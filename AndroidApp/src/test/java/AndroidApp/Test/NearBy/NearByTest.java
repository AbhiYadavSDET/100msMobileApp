package test.java.AndroidApp.Test.NearBy;

import IntegrationTests.Onboarding.OnboardingHelper;
import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.NearByHelper;
import test.java.AndroidApp.PageObject.NearByHelperBase;

import java.io.IOException;

/**
 * automated test to verify Near By.
 */


public class NearByTest extends CreateSession {
    NearByHelperBase nearHelperBase;
    Reporter reporter;
    OnboardingHelper onboardingHelper;
    NearByHelper nearByHelper;

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
        nearByHelper=new NearByHelper(getAndroidDriver());

    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearByHome"}, priority = 0, enabled = true)
    public void nearbyStoreListMap(@Optional String androidOSVersion)throws Exception{
        Log.infoStartTest("nearby home");
        reporter.extentTest = reporter.extentReports.createTest("nearby home");

        // login in app
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        //onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

        // verify nearby home page
        nearByHelper.nearbyStoreListMap("nearby", "nearbyHome");

        Log.infoEndTest("nearby home");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearbySearchCategory"}, priority = 1, enabled = true)
    public void nearbySearchCategory(@Optional String androidOSVersion)throws Exception{
        Log.infoStartTest("nearby search category");
        reporter.extentTest = reporter.extentReports.createTest("nearby category");

        // login in app
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        //onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");

        // verify nearby category
        nearByHelper.nearbySearchCategory("Grocery", "nearby", "nearbyCategory");

        Log.infoEndTest("nearby search category");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearbySearchKeyword"}, priority = 2, enabled = true)
    public void nearbySearchStore(@Optional String androidOSVersion)throws Exception{
        Log.infoStartTest("nearby search store");
        reporter.extentTest = reporter.extentReports.createTest("nearby store");

        // login in app
       // onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Suneja");
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");

        // verify nearby stores
        nearByHelper.nearbySearchStore("food", "nearby", "nearbyCategory");

        Log.infoEndTest("nearby search store");
    }

}
