package PageObject;

import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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

    @AndroidFindBy(xpath = "//*[@text='NONE OF THE ABOVE']")
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

    @AndroidFindBy(id = "et_otp")
    private AndroidElement textbox_enter_otp;

    @AndroidFindBy(id = "verify_otp_btn")
    private AndroidElement cta_submit_otp;

    @AndroidFindBy(id = "retry_btn")
    private AndroidElement cta_resend_otp;


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickGetstarted() {
        Elements.selectElement(driver, getStartedButton, "Click Get Started button");
    }


    public void clickNoneOfAbove() {
        Elements.selectElement(driver, noneOfAboveButton, "Click None of the Above button");
    }

    public void enterMobileNum(String mobileNumber) {
        Elements.clearText(driver, editTextField, "Clear mobile number");
        Elements.enterToElement(driver, editTextField, mobileNumber, "Enter mobile number");
    }

    public void clickSendOtpbutton() {
        Elements.selectElement(driver, sendOtpButton, "Click Send OTP button");
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

    public void enterOtp(String otp) throws InterruptedException {
        if (otp.length() > 0) {
            Element.enterText(driver, textbox_enter_otp, otp, "Enter OTP");
        }
    }

    public void clickSubmitOtpCta() {
        Element.selectElement(driver, cta_submit_otp, "Submit OTP CTA");
    }


}
