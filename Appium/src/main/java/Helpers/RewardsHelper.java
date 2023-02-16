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

        // Click on the Trophy Icon
        Thread.sleep(5000);
        rewardsPage.clickTrophyIcon();

        // Click the CTA - Get started
        rewardsPage.clickGetStarted();

        // Click the CTA - Spin the wheel
        rewardsPage.clickSpinTheWheel();

        // Verification on the Claim Now bottom sheet
        String actualTitle = rewardsPage.getClaimNowScreenTitle();
        String actualSubTitle = rewardsPage.getClaimNowScreenSubTitle();
        String actualCtaText = rewardsPage.getCtaText();

        // Display the values
        Log.info("Title : " + actualTitle);
        Log.info("SubTitle : " + actualSubTitle);
        Log.info("Cta text : " + actualCtaText);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Title", false,false,true);
        mbReporter.verifyEqualsWithLogging(actualSubTitle, expSubTitle, "Verify Sub Title", false,false,true);
        mbReporter.verifyEqualsWithLogging(actualCtaText, expCtaText, "Verify Cta Text", false,false,true);

        // Click on the cross button
        rewardsPage.clickCrossButton();


    }


}
