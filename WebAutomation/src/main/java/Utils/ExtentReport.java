package Utils;

import Config.Configuration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

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

    public static void extentReportDisplay(Status result, String details) throws IOException {
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

    public static void createLable(String text, ExtentColor extentColor) {
        EXTENTTEST.info(MarkupHelper.createLabel(text, extentColor));
    }

    @AfterSuite(alwaysRun = true)
    public void extentReportTearDown() throws IOException {
        Log.info("Reporter : @AfterSuite");

        Log.info("Flush the Extent Report");
        EXTENTREPORT.flush();
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
