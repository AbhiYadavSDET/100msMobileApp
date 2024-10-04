package Helpers;

import Logger.Log;
import PageObject.LoginPage;
import PageObject.PermissionPage;
import Utils.Elements;
import io.appium.java_client.internal.ElementMap;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginHelper{

    IOSDriver<IOSElement> driver;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    PermissionPage permissionPage;
    Elements element;

    public LoginHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        element = new Elements(driver);
        loginPage = new LoginPage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginViaOtp(String mobileNumber, String otp) throws InterruptedException, IOException {

        if(permissionPage.isPermissionPopUpPresent()){

            permissionPage.clickOnAllow();
        }

        // Enter Mobile Number
        loginPage.enterMobileNumber(mobileNumber);

        // Click On Continue
        loginPage.clickContinue();

        // Enter Otp
        loginPage.enterOtp(otp);


//        // If the error message is present --> resend OTP
//        if (element.isElementPresent(driver, By.id("error_view"))) {
//            Log.info(element.findElement(driver, By.id("error_view")).getText());
//            loginPage.clickResendOtp();
//            loginPage.enterOtp(otp);
//        }
        // Wait for 2000 ms for all the banners to load
//        Thread.sleep(5000);
        element.waitForInvisibility(driver, By.id("Enter OTP to verify your number"));
        Thread.sleep(2000);

        if (element.isElementPresentNoWait(driver, By.id("Explore the app"),"Feature Assist Page")){
            Log.info("Feature Assist Page Shown");
            Thread.sleep(1500);
            driver.findElementById("Explore the app").click();
            Thread.sleep(3000);
        }

        mbkCommonControlHelper.handleHomePageLanding();
    }
}
