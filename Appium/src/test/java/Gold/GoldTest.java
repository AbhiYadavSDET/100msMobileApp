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

    @Test(groups = {"sanity1"}, priority = 2, description = "Verify Safe Gold Coins data")
    public void Gold_Test02_buySell() throws IOException, InterruptedException {

        Log.info("======= START : Gold Sell test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
         loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372"); 

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldSell("1", "Payment Successful", "Sell Gold", "0.0002", "₹1", "Sold Gold", "+₹1", "Success");

        Log.info("======= END : Gold Sell test =======");


    }


    @Test(groups = {"sanity", "goldCoin", "regression"}, priority = 0, description = "Verify Safe Gold Coin")
    public void Gold_Test03_SafeGoldCoin() throws IOException, InterruptedException {

        Log.info("======= START : Gold Coins Test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
         loginHelper.quickLoginViaOtpAutoRead("7042338867", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldCoin("Gold Coins","Know More","About SafeGold");

        Log.info("======= END : Gold Coins Test =======");


    }

    @Test(groups = {"sanity", "goldBuy", "regression"}, priority = 1, description = "Verify Sip On Gold Page")
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


}
