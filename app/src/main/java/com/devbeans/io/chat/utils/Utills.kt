package com.devbeans.io.chat.utils

import android.app.Activity
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.media.MediaMetadataRetriever
import android.media.MediaPlayer
import android.media.MediaScannerConnection
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.UserManager
import android.provider.MediaStore
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.amulyakhare.textdrawable.TextDrawable
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.ChatActivity
import com.devbeans.io.chat.activities.MainActivity
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.app.MainApp.Companion.appContext
import com.devbeans.io.chat.app.MainApp.Companion.ls
import com.devbeans.io.chat.callBacks.NetworkCallback
import com.devbeans.io.chat.extensions.contactsDao
import com.devbeans.io.chat.extensions.messagesDao
import com.devbeans.io.chat.extensions.offlineAckDao
import com.devbeans.io.chat.extensions.offlineMessagesDao
import com.devbeans.io.chat.models.Contact
import com.devbeans.io.chat.models.EncryptedPayload
import com.devbeans.io.chat.models.OfflineMessage
import com.devbeans.io.chat.models.Payload
import com.devbeans.io.chat.network.NetworkCheck
import com.devbeans.io.chat.network.NetworkCheckCA
import com.devbeans.io.chat.roomDB.Dao.ContactsDao
import com.devbeans.io.chat.utils.NameUtil.getAbbreviation
import com.devbeans.io.chat.utils.avatar.Avatar
import com.devbeans.io.chat.utils.avatar.AvatarColor
import com.devbeans.io.chat.utils.avatar.AvatarRenderer.createTextDrawable
import com.devbeans.io.chat.utils.avatar.Avatars
import com.devbeans.io.chat.utils.avatar.Avatars.getForegroundColor
import com.devbeans.io.chat.utils.logging.Log
import com.google.gson.Gson
import com.virgilsecurity.keyknox.utils.Serializer.Companion.gson
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.lang.reflect.Method
import java.net.InetAddress
import java.net.UnknownHostException
import java.nio.charset.StandardCharsets
import java.security.SecureRandom
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


object Utills {
    private var expirytoolTip: ExpiryTooltipPopup? = null
    private var expirytoolTipList = mutableListOf<ExpiryTooltipPopup>()
    var serverAvailable: MutableLiveData<Boolean>? = null
    val TAG = Log.tag(Utills::class.java)
    var rnd = SecureRandom()
    var colors: ArrayList<String?> = object : ArrayList<String?>() {
        init {
            add("FF9800")
            add("00BA1E")
            add("F44336")
            add("783294")
        }
    }


    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

    public open val TextColors: ArrayList<String?> = object : ArrayList<String?>() {
        init {
            add("#F44336")
            add("#FF9800")
            add("#00BA1E")
        }
    }
    private val ALLOWED_CHARACTERS: CharSequence = "qwertyuiopasdfghjklzxcvbnm1234567890"
    fun isCause(
        expected: Class<out Throwable?>,
        exc: Throwable?
    ): Boolean {
        return expected.isInstance(exc) || exc != null && isCause(expected, exc.cause)
    }

    fun getString(id: Int): String {
        return appContext!!.resources.getString(id)
    }

    fun getLoading(activity: Activity?, mesage: String?): Loading {
        return Loading.make(activity)
            .setCancelable(false)
            .setMessage(mesage)
            .show()
    }

    fun getRandomString(sizeOfRandomString: Int): String {
        val random = Random()
        val sb = StringBuilder(sizeOfRandomString)
        for (i in 0 until sizeOfRandomString) sb.append(
            ALLOWED_CHARACTERS[random.nextInt(
                ALLOWED_CHARACTERS.length
            )]
        )
        return sb.toString()
    }


    fun numToBytes(num: Int): ByteArray? {
        return if (num == 0) {
            byteArrayOf()
        } else if (num < 256) {
            byteArrayOf(num.toByte())
        } else if (num < 65536) {
            byteArrayOf((num ushr 8).toByte(), num.toByte())
        } else if (num < 16777216) {
            byteArrayOf((num ushr 16).toByte(), (num ushr 8).toByte(), num.toByte())
        } else { // up to 2,147,483,647
            byteArrayOf(
                (num ushr 24).toByte(),
                (num ushr 16).toByte(),
                (num ushr 8).toByte(),
                num.toByte()
            )
        }
    }

    @Throws
    fun getDuration(context: Context?, path: String?): String {
//        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + path;
        val retriever = MediaMetadataRetriever()
        var time = 0

        try {
            val file = File(path)
            if (file != null && file.exists() && file.length() > 0) {
                val uri = Uri.parse(file.absolutePath)
                time = getMediaDuration(context, uri)


            }
        } catch (e: Exception) {

            e.printStackTrace()
            val inputStream = FileInputStream(path)
            retriever.setDataSource(inputStream.getFD())
            inputStream.close()
        }

        val timeInmillisec = time!!.toLong()
        val duration = timeInmillisec / 1000
        val hours = duration / 3600
        val minutes = (duration - hours * 3600) / 60
        val seconds = duration - (hours * 3600 + minutes * 60)
        val timeString: String
        timeString = if (hours > 0) {
            String.format("%02d:%02d:%02d", hours, minutes, seconds)
        } else {
            String.format("%02d:%02d", minutes, seconds)
        }
        return timeString
    }

