package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmexPaymentPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@value = 'Submit']")
    private WebElement button_submit;

    @FindBy(xpath = "//h1[text() = 'ACS Emulator']")
    private WebElement page_load_text;


    public AmexPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, button_submit);
        Config.logComment("*****On Amex Payment Page*****");
    }


    public SuccessPage clickOnSubmitButton() {
        Element.selectElement(driver, button_submit, "Submit");
        return new SuccessPage(driver);
    }


}








