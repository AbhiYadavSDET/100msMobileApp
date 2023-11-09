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

    public void spinTheWheel(String expTitle, String expSubTitle, String expCtaText) throws InterruptedException, IOException {

        // Check the Trophy Icon
        if(rewardsPage.isTrophyIconPresent()){
            // Click on the Trophy Icon
            rewardsPage.clickTrophyIcon();
        }
        else {
            // Click on the Trophy Icon2
            rewardsPage.clickTrophyIcon2();
        }

        Thread.sleep(2000);

        // Click the CTA - Get started
        rewardsPage.clickGetStarted();

        // Click the CTA - Swipe Up More
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);

        if(rewardsPage.isSpinTheWheelPresent()){

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

        // Click on the Notify Me button
        rewardsPage.clickNotifyMe();

    }
}
