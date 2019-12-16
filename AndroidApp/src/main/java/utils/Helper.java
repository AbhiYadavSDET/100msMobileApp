package utils;

import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helper {


    static String checksumString;
    static String secretKey;
    static String checksum;
    StringBuffer response;
    HttpURLConnection con = null;
    String contentType = "application/json";
    String responseData = "";
    static URL otpUrl;

    static String otpMid = "MBK5778";
    static String serviceURL = "https://wallet.mobikwik.com/getotpandtokendata/";
    static String serviceCode = "0";


    /**
     * This Method is used to get OTP from DB
     *
     * @param email
     * @param mobile
     * @author manojkumar
     */
    public static String getOTPfromDB(String email, String mobile) throws JSONException {

        return getOTPfromDB(email, mobile, otpMid, serviceURL, serviceCode);
    }

    private static String getOTPfromDB(String email, String mobile, String mid, String url, String servercode) throws JSONException {
        checksumString = "'getotp'";
        String member = "";
        if (!mobile.equals("")) {
            checksumString = checksumString + "'" + mobile + "''" + mid + "'";
            member = "cell=" + mobile;
        } else {
            checksumString = checksumString + "'" + email + "''" + mid + "'";
            member = "email=" + email;
        }
        secretKey = "ju6tygh7u7tdg554k098ujd5468o";
        checksum = calculateCheckSumForService(checksumString, secretKey);
        String param = "";
        if (servercode.isEmpty())
            param = "?" + member + "&action=getotp&checksum=" + checksum + "&mid=" + mid + "&servercode=5";
        else
            param = "?" + member + "&action=getotp&checksum=" + checksum + "&mid=" + mid + "&" + servercode
                    + "&servercode=5";

        String otp = hitGetRequest(url, param);
        return otp;
    }

    private static String hitGetRequest(String url, String paramValues) throws JSONException {
        url = url + paramValues;

        try {
            otpUrl = new URL(url);
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        InputStream otpResponse = null;

        try {
            HttpURLConnection myURLConnection1 = (HttpURLConnection) otpUrl.openConnection();

            myURLConnection1.setRequestMethod("GET");
            otpResponse = myURLConnection1.getInputStream();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(otpResponse);
        String responseBody = scanner.useDelimiter("\\A").next();

        JSONObject otpjo = new JSONObject(responseBody);

        // Setting the values in the Balance Map from Api
        String otp = otpjo.getString("otp");

        return otp;

    }

    private static String calculateCheckSumForService(String input, String secretkey) {
        String mykey = secretkey;
        String test = input;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret = new SecretKeySpec(mykey.getBytes(), "HmacSHA256");
            mac.init(secret);
            byte[] digest = mac.doFinal(test.getBytes());
            String ret = "";
            for (byte b : digest) {
                ret = ret + String.format("%02x", b);
            }
            return ret;
        } catch (Exception e) {
            System.out.println("{\"OTP\":\"NA\",\"ErrorMsg\":\"Failed to calculate checksum\"}");
            return "";
        }
    }

    /**
     * Compare two integer, double or float type values using a generic function.
     *
     * @param what
     * @param expected
     * @param actual
     * @author manojkumar
     */
    public static <T> void compareEquals(AndroidDriver driver, String what, T expected, T actual) {
        if (expected == null & actual == null) {
            Config.logPass(what.toString(), actual.toString());
            return;
        }

        if (actual != null) {
            if (!actual.equals(expected)) {
                Config.logFail(what.toString(), expected.toString(), actual.toString());
            } else {
                Config.logPass(what.toString(), actual.toString());
            }
        } else {
            Config.logFail(what.toString(), expected.toString(), actual.toString());
        }
    }

    /**
     * Compare two string and log as warning if strings are not same
     *
     * @param what
     * @param expected
     * @param actual
     * @author manojkumar
     */
    public static void compareEqualsWithoutFailingTest(AndroidDriver driver, String what, String expected, String actual) {
        if (expected == null & actual == null) {
            Config.logPass(what, actual);
            return;
        }

        if (actual != null) {
            if (!actual.equals(expected)) {
                Config.logWarning(what, expected, actual);
            } else {
                Config.logPass(what, actual);
            }
        } else {
            Config.logWarning(what, expected, actual);
        }
    }


    /**
     * Compare true and log as warning if values are not same
     *
     * @param what
     * @param actual
     * @author manojkumar
     */
    public static void compareTrue(AndroidDriver driver, String what, boolean actual) {
        if (!actual) {
            Config.logFail("Failed to verify " + what);
        } else {
            Config.logPass("Verified " + what);
        }
    }

    /**
     * This method is used to compare a value to false. If the value is false, the test case passes else fails.
     *
     * @param what
     * @param actual
     * @author manojkumar
     */

    public static void compareFalse(AndroidDriver driver, String what, boolean actual) {
        if (!actual) {
            Config.logPass("Verified " + what);
        } else {
            Config.logFail("Failed to verify " + what);

        }
    }


    /**
     * @param what
     * @param expected This value must be value having more than 2 digits after
     *                 decimal
     * @param actual
     * @author manojkumar
     */
    public static void compareValues(AndroidDriver driver, String what, String expected, String actual) {
        if (expected == null & actual == null) {
            Config.logPass(what, actual);
            return;
        }

        if (actual != null) {
            String[] expectedValue = expected.split(".");
            expected = expectedValue[1];
            expected = expected.substring(0, 2);
            String[] actualValue = actual.split(".");
            actual = actualValue[1];
            expected = String.valueOf(expectedValue);
            if (!actual.equals(expected)) {
                Config.logFail(what, expected, actual);
            } else {
                Config.logPass(what, actual);
            }
        } else {
            Config.logFail(what, expected, actual);
        }
    }


    /**
     * Generate a random Alphabets string of given length
     *
     * @param length Length of string to be generated
     * @author manojkumar
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
     * @author manojkumar
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
     * @author manojkumar
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
     * @author manojkumar
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
     * @author manojkumar
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
     * Replaces the arguments like {$someArg} present in input string with its
     * value from RuntimeProperties
     *
     * @param input string in which some Argument is present
     * @return replaced string
     * @author manojkumar
     */
    public static String replaceArgumentsWithRunTimeProperties(String input) {
        if (input.contains("{$")) {
            int index = input.indexOf("{$");
            input.length();
            input.indexOf("}", index + 2);
            String key = input.substring(index + 2, input.indexOf("}", index + 2));
            String value = Config.getRunTimeProperty(key);
            input = input.replace("{$" + key + "}", value);
            return replaceArgumentsWithRunTimeProperties(input);
        } else {
            return input;
        }

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