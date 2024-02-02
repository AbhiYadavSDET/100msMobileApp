package Helpers;

import Logger.Log;
import PageObject.GoldPage;
import PageObject.SecurityPinPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.LinkedHashMap;
import java.io.IOException;

public class GoldHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    GoldPage goldPage;
    Screen screen;
    MBReporter mbReporter;
    SecurityPinPage securityPinPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;


    public GoldHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        goldPage = new GoldPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void goldBuy(String amount, String expTitle, String expSubTitle, String expGoldAmount, String expAmount,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Tap on See All Services
        goldPage.clickAllServices();

        // Swipe till the bottom
        goldPage.scrollToBuyGold();

        // Click on 99% Buy Gold
        goldPage.clickBuyGold();

        // Close what's new in gold bottom sheet
        while(!goldPage.isBuyGoldPresent()){
            mbkCommonControlsHelper.pressback();
        }

        // Click on Buy Gold
        goldPage.clickBuyCta();


        // Enter the Gold amount
        goldPage.enterAmount(amount);

        // Click on Pay Now CTA
        goldPage.clickPayCta();

        // checking for security pin
        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin();
        }

        // Verification on the Success Screen
        String title = goldPage.getTitle();
        String subTitle = goldPage.getSubTitle();
        String goldAmount = goldPage.getGoldAmount();
        String txnAmount = goldPage.getAmount();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Gold Amount : " + goldAmount);
        Log.info("Txn Amount : " + txnAmount);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(goldAmount, expGoldAmount, "Verify Gold Amount", false, false,true);
        mbReporter.verifyEqualsWithLogging(txnAmount, expAmount, "Verify Amount", false, false,true);


        // back to home
        mbkCommonControlsHelper.pressback(2);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);


    }

    public void goldSell(String amount, String expTitle, String expSubTitle, String expGoldAmount, String expAmount,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Tap on See All Services
        goldPage.clickAllServices();

        // Swipe till the bottom
        goldPage.scrollToBuyGold();

        // Click on 99% Buy Gold
        goldPage.clickBuyGold();

        // Close what's new in gold bottom sheet
        if(!goldPage.isBuyGoldPresent()){
            mbkCommonControlsHelper.pressback();
        }

        // Click on Sell Gold
        goldPage.clickSellCta();

        // Enter the Gold amount
        goldPage.enterAmount(amount);

        // Shut the keyboard
        screen.hideKeyboard(driver);

        // Click on Continue CTA
        goldPage.clickContinueCta();

        Thread.sleep(3000);

        // Click on Sell Gold Cta
        goldPage.clickSellGoldCta();


        // Verification on the Success Screen
        String title = goldPage.getTitle();
        String subTitle = goldPage.getSubTitle();
        String goldAmount = goldPage.getGoldAmount();
        String txnAmount = goldPage.getAmount();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Gold Amount : " + goldAmount);
        Log.info("Txn Amount : " + txnAmount);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(goldAmount, expGoldAmount, "Verify Gold Amount", false, false,true);
        mbReporter.verifyEqualsWithLogging(txnAmount, expAmount, "Verify Amount", false, false,true);

        // back to home
        mbkCommonControlsHelper.pressback(2);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Add");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);


    }

}
