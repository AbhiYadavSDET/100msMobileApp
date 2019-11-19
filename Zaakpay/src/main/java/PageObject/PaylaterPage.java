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
    private WebElement label_paylater_make_payment;

    //@FindBy(xpath = ".//*[@class = "form-input ng-pristine ng-invalid ng-touched"])

    @FindBy(xpath = "/html/body/app-root/app-verify-otp/section/div[1]/form/div/input")
    private WebElement label_enter_otp;

    @FindBy(xpath = ".//*[@type='submit' and @class = 'btn frmBtn']")
    private WebElement label_Submit_button;

    @FindBy(xpath = "//td[text() = 'This Page is for Testing purpose later on will be on merchant Site']")
    private WebElement page_load_text;

    public PaylaterPage(WebDriver driver) {


        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, label_Submit_button);
        //Browser.waitForPageLoad(driver, label_Submit_button);
        Config.logComment("*****On Paylater Page*****");


    }

    public SuccessPage clickOnSubmitButton() throws InterruptedException{
        System.out.println("In this flow");
        Element.click(driver, label_Submit_button, "Click on Submit button");
        Thread.sleep(5000);
        return new SuccessPage(driver);
    }
}
