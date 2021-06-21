package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class OnboardingPage {

    AndroidDriver<AndroidElement> driver;

    @AndroidFindBy(id="get_started_btn")
    private AndroidElement getStartedButtoncta;

    @AndroidFindBy(id = "tv_payments")
    private AndroidElement onboarding_text;

    @AndroidFindBy(id = "skip")
    private AndroidElement button_skip;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement textbox_mobile_no;

    @AndroidFindBy(id = "send_otp_btn")
    private AndroidElement cta_get_otp;

    @AndroidFindBy(id = "edit_text_otp")
    private AndroidElement textbox_enter_otp;

    @AndroidFindBy(id = "verify_otp_btn")
    private AndroidElement cta_submit_otp;

    @AndroidFindBy(id = "tv_permission")
    private AndroidElement permission_statement;

    @AndroidFindBy(id="btn_continue")
    private AndroidElement cta_continue_with_aadhaar;

    @AndroidFindBy(id= "tv_right")
    private AndroidElement cta_skip;

    @AndroidFindBy(id="alertTitle")
    private AndroidElement permission_consent;

    @AndroidFindBy (xpath= "//android.widget.Button[@text= 'ALLOW']")
    private AndroidElement allow_consent;

    @AndroidFindBy(id="cbKycConsent")
    private AndroidElement kyc_consent;

    @AndroidFindBy(id="btn_other_options")
    private AndroidElement skip_other_option_cta;

    @AndroidFindBy(id="btn_exit")
    private AndroidElement skip_i_dont_want_benifits;

    @AndroidFindBy(id="non_aadhaar_options")
    private AndroidElement non_aadhaar_options;

    @AndroidFindBy(id="cashback_text")
    private AndroidElement upi_page_cashback_text;

    @AndroidFindBy(id="icon_close")
    private AndroidElement upi_page_cross;

    @AndroidFindBy(id="title")
    private AndroidElement email_screen_title;

    @AndroidFindBy(id= "continue_button")
    private AndroidElement cta_continue_button_email_screen;




    public OnboardingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Onboarding Page*****");
    }

    public void clickOnGetStartedCta() throws InterruptedException {
        Element.isElementPresent(driver, By.id("get_started_btn"));
        Element.selectElement(driver, getStartedButtoncta, "Click on Intro Page");
    }


    public void enterMobileNo(String mobileNo) {
//        Element.selectElement(driver,textbox_mobile_no, "Select mobile no Field");
        Element.enterText(driver, textbox_mobile_no, mobileNo, "Enter Mobile No");
    }

    public void clickOnGetOtpCta() {
        Element.selectElement(driver, cta_get_otp, "Click on Get OTP CTA");
    }

    public HomePage clickOnSkip() throws IOException {
        Element.selectElement(driver, button_skip, "Click on Skip button");
        return new HomePage(driver);
    }

    public void enterOtp(String otp) throws InterruptedException {
        Element.enterText(driver, textbox_enter_otp, otp, "OTP");
    }

    public void clickSubmitOtpCta() {
        Element.selectElement(driver, cta_submit_otp, "Submit OTP CTA");
    }

    public String getPermissionText(){
        return Element.getText(driver, permission_statement, "Get Permission Text");
    }

    public void clickContinueWithAadhaarCta(){
        Element.selectElement(driver, cta_continue_with_aadhaar, "Continue With Aadhaar");
    }

    public String getConsentPopUpTitleText(){
        return Element.getText(driver, permission_consent, "Get Consent Title Text");
    }

    public void clickAllowConsent(){
        Element.selectElement(driver, allow_consent, "Allow Consent");
    }

    public String getKycConsentText(){
        return Element.getText(driver, kyc_consent, "Get Kyc Consent Text");
    }

    public void clickOnKYCSkipCta(){
        Element.selectElement(driver, cta_skip, "Skip KYC");
    }

    public void clickOnOtherKycOptionCta(){
        Element.selectElement(driver, skip_other_option_cta, "Choose Other KYC option");
    }

    public boolean isNonAadhaarOptionsAvailable() throws InterruptedException {
        if (Element.isElementPresent(driver, By.id("non_aadhaar_options"))){
            return true;
        }else {
        return false;
        }
    }

    public void clickOnIdontWantBenifitsCta(){
        Element.selectElement(driver, skip_i_dont_want_benifits, "Choose I Dont Want Benifits option");
    }

    public String getUpiPageCashbackText(){
        return Element.getText(driver, upi_page_cashback_text, "Get Upi Page Cashback Text");
    }

    public void clickOnUpiPageCross(){
        Element.selectElement(driver, upi_page_cross, "Close Upi Page");
    }

    public String getEmailScreenText(){
        return Element.getText(driver, email_screen_title, "Get Email Page Title Text");
    }

    public void clickOnContinueCta(){
        Element.selectElement(driver, cta_continue_button_email_screen, "Click on continue Button");
    }

}
