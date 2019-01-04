package IntegrationTests.SignUp;

import IntegrationTests.Onboarding.OnboardingHelper;
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

public class SignUpTest extends CreateSession {
    SignUpHelperBase signUpHelperBase;
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

        signUpHelperBase = new SignUpHelper(getAndroidDriver());
        reporter = new Reporter();


    }

    /**
     * method to verify Recharges from Home Screen
     *
     * @throws Exception
     */
    @Parameters({"androidOSVersion"})
    @Test(groups = {"signUpSanity", "signUpMobile"}, priority = 0)
    public void signUpMobile(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("signUpMobile");

        reporter.extentTest = reporter.extentReports.createTest("signUpMobile");


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

        signUpHelperBase.signUpOnboardMobile("signUp","signUpNobile");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("signUpMobile");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"signUpSanity", "signUpEmail"}, priority = 1)
    public void signUpEmail(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("signUpEmail");

        reporter.extentTest = reporter.extentReports.createTest("signUpEmail");


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

        signUpHelperBase.signUpEmail("signUp","signUpEmail");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("signUpEmail");
    }

}




