package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyTransferPage {

    WebDriver driver;

    @FindBy(xpath = "//h1[text() = 'Money Transfer']")
    private WebElement load_money_transfer;

    @FindBy(xpath = "//label[text() = 'Send To Wallet']")
    private WebElement button_send_to_wallet;

    @FindBy(xpath = "//label[text() = 'Send To Bank']")
    private WebElement button_send_to_bank;

    @FindBy(id = "mobileNumber")
    private WebElement textbox_mobile_number;

    @FindBy(id = "amount")
    private WebElement textbox_amount;

    @FindBy(xpath = "//span[text() = 'Go']")
    private WebElement cta_go;

    @FindBy(xpath = "//span[text() = 'Send Money']")
    private WebElement cta_send_money;


    public MoneyTransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, load_money_transfer);
        Config.logComment("*****On money Transfer Page*****");
    }


    public void clickOnSendToWallet() {
        Element.selectElement(driver, button_send_to_wallet, "Send to Wallet");
    }

    public void clickOnSendToBank() {
        Element.selectElement(driver, button_send_to_bank, "Send to Bank");
    }

    public void enterMobileNo(String mobileNo) {
        Element.enterText(driver, textbox_mobile_number, mobileNo, "Mobile No.");
    }

    public void enterAmount(String amount) {
        Element.enterText(driver, textbox_amount, amount, "Amount");
    }

    public void clickOnCtaGo() {
        Element.selectElement(driver, cta_go, "Cta Go");
    }

    public void clickOnCtaSendMoney() {
        Element.selectElement(driver, cta_send_money, "Cta Send Money");
    }


}








