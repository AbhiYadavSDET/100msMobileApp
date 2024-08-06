package PageObject;

import Helpers.LoginHelper;
import Logger.Log;
import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//    String getStartedButton ="Get Started";
//    String noneOfAboveButton="NONE OF THE ABOVE";
//    String editTextField="android.widget.EditText";
//    String sendOtpButton="Send OTP";
//    String history="History";
//    String homeTab="Home";
//    String loginSignupButton ="Login/Signup";


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*[@text='Get Started']")
    private AndroidElement getStartedButton;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private AndroidElement noneOfAboveButton;

    @AndroidFindBy(id = "et_phone_number")
    private AndroidElement editTextField;

    @AndroidFindBy(id = "send_otp_button")
    private AndroidElement sendOtpButton;

    @AndroidFindBy(xpath = "//*[@text='History']")
    private AndroidElement history;

    @AndroidFindBy(xpath = "//*[@text='Home']")
    private AndroidElement homeTab;

    @AndroidFindBy(xpath = "//*[@text='Login/Signup']")
    private AndroidElement loginSignupButton;

    @AndroidFindBy(xpath = "//*[@text='Login']")
    private AndroidElement loginButton;

    @AndroidFindBy(id = "et_otp")
    private AndroidElement textbox_enter_otp;

    @AndroidFindBy(id = "verify_otp_btn")
    private AndroidElement cta_submit_otp;

    @AndroidFindBy(id = "retry_btn")
    private AndroidElement cta_resend_otp;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Logout']")
    private AndroidElement text_logout;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Accounts']")
    private AndroidElement text_account;




    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickGetstarted() {
        Elements.selectElement(driver, getStartedButton, "Click Get Started button");
    }

    public void clickNoneOfAbove() {
        Elements.selectElement(driver, noneOfAboveButton, "Closing the Phone Number Suggestion Bottomsheet");
    }

    public void enterMobileNum(String mobileNumber) {
        Elements.clearText(driver, editTextField, "Clear mobile number");
        Elements.enterToElement(driver, editTextField, mobileNumber, "Enter mobile number");
    }

    public void clickSendOtpbutton() {
        Elements.selectElement(driver, sendOtpButton, "Click Send OTP button");
    }

    public String getTextSendOtpbutton() throws InterruptedException {
        return Elements.getText(driver, sendOtpButton, "Get Text Continue");
    }

    public void clickHistoryTab() {
        Elements.waitForElementToVisibleOnPage(driver, history, 15);
        Elements.selectElement(driver, history, "Click history tab");
    }

    public void checkHistoryText() {
        Elements.waitForElementToVisibleOnPage(driver, history, 10);
    }

    public void clickHomeTab() {
        Elements.selectElement(driver, homeTab, "Click on home tab");
    }

    public void clickResendOtp() {
        Elements.selectElement(driver, cta_resend_otp, "Click on Resend Otp Button");
    }

    public void clickLoginSignup() {
        Elements.selectElement(driver, loginSignupButton, "Click on Login/Signup button");
    }

    public String gettextLoginSignup() throws InterruptedException {
        return Elements.getText(driver, loginSignupButton, "Get Text Login Signup");
    }
    public void enterOtp(String otp) throws InterruptedException {
        Element.waitForVisibility(driver, textbox_enter_otp);
        if (otp.length() > 0) {
            Element.enterText(driver, textbox_enter_otp, otp, "Enter OTP");
        }
        Element.waitForInvisibility(driver, By.id("btn_loader"));
    }

    public void clickSubmitOtpCta() {
        Element.selectElement(driver, cta_submit_otp, "Submit OTP CTA");
    }


    public boolean scrollToAccount() throws InterruptedException {
        return Elements.scrollToElement(driver, text_account);
    }
    public void clickAccount() {
        Elements.selectElement(driver, text_account, "Click Account");
    }
    public boolean scrollToLogout() throws InterruptedException {
        return Elements.scrollToElement(driver, text_logout);
    }
    public void clickLogout() {
        Elements.selectElement(driver, text_logout, "click logout");
    }

    public void clickLoginButton() {
        Elements.selectElement(driver, loginButton, "click login");
    }

    public boolean isOTPNotAutoRead() throws InterruptedException{

        Thread.sleep(6000);
        return Element.isElementPresent(driver, By.id("otp_sent_to"));

    }


}
