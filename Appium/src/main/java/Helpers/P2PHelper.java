package Helpers;

import Logger.Log;
import PageObject.GoldPage;
import PageObject.P2MPage;
import PageObject.P2PPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

public class P2PHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    GoldPage goldPage;
    P2PPage p2PPage;
    P2MPage p2MPage;
    Screen screen;
    MBReporter mbReporter;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;
    MBKCommonControlsHelper mbkCommonControlsHelper;


    public P2PHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        goldPage = new GoldPage(driver);
        p2PPage = new P2PPage(driver);
        p2MPage = new P2MPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void p2pSend(String mobileNo, String amount, String expStatus, String expAmount, String expReceiverName, String expReceiverMobileNo, String expPaymentMode, String expZipCtaText) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Tap on See All Services
        p2PPage.clickAllServices();

        // Swipe till the bottom
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        //screen.swipeUpMore(driver);

        // Click on Wallet to Wallet Transfer
        p2PPage.clickP2PButton();

        // Enter Mobile No
        p2PPage.enterMobileNo(mobileNo);

        // Enter the amount
        p2PPage.enterAmount(amount);

        // Click on Transfer Now CTA
        p2PPage.clickTransferNowCta();

        // Verification on the Success Screen
        String actualStatus = p2PPage.getStatus();
        String actualAmount = p2PPage.getAmount();
        String actualReceiverName = p2PPage.getReceiverName();
        String actualReceiverMobileNo = p2PPage.getReceiverMobileNumber();
        String actualPaymentMode = p2PPage.getPaymentMode();
        String actualZipCtaText = p2PPage.getZipCtaText();


        // Display the values
        Log.info("Status : " + actualStatus);
        Log.info("Amount : " + actualAmount);
        Log.info("Receiver Name : " + actualReceiverName);
        Log.info("Receiver Mobile No. : " + actualReceiverMobileNo);
        Log.info("Payment Mode : " + actualPaymentMode);
        Log.info("Zip Cta Text : " + actualZipCtaText);


        // Add the assertions
        mbReporter.verifyEquals(actualStatus, expStatus, "Verify Title", false, false);
        mbReporter.verifyEquals(actualAmount, expAmount, "Verify Sub Title", false, false);
        mbReporter.verifyEquals(actualReceiverName, expReceiverName, "Verify Gold Amount", false, false);
        mbReporter.verifyEquals(actualReceiverMobileNo, expReceiverMobileNo, "Verify Amount", false, false);
        mbReporter.verifyEquals(actualPaymentMode, expPaymentMode, "Verify Amount", false, false);
        mbReporter.verifyEquals(actualZipCtaText, expZipCtaText, "Verify Amount", false, false);

        // Click on the up Icon
        p2MPage.clickUpButton();

        // Click Cross Buttonm
        p2MPage.clickBackButton();

        // Click on the up Icon
        p2MPage.clickUpButton();

        // Click on the back button if the bottom sheet is present
        Thread.sleep(3000);
        if (Elements.isElementPresent(driver, p2MPage.upiBottomSheetCta)) {
            Elements.back(driver, "Navigate Back");
        }

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualMoneyAddedAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
        Double actualSupercashAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
        Double expectedMoneyAddedAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;
        Double expectedSupercashAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        mbReporter.verifyEquals(actualMainBalanceAfter, expectedMainBalanceAfter, "Post TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEquals(actualMoneyAddedAfter, expectedMoneyAddedAfter, "Post TRX | Verify Money Added Balance", false, false);
        mbReporter.verifyEquals(actualSupercashAfter, expectedSupercashAfter, "Post TRX | Verify Supercash Balance", false, false);


    }


}
