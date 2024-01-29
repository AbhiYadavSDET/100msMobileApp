package Helpers;

import Logger.Log;
import PageObject.GoldPage;
import PageObject.P2MPage;
import PageObject.P2PPage;
import PageObject.SecurityPinPage;
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
    SecurityPinPage securityPinPage;
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
        securityPinPage = new SecurityPinPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void p2pSend(String mobileNo, String amount, String expStatus, String expAmount, String expReceiverName, String expReceiverMobileNo, String expPaymentMode, String expZipCtaText,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Tap on See All Services
        p2PPage.clickAllServices();

        // Swipe till the bottom
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        //screen.swipeUpMore(driver);

        // Click on Wallet to Wallet Transfer
        if(!p2PPage.checkP2PButton()) {
            screen.swipeUpMore(driver);
        }

        p2PPage.clickP2PButton();

        // Enter Mobile No
        p2PPage.enterMobileNo(mobileNo);

        // Enter the amount
        p2PPage.enterAmount(amount);

        // Click on Transfer Now CTA
        p2PPage.clickTransferNowCta();

        // checking for security pin
        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin();
        }

        if(p2PPage.checkKycPageOpened()){
            p2PPage.clickBackBtnOnKycPage();
            p2PPage.clickOnNoBtn();
        }

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
        mbReporter.verifyEqualsWithLogging(actualStatus, expStatus, "Verify Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualAmount, expAmount, "Verify Sub Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualReceiverName, expReceiverName, "Verify Gold Amount", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualReceiverMobileNo, expReceiverMobileNo, "Verify Amount", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualPaymentMode, expPaymentMode, "Verify Amount", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualZipCtaText, expZipCtaText, "Verify Amount", false, false,true);

        // Click on the up Icon
        p2MPage.clickUpButton();

        // Click Cross Buttonm
        if (p2MPage.checkBackButton()) p2MPage.clickBackButton();

        // Click on the up Icon
        //p2MPage.clickUpButton();

        //p2MPage.tapOuside();

        // Click on the back button if the bottom sheet is present
        Thread.sleep(3000);
        if (Elements.isElementPresent(driver, p2MPage.upiBottomSheetCta)) {
            Elements.back(driver, "Navigate Back");
        }

        // Handel home page pop-up after transaction
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);

    }


}
