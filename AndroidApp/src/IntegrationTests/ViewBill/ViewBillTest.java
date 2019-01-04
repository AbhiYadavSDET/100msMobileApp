package IntegrationTests.ViewBill;

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

public class ViewBillTest extends CreateSession {
    ViewBillHelperBase viewBillHelperBase;
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

        viewBillHelperBase = new ViewBillHelper(getAndroidDriver());
        onboardingHelper = new OnboardingHelper(getAndroidDriver());


    }

    /**
     * method to verify Recharges from Home Screen
     *
     * @throws Exception
     */
    @Parameters({"androidOSVersion"})
    @Test(groups = {"viewBillSanity", "viewBillGas"}, priority = 0)
    public void viewBillGas(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("viewBillGas");

        reporter.extentTest = reporter.extentReports.createTest("viewBillGas");

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
                    + "directoryName : " + directoryName + "/" + androidOSVersion + " | " + "screensh4otName : "
                    + screenshotName);*/

        viewBillHelperBase.viewBillGas("Gujarat Gas Ltd", "100407129", "8527797582", "mayank.suneja@gmail.com", "viewbill", "viewBillGas");

            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("viewBillGas");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"viewBillElectricity"}, priority = 1)
    public void viewBillElectricity(@Optional String androidOSVersion) throws Exception {
        Log.info("START : viewBillElectricity");

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

        viewBillHelperBase.viewBillElectricity("B.E.S.T Mumbai", "4132650955", "directoryName", "screenName");

            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.info("END : viewBillElectricity");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"viewBillWater"}, priority = 0)
    public void viewBillWater(@Optional String androidOSVersion) throws Exception {
        Log.info("START : viewBillWater");

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

        viewBillHelperBase.viewBillWater("Bangalore Water Supply and Sewerage Board", "C-100171", "directoryName", "screenName");

            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.info("END : viewBillWater");
    }


}



