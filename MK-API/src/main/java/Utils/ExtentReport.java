package Utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ExtentReport {

    public enum Status {
        PASS,
        FAIL, INFO,
        SKIP
    }


    public static String EXTENTREPORTPATH = "./Reports/TestReport.html";
    public static ExtentReports EXTENTREPORT;
    public static ExtentTest EXTENTTEST;


    @BeforeSuite(alwaysRun = true)
    public void extentReportSetup() throws IOException {
        Log.info("Reporter : @BeforeSuite");


        // Create Report with filepath
        EXTENTREPORT = new ExtentReports(EXTENTREPORTPATH, true);
    }

    public static void extentReportDisplay(Status result, String stepname, String details) throws IOException {
        switch (result) {

            case PASS:
                EXTENTTEST.log(LogStatus.PASS, stepname, details);
                break;
            case FAIL:
                EXTENTTEST.log(LogStatus.FAIL, stepname, details);
                break;
            case INFO:
                EXTENTTEST.log(LogStatus.INFO, stepname, details);
                break;
            case SKIP:
                EXTENTTEST.log(LogStatus.SKIP, stepname, details);
                break;
        }
    }

    @AfterSuite(alwaysRun = true)
    public void extentReportTearDown() throws IOException {
        Log.info("Reporter : @AfterSuite");


        // Create Report with filepath
        EXTENTREPORT.flush();
    }

}
