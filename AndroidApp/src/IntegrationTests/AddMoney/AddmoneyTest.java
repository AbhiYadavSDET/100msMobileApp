package IntegrationTests.AddMoney;

import IntegrationTests.Onboarding.OnboardingHelper;
import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * automated test to verify Add Money.
 */

public class AddmoneyTest extends CreateSession {
    AddmoneyHelperBase addmoneyHelperBase;
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

        addmoneyHelperBase = new AddmoneyHelper(getAndroidDriver());
        onboardingHelper = new OnboardingHelper(getAndroidDriver());


    }

    /**
     * method to verify Recharges from Home Screen
     *
     * @throws Exception
     */
    @Parameters({"androidOSVersion"})
    @Test(groups = {"addmoneySanity", "addmoneyNetbanking"}, priority = 0)
    public void addmoneyNetbanking(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("Addmoney Netbanking");
        Reporter.extentTest = Reporter.extentReports.createTest("addmoneyViaNetbanking");

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

        addmoneyHelperBase.addmoneyNetbanking("ICICI Bank", "addmoney", "addmoneyNetbanking");
        addmoneyHelperBase.addmoneyNetbanking("HDFC Bank", "addmoney", "addmoneyNetbanking");
        addmoneyHelperBase.addmoneyNetbanking("CitiBank", "addmoney", "addmoneyNetbanking");
        addmoneyHelperBase.addmoneyNetbanking("Axis Bank", "addmoney", "addmoneyNetbanking");


            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("Addmoney Netbanking");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"addmoneySanity", "addmoneyNewCard"}, priority = 1)
    public void addmoneyNewCard(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("Addmoney Newcard");
        Reporter.extentTest = Reporter.extentReports.createTest("addmoneyViaNewcard");

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

        addmoneyHelperBase.addmoneyNewCard("10", "4363931800224460", "12/22", "239", "p@324008", "Payment Successful!", "addmoney", "addmoneyNewCard");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("Addmoney Newcard");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"addmoneySanity", "addmoneySavedCardPromocode"}, priority = 2)
    public void addmoneySavedCardPromocode(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("addmoneySavedCardPromocode");

        Reporter.extentTest = Reporter.extentReports.createTest("addmoneySavedCardPromocode");

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

        addmoneyHelperBase.addmoneySavedCardPromocode("10", "4363931800224460", "239", "p@324008", "Payment Successful!", true, "QWERTY12", "5", "addmoney", "addmoneySavedCard");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("Addmoney Saved card Promocode");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"addmoneySavedCard"}, priority = 3)
    public void addmoneySavedCard(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("addmoneySavedCard");

        Reporter.extentTest = Reporter.extentReports.createTest("addmoneySavedCardPromocode");

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

        addmoneyHelperBase.addmoneySavedCardPromocode("10", "4363931800224460", "239", "p@324008", "Payment Successful!", false, "shubhadd", "5", "addmoney", "addmoneySavedCard");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("Addmoney Saved card");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"addmoneyNewCardPromocode"}, priority = 2)
    public void addmoneyNewCardPromocode(@Optional String androidOSVersion) throws Exception {
        Log.info("START : Addmoney Saved card with Promocode");
        Reporter.extentTest = Reporter.extentReports.createTest("addmoneyViaSavedcardPromocode");


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

        // addmoneyHelperBase.addmoneyNewCardPromocode("10", "4363931800224460", "1222", "239", "p@324008", true, "ADDTEST", "addmoney", "addmoneyNewCardPromocode");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.info("END : Addmoney Saved card with Promocode");
    }
}



