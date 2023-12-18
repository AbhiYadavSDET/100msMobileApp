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

    RechargeHelper rechargeHelper;


    public SecurityPinHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        securityPinPage = new SecurityPinPage(driver);
        p2mPage = new P2MPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        goldHelper = new GoldHelper(driver);
        rechargeHelper = new RechargeHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void securityPinFlow(String currentState, String pin, String expSecuritySettingsTitle, String expSecurityPinTitle) throws InterruptedException, IOException {

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

        if(securityPinPage.getCurrentState().equals("Security PIN: "+currentState)){

            mbReporter.verifyEqualsWithLogging(currentStateText, "Security PIN: "+currentState, "Verify Current Sate", false, false,true);

            // Click on Security Pin
            securityPinPage.clickOnSecurityPin();

            // Verification on the Security Settings screen
            String securityPinPageTitle = securityPinPage.getTitle();
            Log.info("Title : " + securityPinPageTitle);

            mbReporter.verifyEqualsWithLogging(securityPinPageTitle, expSecurityPinTitle , "Verify Title", false, false,true);

            // Enter security pin
            securityPinPage.enterSecurityPin(pin);

        }

        // Going back to home
        mbkCommonControlsHelper.handleHomePageLanding();

    }



    public void securityPinTestCase(String pin, String expSecuritySettingsTitle, String expSecurityPinTitle) throws InterruptedException, IOException {

        //Enable Security Pin
        securityPinFlow("Disabled", pin, expSecuritySettingsTitle, expSecurityPinTitle);

        // Postpaid Recharge
        rechargeHelper.postpaidRecharge("1","₹1","Payment Successful","for Jio 9311878235 ","₹1","Jio Bill Payment", "-₹1", "Success");

        mbkCommonControlsHelper.handleHomePageLanding();

        //Disable Security Pin
        securityPinFlow("Enabled", pin, expSecuritySettingsTitle, expSecurityPinTitle);

    }



    public void changeSecurityPinTest(String pin, String expSecuritySettingsTitle, String expSecurityPinTitle) throws InterruptedException, IOException {

        //Enable Security Pin
        securityPinFlow("Disabled", pin, expSecuritySettingsTitle, expSecurityPinTitle);

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
        mbReporter.verifyEqualsWithLogging(currentStateText, "Security PIN: Enabled", "Verify Current Sate", false, false,true);

        // Click on Change Pin
        securityPinPage.clickOnChangePin();

        // Enter Current Pin
        securityPinPage.enterCurrentPin(pin);

        // Enter New Pin
        securityPinPage.enterNewPin(pin);

        // Enter Confirm New Pin
        securityPinPage.enterConfirmNewPin(pin);

        // Click on Change Security Pin
        securityPinPage.clickOnChangeSecurityPin();


        Thread.sleep(2000);

    }
}
