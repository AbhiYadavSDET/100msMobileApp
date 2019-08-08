package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    WebDriver driver;


    @FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
    private WebElement enter_mobile_number;

    @FindBy(xpath = "//span[text() ='Get OTP']")
    private WebElement button_get_otp;

    @FindBy(xpath = "//input[@id='otp']")
    private WebElement enter_otp;

    @FindBy(xpath = "//span[text() ='Submit OTP']")
    private WebElement button_submit_otp;

    @FindBy(xpath = "//p[text() = 'Login']")
    public WebElement load_login_page;

    @FindBy(xpath = "//span[text() = '+ Add Money']")
    public WebElement addmoney_button;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, load_login_page);
        Config.logComment("*****On Login-Page*****");

    }


    public void enterMobileNumber(String mobileNumber) {
        Element.enterText(driver, enter_mobile_number, mobileNumber, "Enter Mobile Number");

    }

    public void clickGetOtp() {
        Element.selectElement(driver, button_get_otp, "Get OTP");
    }

    public void enterOtp() {
        Element.selectElement(driver, enter_otp, "Enter OTP");
    }

    public void clickSubmitOtp() {
        Element.selectElement(driver, button_submit_otp, "Submit OTP");
    }

    public void waitForAddMoneyButton() {
        Element.waitForVisibility(driver, addmoney_button, "Add money Button");
    }


}