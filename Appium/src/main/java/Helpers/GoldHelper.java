package Helpers;

import Logger.Log;
import PageObject.GoldPage;
import PageObject.SecurityPinPage;
import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
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
        //balanceBefore = mbkCommonControlsHelper.getBalance();

        // Tap on See All Services
        goldPage.clickAllServices();

        // Swipe till the bottom
        goldPage.scrollToBuyGold();

        // Click on 99% Buy Gold
        goldPage.clickBuyGold();

        // Close what's new in gold bottom sheet
        if(goldPage.checkEXploreSipBottomsheet()){
            mbkCommonControlsHelper.pressback();
        }

        // Click on Buy Gold
        goldPage.clickBuyCta();

        // Enter the Gold amount
        goldPage.enterAmount(amount);

       /* if(goldPage.isErrorTextVisible()){
            mbReporter.verifyTrueWithLogging(goldPage.isErrorTextVisible(), "Error Shown : "+ goldPage.getErrorText(),  false, false, true);
        }else { */

            Log.info("No error on amount field shown : Continue with Existing Case");

            // Click on Pay Now CTA
            goldPage.clickPayCta();

            // checking for security pin
            if (securityPinPage.checkSecurityPinPage()) {
                securityPinPage.enterSecurityPin();
            }

           /*
            mbkCommonControlsHelper.handle2FADeviceBindingFlow();

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
            mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(goldAmount, expGoldAmount, "Verify Gold Amount", false, false, true);
            mbReporter.verifyEqualsWithLogging(txnAmount, expAmount, "Verify Amount", false, false, true);


            // back to home
            mbkCommonControlsHelper.pressback(2);

            // Click on the back button if the bottom sheet is present
            mbkCommonControlsHelper.handleHomePageLanding();

            // Get the Balance if the User Before TRX
            balanceAfter = mbkCommonControlsHelper.getBalance();

            // Assertions on the balance deducted
            mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

            // Verify the History details
            mbkCommonControlsHelper.verifyHistoryDetails(driver, expectedHistoryDescription, expectedHistoryAmount, expectedHistoryStatus);

*/
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


        if(goldPage.isErrorTextVisible()) {
            mbReporter.verifyTrueWithLogging(goldPage.isErrorTextVisible(), "Error Shown : " + goldPage.getErrorText(), false, false, true);
        }else {

            Log.info("No error on amount field shown : Continue with Existing Case");

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
            mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(goldAmount, expGoldAmount, "Verify Gold Amount", false, false, true);
            mbReporter.verifyEqualsWithLogging(txnAmount, expAmount, "Verify Amount", false, false, true);

            // back to home
            mbkCommonControlsHelper.pressback(2);

            // Click on the back button if the bottom sheet is present
            mbkCommonControlsHelper.handleHomePageLanding();

            // Get the Balance if the User Before TRX
            balanceAfter = mbkCommonControlsHelper.getBalance();


            // Assertions on the balance deducted
            mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Add");

            // Verify the History details
            mbkCommonControlsHelper.verifyHistoryDetails(driver, expectedHistoryDescription, expectedHistoryAmount, expectedHistoryStatus);

        }

    }


    public void goldCoin(String exptitleGoldCoins,String exptitleKnowMore,String exptitleAboutSafeGold) throws InterruptedException, IOException {

        // Tap on See All Services
        goldPage.clickAllServices();

        // Swipe till the bottom
        goldPage.scrollToBuyGold();

        // Click on 99% Buy Gold
        goldPage.clickBuyGold();

        if(goldPage.checkEXploreSipBottomsheet()){
            mbkCommonControlsHelper.pressback();
        }

       // goldPage.scrollToGoldCointXT();

        // Verification on the Gold Coin Txt
        String titleGoldCoins = goldPage.getGoldCoinTxt();
        // Display the values
        Log.info("titleGoldCoins : " + titleGoldCoins);
        // Add the assertions
        mbReporter.verifyEqualsWithLogging(titleGoldCoins, exptitleGoldCoins, "Verify Gold Coins Title", false, false, true);
        goldPage.clickOnGoldCointXT();

        goldPage.clickSafeGoldIcon();
        goldPage.enterPincode("122004");

        Element.waitForVisibility(driver, By.id("buy_now_button"));
        goldPage.clickPayCta();

    }



    public void goldSip(String exptitlSipBannerTitle,String exptitlDaily,String exptitlMonthly,String exptitlCalenderViewInsideScreen) throws InterruptedException, IOException {

        // Tap on See All Services
        goldPage.clickAllServices();

        // Swipe till the bottom
        goldPage.scrollToBuyGold();

        // Click on 99% Buy Gold
        goldPage.clickBuyGold();

        if(goldPage.checkEXploreSipBottomsheet()){
            mbkCommonControlsHelper.pressback();
        }

        // Verification on the Gold Home Page
        String titlSipBannerTitle = goldPage.getGoldSIPBannerTitle();

        // Display the values on Gold Home Page
        Log.info("titlSipBannerTitle : " + titlSipBannerTitle);

        mbReporter.verifyEqualsWithLogging(titlSipBannerTitle, exptitlSipBannerTitle, "Title Sip Banner", false, false, true);

        goldPage.clickOnSIPBannerTitle();
        // Verification on the Gold Home Page
        String titlDaily = goldPage.getDailyTitleOnGoldSipPage();
        String titlMonthly = goldPage.getMonthlyTitleOnGoldSipPage();


        // Display the values
        Log.info("titlDaily : " + titlDaily);
        Log.info("titlMonthly : " + titlMonthly);


        mbReporter.verifyEqualsWithLogging(titlDaily, exptitlDaily, "Title Daily", false, false, true);
        mbReporter.verifyEqualsWithLogging(titlMonthly, exptitlMonthly, "Title Monthly", false, false, true);

        goldPage.enterDailySipAmount("5000");
        goldPage.clickOnMonthlyTitle();
        goldPage.clickOnCalender();

        String titlCalenderViewInsideScreen = goldPage.getMHeadingOnCalenderView();
        Log.info("titlCalenderViewInsideScreen : " + titlCalenderViewInsideScreen);
        mbReporter.verifyEqualsWithLogging(titlCalenderViewInsideScreen, exptitlCalenderViewInsideScreen, "Calender view title inside the calender", false, false, true);
        goldPage.clickOnCalenderDropdown();
    }

}


