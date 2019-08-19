package RechargeAndBill;

import Helpers.Recharge.MobileHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class MobileRechargeTest extends TestBase {

    @Test(groups = {"recharge"}, priority = 0, description = "Verify Mobile prepaid bill")
    public void Test_Prepaid() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
        mobileHelper.verifyPrepaid("vodafone", "9953138474", "haryana", "10", false, "APPTEAMREC", "5.0");

    }

    @Test(groups = {"recharge"}, priority = 1, description = "Verify Mobile postpaid bill")
    public void Test_Postpaid() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
        mobileHelper.verifyPostpaid("Vodafone", "7795709569", "Delhi", "1");

    }

    @Test(groups = {"recharge"}, priority = 2, description = "Verify Mobile prepaid bill with promo code")
    public void Test_Prepaid_promo() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
        mobileHelper.verifyPrepaid("vodafone", "9999301210", "haryana", "10", true, "APPTEAMREC", "5.0");

    }
}
