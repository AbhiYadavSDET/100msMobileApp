package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class RechargePage {

    AndroidDriver driver;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Please Enter Name or Mobile No.']")
    private AndroidElement textbox_mobile_no;

    @AndroidFindBy(id = "contact_number")
    private AndroidElement numberSelecter;

    //Pallavi Xpath
    @AndroidFindBy(id = "toggle_button")
    private AndroidElement prepaidPostpaid_toggle;

    @AndroidFindBy(id = "horizontal_button_2")
    private AndroidElement rightYes_Cta;

    @AndroidFindBy(id = "horizontal_button_2")
    private AndroidElement popupbutton_yes;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enterText_click;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Adani Electricity Mumbai Limited']")
    private AndroidElement dropdown_electricityFirstOperator;

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

    @AndroidFindBy(id = "operator")
    private AndroidElement label_operator;

    @AndroidFindBy(id = "amount")
    private AndroidElement label_amount;

    @AndroidFindBy(id = "total_amount_value")
    private AndroidElement label_total_payment;

    @AndroidFindBy(id = "base_title")
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


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'z']/following::android.widget.EditText[1]")
    public AndroidElement textbox_enter_credit_card_amount;

    @AndroidFindBy(id = "connection_detail_button_recharge")
    public AndroidElement button_credit_card_continue;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Confirm Payment']")
    public AndroidElement confirm_payment_title;


    @AndroidFindBy(id = "base_title")
    public AndroidElement pending_screen_title;

    @AndroidFindBy(id = "pending_desc")
    public AndroidElement pending_desc_message;

    @AndroidFindBy(id = "total_amount_value")
    public AndroidElement total_amount_value;

    @AndroidFindBy(id = "base_icon_close")
    public AndroidElement cross_icon_pending_screen;

    @AndroidFindBy(id= "cross_icon")
    public AndroidElement select_cross_icon;

//cta_continue


    //Coupon and voucher
    @AndroidFindBy(id = "have_a_promo_text")
    private AndroidElement have_promo_code;

    @AndroidFindBy(id = "redeem_layout")
    private AndroidElement select_voucher;


    public RechargePage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Recharge Page*****");
    }


    // New

    public void enterMobileNo(String cell) throws InterruptedException {
        Element.enterText(driver, textbox_mobile_no, cell, "Mobile No");
        Element.selectElement(driver, numberSelecter, "select number from List");
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

    public void selectOperator(String operator) throws InterruptedException {
        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text = '" + operator + "']"));
        AndroidElement androidElement = new Element(driver).findElement(driver, By.xpath("//android.widget.TextView[@text = '" + operator + "']"));
        Element.selectElement(driver, androidElement, "Operator");
    }

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

    public void enterAmount(String amount) throws InterruptedException {
        Element.enterText(driver, textbox_enter_amount2, amount, "Enter Amount");
    }

    public void clickOnContinue() throws InterruptedException {
        Element.selectElement(driver, button_continue, "Button Continue");
    }

    public void clickOnConfirmAmountPageCta() throws InterruptedException {
        Element.selectElement(driver, confirmButtonAmountPage, "Confirm Button amount Page");
    }

    public void clickOnCtaCotinue() throws InterruptedException {
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
    }

    public void clickOnCreditCardContinueCta() throws InterruptedException {
        Element.selectElement(driver, button_credit_card_continue, "CTA Continue");
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

    public void clickApplyCoupon() throws InterruptedException {
        Element.selectElement(driver, have_promo_code, "Select Apply a coupon");
    }

    public void selectVoucher() throws InterruptedException {
        Element.selectElement(driver, select_voucher, "Apply a voucher");
    }

    public void selectCrossIcon() throws InterruptedException{
        Element.selectElement(driver, select_cross_icon, "Dismiss pop up");
    }


}
