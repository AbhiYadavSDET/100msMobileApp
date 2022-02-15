package PageObject;

import utils.Element;
import utils.Elements;
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

    @AndroidFindBy(xpath="//*[@text='Get Started']")
    private AndroidElement getStartedButton;

    @AndroidFindBy(xpath="//*[@text='NONE OF THE ABOVE']")
    private AndroidElement noneOfAboveButton;

    @AndroidFindBy(xpath="//*[@class='android.widget.EditText']")
    private AndroidElement editTextField;

    @AndroidFindBy(xpath="//*[@text='Send OTP']")
    private AndroidElement sendOtpButton;

    @AndroidFindBy(xpath="//*[@text='History']")
    private AndroidElement history;

    @AndroidFindBy(xpath="//*[@text='Home']")
    private AndroidElement homeTab;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement loginSignupButton;

    /// Old


    @AndroidFindBy(id = "verify_otp_btn")
    private AndroidElement cta_submit_otp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'EXISTING USER']")
    private AndroidElement link_existing_user;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'NEW USER']")
    private AndroidElement link_new_user;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement textbox_email;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement textbox_number;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Password']/following::android.widget.EditText")
    private AndroidElement textbox_password;

    @AndroidFindBy(id = "btnLogin")
    private AndroidElement cta_login;

    @AndroidFindBy(id = "send_otp_btn")
    private AndroidElement cta_send_otp;

    @AndroidFindBy(id = "edit_text_otp")
    private AndroidElement textbox_enter_otp;


    ////


    public LoginPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickGetstarted(){
        Elements.selectElement(driver,getStartedButton,"Click Get Started button");
    }


    public void clickNoneOfAbove() {
        Elements.selectElement(driver,noneOfAboveButton,"Click None of the Above button");
    }

    public void enterMobileNum(String mobileNumber) {
        Elements.clearText(driver, editTextField,"Clear mobile number");
        Elements.enterToElement(driver, editTextField, mobileNumber,"Enter mobile number");
    }

    public void clickSendOtpbutton() {
        Elements.selectElement(driver,sendOtpButton,"Click Send OTP button");
    }

    public void clickHistoryTab() {
        Elements.waitForElementToVisibleOnPage(driver,history,15);
        Elements.selectElement(driver,history,"Click history tab");
    }

    public void checkHistoryText() {
        Elements.waitForElementToVisibleOnPage(driver,history,10);
    }

    public void clickHomeTab() {
        Elements.selectElement(driver,homeTab,"Click on home tab");
    }

    public void clickLoginSignup() {
        Elements.selectElement(driver,loginSignupButton,"Click on Login/Signup button");
    }

    ////OLD


    public void clickOnNewUser() {
        Element.selectElement(driver, link_new_user, "New User");
    }

    public void clickOnExistingUser() {
        Element.selectElement(driver, link_existing_user, "Existing User");
    }

    public void enterEmail(String email) throws InterruptedException {
        Element.enterText(driver, textbox_email, email, "Email");
    }

    public void enterMobileNumber(String number) throws InterruptedException {
        Element.enterText(driver, textbox_number, number, "Enter Mobile Number");
    }

    public void enterPassword(String password) throws InterruptedException {
        Element.enterText(driver, textbox_password, password, "Password");
    }

    public void clickOnLoginCta() {
        Element.selectElement(driver, cta_login, "Login CTA");
    }

    public void clickOnSendOtpCta() {
        Element.selectElement(driver, cta_send_otp, "Send OTP CTA");
    }

    public void enterOtp(String otp) throws InterruptedException {
        Element.enterText(driver, textbox_enter_otp, otp, "OTP");
    }

    public void clickSubmitOtpCta() {
        Element.selectElement(driver, cta_submit_otp, "Submit OTP CTA");
    }

    //



}
