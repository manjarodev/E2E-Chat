package com.devbeans.io.chat.activities

import android.Manifest.permission
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.*
import android.os.Build.VERSION
import android.provider.Settings
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.devbeans.io.chat.BuildConfig
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.databinding.ActivitySplashBinding
import com.devbeans.io.chat.models.*
import com.devbeans.io.chat.network.*
import com.devbeans.io.chat.network.mqtt.Connection
import com.devbeans.io.chat.network.mqtt.EmqxHelper
import com.devbeans.io.chat.network.serializers.requestbody.UploadSikRequest
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.RegisterUserResponse
import com.devbeans.io.chat.network.serializers.response.UploadKeysModel
import com.devbeans.io.chat.services.BackgroundService
import com.devbeans.io.chat.services.SavingKeysService
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.CreatePinActivity
import com.devbeans.io.chat.verifypin.LogOutTimerUtil
import com.google.gson.Gson
import io.sentry.android.core.SentryAndroid
import io.sentry.android.core.SentryAndroidOptions
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * Custom Splash Responsible for First ever launch server time check
 */
@SuppressLint("CustomSplashScreen")
class CustomSplashActivity : AppCompatActivity(), OnNetworkResponse {
    private var check: Boolean = false
    private lateinit var public_key: String
    lateinit var splashBinding: ActivitySplashBinding
    private var i = 0
    var isAppInitialized = false

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.e(TAG, "check : $check")
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val mViewContent = findViewById<View>(android.R.id.content)
        INSTANCE = this
        runService()
//        if (AppSession.getUser() == null) {
//            mViewContent.viewTreeObserver.addOnPreDrawListener(
//                object : ViewTreeObserver.OnPreDrawListener {
//                    override fun onPreDraw(): Boolean {
////                        Log.e(TAG, "onPreDraw called")
//                        isAppInitialized = true
//                        return if (isAppInitialized) {
//
//                            mViewContent.viewTreeObserver.removeOnPreDrawListener(this)
////                            initViews()
////                            Constants.ensureBackgroundThread {
////                                proceedData()
////                            }
//
//                            true
//                        } else {
//                            // The content is not ready; suspend.
//                            isAppInitialized = false
//                            false
//                        }
//                    }
//                })
//        } else if (AppSession.getUser() != null && savedInstanceState == null) {
////            initViews()
////            proceedData()
//        }

        check = true
//        Log.e(TAG, "Check ${i++}  instance ${savedInstanceState}")
        val decorView = window.decorView  //set status background black
        decorView.systemUiVisibility =
            decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        SentryAndroid.init(this) { options: SentryAndroidOptions ->
            options.environment = Config.ENVIRONMENT
            options.release = BuildConfig.APPLICATION_ID + "@" + BuildConfig.VERSION_NAME
            options.isAnrReportInDebug = true
        }

