package test.java.AndroidApp.Test.Bike;

import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.BikeHelper;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.PageObject.BikeHelperBase;

import java.io.IOException;

public class BikeTest extends CreateSession {
    BikeHelperBase bikeHelperBase;
    Reporter reporter = new Reporter();
    LoginHelper loginHelper;
    BikeHelper bikeHelper;


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

        bikeHelperBase = new BikeHelper(getIOSDriver());
        loginHelper = new LoginHelper(getIOSDriver());
        bikeHelper = new BikeHelper(getIOSDriver());


    }


    @Parameters({"androidOSVersion"})
    @Test(groups = {"bikeBook"}, priority = 0)
    public void bikeInSufficient(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("bikeBook");

        reporter.extentTest = reporter.extentReports.createTest("bikeBook");

        //onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "");
        loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");


        bikeHelper.bikeInSufficientBooking("TextLicense", "Prashant Rai", "5", "8527797582", "bike", "bikeInSufficient");


        Log.infoEndTest("bikeBook");
    }

}



