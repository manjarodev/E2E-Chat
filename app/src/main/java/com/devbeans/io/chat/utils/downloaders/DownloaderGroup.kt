package com.devbeans.io.chat.utils.downloaders

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.DownloadMedia
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.network.Network
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.EncryptionUtils
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import com.tonyodev.fetch2.*
import com.tonyodev.fetch2core.DownloadBlock
import com.tonyodev.fetch2okhttp.OkHttpDownloader
import kotlinx.coroutines.*
import java.io.File
import kotlin.system.measureTimeMillis

class DownloaderGroup : FetchListener {
    private var listDownloading = mutableListOf<DownloadMedia>()
    var fileMutableLiveData = MutableLiveData<File>()
    var isImage = false
    var payload: Payload? = null
    var hashMap: HashMap<Int, Payload> = HashMap<Int, Payload>()
    private fun initialize() {
        val fetchConfiguration: FetchConfiguration =
            FetchConfiguration.Builder(MainApp.appContext!!)
                .setNamespace("GroupChat")
                .setAutoRetryMaxAttempts(10)
                .enableLogging(true)
                .enableAutoStart(true)
                .enableRetryOnNetworkGain(true)
                .setDownloadConcurrentLimit(1)
                .setHttpDownloader(OkHttpDownloader(Network.getUnsafeOkHttpClient()))
                .build()

        fetch = Fetch.getInstance(fetchConfiguration)
        fetch!!.addListener(this)
    }


    fun download(path: String?, url: String?, payload: Payload?) {
        if (path != null && url != null && payload != null && payload.data != null && Utills.isNetworkAvailable() && !Utills.isSubscriptionExpired()) {
            val file = File(path!!)
            if (file.exists()) file.delete()
            val request = Request(url!!, path)
            Log.e(TAG, "Url which is being downloaded $url")
            request.priority = Priority.HIGH
            request.networkType = NetworkType.ALL
            this.payload = payload
            fetch!!.enqueue(
                request,
                { }) { error: Error? -> Notify.Toast("fail req $error") }
            listDownloading.add(
                DownloadMedia(
                    path = path,
                    url = url,
                    payload = payload
                )
            )
        } else {
            payload?.let {
                MainApp.appContext?.messagesDao?.updateMessageDownloading(payload.messageId, false)
            }
        }

    }

    fun clearDownloadingData() {
        if (Utills.isSubscriptionExpired()) {
            listDownloading.clear()
            hashMap.clear()
            DownloaderOneToOne.fetch?.cancelAll()
            DownloaderOneToOne.fetch?.deleteAll()

        }
    }

    fun downloadAll(listDownloadingMedia: MutableList<DownloadMedia>) {
        val requestList = mutableListOf<Request>()
        listDownloadingMedia.forEach {
            val file = File(it.path)
            if (file.exists()) file.delete()
            val request = Request(it.url, it.path)
            request.priority = Priority.HIGH
            request.networkType = NetworkType.ALL
            requestList.add(request)
            Log.e(TAG, "Url which is being downloaded ${it.url}")
        }

        if (listDownloadingMedia.isEmpty())
            this.listDownloading = listDownloadingMedia
        else {
            this.listDownloading.addAll(listDownloadingMedia)
        }

        fetch!!.enqueue(requestList)



    }

    override fun onAdded(download: Download) {

        val media = listDownloading.find {
            it.url == download.url
        }

        hashMap[download.id] = media?.payload!!

    }

    override fun onCancelled(download: Download) {
        Notify.Toast("cancelled downloading")
    }

    @DelicateCoroutinesApi
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCompleted(download: Download) {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.e(TAG, "CoroutineExceptionHandler got $exception")
        }
        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler)
        {

            launch {
                val name = download.file
                val file = File(download.file)
                try {

                    hashMap[download.id]?.let {

                        val aVRatchetKeyMaterial = hashMap[download.id]!!.aVRatchetKeyMaterial!!
                        Log.e(TAG, "File Downloaded ")
                        val ivByte = Constants.NONCE
                        val gson = Gson()
                        var isDecrypted = false
                        val time = measureTimeMillis {
                            isDecrypted =
                                EncryptionUtils.decryptFile(file.path, aVRatchetKeyMaterial)
                        }
                        Log.e("Time", "Time after file decrypt $time")

                        if (isDecrypted) {
                            fileMutableLiveData.postValue(file)
                            MainApp.appContext?.messagesDao
                                ?.updateMessageDownloading(hashMap[download.id]?.messageId, false)
                            hashMap.remove(download.id)
                            listDownloading.removeIf {
                                download.url == it.url
                            }
                            handleOtherDownload(file)

                        } else {
                            Log.e(TAG, "File did not decrypted")
                        }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, e.message)
                    e.printStackTrace()
                }
            }
        }
    }

    private fun handleOtherDownload(file: File) {
        val downloading = AppSession.getDownloadingFiles()
        val newList: MutableList<Messages> = ArrayList()
        if (!downloading.isNullOrEmpty()) {
            for (messages in downloading) {
                if (!messages.filePath.equals(
                        file.absolutePath,
                        ignoreCase = true
                    )
                ) {
                    newList.add(messages)
                }
            }
            if (newList.isNotEmpty()) {
                AppSession.saveDownloadingFiles(newList)
            }
        }
    }

    override fun onDeleted(download: Download) {
        //is used for over ride
    }
    override fun onDownloadBlockUpdated(download: Download, downloadBlock: DownloadBlock, i: Int) {
        //is used for over ride
    }
    override fun onPaused(download: Download) {
        //is used for over ride
    }
    override fun onProgress(download: Download, l: Long, l1: Long) {
        //is used for over ride
    }
    override fun onQueued(download: Download, b: Boolean) {
        //is used for over ride
    }
    override fun onRemoved(download: Download) {
        //is used for over ride
    }
    override fun onResumed(download: Download) {
        //is used for over ride
    }
    override fun onStarted(download: Download, list: List<DownloadBlock>, i: Int) {
        //is used for over ride
    }
    override fun onWaitingNetwork(download: Download) {
        //is used for over ride
    }
    override fun onError(
        download: Download,
        error: Error,
        throwable: Throwable?
    ) {
        val file = File(download.file)
        if (file.exists()) {
            file.delete()
        }
    }

    companion object {
        private const val TAG = "DownloaderOneToOne"
        var fetch: Fetch? = null
        var downloader: DownloaderGroup? = null

        @get:Synchronized
        val instance: DownloaderGroup?
            get() {
                if (downloader == null) {
                    downloader = DownloaderGroup()
                }
                return downloader
            }
    }

    init {
        initialize()
    }


}