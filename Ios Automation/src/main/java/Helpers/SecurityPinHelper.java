package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SecurityPinHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PermissionPage permissionPage;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    RechargePage rechargePage;
    MBReporter mbReporter;
    HistoryPage historyPage;
    SecurityPinPage securityPinPage;

    public SecurityPinHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        rechargePage = new RechargePage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        mbReporter = new MBReporter(driver);
        historyPage = new HistoryPage(driver);
        securityPinPage = new SecurityPinPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void securityPinFlow(String expSecuritySettingsTitle) throws InterruptedException, IOException {

        //Click Profile option
        homePage.clickProfile();

        Thread.sleep(2000);

        // Swipe till the bottom
        Screen.swipeUp(driver);
        Screen.swipeUp(driver);

        //Click on security settings
        securityPinPage.clickOnSecuritySettings();

        String secutiySettingsPageTitle = securityPinPage.getTitle();
        String currentStateText = securityPinPage.getCurrentState();

        // Display the values
        Log.info("Title : " + secutiySettingsPageTitle);
        Log.info("Current Security State : " + currentStateText);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(secutiySettingsPageTitle, expSecuritySettingsTitle , "Verify Title", false, false,true);

    }
}
