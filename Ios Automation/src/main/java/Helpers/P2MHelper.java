package Helpers;

import Logger.Log;

import PageObject.P2MPage;
import PageObject.SecurityPinPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

public class P2MHelper {

    IOSDriver<IOSElement> driver;
    Elements elements;
    P2MPage p2mPage;
    SecurityPinPage securityPinPage;
    Screen screen;
    MBReporter mbReporter;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;



    public P2MHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);

        p2mPage = new P2MPage(driver);

        securityPinPage = new SecurityPinPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void p2mSend(String merchant, String amount, String expStatus, String expAmount, String expReceiverName, String expMerchantName, String expMerchantCode, String expZipCtaText, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX

        // Tap the QR code Icon on Homepage
        p2mPage.clickScanQR();

        // Allow the Permission
        if(p2mPage.checkIfCameraPermissionNeeded()){
            p2mPage.allowPermissionWhileUsingApp();
        }

        if(merchant.equals("RecentMerchant")){
            p2mPage.clickOnRecentMerchant();

        }else{

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
//        customKeyboardPage.enterAmount(amount);

        // Click on the Continue CTA
        p2mPage.clickOnContinue();

        // Click on the Confirm Payment CTA
        p2mPage.clickConfirmPayment();

        // checking for security pin
        if(securityPinPage.isSecurityPinPageShown())
        {
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


    }



}
