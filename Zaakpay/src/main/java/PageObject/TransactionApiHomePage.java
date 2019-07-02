package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionApiHomePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name = 'buyerEmail']")
    private WebElement textbox_buyer_email;

    @FindBy(xpath = "//input[@name = 'buyerFirstName']")
    private WebElement textbox_buyer_first_name;

    @FindBy(xpath = "//input[@name = 'buyerLastName']")
    private WebElement textbox_buyer_last_name;

    @FindBy(xpath = "//input[@name = 'zpAmount']")
    private WebElement textbox_amount;

    @FindBy(xpath = "//a[@class = 'boxes']")
    private WebElement button_pay_via_zaakpay;

    @FindBy(xpath = "//h2[text() = 'Example Checkout Page']")
    private WebElement page_load_text;


    public TransactionApiHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, page_load_text);
        Config.logComment("*****On Transaction Api Home Page*****");
    }

    public PaymentOptionsPage clickOnButtonPayViaZaakpay() {
        Element.selectElement(driver, button_pay_via_zaakpay, "Pay via Zaakpay BUtton");
        return new PaymentOptionsPage(driver);
    }

    public void enterEmail(String email) {
        Element.enterText(driver, textbox_buyer_email, email, "Email");
    }

    public void enterAmount(String amount) {
        Element.enterText(driver, textbox_amount, amount, "Amount");
    }

    public void enterFirstName(String firstName) {
        Element.enterText(driver, textbox_amount, firstName, "First Name");
    }

    public void enterLastName(String lastName) {
        Element.enterText(driver, textbox_amount, lastName, "Last Name");
    }


}








