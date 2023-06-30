package Helpers;

import Logger.Log;
import PageObject.SecurityPinPage;
import PageObject.P2MPage;
import Helpers.GoldHelper;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SecurityPinHelper {

    AndroidDriver<AndroidElement> driver;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    Elements elements;
    SecurityPinPage securityPinPage;
    P2MPage p2mPage;
    Screen screen;
    MBReporter mbReporter;
    GoldHelper goldHelper;


    public SecurityPinHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        securityPinPage = new SecurityPinPage(driver);
        p2mPage = new P2MPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        goldHelper = new GoldHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void securityPinFlow(String currentState , String expSecuritySettingsTitle, String expSecurityPinTitle) throws InterruptedException, IOException {

        // Click on profile icon
        securityPinPage.clickOnProfile();

        Thread.sleep(2000);

        // Swipe till the bottom
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);

        // Click on Security Settings
        securityPinPage.clickOnsSecuritySettings();

        // Verification on the Security Settings screen
        String securitySettingPageTitle = securityPinPage.getTitle();
        String currentStateText = securityPinPage.getCurrentState();

        // Display the values
        Log.info("Title : " + securitySettingPageTitle);
        Log.info("Current Security State : " + currentStateText);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(securitySettingPageTitle, expSecuritySettingsTitle , "Verify Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(currentStateText, "Security PIN: "+currentState, "Verify Current Sate", false, false,true);

        if(securityPinPage.getCurrentState().equals("Security PIN: "+currentState)){

            // Click on Security Pin
            securityPinPage.clickOnSecurityPin();

            // Verification on the Security Settings screen
            String securityPinPageTitle = securityPinPage.getTitle();
            Log.info("Title : " + securityPinPageTitle);
            mbReporter.verifyEqualsWithLogging(securityPinPageTitle, expSecurityPinTitle , "Verify Title", false, false,true);

            // Enter security pin
            securityPinPage.enterSecurityPin();

        }

        // Going back to home
        mbkCommonControlsHelper.handleHomePageLanding();

    }



    public void securityPinTestCase(String expSecuritySettingsTitle, String expSecurityPinTitle) throws InterruptedException, IOException {

        //Enable Security Pin
        securityPinFlow("Disabled",expSecuritySettingsTitle,expSecurityPinTitle);

        goldHelper.goldBuy("1", "Payment Successful", "Gold Purchase", "0.0002", "₹1","Purchased Gold", "₹1", "Success");

        mbkCommonControlsHelper.handleHomePageLanding();

        //Disable Security Pin
        securityPinFlow("Enabled",expSecuritySettingsTitle,expSecurityPinTitle);

    }
}
