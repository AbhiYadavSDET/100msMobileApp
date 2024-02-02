package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.LinkedHashMap;

public class CouponsHelper {


    AndroidDriver<AndroidElement> driver;
    RechargePage rechargePage;
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
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        couponsPage = new CouponsPage(driver);
        ccPage = new CCPage(driver);
    }

    public void applyCoupons(String amount, String couponCode, String expCouponMessage, String expCouponApplied, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus )throws IOException, InterruptedException{

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();
        String superCashBefore = balanceBefore.get("Supercash");

        // scroll to Recharge And PayBills
        rechargePage.scrollToRechargeAndPayBills();

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
        mbReporter.verifyEqualsWithLogging(couponApplied, expCouponApplied, "Verify Coupon Applied on Payment screen", false, false,true);

        //Click on Pay button
        ccPage.clickOnPay();

        // checking for security pin
        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin();
        }

        //Verification on Payment success screen
        String couponMessage = couponsPage.getMessage();
        Log.info("Coupon Message on Payment success screen: " + couponMessage);
        mbReporter.verifyEqualsWithLogging(couponMessage, expCouponMessage, "Verify Coupon Message on Payment Success screen", false, false,true);

        mbkCommonControlsHelper.pressback(3);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();
        String superCashAfter = balanceAfter.get("Supercash");


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);



    }

    public void applySuperCash(String amount, String expCouponApplied, String expBillAmount, String expSuperCashAmount, String expTotalAmount, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus )throws IOException, InterruptedException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        String superCashBefore = balanceBefore.get("Supercash");

        // scroll to Recharge And PayBills
        rechargePage.scrollToRechargeAndPayBills();

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


        // Verification on the Payment  Confirmation Screen
        String couponApplied = couponsPage.getCouponApplied();
        Log.info("Amount on Payment Screen : " + couponApplied);
        mbReporter.verifyEquals(couponApplied, expCouponApplied, "Verify Coupon Applied on Payment screen", false, false);

        String billAmount = couponsPage.getBilAmount();
        String superCashAmount = couponsPage.getSuperCashAmount();
        String totalAmount = couponsPage.getTotalAmount();

        // Display the values
        Log.info("Bill Amount : " + billAmount);
        Log.info("SuperCash Amount : " + superCashAmount);
        Log.info("Total Amount : " + totalAmount);


        // Add the assertions
        mbReporter.verifyEqualsWithLogging(billAmount, expBillAmount, "Verify Bill Amount on Payment Confirmation Screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(superCashAmount, expSuperCashAmount, "Verify SuerCash Amount on Payment Confirmation Screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(totalAmount, expTotalAmount, "Verify Total Amount on Payment Confirmation Screen", false, false, true);


        //Click on Pay button
        ccPage.clickOnPay();

        // checking for security pin
        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin();
        }

        mbkCommonControlsHelper.pressback(3);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();
        String superCashAfter = balanceAfter.get("Supercash");

        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");


        Log.info(Log.ANSI_GREEN + "SuperCash Balance Before : " + superCashBefore + Log.ANSI_RESET);


        Log.info(Log.ANSI_GREEN + "SuperCash Balance After : " + superCashAfter + Log.ANSI_RESET);


        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);

    }

}
