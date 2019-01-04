package IntegrationTests.Bikes;

import IntegrationTests.Onboarding.OnboardingHelper;
import IntegrationTests.Bikes.BikeHelper;
import IntegrationTests.Bikes.BikeHelperBase;
import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class BikeTest extends CreateSession {
    BikeHelperBase bikeHelperBase;
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

        bikeHelperBase = new BikeHelper(getAndroidDriver());
        onboardingHelper = new OnboardingHelper(getAndroidDriver());


    }


    @Parameters({"androidOSVersion"})
    @Test(groups = {"bikeBook"}, priority = 0)
    public void bikeInSufficient(@Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("bikeBook");

        reporter.extentTest = reporter.extentReports.createTest("bikeBook");

        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "");


        bikeHelperBase.bikeInSufficientBooking("TextLicense", "Prashant Rai", "5", "8527797582", "bike", "bikeInSufficient");


        Log.infoEndTest("bikeBook");
    }

}



