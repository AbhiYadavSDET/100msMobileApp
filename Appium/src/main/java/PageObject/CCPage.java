package PageObject;

import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CCPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Pay Bills']")
    private AndroidElement rechargeAndPayBills;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Bill Payments']")
    private AndroidElement swipeLeftBottomRemove;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Credit Card Payment']")
    private AndroidElement creditCardPayment;

    @AndroidFindBy(id = "close_button")
    private AndroidElement syncEmailBottomSheet;

    @AndroidFindBy(id = "cl_root")
    private AndroidElement addNewCreditCard;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enterText;

    @AndroidFindBy(id = "btn_pin_4")
    private AndroidElement fourButton;

    @AndroidFindBy(id = "btn_pin_3")
    private AndroidElement threeButton;

    @AndroidFindBy(id = "btn_pin_7")
    private AndroidElement sevenButton;

    @AndroidFindBy(id = "btn_pin_5")
    private AndroidElement fiveButton;

    @AndroidFindBy(id = "btn_pin_1")
    private AndroidElement oneButton;

    @AndroidFindBy(id = "btn_pin_0")
    private AndroidElement zeroButton;


    @AndroidFindBy(id = "btn_submit")
    private AndroidElement continueCTA;

    @AndroidFindBy(id = "cl_amt_manual")
    private AndroidElement enterAmountManually;

    @AndroidFindBy(id = "tv_total")
    private AndroidElement amountDisplayed;



    public CCPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickRechargeAndPayBills() {
        Elements.selectElement(driver, rechargeAndPayBills, "click on Recharge And PayBills");
    }

    public void clickSwipeLeftBottomRemove() {
        Elements.selectElement(driver, swipeLeftBottomRemove, "Tap to remove Swipe Left Bottom Pop Up");
    }

    public void clickOnCreditCardPayment(){
        Elements.selectElement(driver, creditCardPayment, "click on credit card payment" );
    }

    public void clickSyncEmailBottomSheet() {
        Elements.selectElement(driver, syncEmailBottomSheet, "Click close to close Sync Email bottom sheet");
    }

    public void clickAddNewCreditCard(){
        Elements.selectElement(driver, addNewCreditCard, "click on Add new credit card");
    }

    public void clickEnterCardNumber(){
        Elements.selectElement(driver, enterText, "click on Enter card number");
    }

    public void clickFourButton(){
        Elements.selectElement(driver, fourButton, "Click 4");
    }

    public void clickThreeButton() {
        Elements.selectElement(driver, threeButton, "Click 3");
    }

    public void clickSevenButton() {
        Elements.selectElement(driver, sevenButton, "Click 7");
    }


    public void clickFiveButton() {
        Elements.selectElement(driver, fiveButton, "Click 5");
    }


    public void clickOneButton() {
        Elements.selectElement(driver, oneButton, "Click 1");
    }

    public void clickContinueCTA(){
        Elements.selectElement(driver, continueCTA, "Click on Continue button");
    }

    public void clickEnterAmountManually(){
        Elements.selectElement(driver, enterAmountManually, "Click Enter amount manually field");
    }

    public void enterEnterAmountManually(){
        Elements.enterToElement(driver, enterAmountManually, "100", "Enter amount");
    }

    public void clickEnterAmountField(){
        Elements.selectElement(driver, enterText, "click on Enter amount manually text box");
    }

    public void clickZeroButton() {
        Elements.selectElement(driver, zeroButton, "Click 0");
    }

    public String getAmountOnPayment() throws InterruptedException {
        return Elements.getText(driver, amountDisplayed, "Amount on payment screen");
    }



}
