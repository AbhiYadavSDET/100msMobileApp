package test.java.AndroidApp.Test.Mgm;

import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.MgmHelper;

import java.io.IOException;

public class MgmTest extends CreateSession {
    MgmHelper mgmHelper;
    Reporter reporter;
    LoginHelper loginHelper;

    /**
     * this method instantiate required helpers for Platform : Android
     *
     * @param - invokeDriver androidcle
     * @param - build - staging, beta, production
     * @throws IOException
     * @name - instantiateHelpers
     */
    @Parameters({"build"})
    @BeforeMethod(groups = "instantiateHelpers", alwaysRun = true)
    public void instantiateHelpers(String build) throws IOException {

        reporter = new Reporter();
        loginHelper = new LoginHelper(driver);
        mgmHelper = new MgmHelper(getAndroidDriver());


    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"verifyMgm"}, priority = 0, dataProvider = "mgmData", dataProviderClass = MgmDataProviderClass.class)
    public void verifyMgm(String username, String password, @Optional String androidOSVersion) throws Exception {
        Log.infoStartTest("verify mgm");
        reporter.extentTest = reporter.extentReports.createTest("max get more");

        // login in app
        //onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Test");
        loginHelper.quickLoginViaEmail(username, password);

        // verify mgm functionality
        mgmHelper.verifyMgm("mgm", "redeem mgm points");

        Log.infoEndTest("verify mgm");

    }

}
