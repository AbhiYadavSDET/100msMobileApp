package Gold;

import Helpers.GoldHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class GoldTest extends TestBase {


    @Test(groups = {"sanity", "goldBuy", "regression"}, priority = 1, description = "Verify Gold Buy")
    public void Test01_buyGold() throws IOException, InterruptedException {

        Log.info("======= START : Gold Buy test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldBuy("1", "Payment Successful", "Gold Purchase", "0.0002", "₹1", "Purchased Gold", "-₹1", "Success");

        Log.info("======= END : Gold Buy test =======");


    }

        @Test(groups = {"sanity", "goldSell", "regression"}, priority = 1, description = "Verify Safe Gold Coins data")
    public void Test02_buySell() throws IOException, InterruptedException {

        Log.info("======= START : Gold Sell test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
         loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372"); 

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldSell("1", "Payment Successful", "Sell Gold", "0.0002", "₹1", "Sold Gold", "+₹1", "Success");

        Log.info("======= END : Gold Sell test =======");


    }


    @Test(groups = {"sanity1", "goldCoin", "regression"}, priority = 1, description = "Verify Safe Gold Coin")
    public void Test03_SafeGoldCoin() throws IOException, InterruptedException {

        Log.info("======= START : Gold Coins Test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
         loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372"); 

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldCoin("Gold Coins","Know More","About SafeGold");

        Log.info("======= END : Gold Coins Test =======");


    }

    @Test(groups = {"sanity", "goldBuy", "regression"}, priority = 0, description = "Verify Sip On Gold Page")
    public void Test04_Gold_Sip() throws IOException, InterruptedException {

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
