package Helpers;

import PageObject.*;
import Utils.MBReporter;
import Utils.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RechargeHelper {


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



    public RechargeHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        rechargePage = new RechargePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        permissionsPage = new PermissionPage(driver);
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    }


    public void postpaidRecharge(String amount, String expAmountOnPaymentScreen, String expTitle, String expSubTitle, String expAmountOnSuccessScreen,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

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


        // Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false);

        rechargePage.clickOnPay();

        // checking for security pin
        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin();
        }

        // Verification on the Success Screen
        String title = rechargePage.getTitle();
        String subTitle = rechargePage.getSubTitle();
        String amountOnSuccesScreen = rechargePage.getAmountOnSuccessScreen();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Amount On Success Screen : " + amountOnSuccesScreen);


        // Add the assertions
        mbReporter.verifyEquals(title, expTitle, "Verify Title", false, false);
        mbReporter.verifyEquals(subTitle, expSubTitle, "Verify Sub Title", false, false);
        mbReporter.verifyEquals(amountOnSuccesScreen, expAmountOnSuccessScreen, "Verify Gold Amount", false, false);

        mbkCommonControlsHelper.pressback(3);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);


    }


    public void prepaidRecharge(String amount, String expAmountOnPaymentScreen, String expTitle, String expSubTitle, String expAmountOnSuccessScreen,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        // Click on outside Swipe Left Bottom Popup
        rechargePage.clickSwipeLeftBottomRemove();

        // Click on Mobile
        rechargePage.clickOnMobile();

        // Click on Select Number
        rechargePage.selectNumberPrepaid();

        // Tap to search plan
        rechargePage.tapToSearchPlan();

        // Enter amount to search plan
        rechargePage.searchPlanPrepaid(amount);

        // Click to select plan
        rechargePage.selectPlan();


        // Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false);

        rechargePage.clickOnPay();

        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin();
        }

        // Verification on the Success Screen
        String title = rechargePage.getTitle();
        String subTitle = rechargePage.getSubTitle();
        String amountOnSuccesScreen = rechargePage.getAmountOnSuccessScreen();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Amount On Success Screen : " + amountOnSuccesScreen);


        // Add the assertions
        mbReporter.verifyEquals(title, expTitle, "Verify Title", false, false);
        mbReporter.verifyEquals(subTitle, expSubTitle, "Verify Sub Title", false, false);
        mbReporter.verifyEquals(amountOnSuccesScreen, expAmountOnSuccessScreen, "Verify Gold Amount", false, false);

        mbkCommonControlsHelper.pressback(3);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);

    }

}
