package IntegrationTests.Mgm;

import IntegrationTests.Onboarding.OnboardingHelper;
import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.io.IOException;

public class MgmTest extends CreateSession {
    MgmHelperBase mgmHelperBase;
    Reporter reporter;
    OnboardingHelper onboardingHelper;

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

        mgmHelperBase = new MgmHelper(getAndroidDriver());
        reporter = new Reporter();
        onboardingHelper = new OnboardingHelper(getAndroidDriver());

    }

    @Parameters({"androidOSVersion"})
    @Test(groups = {"verifyMgm"}, priority = 0)
    public void verifyMgm(@Optional String androidOSVersion) throws Exception
    {
        Log.infoStartTest("verify mgm");
        reporter.extentTest = reporter.extentReports.createTest("max get more");

        // login in app
        onboardingHelper.quickLogin("8527797582", "mayank.suneja@mobikwik.com", "T.C. Test");

        // verify mgm functionality
        mgmHelperBase.verifyMgm("mgm","redeem mgm points");

        Log.infoEndTest("verify mgm");

    }

}
