package Utils;

import io.appium.java_client.android.AndroidDriver;
import Logger.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * All the validation methods and method to take screenshot are defined in this
 * class. MobikwikScreen class extends this class.
 */
public class MBReporter {
    public boolean testCaseStatus = true;
    private AndroidDriver driver;
    private File file;
    private String testScreenshotDir;
    private InetAddress ownIP;
    //ExtentReport reporter = new ExtentReport();

    public MBReporter(AndroidDriver driver, String testScreenshotDir) {
        this.driver = driver;
        this.testScreenshotDir = testScreenshotDir;
        file = new File("");

    }

    public MBReporter(AndroidDriver driver) {
        this.driver = driver;
    }

    public String screenShot() {
        String screenshotPath = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new GregorianCalendar().getTime())
                + "screenshot.png";

        System.out.println(screenshotPath);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
//            FileUtils.copyFile(scrFile, new File("screenshots/" + screenshotPath));
            ownIP = InetAddress.getLocalHost();
            System.out.println("IP of my system is := " + ownIP.getHostAddress());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            screenshotPath = "";
        }
        String s = "http://" + ownIP.getHostAddress() + ":80/userContent/screenshot/" + screenshotPath;
        return s;
    }

//    public String screenShot1(String directoryName, String screenname) {
//        String screenshotPath = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new GregorianCalendar().getTime())
//                + "_" + screenname + ".png";
//
//        System.out.println(screenshotPath);
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
////            FileUtils.copyFile(scrFile, new File("screenshots/" + directoryName + "/" + screenshotPath));
//            ownIP = InetAddress.getLocalHost();
//            // System.out.println("IP of my system is := " +
//            // ownIP.getHostAddress());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            screenshotPath = "";
//        }
//        String s = "http://" + ownIP.getHostAddress() + ":80/userContent/screenshot/" + screenshotPath;
//        return screenshotPath;
//    }

    /**
     * method to verify the actual value with expected value
     *
     * @param actual              actual text displayed
     * @param expected            expected text to be displayed
     * @param stepName            message should be displayed on failure of assertion
     * @param screenshotOnFailure pass true if screenshot should be taken on failure else false
     * @param exitOnFailure       pass true if program execution should halt on failure of the
     *                            condition else false
     */

    public void verifyEquals(Object actual, Object expected, String stepName, boolean screenshotOnFailure,
                             boolean exitOnFailure) throws IOException {

        Reporter.log("<br>");

        try {
            Assert.assertEquals(actual, expected, stepName);
            Reporter.log("<Font Color=#008000> PASS </Font>" + stepName + " | Actual : " + actual + " | Expected : " + expected);
            Log.info(Log.ANSI_GREEN + "LOG | PASS | " + stepName + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);


        } catch (AssertionError e) {
            this.testCaseStatus = false;
            if (screenshotOnFailure) {

                String s = screenShot();
                Reporter.log("<a href='" + s + "'> <Font Color=red> FAIL </Font> </a>" + stepName + " | Actual : " + actual + " | Expected : " + expected);
                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);


            } else {

                Reporter.log("<Font Color=red> FAIL </Font> " + stepName + " | Actual : " + actual + " | Expected : " + expected);
                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);


            }

            if (exitOnFailure) {
                Reporter.log("<br>");

                Reporter.log("Exiting this function as exitOnFail flag is set to True. Will move to next test.");

                throw e;

            }

        }
    }


    public void verifyEqualsWithLogging(Object actual, Object expected, String stepName, boolean screenshotOnFailure,
                                        boolean exitOnFailure) throws IOException {
        verifyEqualsWithLogging(actual, expected, stepName, screenshotOnFailure, exitOnFailure, true);
    }

    public void verifyEqualsWithLogging(Object actual, Object expected, String stepName, boolean screenshotOnFailure,
                                        boolean exitOnFailure, boolean logExtentReport) throws IOException {

        Reporter.log("<br>");

        try {
            Assert.assertEquals(actual, expected, stepName);
            Reporter.log("<Font Color=#008000> PASS </Font>" + stepName + " | Actual : " + actual + " | Expected : " + expected);
            Log.info(Log.ANSI_GREEN + "LOG | PASS | " + stepName + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);

            if (logExtentReport) {

                ExtentReport.extentReportDisplay(ExtentReport.Status.PASS, stepName + " | Actual : " + actual + " | Expected : " + expected);


            }

        } catch (AssertionError | IOException e) {
            this.testCaseStatus = false;
            if (screenshotOnFailure) {

                String s = screenShot();
                Reporter.log("<a href='" + s + "'> <Font Color=red> FAIL </Font> </a>" + stepName + " | Actual : " + actual + " | Expected : " + expected);
                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
                if (logExtentReport) {
                    ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepName + " | Actual : " + actual + " | Expected : " + expected, s);
                }


            } else {

                Reporter.log("<Font Color=red> FAIL </Font> " + stepName + " | Actual : " + actual + " | Expected : " + expected);
                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);

                if (logExtentReport) {
                    ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepName + " | Actual : " + actual + " | Expected : " + expected);
                }

            }

            if (exitOnFailure) {
                Reporter.log("<br>");

                Reporter.log("Exiting this function as exitOnFail flag is set to True. Will move to next test.");

                throw e;

            }

        }
    }

    public void verifyTrueWithLogging(boolean condition, String stepName, boolean screenshotOnFailure,
                                      boolean exitOnFailure) throws IOException {
        verifyTrueWithLogging(condition, stepName, screenshotOnFailure, exitOnFailure, true);

    }

    public void verifyTrueWithLogging(boolean condition, String stepName, boolean screenshotOnFailure,
                                      boolean exitOnFailure, boolean logExtentReport) throws IOException {

        Reporter.log("<br>");

        try {
            Assert.assertTrue(condition, stepName);
            Reporter.log("<Font Color=#008000> PASS </Font>" + stepName);
            Log.info(Log.ANSI_GREEN + "LOG | PASS | " + stepName + Log.ANSI_RESET);

            if (logExtentReport) {
                ExtentReport.extentReportDisplay(ExtentReport.Status.PASS, stepName);
            }

        } catch (AssertionError | IOException e) {
            this.testCaseStatus = false;
            if (screenshotOnFailure) {

                String s = screenShot();
                Reporter.log("<a href='" + s + "'> <Font Color=red> FAIL </Font> </a>" + stepName);
                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + Log.ANSI_RESET);

                if (logExtentReport) {
                    ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepName);
                }


            } else {

                Reporter.log("<Font Color=red> FAIL </Font> " + stepName);
                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + Log.ANSI_RESET);

                if (logExtentReport) {
                    ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepName);
                }


            }

            if (exitOnFailure) {
                Reporter.log("<br>");

                Reporter.log("Exiting this function as exitOnFail flag is set to True. Will move to next test.");

                throw e;

            }

        }
    }



