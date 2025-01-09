package com.devbeans.io.chat.utils

import androidx.lifecycle.MutableLiveData
import com.devbeans.io.chat.activities.ChatActivity
import com.devbeans.io.chat.activities.ChatDetailsActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.extensions.conversationsDao
import com.devbeans.io.chat.models.DownloadMedia
import com.devbeans.io.chat.network.Network
import com.devbeans.io.chat.utils.Utills.isNetworkAvailable
import com.devbeans.io.chat.utils.Utills.isSubscriptionExpired
import com.devbeans.io.chat.utils.logging.Log
import com.downloader.*
import com.downloader.Error
import com.downloader.Priority
import com.tonyodev.fetch2.*
import com.tonyodev.fetch2.Fetch.Impl.getInstance
import com.tonyodev.fetch2core.DownloadBlock
import com.tonyodev.fetch2okhttp.OkHttpDownloader
import java.io.File

class DownloaderImage : FetchListener {
    var isImage = false
    private var file: File? = null
    private var listDownloading = mutableListOf<DownloadMedia>()

    init {
        initialize()
    }

    private fun initialize() {

        val fetchConfiguration: FetchConfiguration = FetchConfiguration.Builder(appContext!!)
            .setAutoRetryMaxAttempts(10)
            .setNamespace("ImageDownloader")
            .enableLogging(true)
            .enableAutoStart(true)
            .enableRetryOnNetworkGain(true)
            .setDownloadConcurrentLimit(10)
            .setHttpDownloader(OkHttpDownloader(Network.getUnsafeOkHttpClient()))
            .build()
        fetch = getInstance(fetchConfiguration)
        fetch!!.addListener(this)
    }

    fun downloadImage(mediaName: String, url: String?, path: String?, convID: String?) {
        if (isNetworkAvailable()) {
            val downloadFile = File(path)

//            AppDownloader.with().download(mediaName, downloadFile.getAbsolutePath(), "http://192.168.102.19:3004/media?device_id=1384974004&file_name=Labour 2022-05-15 16-57-51.png");
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
//                                progressDialog.dismiss();
                        val downloadedFilePath = "$downloadFile/$mediaName"
                        Log.e(TAG, "onDownloadComplete: $downloadedFilePath")
                        val obj = File(downloadedFilePath)
                        //                            fileMutableLiveData.postValue(obj);
                        MainApp.database!!.conversationsDao()!!
                            .updateFilePath(convID, downloadedFilePath)
                        var hash = ""
                        try {
//                                hash = HashUtil.getHash(obj);
                        } catch (e: Exception) {
                            hash = ""
                        }


//                            BaseActivity.dbViewModel.insertBackup(backupModel);


//                                MainApp.appDB.backupDao().insertBackup(backupModel);
//                                HomeViewModel.with(MainApp.getActivity()).fetchMediaList();
                    }

                    override fun onError(error: Error) {}
                })
            val status = PRDownloader.getStatus(downloadId)

