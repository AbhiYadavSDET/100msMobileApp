package Utils;

import org.testng.Assert;

public class MbkReporter {

    public MbkReporter() {

    }


    public static void verifyTrue(boolean condition, String message, boolean exitOnFailure) {

        try {
            Assert.assertTrue(condition, message);


        } catch (AssertionError e) {
            if (exitOnFailure) {
                throw e;

            } else {
            }

        }
    }


    public static void verifyTrueWithLogging(boolean condition, String message, boolean exitOnFailure) {

        try {
            Assert.assertTrue(condition, message);
            Log.info(Log.ANSI_GREEN + "LOG | PASS | Message : " + message + Log.ANSI_RESET);

        } catch (AssertionError e) {
            if (exitOnFailure) {
                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + message + Log.ANSI_RESET);
                throw e;

            } else {
                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + message + Log.ANSI_RESET);
            }

        }
    }

    public static void verifyEqualsWithLogging(Object actual, Object expected, String message, boolean exitOnFailure) {

        try {
            Assert.assertEquals(actual, expected, message);
            Log.info(Log.ANSI_GREEN + "LOG | PASS | Message : " + message + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);

        } catch (AssertionError e) {
            if (exitOnFailure) {
                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + message + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
                throw e;

            } else {
                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + message + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
            }

        }
    }


}