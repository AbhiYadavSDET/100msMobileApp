package Helpers;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.PermissionPage;
import Utils.MBReporter;
import org.openqa.selenium.By;
import Utils.Element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginHelper {

    AndroidDriver<AndroidElement> driver;
    LoginPage loginPage;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    HomePage homePage;
    PermissionPage permissionPage;


    public LoginHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        permissionPage = new PermissionPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginViaOtp(String mobileNumber) throws InterruptedException, IOException {

        if (permissionPage.isPermissionNotificationsPresent()) {
            permissionPage.allowPermissionNotifications();
        }
        Thread.sleep(3000);
        if (element.isElementPresent(driver, By.xpath("//*[@text='Get Started']"))) {
            loginPage.clickGetstarted();
        } else if (element.isElementPresent(driver, By.xpath("//*[@text='Login/Signup']"))) {
            loginPage.clickLoginSignup();
        }

        if (element.isElementPresent(driver, By.xpath("//*[@text='NONE OF THE ABOVE']"))) {
            loginPage.clickNoneOfAbove();
        }


        loginPage.enterMobileNum(mobileNumber);
        loginPage.clickSendOtpbutton();

        Thread.sleep(6000);
        element.waitForVisibility(driver, By.xpath("//*[@text='History']"));

        mbReporter.verifyTrueWithLogging(element.isElementPresent(driver, By.xpath("//*[@text='Balance']")), "Verify User is Logged In", true, true);

        loginPage.clickHistoryTab();
        loginPage.checkHistoryText();
        loginPage.clickHomeTab();


    }

    public void loginViaOtp(String mobileNumber, String otp) throws InterruptedException, IOException {

        if (permissionPage.isPermissionNotificationsPresent()) {
            permissionPage.allowPermissionNotifications();
        }

        Thread.sleep(3000);
        if (element.isElementPresent(driver, By.xpath("//*[@text='Get Started']"))) {
            loginPage.clickGetstarted();
        } else if (element.isElementPresent(driver, By.xpath("//*[@text='Login/Signup']"))) {
            loginPage.clickLoginSignup();
        }

        if (element.isElementPresent(driver, By.xpath("//*[@text='NONE OF THE ABOVE']"))) {
            loginPage.clickNoneOfAbove();
        }

        loginPage.enterMobileNum(mobileNumber);
        loginPage.clickSendOtpbutton();

        loginPage.enterOtp(otp);

        // Now it is auto submitted so click CTA not needed
        //loginPage.clickSubmitOtpCta();

        // Wait for 5000 ms for all the banners to load
        Thread.sleep(5000);

        mbkCommonControlsHelper.handleHomePage();

        element.waitForVisibility(driver, By.xpath("//*[@text='History']"));

        mbReporter.verifyTrueWithLogging(element.isElementPresent(driver, By.id("tx_balance")), "Is User is Logged In", true, false);


    }

    public void quickLoginViaOtp(String mobileNumber, String otp) throws InterruptedException {

        if (permissionPage.isPermissionNotificationsPresent()) {
            permissionPage.allowPermissionNotifications();
        }

        Thread.sleep(1000);
        if (element.isElementPresent(driver, By.xpath("//*[@text='Get Started']"))) {
            loginPage.clickGetstarted();
        } else if (element.isElementPresent(driver, By.xpath("//*[@text='Login/Signup']"))) {
            loginPage.clickLoginSignup();
        }

        if (element.isElementPresent(driver, By.xpath("//*[@text='NONE OF THE ABOVE']"))) {
            loginPage.clickNoneOfAbove();
        }

        loginPage.enterMobileNum(mobileNumber);
        loginPage.clickSendOtpbutton();

        if (!element.isElementPresent(driver, By.id("et_otp"))) {
            loginPage.clickSendOtpbutton();
        }


        loginPage.enterOtp(otp);

        // Now it is auto submitted so click CTA not needed
        //loginPage.clickSubmitOtpCta();

        // Wait for 3 sec
        Thread.sleep(3000);

        // If the error message is present --> resend OTP
        if (element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Please try again']"))) {

            loginPage.clickResendOtp();
            loginPage.enterOtp(otp);
        }

        // Wait for 5000 ms for all the banners to load
        Thread.sleep(5000);

        mbkCommonControlsHelper.handleHomePageLanding();

        element.waitForVisibility(driver, By.xpath("//*[@text='History']"));
    }

}
