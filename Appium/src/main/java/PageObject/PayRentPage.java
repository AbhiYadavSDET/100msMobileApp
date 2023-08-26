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

    @AndroidFindBy(id = "edit_text")
    private AndroidElement payRentAmount;

    @AndroidFindBy(id = "btn_submit")
    private AndroidElement cnButton;

    @AndroidFindBy(id = "cta")
    private AndroidElement ctaButton;

    @AndroidFindBy(id = "title")
    private AndroidElement title;

    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement heading1;

    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[2]/android.widget.TextView")
    private AndroidElement heading2;

    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[3]/android.widget.TextView")
    private AndroidElement heading3;

    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[4]/android.widget.TextView")
    private AndroidElement heading4;

    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[5]/android.widget.TextView")
    private AndroidElement heading5;

    @AndroidFindBy(id = "benefits_recycler_view")
    private AndroidElement subHeadings;




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

    public void enterPayRentAmount() throws InterruptedException{
         Elements.selectElement(driver, payRentAmount, "Enter pay Rent Amount");
    }

    public void clickCnButton() throws InterruptedException{
        Elements.selectElement(driver, cnButton, "Click Continue button");
    }

    public void clickCtaButton() throws InterruptedException{
        Elements.selectElement(driver, ctaButton, "click Continue button");
    }

    public String getTitle() throws InterruptedException{
        return Elements.getText(driver, title, "Get Title of Pay rent description screen");
    }

    public String getHeading1() throws InterruptedException{
        return Elements.getText(driver, heading1, "Get Title of heading1 of Pay rent description screen");
    }
    public String getHeading2() throws InterruptedException{
        return Elements.getText(driver, heading2, "Get Title of heading2 of Pay rent description screen");
    }
    public String getHeading3() throws InterruptedException{
        return Elements.getText(driver, heading3, "Get Title of heading3 of Pay rent description screen");
    }
    public String getHeading4() throws InterruptedException{
        return Elements.getText(driver, heading4, "Get Title of heading4 of Pay rent description screen");
    }
    public String getHeading5() throws InterruptedException{
        return Elements.getText(driver, heading5, "Get Title of heading5 of Pay rent description screen");
    }

    public String getSubHeading() throws InterruptedException{
        return Elements.getText(driver, subHeadings, "Get Sub heading of PayRent description Screen");
    }

}

