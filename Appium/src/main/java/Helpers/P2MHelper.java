package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class P2MHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    GoldPage goldPage;
    P2MPage p2mPage;
    SecurityPinPage securityPinPage;
    CustomKeyboardPage customKeyboardPage;
    Screen screen;
    MBReporter mbReporter;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    P2PPage p2PPage;


    public P2MHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        goldPage = new GoldPage(driver);
        p2mPage = new P2MPage(driver);
        customKeyboardPage = new CustomKeyboardPage(driver);
        securityPinPage = new SecurityPinPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        p2PPage = new P2PPage(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void p2mSend(String merchant, String amount, String Number, String expStatus, String expAmount, String expReceiverName, String expMerchantName, String expMerchantCode, String expZipCtaText, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Tap the QR code Icon on Homepage
       // p2mPage.clickScanQR();

        // Tap on See All Services
        p2PPage.clickAllServices();

        // Click on Scan Any Qr
        p2PPage.clickScanQrOptn();

        // Allow the Permission
        if(p2mPage.checkWhileUsingAppPermission()){ p2mPage.allowPermissionWhileUsingApp();}
        {

            // Click on merchant code text box
            p2mPage.clickOnGallery();

            // Allow the Permission
            if(p2mPage.checkAllowPermissionForGallery()) p2mPage.allowPermissionAllow();

            if(merchant.equals("MobikwikQr")){
                p2mPage.clickOnMBKQrCodeGallery();
            }
            else if(merchant.equals("SonuQr")){
                p2mPage.clickOnSonuQrCodeGallery();
            }
        }

        // Enter the amount
        customKeyboardPage.enterAmount(amount);

        // Click on the Continue CTA
        if(merchant.equals("RecentMerchant")){
            p2mPage.clickConfirmPayment();
        }
        else {
            p2mPage.clickOnContinue();
        }

        // Click on the Confirm Payment CTA
        p2mPage.clickConfirmPayment();

        if(merchant.equals("RecentMerchant") && p2mPage.checkEnterDetailsBottomsheet()){
            p2mPage.enterPhoneNumber(Number);
            p2mPage.clickConfirmPaymentBtn();
        //  p2mPage.clickBackButtonOnStatusScreen();
        }

        // checking for security pin
        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin();
        }

        // Verification on the Success Screen
        String actualStatus = p2mPage.getStatus();
        String actualAmount = p2mPage.getAmount();
        String actualReceiverName = p2mPage.getReceiverName();
        String actualMerchantName = p2mPage.getMerchantName();
        String actualMerchantCode = p2mPage.getMerchantCode();
        String actualZipCtaText = p2mPage.getZipCtaText();

        // Display the values
        Log.info("Status : " + actualStatus);
        Log.info("Amount : " + actualAmount);
        Log.info("Receiver Name : " + actualReceiverName);
        Log.info("Merchant Name : " + actualMerchantName);
        Log.info("Merchant Code : " + actualMerchantCode);
        Log.info("Zip Cta Text : " + actualZipCtaText);


        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualStatus, expStatus, "Verify Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualAmount, expAmount, "Verify Sub Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualReceiverName, expReceiverName, "Verify Gold Amount", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualMerchantName, expMerchantName, "Verify Amount", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualMerchantCode, expMerchantCode, "Verify Amount", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualZipCtaText, expZipCtaText, "Verify Amount", false, false, true);


        // Click on the up Icon
        p2mPage.clickUpButton();

        // Click Cross Buttonm
        if (p2mPage.checkBackButton()) p2mPage.clickBackButton();

        // Click on the up Icon
        // p2mPage.clickUpButton();
        //if (p2mPage.checkBackButton()) p2mPage.clickBackButton();

        // Click on the back button if the bottom sheet is present
        Thread.sleep(3000);
        if (Elements.isElementPresent(driver, p2mPage.upiBottomSheetCta)) {
            Elements.back(driver, "Navigate Back");
        }

        // Handle home page pop-up after transaction
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Assertions on the balance deducted
       mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);

    }


    public void p2mVerify(String flow, String expTitle, String expText) throws InterruptedException, IOException {

        // Tap the QR code Icon on Homepage
        //p2mPage.clickScanQR();

        // Tap on See All Services
        p2PPage.clickAllServices();

        // Click on Scan Any Qr
        p2PPage.clickScanQrOptn();

        // Allow the Permission
        if(p2mPage.checkWhileUsingAppPermission()){ p2mPage.allowPermissionWhileUsingApp();}
        else if(p2mPage.checkAllowPermission()){ p2mPage.allowPermissionAllow(); }

        String actualTitle;
        String actualText;

        if(flow.equals("NearbyStores")){

            // Click on the up Nearby Stores
            p2mPage.clickOnNearbyStores();

            // Allow the Permission
            p2mPage.allowPermissionWhileUsingApp();

            // Verification on the Success Screen
            actualTitle = p2mPage.getCurrentLocationTitle();
            actualText = p2mPage.getStoreByAddress();
        }
        else {

            // Click on the up Nearby Stores
            p2mPage.clickOnOfflinePaymentCode();

            // Allow the Permission
            if(p2mPage.checkWhileUsingAppPermission()){ p2mPage.allowPermissionWhileUsingApp();}

            // Verification on the Success Screen
            actualTitle = p2mPage.getPayAtStoreTitle();
            actualText = p2mPage.getInstructionText();

        }

        // Display the values
        Log.info("Title : " + actualTitle);
        Log.info("Text : " + actualText);


        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualText, expText, "Verify Text", false, false, true);



    }


}
