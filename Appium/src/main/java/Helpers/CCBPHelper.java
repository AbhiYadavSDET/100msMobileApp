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

public class CCBPHelper {

    AndroidDriver<AndroidElement> driver;
    RechargePage rechargePage;
    CCPage ccPage;
    LoginPage loginPage;
    HomePage homePage;
    PermissionPage permissionsPage;
    Screen screen;
    MBReporter mbReporter;
    SecurityPinPage securityPinPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;
    SyncEmailBottomSheet syncEmailBottomSheet;
    private String expAmountOnPaymentScreen;


    public CCBPHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        rechargePage = new RechargePage(driver);
        ccPage = new CCPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        permissionsPage = new PermissionPage(driver);
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        syncEmailBottomSheet = new SyncEmailBottomSheet(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    }

    public static String actualDeductedAmount(String amount){

        double deductedAmount = Double.parseDouble(amount);
        double totalDeductedAmount = (101.18 * deductedAmount)/100;

        String newAmount = String.valueOf(totalDeductedAmount);

        return newAmount;
    }

    public void creditCardBillPayment(String amount, String expAmountOnPaymentScreen, String cardNumber, String expTitle, String expSubTitle, String expAmountOnSuccessScreen, String expectedHistoryDescription, String expectedHistoryStatus, String expectedHistoryAmount) throws IOException, InterruptedException {


        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // scroll to Recharge And PayBills
        ccPage.scrollToRechargeAndPayBills();

        // Click on Recharge And PayBills
        ccPage.clickRechargeAndPayBills();

        if (rechargePage.clickMobileRechargeAlert()) {
            rechargePage.clickToCloseMobileRechargeAlert();
        }

        if(rechargePage.checkAutoPayBottomsheet()) {
            rechargePage.clickSkipbtn();
        }

        // Click on outside Swipe Left Bottom Popup
        ccPage.clickSwipeLeftBottomRemove();

        // Click on Credit card payment option
        ccPage.clickOnCreditCardPayment();


        //Close Email Sync Bottom sheet
        if(syncEmailBottomSheet.checkEmailSyncBottomSheet())
        {
            syncEmailBottomSheet.clickSyncEmailBottomSheet();
        }

        if(ccPage.getAddNewCreditCard()){
            //Click Add new credit card
            ccPage.clickAddNewCreditCard();

        }else{
            ccPage.clickOnAddCardButton();
        }

        //Click on Enter card number text box
        ccPage.clickEnterCardNumber();

        ccPage.enterCardNumber(cardNumber);

        //Click Continue CTA
        ccPage.clickContinueCTA();

        //click on enter amount manually
        ccPage.clickEnterAmountManually();

        //Enter amount
        ccPage.clickEnterAmountField();

        //Enter amount
        ccPage.enterCardNumber(expAmountOnPaymentScreen);

        //click Continue CTA
        ccPage.clickContinueCTA();

        // Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false);

        ccPage.clickOnPay();

//        //Click on wallet balance
//        ccPage.clickWalletBalance();
//
//        //Click on pay button on Payable amount bottom sheet
//        ccPage.clickPayAmount();
//
//        // checking for security pin
//        if(securityPinPage.checkSecurityPinPage()){
//            securityPinPage.enterSecurityPin();
//        }
//
//        // Verification on the Success Screen
//        String title = ccPage.getTitle();
//        String subTitle = ccPage.getSubTitle();
//        String amountOnSuccesScreen = ccPage.getAmountOnSuccessScreen();
//
//        // Display the values
//        Log.info("Title : " + title);
//        Log.info("Sub Title : " + subTitle);
//        Log.info("Amount On Success Screen : " + amountOnSuccesScreen);
//
//
//        // Add the assertions
//        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false, true);
//        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false, true);
//        mbReporter.verifyEqualsWithLogging(amountOnSuccesScreen, expAmountOnSuccessScreen, "Verify Credit Card Bill Payment Amount", false, false, true);
//
//        mbkCommonControlsHelper.pressback(3);
//
//        // Click on the back button if the bottom sheet is present
//        mbkCommonControlsHelper.handleHomePageLanding();
//
//        // Get the Balance if the User Before TRX
//        balanceAfter = mbkCommonControlsHelper.getBalance();
//
//
//        // Assertions on the balance deducted
//        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, actualDeductedAmount(amount), "Sub");
//
//        // Verify the History details
//        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);

    }

