package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MbkReporter {

    public boolean testCaseStatus = true;
    Utils.ExtentReport.Reporter reporter;

    public MbkReporter() {
    reporter = new Utils.ExtentReport.Reporter();
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

    public void verifyEqualsExtentReport(Object actual, Object expected, String message, boolean screenshotOnFailure, String stepName) throws IOException {

        Reporter.log("<br>");

        try {
            Assert.assertEquals(actual, expected, message);
            Reporter.log("<Font Color=#008000> PASS </Font>" + message);

            Log.info(Log.ANSI_GREEN + "LOG | PASS | " + stepName + " | " + message + Log.ANSI_RESET);

            reporter.extentReportDisplay("PASS", stepName + " | " + message);


        } catch (AssertionError e) {
            this.testCaseStatus = false;
            if (screenshotOnFailure) {

                Reporter.log("<Font Color=red> FAIL </Font> " + message);


                //String s = screenCaptureExtentReport(directoryName, screenName);
                //Log.info(s);
                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + " | " + message + Log.ANSI_RESET);

                reporter.extentReportDisplay("FAIL", stepName + " | " + message);

            }


        }
    }

    public void verifyTrueExtentReport(boolean condition, String message, boolean screenshotOnFailure, String stepName) throws IOException {

        Reporter.log("<br>");

        try {
            Assert.assertTrue(condition, message);
            Reporter.log("<Font Color=#008000> PASS </Font>" + message);

            Log.info(Log.ANSI_GREEN + "LOG | PASS | " + stepName + " | " + message + Log.ANSI_RESET);

            reporter.extentReportDisplay("PASS", stepName + " | " + message);

        } catch (AssertionError e) {
            this.testCaseStatus = false;
            if (screenshotOnFailure) {

                Reporter.log("<Font Color=red> FAIL </Font> " + message);


                //String s = screenCaptureExtentReport(directoryName, screenName);
                //Log.info(s);
                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + " | " + message + Log.ANSI_RESET);

                reporter.extentReportDisplay("FAIL", stepName + " | " + message);

            }


        }
    }

}