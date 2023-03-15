package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

public class CouponsHelper {


    AndroidDriver<AndroidElement> driver;
    RechargePage rechargePage;
    LoginPage loginPage;
    HomePage homePage;
    PermissionPage permissionsPage;
    Screen screen;
    MBReporter mbReporter;
    SecurityPinPage securityPinPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;
    CouponsPage couponsPage;
    CCPage ccPage;



    public CouponsHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        rechargePage = new RechargePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        permissionsPage = new PermissionPage(driver);
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        couponsPage = new CouponsPage(driver);
        ccPage = new CCPage(driver);
    }

    public void applyCoupons(String amount, String couponCode, String expMessage, String expCouponApplied )throws IOException, InterruptedException{

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        // Click on outside Swipe Left Bottom Popup
        rechargePage.clickSwipeLeftBottomRemove();

        // Click on Mobile
        rechargePage.clickOnMobile();

        // Click on Postpaid
        rechargePage.clickOnPostpaid();

        // Click on Select Number
        rechargePage.selectNumberPostpaid();

        // Enter amount on payment screen
        rechargePage.setEnterAmountPostpaid(amount);

        // Click on Continue
        rechargePage.clickOnContinue();

        //Click on Apply coupon option
        ccPage.clickApplyCoupon();

        //Enter coupon code
        couponsPage.enterEnterCouponCode(couponCode);

        //Click Apply button after entering coupon code
        ccPage.clickApplyButton();


        // Verification on the Payment Screen
        String couponApplied = couponsPage.getCouponApplied();
        Log.info("Amount on Payment Screen : " + couponApplied);
        mbReporter.verifyEquals(couponApplied, expCouponApplied, "Verify Coupon Applied on Payment screen", false, false);



    }

    public void applySuperCash(String amount, String couponCode, String expCouponApplied )throws IOException, InterruptedException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        // Click on outside Swipe Left Bottom Popup
        rechargePage.clickSwipeLeftBottomRemove();

        // Click on Mobile
        rechargePage.clickOnMobile();

        // Click on Postpaid
        rechargePage.clickOnPostpaid();

        // Click on Select Number
        rechargePage.selectNumberPostpaid();

        // Enter amount on payment screen
        rechargePage.setEnterAmountPostpaid(amount);

        // Click on Continue
        rechargePage.clickOnContinue();

        //Click on Apply coupon option
        ccPage.clickApplyCoupon();

        //Apply SuperCash
        couponsPage.clickApplySuperCash();


        // Verification on the Payment Screen
        String couponApplied = couponsPage.getCouponApplied();
        Log.info("Amount on Payment Screen : " + couponApplied);
        mbReporter.verifyEquals(couponApplied, expCouponApplied, "Verify Coupon Applied on Payment screen", false, false);

    }

}
