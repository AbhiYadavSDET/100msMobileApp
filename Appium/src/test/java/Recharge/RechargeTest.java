package Recharge;

import Helpers.RechargeHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;

public class RechargeTest extends TestBase {

    @Test(groups = {"sanity", "rechargeSanity" , "regression" }, priority = 1, description = "mobile Recharge")
    public void Recharge_Test01_postpaid_Recharge() throws IOException, InterruptedException {


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        Log.info("======= START : Postpaid Recharge =======");

     //    Execute the test
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.postpaidRecharge("1","₹1","Payment Successful","for Jio 9311878235 ","₹1","Jio Bill Payment", "-₹1", "Success");

        Log.info("======= END : Postpaid Recharge =======");


    }

    @Test(groups = {"sanity1", "regression"}, priority = 1, description = "mobile Recharge")
    public void Recharge_Test02_prepaid_Recharge() throws IOException, InterruptedException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        Log.info("======= START : Prepaid Recharge =======");

        // Execute the test
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.prepaidRecharge("10","₹10","Recharge Successful","for Vi 7795709569 ","₹10","Vi Recharge", "-₹10", "Success");

        Log.info("======= END : Prepaid Recharge =======");


    }

    @Test(groups = {"sanity1", "rechargeSanity", "regression"}, priority = 1, description = "Verify change operator flow")
    public void Recharge_Test03_changeOperator() throws IOException, InterruptedException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        Log.info("======= START : Change Operator Flow test  =======");

        // Execute the test
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.changeOperator("Delhi","MTNL prepaid","Delhi");

        Log.info("======= END : Change Operator Flow test  =======");


    }

    @Test(groups = {"sanity1", "rechargeSanity", "regression"}, priority = 1, description = "Change prepaid to postpaid")
    public void Recharge_Test04_changePrepaidToPostpaid() throws IOException, InterruptedException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        Log.info("======= START : Postpaid Recharge =======");

        // Execute the test
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.changePrepaidToPostpaid("9311878235","Delhi","Reliance prepaid","Delhi");

        Log.info("======= END : Prepaid Recharge =======");


    }

    @Test(groups = {"sanity1", "rechargeSanity", "regression"}, priority = 0, description = "Coupon code handling")
    public void Recharge_Test05_couponCodeHandle() throws IOException, InterruptedException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        Log.info("======= START : Coupon Code =======");

        // Execute the test
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.couponCodeHandling("10","Coupon code is invalid","7042338867");
        Log.info("======= END : Prepaid Recharge =======");

    }

}
