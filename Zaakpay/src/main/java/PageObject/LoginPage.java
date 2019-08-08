package PageObject;

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



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }


    public void enterMobileNumber() {
        Element.selectElement(driver, enter_mobile_number, "Enter Mobile Number");
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


}
