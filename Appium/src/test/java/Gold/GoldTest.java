package Gold;

import Helpers.GoldHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class GoldTest extends TestBase {


    @Test(groups = {"sanity", "goldBuy", "regression"}, priority = 2, description = "Verify Gold Buy")
    public void Gold_Test01_buyGold() throws IOException, InterruptedException {

        Log.info("======= START : Gold Buy test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldBuy("5000", "Payment Successful", "Gold Purchase", "0.0002", "₹1", "Purchased Gold", "-₹1", "Success");

        Log.info("======= END : Gold Buy test =======");


    }

    @Test(groups = {"sanity", "goldCoin1", "regression"}, priority = 1, description = "Verify Safe Gold Coin")
    public void Gold_Test03_SafeGoldCoin() throws IOException, InterruptedException {

        Log.info("======= START : Gold Coins Test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
         loginHelper.quickLoginViaOtpAutoRead("7042338867", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldCoin("Gold Coin Delivery","Know More","About SafeGold");

        Log.info("======= END : Gold Coins Test =======");


    }

    @Test(groups = {"sanity", "goldBuy1", "regression"}, priority = 2, description = "Verify Sip On Gold Page")
    public void Gold_Test04_Gold_Sip() throws IOException, InterruptedException {

        Log.info("======= START : Gold SIp test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
         loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldSip("Start Saving with Gold SIP","Daily","Monthly","Select a day for monthly purchase");

        Log.info("======= END : Gold SIp test =======");


    }

    @Test(groups = {"sanity", "goldBuy", "regression"}, priority = 0, description = "Verify Sip On Gold Page")
    public void Gold_Test05_Gold_Gift() throws IOException, InterruptedException {

        Log.info("======= START : Gold Gift test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.giftGold("Gift Gold to your loved ones","24K Gold Coins & Bars","Modify","Gifting Gold","GST (3%)","Net Payable");

        Log.info("======= END : Gold Gift test =======");


    }

}
