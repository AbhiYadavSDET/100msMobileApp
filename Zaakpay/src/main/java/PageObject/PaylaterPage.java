package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaylaterPage {

    WebDriver driver;

    @FindBy(xpath = ".//*[@href = '#view12']")
    private WebElement label_paylater;

    @FindBy(xpath = ".//*[@id = 'epaylaternumber' and @type = 'text' and @placeholder = 'Enter Here' and @name = 'epaylater_number']")
    private WebElement label_enter_phone_number;

    @FindBy(xpath = ".//*[@type = 'button' and @value = 'Make Payment' and @class = 'mk_payment_btn btn']")
    private WebElement label_make_payment;

    @FindBy(xpath = ".//*[@class = 'form-input ng-pristine ng-invalid ng-touched' and @formcontrolname = 'otp']")
    private WebElement label_enter_otp;

    @FindBy(xpath = ".//*[@type='submit' and @class = 'btn frmBtn']")
    private WebElement label_Submit_button;

    public PaylaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, label_make_payment);
        Config.logComment("*****On Paylater Page*****");


    }

    public SuccessPage clickOnSubmitButton() {
        Element.selectElement(driver, label_make_payment, "Make payment");
        return new SuccessPage(driver);
    }
}
