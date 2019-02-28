package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public abstract class DateHelper {
    public DateHelper() {
    }

    public static String getCurrentDate(Utils.DateFormatEnums dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        return simpleDateFormat.format(new Date());
    }

    public static String getDateAterNDays(Utils.DateFormatEnums dateFormat, int daysAfterCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, daysAfterCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateAterNMonths(Utils.DateFormatEnums dateFormat, int monthsAfterCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, monthsAfterCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateAterNMonthsMinusMDays(Utils.DateFormatEnums dateFormat, int monthsAfterCurrentDate, int minusDays) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, monthsAfterCurrentDate);

        calendar.add(5, -minusDays);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateBeforeNYears(Utils.DateFormatEnums dateFormat, int yearsBeforeCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -yearsBeforeCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateBeforeNDays(Utils.DateFormatEnums dateFormat, int daysBeforeCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -daysBeforeCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateBeforeNMonths(Utils.DateFormatEnums dateFormat, int monthsBeforeCurrentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.getValue());
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -monthsBeforeCurrentDate);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDateAterNYears(Utils.DateFormatEnums dateFormat, int yearssAfterCurrentDate) {
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

    public static int getCurrentMonthInteger() {
        return Calendar.getInstance().get(2) + 1;
    }

    public static int getCurrentYearInteger() {
        return Calendar.getInstance().get(1);
    }
}


