package P2PExtra;

import Helpers.LoginHelper;
import Helpers.P2PExtraHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class P2PExtraTest extends TestBase {

    @Test(groups = {"p2pXtraNewUser"}, priority = 0, description = "Verify Xtra :New User Flow Journey")
    public void Test_Xtra_New_User_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - NEW USER flow test with no kYC=======");
        // Start the test
        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getIosDriver());
        p2PExtraHelper.newUserFlow("Complete your KYC");

        Log.info("======= END : XTRA - NEW USER flow test with no kYC=======");

    }



    @Test(groups = {"p2pXtraReferAndEarn", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra : Refer & Earn Journey from Xtra Dashboard")
    public void Test_Xtra_Refer_Earn_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Refer & Earn  flow =======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getIosDriver());
        p2PExtraHelper.referAndEarnFlow("Know More");

        Log.info("======= END : XTRA - Refer & Earn flow =======");

    }


}
