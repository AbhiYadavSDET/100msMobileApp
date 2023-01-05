package Helpers;

import Logger.Log;
import PageObject.GoldPage;
import PageObject.P2MPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class P2MHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    GoldPage goldPage;
    P2MPage p2mPage;
    Screen screen;
    MBReporter mbReporter;


    public P2MHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        goldPage = new GoldPage(driver);
        p2mPage = new P2MPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void p2mSend(String merchantCode, String amount, String expStatus, String expAmount, String expReceiverName, String expMerchantName, String expMerchantCode, String expZipCtaText) throws InterruptedException, IOException {

        // Tap the QR code Icon on Homepage
        p2mPage.clickScanQR();

        // Allow the Permission
        Thread.sleep(3000);
        p2mPage.allowPermission();

        // Click on merchant code text box
        p2mPage.clickMerchantCodeTextBox();

        // Allow the Permission
        p2mPage.allowPermission2();

        // enter the merchant code
        p2mPage.enterMerchantCode(merchantCode);

        // select the merchant
        p2mPage.selectMerchant();

        // Enter the amount
        p2mPage.enterAmount(amount);

        // Click on the Confirm Payment CTA
        p2mPage.clickConfirmPayment();

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
        mbReporter.verifyEquals(actualStatus, expStatus, "Verify Title", false, false);
        mbReporter.verifyEquals(actualAmount, expAmount, "Verify Sub Title", false, false);
        mbReporter.verifyEquals(actualReceiverName, expReceiverName, "Verify Gold Amount", false, false);
        mbReporter.verifyEquals(actualMerchantName, expMerchantName, "Verify Amount", false, false);
        mbReporter.verifyEquals(actualMerchantCode, expMerchantCode, "Verify Amount", false, false);
        mbReporter.verifyEquals(actualZipCtaText, expZipCtaText, "Verify Amount", false, false);


        // Click on the up Icon


        // Click on Home


    }


}
