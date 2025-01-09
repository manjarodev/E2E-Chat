package com.devbeans.io.chat.utils;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.DatePicker;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

//**********************************************************
public class DateTimeUtil
//**********************************************************
{

    public static final String sDateFormat = "MMM dd, yyyy";
    public static final String sTimeFormat = "hh:mm a";
    public static final String sServerTimeFormat = "HH:mm:ss";
    public static final String sDateTimeFormat = "MMM dd, yyyy - hh:mm a";
    public static final String sDateTimeFormatWOss = "dd/MM/yyyy HH:mm";
    public static final String sDateFormatWithDayName = "EEEE, dd MMM, yyyy";
    public static final String sSimpleDateFormat = "MM/dd/yyyy";
    public static final String sMonthYear = "MM/yy";
    public static final String sSimpleDateFormatDash = "MM-dd-yyyy";
    public static final String sSimpleDateFormatDashs = "yyyy-MM-dd";
    public static final String sServerDateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    public static final String sDotNetTimeFormat = "dddd, MMMM dd, yyyy h:mm:ss a";

    //**********************************************************
    public static String format(Date STAMP, String FORMAT)
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat(FORMAT);
        String formattedDate = null;
        try {
            formattedDate = from.format(STAMP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    //**********************************************************
    public static Date format(String dateTime, String foramt)
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat(foramt);
        Date formattedDate = null;
        try {
            formattedDate = from.parse(dateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }


    //**********************************************************
    public static String formatServerDateTime(String timeDate)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(sServerDateTimeFormat);
        try {
            Date date = sdf.parse(timeDate);
            System.out.println(date);
            String your_format = new SimpleDateFormat(sDateTimeFormat).format(date);
            return your_format;
        } catch (ParseException e) {
            //Logger.log(Logger.EXCEPTION, e);
            return timeDate;
        }
    }

    //**********************************************************
    public static String formatSimpleDate(Date date)
    //**********************************************************
    {
        System.out.println(date);
        String your_format = new SimpleDateFormat(sDateTimeFormat).format(date);
        return your_format;
    }

    //**********************************************************
    public static String formatServerDateTime(String dateTime,
                                              String format)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(sServerDateTimeFormat);
        try {
            Date date = sdf.parse(dateTime);
            System.out.println(date);
            String your_format = new SimpleDateFormat(format).format(date);
            return your_format;
        } catch (ParseException e) {
            // Logger.log(Logger.EXCEPTION, e);
            return dateTime;
        }
    }

    //**********************************************************
    public static String formatServerTime(String serverFormat)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(sServerDateTimeFormat);
        try {
            Date date = sdf.parse(serverFormat);
            System.out.println(date);
            String your_format = new SimpleDateFormat(sTimeFormat).format(date);
            return your_format;
        } catch (ParseException e) {
            // Logger.log(Logger.EXCEPTION, e);
            return serverFormat;
        }
    }

    //**********************************************************
    public static String formatServerDate(String value)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(sServerDateTimeFormat);
        try {
            Date date = sdf.parse(value);
            System.out.println(date);
            String your_format = new SimpleDateFormat(sDateFormat).format(date);
            return your_format;
        } catch (ParseException e) {
            // Logger.log(Logger.EXCEPTION, e);
            return value;
        }
    }

    //**********************************************************
    public static String getCurrentDateTime(String formate)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(new Date());
    }

    //**********************************************************
    public static String getCurrentDateTime()
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat(sDateTimeFormat);
        String current = from.format(new Date());
        return current;
    }

    //**********************************************************
    public static String getServerCurrentDateTime()
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat(sServerDateTimeFormat);
        String current = from.format(new Date());
        return current;
    }

    //**********************************************************
    public static String getCurrentDate()
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat(sSimpleDateFormatDashs);
        String current = from.format(new Date());
        return current;
    }


    //**********************************************************
    public static String getCurrentTimeOnly()
    //**********************************************************
    {
        Calendar calendar = Calendar.getInstance();
        java.text.SimpleDateFormat mdformat = new SimpleDateFormat(sTimeFormat);
        return mdformat.format(calendar.getTime());
    }

    //**********************************************************
    public static String getCurrentServerTimeOnly()
    //**********************************************************
    {
        Calendar calendar = Calendar.getInstance();
        java.text.SimpleDateFormat mdformat = new SimpleDateFormat(sServerTimeFormat);
        return mdformat.format(calendar.getTime());
    }

    //**********************************************************
    public static long getTimeDifference(String orderTime)
    //**********************************************************
    {
        java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(getCurrentTimeOnly());
            date2 = simpleDateFormat.parse(orderTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long difference = 0;
        if (date2 != null && date1 != null)
            difference = date2.getTime() - date1.getTime();
        long days = (int) (difference / (1000 * 60 * 60 * 24));
        long hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
        long minutes = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
        return (minutes - 15);
    }

    //**********************************************************
    public static String convert24To12(String STAMP)
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        java.text.SimpleDateFormat to = new SimpleDateFormat(sTimeFormat);
        String formattedDate = null;
        try {
            formattedDate = to.format(from.parse(STAMP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    //**********************************************************
    public static String convert24To12Format(String STAMP)
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        java.text.SimpleDateFormat to = new SimpleDateFormat(sDateFormat);
        String formattedDate = null;
        try {
            formattedDate = to.format(from.parse(STAMP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    //**********************************************************
    public static String getTimeStamp()
    //**********************************************************
    {
        return System.currentTimeMillis() + "";
    }

    //**********************************************************
    public static String getTimeStampForKey()
    //**********************************************************
    {
        return (System.currentTimeMillis() / 1000) + "";
    }

    //**********************************************************
    public static String getFormatedDateTimeString(String STAMP)
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat(sServerDateTimeFormat);
        java.text.SimpleDateFormat to = new SimpleDateFormat(sDateFormat + " " + sTimeFormat);
        Date formattedDate = null;

        try {
            Date date = from.parse(STAMP);
            formattedDate = date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return to.format(formattedDate);
    }

    //**********************************************************
    public static String getFormatedDateTime(String STAMP)
    //**********************************************************
    {
        java.text.SimpleDateFormat from = new SimpleDateFormat(sDateTimeFormat);
        java.text.SimpleDateFormat to = new SimpleDateFormat(sDateFormat + " " + sTimeFormat);
        String formattedDate = null;
        try {
            formattedDate = to.format(from.parse(STAMP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    //**********************************************************
    public static boolean firstIsEqualesSecond(String date1,
                                               String date2)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.sDateFormat);
        Date first = null;
        Date second = null;
        try {
            first = sdf.parse(date1);
            second = sdf.parse(date2);
            return first.equals(second);
        } catch (Exception e) {
            return false;
        }
    }

    //**********************************************************
    public static void showDatePicker(Activity activity,
                                      final datePickerCallback callback)
    //**********************************************************
    {
        int yy;
        int mm;
        int dd;
        final Calendar calendar = Calendar.getInstance();
        yy = calendar.get(Calendar.YEAR);
        mm = calendar.get(Calendar.MONTH);
        dd = calendar.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) -> {
//                java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//                monthOfYear = monthOfYear + 1;
            String d = dayOfMonth + "", m = monthOfYear + "";
            if (String.valueOf(monthOfYear).length() == 1) {
                m = "0" + monthOfYear;
            }
            if (String.valueOf(dayOfMonth).length() == 1) {
                d = "0" + dayOfMonth;
            }
            String date = d + "-" + m + "-" + year;
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.YEAR, year);
            calendar1.set(Calendar.MONTH, Integer.parseInt(m));
            calendar1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(d));

            if (callback != null)
                callback.onSelected(sdf.format(calendar1.getTime()));

        }, yy, mm, dd);
        dialog.setOnCancelListener(dialog1 -> {
            dialog1.dismiss();
            if (callback != null)
                callback.onSelected("");

        });
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.show();
    }

    //**********************************************************
    public static void showDatePickerWithoutLimits(Activity activity,
                                                   final datePickerCallback callback)
    //**********************************************************
    {

        int yy;
        int mm;
        int dd;
        final Calendar calendar = Calendar.getInstance();
        yy = calendar.get(Calendar.YEAR);
        mm = calendar.get(Calendar.MONTH);
        dd = calendar.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) -> {
//                java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//                monthOfYear = monthOfYear + 1;
            String d = dayOfMonth + "", m = monthOfYear + "";
            if (String.valueOf(monthOfYear).length() == 1) {
                m = "0" + monthOfYear;
            }
            if (String.valueOf(dayOfMonth).length() == 1) {
                d = "0" + dayOfMonth;
            }
            String date = d + "-" + m + "-" + year;
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.YEAR, year);
            calendar1.set(Calendar.MONTH, Integer.parseInt(m));
            calendar1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(d));

            if (callback != null)
                callback.onSelected(sdf.format(calendar1.getTime()));

        }, yy, mm, dd);
        dialog.setOnCancelListener(dialog1 -> {
            dialog1.dismiss();
            if (callback != null)
                callback.onSelected("");

        });
//        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.show();
    }

    //**********************************************************
    public static void showDatePickerWithNoFutureDates(Activity activity,
                                                       final datePickerCallback callback)
    //**********************************************************
    {
        int yy;
        int mm;
        int dd;
        final Calendar calendar = Calendar.getInstance();
        yy = calendar.get(Calendar.YEAR);
        mm = calendar.get(Calendar.MONTH);
        dd = calendar.get(Calendar.DATE);


        DatePickerDialog dialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

            //**********************************************************
            @Override
            public void onDateSet(DatePicker view,
                                  int year,
                                  int monthOfYear,
                                  int dayOfMonth)
            //**********************************************************
            {
//                java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
                java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//                monthOfYear = monthOfYear + 1;
                String d = dayOfMonth + "", m = monthOfYear + "";
                if (String.valueOf(monthOfYear).length() == 1) {
                    m = "0" + monthOfYear;
                }
                if (String.valueOf(dayOfMonth).length() == 1) {
                    d = "0" + dayOfMonth;
                }
                String date = d + "-" + m + "-" + year;
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, Integer.parseInt(m));
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(d));

                if (callback != null)
                    callback.onSelected(sdf.format(calendar.getTime()));

            }
        }, yy, mm, dd);
        dialog.setOnCancelListener(dialog1 -> {
            dialog1.dismiss();
            if (callback != null)
                callback.onSelected("");

        });
        dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        dialog.show();
    }


    //**********************************************************
    public static void showDatePickerWithLimit(Activity activity,
                                               final datePickerCallback callback,
                                               boolean maxLimit,
                                               boolean minLimit)
    //**********************************************************
    {
        int yy;
        int mm;
        int dd;
        final Calendar calendar = Calendar.getInstance();
        yy = calendar.get(Calendar.YEAR);
        mm = calendar.get(Calendar.MONTH);
        dd = calendar.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) -> {

            monthOfYear = monthOfYear + 1;
            String d = dayOfMonth + "", m = monthOfYear + "";
            if (String.valueOf(monthOfYear).length() == 1) {
                m = "0" + monthOfYear;
            }
            if (String.valueOf(dayOfMonth).length() == 1) {
                d = "0" + dayOfMonth;
            }
            if (callback != null)
                callback.onSelected(m + "-" + d + "-" + year);

        }, yy, mm, dd);
        dialog.setOnCancelListener(dialog1 -> {
            dialog1.dismiss();
            if (callback != null)
                callback.onSelected("");

        });
        if (maxLimit == true) {
            dialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
        } else if (minLimit == true) {
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            dialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        }
        dialog.show();
    }

    //**********************************************************
    public static void showMonthYearPicker(Activity activity,
                                           final datePickerCallback callback)
    //**********************************************************
    {
        int yy;
        int mm;
        int dd;

        final Calendar calendar = Calendar.getInstance();
        yy = calendar.get(Calendar.YEAR);
        mm = calendar.get(Calendar.MONTH);
        dd = calendar.get(Calendar.DATE);
        DatePickerDialog dialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) -> {

            monthOfYear = monthOfYear + 1;
            String d = dayOfMonth + "", m = monthOfYear + "";
            if (monthOfYear + "".length() == 1) {
                m = "0" + monthOfYear;
            }
            if (dayOfMonth + "".length() == 1) {
                d = "0" + dayOfMonth;
            }
            if (callback != null)
                callback.onSelected(m + "/" + year);

        }, yy, mm, dd);
        int day = activity.getResources().getIdentifier("android:id/day", null, null);
        if (day != 0) {
            View dayPicker = dialog.getDatePicker().findViewById(day);
            if (dayPicker != null) {
                dayPicker.setVisibility(View.GONE);
            }
        }
        dialog.setOnCancelListener(dialog1 -> {
            dialog1.dismiss();
            if (callback != null)
                callback.onSelected("");

        });
        dialog.show();
    }



    //**********************************************************
    public static Calendar convertBaseTimeToCalender(String stamp)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(sServerDateTimeFormat);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(sdf.parse(stamp).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    //**********************************************************
    public static Calendar convertToCalender(String formatIn,
                                             String stamp)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(formatIn);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(sdf.parse(stamp).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    //**********************************************************
    public static Calendar convertBaseTimeToCalenderDefaultTimeZone(String stamp)
    //**********************************************************
    {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(sServerDateTimeFormat);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(sdf.parse(stamp).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    //**********************************************************
    public static String calculateHoursMinutesFrom(Calendar start, Calendar end)
    //**********************************************************
    {
        long difference = (end.getTimeInMillis() - start.getTimeInMillis()) / 1000;
        int hours = (int) difference / 3600;
        difference = difference % 3600;
        int minuts = (int) difference / 60;
        int seconds = (int) difference % 60;
        if (hours > 0) {
            return hours + "h " + minuts + "m " + seconds + "s";
        } else if (minuts == 0) {
            return seconds + " sec";
        } else if (minuts == 1) {
            return minuts + " min " + seconds + " sec";
        } else if (minuts > 1) {
            return minuts + " mins " + seconds + " sec";
        } else {
            return "0 min";
        }
    }

    //**********************************************************
    public static String addMinutes(String format, Integer prepTime)
    //**********************************************************
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, prepTime);
        return DateTimeUtil.format(calendar.getTime(), format);
    }

    //**********************************************************
    public static String getMonthForInt(int num)
    //**********************************************************
    {
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11) {
            month = months[num];
        }
        return month;
    }

    //**********************************************************
    public static String formateDateFromstring(String inputFormat,
                                               String outputFormat,
                                               String inputDate)
    //**********************************************************
    {

        Date parsed = null;
        String outputDate = "";

        java.text.SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, Locale.getDefault());
        java.text.SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
//            LOGE(TAG, "ParseException - dateFormat");
        }

        return outputDate;

    }

    //**********************************************************
    public interface datePickerCallback
            //**********************************************************
    {
        void onSelected(String date);
    }

    //**********************************************************
    public interface timePickerCallback
            //**********************************************************
    {
        void onSelectedTime(String time);
    }

    public static String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        return finalTimerString;
    }

    public static String convertSecondsToHMmSs(long seconds) {
        return String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(seconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(seconds)), TimeUnit.MILLISECONDS.toSeconds(seconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(seconds)));
//        String hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toHours(seconds),
//                TimeUnit.MILLISECONDS.toMinutes(seconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(seconds)),
//                TimeUnit.MILLISECONDS.toSeconds(seconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(seconds)));
//        return hms;

    }

}
