package com.devbeans.io.chat.app

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.*
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.dependencies.ApplicationDependencies
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.CreatePinActivity
import com.devbeans.io.chat.verifypin.PinDialog
import com.devbeans.io.chat.websocket.WebSocketConnectionState
import com.devbeans.io.chat.websocket.WebSocketStateChangeListener
import com.devbeans.io.chat.worker.DisappearWorker
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.goterl.lazysodium.LazySodiumAndroid
import com.goterl.lazysodium.SodiumAndroid
import com.goterl.lazysodium.interfaces.Box
import com.snatik.storage.Storage
import com.vanniktech.emoji.EmojiManager
import com.vanniktech.emoji.ios.IosEmojiProvider
import java.io.File
import java.util.concurrent.TimeUnit

class MainApp : Application(), AppForegroundObserver.Listener, LifecycleObserver {


    var isAppInForground: Boolean = false


    //    public
    var currentActivity: Activity? = null
    var expiryListener: ExpiryCallback? = null
    var webSocketStateChangeListener: WebSocketStateChangeListener? = null
    var INSTANCE: MainApp? = null
    fun getAppContext(): MainApp? {
        return INSTANCE
    }


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate() {


        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        appContext = this
        INSTANCE = this
        database = AppDatabase.getAppDatabase(this@MainApp)
        ls = LazySodiumAndroid(SodiumAndroid())
        box = ls
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        EmojiManager.install(IosEmojiProvider())
        AndroidUtil.setContext(applicationContext)
//        regiterActivityCallback()

        AppStartup.getInstance()
            .addBlocking("API-init", this::initAPIs)
            .addBlocking("mediaRoutes", this::setupMediaRoutes)
            .addBlocking("createDirectories", this::createDirectories)
            .addBlocking("appForegroundObserver", this::appForegroundObserver)
            .addBlocking("initializeWorker", this::initializeWorker)
            .addBlocking(
                "initializeRevealableMessageManager",
                this::initializeRevealableMessageManager
            )
            .addPostRender(this::initializeExpiringMessageManager)
            .execute()


    }


    fun initializeRevealableMessageManager() {
        ApplicationDependencies.getViewOnceMessageManager().scheduleIfNecessary()
    }

    fun scheduleNextRevealableMessageManager(TAG: String) {
        Log.e(MainApp.TAG, "From $TAG")
        ApplicationDependencies.getViewOnceMessageManager().setNextClosestEvent()
    }

    private fun configurePR(context: Context) {
        val config = PRDownloaderConfig.newBuilder()
            .setDatabaseEnabled(true)
            .build()
        PRDownloader.initialize(context, config)
    }

    fun setSocketChangeListener(webSocketStateChangeListener: WebSocketStateChangeListener) {
        this.webSocketStateChangeListener = webSocketStateChangeListener
    }

    fun notifySocketStateChange(state: WebSocketConnectionState) {
        webSocketStateChangeListener?.onStateChange(state)
    }

    private fun initializeWorker() {
        val keepChatWorker = PeriodicWorkRequest.Builder(
            DisappearWorker::class.java, 15, TimeUnit.MINUTES
        ).build()
        WorkManager.getInstance(appContext!!)
            .enqueueUniquePeriodicWork(
                "keepChat",
                ExistingPeriodicWorkPolicy.REPLACE,
                keepChatWorker
            )
    }

    private fun appForegroundObserver() {
        if (appForegroundObserver == null) {
            appForegroundObserver = AppForegroundObserver()
        }
        appForegroundObserver!!.addListener(this@MainApp)
        appForegroundObserver!!.begin()
    }

    private fun initializeExpiringMessageManager() {
        ApplicationDependencies.getExpiringMessageManager().checkSchedule()
    }

    @VisibleForTesting
    fun initializeAppDependencies() {
        ApplicationDependencies.init(appContext!!)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        //App in background
        isAppInForground = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        //App in foreground
        isAppInForground = true
    }

    private fun setupMediaRoutes() {
        val internalStorage: String = appContext!!.filesDir.absolutePath
        rootPath = "$internalStorage/chat"
        imagesPath = rootPath.toString() + "/images"
        imagesPathSent = imagesPath.toString() + "/Sent"
        imagesPathConv = imagesPath.toString() + "/Conversations"
        imagesPathReceive = imagesPath.toString() + "/Receive"
        imagesPathCaptured = imagesPath.toString() + "/Capture"

        audioPath = rootPath.toString() + "/audio"
        audioPathSent = audioPath.toString() + "/Sent"
        audioPathReceive = audioPath.toString() + "/Receive"

        videoPath = rootPath.toString() + "/video"
        videoPathSent = videoPath.toString() + "/Sent"
        videoPathReceive = videoPath.toString() + "/Receive"
        videoPathCaptured = videoPath.toString() + "/Capture"

        filesPath = rootPath.toString() + "/files"
        filesPathSent = filesPath.toString() + "/Sent"
        filesPathReceive = filesPath.toString() + "/Receive"

        cachePath = rootPath.toString() + "/cache"

    }

