package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentOptionsPage {

    WebDriver driver;

    @FindBy(xpath = "//a/font[text() = 'Net Banking']")
    private WebElement label_net_banking;

    @FindBy(xpath = "//a/font[text() = 'Credit Card']")
    private WebElement label_credit_card;

    @FindBy(xpath = "//a/font[text() = 'Debit Card']")
    private WebElement label_debit_card;

    @FindBy(xpath = "//a/font[text() = 'MobiKwik Wallet']")
    private WebElement label_mobikwik_wallet;

    @FindBy(xpath = "//h2[text() = 'Payment Options']")
    private WebElement page_load_text;


    public PaymentOptionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, page_load_text);
        Config.logComment("*****On Payments Option Page*****");
    }

    public void clickOnDebitCard() {
        Element.selectElement(driver, label_debit_card, "Debit Card");
    }

    public void clickOnCreditCard() {
        Element.selectElement(driver, label_credit_card, "Credit Card");
    }

    public void clickOnNetBankingCard() {
        Element.selectElement(driver, label_net_banking, "Net Banking");
    }

    public void clickOnMobikwikWallet() {
        Element.selectElement(driver, label_mobikwik_wallet, "MobiKwik Wallet");
    }


}








