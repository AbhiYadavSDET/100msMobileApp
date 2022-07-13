package PageObject;

import utils.Config;
import utils.Elements;
import utils.Element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Locale;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class RechargePage {
    //############################ Udit start ################################

    // Login, home and permission page elements

    @AndroidFindBy(id = "navigation_service")
    private AndroidElement allService;

    @AndroidFindBy(id = "navigation_home")
    private AndroidElement homeTab;

    @AndroidFindBy(id = "skip")
    private AndroidElement checkSkip;

    @AndroidFindBy(id = "permission_allow_foreground_only_button")
    private AndroidElement checkLocationAccess;

    @AndroidFindBy(id = "icon_drawer")
    private AndroidElement clickSideDrawer;

    @AndroidFindBy(id = "drawer_row_accounts")
    private AndroidElement clickAccounts;

    @AndroidFindBy(id = "btn_logout")
    private AndroidElement clickLogout;

    // Common elements
    @AndroidFindBy(xpath="//*[@text='Continue']")
    private AndroidElement continueButton;

    @AndroidFindBy(id = "view_curved")
    private AndroidElement checkSwipLeftPopUp;

    // Mobile recharge elements
    @AndroidFindBy(xpath="//*[@text='Mobile']")
    private AndroidElement mobileButton;

    @AndroidFindBy(xpath="//*[@class='android.widget.EditText']")
    private AndroidElement enterNumber;

    @AndroidFindBy(xpath="//*[@text='Bill Payment for']")
    private AndroidElement billPaymentForText;

    @AndroidFindBy(xpath="//*[@text='Recharge for']")
    private AndroidElement rechargeForText;

    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private AndroidElement selectMobile;

    @AndroidFindBy(id = "btn_pin_submit")
    private AndroidElement nextCTA;

    @AndroidFindBy(xpath="//*[@text='Confirm']")
    private AndroidElement confirmButton;

    @AndroidFindBy(xpath="//*[@text='Recharge & Pay Bills']")
    private AndroidElement rechargeBills;

    @AndroidFindBy(xpath="//*[@text='Security PIN']")
    private AndroidElement clickSecurityPin;

    @AndroidFindBy(xpath="//*[@class='android.widget.Switch']")
    private AndroidElement operatorType;

    @AndroidFindBy(xpath="//android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
    private AndroidElement clickPayButton;

    @AndroidFindBy(xpath="//*[@text='OFF']")
    private AndroidElement offText;

    @AndroidFindBy(xpath="//*[@text='ON']")
    private AndroidElement onText;

    @AndroidFindBy(xpath="//*[@text='Yes']")
    private AndroidElement yesButton;

    @AndroidFindBy(id = "have_a_promo_text")
    private AndroidElement clickApplyCoupon;

    @AndroidFindBy(id = "radio_button_sc")
    private AndroidElement clickApplySupercash;

    @AndroidFindBy(xpath="//*[@class='android.widget.EditText']")
    private AndroidElement couponField;

    @AndroidFindBy(xpath="//*[@text='Apply']")
    private AndroidElement clickApply;

    @AndroidFindBy(xpath="//*[@text='SuperCash']")
    private AndroidElement checkSupercash;

    @AndroidFindBy(xpath="//*[contains(@text,'Success')]")
    private AndroidElement success;

    @AndroidFindBy(xpath="//*[contains(@text,'Fail')]")
    private AndroidElement fail;

    @AndroidFindBy(xpath="//*[contains(@text,'Pending')]")
    private AndroidElement pending;

    @AndroidFindBy(xpath="//*[@text='View Details']")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(xpath="//*[@text='More']")
    private AndroidElement moreButton;

    // Gas elements
    @AndroidFindBy(xpath="//*[@text='Piped Gas']")
    private AndroidElement pipedGasButton;

    @AndroidFindBy(xpath="//*[@text='Select an Operator']")
    private AndroidElement enterOperator;

    @AndroidFindBy(xpath="//*[@class='android.widget.ImageView']")
    private AndroidElement selectOperator;

    @AndroidFindBy(xpath="//*[@text='BP Number']")
    private AndroidElement bpNumberGas;

    @AndroidFindBy(xpath="//*[@text='No Dues')]")
    private AndroidElement noDuesText;

    @AndroidFindBy(xpath="//*[@text='Unable to get bill details']")
    private AndroidElement unableToFetchBill;

    // Electricity elements
    @AndroidFindBy(xpath="//*[@text='Electricity']")
    private AndroidElement electricityButton;

    @AndroidFindBy(xpath="//*[@text='Select an Electricity Board']")
    private AndroidElement enterBoard;

    @AndroidFindBy(xpath="//*[@class='android.widget.ImageView']")
    private AndroidElement selectBoard;

    AndroidDriver driver;

    //############################ Udit end ################################

    //############################ Old start ################################

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Please Enter Name or Mobile No.']")
    private AndroidElement textbox_mobile_no;

    @AndroidFindBy(id = "contact_number")
    private AndroidElement numberSelecter;

    //Udit added
    @AndroidFindBy(id = "search_text")
    private AndroidElement unknownNumberSelecter;

    //Pallavi Xpath
    @AndroidFindBy(id = "toggle_button")
    private AndroidElement prepaidPostpaid_toggle;

    @AndroidFindBy(id = "horizontal_button_2")
    private AndroidElement rightYes_Cta;

    @AndroidFindBy(id = "horizontal_button_2")
    private AndroidElement popupbutton_yes;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enterText_click;

    @AndroidFindBy(id = "continue_button")
    private AndroidElement continue_button;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ę']")
    private AndroidElement back_electricity_icon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Adani Electricity Mumbai Limited']")
    private AndroidElement dropdown_electricityFirstOperator;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Aavantika Gas Ltd.']")
    private AndroidElement dropdown_gasConnection;

    @AndroidFindBy(id = "right_arrow")
    private AndroidElement link_drop_down;

    @AndroidFindBy(id = "parent_layout")
    private AndroidElement link_drop_down_mobilenoselect;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'VI']")
    private AndroidElement label_vodafone;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Haryana']")
    private AndroidElement label_haryana;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '8506053433']")
    private AndroidElement saved_contactNo;