    private fun createDirectories() {
        val files: Array<File> = arrayOf<File>(
            File(rootPath!!),
            File(imagesPath!!),
            File(audioPath!!),
            File(videoPath!!),
            File(filesPath!!),
            File(cachePath!!),
            File(imagesPathSent!!),
            File(imagesPathReceive!!),
            File(imagesPathCaptured!!),
            File(imagesPathConv!!),
            File(audioPathSent!!),
            File(audioPathReceive!!),
            File(videoPathSent!!),
            File(videoPathReceive!!),
            File(videoPathCaptured!!),
            File(filesPathSent!!),
            File(filesPathReceive!!)
        )
        for (file in files) {
            if (!file.exists()) {
                file.mkdir()
            }
        }
    }

    private fun regiterActivityCallback() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                p0.window.setFlags(
                    WindowManager.LayoutParams.FLAG_SECURE,
                    WindowManager.LayoutParams.FLAG_SECURE
                )

            }

            override fun onActivityStarted(p0: Activity) {

                // was essential to over ride

            }

            override fun onActivityResumed(p0: Activity) {

                // was essential to over ride

            }

            override fun onActivityPaused(p0: Activity) {

                // was essential to over ride

            }

            override fun onActivityStopped(p0: Activity) {

                // was essential to over ride

            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {

                // was essential to over ride

            }

            override fun onActivityDestroyed(p0: Activity) {

                // was essential to over ride

            }

        })
    }


    private fun initAPIs() {
        AndroidUtil.setContext(applicationContext)
        storage = Storage(applicationContext)
        session = AppSession.with()
        pinDialog = PinDialog.with()
    }

    fun setNotifyExpiry(expiryCallback: ExpiryCallback) {
        expiryListener = expiryCallback
    }


    fun notifyViewExpiry() {
        expiryListener?.notifyExpiry()
    }

    companion object {
        val TAG = MainApp::class.java.simpleName

        @SuppressLint("StaticFieldLeak")
        var appContext: MainApp? = null

        @JvmField
        var database: AppDatabase? = null
        var appForegroundObserver: AppForegroundObserver? = null
        val LOCK = Any()
        var isServiceRunning = false

        @SuppressLint("StaticFieldLeak")
        var exoPlayerPool: SimpleExoPlayerPool? = null

        fun resetApplication(clas: Class<*>?) {
            val intent = Intent(appContext, clas)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            appContext!!.startActivity(intent)
        }

        fun resetApplication() {
//        Intent intent = new Intent(MainApp.Companion.getAppContext(), MainActivity.class);
            SettingsValues.onFirstEverAppLaunch()
//            initiateWorker();
            appContext?.initializeAppDependencies()
            val intent = Intent(appContext, CreatePinActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("syncUp", true)

            appContext!!.startActivity(intent)
        }

//        private fun initiateWorker() {
//            val keepChatWorker = PeriodicWorkRequest.Builder(
//                DisappearWorker::class.java, 15, TimeUnit.MINUTES
//            ).build()
//            WorkManager.getInstance(appContext!!)
//                .enqueueUniquePeriodicWork(
//                    "keepChat",
//                    ExistingPeriodicWorkPolicy.REPLACE,
//                    keepChatWorker
//                )
//        }

        @JvmName("getAppForegroundObserver1")
        fun getAppForegroundObserver(): AppForegroundObserver {
            return appForegroundObserver!!
        }

        @JvmName("getExoPlayerPool1")
        fun getExoPlayerPool(): SimpleExoPlayerPool {
            if (exoPlayerPool == null) {
                exoPlayerPool = SimpleExoPlayerPool(appContext!!)
            }
            return exoPlayerPool as SimpleExoPlayerPool
        }

        var imagesPath: String? = null
        var audioPath: String? = null
        var videoPath: String? = null
        var filesPath: String? = null
        var cachePath: String? = null
        var trimmerPath: String? = null

        var imagesPathSent: String? = null
        var imagesPathReceive: String? = null
        var imagesPathConv: String? = null
        var imagesPathCaptured: String? = null
        var audioPathSent: String? = null
        var audioPathReceive: String? = null
        var videoPathSent: String? = null
        var videoPathReceive: String? = null
        var videoPathCaptured: String? = null
        var filesPathSent: String? = null
        var filesPathReceive: String? = null
        var confPath: String? = null
        var rootPath: String? = null
        var storage: Storage? = null
        lateinit var session: AppSession
        lateinit var pinDialog: PinDialog
        lateinit var ls: LazySodiumAndroid
        lateinit var box: Box.Lazy

        var stopwatchOverAll: Stopwatch? = null
    }
}