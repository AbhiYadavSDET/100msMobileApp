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

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Categories']")
    private AndroidElement rechargeAndPayBills;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Bill Payments']")
    private AndroidElement swipeLeftBottomRemove;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Credit Card Payment']")
    private AndroidElement creditCardPayment;

    @AndroidFindBy(id = "close_button")
    private AndroidElement syncEmailBottomSheet;

    @AndroidFindBy(id = "ic_add")
    private AndroidElement addNewCreditCard;

    @AndroidFindBy(id = "ll_add_new_card")
    private AndroidElement addCard;

    @AndroidFindBy(id = "pay_button")
    private AndroidElement payNowButton;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enterText;

    @AndroidFindBy(id = "btn_pin_0")
    private AndroidElement zeroButton;

    @AndroidFindBy(id = "btn_pin_1")
    private AndroidElement oneButton;

    @AndroidFindBy(id = "btn_pin_2")
    private AndroidElement twoButton;

    @AndroidFindBy(id = "btn_pin_3")
    private AndroidElement threeButton;

    @AndroidFindBy(id = "btn_pin_4")
    private AndroidElement fourButton;

    @AndroidFindBy(id = "btn_pin_5")
    private AndroidElement fiveButton;

    @AndroidFindBy(id = "btn_pin_6")
    private AndroidElement sixButton;

    @AndroidFindBy(id = "btn_pin_7")
    private AndroidElement sevenButton;

    @AndroidFindBy(id = "btn_pin_8")
    private AndroidElement eightButton;

    @AndroidFindBy(id = "btn_pin_9")
    private AndroidElement nineButton;

    @AndroidFindBy(id = "btn_submit")
    private AndroidElement continueCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Enter Amount Manually']")
    private AndroidElement enterAmountManually;

    @AndroidFindBy(id = "cl_coupon_view")
    private AndroidElement applyCoupon;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enterCouponCode;

    @AndroidFindBy(id = "textinput_suffix_text")
    private AndroidElement applyButton;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement couponApplied;

    @AndroidFindBy(id = "tv_total")
    private AndroidElement amountDisplayed;

    @AndroidFindBy(id = "btn_pay")
    private AndroidElement pay;

    @AndroidFindBy(id = "right_icon_wallet")
    private AndroidElement walletBalance;

    @AndroidFindBy(id = "right_icon_pg")
    private AndroidElement otherPaymentOptions;

    @AndroidFindBy(id = "action_button")
    private AndroidElement payAmount;

    @AndroidFindBy(id = "title")
    private AndroidElement title;

    @AndroidFindBy(id = "subtitle")
    private AndroidElement subtitle;

    @AndroidFindBy(id = "right")
    private AndroidElement amountOnSuccessScreen;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Pay Now']")
    private AndroidElement savedCardPayButton;

    @AndroidFindBy(id = "btn_explore")
    private AndroidElement checkAutoPayBottomsheet;

    @AndroidFindBy(id = "tv_skip")
    private AndroidElement skipAutoPayBottomsheet;



    public CCPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean scrollToRechargeAndPayBills() throws InterruptedException {
        return Elements.scrollToElement(driver, rechargeAndPayBills);
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

    public void clickPayNowButton() {
        Elements.selectElement(driver, payNowButton, "Click on Pay now button of saved card");
    }

    public Boolean getAddNewCreditCard() throws InterruptedException {
        return Elements.isElementPresent(driver, addNewCreditCard);
    }
    public void clickAddNewCreditCard(){
        Elements.selectElement(driver, addNewCreditCard, "Click on Add new credit card button");
    }
    public void clickOnAddCardButton(){
        Elements.selectElement(driver, addCard, "click on Add card button");
    }

    public void clickEnterCardNumber(){
        Elements.selectElement(driver, enterText, "click on Enter card number");
    }

    public void clickZeroButton() {
        Elements.selectElement(driver, zeroButton, "Click 0");
    }

    public void clickOneButton() {
        Elements.selectElement(driver, oneButton, "Click 1");
    }

    public void clickTwoButton() {
        Elements.selectElement(driver, twoButton, "Click 2");
    }

    public void clickThreeButton() {
        Elements.selectElement(driver, threeButton, "Click 3");
    }

    public void clickFourButton(){
        Elements.selectElement(driver, fourButton, "Click 4");
    }

    public void clickFiveButton() {
        Elements.selectElement(driver, fiveButton, "Click 5");
    }

    public void clickSixButton() {
        Elements.selectElement(driver, sixButton, "Click 6");
    }

    public void clickSevenButton() {
        Elements.selectElement(driver, sevenButton, "Click 7");
    }

    public void clickEightButton() {
        Elements.selectElement(driver, eightButton, "Click 8");
    }

    public void clickNineButton() {
        Elements.selectElement(driver, nineButton, "Click 9");
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
        Elements.selectElement(driver, enterAmountManually, "click on Enter amount manually text box");
    }


    public String getAmountOnPayment() throws InterruptedException {
        return Elements.getText(driver, amountDisplayed, "Amount on payment screen");
    }

    //Enter credit card number/amount
    public void enterCardNumber(String number){


        for(int i = 0 ; i < number.length() ; i++) {
            char c = number.charAt(i);

            switch (c) {
                case '2':
                    clickTwoButton();
                    break;

                case '5':
                    clickFiveButton();
                    break;

                case '8':
                    clickEightButton();
                    break;

                case '0':
                    clickZeroButton();
                    break;

                case '1':
                    clickOneButton();
                    break;

                case '4':
                    clickFourButton();
                    break;

                case '7':
                    clickSevenButton();
                    break;

                case '3':
                    clickThreeButton();
                    break;

                case '6':
                    clickSixButton();
                    break;

                case '9':
                    clickNineButton();
                    break;

            }
        }
    }

    public void clickApplyCoupon(){ Elements.selectElement(driver, applyCoupon, "Click on Apply coupon"); }

    public void enterEnterCouponCode() {
        Element.waitForVisibility(driver,enterCouponCode);
        Elements.enterToElement(driver, enterCouponCode, "CCPAY" ,"Enter CCPAY as coupon code"); }

    public void clickApplyButton() { Elements.selectElement(driver, applyButton, "Click on Apply button"); }

    public String getCouponTitle() throws InterruptedException {
        return Elements.getText(driver, couponApplied, "Coupon Applied on payment screen");
    }

    public void clickOnPay() { Elements.selectElement(driver, pay, "click on Pay"); }

    public void clickWalletBalance(){
        Elements.selectElement(driver, walletBalance, "Click on wallet balance");
    }

    public void clickOtherPaymentOptions(){Elements.selectElement(driver, otherPaymentOptions, "Click on Other Payment options");}

    public void clickPayAmount(){
        Elements.selectElement(driver, payAmount, "Click on Pay button");
    }

    public void clickOnSavedCardPayButton() { Elements.selectElement(driver, savedCardPayButton, "click on PayNow button of saved card"); }



    // Success Screen methods
    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Base Title");
    }

    public String getSubTitle() throws InterruptedException {
        return Elements.getText(driver, subtitle, "Sub Title");
    }

    public String getAmountOnSuccessScreen() throws InterruptedException {
        return Elements.getText(driver, amountOnSuccessScreen, "Amount on success screen");
    }

    public Boolean checkSwipeLeftBottom() throws InterruptedException {
        return Elements.isElementPresent(driver, swipeLeftBottomRemove);
    }

    public Boolean checkAutoPayBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, checkAutoPayBottomsheet);
    }

    public void clickSkipbtn() throws InterruptedException {
        Elements.selectElement(driver, skipAutoPayBottomsheet, "Click On SKIP Autopay Bottomsheet");
    }

}
