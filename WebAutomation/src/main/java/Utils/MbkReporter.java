package Utils;

import org.testng.Assert;

import java.io.IOException;

public class MbkReporter {

    public boolean testCaseStatus = true;

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
            Config.logComment(Log.ANSI_GREEN + "LOG | PASS | Message : " + message + Log.ANSI_RESET);

        } catch (AssertionError e) {
            if (exitOnFailure) {
                Config.logComment(Log.ANSI_RED + "LOG | FAIL | Message : " + message + Log.ANSI_RESET);
                throw e;

            } else {
                Config.logComment(Log.ANSI_RED + "LOG | FAIL | Message : " + message + Log.ANSI_RESET);
            }

        }
    }


    public static void verifyEqualsWithLogging(Object actual, Object expected, String message, boolean exitOnFailure) {

        try {
            Assert.assertEquals(actual, expected, message);
            Config.logComment(Log.ANSI_GREEN + "LOG | PASS | Message : " + message + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);

        } catch (AssertionError e) {
            if (exitOnFailure) {
                Config.logComment(Log.ANSI_RED + "LOG | FAIL | Message : " + message + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
                throw e;

            } else {
                Config.logComment(Log.ANSI_RED + "LOG | FAIL | Message : " + message + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
            }

        }
    }

    public static void verifyTrueWithLoggingExtentReport(boolean condition, String stepname, String details, boolean exitOnFailure) throws IOException {

        try {
            Assert.assertTrue(condition, stepname);
            Log.info(Log.ANSI_GREEN + "LOG | PASS | Message : " + stepname + Log.ANSI_RESET);
            ExtentReport.extentReportDisplay(ExtentReport.Status.PASS, stepname, details);


        } catch (AssertionError e) {
            if (exitOnFailure) {
                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + stepname + Log.ANSI_RESET);
                ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepname, details);
                throw e;

            } else {
                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + stepname + Log.ANSI_RESET);
                ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepname, details);
            }

        }
    }

    public static void verifyEqualsWithLoggingExtentReport(Object actual, Object expected, String stepname, boolean exitOnFailure) throws IOException {

        try {
            Assert.assertEquals(actual, expected, stepname);
            Log.info(Log.ANSI_GREEN + "LOG | PASS | Message : " + stepname + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
            ExtentReport.extentReportDisplay(ExtentReport.Status.PASS, stepname, "Actual : " + actual + " | Expected : " + expected);

        } catch (AssertionError e) {
            if (exitOnFailure) {
                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + stepname + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
                ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepname, "Actual : " + actual + " | Expected : " + expected);
                throw e;

            } else {
                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + stepname + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
                ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepname, "Actual : " + actual + " | Expected : " + expected);

            }

        }
    }


}