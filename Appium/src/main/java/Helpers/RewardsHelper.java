package Helpers;

import Logger.Log;
import PageObject.RewardsPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RewardsHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    RewardsPage rewardsPage;
    Screen screen;
    MBReporter mbReporter;


    public RewardsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        rewardsPage = new RewardsPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void spinTheWheel(String expTitle, String expSubTitle) throws InterruptedException, IOException {

        // Check the Trophy Icon
        if(rewardsPage.isTrophyIconPresent()){
            // Click on the Trophy Icon
            rewardsPage.clickTrophyIcon();
        }
        else {
            // Click on the Trophy Icon2
            rewardsPage.clickTrophyIcon2();
        }

        Thread.sleep(3000);

        // Click the CTA - Get started
        rewardsPage.clickGetStarted();

//        if(!rewardsPage.isSpinTheWheelPresent() || !rewardsPage.isCheckRewardsPresent()) {
//            // Click the CTA - Swipe Up More
//            screen.swipeUpMore(driver);
//            screen.swipeUpMore(driver);
//        }
        if(rewardsPage.isSpinTheWheelPresent() ){

            // Click the CTA - Spin the wheel
            rewardsPage.clickSpinTheWheel();

            Thread.sleep(3000);
        }
        else {

            // Click the CTA - Check Rewards
            rewardsPage.clickCheckRewards();
        }

        // Verification on the Prize page
        String actualTitle = rewardsPage.getPrizeTitle();
        String actualSubTitle = rewardsPage.getPrizeSubTitle();

        // Display the values
        Log.info("Title : " + actualTitle);
        Log.info("SubTitle : " + actualSubTitle);

        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify the prize title", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualSubTitle, expSubTitle,"Verify the prize subtitle", false, false, true);

    }

    public void checkRewards(String expTitle, String expSubTitle) throws InterruptedException, IOException {

        // Check the Trophy Icon
        if(rewardsPage.isTrophyIconPresent()){
            // Click on the Trophy Icon
            rewardsPage.clickTrophyIcon();
        }
        else {
            // Click on the Trophy Icon2
            rewardsPage.clickTrophyIcon2();
        }

        Thread.sleep(3000);

        // Click the CTA - Get started
        rewardsPage.clickGetStarted();


//        if(!rewardsPage.isSpinTheWheelPresent() || !rewardsPage.isCheckRewardsPresent()) {
//            // Click the CTA - Swipe Up More
//            screen.swipeUpMore(driver);
//            screen.swipeUpMore(driver);
//        }

         if(rewardsPage.isSpinTheWheelPresent() ){

            // Click the CTA - Spin the wheel
            rewardsPage.clickSpinTheWheel();

            Thread.sleep(3000);
        }
        else {

            // Click the CTA - Check Rewards
            rewardsPage.clickCheckRewards();
        }

        // Verification on the Prize page
        String actualTitle = rewardsPage.getPrizeTitle();
        String actualSubTitle = rewardsPage.getPrizeSubTitle();

        // Display the values
        Log.info("Title : " + actualTitle);
        Log.info("SubTitle : " + actualSubTitle);

        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify the prize title", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualSubTitle, expSubTitle,"Verify the prize subtitle", false, false, true);

    }

    public void cashbackHistroy(String expTitle) throws InterruptedException, IOException {

        // Check the Trophy Icon
        if (rewardsPage.isTrophyIconPresent()) {
            // Click on the Trophy Icon
            rewardsPage.clickTrophyIcon();
        } else {
            // Click on the Trophy Icon2
            rewardsPage.clickTrophyIcon2();
        }

        Thread.sleep(3000);

        // Click the CTA - Get started
        rewardsPage.clickGetStarted();

        if(rewardsPage.isCashbackPresent()){

            rewardsPage.clickOnCashback();

            String actualTitle = rewardsPage.getCashbackTitle();
            String actualTotalCashback = rewardsPage.getActiveVoucher();

            Log.info("Title on cashback history screen : " + actualTitle);
            Log.info("Total Cashback : " + actualTotalCashback);

            mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify title on cashback screen", false, false, true);
        }
    }
    public void superCashHistory(String expTitle) throws InterruptedException, IOException {

        // Check the Trophy Icon
        if (rewardsPage.isTrophyIconPresent()) {
            // Click on the Trophy Icon
            rewardsPage.clickTrophyIcon();
        } else {
            // Click on the Trophy Icon2
            rewardsPage.clickTrophyIcon2();
        }

        Thread.sleep(3000);

        // Click the CTA - Get started
        rewardsPage.clickGetStarted();

        if(rewardsPage.isSupercashPresent()){

            rewardsPage.clickOnSuperCash();
            String actualTitle = rewardsPage.getCashbackTitle();
            String actualTotalCashback = rewardsPage.getActiveVoucher();

            Log.info("Title on cashback history screen : " + actualTitle);
            Log.info("Total Cashback : " + actualTotalCashback);

            mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify title on supercash screen", false, false, true);

        }
    }
    public void voucherHistory(String expTitle) throws InterruptedException, IOException {

        // Check the Trophy Icon
        if (rewardsPage.isTrophyIconPresent()) {
            // Click on the Trophy Icon
            rewardsPage.clickTrophyIcon();
        } else {
            // Click on the Trophy Icon2
            rewardsPage.clickTrophyIcon2();
        }

        Thread.sleep(3000);

        // Click the CTA - Get started
        rewardsPage.clickGetStarted();

        if(rewardsPage.isVoucherPresent()){

            rewardsPage.clickOnVoucher();
            String actualTitle = rewardsPage.getCashbackTitle();
            String actualTotalCashback = rewardsPage.getActiveVoucher();

            Log.info("Title on cashback history screen : " + actualTitle);
            Log.info("Total Cashback : " + actualTotalCashback);

            mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify title on voucher screen", false, false, true);

        }
    }
}