//    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Amount (in X)']/following::android.widget.TextView[@text = 'Enter any amount']")
    //@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Amount (in ₹)'/following::android.widget.TextView[@text = 'Enter any amount']")

    @AndroidFindBy(id = "edit_text")
    public AndroidElement textbox_enter_amount;

    @AndroidFindBy(id = "see_plans")
    public AndroidElement cta_see_all_plans;


    @AndroidFindBy(id = "edit_text")
    private AndroidElement textbox_enter_amount2;

    @AndroidFindBy(id = "btn_pin_submit")
    private AndroidElement button_continue;

    @AndroidFindBy(xpath = "//android.widget.Button[@text= 'Confirm']")
    private AndroidElement confirmButtonAmountPage;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta_continue;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Postpaid']")
    private AndroidElement postPaid;

    // Success screen

    @AndroidFindBy(id = "cn_value")
    private AndroidElement label_connection_no;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Category']/following::android.widget.TextView[1]")
    private AndroidElement label_category;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Operators']/following::android.widget.TextView[1]")
    private AndroidElement label_opertor_Gas;

    @AndroidFindBy(id = "operator")
    private AndroidElement label_operator;

    @AndroidFindBy(id = "amount")
    private AndroidElement label_amount;

    @AndroidFindBy(id = "total_amount_value")
    private AndroidElement label_total_payment;

    @AndroidFindBy(xpath = "//*[@id='header_container']//*[@id='title']")
    private AndroidElement label_success_page_status;

    @AndroidFindBy(id = "recharge_button")
    private AndroidElement cta_continue2;

    @AndroidFindBy(id = "content_root")
    public AndroidElement popup;

    @AndroidFindBy(id = "title_text")
    public AndroidElement popup_error;

    @AndroidFindBy(id = "body_text")
    public AndroidElement popup_text;

    @AndroidFindBy(id = "close_button")
    public AndroidElement popup_cross;

    @AndroidFindBy(id = "view_bill_text")
    public AndroidElement viewBillText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'z']/following::android.widget.EditText[1]")
    public AndroidElement textbox_enter_dth_amount;

    @AndroidFindBy(id = "connection_detail_button_recharge")
    public AndroidElement button_dth_continue;

    @AndroidFindBy(id = "promo_text")
    public AndroidElement label_promo_code_text;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'More']")
    public AndroidElement label_more;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Bill Payment for']")
    public AndroidElement text_billpayment;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text = 'Remind me for forthcoming bill payments']")
    public AndroidElement text_reminder;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'BP Number']/following::android.widget.EditText[1]")
    public AndroidElement textbox_bp_number;

    @AndroidFindBy(id = "connection_detail_textView_name")
    public AndroidElement label_success_screen_operator;

    @AndroidFindBy(id = "connection_detail_textView_company")
    public AndroidElement label_success_screen_number;

    @AndroidFindBy(id = "fixed_amount_value")
    public AndroidElement label_success_screen_amount;

    @AndroidFindBy(id = "edit_text")
    public AndroidElement id_amount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Telephone Number (Without STD Code)']/following::android.widget.EditText[1]")
    public AndroidElement textbox_telephone_no;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Telephone Number (Without STD Code)']/following::android.widget.EditText[2]")
    public AndroidElement textbox_can;


    //See All option for Plans

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'TOPUP']")
    public AndroidElement header_top_up_plan_types;

    @AndroidFindBy(id = "mkab_icon_1")
    public AndroidElement cta_back_button_plans_page;


    //Credit card Wapg Flow

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'ICICI BANK LTD']")
    public AndroidElement credit_card_from_saved_connection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Credit Card Bill']")
    public AndroidElement credit_card_bill_title;


    @AndroidFindBy(id="edit_text")
    public AndroidElement textbox_enter_credit_card_amount;

    @AndroidFindBy(id="btn_pin_submit")
    public AndroidElement cta_submit_amount;

    @AndroidFindBy(id = "cta")
    public AndroidElement button_credit_card_continue;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Confirm Payment']")
    public AndroidElement confirm_payment_title;

    @AndroidFindBy(id = "wallet_layout")
    public AndroidElement select_wallet_balance_flow;

    @AndroidFindBy(id = "pg_layout")
    public AndroidElement select_walletAsPG_balance_flow;

    @AndroidFindBy(id="why_layout")
    public AndroidElement cta_why;

    @AndroidFindBy(id="btn_okay")
    public AndroidElement cta_ok;

    @AndroidFindBy(id="fees_wallet")
    public AndroidElement get_fees;

    @AndroidFindBy(id="processing_fee_title")
    public AndroidElement why_page_opened;

    @AndroidFindBy(id = "base_title")
    public AndroidElement pending_screen_title;

    @AndroidFindBy(id = "base_sub_title")
    public AndroidElement pending_desc_message;

    @AndroidFindBy(id = "amount")
    public AndroidElement total_amount_value;

    @AndroidFindBy(id = "base_icon_back")
    public AndroidElement cross_icon_pending_screen;

    @AndroidFindBy(id = "cross_icon")
    public AndroidElement select_cross_icon;

