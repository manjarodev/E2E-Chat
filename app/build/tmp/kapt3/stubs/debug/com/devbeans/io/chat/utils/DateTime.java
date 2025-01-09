package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002pqB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 J!\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010%\u00a2\u0006\u0002\u0010&J\u0016\u0010\'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)J\u0012\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004J\u0012\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004J\u0010\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u0010\u00100\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u001a\u00101\u001a\u00020)2\b\u00102\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u0012\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0004J\"\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020 J\u001c\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u0001042\b\u0010;\u001a\u0004\u0018\u00010\u0004J\u001c\u0010$\u001a\u0004\u0018\u0001042\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010\u0004J\u000e\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004J\u0018\u0010@\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004J\u000e\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004J\u000e\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004J\u0010\u0010E\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000104J$\u0010F\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010\u00042\b\u0010H\u001a\u0004\u0018\u00010\u00042\b\u0010I\u001a\u0004\u0018\u00010\u0004J\u0010\u0010J\u001a\u0004\u0018\u00010\u00042\u0006\u0010K\u001a\u00020 J\b\u0010L\u001a\u0004\u0018\u00010\u0004J\b\u0010M\u001a\u0004\u0018\u00010\u0004J\u0010\u0010M\u001a\u00020\u00042\b\u0010N\u001a\u0004\u0018\u00010\u0004J\u0014\u0010O\u001a\u0004\u0018\u0001042\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010P\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004J\u0010\u0010Q\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004J\u0012\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004J\u0012\u0010S\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004J\u0010\u0010T\u001a\u00020 2\b\u0010U\u001a\u0004\u0018\u00010\u0004J\u000e\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020%J\u0010\u0010X\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u0004J\u0010\u0010Z\u001a\u00020 2\b\u0010U\u001a\u0004\u0018\u00010\u0004J\u0010\u0010[\u001a\u0004\u0018\u00010\u00042\u0006\u0010K\u001a\u00020 J\u001e\u0010\\\u001a\u0002072\u0006\u0010]\u001a\u00020 2\u0006\u0010^\u001a\u00020 2\u0006\u0010_\u001a\u00020`J\u001a\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010fJ*\u0010g\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010h\u001a\u0002072\u0006\u0010i\u001a\u000207J\u001a\u0010j\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010fJ\u001a\u0010k\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010fJ\u0018\u0010l\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010fJ\u001a\u0010m\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010nJ\u0006\u0010o\u001a\u000204R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012\u00a8\u0006r"}, d2 = {"Lcom/devbeans/io/chat/utils/DateTime;", "", "()V", "DateFormat", "", "DateFormatWithDayName", "DateTimeFormat", "DateTimeFormatWOss", "DotNetTimeFormat", "MonthYear", "ServerDateTimeFormat", "ServerTimeFormat", "SimpleDateFormat", "SimpleDateFormatDash", "SimpleDateFormatDashs", "TimeFormat", "currentDate", "getCurrentDate", "()Ljava/lang/String;", "currentServerTimeOnly", "getCurrentServerTimeOnly", "currentTimeOnly", "getCurrentTimeOnly", "prevMonthCurrentDate", "getPrevMonthCurrentDate", "serverCurrentDateTime", "getServerCurrentDateTime", "timeStamp", "getTimeStamp", "timeStampForKey", "getTimeStampForKey", "addMilliSeconds", "", "time", "prepTime", "addMinutes", "format", "", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "calculateHoursMinutesFrom", "start", "Ljava/util/Calendar;", "end", "convert24To12", "STAMP", "convert24To12Format", "convertBaseTimeToCalender", "stamp", "convertBaseTimeToCalenderDefaultTimeZone", "convertToCalender", "formatIn", "convertToDate", "Ljava/util/Date;", "date", "firstIsEqualesSecond", "", "date1", "date2", "ExpireTime", "FORMAT", "dateTime", "foramt", "formatServerDate", "value", "formatServerDateTime", "timeDate", "formatServerTime", "serverFormat", "formatServerTimeStamp", "formatSimpleDate", "formateDateFromstring", "inputFormat", "outputFormat", "inputDate", "getConversationTimeStampFromMillis", "milliSeconds", "getCurrentDateMinusOneMinute", "getCurrentDateTime", "formate", "getDateFromString", "getFormatedDateTime", "getFormatedDateTimeString", "getFormattedDateOnly", "getFormattedTimeOnly", "getMessageTimeDifference", "orderTime", "getMonthForInt", "num", "getNextMonthCurrentDate", "dateStr", "getTimeDifference", "getTimeStampFromMillis", "isWithin", "millis", "span", "unit", "Ljava/util/concurrent/TimeUnit;", "showDatePicker", "", "activity", "Landroid/app/Activity;", "callback", "Lcom/devbeans/io/chat/utils/DateTime$datePickerCallback;", "showDatePickerWithLimit", "maxLimit", "minLimit", "showDatePickerWithNoFutureDates", "showDatePickerWithoutLimits", "showMonthYearPicker", "showTimePicker", "Lcom/devbeans/io/chat/utils/DateTime$timePickerCallback;", "stringToDate", "datePickerCallback", "timePickerCallback", "app_debug"})
public final class DateTime {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.DateTime INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DateFormat = "MMM dd, yyyy";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TimeFormat = "hh:mm a";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ServerTimeFormat = "HH:mm:ss";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DateTimeFormat = "MMM dd, yyyy - hh:mm:ss a";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DateTimeFormatWOss = "dd/MM/yyyy HH:mm";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DateFormatWithDayName = "EEEE, dd MMM, yyyy";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SimpleDateFormat = "MM/dd/yyyy";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MonthYear = "MM/yy";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SimpleDateFormatDash = "MM-dd-yyyy";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SimpleDateFormatDashs = "yyyy-MM-dd";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ServerDateTimeFormat = "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DotNetTimeFormat = "dddd, MMMM dd, yyyy h:mm:ss a";
    
