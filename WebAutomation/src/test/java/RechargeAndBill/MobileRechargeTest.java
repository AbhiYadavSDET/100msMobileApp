package RechargeAndBill;

import Helpers.LoginHelper;
import Helpers.Recharge.MobileHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class MobileRechargeTest extends TestBase {

    @Test(groups = {"rechargeMobile"}, priority = 0, description = "Verify Mobile prepaid bill")
    public void Test_Prepaid() throws InterruptedException, IOException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9149237812", "Sumit Chauhan", "sumitch853@gmail.com", "9149237812");

        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
        mobileHelper.verifyPrepaid("jio", "9149237812", "up(west)", "15", false, "APPTEAMREC", "5.0","4799470274582974","07","2027", "443", "521991");

    }

//    @Test(groups = {"recharge"}, priority = 1, description = "Verify Mobile postpaid bill")
//    public void Test_Postpaid() throws InterruptedException {
////        LoginHelper loginHelper = new LoginHelper(driver);
////        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");
//
//        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
//        mobileHelper.verifyPostpaid("Vodafone", "7795709569", "Delhi", "1");
//
//    }
//
//    @Test(groups = {"recharge"}, priority = 2, description = "Verify Mobile prepaid bill with promo code")
//    public void Test_Prepaid_promo() throws InterruptedException {
////        LoginHelper loginHelper = new LoginHelper(driver);
////        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");
//
//        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
//        mobileHelper.verifyPrepaid("vodafone", "9999301210", "haryana", "10", true, "APPTEAMREC", "5.0");
//
//    }
}
