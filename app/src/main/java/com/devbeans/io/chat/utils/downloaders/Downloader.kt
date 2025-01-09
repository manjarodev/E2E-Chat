package com.devbeans.io.chat.utils.downloaders

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.models.DownloadMedia
import com.devbeans.io.chat.models.Messages
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.network.Network
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.EncryptionUtils
import com.devbeans.io.chat.utils.Notify
import com.devbeans.io.chat.utils.Utills
import com.devbeans.io.chat.utils.Utills.isNetworkAvailable
import com.devbeans.io.chat.utils.logging.Log
import com.downloader.*
import com.downloader.Error
import com.downloader.Priority
import com.google.gson.Gson
import com.tonyodev.fetch2.*
import com.tonyodev.fetch2.Fetch.Impl.getInstance
import com.tonyodev.fetch2core.DownloadBlock
import com.tonyodev.fetch2okhttp.OkHttpDownloader
import kotlinx.coroutines.*
import java.io.File
import kotlin.system.measureTimeMillis

class Downloader : FetchListener {
    var fileMutableLiveData = MutableLiveData<File>()
    private var listDownloading = mutableListOf<DownloadMedia>()
    var isImage = false
    var payload: Payload? = null
    var hashMap: HashMap<Int, Payload> = HashMap<Int, Payload>()

    private fun initialize() {
        val fetchConfiguration: FetchConfiguration = FetchConfiguration.Builder(appContext!!)
            .setAutoRetryMaxAttempts(10)
            .setNamespace("Downloader")
            .enableLogging(true)
            .enableAutoStart(true)
            .enableRetryOnNetworkGain(true)
            .setDownloadConcurrentLimit(1)
            .setHttpDownloader(OkHttpDownloader(Network.getUnsafeOkHttpClient()))
            .build()


//        FetchConfiguration fetchConfiguration = new FetchConfiguration.Builder(MainApp.Companion.getAppContext())
//                .setDownloadConcurrentLimit(5)
//                .build();
        fetch = getInstance(fetchConfiguration)
        fetch!!.addListener(this)
    }

    fun downloadImage(mediaName: String, url: String?, path: String?, convID: String?) {
        if (isNetworkAvailable()) {
            val downloadFile = File(path)

            val downloadId = PRDownloader.download(
                url,
                downloadFile.path,
                mediaName
            ).setPriority(Priority.HIGH)
                .build()
                .setOnStartOrResumeListener { Log.e(TAG, "onDownloadStartResume: ") }
                .setOnPauseListener { Log.e(TAG, "onDownloadPause: ") }
                .setOnCancelListener { Log.e(TAG, "onDownloadCancel: ") }
                .setOnProgressListener { progress: Progress ->
                    val progressPercent = progress.currentBytes * 100 / progress.totalBytes
                    Log.e(TAG, "onDownloadProgress: $progressPercent")
                }.start(object : OnDownloadListener {
                    override fun onDownloadComplete() {
                        val downloadedFilePath = "$downloadFile/$mediaName"
                        Log.e(TAG, "onDownloadComplete: $downloadedFilePath")
                        val obj = File(downloadedFilePath)
                        MainApp.appContext?.conversationsDao?.updateFilePath(
                            convID,
                            downloadedFilePath
                        )
                        var hash = ""
                        try {
//                                hash = HashUtil.getHash(obj);
                        } catch (e: Exception) {
                            hash = ""
                        }



                    }

                    override fun onError(error: Error) {

                        //is used for over ride

                    }
                })
            val status = PRDownloader.getStatus(downloadId)

        }
    }


    fun download(path: String?, url: String?, payload: Payload?) {
        if (path != null && url != null && payload != null && payload.data != null && isNetworkAvailable() && !Utills.isSubscriptionExpired()) {
            val file = File(path!!)
            if (file.exists()) file.delete()
            val request = Request(url!!, path)
            Log.e(TAG, "Url which is being downloaded $url")
            request.priority = com.tonyodev.fetch2.Priority.HIGH
            request.networkType = NetworkType.ALL
            this.payload = payload
            fetch!!.enqueue(
                request,
                { }) { error: com.tonyodev.fetch2.Error? -> Notify.Toast("fail req $error") }
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

    fun downloadImage(path: String?, url: String?, isImage: Boolean) {
        val file = File(path)
        if (file.exists()) file.delete()
        val request = Request(url!!, path!!)
        request.priority = com.tonyodev.fetch2.Priority.HIGH
        request.networkType = NetworkType.ALL
        fetch!!.enqueue(
            request,
            { }) { Notify.Toast("fail req") }
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCompleted(download: Download) {
        val name = download.file

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
        Log.e(TAG, "in queue")
    }

    override fun onRemoved(download: Download) {
        Log.e(TAG, "onRemoved ")
    }

    override fun onResumed(download: Download) {
        //is used for over ride
    }

    override fun onStarted(download: Download, list: List<DownloadBlock>, i: Int) {
        //is used for over ride
    }

    override fun onWaitingNetwork(download: Download) {
        Log.e(TAG, "onWaitingNetwork ")
    }

    override fun onError(
        download: Download,
        error: com.tonyodev.fetch2.Error,
        throwable: Throwable?
    ) {
        Log.e(TAG, "onError $throwable")
        val file = File(download.file)
        if (file.exists()) {
            Utills.handleFileDelete(TAG, file.delete())
        }
    }

    companion object {
        private const val TAG = "Downloader"
        var fetch: Fetch? = null
        var downloader: Downloader? = null

        @get:Synchronized
        val instance: Downloader?
            get() {
                if (downloader == null) {
                    downloader = Downloader()
                }
                return downloader
            }
    }

    init {
        initialize()
    }
}