    private DateTime() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String format(@org.jetbrains.annotations.Nullable
    java.util.Date STAMP, @org.jetbrains.annotations.Nullable
    java.lang.String FORMAT) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date format(@org.jetbrains.annotations.Nullable
    java.lang.String dateTime, @org.jetbrains.annotations.Nullable
    java.lang.String foramt) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatServerDateTime(@org.jetbrains.annotations.NotNull
    java.lang.String timeDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatSimpleDate(@org.jetbrains.annotations.Nullable
    java.util.Date date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date stringToDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatServerDateTime(@org.jetbrains.annotations.NotNull
    java.lang.String dateTime, @org.jetbrains.annotations.Nullable
    java.lang.String format) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatServerTime(@org.jetbrains.annotations.NotNull
    java.lang.String serverFormat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatServerTimeStamp(@org.jetbrains.annotations.NotNull
    java.lang.String serverFormat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatServerDate(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentDateTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentDateMinusOneMinute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentDateTime(@org.jetbrains.annotations.Nullable
    java.lang.String formate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServerCurrentDateTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrevMonthCurrentDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNextMonthCurrentDate(@org.jetbrains.annotations.Nullable
    java.lang.String dateStr) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentTimeOnly() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentServerTimeOnly() {
        return null;
    }
    
    public final long getTimeDifference(@org.jetbrains.annotations.Nullable
    java.lang.String orderTime) {
        return 0L;
    }
    
    public final long getMessageTimeDifference(@org.jetbrains.annotations.Nullable
    java.lang.String orderTime) {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String convert24To12(@org.jetbrains.annotations.Nullable
    java.lang.String STAMP) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String convert24To12Format(@org.jetbrains.annotations.Nullable
    java.lang.String STAMP) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTimeStamp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTimeStampForKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormatedDateTimeString(@org.jetbrains.annotations.Nullable
    java.lang.String STAMP) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFormatedDateTime(@org.jetbrains.annotations.Nullable
    java.lang.String STAMP) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFormattedTimeOnly(@org.jetbrains.annotations.Nullable
    java.lang.String STAMP) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFormattedDateOnly(@org.jetbrains.annotations.Nullable
    java.lang.String STAMP) {
        return null;
    }
    
    public final boolean firstIsEqualesSecond(@org.jetbrains.annotations.Nullable
    java.lang.String date1, @org.jetbrains.annotations.Nullable
    java.lang.String date2, long ExpireTime) {
        return false;
    }
    
    public final void showDatePicker(@org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.DateTime.datePickerCallback callback) {
    }
    
    public final void showDatePickerWithoutLimits(@org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.DateTime.datePickerCallback callback) {
    }
    
    public final void showDatePickerWithNoFutureDates(@org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.DateTime.datePickerCallback callback) {
    }
    
    public final void showDatePickerWithLimit(@org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.DateTime.datePickerCallback callback, boolean maxLimit, boolean minLimit) {
    }
    
    public final void showMonthYearPicker(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.DateTime.datePickerCallback callback) {
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final java.util.Date getDateFromString(@org.jetbrains.annotations.Nullable
    java.lang.String STAMP) {
        return null;
    }
    
    public final void showTimePicker(@org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.DateTime.timePickerCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar convertBaseTimeToCalender(@org.jetbrains.annotations.Nullable
    java.lang.String stamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar convertToCalender(@org.jetbrains.annotations.Nullable
    java.lang.String formatIn, @org.jetbrains.annotations.Nullable
    java.lang.String stamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar convertBaseTimeToCalenderDefaultTimeZone(@org.jetbrains.annotations.Nullable
    java.lang.String stamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String calculateHoursMinutesFrom(@org.jetbrains.annotations.NotNull
    java.util.Calendar start, @org.jetbrains.annotations.NotNull
    java.util.Calendar end) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String addMinutes(@org.jetbrains.annotations.Nullable
    java.lang.String format, @org.jetbrains.annotations.Nullable
    java.lang.Integer prepTime) {
        return null;
    }
    
    public final long addMilliSeconds(long time, long prepTime) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMonthForInt(int num) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formateDateFromstring(@org.jetbrains.annotations.Nullable
    java.lang.String inputFormat, @org.jetbrains.annotations.Nullable
    java.lang.String outputFormat, @org.jetbrains.annotations.Nullable
    java.lang.String inputDate) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date convertToDate(@org.jetbrains.annotations.Nullable
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTimeStampFromMillis(long milliSeconds) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getConversationTimeStampFromMillis(long milliSeconds) {
        return null;
    }
    
    public final boolean isWithin(long millis, long span, @org.jetbrains.annotations.NotNull
    java.util.concurrent.TimeUnit unit) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/DateTime$datePickerCallback;", "", "onSelected", "", "date", "", "app_debug"})
    public static abstract interface datePickerCallback {
        
        public abstract void onSelected(@org.jetbrains.annotations.Nullable
        java.lang.String date);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/DateTime$timePickerCallback;", "", "onSelectedTime", "", "time", "", "app_debug"})
    public static abstract interface timePickerCallback {
        
        public abstract void onSelectedTime(@org.jetbrains.annotations.Nullable
        java.lang.String time);
    }
}