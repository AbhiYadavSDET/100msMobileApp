package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class RechargePage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Categories']")
    private AndroidElement rechargeAndPayBills;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Bill Payments']")
    private AndroidElement thirdTimeLuckyPopupRemove;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Bill Payments']")
    private AndroidElement swipeLeftBottomRemove;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Enable secure login']")
    private AndroidElement enableSecureLoginBottomSheet;

    @AndroidFindBy(id = "android:id/alertTitle")
    private AndroidElement mobileRechargeAlert;

    @AndroidFindBy(id = "android:id/button2")
    private  AndroidElement closeMobileRechargeAlert;


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

    @AndroidFindBy(id = "tv_skip")
    private AndroidElement skipAutoPayBottomsheet;

    @AndroidFindBy(id = "btn_explore")
    private AndroidElement checkAutoPayBottomsheet;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Change']")
    private AndroidElement change;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'MTNL']")
    private AndroidElement airtelOperator;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Search your circle']")
    private AndroidElement searchCircle;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Delhi NCR']")
    private AndroidElement selectCircle;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text='MTNL prepaid']")
    private AndroidElement operatorName;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text='Delhi NCR']")
    private AndroidElement circleName;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text='Enter name or Mobile no.']")
    private AndroidElement searchMobileNo;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Search your contacts or enter number']")
    private AndroidElement searchContact;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text='9311878235']")
    private AndroidElement selectNumber;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Switch to Postpaid']")
    private AndroidElement switchToPostpaid;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Reliance']")
    private AndroidElement relianceOperator;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'My Number']")
    private AndroidElement myNumber;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text='Reliance prepaid']")
    private AndroidElement relianceOperatorName;



    public RechargePage(AndroidDriver driver){
        this.driver=driver;
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

    public void clickThirdTimeLuckyPopupRemove() {
        Elements.back(driver, "Tap to remove Third Time Lucky Pop Up");

    }

    public void clickEnableSecureLoginBottomSheet() {
        Elements.back(driver, "Tap to remove Enable Secure Login Bottom Sheet");

    }

    public Boolean clickMobileRechargeAlert() throws InterruptedException {
        return Elements.isElementPresent(driver, mobileRechargeAlert);

    }

    public void clickToCloseMobileRechargeAlert()
    {
        Elements.selectElement(driver, closeMobileRechargeAlert, "Click Later to close Mobile Recharge Bonanza Alert");
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

    public void clickChangeButton() {
        Elements.selectElement(driver, change,"Click on change button");
    }

    public void selectAirtelOperator() {
        Elements.selectElement(driver, airtelOperator,"Select an operator");
    }

    public void clickOnSearchCircle() {
        Elements.selectElement(driver, searchCircle,"Select an search your circle");
    }

    public void enterCircleName(String circle) {
        Elements.enterToElement(driver, searchCircle, circle,"enter circle name");
    }

    public void selectCircle() {
        Elements.selectElement(driver, selectCircle,"Select circle");
    }

    public String getOperatorName() throws InterruptedException { return Elements.getText(driver, operatorName); }

    public String getCircleName() throws InterruptedException { return Elements.getText(driver, circleName); }

    public void clickOnSearchMobileNoField(){
        Elements.selectElement(driver, searchMobileNo, "Click on Search Mobile No. Field");
    }

    public void clickEnterMobileNoField(){
        Elements.selectElement(driver, searchMobileNo,"Click on Search mobile no. field");
    }

    public void enterMobileNo(String number){
        Elements.enterToElement(driver, searchContact,number, "Enter Mobile no");
    }

    public void selectNumber(){
        Elements.selectElement(driver, selectNumber,"Select mobile no.");
    }

    public void clickOnSwitchToPostpaid(){
        Elements.selectElement(driver, switchToPostpaid,"Click on Switch to postpaid");
    }

    public void selectRelianceOperator() {
        Elements.selectElement(driver, relianceOperator,"Select an operator");
    }

    public void clickOnMyNumber() {
        Elements.selectElement(driver, myNumber,"Click on my number");
    }
    public String getRelianceOperatorName() throws InterruptedException { return Elements.getText(driver, relianceOperatorName); }





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

    public void clickSkipbtn() throws InterruptedException {
         Elements.selectElement(driver, skipAutoPayBottomsheet, "Click On SKIP Autopay Bottomsheet");
    }

    public Boolean checkAutoPayBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, checkAutoPayBottomsheet);
    }

    public Boolean checkSwipeLeftBottom() throws InterruptedException {
        return Elements.isElementPresent(driver, swipeLeftBottomRemove);
    }


}
