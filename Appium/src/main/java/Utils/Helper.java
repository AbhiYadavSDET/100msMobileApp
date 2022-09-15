package Utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helper {


    /**
     * Generate a random Alphabets string of given length
     *
     * @param length Length of string to be generated
     * @author parajJain
     */
    public static String generateRandomAlphabetsString(int length) {
        Random rd = new Random();
        String aphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(aphaNumericString.charAt(rd.nextInt(aphaNumericString.length())));
        }

        return sb.toString();
    }

    /**
     * Generate a random Alpha-Numeric string of given length
     *
     * @param length Length of string to be generated
     * @author parajJain
     */
    public static String generateRandomAlphaNumericString(int length) {
        Random rd = new Random();
        String aphaNumericString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(aphaNumericString.charAt(rd.nextInt(aphaNumericString.length())));
        }

        return sb.toString();
    }

    /**
     * Generate a random Special Character string of given length
     *
     * @param length Length of string to be generated
     * @author parajJain
     */

    public static String generateRandomSpecialCharacterString(int length) {
        Random rd = new Random();
        String specialCharString = "~!@#$%^*()_<>?/{}[]|\";";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(specialCharString.charAt(rd.nextInt(specialCharString.length())));
        }

        return sb.toString();
    }

    /**
     * Generate a random decimal number
     *
     * @param lowerBound    lower bound value
     * @param upperBound    Upper bound value
     * @param decimalPlaces decimal points
     * @return an decimal number between that bound upto given decimal points
     * @author parajJain
     */

    public static String generateRandomDecimalValue(int lowerBound, int upperBound, int decimalPlaces) {
        Random random = new Random();
        double dbl;
        dbl = random.nextDouble() * (upperBound - lowerBound) + lowerBound;
        return String.format("%." + decimalPlaces + "f", dbl);

    }

    /**
     * Generate a random number of given length
     *
     * @param length Length of number to be generated
     * @return
     * @author parajJain
     */
    public static long generateRandomNumber(int length) {
        long randomNumber = 1;
        int retryCount = 1;

        // retryCount added for generating specified length's number
        while (retryCount > 0) {
            String strNum = Double.toString(Math.random());
            strNum = strNum.replace(".", "");

            if (strNum.length() > length) {
                strNum = strNum.substring(0, length);
            } else {
                int remainingLength = length - strNum.length() + 1;
                randomNumber = generateRandomNumber(remainingLength);
                strNum = strNum.concat(Long.toString(randomNumber));
            }

            randomNumber = Long.parseLong(strNum);

            if (String.valueOf(randomNumber).length() < length) {
                retryCount++;
            } else {
                retryCount = 0;
            }

        }

        return randomNumber;
    }


    /**
     * This method is used to get current date
     *
     * @param format
     * @return
     * @author manojkumar
     */
    public static String getCurrentDate(String format) {
        // get current date
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * This method is used to get current date and time
     *
     * @param format
     * @return
     * @author manojkumar
     */
    public static String getCurrentDateTime(String format) {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateNow = formatter.format(currentDate.getTime());
        return dateNow;
    }

    /**
     * This method is used to get current time
     *
     * @param format
     * @return
     * @author manojkumar
     */
    public static String getCurrentTime(String format) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String currentTime = formatter.format(cal.getTime());

        return currentTime;
    }

    public static String getDate(int dd, int mm, int yyyy, String format) {
        Calendar date = new GregorianCalendar(yyyy, mm - 1, dd);
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date.getTime());
    }

    /**
     * @param val
     * @return returns a string with the specified Decimal places
     */
    public static String formatString(Double val) {

        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);

        return format.format(val);

    }


}