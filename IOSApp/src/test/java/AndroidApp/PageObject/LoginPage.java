package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {

    IOSDriver driver;
    String apiOtp;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/otp_field")
    private IOSElement textbox_otp;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/continue_btn")
    private IOSElement cta_submit_otp;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'EXISTING USER']")
    private IOSElement link_existing_user;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'NEW USER']")
    private IOSElement link_new_user;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Number or Email']/following::XCUIElementTypeTextField[1]")
    private IOSElement textbox_email;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Number or Email']/following:: XCUIElementTypeSecureTextField")
    private IOSElement textbox_password;

    @iOSXCUITFindBy(id = "Login")
    private IOSElement cta_login;


    public LoginPage(IOSDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Login Page*****");
    }


    public void enterOtp(String otp) throws InterruptedException {
        Element.enterText(driver, textbox_otp, otp, "OTP");
    }

    public void clickOnGetOtpCta() {
        Element.selectElement(driver, cta_submit_otp, "Submit OTP CTA");
    }

    public void clickOnNewUser() {
        Element.selectElement(driver, link_new_user, "New User");
    }

    public void clickOnExistingUser() {
        Element.selectElement(driver, link_existing_user, "Existing User");
    }

    public void enterEmail(String email) throws InterruptedException {
        Element.enterText(driver, textbox_email, email, "Email");
    }

    public void enterPassword(String password) throws InterruptedException {
        Element.enterText(driver, textbox_password, password, "Password");
    }

    public void clickOnLoginCta() {
        Element.selectElement(driver, cta_login, "Login CTA");
    }
}