//cta_continue


    //Coupon and voucher
    @AndroidFindBy(id = "have_a_promo_text")
    private AndroidElement have_promo_code;

    @AndroidFindBy(id = "redeem_layout")
    private AndroidElement select_voucher;

    //############################ Old end ################################

    public RechargePage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //############################ Udit start ################################
    public boolean checkResultScreen(String operator) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,operator,10);
        if(Elements.isElementPresent(driver,billPaymentForText)){
            Config.logComment("Bill is present for current bill");
            return true;
        }else if(Elements.isElementPresent(driver,rechargeForText)){
            Config.logComment("Bill is present for current bill");
            return true;
        }else{
            Config.logComment("Currently bill is not present or unable to fetch bill");
            return false;
        }
    }

//    public void clickAllServicesTab() {
//        Elements.selectElement(driver,allService,"Click All Services tab");
//    }

    public void selectOperator(String operator) {
        Elements.selectElement(driver,operator,"Click gas operator");
    }

    public void clickMobileButton() {
        Elements.selectElement(driver,mobileButton,"Click mobile button");
    }

    public void enterMobileNumber(String number) {
        Elements.waitForElementToVisibleOnPage(driver,enterNumber,5);
        Elements.enterToElement(driver, enterNumber, number,"Enter Mobile Number");
    }

    public void selectNumber() {
        Elements.selectElement(driver,selectMobile,"Click mobile number");
    }

    public void selectCircle(String circle) {
        Elements.selectElement(driver,circle,"Click your sim circle");
    }

    public void enterAmount(String amount) {
        Elements.waitForElementToVisibleOnPage(driver,enterNumber,5);
        for(int i=0;i<amount.length();i++) {
            Elements.selectElement(driver, amount.substring(i,i+1), "Enter amount");
        }
    }

    public void clickNextCTA() throws InterruptedException {
        if(Elements.isElementEnabled(driver,nextCTA)) {
            Elements.selectElement( driver, nextCTA, "Click next CTA");
        }else{
            Config.logComment("Next CTA is not clickable ,Please check");
        }
    }

    public void clickConfirm() {
        Elements.selectElement(driver,confirmButton,"Click Confirm button");
    }

    public void enterSecurityPin(String pin) {
        Elements.waitForElementToVisibleOnPage(driver,clickSecurityPin,5);
        for(int i=0;i<pin.length();i++) {
            Elements.selectElement(driver, pin.substring(i,i+1), "Enter Security Pin");
        }
    }

    public void clickPayButton() {
        Elements.waitForElementToVisibleOnPage(driver,clickPayButton,15);
        Elements.selectElement(driver,clickPayButton,"Click Pay button");
    }

