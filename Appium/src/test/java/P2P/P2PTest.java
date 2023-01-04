package P2P;

import Helpers.GoldHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class P2PTest extends TestBase {


    @Test(groups = {"sanity", "p2pSend"}, priority = 0, description = "Wallet To Wallet transfer")
    public void Test01_buyGold() throws IOException, InterruptedException {

        Log.info("======= START : P2P Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldBuy("1", "9414065033");

        Log.info("======= END : P2P Send test =======");


    }
}
