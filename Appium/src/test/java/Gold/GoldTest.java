package Gold;

import Helpers.GoldHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class GoldTest extends TestBase {


    @Test(groups = {"sanity", "goldBuy" , "regression"}, priority = 1, description = "Verify Gold Buy")
    public void Test01_buyGold() throws IOException, InterruptedException {

        Log.info("======= START : Gold Buy test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldBuy("1", "Payment Successful", "Gold Purchase", "0.0002", "₹1","Purchased Gold", "₹1", "Success");

        Log.info("======= END : Gold Buy test =======");


    }

    @Test(groups = {"sanity", "goldSell", "regression"}, priority = 0, description = "Verify Gold Sell")
    public void Test02_buySell() throws IOException, InterruptedException {

        Log.info("======= START : Gold Sell test =======");


        // Login to the account
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.goldSell("1", "Payment Successful", "Sell Gold", "0.0002", "₹1","Sold Gold", "+ ₹1", "Success");

        Log.info("======= END : Gold Sell test =======");


    }

}
