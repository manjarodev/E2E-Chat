package com.devbeans.io.chat.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.CustomSplashActivity
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.NetworkCallback
import com.devbeans.io.chat.databinding.SplashFragmentBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.models.*
import com.devbeans.io.chat.network.APIInterface
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.RetrofitClient
import com.devbeans.io.chat.network.serializers.requestbody.UploadSikRequest
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.RegisterUserResponse
import com.devbeans.io.chat.network.serializers.response.UploadKeysModel
import com.devbeans.io.chat.services.SavingKeysService
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.CreatePinActivity
import com.devbeans.io.chat.verifypin.LogOutTimerUtil
import com.google.gson.Gson
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

class SplashFragment : Fragment(), OnNetworkResponse {
    lateinit var public_key: String
    private lateinit var mBinding: SplashFragmentBinding
    private var i = 0
    var isAppInitialized = false
    val sTag = javaClass.simpleName


    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View? {

        mBinding = SplashFragmentBinding.inflate(inflater, viewGroup, false)

        return mBinding?.root
    }


    private fun initViews() {

        val fadeIn: Animation = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this
        fadeIn.duration = 3000
        val animation = AnimationSet(false) //change to false
        animation.addAnimation(fadeIn)

        mBinding.linearLayout.visibility = View.GONE
    }


    /**
     * Checking the server time in [proceedData]
     * if the time is not correct the App will always prompt for setting time of device (Android)
     */
    private fun proceedData() {


        Utills.checkKDSServerConnected(object : NetworkCallback {
            override fun onResponse(network: Boolean) {
                if (network) {
                    callNextProcedure()

                } else {
                    activity?.findNavController(R.id.fragment_container_settings)
                        ?.navigate(R.id.action_ChatSplashFragment_to_networkFragment)
                }
            }
        })
    }


    /**
     * If the server time is correct [proceedData] this is the next procedure of registering [User] on Chat Server ]
     */
    private fun callNextProcedure() {

        val thr: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(500)
                } catch (exception: Exception) {
                    exception.printStackTrace()
                } finally {
                    try {
                        if (AppSession.getUser() != null && AppSession.getUser().chatUserId != null && (AppSession.keysUploaded() || SettingsValues.getKeyUploaded())) {
                            checkTime(false)
//                            handleActivities()
                        } else {
                            runOnUiThread {
                                mBinding.ivLogoApp.visibility = View.GONE
                                mBinding.linearLayout.visibility = View.VISIBLE
                            }
                            Log.e(CustomSplashActivity.TAG, "User was not saved in APP session")
                            Utills.checkChatServerConnected(object : NetworkCallback {
                                override fun onResponse(network: Boolean) {
                                    if (network) {
                                        registerUser()
                                    } else {
                                        activity?.findNavController(R.id.fragment_container_settings)
                                            ?.navigate(R.id.action_ChatSplashFragment_to_networkFragment)
                                    }
                                }

                            })

                        }
                    } catch (e: java.lang.IllegalStateException) {
                        Log.e(tag, "Exception ${e.printStackTrace()}")
                    }
                }
            }
        }
        thr.start()
    }


    /**
     * Registering the [User] on chat server
     */
    private fun registerUser() {
        Log.d(
            CustomSplashActivity.TAG,
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
        Utills.checkKDSServerConnected(object : NetworkCallback {
            override fun onResponse(network: Boolean) {
                if (network) {
                    val retrofitClient =
                        RetrofitClient.createRetroCLient().create(APIInterface::class.java)
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
                                    call: Call<UploadKeysModel?>,
                                    response: Response<UploadKeysModel?>
                                ) {
                                    if (response.isSuccessful) {
                                        generateKeyPairs(
                                            chatId!!, sik, sikX, ikCurve
                                        )
                                        Log.e(CustomSplashActivity.TAG, "SIK Keys uploaded")
                                    } else {
                                        Log.e(CustomSplashActivity.TAG, "SIK Keys not uploaded")
                                    }
                                }

                                override fun onFailure(call: Call<UploadKeysModel?>, t: Throwable) {
                                    t.printStackTrace()
                                    Log.e(CustomSplashActivity.TAG, "SIK Keys not uploaded")
                                }

                            })
                        }
                    } catch (e: Exception) {
                        Log.e(
                            CustomSplashActivity.TAG,
                            "Exception in SIK uploading ${e.printStackTrace()}"
                        )
                        runOnUiThread {
                            requireActivity().finish()
                        }
                    }
                } else {
                    Log.e(tag, "Upload sik Network not available")
                    AppSession.editor.clear().commit()
                    activity?.findNavController(R.id.fragment_container_settings)
                        ?.navigate(R.id.action_ChatSplashFragment_to_networkFragment)
                }
            }


        })


    }


    /**
     * Will generate Key pair from [KeyPairGenerator]
     */
    private fun generateKeyPairs(
        chat_id: String,
        sik: ChatKeyPair,
        sikX: ChatKeyPair,
        ikCurve: ChatKeyPair
    ) {

        //Checking if there is previously generated keyPairs
//        if (SettingsValues.getKeyUploaded()) {
//            checkTime(false)
//            Log.e(SplashActivity.TAG, "no need to generate keys")
//
//        } else {
        val keyPairGenerator = KeyPairGenerator()
        keyPairGenerator.generateKeys(object : KeyPairGenerator.keysGenerated {
            override fun onKeysGenerated() {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        saveAllKeys(keyPairGenerator.keyPairList, chat_id, sik, sikX, ikCurve)
                    }
                } catch (e: CertificateException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: NoSuchAlgorithmException) {
                    e.printStackTrace()
                } catch (e: KeyStoreException) {
                    e.printStackTrace()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })
//        }
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.e(CustomSplashActivity.TAG, "asas")
        if (AppSession.getUser() == null) {
            view.viewTreeObserver.addOnPreDrawListener(
                object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        Log.e(CustomSplashActivity.TAG, "Got onPreDraw called")
                        isAppInitialized = true
                        return if (isAppInitialized) {

                            view.viewTreeObserver.removeOnPreDrawListener(this)
                            initViews()
                            Constants.ensureBackgroundThread {
                                proceedData()
                            }
                            true
                        } else {
                            // The content is not ready; suspend.
                            isAppInitialized = false
                            false
                        }
                    }
                }) ?: return
        } else if (AppSession.getUser() != null && savedInstanceState == null) {
            initViews()
            proceedData()
        }
    }


    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
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