//    public void clickHomeTab() {
//        Elements.selectElement(driver,homeTab,"Click Home tab");
//    }

//    public void clickRechargePayBill() {
//        Elements.selectElement(driver,rechargeBills,"Click Recharge & Pay Bills");
//    }

    public void clickContinue(String comment) {
        Elements.selectElement(driver,continueButton,"Click Continue button for "+comment);
    }

    public void changeType() {
        Elements.selectElement(driver,operatorType,"Change type of operator");
    }

    public boolean checkOperatorType(String operatorType) throws InterruptedException {
        if(operatorType.toLowerCase(Locale.ROOT).equals("prepaid") && Elements.isElementPresent(driver,offText)){
            return false;
        }else if(operatorType.toLowerCase(Locale.ROOT).equals("postpaid") && Elements.isElementPresent(driver,onText)){
            return false;
        }else{
            return true;
        }
    }

    public void clickYes() {
        Elements.waitForElementToVisibleOnPage(driver,yesButton,5);
        Elements.selectElement(driver,yesButton,"Click yes");
    }

    public void clickSwipPopUp() {

        Elements.selectElement(driver,checkSwipLeftPopUp,"Click Swipe left to explore more services");
    }

//    public void clickSkip() {
//        Elements.selectElement(driver,skipButton,"Click Skip");
//    }

//    public void clickLocationAccess() {
//        Elements.selectElement(driver,checkLocationAccess,"Click allow location");
//    }

//    public void openSideDrawr() {
//        Elements.selectElement(driver,clickSideDrawer,"Open side drawer");
//        double anchorPercentage=0.8;
//        double startPercentage= 0.9;
//        double endPercentage= 0.2;
//        Dimension size = driver.manage().window().getSize();
//        int anchor = (int) (size.height * anchorPercentage);
//        int startPoint = (int) (size.width * startPercentage);
//        int endPoint = (int) (size.width * endPercentage);
//        new TouchAction(driver)
//                .press(point(startPoint, anchor))
//                .waitAction(waitOptions(ofMillis(1000)))
//                .moveTo(point(endPoint, anchor))
//                .release().perform();
//    }

