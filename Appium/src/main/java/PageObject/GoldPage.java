package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
//import utils.Element;

public class GoldPage {

    AndroidDriver driver;


    @AndroidFindBy(id = "buy_gold_button")
    private AndroidElement button_buy_gold;

    @AndroidFindBy(id = "buy_gold_button_registered")
    private AndroidElement cta_buy_gold_for_registered;

    @AndroidFindBy(id = "sell_gold_button_registered")
    private AndroidElement cta_sell_gold_for_registered;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='₹']")
    private AndroidElement text_box_buy_in_rupees;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='gm']")
    private AndroidElement text_box_buy_in_gram;

    @AndroidFindBy(id = "buy_now_button")
    private AndroidElement cta_buy_now;

    @AndroidFindBy(id = "have_a_promo_text")
    private AndroidElement have_promo_code;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement text_box_coupon_code;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
    private AndroidElement button_apply_coupon;


    @AndroidFindBy(id = "btn_gold_action")
    private AndroidElement cta_make_payment;

    @AndroidFindBy(id = "base_icon_close")
    private AndroidElement cross_icon;


    @AndroidFindBy(id = "txt_status")
    private AndroidElement get_txn_status;


    @AndroidFindBy(id = "txt_order_id")
    private AndroidElement get_txn_orderid;

    @AndroidFindBy(id = "txt_amount")
    private AndroidElement quantity_in_gram;


    @AndroidFindBy(id = "gold_balance_button")
    private AndroidElement cta_check_gold_balance;

    @AndroidFindBy(id = "textActionButton")
    private AndroidElement navigate_history;


    @AndroidFindBy(id = "txt_paid_or_received")
    private AndroidElement select_transaction;

    @AndroidFindBy(id = "txt_txn_id")
    private AndroidElement get_transaction_id;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement back_button;

    @AndroidFindBy(id = "txt_description_amount")
    private AndroidElement error_description;

    @AndroidFindBy(id = "btn_gold_action")
    private AndroidElement cta_continue;


    @AndroidFindBy(id = "btn_gold_action")
    private AndroidElement cta_sell_gold;


    public GoldPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Gold Page*****");
    }
/*
    public void clickOnBuyGold() {
        Element.selectElement(driver, button_buy_gold, "Buy Gold Button");
    }

    public void clickOnBuyGoldRegisteredUser() {
        Element.selectElement(driver, cta_buy_gold_for_registered, "Buy Gold Button for Registered User");
    }

    public void clickOnSellGoldRegisteredUser() {
        Element.selectElement(driver, cta_sell_gold_for_registered, "Sell Gold Button for Registered User");
    }

    public void enterAmount(String amount) {
        Element.enterText(driver, text_box_buy_in_rupees, amount, "Enter Amount For Gold");

    }

    public void clickBuyNowCta() {
        Element.selectElement(driver, cta_buy_now, "Click on Buy Now.");
    }

    public void applyPromoCode() {
        Element.selectElement(driver, have_promo_code, "Have a promo code");
        Element.enterText(driver, text_box_coupon_code, "TSTAUGL", "Enter Promo Code");
        Element.selectElement(driver, button_apply_coupon, "Click on Apply Button");
    }

    public void clickOnMakePaymentCta() {
        Element.selectElement(driver, cta_make_payment, "Click on Make Payment");

    }
    //Add Security Pin

    public FiveStarRatingPage clickOnSuccessPageCross() {

        Element.selectElement(driver, cross_icon, "base_icon_close");
        return new FiveStarRatingPage(driver);

    }

    public String getTxnStatus() throws InterruptedException {
        return Element.getText(driver, get_txn_status, "Get TXN Status");
    }

    public String getOrderId() throws InterruptedException {
        return Element.getText(driver, get_txn_orderid, "Get Order ID");
    }

    public String getQuantityInGram() throws InterruptedException {
        return Element.getText(driver, quantity_in_gram, "Get quantity in gram");
    }

    public void clickCheckYourGoldBalance() throws InterruptedException {
        Element.selectElement(driver, cta_check_gold_balance, "Check Gold Balance");
    }

    public void checkHistory() throws InterruptedException {
        Element.selectElement(driver, navigate_history, "Navigate to history to check Gold Balance");
    }


    public void selectTransaction() throws InterruptedException {
        Element.selectElement(driver, select_transaction, "get invoice for the transaction");
    }

    public String getInvoiceIdHistoryPage() throws InterruptedException {
        return Element.getText(driver, get_transaction_id, "Get Invoice id");
    }

    public void clickBack() throws InterruptedException {
        Element.selectElement(driver, back_button, "Back Button");
    }

    public String getErrorDescription() throws InterruptedException {
        return Element.getText(driver, error_description, "Get Error Description");
    }

    public void clickOnContinueCta() {
        Element.selectElement(driver, cta_continue, "Click on Continue");

    }

    public void clickOnSellGoldCta() {
        Element.selectElement(driver, cta_sell_gold, "Click on Sell Gold");

    }

 */

}
