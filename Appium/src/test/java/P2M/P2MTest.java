package P2M;

import Helpers.LoginHelper;
import Helpers.P2MHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class P2MTest extends TestBase {

    @Test(groups = {"sanity", "p2mSend"}, priority = 2, description = "P2M Send test")
    public void Test01_p2mSend() throws IOException, InterruptedException {

        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        P2MHelper p2mHelper = new P2MHelper(getAndroidDriver());
        p2mHelper.p2mSend("RecentMerchant", "1", "You Paid", "₹1", "to dhdn", "dhdn", "9554807271", "Activate Now", "Paid to dhdn", "₹1", "Success");
        Log.info("======= END : P2M Send test =======");

    }


    @Test(groups = {"p2mSend", "p2mSendMobikwikQr"}, priority = 1, description = "P2M Send test")
    public void Test01_p2mSendMobikwikQr() throws IOException, InterruptedException {

        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        P2MHelper p2mHelper = new P2MHelper(getAndroidDriver());
        p2mHelper.p2mSend("MobikwikQr", "1", "You Paid", "₹1", "to Rizwan Cafe FF", "Rizwan Cafe FF", "AABR50750", "Activate Now", "Paid to Rizwan Cafe FF", "₹1", "Success");
        Log.info("======= END : P2M Send test =======");


    }


    @Test(groups = {"p2mSend", "p2mSendRecentMerchant"}, priority = 2, description = "P2M Send test")
    public void Test01_p2mSendRecentMerchant() throws IOException, InterruptedException {

        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        P2MHelper p2mHelper = new P2MHelper(getAndroidDriver());
        p2mHelper.p2mSend("RecentMerchant", "1", "You Paid", "₹1", "to dhdn", "dhdn", "9554807271", "Activate Now", "Paid to dhdn", "₹1", "Success");
        Log.info("======= END : P2M Send test =======");

    }

    @Test(groups = { "p2mSend", "p2mSendSonuQr"}, priority = 3, description = "P2M Send test")
    public void Test01_p2mSendSonuQr() throws IOException, InterruptedException {

        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        P2MHelper p2mHelper = new P2MHelper(getAndroidDriver());
        p2mHelper.p2mSend("SonuQr", "1", "You Paid", "₹1", "to Bayleaf @ MobiKwik", "Bayleaf @ MobiKwik", "BLF001", "Activate Now", "Paid to Bayleaf @ MobiKwik", "₹1", "Success");
        Log.info("======= END : P2M Send test =======");


    }


}
