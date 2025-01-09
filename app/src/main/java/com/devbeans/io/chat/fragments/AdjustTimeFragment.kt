package com.devbeans.io.chat.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.CustomSplashActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.databinding.AdjustTimeFragmentBinding
import com.devbeans.io.chat.extensions.findNavController
import com.devbeans.io.chat.extensions.runOnUiThread
import com.devbeans.io.chat.models.ServerTime
import com.devbeans.io.chat.network.APIInterface
import com.devbeans.io.chat.network.RetrofitClient
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Constants
import com.devbeans.io.chat.utils.logging.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class AdjustTimeFragment : Fragment() {


    private var firstLaunch: Boolean = false
    lateinit var mBinding: AdjustTimeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View {
        mBinding = AdjustTimeFragmentBinding.inflate(inflater, viewGroup, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listeners()
        getArgs()
    }

    private fun getArgs() {
        val bundle = arguments
        firstLaunch =
            bundle != null && bundle.containsKey(Constants.KEYS.INTENT_FROM_SPLASH) && bundle.getBoolean(
                Constants.KEYS.INTENT_FROM_SPLASH,
                false
            )
    }

    private fun listeners() {
        mBinding.apply {
            adjustTimeBtn.setOnClickListener {
                startActivityForResult(
                    Intent(Settings.ACTION_DATE_SETTINGS),
                    9878
                );
            }
        }
    }

    private fun checkTime() {
        val retrofitClient =
            RetrofitClient.createRetroCLient().create(APIInterface::class.java)
        val dateTimeCheck = retrofitClient.getServerTime()
        dateTimeCheck.enqueue(object : Callback<ServerTime> {
            override fun onResponse(
                call: Call<ServerTime>,
                response: Response<ServerTime>
            ) {
                val res = response.body()
                if (res != null && res!!.getCode() == 200) {
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
                            mBinding.textMessage.text = String.format(
                                "%s",
                                "${AndroidUtil.getString(R.string.time_wrong)}\n $datesss"
                            )

                        }
                    } else {


                        runOnUiThread {
                            if (firstLaunch) {
                                MainApp.resetApplication()
                                activity?.finish()
                            } else {
                                activity?.findNavController(R.id.fragment_container_settings)
                                    ?.navigateUp()
                            }

                        }
                    }
                } else {
                    activity?.findNavController(R.id.fragment_container_settings)
                        ?.navigate(R.id.action_ChatSplashFragment_to_networkFragment)
                    Log.e(CustomSplashActivity.TAG, "Response was null from KDS")
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
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 9878) {
            Constants.ensureBackgroundThread {
                checkTime()
            }
        }
    }
}