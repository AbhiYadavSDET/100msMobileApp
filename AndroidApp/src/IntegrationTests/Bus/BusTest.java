package IntegrationTests.Bus;

import IntegrationTests.Onboarding.OnboardingHelper;
import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

/**
 * automated test to verify Add Money.
 */

public class BusTest extends CreateSession {
    BusHelperBase busHelperBase;
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

        busHelperBase = new BusHelper(getAndroidDriver());
        onboardingHelper = new OnboardingHelper(getAndroidDriver());


    }

    /**
     * method to verify Recharges from Home Screen
     *
     * @throws Exception
     */
    @Parameters({"androidOSVersion"})
    @Test(groups = {"busSanity", "busBook"}, priority = 0)
    public void busBook(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("busBook");

        reporter.extentTest = reporter.extentReports.createTest("offerSearch");
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        Thread.sleep(3000);

        if(Element.isElementPresent(driver,(By.id("cross_button")))) {
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("cross_button")), "Cross Button");
        }
        Thread.sleep(1000);


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

        busHelperBase.busBook("Bhubaneswar", "Baripada", "IOS Automation", "25", "bus", "busBook");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("busBook");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"busCancel"}, priority = 1, dependsOnMethods = "busBook")
    public void busCancel(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("busCancel");

        reporter.extentTest = reporter.extentReports.createTest("busCancel");
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        Thread.sleep(3000);

        if(Element.isElementPresent(driver,(By.id("cross_button")))) {
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("cross_button")), "Cross Button");
        }
        Thread.sleep(1000);
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

        busHelperBase.busCancel("bus", "busCancel");



            /*if (status) {
                Log.info("Marking the Test Case : PASS");
                excelUtils.setCellData("PASS", testcaseIndex, 10);
            } else {
                Log.info("Marking the Test Case : FAIL");
                excelUtils.setCellData("FAIL", testcaseIndex, 10);
            }*/

        Log.infoEndTest("busCancel");
    }

}



