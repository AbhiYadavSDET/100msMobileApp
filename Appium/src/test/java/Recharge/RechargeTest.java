package Recharge;

import Helpers.RechargeHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;

public class RechargeTest extends TestBase {

    @Test(groups = {"sanity", "mobileRecharge"}, priority = 0, description = "mobile Recharge")
    public void postpaid_Recharge() throws IOException, InterruptedException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Postpaid Recharge =======");

     //    Execute the test
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.postpaidRecharge("1","₹1","Payment Successful","for Jio 9311878235 ","₹1","Jio Bill Payment", "₹1", "Success");

        Log.info("======= END : Postpaid Recharge =======");


    }

    @Test(groups = {"sanity", "mobileRecharge"}, priority = 1, description = "mobile Recharge")
    public void prepaid_Recharge() throws IOException, InterruptedException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Postpaid Recharge =======");

        // Execute the test
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.prepaidRecharge("10","₹10","Recharge Successful","for Vi 7795709569 ","₹10","Vi Recharge", "₹10", "Success");

        Log.info("======= END : Prepaid Recharge =======");


    }

}