//            Utills.checkKDSServerConnected(object : NetworkCallback {
//                override fun onResponse(network: Boolean) {
//                    if (network) {
            runOnUiThread {
                val keyPairGenerator = KeyPairGenerator()
                val hsm = HSM.with()
                val ik = keyPairGenerator.convertCurveToX25519(ikCurve)
                hsm!!.storeServerIdentityKey(sik)
                hsm.storeX25519ServerIdentityKey(
                    sikX
                )
                hsm.storeIdentityKey(ik)

                val intent = Intent(activity, SavingKeysService::class.java)
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

                activity?.startService(intent)
                Log.e(sTag, "Got here")
            }

            Handler(Looper.getMainLooper()).postDelayed({
                checkTime(true)
            }, 6 * 1000)
//                    } else {

//                    }
//                }
//            })

        } catch (e: Exception) {
            Log.e(CustomSplashActivity.TAG, "Exception in saving keys ${e.printStackTrace()}")
            runOnUiThread { requireActivity().finish() }
        }

    }

    private fun checkTime(firstLaunch: Boolean) {
        Utills.checkKDSServerConnected(object : NetworkCallback {
            override fun onResponse(network: Boolean) {
                if (network) {
                    val retrofitClient =
                        RetrofitClient.createRetroCLient().create(APIInterface::class.java)
                    val dateTimeCheck = retrofitClient.getServerTime()
                    dateTimeCheck.enqueue(object : Callback<ServerTime> {
                        override fun onResponse(
                            call: Call<ServerTime>,
                            response: Response<ServerTime>
                        ) {

                            val res = response.body()
                            res?.let {
                                handleTimeResponse(res, firstLaunch)
                            }
                        }

                        override fun onFailure(call: Call<ServerTime>, t: Throwable) {

                            activity?.findNavController(R.id.fragment_container_settings)
                                ?.navigate(R.id.action_ChatSplashFragment_to_networkFragment)
//                requireActivity().findNavController(
//                    R.id.fragment_container_settings
//                ).navigate(R.)
//                t.printStackTrace()
//                Log.e(SplashActivity.TAG, "${t.message}")
                        }

                    })
                } else {
                    activity?.findNavController(R.id.fragment_container_settings)
                        ?.navigate(R.id.action_ChatSplashFragment_to_networkFragment)
                }
            }


        })

    }

    private fun handleTimeResponse(res: ServerTime, firstLaunch: Boolean) {
        if (res!!.getCode() == 200) {
            val time = System.currentTimeMillis() + 300000

            val serverTime = res.getTime()
            val inLocalFormate =
                SimpleDateFormat(
                    "HH:mm",
                    Locale.getDefault()
                ).format(serverTime)
            Log.e("error", time.toString())
            Log.e("error", inLocalFormate)

            val date = Date(time)
            val date2 = Date(serverTime!!)

            if (date.before(date2)) {
                val df: DateFormat =
                    SimpleDateFormat(
                        "EEE, d MMM yyyy HH:mm:ss",
                        Locale.getDefault()
                    )
                val datesss: String = df.format(date2)
                runOnUiThread {
                    val args = Bundle()
                    args.putBoolean(
                        Constants.KEYS.INTENT_FROM_SPLASH,
                        firstLaunch
                    )

                    activity?.findNavController(R.id.fragment_container_settings)
                        ?.navigate(R.id.action_ChatSplashFragment_to_adjustTimeFragment,args)
                }
            } else {
                Log.e(sTag, "Got here $firstLaunch")
                runOnUiThread {
                    if (firstLaunch) {
                        MainApp.resetApplication()
                        activity?.finish()
                    } else {
                        handleActivities()
                    }
                }
            }
        } else {
            activity?.findNavController(R.id.fragment_container_settings)
                ?.navigate(R.id.action_ChatSplashFragment_to_networkFragment)
            Log.e(CustomSplashActivity.TAG, "Response was null from KDS")
        }
    }

    private fun handleActivities() {
        runOnUiThread {
            val intent: Intent
            if (AppSession.getInt(LogOutTimerUtil.LOGOUT_KEY) == 0) {
                AppSession.put(
                    LogOutTimerUtil.LOGOUT_KEY,
                    30000
                )
            }
            if (AppSession.get(CreatePinActivity.KEY_PIN)
                    .isEmpty()
            ) {
                intent =
                    Intent(
                        requireActivity(),
                        CreatePinActivity::class.java
                    )
            } else {
                intent = Intent(
                    requireActivity(),
                    MainActivity::class.java
                )
            }
            startActivity(intent)

            requireActivity().finish()
        }
    }


    @SuppressLint("ObsoleteSdkInt")
    override fun onSuccess(call: Call<*>?, response: Response<*>, tag: Any) {

        if (tag as Int == RequestCodes.API.GET_USER_ID && response.code() == 200) {
            val res = response.body() as RegisterUserResponse?
            handleUserResponse(res)
        }

    }

    private fun handleUserResponse(res: RegisterUserResponse?) {
        Log.d(
            ContentValues.TAG,
            "registerUser: " + "End Point: " + RequestCodes.API_END_POINTS.REGISTER_DEVICE + " Response: " + "status=" + res!!.status + " user=" + res.user
        )
        if (res.user != null) {
            AppSession.saveUser(res.user)
            public_key = res.user!!.publicKey!!
            if (AppSession.getInt(LogOutTimerUtil.LOGOUT_KEY) == 0) {
                AppSession.put(LogOutTimerUtil.LOGOUT_KEY, 30000)
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val chat_id = if (res.user != null) {
                    res.user!!.chatUserId
                } else {
                    ""
                }

                if (chat_id != null) {
                    Constants.ensureBackgroundThread {
                        generateSik(chat_id)
                    }

                } else {
                    runOnUiThread {
                        Notify.Toast("User not created")
                        activity?.finish()
                    }
                }

            }
        } else {
            Notify.Toast("No user found")
            activity?.finish()
        }
    }

    override fun onFailure(call: Call<*>?, response: BaseResponse, tag: Any) {
        Notify.Toast(response.message)
    }
}