//    public void clickAccounts() {
//        Elements.selectElement(driver,clickAccounts,"Click accounts button");
//    }

    public void clickLogout() {
        Elements.waitForElementToVisibleOnPageUsingText(driver,"Account",5);
        double anchorPercentage=0.5;
        double startPercentage= 0.9;
        double endPercentage= 0.2;
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
        Elements.selectElement(driver,clickLogout,"Click Logout button");
    }

    public void clickApplyCoupon() {
        Elements.waitForElementToVisibleOnPage(driver,clickApplyCoupon,7);
        Elements.selectElement(driver,clickApplyCoupon,"Click Apple coupon or Supercash");
    }

    public void clickApplySupercash() throws InterruptedException {
        Elements.isElementPresent(driver,clickApplySupercash);
        Elements.selectElement(driver,clickApplySupercash,"Apply Supercash");
    }

    public void enterCouponCode(String coupon) {
        Elements.clearText(driver,couponField,"Coupon field");
        Elements.enterToElement(driver,couponField,coupon,"Enter coupon");
    }

    public void clickApplyButton() {
        Elements.selectElement(driver,clickApply,"Apply button");
    }

    public void checkSupercashApplied() throws InterruptedException {
        Elements.waitForElementToVisibleOnPage(driver,checkSupercash,5);
        Assert.assertTrue(Elements.isElementPresent(driver,checkSupercash));
    }

    public void checkCouponApplied(String coupon) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,coupon,5);
        Assert.assertTrue(Elements.isElementPresent(driver,coupon));
    }

    public void checkPaymentScreen(String number, String amount) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,number,7);
        if(Elements.isElementPresent(driver,number) && Elements.isElementPresent(driver,"₹"+amount)){

        }else{
            Config.info("Issue in details");
            Assert.assertTrue(false);
        }

        Elements.waitForElementToVisibleOnPage(driver,success,7);
        if(Elements.isElementPresent(driver,success) || Elements.isElementPresent(driver,pending)){
            while(!Elements.isElementPresent(driver,checkViewDetails)) {
                Elements.back(driver, "Back button");
            }

        }else{
            Config.info("Issue in payment");
            Assert.assertTrue(false);
        }
    }

    public void checkResultScreenGas(String operator) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,operator,10);
//        Thread.sleep(5000);
        if(Elements.isElementPresent(driver,unableToFetchBill)){
            Config.logComment("Unable to get bill details due to some issue");
        }else if(Elements.isElementPresent(driver,billPaymentForText)){
            Config.logComment("Bill is present for current bill");
        }else if(Elements.isElementPresent(driver,noDuesText)){
            Config.logComment("No dues for current bill");
        }
    }

    public void clickMoreButtonGas() {
        Elements.selectElement(driver,moreButton,"Click more button");
    }

    public void clickPipedGasButtonGas() {
        Elements.selectElement(driver,pipedGasButton,"Click piped gas button");
    }

    public void enterOperatorGas(String operatorName) {
        Elements.enterToElement(driver, enterOperator, operatorName,"Enter operator name");
    }

    public void selectOperatorGas() {
        Elements.selectElement(driver,selectOperator,"Click gas operator");
    }

    public void enterBPNumberGas(String BP_Number) {
        Elements.waitForElementToVisibleOnPage(driver,bpNumberGas,5);
        Elements.enterToElement(driver, bpNumberGas, BP_Number,"Enter BP Number");
    }

    public void checkResultScreenElectricity(String operator) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,operator,10);
