package com.devbeans.io.chat.verifypin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.callBacks.ResetLogoutTimer
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.verifypin.LogOutTimerUtil.LogOutListener
import kotlinx.coroutines.*
import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

open class BaseActivity : AppCompatActivity(), LogOutListener, ResetLogoutTimer {
    private var isScreenOn: Boolean = false
    protected val dynamicTheme: DynamicTheme = DynamicTheme()




    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
//        DynamicTheme.setDefaultDayNightMode(this)
//        dynamicTheme.onCreate(this)
        super.onCreate(savedInstanceState)
        WindowUtil.setStatusBarColor(window,AndroidUtil.getColor(R.color.bg_window_fill_color))
        AppSession.put(Constants.KEYS.WAS_SHOWING, false)
        GlobalScope.launch {
            try {
                val exifPath = filesDir.absolutePath + "/exiftool/exiftool"

                val exifFile = File(exifPath)


                if (!exifFile.exists()) {
                    Log.e(TAG, "extracting ${exifFile.absoluteFile}")
                    moveAssetsToInternal()
                } else {
                    Log.e(TAG, "${exifFile.absoluteFile}")
                }


//                String imagePath = getFilesDir().getAbsolutePath().concat("/a.jpg");
//                String imagePath = "/storage/emulated/0/vault/pexels-marina-m-8357320.jpg";
//                String outPath = "/storage/emulated/0/vault/pexels-marina-m.jpg";
//                String outPath = getFilesDir().getAbsolutePath().concat("/a.1jpg");


//                String[] cmd = {
//                        "ffmpeg",
//                        "-i",
//                        imagePath,
//                        outPath
//                };
//
//                ProcessBuilder processBuilder = new ProcessBuilder(cmd);
//                processBuilder.redirectErrorStream(true);
//                String processedCommand = processBuilder.command().toString();
//                Log.e(TAG, "onCreate: Command::  " + processedCommand);
//                Process process = processBuilder.start();
//                int exitCode = process.waitFor();
//                Log.e(TAG, "onCreate: ExitCode::  " + exitCode);
//
//                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
//                String s = null;
//                while ((s = stdInput.readLine()) != null) {
//                    Log.e(TAG, "onCreate: Output::  " + s);
//                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
//        appContext?.notifyViewExpiry()
        appContext!!.currentActivity = this
    }

    private fun moveAssetsToInternal() {
        val destPath = filesDir.absolutePath
        val assetManager = assets
        val files: Array<String>?
        try {
            files = assetManager.list("")
            for (filename in files!!) {
                if (filename == "exiftool.zip") {
                    var inputStream: InputStream
                    var outputStream: OutputStream
                    inputStream = assetManager.open(filename)
                    val outFile = File(destPath, filename)
                    if (!outFile.exists()) {
                        outputStream = FileOutputStream(outFile)
                        val buffer = ByteArray(1024)
                        var read: Int
                        while (inputStream.read(buffer).also { read = it } != -1) {
                            outputStream.write(buffer, 0, read)
                        }
                        inputStream.close()
                        outputStream.flush()
                        outputStream.close()
                        unzipFonts(this, File("$destPath/exiftool.zip"), File(destPath))
                    }
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        Log.e(TAG, "onWindowFocusChanged () &&& $hasFocus ")
        handleClipBoard(hasFocus)
        super.onWindowFocusChanged(hasFocus)
    }

    @Throws(IOException::class)
    @SuppressLint("StaticFieldLeak")
    open fun unzipFonts(context: Context?, zipFile: File, targetDirectory: File?): Boolean {
        val unziped = booleanArrayOf(false)
        val zis = ZipInputStream(BufferedInputStream(FileInputStream(zipFile)))


        object : AsyncTask<Void?, Void?, Void?>() {
            @Deprecated("Deprecated in Java")
            override fun onPreExecute() {
                super.onPreExecute()
                try {
                    if (context is Activity) {
                        if (context.isFinishing) {
                            return
                        }
                    }
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }

            @Deprecated("Deprecated in Java")
            override fun doInBackground(vararg voi: Void?): Void? {
                handleBackground(zis, unziped, targetDirectory)
                return null
            }

            @Deprecated("Deprecated in Java")
            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                try {
                    if (zipFile.exists()) {
                        zipFile.delete()
                    }
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }
        }.execute()


        return unziped[0]
    }

    private fun handleBackground(
        zis: ZipInputStream,
        unziped: BooleanArray,
        targetDirectory: File?
    ) {
        try {
            var ze: ZipEntry
            var count: Int
            val buffer = ByteArray(8192)
            while (zis.nextEntry.also { ze = it } != null) {
                val file = File(targetDirectory, ze.name)
                val dir = if (ze.isDirectory) file else file.parentFile
                val canonicalPath = file.canonicalPath
                if (!dir.isDirectory && !dir.mkdirs() && !canonicalPath.startsWith(dir.name)) try {
                    throw FileNotFoundException(
                        "Failed to ensure directory: " +
                                dir.absolutePath
                    )
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
                if (ze.isDirectory) continue
                val fout = FileOutputStream(file)
                try {
                    while (zis.read(buffer).also { count = it } != -1) fout.write(
                        buffer,
                        0,
                        count
                    )
                } finally {
                    fout.close()
                }
                /* if time should be restored as well
long time = ze.getTime();
if (time > 0)
    file.setLastModified(time);
*/
            }
            unziped[0] = true
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        } finally {
            try {
                zis.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (AppSession.getBoolean(Constants.LOCK.KEY_KEEP_LOCK) && AppSession.getBoolean(Constants.isDialog)) {
            Log.e(TAG, "Got here OnStart showing dialog")

            //persist app lock if shows on screen
            //destory all dialogs
            MainApp.pinDialog.destroyDialog()

            //create new dialog
            MainApp.pinDialog.createPinDialog(this, "device lock")
            LogOutTimerUtil.stopLogoutTimer()

        } else {
            Log.e(TAG, "Got here OnStart not showing dialog")
            LogOutTimerUtil.startLogoutTimer(this, this)
        }
        PinDialog.setResetLogoutTimer(this)

        //if app is at first run make dialog appear
        AppSession.put(Constants.isDialog, true)
        LogOutTimerUtil.startLogoutTimer(this, this)
//        copyChatDataToClipBoard()
        Log.e(TAG, "OnStart () &&& Starting timer")
    }


    @RequiresApi(Build.VERSION_CODES.P)
    private fun handleClipBoard(hasFocus: Boolean) {
        if (SettingsValues.getIncognitoKeyboard()) {
            when (hasFocus) {
                true -> {
                    handleCopyFocus()
                }
                false -> {
                    handleCutFocus()
                }
            }
        }
    }

    private fun handleCutFocus() {
        // Copy data to preference from clipboard if clipboard has data
        val clipBoardManager = ServiceUtil.getClipboardManager(this)
//                    Log.e(TAG, "Going Out of chat")
        if (clipBoardManager.hasPrimaryClip()) {

            val item = clipBoardManager.primaryClip!!.getItemAt(0)

            val pasteUri: Uri? = item.uri
            SettingsValues.setClipboardDataImageSet(pasteUri != null)
            SettingsValues.setClipboardDataStringSet(pasteUri == null)
            if (pasteUri != null) {
                SettingsValues.setClipboardDataImage(pasteUri.toString())
            } else {
                val pasteText = item.text
                SettingsValues.setClipboardDataString(pasteText.toString())
            }
            clipBoardManager.clearPrimaryClip()

        }

    }

    private fun handleCopyFocus() {

        //"Got in Chat
        // Copy data from preference to chat if preference has data
        val clipBoardManager = ServiceUtil.getClipboardManager(this)
        if (clipBoardManager.hasPrimaryClip()) {
            val item = clipBoardManager.primaryClip!!.getItemAt(0)

            val pasteUri: Uri? = item.uri
            SettingsValues.setClipboardDataImageSet(pasteUri != null)
            SettingsValues.setClipboardDataStringSet(pasteUri == null)
            if (pasteUri != null) {
                SettingsValues.setClipboardDataImage(pasteUri.toString())
                // Copied Data was Image")
            } else {
                val pasteText = item.text
                SettingsValues.setClipboardDataString(pasteText.toString())
                // Log.e(TAG, "Copied Data was text $pasteText")
            }
        } else {
            // Log.e(TAG, "Clip Board didn't had data when come from outside of chat")
            if (SettingsValues.getClipboardDataImageSet()) {


                val clip = ClipData.newUri(
                    appContext!!.contentResolver,
                    "a Photo",
                    Uri.parse(SettingsValues.getClipboardDataImage())
                )
                clipBoardManager.setPrimaryClip(clip)
            } else if (SettingsValues.getClipboardDataStringSet()) {
                clipBoardManager.setPrimaryClip(
                    ClipData.newPlainText(
                        "text",
                        SettingsValues.getClipboardDataString()
                    )
                )

            } else {
//                            Log.e(
//                                TAG,
//                                "Both preference Check failed Did not had any copied data in chat"
//                            )
            }
        }

    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        LogOutTimerUtil.startLogoutTimer(this, this)
        Log.e(TAG, "User interacting with screen")
    }

    @SuppressLint("ObsoleteSdkInt")
    override fun onPause() {
        super.onPause()
        Utills.dismiss()
        Log.e(TAG, "onPause()")


        //stop logout timer
        LogOutTimerUtil.stopLogoutTimer()


        //check if screen is locked or not
        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        isScreenOn = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            powerManager.isInteractive
        } else {
            powerManager.isScreenOn
        }
        if (!isScreenOn) {
            Log.e(TAG, "PIN Dialog was not showing recently")
            AppSession.put(Constants.LOCK.KEY_KEEP_LOCK, true)
            //persist app lock if shows on screen
            //destory all dialogs
            MainApp.pinDialog.destroyDialog()
        }

        //destroy dialog on activity pause
        MainApp.pinDialog.destroyDialog()
    }

    override fun onDestroy() {
//        MainApp.pinDialog.destroyDialog()
        try {
            MainApp.pinDialog.destroyDialog()
            AppSession.put(Constants.KEYS.WAS_SHOWING, false)
//            PinDialog.dialogINSTANCE()?.destroyDialog()

        } catch (e: Exception) {
            Log.e(TAG, "Exception $e")
        }
        super.onDestroy()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
//        dynamicTheme.onResume(this)
        if (Utills.isSubscriptionExpired() || Utills.isSubscriptionGrace())
            appContext?.notifyViewExpiry()
        if (AppSession.getBoolean(Constants.LOCK.KEY_KEEP_LOCK) && AppSession.getBoolean(Constants.isDialog)) {
            Log.e(TAG, "Got here onResume showing dialog")

            //persist app lock if shows on screen
            //destory all dialogs


            //create new dialog
            if (!AppSession.getBoolean(Constants.KEYS.WAS_SHOWING)) {
                MainApp.pinDialog.destroyDialog()
                MainApp.pinDialog.createPinDialog(this, "device lock")
            }
            LogOutTimerUtil.stopLogoutTimer()
        } else {
            Log.e(TAG, "Got here onResume not showing dialog")
            LogOutTimerUtil.startLogoutTimer(this, this)
        }

    }

    /**
     * Performing idle time logout
     */
    override fun doLogout() {
        // write your stuff here
        runOnUiThread {
            try {
                SettingsValues.setPassCodeAlreadyShowing(true)

                //if app is at first run make dialog appear
                val check = AppSession.getBoolean(Constants.isDialog)
                if (check) {
                    PinDialog.dialogINSTANCE()?.createPinDialog(this, "timeout")
                    AppSession.put(Constants.LOCK.KEY_KEEP_LOCK, true)
                }
            } catch (e: Exception) {
                AppSession.put(Constants.isDialog, true)
                AppSession.put(Constants.LOCK.KEY_KEEP_LOCK, true)
                Log.e(TAG, "doLogout: ", e)
            }
        }
        Log.e(TAG, "doLogout: timeout")
    }

    override fun onResetTimer() {
        LogOutTimerUtil.startLogoutTimer(this@BaseActivity, this@BaseActivity)
    }


    companion object {
        val TAG = BaseActivity::class.java.simpleName
    }
}