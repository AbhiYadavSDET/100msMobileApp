package PageObject;

import Helpers.TransactionApiHelper;
import Utils.Browser;
import Utils.Config;
import Utils.Element;
import Utils.Log;
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

    @FindBy(xpath = "//input[@id = 'panId']")
    private WebElement textbox_cardno;

    @FindBy(xpath = "//select[@name = 'expiry_month']")
    private WebElement select_expiry_month;

    @FindBy(xpath = "//select[@name = 'expiry_year']")
    private WebElement select_expiry_year;

    @FindBy(xpath = "//input[@id = 'cvvnum']")
    private WebElement textbox_cvv;

    @FindBy(xpath = "//input[@value = 'Make Payment']")
    private WebElement button_make_payment;

    @FindBy(xpath = "//em")
    private WebElement label_order_id;

    @FindBy(xpath = "//select[@name = 'banksList']")
    private WebElement select_bank;

    @FindBy(xpath = "//label[text()= 'Other Banks']/following::input[@value = 'Make Payment'][1]")
    private WebElement button_make_payment_netbanking;

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

    public void enterCardNo(String cardNo) {
        Element.enterText(driver, textbox_cardno, cardNo, "Card No");
    }

    public void selectExpiryMonth(String expirymonth) {
        //1
        Element.selectValue(driver, select_expiry_month, expirymonth, "Expiry Month");
    }

    public void clickOnNetBanking() {
        Element.selectElement(driver, label_net_banking, "Net Banking");
    }

    public void selectBank(String bankValue) {
        //2019
        Log.info("select start");
        Element.selectValue(driver, select_bank, bankValue, "Bank");
        Log.info("select end");

    }


    public void selectExpiryYear(String expiryyear) {
        //2019
        Element.selectValue(driver, select_expiry_year, expiryyear, "Expiry Year");
    }

    public void enterCvv(String cvv) {
        Element.enterText(driver, textbox_cvv, cvv, "Cvv");
    }

    public Object clickOnMakePayment(TransactionApiHelper.flowType flowType) {
        Element.selectElement(driver, button_make_payment, "Make Payment");

        switch (flowType) {
            case AMEX:
                // Amex payment
                return new AmexPaymentPage(driver);


            case HDFC:
                // HDFC payment
                return new SuccessPage(driver);


            case CCAVENUE:
                // CCAvenue payment
                return new CcAvenuePaymentPage(driver);


            case CYBERSOURCE:
                // CyberSource
                return new AmexPaymentPage(driver);


        }
        return new AmexPaymentPage(driver);

    }

    public String getOrderId() {
        return Element.getText(driver, label_order_id, "Order id");
    }

    public CcAvenuePaymentPage clickOnMakePaymentNetbanking() {
        Element.selectElement(driver, button_make_payment_netbanking, "Make Payment");
        return new CcAvenuePaymentPage(driver);

    }

}








