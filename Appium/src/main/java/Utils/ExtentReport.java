package Utils;


//import applicationcontext.ApplicationContextProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Logger.Log;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ExtentReport {

    public enum Status {
        PASS,
        FAIL, INFO,
        SKIP
    }


    public static String EXTENTREPORTPATH = System.getProperty("user.dir").concat(File.separator).concat("test-output/ExtentReports/TestReport.html");
    public static ExtentReports EXTENTREPORT;
    public static ExtentTest EXTENTTEST;
    public static ExtentHtmlReporter EXTENTHTMLREPORTER;


    @BeforeSuite
    public void extentReportSetup() throws IOException {
        Log.info("EXtentReport : Initialising the Extent Report");


        // Create Report with filepath
        Log.info("Path : " + System.getProperty("user.dir").concat(File.separator).concat("test-output/ExtentReports/TestReport.html"));
        EXTENTREPORT = new ExtentReports();
        EXTENTHTMLREPORTER = new ExtentHtmlReporter(EXTENTREPORTPATH);
        EXTENTREPORT.attachReporter(EXTENTHTMLREPORTER);
        EXTENTHTMLREPORTER.config().setReportName("Extent Report Name");
        EXTENTHTMLREPORTER.config().setDocumentTitle("Document Title");


    }

    public static void extentReportDisplay(Status result, String stepname, String details) throws IOException {

        switch (result) {

            case PASS:
                EXTENTTEST.log(com.aventstack.extentreports.Status.PASS, details);
                break;
            case FAIL:
                EXTENTTEST.log(com.aventstack.extentreports.Status.FAIL, details);
                break;
            case INFO:
                EXTENTTEST.log(com.aventstack.extentreports.Status.INFO, details);
                break;
            case SKIP:
                EXTENTTEST.log(com.aventstack.extentreports.Status.SKIP, details);
                break;
        }
    }

    // Added by MS@7th Feb,23 only to take two agrs result & Stepname
    public static void extentReportDisplay(Status result, String stepname) throws IOException {

        switch (result) {

            case PASS:
                EXTENTTEST.log(com.aventstack.extentreports.Status.PASS, stepname);
                break;
            case FAIL:
                EXTENTTEST.log(com.aventstack.extentreports.Status.FAIL, stepname);
                break;
            case INFO:
                EXTENTTEST.log(com.aventstack.extentreports.Status.INFO, stepname);
                break;
            case SKIP:
                EXTENTTEST.log(com.aventstack.extentreports.Status.SKIP, stepname);
                break;
        }
    }

    public static void extentReportAttachScreenshot(String screenshotPath) throws IOException {
        EXTENTTEST.log(com.aventstack.extentreports.Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

    }

    public static void createLable(String text, ExtentColor extentColor) {
        EXTENTTEST.info(MarkupHelper.createLabel(text, extentColor));
    }

    @AfterSuite
    public void extentReportTearDown() throws IOException, InterruptedException, MessagingException {
        Log.info("Reporter : @AfterSuite");

        Log.info("Flush the Extent Report");
        EXTENTREPORT.flush();
//        sendReportViaMail();
        //      Mailer.sendMail();

    }

    public static void sendReportViaMail() throws InterruptedException {


        Log.info("sendReportViaMail");
//        Mailer mailer = (Mailer) ApplicationContextProvider.getApplicationContext().getBean("mailer");

        // Create the list of attachments
        List<String> listOfAttachments = new ArrayList<>();
        Log.info("Path : " + System.getProperty("user.dir").concat(File.separator).concat("reports/TestReport.html"));
        listOfAttachments.add(System.getProperty("user.dir").concat(File.separator).concat("reports/TestReport.html"));

        // Create the recipients array
//        String[] recipients = Configuration.Email.RECIPIENTS.split(",");

        Log.info("Send Mail : " + "TestReport.html");
        Log.info("Send Mail : " + "Extent.html");
//        mailer.sendMail(recipients, Configuration.Email.TEAM + " Test Execution report", Configuration.Email.MAIL_BODY_TEXT, listOfAttachments);
    }


}

