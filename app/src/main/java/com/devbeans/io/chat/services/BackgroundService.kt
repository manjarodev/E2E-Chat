package com.devbeans.io.chat.services

import android.app.*
import android.app.ActivityManager.RunningAppProcessInfo
import android.content.*
import android.content.pm.PackageInstaller.SessionParams
import android.os.Build
import android.os.Handler
import android.os.IBinder
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.CustomSplashActivity
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.activities.MainActivity.Companion.runService
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.network.mqtt.Connection
import com.devbeans.io.chat.network.mqtt.EmqxHelper
import com.devbeans.io.chat.network.mqtt.Subscription
import com.devbeans.io.chat.receiver.ExpiryReceiver
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.websocket.WebSocketConnectionState
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttException
import java.io.*
import java.util.*
import java.util.concurrent.TimeUnit


class BackgroundService : Service() {

    private val mTimer: Timer? = null
    private val mBurnOnRead: Timer? = null
    private var mSenderTask: Timer? = null
    private var mReceiver: Timer? = null
    private val mSenderViewOnce: Timer? = null
    private val mReceiverViewOnce: Timer? = null
    private var mDownloaderOneToOneTask: Timer? = null
    private var mDownloaderGroupTask: Timer? = null
    private var mDownloaderAnonymousTask: Timer? = null
    private val REQUEST_WEBSOCKET_STAY_OPEN_DELAY = TimeUnit.SECONDS.toMillis(30)
    private val webSocketKeepAliveTask: WebSocketKeepAliveTask = WebSocketKeepAliveTask()
    val webSocketStateCheckListener: WebSocketStateCheckTask = WebSocketStateCheckTask()
    val expiryReceiver: ExpiryReceiver = ExpiryReceiver()
    var receiverNew: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val path = intent.extras!!.getString("file")
            val file = File(path)
            if (file.exists()) {
                file.delete()
            }
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO Auto-generated method stub
        return null
    }

    override fun onCreate() {
        isRunning = true
        context = this

        val notificationIntent = Intent(this, CustomSplashActivity::class.java)
        val pendingIntent: PendingIntent
        pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getActivity(
                this, 0,
                notificationIntent, PendingIntent.FLAG_IMMUTABLE
            )
        } else {
            PendingIntent.getActivity(
                this, 0,
                notificationIntent, 0
            )
        }
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createNotificationChannel(
                notificationManager
            ) else ""
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
        val notification = notificationBuilder.setOngoing(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .build()
        startForeground(101, notification)

        Handler().postDelayed({
            webSocketKeepAliveTask.start()
        }, 1000 * 3)


        //schedule tasks
//        if (mTimer != null) // Cancel if already existed
//            mTimer.cancel();
//        else
//            mTimer = new Timer();   //recreate new
//        mTimer.scheduleAtFixedRate(new TimerClass(), 0, notify);   //Schedule task
////        connectMQTT();

//        if (mBurnOnRead != null) // Cancel if already existed
//            mBurnOnRead.cancel();
//        else
//            mBurnOnRead = new Timer();   //recreate new
//        mBurnOnRead.scheduleAtFixedRate(new BurnOnRead(), 0, notify);   //Schedule task

        //Sender Task
        if (mSenderTask != null) // Cancel if already existed
            mSenderTask!!.cancel() else mSenderTask = Timer() //recreate new
        mSenderTask!!.scheduleAtFixedRate(
            TimerSenderClass(),
            0,
            notifySocket.toLong()
        ) //Schedule task
        if (mReceiver != null) // Cancel if already existed
            mReceiver!!.cancel() else mReceiver = Timer() //recreate new
        mReceiver!!.scheduleAtFixedRate(TimerReceiveClass(), 0, notify.toLong()) //Schedule task


        //Sender View Once
//        if (mSenderViewOnce != null) // Cancel if already existed
//            mSenderViewOnce.cancel();
//        else
//            mSenderViewOnce = new Timer();   //recreate new
//        mSenderViewOnce.scheduleAtFixedRate(new TimerSenderViewClass(), 0, notify);


        //Sender View Once
//        if (mReceiverViewOnce != null) // Cancel if already existed
//            mReceiverViewOnce.cancel();
//        else
//            mReceiverViewOnce = new Timer();   //recreate new
//        mReceiverViewOnce.scheduleAtFixedRate(new TimerReceiverViewClass(), 0, notify);
        if (mDownloaderOneToOneTask != null) // Cancel if already existed
            mDownloaderOneToOneTask!!.cancel() else mDownloaderOneToOneTask = Timer() //recreate new
        mDownloaderOneToOneTask!!.scheduleAtFixedRate(
            TimerDownloaderOneToOne(),
            0,
            notifyDownload.toLong()
        )
        if (mDownloaderGroupTask != null) // Cancel if already existed
            mDownloaderGroupTask!!.cancel() else mDownloaderGroupTask = Timer() //recreate new
        mDownloaderGroupTask!!.scheduleAtFixedRate(
            TimerDownloaderGroup(),
            0,
            notifyDownload.toLong()
        )
        if (mDownloaderAnonymousTask != null) // Cancel if already existed
            mDownloaderAnonymousTask!!.cancel() else mDownloaderAnonymousTask =
            Timer() //recreate new
        mDownloaderAnonymousTask!!.scheduleAtFixedRate(
            TimerDownloaderAnonymous(),
            0,
            notifyDownload.toLong()
        )
        val filter = IntentFilter("com.devbeans.packageintsalled")
        //        BroadcastReceiver receiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                String path = intent.getExtras().getString("file");
//                File file = new File(path);
//                if (file.exists()) {
//                    file.delete();
//                }
//            }
//        };
        registerReceiver(receiverNew, filter)
        try {
            setupReceivers()
        } catch (e: Exception) {
            Log.e(TAG, "Error setting up receivers")
        }


        //MQTT connection

        checkConnectMqtt()
        //register receiver to destroy chat app
    }


    /**
     * Setting up our local receivers essential for in application actions
     */
    private fun setupReceivers() {
        val chatFilter = IntentFilter("com.dev.io.mdm.license")
        registerReceiver(expiryReceiver, chatFilter)
    }


    @Throws(MqttException::class, Exception::class)
    private fun connectMQTT() {

//        try {
//            val pass = AppSession.getMQTTPass()
//            if (pass != null && pass.isNotEmpty() &&  && !SettingsValues.getSubscriptionEndSet()) {
//                val connection = Connection(
//                    appContext,
//                    AndroidUtil.getString(R.string.MQTT_BROKER),
//                    appContext?.resources!!.getInteger(R.integer.mqqt_port),
//                    AppSession.getUser().chatUserId,
//                    AppSession.getUser().chatUserId,
//                    pass,
//                    true
//                )
//
//                val emqx = EmqxHelper.with(appContext)
//
//                try {
//                    initConnection(emqx, connection)
//                } catch (e: Exception) {
//                    Log.e(TAG, "${e.printStackTrace()}")
//                }
//
//                if (timerConnect == null) {
//                    timerConnect = Timer()
//
//                    timerConnect?.schedule(object : TimerTask() {
//                        override fun run() {
//                            if (emqx.client == null || !emqx.client.isConnected) {
//                                try {
//
//                                    emqx.connect(connection, object : IMqttActionListener {
//                                        override fun onSuccess(asyncActionToken: IMqttToken) {
//                                            Log.d(
//                                                TAG,
//                                                "onSuccessConnected: " + asyncActionToken.getClient()
//                                                    .getServerURI()
//                                            );
//                                            initConnection(emqx, connection)
//                                        }
//
//                                        override fun onFailure(
//                                            asyncActionToken: IMqttToken,
//                                            exception: Throwable
//                                        ) {
//                                            Log.e(
//                                                TAG,
//                                                "Exception in connecting to MQTT Error message ${exception.message}"
//                                            )
//                                            exception.printStackTrace()
//                                        }
//                                    })
//                                } catch (e: Exception) {
//                                    Log.e(TAG, "${e.printStackTrace()}")
//                                }
//                            } else {
//                                timerConnect?.cancel()
//                                timerConnect = null
//                            }
//                        }
//                    }, 0, 2000)
//                }
//            } else {
//                Log.e(TAG, "MQTT pass null")
//            }
//        } catch (e: MqttException) {
//            timerConnect = null
//            Log.e(
//                TAG,
//                "MQTT Exception at MQTT connect Error Message ${e.message}\n ExceptionStack Trace: ${e.printStackTrace()}  "
//            )
//        } catch (e: SecurityException) {
//            timerConnect = null
//            Log.e(
//                TAG,
//                "SecurityException at MQTT connect Error Message ${e.message}\n ExceptionStack Trace: ${e.printStackTrace()}  "
//            )
//        } catch (e: Exception) {
//            timerConnect = null
//            Log.e(
//                TAG,
//                "Exception at MQTT connect Error Message ${e.message}\n ExceptionStack Trace: ${e.printStackTrace()}  "
//            )
//        }


    }


    fun isAppOnForeground(context: Context): Boolean {
        val activityManager = ServiceUtil.getActivityManager(context)
        val appProcesses = activityManager.runningAppProcesses ?: return false
        val packageName = context.packageName
        for (appProcess in appProcesses) {
            if (appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName == packageName) {
                return true
            }
        }
        return false
    }


    fun initConnection(emqx: EmqxHelper, connection: Connection) {
        if (emqx.client != null && emqx.client.isConnected && !SettingsValues.getSubscriptionEndSet()) {

            //subscribe to client
            emqx.subscribe(
                Subscription(AppSession.getUser().chatUserId, 0),
                object : IMqttActionListener {
                    override fun onSuccess(asyncActionToken: IMqttToken) {
                        Log.d(
                            TAG,
                            "onSuccessSubscribe: " + asyncActionToken.getClient()
                                .getServerURI()
                        );
                    }

                    override fun onFailure(
                        asyncActionToken: IMqttToken,
                        exception: Throwable
                    ) {
                        exception.printStackTrace()
                    }
                })


        } else {
        }

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onDestroy() {
        isRunning = false
        timerConnect = null
        try {
            unRegisterReceivers()
        } catch (exception: java.lang.Exception) {
            exception.printStackTrace()
        }

        stopSelf()
        try {
            unregisterReceiver(receiverNew)
        } catch (exception: Exception) {
            Log.e("TAG", "onDestroy: ", exception)
        }
        super.onDestroy()
    }

    private fun unRegisterReceivers() {
        unregisterReceiver(expiryReceiver)
    }

    /**
     * Periodically request the web socket stay open if we are doing anything call related.
     */
    private inner class WebSocketKeepAliveTask : Runnable {
        private var keepRunning = false

        @MainThread
        fun start() {
            if (!keepRunning) {
                keepRunning = true
                run()
            }
        }

        @MainThread
        fun stop() {
            keepRunning = false
            ThreadUtil.cancelRunnableOnMain(webSocketKeepAliveTask)
        }

        @MainThread
        override fun run() {
//            Log.e(TAG, "Change Listener")
            if (keepRunning) {
//                Log.e(TAG, "Change Listener in run")
                if (MainActivity.isSocketConnected.value!!) {
                    MainActivity.chatWebSocket?.state = WebSocketConnectionState.CONNECTED
                    webSocketStateCheckListener.start()
                    Utills.sendPing()
                } else {
                    if (Utills.isNetworkAvailable()) {
                        MainActivity.instance?.reInitiateSocketConnection("Background service")
                    }
                }
                ThreadUtil.runOnMainDelayed(
                    this,
                    REQUEST_WEBSOCKET_STAY_OPEN_DELAY
                )
            }
        }
    }

    /**
     * Periodically request the web socket stay open if we are doing anything call related.
     */
    inner class WebSocketStateCheckTask : Runnable {
        private var keepRunning = false

        @MainThread
        fun start() {
//            Log.e(TAG, "State change in start")
            if (!keepRunning) {
                keepRunning = true
                ThreadUtil.runOnMainDelayed(
                    this,
                    REQUEST_WEBSOCKET_STAY_OPEN_DELAY
                )
            } else {
//                Log.e(TAG, "false State change in start")
            }
        }

        @MainThread
        fun stop() {
            keepRunning = false
            ThreadUtil.cancelRunnableOnMain(webSocketStateCheckListener)
//            Log.e(TAG, "State change in stop")
        }

        @MainThread
        override fun run() {
//            Log.e(TAG, "State change run")
            if (keepRunning) {
//                Log.e(TAG, "State change in run")
                MainActivity.chatWebSocket?.state = WebSocketConnectionState.FAILED
                try {
                    ThreadUtil.runOnMain {
                        MainActivity.isSocketConnected.postValue(false)
                        if (Utills.isNetworkAvailable()) {
                            MainActivity.instance?.reInitiateSocketConnection("Background sercvice")
                            Utills.sendOfflineMessages()
                        }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Got Exception in pong state $e")
                }
                stop()
            }
        }
    }

    companion object {
        val TAG = BackgroundService::class.java.simpleName
        var context: BackgroundService? = null
        const val notify = 1000 //Here Service run every 1 Seconds
        const val notifySocket = 4000 //Here Service run every 1 Seconds
        const val notifyDownload = 2 * 1000 //Here Service run every 1 Seconds
        var isRunning = false
        private var timerConnect: Timer? = null

        fun checkConnectMqtt() {
//            if (AppSession.getUser() != null && AppSession.getUser().chatUserId != null && !SettingsValues.getSubscriptionEndSet()) {
//                try {
//                    val hsm = HSM.with()
//                    val pass = "hsm.storeMQTTKey"
//
//                    val emqx = EmqxHelper.with(appContext)
//
//                    if (emqx.client == null || !emqx.client.isConnected) {
//                        context?.connectMQTT()
//                    } else {
////                        Log.e(TAG, "MQTT already Connected")
//                    }
//                } catch (e: MqttException) {
//                    Log.e(
//                        TAG,
//                        "MQTT Exception at MQTT connect Error Message ${e.message}\n ExceptionStack Trace: ${e.printStackTrace()}  "
//                    )
//                } catch (e: Exception) {
//                    Log.e(
//                        TAG,
//                        "Exception at MQTT connect Error Message ${e.message}\n ExceptionStack Trace: ${e.printStackTrace()}  "
//                    )
//                }
//
//            }
        }

        fun checkDisconnectMqtt() {
            if (AppSession.getUser() != null && AppSession.getUser().chatUserId != null && !SettingsValues.getSubscriptionEndSet()) {
                try {
                    val hsm = HSM.with()
                    val connection = Connection(
                        appContext,
                        Configurations.mqttBroker,
                        Configurations.mqttPort,
                        AppSession.getUser().chatUserId,
                        AppSession.getUser().chatUserId,
                        AppSession.getMQTTPass(),
                        true
                    )

                    val emqx = EmqxHelper.with(appContext)

                    if (emqx.client != null || !emqx.client.isConnected) {
                        emqx.disconnect()
                    } else {
                        Log.e(TAG, "MQTT already Connected")
                    }
                } catch (e: MqttException) {
                    Log.e(
                        TAG,
                        "MQTT Exception at MQTT connect Error Message ${e.message}\n ExceptionStack Trace: ${e.printStackTrace()}  "
                    )
                } catch (e: Exception) {
                    Log.e(
                        TAG,
                        "Exception at MQTT connect Error Message ${e.message}\n ExceptionStack Trace: ${e.printStackTrace()}  "
                    )
                }

            }
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        fun createNotificationChannel(notificationManager: NotificationManager): String {
            val channelId = "my_service_channelid"
            val channelName = "My Foreground Service"
            val channel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            // omitted the LED color
            channel.importance = NotificationManager.IMPORTANCE_NONE
            channel.lockscreenVisibility = Notification.VISIBILITY_SECRET
            notificationManager.createNotificationChannel(channel)
            return channelId
        }

        fun stop() {
            if (isRunning) {
//            MQTTServiceCommand.disconnect(context);
                context!!.stopService(Intent(appContext, BackgroundService::class.java))
            }
        }

        fun restart() {
            if (isRunning) {
                appContext!!.stopService(Intent(appContext, BackgroundService::class.java))
            }
            Handler().postDelayed({ runService() }, 3000)
        }

        fun installPackage(file: File) {
            try {
                val inputStream: InputStream = FileInputStream(file)
                val packageInstaller = context!!.packageManager.packageInstaller
                var sessionId = 0
                sessionId =
                    packageInstaller.createSession(SessionParams(SessionParams.MODE_FULL_INSTALL))


                //openSession checks for user restrictions
//        clearMyRestrictions(context);
                val session = packageInstaller.openSession(sessionId)
                val sizeBytes: Long = 0
                var out: OutputStream? = null
                out = session.openWrite("COSU", 0, 0)
                var total = 0
                val buffer = ByteArray(65536)
                var c: Int
                while (inputStream.read(buffer).also { c = it } != -1) {
                    total += c
                    out.write(buffer, 0, c)
                }
                session.fsync(out)
                inputStream.close()
                out.close()
                val intent = Intent("com.devbeans.packageintsalled")
                intent.putExtra("file", file.absolutePath)
                context!!.sendBroadcast(intent)
                // fake intent
                val statusReceiver: IntentSender? = null
                val intent1 = Intent(appContext, MainActivity::class.java)
                val pendingIntent = PendingIntent.getBroadcast(
                    appContext,
                    1337111117, intent1, PendingIntent.FLAG_UPDATE_CURRENT
                )
                session.commit(pendingIntent.intentSender)
                session.close()
            } catch (e: IOException) {
                e.printStackTrace()
                Log.d("installPackage", e.message)
            }
        }
    }
}