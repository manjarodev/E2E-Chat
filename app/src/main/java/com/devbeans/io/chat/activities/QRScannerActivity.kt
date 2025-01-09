package com.devbeans.io.chat.activities

//import com.devbeans.io.chat.verify.VerifyIdentityFragment.Companion.create
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.callBacks.ExpiryCallback
import com.devbeans.io.chat.databinding.ActivityQrscannerBinding
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.utils.qr.kitkat.ScanListener
import com.devbeans.io.chat.verify.VerifyScanFragment

class QRScannerActivity : AppCompatActivity(), ScanListener, ExpiryCallback {
    var binding: ActivityQrscannerBinding? = null
    var generatedDeviceId: String? = null
    private var mCodeScanner: CodeScanner? = null
    private val scanFragment = VerifyScanFragment()
    val CAMERA = "android.permission-group.CAMERA"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrscannerBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
//        val fragment = create( //                getIntent().getParcelableExtra(RECIPIENT_EXTRA),
//            //                getIntent().getParcelableExtra(IDENTITY_EXTRA),
//            intent.getBooleanExtra(VERIFIED_EXTRA, false)
//        )
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container_view, scanFragment)
//            .commitAllowingStateLoss()

        Permissions.with(this)
            .request(Constants.CAMERA_PERMISSIONS)
            .ifNecessary()
            .withPermanentDenialDialog(getString(R.string.VerifyIdentityActivity_chat_needs_the_camera_permission_in_order_to_scan_a_qr_code_but_it_has_been_permanently_denied))
            .onAllGranted {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_from_top,
                        R.anim.slide_to_bottom,
                        R.anim.slide_from_bottom,
                        R.anim.slide_to_top
                    )
                    .replace(R.id.fragment_container_view, scanFragment)
//                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
            .onAnyDenied {
                finish()
                Toast.makeText(
                    this@QRScannerActivity,
                    R.string.VerifyIdentityActivity_unable_to_scan_qr_code_without_camera_permission,
                    Toast.LENGTH_LONG
                ).show()
            }
            .execute()


//        try {
//            if (EasyPermissions.hasPermissions(getApplicationContext(), Constants.CAMERA_PERMISSIONS)) {
//                setScanner();
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
//                        RequestCodes.WRITE_PERMISSION);
//            }
//        } catch (Exception e) {
//            Notify.Toast("App requires some permissions to function properly.");
//            Log.d("camera", e.getMessage());
//        }

//        getLicense();
    }


    private fun setScanner() {
        try {
            mCodeScanner = CodeScanner(this, binding!!.scannerView)
            mCodeScanner!!.decodeCallback = DecodeCallback { result ->
                runOnUiThread {
                    val intent = intent
                    intent.putExtra("userId", result.text)
                    setResult(RESULT_OK, intent)
                    finish()
                }
            }
            mCodeScanner!!.errorCallback =
                ErrorCallback { error -> //                    Notify.Toast("Camera not Allowed");
                    Log.e(ContentValues.TAG, "onError: ", error)
                }
            binding!!.scannerView.setOnClickListener { mCodeScanner!!.startPreview() }
        } catch (e: Exception) {
//            Notify.Toast("Camera not Allowed");
            Log.e(ContentValues.TAG, "onError: ", e)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        Permissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
        when (requestCode) {
            RequestCodes.WRITE_PERMISSION -> {
                var i = 0
                while (i < permissions.size) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        Log.d("Permissions", "Permission Granted: " + permissions[i])
//                        setScanner()
                    } else if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        Log.d("Permissions", "Permission Denied: " + permissions[i])
                    }
                    i++
                }
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }

    override fun onResume() {
        MainApp.appContext?.setNotifyExpiry(this)
        MainApp.appContext?.notifyViewExpiry()
        super.onResume()
        if (mCodeScanner != null) mCodeScanner!!.startPreview()
    }

    override fun onPause() {
        Utills.dismiss()
        if (mCodeScanner != null) mCodeScanner!!.releaseResources()
        super.onPause()
    }

    override fun onQrDataFound(data: String) {
        Log.e("TAG", "$data")

        ThreadUtil.runOnMain {
            ServiceUtil.getVibrator(MainApp.appContext).vibrate(50)
//            childFragmentManager.popBackStack()

            if (contactsDao.getContact(data) != null) {
                Notify.Toast("User Already in contacts")
            } else {
                val intent = intent
                intent.putExtra("userId", data)
                setResult(RESULT_OK, intent)
            }

            finish()
//            displayFragment.setScannedFingerprint(data)
        }

    }

//    override fun onQrCodeContainerClicked() {}

    interface Callback {
        fun onQrCodeContainerClicked()
    }

    companion object {
        private const val VERIFIED_EXTRA = "verified_state"
    }

    override fun notifyExpiry() {
        binding?.let {
            Utills.showSubscriptionBanner(binding?.tvSubs)
        }
    }
}