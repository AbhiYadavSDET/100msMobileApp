package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class LoginPage {

    AndroidDriver driver;
    String apiOtp;


    @AndroidFindBy(id = "otp_field")
    private AndroidElement textbox_otp;

    @AndroidFindBy(id = "continue_btn")
    private AndroidElement cta_submit_otp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'EXISTING USER']")
    private AndroidElement link_existing_user;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'NEW USER']")
    private AndroidElement link_new_user;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement textbox_email;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Password']/following::android.widget.EditText")
    private AndroidElement textbox_password;

    @AndroidFindBy(id = "btnLogin")
    private AndroidElement cta_login;


    public LoginPage(AndroidDriver driver) throws IOException {
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
