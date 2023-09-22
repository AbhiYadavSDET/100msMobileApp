package P2P;

import Helpers.LoginHelper;
import Helpers.P2PHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class P2PTest extends TestBase {


    @Test(groups = {"sanity", "p2pSend", "regression"}, priority = 0, description = "Wallet To Wallet transfer")
    public void Test01_p2pSend() throws IOException, InterruptedException {

        Log.info("======= START : P2P Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        P2PHelper p2PHelper = new P2PHelper(getAndroidDriver());
        p2PHelper.p2pSend("9999301210", "5", "You Sent", "₹5", "to Neelam Suneja", "9999301210", "Wallet", "Activate Now","Money transfer to 9999301210", "-₹5", "Success");

        Log.info("======= END : P2P Send test =======");


    }
}
