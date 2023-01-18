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

public class RechargeHelper {


    AndroidDriver<AndroidElement> driver;
    RechargePage rechargePage;
    LoginPage loginPage;
    HomePage homePage;
    PermissionPage permissionsPage;
    Screen screen;
    MBReporter mbReporter;



    public RechargeHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        rechargePage=new RechargePage(driver);
        loginPage = new LoginPage(driver);
        homePage=new HomePage(driver);
        permissionsPage=new PermissionPage(driver);
        mbReporter=new MBReporter(driver);
    }


    public void postpaidRecharge(String amount, String expAmountOnPaymentScreen, String expTitle, String expSubTitle, String expAmountOnSuccessScreen) throws InterruptedException, IOException {

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        // Click on outside Swipe Left Bottom Popup
        rechargePage.clickSwipeLeftBottomRemove();

        // Click on Mobile
        rechargePage.clickOnMobile();

        // Click on Postpaid
        rechargePage.clickOnPostpaid();

        // Click on Select Number
        rechargePage.selectNumber();

        // Enter amount on payment screen
        rechargePage.setEnterAmountPostpaid(amount);

        // Click on Continue
        rechargePage.selectNumber();

        rechargePage.clickOnContinue();


        // Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false);

        rechargePage.clickOnPay();

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

    }

}
