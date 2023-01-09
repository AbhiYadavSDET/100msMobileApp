package P2PExtra;

import Helpers.LoginHelper;
import Helpers.P2PExtraHelper;
import org.testng.annotations.Test;
import Utils.TestBase;


import java.io.IOException;

public class P2PExtraTest extends TestBase {

    @Test(groups = {"p2pXtraWithdraw","sanity", "sanityPrime"}, priority = 0, description = "Verify Withdraw Money")
    public void Test_Withdraw_Money() throws InterruptedException, IOException {
        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("8076595767");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.withdraw("1" ,"₹1", "Withdrawal request placed successfully");

    }

}