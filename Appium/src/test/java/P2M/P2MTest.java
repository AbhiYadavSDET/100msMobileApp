package P2M;

import Helpers.LoginHelper;
import Helpers.P2MHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class P2MTest extends TestBase {


    @Test(groups = {"sanity", "p2mSend"}, priority = 0, description = "Wallet To Wallet transfer")
    public void Test01_p2mSend() throws IOException, InterruptedException {

        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("P2M Send test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        P2MHelper p2mHelper = new P2MHelper(getAndroidDriver());
        p2mHelper.p2mSend("blf001", "1", "You Paid", "₹1", "to Bayleaf @ MobiKwik", "Bayleaf @ MobiKwik", "BLF001", "Activate Now", "Paid to Bayleaf @ MobiKwik", "₹1", "Success");

        Log.info("======= END : P2M Send test =======");


    }
}
