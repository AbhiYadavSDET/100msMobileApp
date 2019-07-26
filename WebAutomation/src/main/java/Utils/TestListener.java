package Utils;

import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener {


    @Override
    public void onFinish(ISuite arg0) {
        // TODO Auto-generated method stub
        Config.logComment("***************[Test Suite Finished][Suite Name: " + arg0.getName() + "]***************");

    }

    @Override
    public void onStart(ISuite arg0) {
        // TODO Auto-generated method stub
        Config.logComment("***************[Test Suite Started][Suite Name: " + arg0.getName() + "]***************");

    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        Config.logComment(Config.ANSI_CYAN + "***************[Test Finished][Name: " + arg0.getName() + "]***************" + Config.ANSI_RESET);

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        Config.logComment(Config.ANSI_CYAN + "***************[Test Started][Name: " + arg0.getName() + "]***************" + Config.ANSI_RESET);

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub
        Config.logComment("***************[Test Failed] [Test Class: " + arg0.getInstanceName() + "] [Test Method: " + arg0.getMethod().getMethodName() + "] [Test Description: " + arg0.getMethod().getDescription() + "]***************");

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub
        Config.logComment("***************[Test Skipped] [Test Class: " + arg0.getInstanceName() + "] [Test Method: " + arg0.getMethod().getMethodName() + "] [Test Description: " + arg0.getMethod().getDescription() + "]***************");

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        Config.logComment(Config.ANSI_CYAN + "***************[Test Started] [Test Class: " + arg0.getInstanceName() + "] [Test Method: " + arg0.getMethod().getMethodName() + "] [Test Description: " + arg0.getMethod().getDescription() + "]***************" + Config.ANSI_RESET);

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        Config.logComment("***************[Test Passed] [Test Class: " + arg0.getInstanceName() + "] [Test Method: " + arg0.getMethod().getMethodName() + "] [Test Description: " + arg0.getMethod().getDescription() + "]***************");

    }

}

