//        Thread.sleep(5000);
        if(Elements.isElementPresent(driver,noDuesText)){
            Config.logComment("No dues for current bill");
        }else if(Elements.isElementPresent(driver,billPaymentForText)){
            Config.logComment("Bill is present for current bill");
        }else if(Elements.isElementPresent(driver,unableToFetchBill)){
            Config.logComment("Unable to get bill details due to some issue");
        }
    }

    public void clickElectricityButtonElectricity() {
        Elements.selectElement(driver,electricityButton,"Click electricity button");
    }

    public void enterBoardElectricity(String operatorName) {
        Elements.enterToElement(driver, enterBoard, operatorName,"Enter board name");
    }

    public void selectBoardElectricity() {
        Elements.selectElement(driver,selectBoard,"Click electricity board");
    }

    public void enterNumberElectricity(String BP_Number) {
        Elements.waitForElementToVisibleOnPage(driver,enterNumber,5);
        Elements.enterToElement(driver, enterNumber, BP_Number,"Enter Number");
    }
    //############################ Udit end ################################

    //############################ Old start ################################

    public void enterMobileNo(String cell) throws InterruptedException {
        Element.enterText(driver, textbox_mobile_no, cell, "Mobile No");
        if(Element.isElementPresent(driver,By.id("contact_number"))) {
            Element.selectElement(driver, numberSelecter, "select number from contact List");
        }else if(Element.isElementPresent(driver,By.id("search_text"))){
            Element.selectElement(driver, unknownNumberSelecter, "select number from List");
        }
    }

    public void enterPostpaidMobileNo(String cell) throws InterruptedException {
        Element.enterText(driver, textbox_mobile_no, cell, "Mobile No");

    }


    //Pallavi Change
    public void changePrepaidPostpaidToggle() throws InterruptedException {
        Element.selectElement(driver, prepaidPostpaid_toggle, "selectpostpaid from toggle");
    }


    public void clickYesCta() throws InterruptedException {
        Element.selectElement(driver, popupbutton_yes, "select pop up button yes");
    }

    public void clickOnPopupYes() throws InterruptedException {
        Element.selectElement(driver, popupbutton_yes, "Select Yest from Popup");
    }

    public void enterTextClick() throws InterruptedException {
        Element.selectElement(driver, enterText_click, "click on enter amount");
    }

    public void dropdownElectricityfirstOpClick() throws InterruptedException {
        Element.selectElement(driver, dropdown_electricityFirstOperator, "click on first electricity operator");
    }

    public void enterPostpaidAmount(String amount) throws InterruptedException {
        Element.enterText(driver, enterText_click, amount, "Enter Amount");
    }


    public void clickOnDropDown() throws InterruptedException {
        Element.selectElement(driver, link_drop_down, "Drop down");
    }

    public void clickOnDropdownMobile() throws InterruptedException {
        Element.selectElement(driver, link_drop_down_mobilenoselect, "Select mobile no from dropdown");
    }

    public void selectOperator() throws InterruptedException {
        Element.selectElement(driver, label_vodafone, "Operator");
    }

//    public void selectOperator(String operator) throws InterruptedException {
//        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text = '" + operator + "']"));
//        AndroidElement androidElement = new Element(driver).findElement(driver, By.xpath("//android.widget.TextView[@text = '" + operator + "']"));
//        Element.selectElement(driver, androidElement, "Operator");
//    }

    public void selectCircle() throws InterruptedException {
        Element.selectElement(driver, label_haryana, "Circle");
    }


    public void selectPostpaidnoSavedContact() throws InterruptedException {
        Element.selectElement(driver, saved_contactNo, "SAve connection postpaid No");
    }

    public void selectAmount() throws InterruptedException {
        Element.selectElement(driver, textbox_enter_amount, "Select Amount");
    }

    public void clickOnSeeAllPlans() throws InterruptedException {
        Element.selectElement(driver, cta_see_all_plans, "Select See all plans");
    }

    public void clickOnBackButtonPlansPage() throws InterruptedException {
        Element.selectElement(driver, cta_back_button_plans_page, "Navigate back to recharge page");
    }


    public void enterGasConnectionNo(String ConnectionNo) throws InterruptedException {
        Element.enterText(driver, textbox_enter_amount2, ConnectionNo, "Enter Connection No");
    }

