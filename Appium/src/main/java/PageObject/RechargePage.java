package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class RechargePage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Pay Bills']")
    private AndroidElement rechargeAndPayBills;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Bill Payments']")
    private AndroidElement swipeLeftBottomRemove;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Mobile']")
    private AndroidElement mobileButton;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Postpaid']")
    private AndroidElement postpaid;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = '9311878235']")
    private AndroidElement selectNumber;

    @AndroidFindBy(id = "et_amt")
    private AndroidElement enterAmountPostpaid;

    @AndroidFindBy(id = "btn_continue")
    private AndroidElement continuePostpaid;

    @AndroidFindBy(id = "tv_total")
    private AndroidElement amountDisplayed;

    @AndroidFindBy(id = "btn_pay")
    private AndroidElement pay;

    @AndroidFindBy(id = "search_bar")
    private AndroidElement enterNumberTap;

    @AndroidFindBy(id = "et_search")
    private AndroidElement enterNumberBox;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Special Offer']")
    private AndroidElement specialOfferButton;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Top Up']")
    private AndroidElement topUpButton;

    @AndroidFindBy(id = "cl_root")
    private AndroidElement selectPlan;

    @AndroidFindBy(id = "title")
    private AndroidElement title;

    @AndroidFindBy(id = "subtitle")
    private AndroidElement subtitle;

    @AndroidFindBy(id = "right")
    private AndroidElement amountOnSuccessScreen;




    public RechargePage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickRechargeAndPayBills() {
        Elements.selectElement(driver, rechargeAndPayBills, "click on Recharge And PayBills");
    }

    public void clickSwipeLeftBottomRemove() {
        Elements.selectElement(driver, swipeLeftBottomRemove, "Tap to remove Swipe Left Bottom Pop Up");
    }

    public void clickOnMobile() {
        Elements.selectElement(driver, mobileButton, "click on Mobile");
    }

    public void clickOnPostpaid() {
        Elements.selectElement(driver, postpaid, "click on Postpaid");
    }

    public void selectNumber() {
        Elements.selectElement(driver, selectNumber, "select Mobile Number");
    }

    public void setEnterAmountPostpaid(String amount) {
        Elements.enterToElement(driver, enterAmountPostpaid, amount,"enter amount");
    }

    public void clickOnContinue() {
        Elements.selectElement(driver, continuePostpaid, "click on Continue");
    }

    public void clickOnPay() {
        Elements.selectElement(driver, pay, "click on Pay");
    }


    public String getAmountOnPayment() throws InterruptedException {
        return Elements.getText(driver, amountDisplayed, "Amount on payment screen");
    }


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

}
