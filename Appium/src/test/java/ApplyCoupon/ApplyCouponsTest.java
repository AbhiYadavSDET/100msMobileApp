package ApplyCoupon;

import Helpers.CouponsHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApplyCouponsTest extends TestBase {

    @Test(groups = {"sanity", "applyCoupons"}, priority = 1, description = "apply coupons")
    public void applyCoupon() throws IOException, InterruptedException {


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8527029916", "");

        Log.info("======= START : Apply Coupons =======");

        //    Execute the test
        CouponsHelper couponsHelper = new CouponsHelper(getAndroidDriver());
        couponsHelper.applyCoupons("10","EARN500","Thank you for participating","EARN500 Applied!","SuperCash for coupon EARN500","+ ₹0.10","Success");

        Log.info("======= END : Apply Coupons =======");


    }
    @Test(groups = {"sanity", "applyCoupons"}, priority = 0, description = "apply coupons")
    public void applySuperCash() throws IOException, InterruptedException {


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8527029916", "");

        Log.info("======= START : Apply SuperCash =======");

        //    Execute the test
        CouponsHelper couponsHelper = new CouponsHelper(getAndroidDriver());
        couponsHelper.applySuperCash("1", "SuperCash Applied!","₹1", "- ₹1","₹0","Jio Bill Payment","₹1","Success");

        Log.info("======= END : Apply SuperCash =======");


    }
}
