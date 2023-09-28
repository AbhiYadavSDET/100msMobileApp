package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;


public class PayRentPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Pay Rent']")
    private AndroidElement payRent;

    @AndroidFindBy(id = "btnSubmit")
    private AndroidElement addNewPropertyButton;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Account Number']")
    private AndroidElement accountNumber;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'IFSC Code']")
    private AndroidElement ifscCode;

    @AndroidFindBy(id = "continue_btn")
    private AndroidElement continueButton;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Landlord Name']")
    private AndroidElement landlordName;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Enter Rent Amount']")
    private AndroidElement rentAmount;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'CVV']")
    private AndroidElement cvv_text_box;

    @AndroidFindBy(id = "landlord_name")
    private AndroidElement name;

    @AndroidFindBy(id = "account_number")
    private AndroidElement number;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private AndroidElement rentRecipient;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = 'Continue with Zip/Cards']")
    private AndroidElement continueWithZipNCards;

    @AndroidFindBy(id = "text_total_amount")
    private AndroidElement totalAmount;

    @AndroidFindBy(id = "text_conv_fee")
    private AndroidElement convFee;

    @AndroidFindBy(id = "text_payable_amount")
    private AndroidElement payableAmount;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'More payment options']")
    private AndroidElement morePaymentOptions;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Add New Debit / Credit card']")
    private AndroidElement addNewDebitCard;

    @AndroidFindBy(id = "upi_button")
    private AndroidElement useUpi;

    @AndroidFindBy(id = "transfer_to")
    private AndroidElement transferToName;

    @AndroidFindBy(id = "btn_pin_5")
    private AndroidElement fiveButton;

    @AndroidFindBy(id = "btn_pin_0")
    private AndroidElement zeroButton;

    @AndroidFindBy(id = "btn_submit")
    private AndroidElement cnButton;

    @AndroidFindBy(id = "cta")
    private AndroidElement ctaButton;

    @AndroidFindBy(id = "title")
    private AndroidElement benefitScreenTitle;

    @AndroidFindBy(id = "ic_text")
    private AndroidElement faqButton;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement faqScreen;

    @AndroidFindBy(id = "menu_button")
    private AndroidElement menuButton;

    @AndroidFindBy(id = "delete")
    private AndroidElement deleteRentDetails;

    @AndroidFindBy(id = "bank_name")
    private AndroidElement bank_name;

    @AndroidFindBy(id = "btn_check_out_pay")
    private AndroidElement pay_button;

    @AndroidFindBy(id = "btn_add_money")
    private AndroidElement pay_button_bottomSheet;


    public PayRentPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        /*
        To Do
        wait for Page load to be added
         */
        Log.info("*****PayRent Page*****");
    }

    public void clickPayRent() {
        Elements.selectElement(driver, payRent, "Click on Pay Rent");
    }

    public void clickAddNewPropertyButton() {
        Elements.selectElement(driver, addNewPropertyButton, "Click on Add New Property");
    }

    public void enterAccountNumber(String AccountNumber){
        Elements.enterToElement(driver, accountNumber, AccountNumber, "Enter Account Number");
    }

    public void enterIfscCode(String IfscCode){
        Elements.enterToElement(driver, ifscCode, IfscCode, "Enter IFSC Code");
    }

    public void clickContinueButton() {
        Elements.selectElement(driver, continueButton, "Click on continue button");
    }

    public void enterLandlordName(String Name ){
        Elements.enterToElement(driver, landlordName, Name, "Enter Landlord Name");
    }

    public void enterRentAmount(String Amount){
        Elements.enterToElement(driver, rentAmount,Amount, "Enter Rent Amount");
    }

    public void enterCVV(String cvv){
        Elements.enterToElement(driver, cvv_text_box, cvv, "Enter CVV");
    }

    public String getLandlordName()throws InterruptedException{
        return Elements.getText(driver, name, "Get Landlord name");
    }

    public String getAccountNumber()throws InterruptedException{
        return Elements.getText(driver, number, "Get Account number");
    }

    public void clickRentRecipient(){
        Elements.selectElement(driver, rentRecipient, "Click on saved rent recipient");
    }

    public void clickContinueWithZipAndCards(){
        Elements.selectElement(driver, continueWithZipNCards, "Click on continue with zip/cards button");
    }

    public String getTotalAmount() throws InterruptedException{
        return Elements.getText(driver, totalAmount, "Get Total Amount on Bottom sheet");
    }

    public String getConvFee() throws InterruptedException{
        return Elements.getText(driver, convFee, "Get convenience fee on Bottom sheet");
    }

    public String getPayableAmount() throws InterruptedException{
        return Elements.getText(driver, payableAmount, "Get Payable Amount on Bottom sheet");
    }

    public void clickMorePaymentOptions(){
        Elements.selectElement(driver, morePaymentOptions, "Click on more payment options");
    }

    public void clickAddNewDebitCard(){
        Elements.selectElement(driver, addNewDebitCard, "Click on Add new debit card");
    }

    public void clickUseUpi(){
        Elements.selectElement(driver, useUpi, "Click on Use UPI button");
    }

    public String getTransaferToName() throws InterruptedException{
       return Elements.getText(driver, transferToName, "Get Name of the recipient");
    }

    public void clickFive(){
        Elements.selectElement(driver, fiveButton, "Click on five");
    }

    public void clickZero(){
        Elements.selectElement(driver, zeroButton, "Click on zero");
    }

    public void clickCnButton() throws InterruptedException{
        Elements.selectElement(driver, cnButton, "Click Continue button");
    }

    public void clickCtaButton() throws InterruptedException{
        Elements.selectElement(driver, ctaButton, "click Continue button");
    }

    public boolean checkBenefitScreen() throws InterruptedException {
        return Elements.isElementPresent(driver, benefitScreenTitle);
    }

    public String getTitle() throws InterruptedException{
        return Elements.getText(driver, benefitScreenTitle, "Get Title of Pay rent description screen");
    }

    public void clickFaqButton() { Elements.selectElement(driver, faqButton , "Click on FAQ Button"); }

    public String getFaqScreenTitle() throws InterruptedException { return Elements.getText(driver, faqScreen , "Get Title of FAQ Screen"); }

    public void clickMenuButton() {Elements.selectElement(driver, menuButton, "Click on Menu button");}

    public void clickDeleteRentDetails() {Elements.selectElement(driver, deleteRentDetails, "Click on delete rent details");}

    public void clickOnBank() throws InterruptedException{
        Elements.selectElement(driver, bank_name, "Click Bank Name");
    }

    public void clickOnPayButton() throws InterruptedException{
        Elements.selectElement(driver, pay_button, "Click Pay Button");
    }

    public void clickOnPayButtonOnCVVScreen() throws InterruptedException{
        Elements.selectElement(driver, pay_button_bottomSheet, "Click Pay Button");
    }

}