//    public String screenCaptureExtentReport(String directoryName, String screenname) {
//        String screenshotPath = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new GregorianCalendar().getTime())
//                + "_" + screenname + ".png";
//
//        //Only for logging --> System.out.println(screenshotPath);
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
////            FileUtils.copyFile(scrFile, new File("screenshots/" + directoryName + "/" + screenshotPath));
//            ownIP = InetAddress.getLocalHost();
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            screenshotPath = "";
//        }
//        String dest = "../../screenshots/" + directoryName + "/" + screenshotPath;
//        return dest;
//    }
//
//    /**
//     * method to verify the actual value with expected value
//     *
//     * @param actual              actual text displayed
//     * @param expected            expected text to be displayed
//     * @param message             message should be displayed on failure of assertion
//     * @param screenshotOnFailure pass true if screenshot should be taken on failure else false
//     * @param exitOnFailure       pass true if program execution should halt on failure of the
//     *                            condition else false
//     */
//    public void verifyEquals(Object actual, Object expected, String message, boolean screenshotOnFailure,
//                             boolean exitOnFailure) {
//
//        Reporter.log("<br>");
//
//        try {
//            Assert.assertEquals(actual, expected, message);
//            Reporter.log("<Font Color=#008000> PASS </Font>" + message);
//
//        } catch (AssertionError e) {
//            this.testCaseStatus = false;
//            if (screenshotOnFailure) {
//
//                Reporter.log("<a href='" + screenShot() + "'> <Font Color=red> FAIL </Font> </a>" + message);
//
//            } else {
//
//                Reporter.log("<Font Color=red> FAIL </Font> " + message);
//
//            }
//
//            if (exitOnFailure) {
//                Reporter.log("<br>");
//
//                Reporter.log("Exiting this function as exitOnFail flag is set to True. Will move to next test.");
//
//                throw e;
//
//            }
//
//        }
//    }
//
//    //Added by MS @22ndJuly,2018 for handling the ExtentReport reports
//
//    /**
//     * This method in created to support the ExtentReport report functionality
//     * In case of assertion failure --> it will take the screen shot
//     */
//    public void verifyEqualsExtentReport(Object actual, Object expected, String message, boolean screenshotOnFailure, String stepName, String directoryName, String screenName) throws IOException {
//
//        Reporter.log("<br>");
//
//        try {
//            Assert.assertEquals(actual, expected, message);
//            Reporter.log("<Font Color=#008000> PASS </Font>" + message);
//
//            Log.info(Log.ANSI_GREEN + "LOG | PASS | " + stepName + " | " + message + Log.ANSI_RESET);
//
//            reporter.extentReportDisplay(ExtentReport.Status.PASS, stepName + " | " + message, "");
//
//
//        } catch (AssertionError e) {
//            this.testCaseStatus = false;
//            if (screenshotOnFailure) {
//
//                Reporter.log("<Font Color=red> FAIL </Font> " + message);
//
//
//                String s = screenCaptureExtentReport(directoryName, screenName);
//                //Log.info(s);
//                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + " | " + message + Log.ANSI_RESET);
//
//                reporter.extentReportDisplay(ExtentReport.Status.FAIL, stepName + " | " + message, s);
//
//            }
//
//
//        }
//    }
//
//    public void verifyTrueExtentReport(boolean condition, String message, boolean screenshotOnFailure, String stepName, String directoryName, String screenName) throws IOException {
//
//        Reporter.log("<br>");
//
//        try {
//            Assert.assertTrue(condition, message);
//            Reporter.log("<Font Color=#008000> PASS </Font>" + message);
//
//            Log.info(Log.ANSI_GREEN + "LOG | PASS | " + stepName + " | " + message + Log.ANSI_RESET);
//
//            reporter.extentReportDisplay(ExtentReport.Status.PASS, stepName + " | " + message, "");
//
//        } catch (AssertionError e) {
//            this.testCaseStatus = false;
//            if (screenshotOnFailure) {
//
//                Reporter.log("<Font Color=red> FAIL </Font> " + message);
//
//
//                String s = screenCaptureExtentReport(directoryName, screenName);
//                //Log.info(s);
//                Log.info(Log.ANSI_RED + "LOG | FAIL | " + stepName + " | " + message + Log.ANSI_RESET);
//
//                reporter.extentReportDisplay(ExtentReport.Status.FAIL, stepName + " | " + message, s);
//
//            }
//
//
//        }
//    }
//
//    public void takeSSOnSuccess(String message, String stepName, String directoryName, String screenName) throws IOException {
//
//
//        String s = screenCaptureExtentReport(directoryName, screenName);
//        //Log.info(s);
//        Log.info("VERIFY", "SS");
//
//        reporter.extentReportDisplay(ExtentReport.Status.INFO, stepName, s);
//
//    }
//
//
//    public void verifyNotEquals(Object actual, Object expected, String message, boolean screenshotOnFailure,
//                                boolean exitOnFailure) {
//
//        Reporter.log("<br>");
//
//        try {
//            Assert.assertNotEquals(actual, expected, message);
//            Reporter.log("<Font Color=#008000> PASS </Font>" + message);
//
//        } catch (AssertionError e) {
//            this.testCaseStatus = false;
//            if (screenshotOnFailure) {
//
//                Reporter.log("<a href='" + screenShot() + "'> <Font Color=red> FAIL </Font> </a>" + message);
//
//            } else {
//
//                Reporter.log("<Font Color=red> FAIL </Font> " + message);
//
//            }
//
//            if (exitOnFailure) {
//                Reporter.log("<br>");
//
//                Reporter.log("Exiting this function as exitOnFail flag is set to True. Will move to next test.");
//
//                throw e;
//
//            }
//
//        }
//    }
//
//    public void verifyTrue(boolean condition, String message, boolean screenshotOnFailure, boolean exitOnFailure) {
//
//        Reporter.log("<br>");
//
//        try {
//            Assert.assertTrue(condition, message);
//            Reporter.log("<Font Color=#008000> PASS </Font>" + message);
//
//        } catch (AssertionError e) {
//            this.testCaseStatus = false;
//            if (screenshotOnFailure) {
//
//                Reporter.log("<a href='" + screenShot() + "'> <Font Color=red> FAIL </Font> </a>" + message);
//
//            } else {
//
//                Reporter.log("<Font Color=red> FAIL </Font> " + message);
//
//            }
//
//            if (exitOnFailure) {
//                Reporter.log("<br>");
//
//                Reporter.log("Exiting this function as exitOnFail flag is set to True. Will move to next test.");
//
//                throw e;
//
//            }
//
//        }
//    }
//
//    public void verifyFalse(boolean condition, String message, boolean screenshotOnFailure, boolean exitOnFailure) {
//
//        Reporter.log("<br>");
//
//        try {
//            Assert.assertFalse(condition, message);
//            Reporter.log("<Font Color=#008000> PASS </Font>" + message);
//        } catch (AssertionError e) {
//            this.testCaseStatus = false;
//            if (screenshotOnFailure) {
//                Reporter.log("<a href='" + screenShot() + "'> <Font Color=red> FAIL </Font> </a>" + message);
//            } else {
//                Reporter.log("<Font Color=red> FAIL </Font> " + message);
//            }
//
//            if (exitOnFailure) {
//                Reporter.log("<br>");
//                Reporter.log("Exiting this function as exitOnFail flag is set to True. Will move to next test.");
//
//                throw e;
//            }
//        }
//    }
//
//    public void reportLog(String logData) {
//        /*
//         * Reporter.log("<br>"); Reporter.log("<a href='" + screenShot() +
//         * "'> <Font Color=#008000> LOG </Font> </a>" + logData);
//         */
//        Reporter.log("<br>");
//        Reporter.log("<Font Color=008000> LOG : </Font> " + logData);
//    }
//
//    public void reportLogandsnapshot(String logData) {
//        Reporter.log("<br>");
//        Reporter.log("<a href='" + screenShot() + "'><Font Color=008000> LOG : </Font> </a>" + logData);
//
//    }
//
//    public void imageCompareLog(String im1, String im2, String diff1, String diff2, boolean flag) {
//        Reporter.log("<br>");
//        Reporter.log("<Font Color=008000> Image Comparison : </Font>  <a href='" + im1 + "'>Source 1</a>" + "        "
//                + "<a href='" + im2 + "'>Source 2</a><br />");
//        if (flag == true) {
//            Reporter.log("<Font Color=#008000> PASS </Font><br />");
//            Reporter.log("<Font Color=#008000> PASS </Font><br /><br />");
//        } else {
//            Reporter.log("<Font Color=Red> FAIL </Font>" + "<a href='" + diff1 + "'>Differential A : B</a><br />");
//            Reporter.log(
//                    "<Font Color=Red> FAIL </Font>" + "<a href='" + diff2 + "'>Differential B : A</a><br /><br />");
//        }
//
//    }
//
//    public void finalReport(boolean testCaseStatus) {
//        Assert.assertTrue(testCaseStatus, "Test Case has one or more assert failures.");
//    }
//
//    public void verifyEqualscreenshotonpass(Object actual, Object expected, String message, boolean screenshotOnFailure,
//                                            boolean exitOnFailure) {
//
//        Reporter.log("<br>");
//
//        try {
//            Assert.assertEquals(actual, expected, message);
//            Reporter.log("<a href='" + screenShot() + "'> <Font Color=#008000> PASS </Font> </a>" + message);
//
//        } catch (AssertionError e) {
//            this.testCaseStatus = false;
//            if (screenshotOnFailure) {
//
//                Reporter.log("<a href='" + screenShot() + "'> <Font Color=red> FAIL </Font> </a>" + message);
//
//            } else {
//
//                Reporter.log("<Font Color=red> FAIL </Font> " + message);
//
//            }
//
//            if (exitOnFailure) {
//                Reporter.log("<br>");
//
//                Reporter.log("Exiting this function as exitOnFail flag is set to True. Will move to next test.");
//
//                throw e;
//
//            }
//
//        }
//    }
//
//
//    public void getServerLogs(Level level, String testName) throws FileNotFoundException {
//        Log.info("Test");
//        //List<LogEntry> logEntries = driver.manage().logs().get("server").filter(Level.INFO);
//        List<LogEntry> logEntries = new ArrayList<>();
//
//        System.out.println(driver.manage().logs().getAvailableLogTypes().size());
//
//        Log.info(": Saving device log...");
//
//        String logPath = "adbLogs/";
//
//        String fileName = logPath + testName + ".txt";
//        Log.info("FILENAME      | " + fileName);
//        File logFile = new File(fileName);
//
//        PrintWriter log_file_writer = new PrintWriter(logFile);
//
//        for (LogEntry e : logEntries) {
//            Log.info(e.getMessage());
//            log_file_writer.println(e.getMessage());
//        }
//
//
//        log_file_writer.flush();
//        Log.info(": Saving device log - Done.");
//
//
//    }
//
//    public static void verifyEqualsWithLoggingExtentReport(Object actual, Object expected, String stepname, boolean exitOnFailure) throws IOException {
//
//        try {
//            Assert.assertEquals(actual, expected, stepname);
//            Log.info(Log.ANSI_GREEN + "LOG | PASS | Message : " + stepname + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
//            ExtentReport.extentReportDisplay(ExtentReport.Status.PASS, stepname, "Actual : " + actual + " | Expected : " + expected);
//
//        } catch (AssertionError e) {
//            if (exitOnFailure) {
//                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + stepname + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
//                ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepname, "Actual : " + actual + " | Expected : " + expected);
//                throw e;
//
//            } else {
//                Log.info(Log.ANSI_RED + "LOG | FAIL | Message : " + stepname + " | Actual : " + actual + " | Expected : " + expected + Log.ANSI_RESET);
//                ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, stepname, "Actual : " + actual + " | Expected : " + expected);
//
//            }
//
//        }
//    }


}
