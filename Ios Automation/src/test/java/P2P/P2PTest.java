package P2P;

import Helpers.LoginHelper;
import Helpers.P2PHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class P2PTest extends TestBase {


    @Test(groups = {"sanity", "p2pSend", "regression"}, priority = 0, description = "Wallet To Wallet transfer")
    public void Test01_p2pSend() throws IOException, InterruptedException {

        Log.info("======= START : P2P Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        // Execute the test
        P2PHelper p2PHelper = new P2PHelper(getIosDriver());
        p2PHelper.p2pSend("9414065033", "5", "You Sent", "₹5", "to Ruchi Kumari Jain", "9414065033", "Wallet");

        Log.info("======= END : P2P Send test =======");


    }
}