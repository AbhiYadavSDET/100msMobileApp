package test.java.AndroidApp.Test.NearBy;

import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
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


public class Test_Nearby extends CreateSession {
    NearByHelperBase nearHelperBase;
    Reporter reporter;
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
        nearByHelper = new NearByHelper(getAndroidDriver());

    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearByHome"}, priority = 0, enabled = true, dataProvider = "insuranceData", dataProviderClass = NearbyProviderClass.class)
    public void Test19_nearbyStoreListMap(@Optional String androidOSVersion, FrontEndEntity frontEndEntity) throws Exception {
        Log.infoStartTest("nearby home");
        reporter.extentTest = reporter.extentReports.createTest("nearby home");

        // login in app
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail("mayank.suneja@mobikwik.com", "Tuesday20");


        // verify nearby home page
        nearByHelper.nearbyStoreListMap("nearby", "nearbyHome");

        Log.infoEndTest("nearby home");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearbySearchCategory"}, priority = 1, enabled = true, dataProvider = "insuranceData", dataProviderClass = NearbyProviderClass.class)
    public void Test20_nearbySearchCategory(@Optional String androidOSVersion, FrontEndEntity frontEndEntity) throws Exception {
        Log.infoStartTest("nearby search category");
        reporter.extentTest = reporter.extentReports.createTest("nearby category");

        // login in app
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail("mayank.suneja@mobikwik.com", "Tuesday20");


        // verify nearby category
        nearByHelper.nearbySearchCategory("Grocery", "nearby", "nearbyCategory");

        Log.infoEndTest("nearby search category");
    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"nearBySanity", "nearbySearchKeyword"}, priority = 2, enabled = true, dataProvider = "insuranceData", dataProviderClass = NearbyProviderClass.class)
    public void Test21_nearbySearchStore(@Optional String androidOSVersion, FrontEndEntity frontEndEntity) throws Exception {
        Log.infoStartTest("nearby search store");
        reporter.extentTest = reporter.extentReports.createTest("nearby store");

        // login in app
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail("mayank.suneja@mobikwik.com", "Tuesday20");


        // verify nearby stores
        nearByHelper.nearbySearchStore("food", "nearby", "nearbyCategory");

        Log.infoEndTest("nearby search store");
    }

}
