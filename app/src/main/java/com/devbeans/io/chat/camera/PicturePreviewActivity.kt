package com.devbeans.io.chat.camera

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.databinding.ActivityPicturePreviewBinding
import com.devbeans.io.chat.verifypin.BaseActivity
import com.otaliastudios.cameraview.PictureResult
import com.otaliastudios.cameraview.size.AspectRatio
import java.io.File

class PicturePreviewActivity : BaseActivity() {

    companion object {
        var pictureResult: PictureResult? = null
    }

    private lateinit var binding: ActivityPicturePreviewBinding

    override fun onDestroy() {
        super.onDestroy()
        if (!isChangingConfigurations) {
            pictureResult = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_picture_preview)
//        setContentView(binding.root)

        val result = pictureResult ?: run {
            finish()
            return
        }

//        val captureResolution = findViewById<MessageView>(R.id.nativeCaptureResolution)
//        val captureLatency = findViewById<MessageView>(R.id.captureLatency)
//        val exifRotation = findViewById<MessageView>(R.id.exifRotation)

        val delay = intent.getLongExtra("delay", 0)
        val ratio = AspectRatio.of(result.size)
//        captureLatency.setTitleAndMessage("Approx. latency", "$delay milliseconds")
//        captureResolution.setTitleAndMessage("Resolution", "${result.size} ($ratio)")
//        exifRotation.setTitleAndMessage("EXIF rotation", result.rotation.toString())

        try {
            result.toBitmap(1000, 1000) { bitmap -> binding.image.setImageBitmap(bitmap) }
        } catch (e: UnsupportedOperationException) {
            binding.image.setImageDrawable(ColorDrawable(Color.GREEN))
            Toast.makeText(this, "Can't preview this format: " + result.format, Toast.LENGTH_LONG)
                .show()
        }


        binding.buttonSave.setOnClickListener {

            result.toFile(File("${MainApp.imagesPath}/${System.currentTimeMillis()}.jpeg")) {
                Log.e("camTAG", "onCreate: ${it!!.absolutePath}")


            }

            //refresh home


            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }

        binding.buttonRetake.setOnClickListener{
            finish()
        }


        if (result.isSnapshot) {
            // Log the real size for debugging reason.
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeByteArray(result.data, 0, result.data.size, options)
            if (result.rotation % 180 != 0) {
                Log.e(
                    "PicturePreview",
                    "The picture full size is ${result.size.height}x${result.size.width}"
                )
            } else {
                Log.e(
                    "PicturePreview",
                    "The picture full size is ${result.size.width}x${result.size.height}"
                )
            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {

        super.onCreate(savedInstanceState, persistentState)

    }

}