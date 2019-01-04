package UITestFramework.ExtentReport;

import UITestFramework.Mailer;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import logger.Log;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Reporter {


    public static ExtentTest extentTest;
    public static ExtentReports extentReports;
    public static ExtentHtmlReporter extentHtmlReporter;
    public static String EXTENTREPORTPATH = "src/UITestFramework/ExtentReport/extent.html";

    @BeforeSuite(alwaysRun = true)
    public void extentReportSetup() throws IOException {
        Log.info("Reporter : @BeforeSuite");
        extentHtmlReporter = new ExtentHtmlReporter(EXTENTREPORTPATH);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("OS", "Mac Sierra");
        extentReports.setSystemInfo("Host Name", "MS");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("User Name", "MS");

        extentHtmlReporter.config().setDocumentTitle("Extent report");
        extentHtmlReporter.config().setReportName("Final Report");

        //Log.info("COPY         | Older .html file for backup");
        //File source = new File("src/UITestFramework/ExtentReport/extent.html");

        //String timestamp = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new GregorianCalendar().getTime());
        //FileUtils.copyFile(source, new File("src/UITestFramework/ExtentReport/old/" + timestamp + "_extent.html"));


    }

   /* @AfterMethod
    public void getResult(ITestResult result) {
        Log.info("Reporter : @AfterMethod");
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            extentTest.skip(result.getThrowable());
        }
    }*/


    public void extentReportDisplay(String result, String details, String ssPath) throws IOException {
        switch (result) {

            case "PASS":
                extentTest.log(Status.PASS, details);
                break;
            case "PASSSS":
                extentTest.log(Status.PASS, details, MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
                break;
            case "FAIL":
                extentTest.log(Status.FAIL, details, MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
                break;
            case "INFO":
                extentTest.log(Status.INFO, details);
                break;
            case "INFOSS":
                extentTest.log(Status.INFO, details, MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
                break;
            case "WARNING":
                extentTest.log(Status.WARNING, details);
                break;
            case "SKIP":
                extentTest.log(Status.SKIP, details);
                break;
            case "SKIPSS":
                extentTest.log(Status.SKIP, details, MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
                break;
        }
    }

    public void extentReportDisplay(String result, String details, String ssPath, String exceptionDetails) throws
            IOException {
        switch (result) {

            case "PASS":
                extentTest.log(Status.PASS, details);
                break;
            case "PASSSS":
                extentTest.log(Status.PASS, details, MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
                break;
            case "FAIL":
                extentTest.log(Status.FAIL, details, MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
                break;
            case "INFO":
                extentTest.log(Status.INFO, details);
                break;
            case "INFOSS":
                extentTest.log(Status.INFO, details, MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
                break;
            case "WARNING":
                extentTest.log(Status.WARNING, details);
                break;
            case "SKIP":
                extentTest.log(Status.SKIP, details);
                break;
            case "SKIPSS":
                extentTest.skip(exceptionDetails, MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
                break;


        }
    }


    @AfterSuite(alwaysRun = true)
    public void extentReportTearDown() {
        Log.info("Reporter : @Aftersuite");
        extentReports.flush();

        Log.info("SEND          | Mail : extent.html");
        try {
            Mailer.reportMailer("src/UITestFramework/ExtentReport/extent.html", "extent.html");
        } catch (Exception e) {
            Log.info("Error         | While sending the Mailer");
            e.printStackTrace();
        }
    }


    public static void copyFile(File source, File dest) throws IOException {

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int len;

            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }


        } catch (FileNotFoundException e) {
            Log.info("File not found");
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }

    }


}
