package ReferAndEarn;

import Helpers.LoginHelper;
import Helpers.ReferAndEarnHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReferAndEarnTest extends TestBase {

    @Test(groups = {"referInUpiWithoutEarnings","regression"}, priority = 0, description = "Verify Refer & Earn UPI with NO Earnings")
    public void Test01_Refer_And_Earn_UPI() throws InterruptedException, IOException {

        Log.info("======= START : Refer And Earn in UPI with no earnings=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        ReferAndEarnHelper referAndEarnHelper = new ReferAndEarnHelper(getAndroidDriver());
        referAndEarnHelper.referInUpiWithoutEarnings("Refer & earn ₹20");

        Log.info("======= END : Refer And Earn in UPI with no earnings =======");

    }


    @Test(groups = {"sanity","referInUpiWithEarnings","regression"}, priority = 1, description = "Verify Refer & Earn UPI with Earnings table")
    public void Test02_Refer_And_Earn_WithEarning_UPI() throws InterruptedException, IOException {

        Log.info("======= START : Refer And Earn in UPI with earnings=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");

        ReferAndEarnHelper referAndEarnHelper = new ReferAndEarnHelper(getAndroidDriver());
        referAndEarnHelper.referInUpiWithEarnings("Refer & earn ₹20");

        Log.info("======= END : Refer And Earn in UPI earnings =======");
    }


    @Test(groups = {"referInCCBP","regression"}, priority = 2, description = "Verify Refer & Earn in CCBP")
    public void Test03_Refer_And_Earn_CCBP() throws InterruptedException, IOException {

        Log.info("======= START : Refer And Earn in CCBP =======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        ReferAndEarnHelper referAndEarnHelper = new ReferAndEarnHelper(getAndroidDriver());
        referAndEarnHelper.referInCCBP();

        Log.info("======= END : Refer And Earn in CCBP =======");
    }

}