        setContentView(splashBinding.root)


    }

    private fun connectMQTT() {
        //MQTT connection

        val connection = Connection(
            appContext,
            "192.168.102.19",
            1883,
            "l52nlvna",
            "ZeeshanSultan",
            "kill3rCert",
            false
        )

        val emqx = EmqxHelper.with(MainApp.appContext)

        val timerConnect = Timer()
        timerConnect.schedule(object : TimerTask() {
            override fun run() {
                if (emqx.client == null || !emqx.client.isConnected) {
                    emqx.connect(connection, object : IMqttActionListener {
                        override fun onSuccess(asyncActionToken: IMqttToken) {
                            Log.d(
                                BackgroundService.TAG,
                                "onSuccessConnected: " + asyncActionToken.getClient().getServerURI()
                            );
                        }

                        override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                            exception.printStackTrace()
                        }
                    })
                } else {
                    timerConnect.cancel()
                }
            }
        }, 0, 2000)
    }

    override fun onStart() {

        super.onStart()
    }


    /**
     * Checking the server time in [proceedData]
     * if the time is not correct the App will always prompt for setting time of device (Android)
     */
    private fun proceedData() {

        val retrofitClient = RetrofitClient.createRetroCLient().create(APIInterface::class.java)
        val dateTimeCheck = retrofitClient.getServerTime()
        dateTimeCheck.enqueue(object : Callback<ServerTime> {
            override fun onResponse(call: Call<ServerTime>, response: Response<ServerTime>) {

                val res = response.body()
                if (res != null && res!!.getCode() == 200) {
                    val time = System.currentTimeMillis() + 300000

                    val serverTime = res.getTime()
                    val inLocalFormate =
                        SimpleDateFormat("HH:mm", Locale.getDefault()).format(serverTime)
                    Log.e("error", time.toString())
                    Log.e("error", inLocalFormate)

                    val date = Date(time)
                    val date2 = Date(serverTime!!)

                    if (date.before(date2)) {
                        val df: DateFormat =
                            SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.getDefault())
                        val datesss: String = df.format(date2)
                        runOnUiThread {
                            splashBinding.controlAdjustTime.visibility = View.VISIBLE
                            splashBinding.textMessage.text = String.format(
                                "%s", "${AndroidUtil.getString(R.string.time_wrong)}\n $datesss"
                            )
                            splashBinding.adjustTimeBtn.setOnClickListener {
                                startActivityForResult(Intent(Settings.ACTION_DATE_SETTINGS), 9878);
                            }
                        }
                    } else {

                        runOnUiThread {
                            splashBinding.controlAdjustTime.visibility = View.GONE
                            callNextProcedure()
                        }
                    }
                } else {
                    Log.e(TAG, "Response was null from KDS")
                }
            }

            override fun onFailure(call: Call<ServerTime>, t: Throwable) {
                t.printStackTrace()
                Log.e(TAG, "${t.message}")
            }

        })
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 9878) {
            Constants.ensureBackgroundThread {
                proceedData()
            }
        }
    }


    /**
     * If the server time is correct [proceedData] this is the next procedure of registering [User] on Chat Server ]
     */
    private fun callNextProcedure() {

        val thr: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(1000)
                } catch (exception: Exception) {
                    exception.printStackTrace()
                } finally {
                    if (AppSession.getUser() != null && AppSession.getUser().chatUserId != null) {
                        runOnUiThread {
                            val intent: Intent
                            if (AppSession.getInt(LogOutTimerUtil.LOGOUT_KEY) == 0) {
                                AppSession.put(LogOutTimerUtil.LOGOUT_KEY, 30000)
                            }
                            if (AppSession.get(CreatePinActivity.KEY_PIN).isEmpty()) {
                                intent =
                                    Intent(this@CustomSplashActivity, CreatePinActivity::class.java)
                            } else {
                                intent = Intent(this@CustomSplashActivity, MainActivity::class.java)
                            }
                            startActivity(intent)
                            finish()
                        }
                    } else {

                        Log.e(TAG, "User was not saved in APP session")
                        registerUser()
                    }
                }
            }
        }
        thr.start()
    }

    override fun onResume() {
        super.onResume()

    }

    private fun initViews() {

        val fadeIn: Animation = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this
        fadeIn.duration = 3000
        val animation = AnimationSet(false) //change to false
        animation.addAnimation(fadeIn)

        splashBinding.linearLayout.visibility = View.GONE
    }

    /**
     * Registering the [User] on chat server
     */
    private fun registerUser() {

        Log.d(
            TAG,
            "registerUser: " + "End Point: " + RequestCodes.API_END_POINTS.REGISTER_DEVICE + " Request: " + "chatNickName=" + " "
        )
        ApiHelper.with()?.registerUser(this)
    }


    private fun generateSik(chatId: String?) {
        val keypairGenerator = KeyPairGenerator()
        val sikCurve = keypairGenerator.generateKeyPairs()
        val ikCurve = keypairGenerator.generateKeyPairs()
        val keyPairGenerator = KeyPairGenerator()
        val sikX = keyPairGenerator.convertCurveToX25519(ikCurve!!)
        uploadSik(chatId, sikCurve!!, sikX!!, ikCurve)
    }

    private fun uploadSik(
        chatId: String?,
        sik: ChatKeyPair,
        sikX: ChatKeyPair,
        ikCurve: ChatKeyPair
    ) {

        val retrofitClient = RetrofitClient.createRetroCLient().create(APIInterface::class.java)
        val sikModel = ManifestModel.SIKClass(
            serverIdentityPubKey = sik.pubKey,
            serverIdentityPubKeyX = sikX.pubKey,
            serverFingerprintPubKey = sik.identifier
        )
        val gson = Gson()
        val request = UploadSikRequest()
        request.chatAppId = chatId
        request.keyObject = sikModel

        val uploadSIK = retrofitClient.uploadSIK(
            request
        )

        try {
            if (!Utills.isSubscriptionExpired()) {
                uploadSIK!!.enqueue(object : Callback<UploadKeysModel?> {
                    override fun onResponse(
                        call: Call<UploadKeysModel?>, response: Response<UploadKeysModel?>
                    ) {
                        if (response.isSuccessful) {

                            Log.e(TAG, "SIK Keys uploaded")
                        } else {
                            Log.e(TAG, "SIK Keys not uploaded")
                        }
                    }

                    override fun onFailure(call: Call<UploadKeysModel?>, t: Throwable) {
                        t.printStackTrace()
                        Log.e(TAG, "SIK Keys not uploaded")
                    }

                })
            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception in SIK uploading ${e.printStackTrace()}")
            runOnUiThread {
                finish()
            }
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        Permissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    companion object {
        val TAG: String = Log.tag(CustomSplashActivity::class.java)

        var INSTANCE: CustomSplashActivity? = null

        @JvmStatic
        val instance: CustomSplashActivity
            get() {
                if (INSTANCE == null) {
                    INSTANCE = CustomSplashActivity()
                }
                return INSTANCE!!
            }

        @JvmStatic
        fun runService() {
            try {
                if (BackgroundService.isRunning) {
                    Log.e(MainActivity.TAG, "Do nothing")
                } else {

                    val service = Intent(MainApp.appContext!!, BackgroundService::class.java)
                    if (service != null) {
                        if (VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            Permissions.with(this@Companion.instance)
                                .request(permission.SCHEDULE_EXACT_ALARM)
                                .ifNecessary()
                                .onAllGranted {
                                    this@Companion.instance?.startForegroundService(service)
                                }
                                .onAnyDenied {
                                    Log.e(TAG, "Permission Denied")
                                }
                                .execute()
                        } else {
                            this@Companion.instance?.startService(service)
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e(MainActivity.TAG, "Exception in starting MQTT")
            }
        }

    }





    /**
     * Will save All keyPair generated in [generateKeyPairs] and
     * saves in [GeneratedPrivateKeyByte] table in Encrypted Database
     */
    @JvmName("saveAllKeys1")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Throws(
        CertificateException::class,
        IOException::class,
        NoSuchAlgorithmException::class,
        KeyStoreException::class
    )
    private fun saveAllKeys(
        allKeys: ArrayList<ChatKeyPair>,
        chat_id: String,
        sik: ChatKeyPair,
        sikX: ChatKeyPair,
        ikCurve: ChatKeyPair
    ) {
        try {
            val keyPairGenerator = KeyPairGenerator()
            val hsm = HSM.with()
            val ik = keyPairGenerator.convertCurveToX25519(ikCurve)
            hsm!!.storeServerIdentityKey(sik)
            hsm.storeX25519ServerIdentityKey(
                sikX
            )
            hsm.storeIdentityKey(ik)

            val intent = Intent(this, SavingKeysService::class.java)
            val gson = Gson()
            val dataList = gson.toJson(allKeys)
            val sikSend = gson.toJson(sik)
            val sikXSend = gson.toJson(sikX)
            val ikSend = gson.toJson(ik)
            intent.putExtra("dataList", dataList)
            intent.putExtra("chatId", chat_id)
            intent.putExtra(Constants.KEYS.INTENT_SIK, sikSend)
            intent.putExtra(Constants.KEYS.INTENT_SIK_X, sikXSend)
            intent.putExtra(Constants.KEYS.INTENT_IK, ikSend)

            startService(intent)

            Handler(Looper.getMainLooper()).postDelayed({
                MainApp.resetApplication()
                finish()
            }, 6 * 1000)
        } catch (e: Exception) {
            Log.e(TAG, "Exception in saving keys ${e.printStackTrace()}")
            runOnUiThread { finish() }
        }

    }


    @SuppressLint("ObsoleteSdkInt")
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {
        if (tag as Int == RequestCodes.API.GET_USER_ID) {


        }
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        Notify.Toast(response.message)
    }

}
