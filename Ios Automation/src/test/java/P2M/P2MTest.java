package P2M;

import Helpers.LoginHelper;
import Helpers.P2MHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class P2MTest extends TestBase {

    @Test(groups = { "p2m", "p2mSend", "p2mSendMobikwikQr", "regression"}, priority = 1, description = "P2M Send test")
    public void Test01_p2mSendMobikwikQr() throws IOException, InterruptedException {

        Log.info("======= START : P2M Send test : Mobikwik QR =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        // Execute the test
        P2MHelper p2mHelper = new P2MHelper(getIosDriver());
        p2mHelper.p2mSend("MobikwikQr", "1", "You Paid", "₹1", "manoj", "AACH41414");
        Log.info("======= END : P2M Send test =======");


    }


    @Test(groups = { "p2m", "p2mSend", "p2mSendRecentMerchant", "regression"}, priority = 2, description = "P2M Send test")
    public void Test02_p2mSendRecentMerchant() throws IOException, InterruptedException {

        Log.info("======= START : P2M Send test : Recent Merchants =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        // Execute the test
        P2MHelper p2mHelper = new P2MHelper(getIosDriver());
        p2mHelper.p2mSend("RecentMerchant", "1", "You Paid", "₹1", "manoj", "AACH41414");
        Log.info("======= END : P2M Send test =======");

    }

    @Test(groups = {"p2mSendSonuQr"}, priority = 3, description = "P2M Send test")
    public void Test03_p2mSendSonuQr() throws IOException, InterruptedException {

        Log.info("======= START : P2M Send test : Sonu QR =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        // Execute the test
        P2MHelper p2mHelper = new P2MHelper(getIosDriver());
        p2mHelper.p2mSend("SonuQr", "1", "You Paid", "₹1", "Sonu Kumar", "Sonu");
        Log.info("======= END : P2M Send test =======");


    }



}
