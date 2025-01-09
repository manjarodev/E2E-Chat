package com.devbeans.io.chat.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateTime {
    const val DateFormat = "MMM dd, yyyy"
    const val TimeFormat = "hh:mm a"
    const val ServerTimeFormat = "HH:mm:ss"
    const val DateTimeFormat = "MMM dd, yyyy - hh:mm:ss a"
    const val DateTimeFormatWOss = "dd/MM/yyyy HH:mm"
    const val DateFormatWithDayName = "EEEE, dd MMM, yyyy"
    const val SimpleDateFormat = "MM/dd/yyyy"
    const val MonthYear = "MM/yy"
    const val SimpleDateFormatDash = "MM-dd-yyyy"
    const val SimpleDateFormatDashs = "yyyy-MM-dd"

    //    public static final String ServerDateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    const val ServerDateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val DotNetTimeFormat = "dddd, MMMM dd, yyyy h:mm:ss a"
    fun format(STAMP: Date?, FORMAT: String?): String? {
        val from = SimpleDateFormat(FORMAT)
        var formattedDate: String? = null
        try {
            formattedDate = from.format(STAMP)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return formattedDate
    }

    fun format(dateTime: String?, foramt: String?): Date? {
        val from = SimpleDateFormat(foramt)
        var formattedDate: Date? = null
        try {
            formattedDate = from.parse(dateTime)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return formattedDate
    }

    fun formatServerDateTime(timeDate: String): String {
        val sdf = SimpleDateFormat(ServerDateTimeFormat)
        return try {
            val date = sdf.parse(timeDate)
            println(date)
            SimpleDateFormat(DateTimeFormat).format(date)
        } catch (e: ParseException) {
            //Logger.log(Logger.EXCEPTION, e);
            timeDate
        }
    }

    fun formatSimpleDate(date: Date?): String {
        println(date)
        return SimpleDateFormat(DateTimeFormat).format(date)
    }

    fun stringToDate(): Date {
//        if(aDate==null) return null;
        val pos = ParsePosition(0)
        val simpledateformat = SimpleDateFormat(ServerDateTimeFormat)
        return simpledateformat.parse(getCurrentDateTime(), pos)
    }

    fun formatServerDateTime(dateTime: String, format: String?): String {
        val sdf = SimpleDateFormat(ServerDateTimeFormat)
        return try {
            val date = sdf.parse(dateTime)
            println(date)
            SimpleDateFormat(format).format(date)
        } catch (e: ParseException) {
            // Logger.log(Logger.EXCEPTION, e);
            dateTime
        }
    }

    fun formatServerTime(serverFormat: String): String {
        val sdf = SimpleDateFormat(ServerDateTimeFormat)
        return try {
            val date = sdf.parse(serverFormat)
            println(date)
            SimpleDateFormat(TimeFormat).format(date)
        } catch (e: ParseException) {
            // Logger.log(Logger.EXCEPTION, e);
            serverFormat
        }
    }

    fun formatServerTimeStamp(serverFormat: String): String {
        val sdf = SimpleDateFormat(ServerDateTimeFormat)
        return try {
            val date = sdf.parse(serverFormat)
            println(date)
            SimpleDateFormat(DateTimeFormat).format(date)
        } catch (e: ParseException) {
            // Logger.log(Logger.EXCEPTION, e);
            serverFormat
        }
    }

    fun formatServerDate(value: String): String {
        val sdf = SimpleDateFormat(ServerDateTimeFormat)
        return try {
            val date = sdf.parse(value)
            println(date)
            SimpleDateFormat(DateFormat).format(date)
        } catch (e: ParseException) {
            // Logger.log(Logger.EXCEPTION, e);
            value
        }
    }

    fun getCurrentDateTime(): String? {
        val from = SimpleDateFormat(ServerDateTimeFormat)
        from.timeZone = TimeZone.getTimeZone("gmt");
        return from.format(Date())
    }

    fun getCurrentDateMinusOneMinute(): String? {
        val from = SimpleDateFormat(ServerDateTimeFormat)
        from.timeZone = TimeZone.getTimeZone("gmt");
        return from.format(Date(System.currentTimeMillis() + (60*60*1000)))
    }


    fun getCurrentDateTime(formate: String?): String {
        val sdf = SimpleDateFormat(formate)
        return sdf.format(Date())
    }

    //    val currentDateTime: String
//        get() {
//            val from = SimpleDateFormat(DateTimeFormat)
//            return from.format(Date())
//        }
    val serverCurrentDateTime: String
        get() {
            val from = SimpleDateFormat(ServerDateTimeFormat)
            return from.format(Date())
        }
    val currentDate: String
        get() {
            val from = SimpleDateFormat(SimpleDateFormatDashs)
            return from.format(Date())
        }
    val prevMonthCurrentDate: String
        get() {
            val from = SimpleDateFormat(SimpleDateFormatDashs)
            val date = Date()
            if (date.month != 1) {
                date.month = date.month - 1
            } else {
                date.month = 12
                date.year = date.year - 1
            }
            return from.format(date)
        }

    fun getNextMonthCurrentDate(dateStr: String?): String {
        val from = SimpleDateFormat(SimpleDateFormatDashs)
        var date: Date? = null
        try {
            date = from.parse(dateStr)
            println(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        if (date!!.month == 12) {
            date.month = 1
            date.year = date.year + 1
        } else {
            date.month = date.month + 1
        }
        return from.format(date)
    }

    val currentTimeOnly: String
        get() {
            val calendar = Calendar.getInstance()
            val mdformat = SimpleDateFormat(TimeFormat)
            return mdformat.format(calendar.time)
        }
    val currentServerTimeOnly: String
        get() {
            val calendar = Calendar.getInstance()
            val mdformat = SimpleDateFormat(ServerTimeFormat)
            return mdformat.format(calendar.time)
        }

    fun getTimeDifference(orderTime: String?): Long {
        val simpleDateFormat = SimpleDateFormat("HH:mm")
        var date1: Date? = null
        var date2: Date? = null
        try {
            date1 = simpleDateFormat.parse(currentTimeOnly)
            date2 = simpleDateFormat.parse(orderTime)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val difference = date2!!.time - date1!!.time
        val days = (difference / (1000 * 60 * 60 * 24)).toInt().toLong()
        val hours = ((difference - 1000 * 60 * 60 * 24 * days) / (1000 * 60 * 60)).toInt().toLong()
        val minutes =
            ((difference - 1000 * 60 * 60 * 24 * days - 1000 * 60 * 60 * hours).toInt() / (1000 * 60)).toLong()
        return minutes - 15
    }

    fun getMessageTimeDifference(orderTime: String?): Long {
        val simpleDateFormat = SimpleDateFormat(DateTimeFormat)
        var date1: Date? = null
        var date2: Date? = null
        try {
            date1 = simpleDateFormat.parse(currentTimeOnly)
            date2 = simpleDateFormat.parse(orderTime)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val difference = date2!!.time - date1!!.time
        val days = (difference / (1000 * 60 * 60 * 24)).toInt().toLong()
        val hours = ((difference - 1000 * 60 * 60 * 24 * days) / (1000 * 60 * 60)).toInt().toLong()
        val minutes =
            ((difference - 1000 * 60 * 60 * 24 * days - 1000 * 60 * 60 * hours).toInt() / (1000 * 60)).toLong()
        return minutes - 15
    }

    fun convert24To12(STAMP: String?): String? {
        val from = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
        val to = SimpleDateFormat(TimeFormat)
        var formattedDate: String? = null
        try {
            formattedDate = to.format(from.parse(STAMP))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return formattedDate
    }

    fun convert24To12Format(STAMP: String?): String? {
        val from = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        val to = SimpleDateFormat(DateFormat)
        var formattedDate: String? = null
        try {
            formattedDate = to.format(from.parse(STAMP))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return formattedDate
    }

    val timeStamp: String
        get() = System.currentTimeMillis().toString() + ""
    val timeStampForKey: String
        get() = (System.currentTimeMillis() / 1000).toString() + ""

    fun getFormatedDateTimeString(STAMP: String?): String {
        val from = SimpleDateFormat(ServerDateTimeFormat)
        val to = SimpleDateFormat(DateFormat + " " + TimeFormat)
        var formattedDate: Date? = null
        try {
            val date = from.parse(STAMP)
            formattedDate = date
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return if (formattedDate != null) to.format(formattedDate) else "null"
    }

    fun getFormatedDateTime(STAMP: String?): String? {
        val from = SimpleDateFormat(DateTimeFormat)
        val to = SimpleDateFormat(DateFormat + " " + TimeFormat)
        var formattedDate: String? = null
        try {
            formattedDate = to.format(from.parse(STAMP))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return formattedDate
    }

    fun getFormattedTimeOnly(STAMP: String?): String? {
        val from = SimpleDateFormat(ServerDateTimeFormat)
        from.timeZone = TimeZone.getTimeZone("gmt");
        val to = SimpleDateFormat(TimeFormat)
        to.timeZone = TimeZone.getDefault();
        var formattedDate: String? = null
        try {
            formattedDate = to.format(from.parse(STAMP))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return formattedDate
    }

    fun getFormattedDateOnly(STAMP: String?): String? {
        val from = SimpleDateFormat(ServerDateTimeFormat)
        val to = SimpleDateFormat(SimpleDateFormat)
        var formattedDate: String? = null
        try {
            formattedDate = to.format(from.parse(STAMP))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return formattedDate
    }

    fun firstIsEqualesSecond(date1: String?, date2: String?, ExpireTime: Long): Boolean {
        val sdf = SimpleDateFormat(DateTimeFormat)
        var first: Date? = null
        var second: Date? = null
        return try {
            first = sdf.parse(date1)
            second = sdf.parse(date2)

//            long time = first.getTime() + ExpireTime;
            val time = addMilliSeconds(first.time, ExpireTime)
            Log.e("TAG", "firstIsEqualesSecond: $time")
            first.time = time
            first.before(second)
        } catch (e: Exception) {
            false
        }
    }

    fun showDatePicker(activity: Activity?, callback: datePickerCallback?) {
        val yy: Int
        val mm: Int
        val dd: Int
        val calendar = Calendar.getInstance()
        yy = calendar[Calendar.YEAR]
        mm = calendar[Calendar.MONTH]
        dd = calendar[Calendar.DATE]
        val dialog = DatePickerDialog(
            activity!!,
            { view, year, monthOfYear, dayOfMonth -> //                java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
                //                monthOfYear = monthOfYear + 1;
                var d = dayOfMonth.toString() + ""
                var m = monthOfYear.toString() + ""
                if (monthOfYear.toString().length == 1) {
                    m = "0$monthOfYear"
                }
                if (dayOfMonth.toString().length == 1) {
                    d = "0$dayOfMonth"
                }
                val date = "$d-$m-$year"
                val calendar = Calendar.getInstance()
                calendar[Calendar.YEAR] = year
                calendar[Calendar.MONTH] = m.toInt()
                calendar[Calendar.DAY_OF_MONTH] = d.toInt()
                callback?.onSelected(sdf.format(calendar.time))
            },
            yy,
            mm,
            dd
        )
        dialog.setOnCancelListener { dialog1: DialogInterface ->
            dialog1.dismiss()
            callback?.onSelected("")
        }
        dialog.datePicker.minDate = System.currentTimeMillis() - 1000
        dialog.show()
    }

    fun showDatePickerWithoutLimits(activity: Activity?, callback: datePickerCallback?) {
        val yy: Int
        val mm: Int
        val dd: Int
        val calendar = Calendar.getInstance()
        yy = calendar[Calendar.YEAR]
        mm = calendar[Calendar.MONTH]
        dd = calendar[Calendar.DATE]
        val dialog = DatePickerDialog(
            activity!!,
            { view, year, monthOfYear, dayOfMonth -> //                java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
                //                monthOfYear = monthOfYear + 1;
                var d = dayOfMonth.toString() + ""
                var m = monthOfYear.toString() + ""
                if (monthOfYear.toString().length == 1) {
                    m = "0$monthOfYear"
                }
                if (dayOfMonth.toString().length == 1) {
                    d = "0$dayOfMonth"
                }
                val date = "$d-$m-$year"
                val calendar = Calendar.getInstance()
                calendar[Calendar.YEAR] = year
                calendar[Calendar.MONTH] = m.toInt()
                calendar[Calendar.DAY_OF_MONTH] = d.toInt()
                callback?.onSelected(sdf.format(calendar.time))
            },
            yy,
            mm,
            dd
        )
        dialog.setOnCancelListener { dialog1: DialogInterface ->
            dialog1.dismiss()
            callback?.onSelected("")
        }
        //        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.show()
    }

    fun showDatePickerWithNoFutureDates(activity: Activity?, callback: datePickerCallback?) {
        val yy: Int
        val mm: Int
        val dd: Int
        val calendar = Calendar.getInstance()
        yy = calendar[Calendar.YEAR]
        mm = calendar[Calendar.MONTH]
        dd = calendar[Calendar.DATE]
        val dialog = DatePickerDialog(
            activity!!,
            { view, year, monthOfYear, dayOfMonth -> //                java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
                //                monthOfYear = monthOfYear + 1;
                var d = dayOfMonth.toString() + ""
                var m = monthOfYear.toString() + ""
                if (monthOfYear.toString().length == 1) {
                    m = "0$monthOfYear"
                }
                if (dayOfMonth.toString().length == 1) {
                    d = "0$dayOfMonth"
                }
                val date = "$d-$m-$year"
                val calendar = Calendar.getInstance()
                calendar[Calendar.YEAR] = year
                calendar[Calendar.MONTH] = m.toInt()
                calendar[Calendar.DAY_OF_MONTH] = d.toInt()
                callback?.onSelected(sdf.format(calendar.time))
            },
            yy,
            mm,
            dd
        )
        dialog.setOnCancelListener { dialog1: DialogInterface ->
            dialog1.dismiss()
            callback?.onSelected("")
        }
        dialog.datePicker.maxDate = System.currentTimeMillis()
        dialog.show()
    }

    fun showDatePickerWithLimit(
        activity: Activity?,
        callback: datePickerCallback?,
        maxLimit: Boolean,
        minLimit: Boolean
    ) {
        val yy: Int
        val mm: Int
        val dd: Int
        val calendar = Calendar.getInstance()
        yy = calendar[Calendar.YEAR]
        mm = calendar[Calendar.MONTH]
        dd = calendar[Calendar.DATE]
        val dialog = DatePickerDialog(
            activity!!,
            { view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val monthOfYear = monthOfYear + 1
                var d = dayOfMonth.toString() + ""
                var m = monthOfYear.toString() + ""
                if (monthOfYear.toString().length == 1) {
                    m = "0$monthOfYear"
                }
                if (dayOfMonth.toString().length == 1) {
                    d = "0$dayOfMonth"
                }
                callback?.onSelected("$m-$d-$year")
            },
            yy,
            mm,
            dd
        )
        dialog.setOnCancelListener { dialog1: DialogInterface ->
            dialog1.dismiss()
            callback?.onSelected("")
        }
        if (maxLimit == true) {
            dialog.datePicker.maxDate = System.currentTimeMillis() - 1000
        } else if (minLimit == true) {
            calendar.add(Calendar.DAY_OF_WEEK, 1)
            dialog.datePicker.minDate = calendar.timeInMillis
        }
        dialog.show()
    }

    fun showMonthYearPicker(activity: Activity, callback: datePickerCallback?) {
        val yy: Int
        val mm: Int
        val dd: Int
        val calendar = Calendar.getInstance()
        yy = calendar[Calendar.YEAR]
        mm = calendar[Calendar.MONTH]
        dd = calendar[Calendar.DATE]
        val dialog = DatePickerDialog(
            activity,
            { view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val monthOfYear = monthOfYear + 1
                var d = dayOfMonth.toString() + ""
                var m = monthOfYear.toString() + ""
                if (monthOfYear + "".length == 1) {
                    m = "0$monthOfYear"
                }
                if (dayOfMonth + "".length == 1) {
                    d = "0$dayOfMonth"
                }
                callback?.onSelected("$m/$year")
            },
            yy,
            mm,
            dd
        )
        val day = activity.resources.getIdentifier("android:id/day", null, null)
        if (day != 0) {
            val dayPicker = dialog.datePicker.findViewById<View>(day)
            if (dayPicker != null) {
                dayPicker.visibility = View.GONE
            }
        }
        dialog.setOnCancelListener { dialog1: DialogInterface ->
            dialog1.dismiss()
            callback?.onSelected("")
        }
        dialog.show()
    }

    @JvmStatic
    fun getDateFromString(STAMP: String?): Date? {
        val sdf = SimpleDateFormat(DateTimeFormat)
        var first: Date? = null
        return try {
            first = sdf.parse(STAMP)
            first
        } catch (ignored: Exception) {
            null
        }
    }

    fun showTimePicker(activity: Activity?, callback: timePickerCallback?) {
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
        val minute = mcurrentTime[Calendar.MINUTE]
        val mTimePicker = TimePickerDialog(
            activity,
            { timePicker: TimePicker?, selectedHour: Int, selectedMinute: Int ->
                val h: String
                val m: String
                h = selectedHour.toString()
                m = selectedMinute.toString()
                if (callback != null) {
                    var am_pm = ""
                    val datetime = Calendar.getInstance()
                    datetime[Calendar.HOUR_OF_DAY] = selectedHour
                    datetime[Calendar.MINUTE] = selectedMinute
                    if (datetime[Calendar.AM_PM] == Calendar.AM) am_pm =
                        "am" else if (datetime[Calendar.AM_PM] == Calendar.PM) am_pm = "pm"
                    var strHrsToShow =
                        if (datetime[Calendar.HOUR] == 0) "12" else datetime[Calendar.HOUR].toString() + ""
                    if (strHrsToShow.length < 2) strHrsToShow = "0$strHrsToShow"
                    var nMinute = datetime[Calendar.MINUTE].toString()
                    if (datetime[Calendar.MINUTE] < 10) {
                        nMinute = "0" + datetime[Calendar.MINUTE]
                    }
                    callback.onSelectedTime("$strHrsToShow:$nMinute $am_pm")
                }
            },
            hour,
            minute,
            android.text.format.DateFormat.is24HourFormat(activity)
        )
        mTimePicker.setOnCancelListener { dialog: DialogInterface ->
            dialog.dismiss()
            callback?.onSelectedTime("")
        }
        mTimePicker.show()
    }

    fun convertBaseTimeToCalender(stamp: String?): Calendar {
        val sdf = SimpleDateFormat(ServerDateTimeFormat)
        val calendar = Calendar.getInstance()
        try {
            calendar.timeInMillis = sdf.parse(stamp).time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return calendar
    }

    fun convertToCalender(formatIn: String?, stamp: String?): Calendar {
        val sdf = SimpleDateFormat(formatIn)
        val calendar = Calendar.getInstance()
        try {
            calendar.timeInMillis = sdf.parse(stamp).time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return calendar
    }

    fun convertBaseTimeToCalenderDefaultTimeZone(stamp: String?): Calendar {
        val sdf = SimpleDateFormat(ServerDateTimeFormat)
        val calendar = Calendar.getInstance()
        try {
            calendar.timeInMillis = sdf.parse(stamp).time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return calendar
    }

    fun calculateHoursMinutesFrom(start: Calendar, end: Calendar): String {
        var difference = (end.timeInMillis - start.timeInMillis) / 1000
        val hours = difference.toInt() / 3600
        difference = difference % 3600
        val minuts = difference.toInt() / 60
        val seconds = difference.toInt() % 60
        return if (hours > 0) {
            hours.toString() + "h " + minuts + "m " + seconds + "s"
        } else if (minuts == 0) {
            "$seconds sec"
        } else if (minuts == 1) {
            "$minuts min $seconds sec"
        } else if (minuts > 1) {
            "$minuts mins $seconds sec"
        } else {
            "0 min"
        }
    }

    fun addMinutes(format: String?, prepTime: Int?): String? {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, prepTime!!)
        return format(calendar.time, format)
    }

    fun addMilliSeconds(time: Long, prepTime: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = time
        calendar.add(Calendar.MILLISECOND, prepTime.toInt())
        return calendar.timeInMillis
    }

    fun getMonthForInt(num: Int): String {
        var month = ""
        val dfs = DateFormatSymbols()
        val months = dfs.months
        if (num >= 0 && num <= 11) {
            month = months[num]
        }
        return month
    }

    fun formateDateFromstring(
        inputFormat: String?,
        outputFormat: String?,
        inputDate: String?
    ): String {
        var parsed: Date? = null
        var outputDate = ""
        val df_input = SimpleDateFormat(inputFormat, Locale.getDefault())
        val df_output = SimpleDateFormat(outputFormat, Locale.getDefault())
        try {
            parsed = df_input.parse(inputDate)
            outputDate = df_output.format(parsed)
        } catch (e: ParseException) {
//            LOGE(TAG, "ParseException - dateFormat");
        }
        return outputDate
    }

    fun convertToDate(date: String?): Date? {
        val dateFormat = SimpleDateFormat(ServerDateTimeFormat)
        var d: Date? = null
        try {
            d = dateFormat.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return d
    }

    fun getTimeStampFromMillis(milliSeconds: Long): String? {
        // Create a DateFormatter object for displaying
        // date in specified format.
        val formatter = SimpleDateFormat(ServerDateTimeFormat)

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }

    fun getConversationTimeStampFromMillis(milliSeconds: Long): String? {
        // Create a DateFormatter object for displaying
        // date in specified format.
        val formatter = SimpleDateFormat(TimeFormat)

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }


    fun isWithin(millis: Long, span: Long, unit: TimeUnit): Boolean {
        return System.currentTimeMillis() - millis <= unit.toMillis(span)
    }

    interface datePickerCallback {
        fun onSelected(date: String?)
    }

    interface timePickerCallback {
        fun onSelectedTime(time: String?)
    }
}