package Utils.Listeners;


import Logger.Log;
import Utils.ExtentReport;
import Utils.MBReporter;
import org.testng.*;

import java.io.IOException;

public class TestListener implements ITestListener, ISuiteListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(Log.ANSI_BLUE + "***************[Test Started] [Test Class: " + iTestResult.getInstanceName() + "] [Test Method: " + iTestResult.getMethod().getMethodName() + "] [Test Description: " + iTestResult.getMethod().getDescription() + "]***************" + Log.ANSI_RESET);
        Log.info("This is onTestStart " + iTestResult.getInstanceName());

        // Starting the test in the extentreport
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(Log.ANSI_GREEN + "***************[Test SUCCESS] [Test Class: " + iTestResult.getInstanceName() + "] [Test Method: " + iTestResult.getMethod().getMethodName() + "] [Test Description: " + iTestResult.getMethod().getDescription() + "]***************" + Log.ANSI_RESET);
        try {
            Reporter.log("<Font Color=#008000> PASS </Font>" + "Test Case Passed");
            ExtentReport.extentReportDisplay(ExtentReport.Status.PASS, "Test Case Passed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(Log.ANSI_RED + "***************[Test FAILED] [Test Class: " + iTestResult.getInstanceName() + "] [Test Method: " + iTestResult.getMethod().getMethodName() + "] [Test Description: " + iTestResult.getMethod().getDescription() + "]***************" + Log.ANSI_RESET);

        try {
            Reporter.log("<Font Color=red> FAIL </Font> " + "Test Case Failed");
            ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, "Test Case Failed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(Log.ANSI_YELLOW + "***************[Test SKIPPED] [Test Class: " + iTestResult.getInstanceName() + "] [Test Method: " + iTestResult.getMethod().getMethodName() + "] [Test Description: " + iTestResult.getMethod().getDescription() + "]***************" + Log.ANSI_RESET);
        try {
            Reporter.log("<Font Color=yellow> SKIPPED </Font>" + "Test Case Skiped");
            ExtentReport.extentReportDisplay(ExtentReport.Status.SKIP, "Test Case Skiped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void onStart(ISuite iSuite) {
        Log.info(Log.ANSI_CYAN + "***************[Test Suite Started][Suite Name: " + iSuite.getName() + "]***************" + Log.ANSI_RESET);


    }

    @Override
    public void onFinish(ISuite iSuite) {
        Log.info(Log.ANSI_CYAN + "***************[Test Suite Finished][Suite Name: " + iSuite.getName() + "]***************" + Log.ANSI_RESET);

    }
}
