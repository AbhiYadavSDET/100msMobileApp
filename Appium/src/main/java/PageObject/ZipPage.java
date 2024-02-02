package PageObject;

import Utils.Element;
import Utils.Elements;
import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ZipPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PayLater']")
    private AndroidElement zipButton;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta;

    @AndroidFindBy(id = "button_accept")
    private AndroidElement buttonAllow;

    @AndroidFindBy(id = "button_skip")
    private AndroidElement buttonNotNow;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement permissionAllowLocation;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permissionAllowContacts;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permissionAllowMessages;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement title;

    @AndroidFindBy(id = "tv_label")
    private AndroidElement label;

    @AndroidFindBy(id="balance")
    private AndroidElement available_balance;

    @AndroidFindBy(id="amount_used")
    private AndroidElement amount_used;

    @AndroidFindBy(id="amount_total")
    private AndroidElement amount_total;

    @AndroidFindBy(id="tv_credit_value")
    private AndroidElement credit_value;

    @AndroidFindBy(id="tv_cta")
    private AndroidElement view_report_cta;

    @AndroidFindBy(id="mkab_icon_1")
    private AndroidElement navigate_back;

    public String txn_history_date="date";

    public String offer_brand_name="brand_name";

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manage now']")
    private AndroidElement manage_now_cta;

    @AndroidFindBy(id="fab_add_connection")
    private AndroidElement add_biller_cta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile']")
    private AndroidElement mobile_category_icon;

    @AndroidFindBy(id="switch_auto_pay")
    private AndroidElement zip_auto_pay_toggle;

    @AndroidFindBy(id="continue_button")
    private AndroidElement save_connection_cta;

    @AndroidFindBy(id = "et_search")
    private AndroidElement search;

    @AndroidFindBy(id = "operator_layout")
    private AndroidElement selectAvailableResult;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement mobileNumberEditText;




    public ZipPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickZipIcon() {
        Elements.selectElement(driver, zipButton, "Zip Icon");
    }

    public void clickCtaActivate() {
        Elements.selectElement(driver, cta, "Cta Activate");
    }

    public void clickNotNow() {
        Elements.selectElement(driver, buttonNotNow, "Not Now");
    }

    public boolean isClickAllowPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, buttonAllow);
    }

    public void clickAllow() {
        Elements.selectElement(driver, buttonAllow, "Allow");
    }

    public boolean isPermissionLocationPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionAllowLocation);
    }

    public boolean isPermissionContactsPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionAllowContacts);
    }

    public boolean isPermissionMessagePresent() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionAllowMessages);
    }

    public void allowPermissionLocation() {
        Elements.selectElement(driver, permissionAllowLocation, "Permission Location");
    }

    public void allowPermissionContacts() {
        Elements.selectElement(driver, permissionAllowContacts, "Permission Contacts");
    }

    public void allowPermissionMessage() {
        Elements.selectElement(driver, permissionAllowMessages, "Permission Message");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Title");
    }

    public String getLabel() throws InterruptedException {
        return Elements.getText(driver, label, "Label");
    }

    public String getAvailableBalance() throws InterruptedException {
        return Elements.getText(driver, available_balance).replace("Available Balance : ₹", "").replace(",","");
    }

    public String getAmountUsed() throws InterruptedException {
        return Elements.getText(driver, amount_used).replace("₹", "").replace(",","");
    }

    public String getAmountTotal() throws InterruptedException {
        return Elements.getText(driver, amount_total).replace("₹", "").replace(",","");
    }

    public String fetchCreditValue() throws InterruptedException {
        return Elements.getText(driver, credit_value);
    }

    public void selectViewReport() throws InterruptedException{
        Elements.selectElement(driver, view_report_cta, "Click on View Report cta for Credit Score");
    }

    public void navigateBack() throws InterruptedException{
        Elements.selectElement(driver, navigate_back, "Navigating Back");
    }

    public int getHistoryCount() throws InterruptedException{
        return Element.findElements(driver, By.id(txn_history_date)).size();

    }

    public int getOfferCount() throws InterruptedException{
        return Element.findElements(driver, By.id(offer_brand_name)).size();

    }

    public void clickOnManageNowCta() throws InterruptedException{
        Elements.selectElement(driver, manage_now_cta, "Click on Manage Now Cta");
    }

    public void clickOnAddBillerCta() throws InterruptedException{
        Elements.selectElement(driver, add_biller_cta, "Click on Add Biller Cta");
    }

    public void selectMobileIcon() throws InterruptedException{
        Elements.selectElement(driver, mobile_category_icon, "Click on Electricity");
    }

    public void clickOnAutopayToggle() throws InterruptedException{
        Elements.selectElement(driver, zip_auto_pay_toggle, "Click on Autopay Toggle");
    }

    public void clickOnSaveConnectionCta() throws InterruptedException{
        Elements.selectElement(driver, save_connection_cta, "Click on Save Connection Cta");
    }

    public void clickSearchBrand(){
        Elements.selectElement(driver, search, "Click Search Brand");
    }

    public void clickSearchCity(){
        Elements.selectElement(driver, search, "Click Search City");
    }

    public void enterSearchCriteria(String data) throws InterruptedException {
        Elements.enterToElement(driver, search, data,"Enter Search Criteria");
    }

    public void clickSelectResult(){
        Elements.selectElement(driver, selectAvailableResult, "Click on Available Result");
    }

    public void clickMobileNumber(){
        Elements.selectElement(driver, mobileNumberEditText, "Click on Mobile number Field");
    }

    public void enterMobileNumber(String number) throws InterruptedException {
        Elements.enterToElement(driver, mobileNumberEditText, number, "Enter Mobile number");
    }





}
