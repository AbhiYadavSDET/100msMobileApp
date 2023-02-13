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

    public void creditCardBillPayment(String amount, String expAmountOnPaymentScreen) throws IOException, InterruptedException {


        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Click on Recharge And PayBills
        ccPage.clickRechargeAndPayBills();

        // Click on outside Swipe Left Bottom Popup
        ccPage.clickSwipeLeftBottomRemove();

        // Click on Credit card payment option
        ccPage.clickOnCreditCardPayment();


        //Close Email Sync Bottom sheet
        if(syncEmailBottomSheet.checkEmailSyncBottomSheet())
        {
            syncEmailBottomSheet.clickSyncEmailBottomSheet();
        }

//        //Close Email sync bottom sheet
//        ccPage.clickSyncEmailBottomSheet();
//
//        //Click on Add new credit card option
//        ccPage.clickAddNewCreditCard();

        //Click on Enter card number text box
        ccPage.clickEnterCardNumber();

        //Enter credit card number
        ccPage.clickFourButton();
        ccPage.clickThreeButton();
        ccPage.clickSevenButton();
        ccPage.clickFiveButton();
        ccPage.clickFiveButton();
        ccPage.clickOneButton();
        ccPage.clickFiveButton();ccPage.clickFiveButton();ccPage.clickFiveButton();ccPage.clickFiveButton();ccPage.clickFiveButton();
        ccPage.clickFiveButton();ccPage.clickFiveButton();ccPage.clickFiveButton();ccPage.clickFiveButton();ccPage.clickFiveButton();


        //Click on Enter card number text box
        ccPage.clickEnterCardNumber();

        //Click Continue CTA
        ccPage.clickContinueCTA();

        //click on enter amount manually
        ccPage.clickEnterAmountManually();

        //Enter amount
        ccPage.clickEnterAmountField();

        //Enter 100 rupees amount
        ccPage.clickOneButton();
        ccPage.clickZeroButton();
        ccPage.clickZeroButton();


        //click Continue CTA
        ccPage.clickContinueCTA();

        // Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false);




    }



    }




