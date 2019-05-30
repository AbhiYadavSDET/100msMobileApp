package main.java.utils;

import logger.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public abstract class DateHelper {
    public DateHelper() {
    }

    public static String getCurrentDate(DateFormatEnums dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        return simpleDateFormat.format(new Date());
    }

    public static String getDateAterNDays(DateFormatEnums dateFormat, int daysAfterCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, daysAfterCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateAterNMonths(DateFormatEnums dateFormat, int monthsAfterCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, monthsAfterCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateAterNMonthsMinusMDays(DateFormatEnums dateFormat, int monthsAfterCurrentDate, int minusDays) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, monthsAfterCurrentDate);

        calendar.add(5, -minusDays);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateBeforeNYears(DateFormatEnums dateFormat, int yearsBeforeCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -yearsBeforeCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateBeforeNDays(DateFormatEnums dateFormat, int daysBeforeCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -daysBeforeCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateBeforeNMonths(DateFormatEnums dateFormat, int monthsBeforeCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -monthsBeforeCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateAterNYears(DateFormatEnums dateFormat, int yearssAfterCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, yearssAfterCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateAndTime_Chennai_Kolkata_Mumbai_UTC() throws ParseException {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(date);
    }

    public static String getMonthInStringFromInteger(int month) {

        String monthString;
        switch (month)

        {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "Invalid month";
                break;
        }

        Log.info(monthString);
        return monthString;
    }

    public static int getCurrentMonthInteger() {
        return Calendar.getInstance().get(2) + 1;
    }

    public static int getCurrentYearInteger() {
        return Calendar.getInstance().get(1);
    }
}


