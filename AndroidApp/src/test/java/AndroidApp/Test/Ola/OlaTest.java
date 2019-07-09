package test.java.AndroidApp.Test.Ola;

import IntegrationTests.Ola.OlaHelperBase;
import IntegrationTests.Onboarding.OnboardingHelper;
import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.OlaHelper;

import java.io.IOException;

/**
 * automated test to verify Add Money.
 */

public class OlaTest extends CreateSession {
    OlaHelperBase olaHelperBase;
    Reporter reporter = new Reporter();
    OnboardingHelper onboardingHelper;
    LoginHelper loginHelper;


    /**
     * this method instantiate required helpers for Platform : Android
     *
     * @param - invokeDriver android
     * @param - build - staging, beta, production
     * @throws IOException
     * @name - instantiateHelpers
     */
    @Parameters({"build"})
    @BeforeMethod(groups = "instantiateHelpers", alwaysRun = true)
    public void instantiateHelpers(String build) throws IOException {

        olaHelperBase = new OlaHelper(getAndroidDriver());
        onboardingHelper = new OnboardingHelper(getAndroidDriver());
        loginHelper = new LoginHelper(getAndroidDriver());



    }

    /**
     * method to verify Recharges from Home Screen
     *
     * @throws Exception
     */
    @Parameters({"androidOSVersion"})
    @Test(groups = {"olaSanity", "olaBook"}, priority = 0)
    public void olaBook(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("olaBook");

        reporter.extentTest = reporter.extentReports.createTest("olaBook");
        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");

        //onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

        // ExcelUtils excelUtils = new ExcelUtils("TestData.xlsx", "login");

        /*if (!excelUtils.isSheetLocked()) {

            int testcaseIndex = excelUtils.getStartPoint("logViaEmailID1", 2);

            String userName = excelUtils.getCellData(testcaseIndex, 4);
            String password = excelUtils.getCellData(testcaseIndex, 5);
            String mobile = excelUtils.getCellData(testcaseIndex, 6);
            String directoryName = excelUtils.getCellData(testcaseIndex, 8);
            String screenshotName = excelUtils.getCellData(testcaseIndex, 9);

            Log.info("userName : " + userName + " | " + "Password : " + password + " | " + "mobile : " + mobile + " | "
                    + "directoryName : " + directoryName + "/" + androidOSVersion + " | " + "screenshotName : "
                    + screenshotName);*/

        olaHelperBase.olaBook("genpact gurgaon", "IOS Automation", "ola", "olaBook");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("olaBook");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"olaCancel"}, priority = 1)
    public void olaCancel(@Optional String androidOSVersion) throws Exception {
        Log.info("START : olaCancel");

        // ExcelUtils excelUtils = new ExcelUtils("TestData.xlsx", "login");

        /*if (!excelUtils.isSheetLocked()) {

            int testcaseIndex = excelUtils.getStartPoint("logViaEmailID1", 2);

            String userName = excelUtils.getCellData(testcaseIndex, 4);
            String password = excelUtils.getCellData(testcaseIndex, 5);
            String mobile = excelUtils.getCellData(testcaseIndex, 6);
            String directoryName = excelUtils.getCellData(testcaseIndex, 8);
            String screenshotName = excelUtils.getCellData(testcaseIndex, 9);

            Log.info("userName : " + userName + " | " + "Password : " + password + " | " + "mobile : " + mobile + " | "
                    + "directoryName : " + directoryName + "/" + androidOSVersion + " | " + "screenshotName : "
                    + screenshotName);*/
        //reporter.extentTest = reporter.extentReports.createTest("olaCancel");
        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");

        olaHelperBase.olaCancel("directoryName", "screenName");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.info("END : olaCancel");
    }

}