    fun getMediaDuration(context: Context?, uriOfFile: Uri?): Int {
        val mp = MediaPlayer.create(context, uriOfFile)
        return mp?.duration ?: 0
    }

    fun getFileDuration(context: Context, path: String): String? {
        var result: String? = null;
        var retriever: MediaMetadataRetriever? = null;
        var inputStream: FileInputStream? = null;
        val file = File(path)
        try {
            retriever = MediaMetadataRetriever()
            inputStream = FileInputStream(file.absolutePath);
            retriever.setDataSource(inputStream.fd);
            val time =
                (retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION))!!.toLong();
            val timeInmillisec = time
            val duration = timeInmillisec / 1000
            val hours = duration / 3600
            val minutes = (duration - hours * 3600) / 60
            val seconds = duration - (hours * 3600 + minutes * 60)
            val timeString: String
            timeString = if (hours > 0) {
                String.format("%02d:%02d:%02d", hours, minutes, seconds)
            } else {
                String.format("%02d:%02d", minutes, seconds)
            }
            result = timeString
            return timeString

        } catch (e: FileNotFoundException) {
            e.printStackTrace();
        } catch (e: IOException) {
            e.printStackTrace();
        } catch (e: RuntimeException) {
            e.printStackTrace();
        } finally {
            retriever?.release()
            inputStream?.close()
        }
        return result;
    }

    fun customImageIcon(name: String?, colorUser: String): Bitmap? {
//        String array[] = name.split(" ");
//        if (array.length == 1) {
//            String fname = array[0];
//            name = String.valueOf(fname.charAt(0));
//        } else {
//            String fname = array[0];
//            String lname = array[1];
//            name = String.valueOf(fname.charAt(0)) + String.valueOf(lname.charAt(0));
//        }
        val _name = getAbbreviation(name!!)
        val color = "#26$colorUser"
        val drawable: Drawable = TextDrawable.builder()
            .beginConfig()
            .width(36)
            .height(36)
            .textColor(Color.parseColor("#$colorUser"))
            .useFont(Typeface.DEFAULT)
            .fontSize(16) /* size in px */
            .toUpperCase()
            .endConfig()
            .buildRound(_name, Color.parseColor(color))
        return drawableToBitmap(drawable)
    }

    /**
     * Returns a drawable for the given name and avatar color.
     *
     * @param name The name to use for the drawable.
     * @param colorss The avatar color to use for the drawable.
     * @return A drawable for the given name and avatar color.
     */
    @JvmStatic
    fun getNameDrawable(name: String?, colorss: AvatarColor): Drawable {
        val targetSize =
            appContext!!.resources.getDimensionPixelSize(R.dimen.contact_photo_target_size)
        val character = getAbbreviation(name!!)

        // Check if the character is not null
        if (character != null) {
            val file = File(MainApp.imagesPathConv + "/" + character + colorss.serialize() + ".jpg")
            // Check if the file exists
            if (file.exists()) {
                val d = Drawable.createFromPath(file.path)
                return d!!
            }
            val foregroundColor = getForegroundColor(colorss)
            val avatar = Avatar.Text(
                character.uppercase(Locale.getDefault()),
                Avatars.ColorPair(colorss, foregroundColor),
                Avatar.DatabaseId.DoNotPersist
            )
            val foreground = createTextDrawable(appContext!!, avatar, false, targetSize, false)
            val background = ContextCompat.getDrawable(appContext!!, R.drawable.circle_tintable)!!
            background.setColorFilter(colorss.colorInt(), PorterDuff.Mode.SRC_ATOP)

            return geSingleDrawable(
                LayerDrawable(arrayOf(background, foreground)),
                character,
                colorss
            )
        }
        return AndroidUtil.getDrawable(R.drawable.ic_unknown)!!
    }

    fun geSingleDrawable(
        layerDrawable: LayerDrawable,
        character: String,
        colorss: AvatarColor
    ): Drawable {
        val resourceBitmapHeight = 136
        val resourceBitmapWidth = 153
        val widthInInches = 0.9f
        val widthInPixels =
            (widthInInches * AndroidUtil.getResources().displayMetrics.densityDpi).toInt()
        val heightInPixels = (widthInPixels * resourceBitmapHeight / resourceBitmapWidth)
        val insetLeft = 10
        val insetTop = 10
        val insetRight = 10
        val insetBottom = 10
        layerDrawable.setLayerInset(1, insetLeft, insetTop, insetRight, insetBottom)
        val bitmap = Bitmap.createBitmap(widthInPixels, heightInPixels, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        layerDrawable.setBounds(0, 0, widthInPixels, heightInPixels)
        layerDrawable.draw(canvas)
        val bitmapDrawable = BitmapDrawable(AndroidUtil.getResources(), bitmap)
        bitmapDrawable.setBounds(0, 0, widthInPixels, heightInPixels)
        val fname = "${character + colorss.serialize()}.jpg"
        val file = File(MainApp.imagesPathConv, fname)
        if (file.exists()) {
            file.delete()
        }
        try {
            val out = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
            out.flush()
            out.close()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return bitmapDrawable
    }

    fun drawableToBitmap(drawable: Drawable): Bitmap? {
        var bitmap: Bitmap? = null
        if (drawable is BitmapDrawable) {
            val bitmapDrawable = drawable
            if (bitmapDrawable.bitmap != null) {
                return bitmapDrawable.bitmap
            }
        }
        bitmap = if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            Bitmap.createBitmap(
                1,
                1,
                Bitmap.Config.ARGB_8888
            ) // Single color bitmap will be created of 1x1 pixel
        } else {
            Bitmap.createBitmap(
                drawable.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
        }
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            appContext!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }


//    @Throws(InterruptedException::class, IOException::class)
//    fun isConnected(): Boolean {
//        val baseUrl = getString(R.string.development)
//        val command = "ping -c 1 $baseUrl"
//        return Runtime.getRuntime().exec(command).waitFor() == 0
//    }

    @Throws(InterruptedException::class, IOException::class, Exception::class)
    fun isConnectedChat(): Boolean {
        val baseUrl = Configurations.pingDevelopmentUrl
        val command = "ping -c 1 $baseUrl"
        return Runtime.getRuntime().exec(command).waitFor() == 0
    }

    @Throws(InterruptedException::class, IOException::class, Exception::class)
    fun isConnectedKds(): Boolean {
        val baseUrl = Configurations.pingKDSUrl
        val command = "ping -c 1 $baseUrl"
        return Runtime.getRuntime().exec(command).waitFor() == 0
    }

    fun isOnline(): Boolean {
        val runtime = Runtime.getRuntime()
        try {
            val baseUrl = Configurations.baseUrl
            val command = String.format(Locale.ENGLISH, "ping -c 1 int-kds.devbeans.io")
            val ipProcess = runtime.exec(command)
            val exitValue = ipProcess.waitFor()
            Log.e(TAG, "exit value $exitValue")
            return exitValue == 0
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return false
    }

    fun isInternetAvailable(): Boolean {
        try {
            val address: InetAddress = InetAddress.getByName(Configurations.baseUrl)
            return !address.equals("")
        } catch (e: UnknownHostException) {
            // Log error
        }
        return false
    }

    fun getSize(size: Long): String {
        var s = ""
        val kb = (size / 1024).toDouble()
        val mb = kb / 1024
        val gb = mb / 1024
        val tb = gb / 1024
        if (size < 1024L) {
            s = "$size Bytes"
        } else if (size >= 1024 && size < 1024L * 1024) {
            s = String.format("%.1f", kb) + " KB"
        } else if (size >= 1024L * 1024 && size < 1024L * 1024 * 1024) {
            s = String.format("%.1f", mb) + " MB"
        } else if (size >= 1024L * 1024 * 1024 && size < 1024L * 1024 * 1024 * 1024) {
            s = String.format("%.1f", gb) + " GB"
        } else if (size >= 1024L * 1024 * 1024 * 1024) {
            s = String.format("%.1f", tb) + " TB"
        }
        return s
    }

    fun hideSoftKeyBoard(editBox: EditText) {
        val imm = appContext!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editBox.windowToken, 0)
    }

    // code to show soft keyboard
    fun showSoftKeyBoard(editBox: EditText) {
        val inputMethodManager =
            appContext!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        editBox.requestFocus()
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun getDisappearingOptions(i: Long): String {
        var disappearingMsg = ""
        when (i) {
            -1L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._off
            0L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._burn_on_read
            10000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._10_seconds
            30000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._30_seconds
            60000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._1_minute
            300000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._5_minutes
            600000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._10_minutes
            1800000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._30_minutes
            3600000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._1_hour
            7200000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._2_hours
            10800000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._3_hours
            28800000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._8_hours
            43200000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._12_hours
            86400000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._1_day
            432000000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._5_days
            864000000L -> disappearingMsg = Constants.DISAPPEARING_STRINGS._10_days
            else -> {
                disappearingMsg = getDisappearValues(i) ?: ""

            }
        }
        return disappearingMsg
    }

    private fun getDisappearValues(i: Long): String? {
        return TimerUnit.values()
            .find { ((i / 1000) / it.valueMultiplier) < it.maxValue }
            ?.let { timerUnit ->
                when (TimerUnit.values().indexOf(timerUnit)) {
                    0 -> {
                        String.format(
                            "${i / 1000} %s",
                            Constants.DISAPPEARING_STRINGS._seconds
                        )
                    }

                    1 -> {
                        when {
                            (((i / 1000) / 60).toLong() > 0) -> {
                                String.format(
                                    "${(i / 1000) / 60} %s",
                                    Constants.DISAPPEARING_STRINGS._minutes
                                )
                            }

                            else -> {
                                String.format(
                                    "59 %s",
                                    Constants.DISAPPEARING_STRINGS._seconds
                                )
                            }
                        }

                    }

                    2 -> {
                        when {
                            (((i / 1000) / 60) / 60).toLong() > 0 -> {

                                String.format(
                                    "${((i / 1000) / 60) / 60} %s",
                                    Constants.DISAPPEARING_STRINGS._hours
                                )
                            }

                            else -> {
                                String.format(
                                    "59 %s",
                                    Constants.DISAPPEARING_STRINGS._minutes
                                )
                            }
                        }
                    }

                    3 -> {
                        when {

                            ((((i / 1000) / 60) / 60) / 24).toLong() > 0 -> {
                                String.format(
                                    "${((((i / 1000) / 60) / 60) / 24)} %s",
                                    Constants.DISAPPEARING_STRINGS._days
                                )
                            }

                            else -> {
                                String.format(
                                    "23 %s",
                                    Constants.DISAPPEARING_STRINGS._hours
                                )
                            }

                        }


                    }

                    4 -> {
                        when {
                            ((((i / 1000) / 60) / 60) / 24).toLong() > 0 -> {
                                String.format(
                                    "${((((i / 1000) / 60) / 60) / 24)} %s",
                                    Constants.DISAPPEARING_STRINGS._days
                                )
                            }

                            else -> {
                                String.format(
                                    "30 %s",
                                    Constants.DISAPPEARING_STRINGS._days
                                )
                            }
                        }
                    }

                    5 -> {
                        String.format(
                            "30 %s",
                            Constants.DISAPPEARING_STRINGS._days
                        )

                    }

                    else -> {
                        ""
                        //was essential exhausative
                    }
                }

            }
    }

    fun getDisappearingTime(timer: Int): String {
        var disappearingMsg = ""
        var index: Int? = null
        if (timer == null || timer == 0) {
            return ""
        }

        TimerUnit.values()
            .find { (timer / it.valueMultiplier) < it.maxValue }
            ?.let { timerUnit ->
                index = TimerUnit.values().indexOf(timerUnit)
            }

        when (index) {
            10000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._10_seconds
            30000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._30_seconds
            60000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._1_minute
            300000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._5_minutes
            600000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._10_minutes
            1800000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._30_minutes
            3600000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._1_hour
            7200000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._2_hours
            10800000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._3_hours
            28800000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._8_hours
            43200000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._12_hours
            86400000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._1_day
            432000000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._5_days
            864000000 -> disappearingMsg = Constants.DISAPPEARING_STRINGS._10_days
        }
        return disappearingMsg
    }

    fun getDisappearingOptionsString(i: String?): Long {
        var disappearingMsg: Long = -1
        return i!!.toLong()
    }

    fun getKeepChatOptions(i: Int): String? {
        var disappearingMsg = ""
        when (i) {
            -1 -> disappearingMsg = AndroidUtil.getString(R.string.off)
            0 -> disappearingMsg = AndroidUtil.getString(R.string.off)
            1 -> disappearingMsg = AndroidUtil.getString(R.string._1_day)
            30 -> disappearingMsg = AndroidUtil.getString(R.string._30_day)
            60 -> disappearingMsg = AndroidUtil.getString(R.string._60_day)
            90 -> disappearingMsg = AndroidUtil.getString(R.string._90_day)
        }
        return disappearingMsg
    }

    enum class TimerUnit(val minValue: Int, val maxValue: Int, val valueMultiplier: Long) {
        SECONDS(1, 59, TimeUnit.SECONDS.toSeconds(1)),
        MINUTES(1, 59, TimeUnit.MINUTES.toSeconds(1)),
        HOURS(1, 23, TimeUnit.HOURS.toSeconds(1)),
        DAYS(1, 6, TimeUnit.DAYS.toSeconds(1)),
        WEEKS(1, 4, TimeUnit.DAYS.toSeconds(7)),
        MONTH(1, 30, TimeUnit.DAYS.toSeconds(30));

        companion object {
            fun get(value: Int) = values()[value]
        }
    }

    @Throws(java.lang.Exception::class)
    fun getHash(stringToConvert: String): String? {
        return ls.toHexStr(stringToConvert.toByteArray(StandardCharsets.UTF_8))
    }


    fun checkMediaPayload(type: String?): Boolean {
        return (type != null && !(type.equals(
            Constants.TYPES.FILE, ignoreCase = true
        ) || type.equals(
            Constants.TYPES.AUDIO, ignoreCase = true
        ) || type.equals(
            Constants.TYPES.VIDEO, ignoreCase = true
        ) || type.equals(
            Constants.TYPES.IMAGE, ignoreCase = true
        )))
    }

    fun checkChatServerConnected(network: NetworkCallback) {

        if (!checkChat) {
            checkChat = true
            NetworkCheck.apis().connect(Configurations.baseUrl)
                .enqueue(object :
                    Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        checkChat = false
                        network.onResponse(response.isSuccessful)
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        checkChat = false
                        network.onResponse(false)

                    }

                })
        }
    }

    var checkKds = false
    var checkChat = false
    var check = false
    fun checkKDSServerConnected(network: NetworkCallback) {

        if (!checkKds) {
            checkKds = true
            NetworkCheck.apis().connect(Configurations.kDSBaseUrl).enqueue(object :
                Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    checkKds = false

                    network.onResponse(response.isSuccessful)
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                    checkKds = false
                    Log.e(TAG, "Error $t message ${t.message}")
                    network.onResponse(false)

                }

            })
        }
    }


    fun checkServerConnected(network: NetworkCallback) {

        Log.e(TAG, "Error")
        check = true
        NetworkCheckCA.apis().connect(AndroidUtil.getString(R.string.network_check))
            .enqueue(object :
                Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    check = false

                    network.onResponse(response.isSuccessful)
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                    check = false
                    Log.e(TAG, "Error $t message ${t.message}")
                    network.onResponse(false)

                }

            })

    }

    fun userID(userName: String): Int {
        var testUserID = "0"
        try {
            val p = Runtime.getRuntime().exec("pm list users")
            p.waitFor()
            val reader = BufferedReader(InputStreamReader(p.inputStream))
            var line = ""
            while (reader.readLine().also { line = it } != null) {
                if (line.contains(userName.trim { it <= ' ' })) {
                    val userid = line.split(":").toTypedArray()
                    val userids = line.split("\\{").toTypedArray()
                    val idstr = userids[1].split(":").toTypedArray()
                    testUserID = idstr[0]
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            testUserID = "0"
        }
        return testUserID.toInt()
    }

    private fun isCurrentUserOwner(context: Context): Boolean {
        return try {
            val getUserHandle: Method = UserManager::class.java.getMethod("getUserHandle")
            val userHandle =
                getUserHandle.invoke(context.getSystemService(Context.USER_SERVICE)) as Int
            userHandle == 0
        } catch (ex: java.lang.Exception) {
            false
        }
    }

    //check if the current user is not owner
    fun checkUser(context: Context): Boolean =
        userID(if (isCurrentUserOwner(context)) "owner" else "private") != 0

    fun checkContactNull(memberID: String?): Contact? {
        return if (memberID != null) appContext!!.contactsDao
            .getContact(memberID) else null
    }

    /**
     * Sends all offline acknowledgements from the database.
     */
    fun sendOfflineAcknowledgements() {
        try {
            val handler = CoroutineExceptionHandler { _, exception ->
                Log.e(TAG, "CoroutineExceptionHandler got $exception")
            }
            val ackList = appContext?.offlineAckDao?.getAllAck()

            // Check if there are any offline acknowledgements to send and if the user's subscription has not expired
            if (!ackList.isNullOrEmpty() && !isSubscriptionExpired()) {
                ackList.forEach { offlineAck ->
                    CoroutineScope(Dispatchers.IO).launch(handler) {
                        delay(1000L)
                        // Send the offline acknowledgement
                        EncryptionUtils.sendOfflineAcks(offlineAck.payload!!)
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("TAG", "Exception ${e.message}")
        }
    }

    fun isSubscriptionExpired(): Boolean {
        return when (SettingsValues.getSubscriptionEndSet()) {
            true -> {

                true
            }

            false -> {

                false
            }
        }
    }

    fun isSubscriptionGrace(): Boolean {
        return when (SettingsValues.getSubscriptionGraceSet()) {
            true -> {

                true
            }

            false -> {

                false
            }
        }
    }

    fun showSubscriptionEnd() {
        try {
            Notify.Toast(AndroidUtil.getString(R.string.subscription_ended))
        } catch (e: Exception) {
            Log.e(TAG, "Error in showing Toast $e")
        }
    }

    fun dismiss() {
        try {
            ThreadUtil.runOnMain {

                expirytoolTip?.dismiss()
                if (expirytoolTipList.isNotEmpty()) {
                    expirytoolTipList.forEach { tooltip ->
                        try {
                            tooltip.dismiss()
                            expirytoolTipList.remove(tooltip)
                        } catch (e: Exception) {
                            Log.e(TAG, "Exception in tooltip removing $e")
                        }

                    }
                    expirytoolTipList.clear()
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception $e")
        }
    }

    fun showSubscriptionBanner(textView: TextView?) {
        try {
            ThreadUtil.runOnMain {
                textView?.let { it ->
                    it.setTextColor(AndroidUtil.getColor(R.color.deep_black))
                    if (isSubscriptionExpired() || isSubscriptionGrace()) {
                        if (it.visibility != View.VISIBLE)
                            it.visibility = View.VISIBLE

                        it.text = AndroidUtil.getString(
                            when {
                                isSubscriptionExpired() -> {
                                    R.string.subscription_ended
                                }

                                isSubscriptionGrace() -> {
                                    R.string.subscription_grace
                                }

                                else -> {
                                    R.string.subscription_grace
                                }
                            }
                        )

                        it.setBackgroundColor(
                            AndroidUtil.getColor(
                                when {
                                    isSubscriptionExpired() -> {
                                        R.color.dark_red
                                    }

                                    isSubscriptionGrace() -> {
                                        R.color.orange
                                    }

                                    else -> {
                                        R.color.orange
                                    }
                                }
                            )
                        )
                    } else {
                        it.visibility = View.GONE
//                        dismiss()
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in showing Banner $e")
        }
    }

    fun showSubscriptionBanner(root: View?) {
//        try {
//            ThreadUtil.runOnMain {
//                root?.let {
//                    if (isSubscriptionExpired() || isSubscriptionGrace()) {
//                        expirytoolTip = ExpiryTooltipPopup.forTarget(root)
//                            .setText(if (isSubscriptionExpired()) R.string.subscription_ended else R.string.subscription_grace)
//                            .setBackgroundTint(
//                                ContextCompat.getColor(
//                                    appContext!!,
//                                    if (isSubscriptionExpired()) R.color.dark_red else R.color.orange
//                                )
//                            )
//                            .setTextColor(ContextCompat.getColor(appContext!!, R.color.core_white))
//                            .show(ExpiryTooltipPopup.POSITION_ABOVE)
//                        expirytoolTipList.add(expirytoolTip!!)
//                    } else {
//                        dismiss()
//                    }
//                }
//            }
//        } catch (e: Exception) {
//            Log.e(TAG, "Error in showing Banner $e")
//        }
    }

    fun sendPing() {
        try {
            val encryptedPaulod = EncryptedPayload()
            encryptedPaulod.fake = Constants.TYPES.PING
            gson.toJson(encryptedPaulod)
            MainActivity.webSocket?.send(gson.toJson(encryptedPaulod))
        } catch (e: Exception) {
            Log.e(TAG, "Sending Ping error $e")
        }
    }

    fun sendOfflineMessages() {
        try {
            Handler().postDelayed({
                val offlineMessages = appContext!!.offlineMessagesDao.allMessages
                if (!offlineMessages.isNullOrEmpty()) {
                    val sentMessages: MutableList<OfflineMessage> = ArrayList()
                    if (MainActivity.isSocketConnected.value != null && MainActivity.isSocketConnected.value!!) {
                        val gson = Gson()
                        offlineMessages.forEach { messages ->
                            sentMessages.add(messages)
                            val payload =
                                appContext?.messagesDao?.getMessage(messages.messageId)
                            //                            String createdAtTime = payload.getCreatedAt();
                            //                            payload.setCreatedAt(DateTime.INSTANCE.getCurrentDateTime());
                            payload?.let {
                                payload.status = Constants.SENT
                                appContext?.messagesDao?.updateMessage(payload)
                                ThreadUtil.runOnMain {
                                    ChatActivity.getInstance()!!.updateMessage(payload)
                                }
                            }
                            Handler().postDelayed({
                                sendPayload(payload)
                            }, 300)
                        }
                        if (sentMessages.isNotEmpty()) {
                            appContext!!.offlineMessagesDao.delete(sentMessages)
                        }
                    }
                }
            }, 3 * 1000)
        } catch (e: Exception) {
            Log.e(TAG, "Exception i sending offline message $e")
        }
    }

    private fun sendPayload(payload: Payload?) {
        payload?.let {
            try {
                EncryptionUtils.encryptMessage(payload.data, payload, null)
            } catch (e: Exception) {
                Log.e(TAG, "Exception in sending with channel $e")
            }
            //                                    String encPayload = EncryptionUtils.INSTANCE.encryptOfflinePayload(messages);
            //                                    MainActivity.webSocket.send(encPayload);
        }
    }

    fun handleFileDelete(tag: String, deleted: Boolean) {
        if (deleted) {
            Log.e(tag, "File Deleted")
        }

    }

    fun checkPayloadRead(payload: Payload): Boolean {
        return SettingsValues.getMessageReadReceipts() && payload.readReceipts
    }


    fun fadeOutDrawable(v: View) {
        v.animate().alpha(0.1f)
    }

    fun fadeInDrawable(v: View) {
        v.animate().alpha(1f).setDuration(150L).start()
    }

    fun fadeInTV(v: View) {
        v.animate().alpha(1f).setDuration(150L).start()
    }

    fun fadeOutTV(v: View) {
        v.animate().alpha(0.4f)
    }


    fun fadeInNote(v: View) {
        v.animate().alpha(0.5f).setDuration(150L).start()
    }

    fun fadeOutNote(v: View) {
        v.animate().alpha(0.4f)
    }


    fun exportTableDataDownloads(tableName: String, context: Context): Boolean {

        val rows = appContext?.contactsDao?.allContacts!!
        if (rows.isEmpty()) {
            // No data in table
            return false
        }

        var fileCounter = 0
        var uri: Uri
        val dateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        do {
            fileCounter++
            val fileName = if (fileCounter == 1) {
                "${tableName}_${dateFormat.format(Date())}.csv"
            } else {
                "${tableName}_${fileCounter}_${dateFormat.format(Date())}.csv"
            }
            val mimeType = "text/csv"
            val values = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
                put(MediaStore.MediaColumns.RELATIVE_PATH, "Download/Chat")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    put(MediaStore.MediaColumns.IS_PENDING, 1)
                }
            }
            val resolver = context.contentResolver
            uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values)!!
        } while (uri == null)

        try {
            val outputStream: OutputStream = context.contentResolver.openOutputStream(uri)!!
            val writer = outputStream.bufferedWriter()

            // Write timestamp to first line of file
            val timestamp = System.currentTimeMillis()
            writer.write("Exported at: $timestamp")
            writer.newLine()

            // Write header row to file
            val headerRow = rows[0].columnNames.joinToString(",")
            writer.write(headerRow)
            writer.newLine()

            // Write data rows to file
            for (row in rows) {
                val columnValues = listOf(
                    row.id.toString(),
                    row.name,
                    row.chatUserId,
                    row.image,
                    row.color,
                    row.avatarColor?.serialize(),
                    row.alias,
                    row.isBlocked.toString().lowercase(),
                    row.isQrAdded.toString().lowercase()
                )
                val dataRow = columnValues.joinToString(",")
                writer.write(dataRow)
                writer.newLine()
            }

            writer.close()
            outputStream.close()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val values = ContentValues().apply {
                    put(MediaStore.MediaColumns.IS_PENDING, 0)
                }
                context.contentResolver.update(uri, values, null, null)
            } else {
                // Notify the system of the new file so it appears in the Downloads app
                MediaScannerConnection.scanFile(
                    context,
                    arrayOf(uri.toString()),
                    arrayOf("text/csv"),
                    null
                )
            }

            return true

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }


    /**
     * Exports data from the specified database table to a CSV file in the app's internal cache directory.
     *
     * @param tableName The name of the database table to export.
     * @param context The context in which the method is called.
     * @return The exported file, or null if the export failed.
     */
    fun exportTableData(tableName: String, context: Context): File? {

        val rows = appContext?.contactsDao?.allContacts!!
        if (rows.isEmpty()) {
            // No data in table
            return null
        }

        // Generate unique file name based on table name and current date/time
        var fileCounter = 0
        val dateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        var file: File
        do {
            fileCounter++
            val fileName = if (fileCounter == 1) {
                "${tableName}_${dateFormat.format(Date())}.csv"
            } else {
                "${tableName}_${fileCounter}_${dateFormat.format(Date())}.csv"
            }
            file = File(context.cacheDir, fileName)
        } while (file.exists())

        try {
            // Open file output stream for writing
            val outputStream: OutputStream = context.openFileOutput(file.name, Context.MODE_PRIVATE)
            val writer = outputStream.bufferedWriter()

            // Write timestamp to first line of file
            val timestamp = System.currentTimeMillis()
            writer.write("Exported at: $timestamp")
            writer.newLine()

            // Write header row to file
            val headerRow = rows[0].columnNames.joinToString(",")
            writer.write(headerRow)
            writer.newLine()

            // Write data rows to file
            for (row in rows) {
                // Concatenate column values into comma-separated string
                val columnValues = listOf(
                    row.id.toString(),
                    row.name,
                    row.chatUserId,
                    row.image,
                    row.color,
                    row.avatarColor?.serialize(),
                    row.alias,
                    row.isBlocked.toString().lowercase(),
                    row.isQrAdded.toString().lowercase()
                )
                val dataRow = columnValues.joinToString(",")
                writer.write(dataRow)
                writer.newLine()
            }

            // Close writer and output stream
            writer.close()
            outputStream.close()

            return file

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }


    fun importTableData(file: File, dao: ContactsDao): Pair<List<Contact>, List<Contact>> {
        val inputStream = file.inputStream()
        val reader = BufferedReader(InputStreamReader(inputStream))

        // Read and ignore first line (timestamp)
        reader.readLine()

        // Read header row
        val headerRow = reader.readLine()
        val checkColumns = Contact()
        val columnNames = headerRow.split(",")

        // Check if column names match table columns
        if (!columnNames.toSet().equals(checkColumns.columnNames.toSet())) {
            throw IllegalArgumentException("File does not match table columns")
        }

        // Read data rows
        var line: String?
        val existingRows = mutableListOf<Contact>()
        val importedRows = mutableListOf<Contact>()
        while (reader.readLine().also { line = it } != null) {
            val rowValues =
                line!!.split(",").map { if (it.equals("null", ignoreCase = true)) null else it }
            val row = Contact(
                rowValues[1],
                rowValues[2],
                rowValues[3],
                rowValues[4],
                AvatarColor.deserialize(rowValues[5]),
                rowValues[6],
                rowValues[7].toBoolean(),
                rowValues[8].toBoolean()
            )
            val existingRow = dao.getContact(row.chatUserId)

            if (existingRow == null) {
                dao.insert(row)
                importedRows.add(row)
            } else if (existingRow.chatUserId == row.chatUserId) {
                existingRows.add(existingRow)
                importedRows.add(row)
            }
        }

        reader.close()
        return Pair(existingRows, importedRows)
    }


    fun getAllExportedFiles(context: Context): Map<Date, File> {
        val fileDir = context.getExternalFilesDir(null)
        val files = fileDir?.listFiles { dir, name ->
            name.startsWith("Contact_") && name.endsWith(".csv")
        } ?: return emptyMap()

        val dateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)
        val fileMap = mutableMapOf<Date, File>()

        for (file in files) {
            val name = file.nameWithoutExtension
            val dateStr = name.substringAfter("_")
            val date = dateFormat.parse(dateStr)

            if (date != null) {
                fileMap[date] = file
            }
        }

        return fileMap.toSortedMap()
    }


    fun getAllExportedFilesExternal(context: Context): Map<Date, File> {
        val projection = arrayOf(
            MediaStore.Downloads.DISPLAY_NAME,
            MediaStore.Downloads.DATE_MODIFIED,
            MediaStore.Downloads.SIZE
        )

        val selection =
            "${MediaStore.Downloads.DISPLAY_NAME} LIKE 'Contact_%' AND ${MediaStore.Downloads.MIME_TYPE} = 'text/csv'"
        val sortOrder = "${MediaStore.Downloads.DATE_MODIFIED} DESC"

        val cursor = context.contentResolver.query(
            MediaStore.Downloads.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            null,
            sortOrder
        )

        val dateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)
        val fileMap = mutableMapOf<Date, File>()

        cursor?.use {
            val displayNameIndex = it.getColumnIndexOrThrow(MediaStore.Downloads.DISPLAY_NAME)
            val dateModifiedIndex = it.getColumnIndexOrThrow(MediaStore.Downloads.DATE_MODIFIED)
            val sizeIndex = it.getColumnIndexOrThrow(MediaStore.Downloads.SIZE)

            while (it.moveToNext()) {
                val displayName = it.getString(displayNameIndex)
                val dateModified =
                    it.getLong(dateModifiedIndex) * 1000 // Convert seconds to milliseconds
                val size = it.getLong(sizeIndex)

                val name = displayName.substringBeforeLast('.')
                val dateStr = name.substringAfter("_")
                val date = dateFormat.parse(dateStr)

                if (date != null) {
                    val uri = Uri.parse("${MediaStore.Downloads.EXTERNAL_CONTENT_URI}/$displayName")
                    val file = File(context.cacheDir, displayName)

                    try {
                        context.contentResolver.openInputStream(uri)?.use { input ->
                            file.outputStream().use { output ->
                                input.copyTo(output)
                            }
                        }

                        fileMap[date] = file
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }

        return fileMap.toSortedMap()
    }

    fun getAllContactFiles(context: Context): Map<Date, File> {
        val files = mutableMapOf<Date, File>()

        val projection = arrayOf(
            MediaStore.Downloads._ID,
            MediaStore.Downloads.DISPLAY_NAME,
            MediaStore.Downloads.DATE_ADDED,
            MediaStore.Downloads.SIZE,
            MediaStore.Downloads.RELATIVE_PATH
        )

        val selection =
            "${MediaStore.Downloads.DISPLAY_NAME} LIKE 'Contact_%' AND ${MediaStore.Downloads.RELATIVE_PATH} LIKE 'Download/Chat/%'"

        val sortOrder = "${MediaStore.Downloads.DATE_ADDED} DESC"

        context.contentResolver.query(
            MediaStore.Downloads.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            null,
            sortOrder
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Downloads._ID)
            val nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Downloads.DISPLAY_NAME)
            val dateAddedColumn = cursor.getColumnIndexOrThrow(MediaStore.Downloads.DATE_ADDED)
            val sizeColumn = cursor.getColumnIndexOrThrow(MediaStore.Downloads.SIZE)
            val relativePathColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Downloads.RELATIVE_PATH)

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id = cursor.getLong(idColumn)
                    val name = cursor.getString(nameColumn)
                    val dateAdded =
                        cursor.getLong(dateAddedColumn) * 1000 // convert seconds to milliseconds
                    val size = cursor.getLong(sizeColumn)
                    val relativePath = cursor.getString(relativePathColumn)

                    if (name.matches(Regex("^Contact_\\d{8}_\\d{6}\\.csv$"))) {
                        val fileUri =
                            ContentUris.withAppendedId(
                                MediaStore.Downloads.EXTERNAL_CONTENT_URI,
                                id
                            )
                        val existingFile = File(context.cacheDir, name)
                        if (existingFile.exists()) {
                            existingFile.delete()
                        }
                        val file = File(context.cacheDir, name)
                        context.contentResolver.openInputStream(fileUri).use { input ->
                            FileOutputStream(file).use { output ->
                                input?.copyTo(output)
                            }
                        }
                        files[Date(dateAdded)] = file
                    }
                }
            }
        }

        return files.toSortedMap()
    }


    fun deleteFileFromDownloads(context: Context, fileName: String): Boolean {
        val file = File(context.cacheDir, fileName)
        if (file.exists()) {
            file.delete()
        }

        val selection = "${MediaStore.Downloads.DISPLAY_NAME} = ?"
        val selectionArgs = arrayOf(fileName)
        val contentUri = MediaStore.Downloads.EXTERNAL_CONTENT_URI

        val rowsDeleted = context.contentResolver.delete(contentUri, selection, selectionArgs)
        return rowsDeleted > 0
    }


    fun getAllContactFilesSecond(context: Context): Map<Date, File> {
        val files = mutableMapOf<Date, File>()

        // Define the file filter for the "Chat" folder
        val fileFilter = FileFilter { file ->
            file.name.matches(Regex("^Contact_\\d{8}_\\d{6}\\.csv$"))
        }

        // Get a list of all the files in the "Chat" folder that match the filter
        val chatFiles = getChatFiles(fileFilter)

        // Copy each file to the cache directory and add it to the map
        chatFiles.forEach { file ->
            val dateAdded = file.lastModified()
            val existingFile = File(context.cacheDir, file.name)
            if (existingFile.exists()) {
                existingFile.delete()
            }
            val cacheFile = File(context.cacheDir, file.name)
            file.copyTo(cacheFile)
            files[Date(dateAdded)] = cacheFile
        }

        return files.toSortedMap()
    }

    private fun getChatFiles(fileFilter: FileFilter): List<File> {
        val chatFiles = mutableListOf<File>()

        // Get the path to the downloads folder
        val downloadsDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        // Get the path to the "Chat" folder in the downloads directory
        val chatDir = File(downloadsDir, "Chat")

        // If the "Chat" folder does not exist, return an empty list
        if (!chatDir.exists() || !chatDir.isDirectory) {
            return chatFiles
        }

        // Get a list of all the files in the "Chat" folder that match the filter
        val files = chatDir.listFiles(fileFilter)

        if (files != null) {
            // Add each file to the list
            chatFiles.addAll(files)
        }

        return chatFiles
    }

    /**
     * Clears the cache directory of any files with a specific naming pattern.
     *
     * @param context The application context.
     */
    fun clearCacheDir(context: Context) {
        try {
            // Get the cache directory for the application
            val cacheDir = context.cacheDir

            // Ensure the cache directory is not null
            if (cacheDir != null) {
                // Get a list of files in the cache directory
                val cacheFiles = cacheDir.listFiles()

                // Ensure the list of cache files is not null
                if (cacheFiles != null) {
                    // Loop through the list of cache files
                    for (cacheFile in cacheFiles) {
                        // Check if the file matches a specific naming pattern
                        if (cacheFile.name.matches(Regex("^Contact_\\d{8}_\\d{6}\\.csv$"))) {
                            // Delete the file
                            cacheFile.delete()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            // Log any exceptions that occur
            Log.e(TAG, "Cached Files not deleted")
        }
    }


}