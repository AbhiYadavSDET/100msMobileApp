package MutualFunds;

import Helpers.LoginHelper;
import Helpers.MutualFundsHelper;
import org.testng.annotations.Test;
import Utils.TestBase;


import java.io.IOException;

public class MutualFundsTest extends TestBase {

    @Test(groups = {"MutualFunds","sanity", "sanityPrime"}, priority = 0, description = "Explore Mutual Funds")
    public void Explore_Mutual_Funds() throws InterruptedException, IOException {
        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330" , "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.mutualFundsCheck();

    }

}