//            Log.e(TAG, "downloadBackup: " + status.toString() + " " + mediaName);
//            if (status.equals(Status.QUEUED))
//                PRDownloader.resume(downloadId);
        }
    }

    fun clearDownloadingData() {
        if (isSubscriptionExpired()) {
            if (fetch != null) {
                fetch!!.cancelAll()
                fetch!!.deleteAll()
            }
        }
    }

    fun download(path: String?, url: String, conversationId: String, photo: String) {
        if (isNetworkAvailable() && !isSubscriptionExpired()) {
            val file = File(path)
            if (file.exists()) file.delete()
            val request = Request(url, path!!)
            request.priority = com.tonyodev.fetch2.Priority.HIGH
            request.networkType = NetworkType.ALL
            Log.e(TAG, "download:: $url")
            listDownloading.add(
                DownloadMedia(
                    path = path,
                    url = url,
                    conversationId = conversationId,
                    name = photo
                )
            )


            //                    request.addHeader("clientKey", "SD78DF93_3947&MVNGHE1WONG")
            fetch!!.enqueue(
                request,
                { updatedRequest: Request? -> }) { error: com.tonyodev.fetch2.Error? ->
                Notify.Toast(
                    "fail req"
                )
            }
        }
    }

    fun downloadImage(path: String?, url: String?, isImage: Boolean) {
        val file = File(path)
        if (file.exists()) file.delete()
        val request = Request(url!!, path!!)
        request.priority = com.tonyodev.fetch2.Priority.HIGH
        request.networkType = NetworkType.ALL
        //                    request.addHeader("clientKey", "SD78DF93_3947&MVNGHE1WONG")
        fetch!!.enqueue(
            request,
            { updatedRequest: Request? -> }) { error: com.tonyodev.fetch2.Error? -> Notify.Toast("fail req") }
    }

    override fun onAdded(download: Download) {
        Log.e(TAG, "onAdded")
    }

    override fun onCancelled(download: Download) {
        Notify.Toast("cancelled downloading")
    }

    override fun onCompleted(download: Download) {
        try {
            val media = listDownloading.find {
                it.path == download.file
            }

            val conversationDao = appContext?.conversationsDao;
            conversationDao?.getConversation(media?.conversationId)?.let { conversation ->
                conversationDao.updateFilePath(
                    conversation.conversationId,
                    media?.path
                )
                conversationDao
                    .updateConversationIcon(
                        conversation.conversationId,
                        media?.path,
                        media?.name
                    )

                ChatActivity.getInstance()?.let { chatInstance ->
                    chatInstance.conversation?.let { conversation ->
                        if (conversation.conversationId.equals(media?.conversationId)) {
                            chatInstance.conversation?.conversationPhoto = media?.path
                            chatInstance.initViews()
                        }
                    }
                }


                ChatDetailsActivity.getDetailsInstance()?.let { chatDetailsInstance ->
                    chatDetailsInstance.mConversation?.let { conversation ->
                        if (conversation.conversationId.equals(media?.conversationId)) {
                            chatDetailsInstance.mConversation?.conversationPhoto = media?.path
                            chatDetailsInstance.initViews()
                        }
                    }
                }


            }

            if (media != null) {
                listDownloading.removeIf { listMediaItem ->
                    listMediaItem.path == media.path
                }
            }

        } catch (e: Exception) {
            Log.e(TAG, "Exception in image downloading $e")
        }

    }

    override fun onDeleted(download: Download) {
        Log.e(TAG, "onDeleted")
    }

    override fun onDownloadBlockUpdated(
        download: Download,
        downloadBlock: DownloadBlock,
        i: Int
    ) {
        Log.e(TAG, "onDownloadBlockUpdated")
    }

    override fun onPaused(download: Download) {
        Log.e(TAG, "onPaused")
    }

    override fun onProgress(download: Download, l: Long, l1: Long) {
        Log.e(TAG, "onProgress")
    }

    override fun onQueued(download: Download, b: Boolean) {
        Log.e(TAG, "onQueued  " + download.status)
    }

    override fun onRemoved(download: Download) {
        Log.e(TAG, "onRemoved")
    }

    override fun onResumed(download: Download) {
        Log.e(TAG, "onResumed")
    }

    override fun onStarted(download: Download, list: List<DownloadBlock>, i: Int) {
        Log.e(TAG, "onStarted" + File(download.file).absolutePath)
    }

    override fun onWaitingNetwork(download: Download) {
        Log.e(TAG, "onWaitingNetwork")
    }

    override fun onError(
        download: Download,
        error: com.tonyodev.fetch2.Error,
        throwable: Throwable?
    ) {
        Log.e(TAG, "Error::  ", throwable)
        val file = File(download.file)
        if (file.exists()) {
            file.delete()
        }
    }

    companion object {
        private val TAG = Log.tag(
            DownloaderImage::class.java
        )
        var fetch: Fetch? = null
        private val fileDefault = File(appContext!!.filesDir.path + " /" + "data")
        var fileImageMutableLiveData = MutableLiveData(fileDefault)
        var downloader: DownloaderImage? = null

        @get:Synchronized
        val instance: DownloaderImage?
            get() {
                if (downloader == null) {

                    downloader = DownloaderImage()
                }
                return downloader
            }
    }
}