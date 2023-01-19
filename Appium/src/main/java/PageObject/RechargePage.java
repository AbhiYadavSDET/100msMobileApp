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
    private AndroidElement selectNumberPostpaid;

    @AndroidFindBy(id = "et_amt")
    private AndroidElement enterAmountPostpaid;

    @AndroidFindBy(id = "btn_continue")
    private AndroidElement continuePostpaid;

    @AndroidFindBy(id = "tv_total")
    private AndroidElement amountDisplayed;

    @AndroidFindBy(id = "btn_pay")
    private AndroidElement pay;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = '7795709569']")
    private AndroidElement selectNumberPrepaid;

    @AndroidFindBy(id = "tv_search_collapsed")
    private AndroidElement tapToSearchPlan;

    @AndroidFindBy(id = "et_search")
    private AndroidElement enterPlanAmountToSearch;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Talktime']")
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

    public void selectNumberPostpaid() {
        Elements.selectElement(driver, selectNumberPostpaid, "select Mobile Number");
    }

    public void setEnterAmountPostpaid(String amount) {
        Elements.enterToElement(driver, enterAmountPostpaid, amount,"enter amount");
    }

    public void clickOnContinue() {
        Elements.selectElement(driver, continuePostpaid, "click on Continue");
    }


    public void selectNumberPrepaid() {
        Elements.selectElement(driver, selectNumberPrepaid, "select Mobile Number");
    }

    public void tapToSearchPlan() {
        Elements.selectElement(driver,tapToSearchPlan , "Tap To Search Plan");
    }

    public void searchPlanPrepaid(String amount) {
        Elements.enterToElement(driver, enterPlanAmountToSearch, amount,"Enter amount to search plan");
    }

    public void selectPlan() {
        Elements.selectElement(driver, selectPlan, "Tap To Select Plan");
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
