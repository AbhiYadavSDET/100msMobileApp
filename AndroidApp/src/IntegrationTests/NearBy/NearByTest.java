package IntegrationTests.NearBy;

import IntegrationTests.Offer.OfferHelper;
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
 * automated test to verify Near By.
 */


public class NearByTest extends CreateSession {
    NearByHelperBase nearHelperBase;
    Reporter reporter;
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

        nearHelperBase = new NearByHelper(getAndroidDriver());
        reporter = new Reporter();
        onboardingHelper = new OnboardingHelper(getAndroidDriver());

    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearByHome"}, priority = 0, enabled = true)
    public void nearbyStoreListMap(@Optional String androidOSVersion)throws Exception{
        Log.infoStartTest("nearby home");
        reporter.extentTest = reporter.extentReports.createTest("nearby home");

        // login in app
        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

        // verify nearby home page
        nearHelperBase.nearbyStoreListMap("nearby", "nearbyHome");

        Log.infoEndTest("nearby home");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearbySearchCategory"}, priority = 1, enabled = true)
    public void nearbySearchCategory(@Optional String androidOSVersion)throws Exception{
        Log.infoStartTest("nearby search category");
        reporter.extentTest = reporter.extentReports.createTest("nearby category");

        // login in app
        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

        // verify nearby category
        nearHelperBase.nearbySearchCategory("Grocery", "nearby", "nearbyCategory");

        Log.infoEndTest("nearby search category");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearbySearchKeyword"}, priority = 2, enabled = true)
    public void nearbySearchStore(@Optional String androidOSVersion)throws Exception{
        Log.infoStartTest("nearby search store");
        reporter.extentTest = reporter.extentReports.createTest("nearby store");

        // login in app
        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

        // verify nearby stores
        nearHelperBase.nearbySearchStore("food", "nearby", "nearbyCategory");

        Log.infoEndTest("nearby search store");
    }

}
