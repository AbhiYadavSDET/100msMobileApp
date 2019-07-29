package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMoneyPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder = 'Enter Amount']")
    private WebElement textbox_amount;

    @FindBy(xpath = "//span[text() = 'Continue']")
    private WebElement cta_continue;


    @FindBy(xpath = "//a[text() = 'Debit / Credit Cards']")
    private WebElement label_debit_credit_cards;

    @FindBy(xpath = "//a[text() = 'Net Banking']")
    private WebElement label_netbanking;

    @FindBy(xpath = "//mat-radio-button[@id = 'mat-radio-24']")
    private WebElement label_ICICI_bank;

    @FindBy(xpath = "//mat-radio-button[@id = 'mat-radio-25']")
    private WebElement label_HDFC_bank;

    @FindBy(xpath = "//mat-radio-button[@id = 'mat-radio-26']")
    private WebElement label_CITI_bank;

    @FindBy(xpath = "//mat-radio-button[@id = 'mat-radio-27']")
    private WebElement label_AXIS_bank;

    @FindBy(xpath = "//mat-radio-button[@id = 'mat-radio-28']")
    private WebElement label_PNB_bank;


    public AddMoneyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, label_insurance_page_load);
        Config.logComment("*****On Insurance Page*****");
    }

    public void clickOnDebitCards() {
        Element.selectElement(driver, label_debit_credit_cards, "Debit/Credit cards");
    }

    public void clickOnNetbanking() {
        Element.selectElement(driver, label_netbanking, "Netbanking");
    }

    public void clickOnCtaContinue() {
        Element.selectElement(driver, cta_continue, "Continue");
    }

    public void clickOnCtaContinue(String amount) {
        Element.enterText(driver, textbox_amount, amount, "Amount");
    }

}








