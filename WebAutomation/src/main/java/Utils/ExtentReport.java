package Utils;

import Config.Configuration;
import applicationcontext.ApplicationContextProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import mail.Mailer;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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


    public static String EXTENTREPORTPATH = "./reports/TestReport.html";
    public static ExtentReports EXTENTREPORT;
    public static ExtentTest EXTENTTEST;
    public static ExtentHtmlReporter EXTENTHTMLREPORTER;


    @BeforeSuite(alwaysRun = true)
    public void extentReportSetup() throws IOException {
        Log.info("Reporter : @BeforeSuite");


        // Create Report with filepath
        EXTENTHTMLREPORTER = new ExtentHtmlReporter(EXTENTREPORTPATH);
        EXTENTREPORT = new ExtentReports();
        EXTENTREPORT.attachReporter(EXTENTHTMLREPORTER);
        EXTENTHTMLREPORTER.config().setTheme(setTheme(Configuration.ReportDefaults.REPORT_THEME));
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

    public static void extentReportAttachScreenshot(String screenshotPath) throws IOException {
        EXTENTTEST.log(com.aventstack.extentreports.Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

    }

    public static void createLable(String text, ExtentColor extentColor) {
        EXTENTTEST.info(MarkupHelper.createLabel(text, extentColor));
    }

    @AfterSuite(alwaysRun = true)
    public void extentReportTearDown() throws IOException, InterruptedException {
        Log.info("Reporter : @AfterSuite");

        Log.info("Flush the Extent Report");
        EXTENTREPORT.flush();
        sendReportViaMail();

    }

    public static void sendReportViaMail() throws InterruptedException {


        Log.info("sendReportViaMail");
        Mailer mailer = (Mailer) ApplicationContextProvider.getApplicationContext().getBean("mailer");

        // Create the list of attachments
        List<String> listOfAttachments = new ArrayList<>();
        Log.info("Path : " + System.getProperty("user.dir").concat(File.separator).concat("reports/TestReport.html"));
        listOfAttachments.add(System.getProperty("user.dir").concat(File.separator).concat("reports/TestReport.html"));

        // Create the recipients array
        String[] recipients = Configuration.Email.RECIPIENTS.split(",");

        Log.info("Send Mail : " + "TestReport.html");
        Log.info("Send Mail : " + "Extent.html");
        mailer.sendMail(recipients, Configuration.Email.TEAM + " Test Execution report", Configuration.Email.MAIL_BODY_TEXT, listOfAttachments);
    }


    public static void sendFabricStatusMail(String subject, String body) throws InterruptedException {


        Log.info("START", "sendFabricStatusMail");
        Mailer mailer = (Mailer) ApplicationContextProvider.getApplicationContext().getBean("mailer");

        // Create the list of attachments
        List<String> listOfAttachments = new ArrayList<>();
        listOfAttachments.add(System.getProperty("user.dir").concat(File.separator).concat("test-output/ExtentReports/ExtentReport.html"));

        // Create the recipients array
        String recepients = "qafront-end@mobikwik.com,Mbk-Android@mobikwik.com";
        String[] recipients = recepients.split(",");

        mailer.sendMail(recipients, subject, body, listOfAttachments);

        Log.info("END", "sendFabricStatusMail");

    }

    private static Theme setTheme(String themeType) {
        Theme theme;
        switch (themeType.toUpperCase()) {
            case ("DARK"):
                theme = Theme.DARK;
                break;
            case ("STANDARD"):
                theme = Theme.STANDARD;
                break;
            default:
                theme = Theme.STANDARD;
                break;
        }
        return theme;
    }

}
