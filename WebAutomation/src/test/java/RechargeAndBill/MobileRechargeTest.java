package RechargeAndBill;

import Helpers.LoginHelper;
import Helpers.Recharge.MobileHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class MobileRechargeTest extends TestBase {

    @Test(groups = {"recharge"}, priority = 0, description = "Verify Mobile prepaid bill")
    public void Test_Prepaid() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9958314430", "Rashi Agarwal", "amanagarwal30@gmail.com", "9958314430");

        MobileHelper mobileHelper = new MobileHelper(driver);
        mobileHelper.verifyPrepaid("bsnl", "9461528145", "Rajasthan", "10");

    }

    @Test(groups = {"recharge"}, priority = 0, description = "Verify Mobile postpaid bill")
    public void Test_Postpaid() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9958314430", "Rashi Agarwal", "amanagarwal30@gmail.com", "9958314430");

        MobileHelper mobileHelper = new MobileHelper(driver);
        mobileHelper.verifyPostpaid("Airtel", "9958314430", "Delhi", "50");

    }
}
