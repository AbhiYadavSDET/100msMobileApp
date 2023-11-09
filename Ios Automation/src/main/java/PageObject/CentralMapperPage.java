package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CentralMapperPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'UPI Transfer']")
    private AndroidElement upi_transfer;

    @AndroidFindBy(id = "search_upi")
    private AndroidElement search_upi;

    @AndroidFindBy(id = "send_money")
    private AndroidElement send_money;

    @AndroidFindBy(id = "transfer_to")
    private AndroidElement transfer_name;

    @AndroidFindBy(id = "transfer_desc")
    private AndroidElement transfer_vpa;

    @AndroidFindBy(id = "merchant_code")
    private AndroidElement tap_search_upi;

    @AndroidFindBy(id = "manage")
    private AndroidElement manage;

    @AndroidFindBy(id = "ic_menu")
    private AndroidElement three_dots;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Manage UPI Numbers']")
    private AndroidElement manage_upi_numbers;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Activate']")
    private AndroidElement activate;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Deactivate']")
    private AndroidElement deactivate;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Deregister']")
    private AndroidElement deregister;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = 'Deactivate']")
    private AndroidElement deactivateOnBottomSheet;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = 'Deregister']")
    private AndroidElement deregisterOnBottomSheet;

    @AndroidFindBy(id = "primary_button")
    private AndroidElement primary_button;

    @AndroidFindBy(id = "fab_add_number")
    private AndroidElement add_new_number;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement number_text_box;

    @AndroidFindBy(id = "btn_check_availablity")
    private AndroidElement btn_check_availablity;


    public CentralMapperPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnUpiTransfer() {
        Elements.selectElement(driver, upi_transfer, "Click On UPI Transfer");
    }

    public void clickOnSendMoney() {
        Elements.selectElement(driver, send_money, "Click On Send Money");
    }

    public void tapOnSearchUpiId() { Elements.selectElement(driver, tap_search_upi, "tap On Search Upi Id"); }

    public void clickOnManage() {
        Elements.selectElement(driver, manage, "Click On Manage");
    }

    public void clickOnThreeDots() {
        Elements.selectElement(driver, three_dots, "Click On Three Dots");
    }

    public void clickOnManageUpiNumbers() { Elements.selectElement(driver, manage_upi_numbers, "Click On Manage Upi Numbers"); }

    public void clickOnActivate() {
        Elements.selectElement(driver, activate, "Click On Activate");
    }

    public void clickOnDeactivate() {
        Elements.selectElement(driver, deactivate, "Click On Deactivate");
    }

    public void clickOnDeregister() {
        Elements.selectElement(driver, deregister, "Click On Deregister");
    }

    public void clickOnAddNewNumber() {
        Elements.selectElement(driver, add_new_number, "Click On Add New Number");
    }

    public void clickOnCheckAvailablity() { Elements.selectElement(driver, btn_check_availablity, "Click On Check Availablity"); }

    public void clickDeactivateOnBottomSheet() {
        Elements.selectElement(driver, deactivateOnBottomSheet, "Click On Deactivate");
    }

    public void clickDeregisterOnBottomSheet() {
        Elements.selectElement(driver, deregisterOnBottomSheet, "Click On Deregister");
    }

    public String getName() throws InterruptedException {
        return Elements.getText(driver, transfer_name, "Get Name");
    }

    public String getVpa() throws InterruptedException {
        return Elements.getText(driver, transfer_vpa, "Get VPA");
    }

    public void enterMappedNumber(String mappedNumber) {
        Elements.enterToElement(driver, search_upi, mappedNumber, "Enter Mapped Number");
    }

    public void enterNumberInTextBox(String number) {
        Elements.enterToElement(driver, number_text_box, number, "Enter Number in TextBox");
    }

    public boolean isActivateButtonPresent() throws InterruptedException{
        return Elements.isElementPresent(driver, activate);
    }

    public boolean isDeactivateButtonPresent() throws InterruptedException{
        return Elements.isElementPresent(driver, deactivate);
    }

    public boolean isDeregisterButtonPresent() throws InterruptedException{
        return Elements.isElementPresent(driver, deregister);
    }


}
