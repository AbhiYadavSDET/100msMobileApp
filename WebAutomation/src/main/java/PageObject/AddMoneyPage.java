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

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent ICICI']")
    public WebElement label_ICICI_bank;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent HDF']")
    public WebElement label_HDFC_bank;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent CITIBK']")
    public WebElement label_CITI_bank;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent AXIS']")
    public WebElement label_AXIS_bank;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent PNB']")
    public WebElement label_PNB_bank;

    @FindBy(xpath = "//span[text() = 'Proceed to Pay']")
    public WebElement button_proceed_to_pay;

    //button[text() = 'New Debit / Credit Card']

    //input[@id = 'cardNo']

    //ng-select[@placeholder = 'MM']

    //ng-select[@placeholder = 'YY']

    //input[@placeholder = 'CVV']




    public AddMoneyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, textbox_amount);
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

    public void enterAmount(String amount) {
        Element.enterText(driver, textbox_amount, amount, "Amount");
    }

    public void selectIcici() {
        Element.selectElement(driver, label_ICICI_bank, "ICICI");
    }

    public void selectHdfc() {
        Element.selectElement(driver, label_HDFC_bank, "HDFC");
    }

    public void selectPnb() {
        Element.selectElement(driver, label_PNB_bank, "PNB");
    }

    public void selectCiti() {
        Element.selectElement(driver, label_CITI_bank, "Citi");
    }

    public void selectAxis() {
        Element.selectElement(driver, label_AXIS_bank, "Axis");
    }

    public void clickOnProceedToPay() {
        Element.selectElement(driver, button_proceed_to_pay, "Proceed to Pay");
    }


}








