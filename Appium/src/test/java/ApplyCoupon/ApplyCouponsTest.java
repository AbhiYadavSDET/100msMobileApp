package ApplyCoupon;

import Helpers.CouponsHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApplyCouponsTest extends TestBase {

    @Test(groups = {"sanity", "applyCoupons"}, priority = 0, description = "apply coupons")
    public void applyCoupon() throws IOException, InterruptedException {


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Apply Coupons =======");

        //    Execute the test
        CouponsHelper couponsHelper = new CouponsHelper(getAndroidDriver());
        couponsHelper.applyCoupons("10","IPHONE13","Thank you for participating","IPHONE13");

        Log.info("======= END : Apply Coupons =======");


    }
}