    public void existingUserCCBP(String amount, String expAmountOnPaymentScreen,String expCouponApplied, String cardNumber, String expTitle, String expSubTitle, String expAmountOnSuccessScreen, String expectedHistoryDescription, String expectedHistoryStatus, String expectedHistoryAmount) throws IOException, InterruptedException {
        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // scroll to Recharge And PayBills
        ccPage.scrollToRechargeAndPayBills();

        // Click on Recharge And PayBills
        ccPage.clickRechargeAndPayBills();

        if (rechargePage.clickMobileRechargeAlert()) {
            rechargePage.clickToCloseMobileRechargeAlert();
        }

        if(rechargePage.checkAutoPayBottomsheet()) {
            rechargePage.clickSkipbtn();
        }

        // Click on outside Swipe Left Bottom Popup
        ccPage.clickSwipeLeftBottomRemove();

        // Click on Credit card payment option
        ccPage.clickOnCreditCardPayment();


        //Close Email Sync Bottom sheet
        if(syncEmailBottomSheet.checkEmailSyncBottomSheet())
        {
            syncEmailBottomSheet.clickSyncEmailBottomSheet();
        }
        //Click Pay now button on saved card
        ccPage.clickOnSavedCardPayButton();

        //Enter amount
        ccPage.clickEnterAmountField();

        ccPage.enterCardNumber(expAmountOnPaymentScreen);

        //click Continue CTA
        ccPage.clickContinueCTA();

        //Click Apply coupon option
        ccPage.clickApplyCoupon();

        Thread.sleep(5000);

        //Enter coupon code
        ccPage.enterEnterCouponCode();

        //Click Apply button after entering coupon code
        ccPage.clickApplyButton();

        //Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEqualsWithLogging(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false, true);

        //Verification of coupon applied on the Payment Screen
        String couponApplied = ccPage.getCouponTitle();
        Log.info("Coupon Applied on Payment Screen : " + couponApplied);
        mbReporter.verifyEqualsWithLogging(couponApplied, expCouponApplied, "Verify coupon applied on Payment screen", false, false,true);

        Thread.sleep(3000);
        //Click on Pay button
        ccPage.clickOnPay();

        //Click on wallet balance
//        ccPage.clickWalletBalance();
//
//        //Click on Other payment options
////        ccPage.clickOtherPaymentOptions();
//
//        //Click on pay button on Payable amount bottom sheet
//        ccPage.clickPayAmount();
//
//        // checking for security pin
//        if(securityPinPage.checkSecurityPinPage()){
//            securityPinPage.enterSecurityPin();
//        }
//
//        mbkCommonControlsHelper.handleAddMoney("CCBP", "100", "4375517199762008","04/27","123");
//
//
//        // Verification on the Success Screen
//        String title = ccPage.getTitle();
//        String subTitle = ccPage.getSubTitle();
//        String amountOnSuccesScreen = ccPage.getAmountOnSuccessScreen();
//
//        // Display the values
//        Log.info("Title : " + title);
//        Log.info("Sub Title : " + subTitle);
//        Log.info("Amount On Success Screen : " + amountOnSuccesScreen);
//
//
//        // Add the assertions
//        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false, true);
//        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false, true);
//        mbReporter.verifyEqualsWithLogging(amountOnSuccesScreen, expAmountOnSuccessScreen, "Verify Credit Card Bill Payment Amount", false, false, true);
//
//        mbkCommonControlsHelper.pressback(3);
//
//        // Click on the back button if the bottom sheet is present
//        mbkCommonControlsHelper.handleHomePageLanding();
//
//        // Get the Balance if the User Before TRX
//        balanceAfter = mbkCommonControlsHelper.getBalance();
//
//
//        // Assertions on the balance deducted
//        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, actualDeductedAmount(amount), "Sub");
//
//        // Verify the History details
//        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);


    }
    }





