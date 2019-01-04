package IntegrationTests.Onboarding;

import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * automated test to verify Add Money.
 */

public class OnboardingTest extends CreateSession {
    OnboardingHelperBase onboardingHelperBase;
    Reporter reporter;

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

        onboardingHelperBase = new OnboardingHelper(getAndroidDriver());
        reporter = new Reporter();


    }

    /**
     * method to verify Recharges from Home Screen
     *
     * @throws Exception
     */
    @Parameters({"androidOSVersion"})
    @Test(groups = {"loginSanity", "onboardingLogin"}, priority = 0)
    public void onboardingLogin(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("onboardingLogin");
        reporter.extentTest = reporter.extentReports.createTest("onboardingLogin");


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

        onboardingHelperBase.onboardingLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja", "onboarding", "onboardingLogin");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("onboardingLogin");

    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"loginViaMobileNo"}, priority = 1)
    public void loginViaMobileNo(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("loginViaMobileNo");
        Reporter.extentTest = Reporter.extentReports.createTest("loginViaMobileNo");


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

        onboardingHelperBase.loginViaMobileNo("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja", "onboarding", "loginViaMobileNo");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoStartTest("loginViaMobileNo");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"loginSanity", "loginViaPassword"}, priority = 1)
    public void loginViaPassword(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("loginViaPassword");
        Reporter.extentTest = Reporter.extentReports.createTest("loginViaPassword");


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

        onboardingHelperBase.loginViaPassword("8527797582", "mayank.suneja@mobikwik.com", "Tuesday20", "T.C. Suneja", "onboarding", "loginViaPassword");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/
        Log.infoStartTest("loginViaPassword");

    }


}