//    public void enterAmount(String amount) throws InterruptedException {
//        Element.enterText(driver, textbox_enter_amount2, amount, "Enter Amount");
//    }

    public void clickOnContinue() throws InterruptedException {
        Element.selectElement(driver, button_continue, "Button Continue");
    }

    public void clickOnConfirmAmountPageCta() throws InterruptedException {
        Element.selectElement(driver, confirmButtonAmountPage, "Confirm Button amount Page");
    }

    public void clickOnCtaCotinue() throws InterruptedException {
        Element.waitForVisibility(driver,cta_continue);
        Element.selectElement(driver, cta_continue, "CTA Continue");
    }

    public void clickOnCtaContinue2() throws InterruptedException {
        Element.selectElement(driver, cta_continue2, "CTA Continue");
    }

    public void clickOnDthContinueCta() throws InterruptedException {
        Element.selectElement(driver, button_dth_continue, "CTA Continue");
    }

    public String getSuccessPageConnectionNo() throws InterruptedException {
        return Element.getText(driver, label_connection_no, "Success Screen | Verify Connection No");
    }

    public String getSuccessPageCategory() throws InterruptedException {
        return Element.getText(driver, label_category, "Success Screen | Verify Category");
    }

    public void clickGasFirstOperator() throws InterruptedException {
        Element.selectElement(driver, label_opertor_Gas, "Click on label Gas");
    }

    public String getSuccessPageOperator() throws InterruptedException {
        return Element.getText(driver, label_operator, "Success Screen | Verify Operator");
    }

    public String getSuccessPageAmount() throws InterruptedException {
        return Element.getText(driver, label_amount, "Success Screen | Verify Amount");
    }

    public String getSuccessPageTotalPayment() throws InterruptedException {
        return Element.getText(driver, label_total_payment, "Success Screen | Verify Total Payment Amount");
    }

    public String getSuccessPageStatus() throws InterruptedException {
        return Element.getText(driver, label_success_page_status, "Success Screen | Verify Status");
    }

    public String getElectricityBillPageStatus() throws InterruptedException {
        return Element.getText(driver, dropdown_electricityFirstOperator, "Success Screen | Verify Status");
    }

    public String dropdownGasFirstOperator() throws InterruptedException {
        return Element.getText(driver, dropdown_gasConnection, "Success Screen | Verify Status");
    }

    public String getPopupError() throws InterruptedException {
        return Element.getText(driver, popup_error, "Popup | Verify error");
    }

    public String getPopupText() throws InterruptedException {
        return Element.getText(driver, popup_text, "Popup | Verify text");
    }

    public void clickOnPopupCross() throws InterruptedException {
        Element.selectElement(driver, popup_cross, "Popup | Cross");
    }

    public String getViewBillText() throws InterruptedException {
        return Element.getText(driver, viewBillText, "View Bill | Verify text");
    }


    public RechargePage clickOnElectricityBackIcon() throws IOException {
        Element.selectElement(driver, back_electricity_icon, "CLick on Electricity BAck icon ");
        return new RechargePage(driver);
    }

    public void enterDthAmount(String amount) throws InterruptedException {
        Element.enterText(driver, textbox_enter_dth_amount, amount, "Enter Amount");
    }

    public String getPromoCodeTextOnSuccessScreen() throws InterruptedException {
        return Element.getText(driver, label_promo_code_text, "Success Screen | Verify promo text");
    }

    public String getBillPaymentText() throws InterruptedException {
        return Element.getText(driver, text_billpayment, "Bill payment Text on Preconfirmation Screen | Verify  text");
    }

    public String getSuccessScreenOperator() throws InterruptedException {
        return Element.getText(driver, label_success_screen_operator, "Success Screen | Verify Operator");
    }

    public String getElectricityBillreminderText() throws InterruptedException {
        return Element.getText(driver, text_reminder, "Success Screen | Verify Operator");
    }

    public String getSuccessScreenNumber() throws InterruptedException {
        return Element.getText(driver, label_success_screen_number, "Success Screen | Verify Number");
    }

    public String getSuccessScreenAmount() throws InterruptedException {
        return Element.getText(driver, label_success_screen_amount, "Success Screen | Verify Amount");
    }

    public String getPreSuccessScreenAmount() throws InterruptedException {
        return Element.getText(driver, id_amount, "Success Screen | Verify Amount");
    }


    public void enterBpNumber(String number) throws InterruptedException {
        Element.enterText(driver, textbox_bp_number, number, "Enter Number");
    }

    public void enterTelephoneNumber(String telephoneNo) throws InterruptedException {
        Element.enterText(driver, textbox_telephone_no, telephoneNo, "Enter Telephone Number");
    }


    public void enterCanNumber(String can) throws InterruptedException {
        Element.enterText(driver, textbox_can, can, "Enter can");
    }

    public void selectCreditCardFromSavedConnection() throws InterruptedException {
        Element.selectElement(driver, credit_card_from_saved_connection, "Select card ending from ICICI Bank");
    }

    public void enterCreditCardAmount(String amount) throws InterruptedException {
        Element.enterText(driver, textbox_enter_credit_card_amount, amount, "Enter Amount");
        Thread.sleep(400);
        Element.selectElement(driver,cta_submit_amount, "Submit Amount");
    }

    public void submitCreditCardAmount() throws InterruptedException {
        Element.selectElement(driver,cta_submit_amount, "Submit Amount");
    }

    public void clickOnCreditCardContinueCta() throws InterruptedException {
        Element.selectElement(driver, button_credit_card_continue, "CTA Continue");
    }

    public void clickGasContinueCta() throws InterruptedException {
        Element.selectElement(driver, continue_button, "Continue Continue");
    }
    public void selectWalletFlowWithConvFee() throws InterruptedException{
        Element.selectElement(driver, select_wallet_balance_flow, "Select Wallet Balance Flow with Conv fee");
    }

    public void selectWalletAsPgFlow() throws InterruptedException{
        Element.selectElement(driver, select_walletAsPG_balance_flow, "Select Wallet AS PG Flow");
    }

    public void clickOnWhyCta() throws InterruptedException{
        Element.selectElement(driver, cta_why, "Select Why option");
    }

    public void clickOnOK() throws InterruptedException{
        Element.selectElement(driver, cta_ok, "Select OK Cta");
    }

    public String getFeesAmount() throws InterruptedException{
        return Element.getText(driver, get_fees, "Get Fees Amount").replace("X", "").replace(" Conv. fees", "");

    }

    public Boolean isWhyPageOpened() throws InterruptedException{
        return Element.isElementPresent(driver, By.id("processing_fee_title"));
    }


    public String getSuccessScreenTitle() throws InterruptedException {
        return Element.getText(driver, pending_screen_title, "Succes Screen Tile");
    }

    public String getTotalAmountValue() throws InterruptedException {
        return Element.getText(driver, total_amount_value, "Total Amount Value");
    }

    public String getPendingDescMessage() throws InterruptedException {
        return Element.getText(driver, pending_desc_message, "Pending description Message");
    }

    public void backToHomeFromPendingScreen() throws InterruptedException {
        Element.selectElement(driver, cross_icon_pending_screen, "Navigate Back Tome home");
    }

//    public void clickApplyCoupon() throws InterruptedException {
//        Element.selectElement(driver, have_promo_code, "Select Apply a coupon");
//    }

    public void selectVoucher() throws InterruptedException {
        Element.selectElement(driver, select_voucher, "Apply a voucher");
    }

    public void selectCrossIcon() throws InterruptedException {
        Element.selectElement(driver, select_cross_icon, "Dismiss pop up");
    }

    //############################ Old end ################################

}
