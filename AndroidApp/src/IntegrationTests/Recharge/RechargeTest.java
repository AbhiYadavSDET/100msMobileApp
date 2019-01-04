package IntegrationTests.Recharge;

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

public class RechargeTest extends CreateSession {
    RechargeHelperBase rechargeHelperBase;
    Reporter reporter = new Reporter();
    OnboardingHelper onboardingHelper;


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

        rechargeHelperBase = new RechargeHelper(getAndroidDriver());
        onboardingHelper = new OnboardingHelper(getAndroidDriver());


    }

    /**
     * method to verify Recharges from Home Screen
     *
     * @throws Exception
     */
    @Parameters({"androidOSVersion"})
    @Test(groups = {"rechargeSanity", "mobilePrepaid"}, priority = 0)
    public void mobilePrepaid(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("Mobile Prepaid");

        reporter.extentTest = reporter.extentReports.createTest("mobilePrepaid");

        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

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

        rechargeHelperBase.prepaidRecharge("9953138474", "10", "Prepaid", "Vodafone", "recharge", "mobilePrepaid");

            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("mobilePrepaid");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"rechargeSanity", "mobilePostpaidSavedConnection"}, priority = 1)
    public void mobilePostpaidSavedConnection(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("mobilePostpaidSavedConnection");

        reporter.extentTest = reporter.extentReports.createTest("mobilePostpaidSavedConnection");

        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

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

        rechargeHelperBase.mobilePostpaidSavedConnection("7795709569", "1", "Postpaid", "Vodafone", "recharge", "mobilePostpaidSavedConnection");

            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("mobilePostpaidSavedConnection");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"rechargeSanity", "mobilePostpaidPromocode"}, priority = 3)
    public void mobilePostpaidPromocode(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("mobilePostpaidPromocode");

        reporter.extentTest = reporter.extentReports.createTest("mobilePostpaidPromocode");

        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

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

        rechargeHelperBase.postpaidPaymentWithPromocode("7795709569", "1", true, "QWERTY", "recharge", "mobilePostpaidPromocode");

            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("mobilePostpaidPromocode");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"rechargeSanity", "bsnlSpecial"}, priority = 2)
    public void bsnlSpecial(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("bsnlSpecial");


        reporter.extentTest = reporter.extentReports.createTest("bsnlSpecial");

        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

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

        rechargeHelperBase.bsnlSpecial("9461528145", "BSNL", "recharge", "bsnlSpecial");

            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("bsnlSpecial");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"creditCard"}, priority = 0)
    public void creditCard(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("creditCard Bill Payment");

        reporter.extentTest = reporter.extentReports.createTest("creditCard");

        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

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

        rechargeHelperBase.creditCardBillPayment("5", "recharge", "creditCard");

            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("creditCard Bill Payment");
    }
}



