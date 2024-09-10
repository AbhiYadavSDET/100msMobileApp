package Helpers;

import Logger.Log;
import PageObject.P2MPage;
import PageObject.P2PPage;
import PageObject.SecurityPinPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class P2PHelper {

    IOSDriver<IOSElement> driver;
    Elements elements;
    P2PPage p2PPage;
    P2MPage p2MPage;
    SecurityPinPage securityPinPage;
    Screen screen;
    MBReporter mbReporter;




    public P2PHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        p2PPage = new P2PPage(driver);
        p2MPage = new P2MPage(driver);
        securityPinPage = new SecurityPinPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void p2pSend(String mobileNo, String amount, String expStatus, String expAmount, String expReceiverName, String expReceiverMobileNo, String expPaymentMode) throws InterruptedException, IOException {


        // Tap on See All Services
        p2PPage.clickAllServices();

        // Click on Wallet to Wallet Transfer
//        while(!p2PPage.checkP2PButton()) {

        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);

//        }

        p2PPage.clickP2PButton();

        // Enter Mobile No
        p2PPage.enterMobileNo(mobileNo);

        // Enter the amount
        p2PPage.enterAmount(amount);

        // Click on Transfer Now CTA
        p2PPage.clickTransferNowCta();

        // checking for security pin
        if(securityPinPage.isSecurityPinPageShown())
        {
            securityPinPage.enterSecurityPin();
        }

        Thread.sleep(3000);

        // Verification on the Success Screen
        String actualStatus = p2PPage.getStatus();
        String actualAmount = p2PPage.getAmount();
        String actualReceiverName = p2PPage.getReceiverName();
        String actualReceiverMobileNo = p2PPage.getReceiverMobileNumber();
        String actualPaymentMode = p2PPage.getPaymentMode();
        Boolean isZipWidgetPresent = p2PPage.isZipWidgetPresent();


        // Display the values
        Log.info("Status : " + actualStatus);
        Log.info("Amount : " + actualAmount);
        Log.info("Receiver Name : " + actualReceiverName);
        Log.info("Receiver Mobile No. : " + actualReceiverMobileNo);
        Log.info("Payment Mode : " + actualPaymentMode);
        Log.info("Is Zip Widget Present : " + isZipWidgetPresent);


        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualStatus, expStatus, "Verify Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualAmount, expAmount, "Verify Sub Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualReceiverName, expReceiverName, "Verify Gold Amount", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualReceiverMobileNo, expReceiverMobileNo, "Verify Amount", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualPaymentMode, expPaymentMode, "Verify Amount", false, false,true);
        mbReporter.verifyTrueWithLogging(isZipWidgetPresent, "Verify Amount", false, false,true);

        // Click on the up Icon
        p2MPage.clickBackButton();

    }


}
