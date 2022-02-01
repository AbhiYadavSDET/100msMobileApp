package Utils;

import org.testng.*;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestListener implements ITestListener, ISuiteListener{

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
        Config.logComment("***************[Test Finished][Name: " + arg0.getName() + "]***************");

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        Config.logComment("***************[Test Started][Name: " + arg0.getName() + "]***************");

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
        Config.logComment("***************[Test Started] [Test Class: " + arg0.getInstanceName() + "] [Test Method: " + arg0.getMethod().getMethodName() + "] [Test Description: " + arg0.getMethod().getDescription() + "]***************");

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        Config.logComment("***************[Test Passed] [Test Class: " + arg0.getInstanceName() + "] [Test Method: " + arg0.getMethod().getMethodName() + "] [Test Description: " + arg0.getMethod().getDescription() + "]***************");

    }

}
