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

import java.util.ArrayList;

public class CheckoutPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Net Banking']")
    private AndroidElement selectNBOnCheckoutScreen;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'IMPS/NEFT/RTGS']")
    private AndroidElement selectIMPSOnCheckoutScreen;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Restore your UPI account']")
    private AndroidElement checkoutUpiMode;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Kotak Bank']")
    private AndroidElement kotakBankCta;


    @AndroidFindBy(id = "bottom_sheet_text")
    private AndroidElement bank_page;

    @AndroidFindBy(id = "mkab_title")
    private AndroidElement bank_Web_Page;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement back_btn_netbanking_web_page;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Cancel transaction?']")
    private AndroidElement cancel_transaction_popup;

    @AndroidFindBy(id="horizontal_button_2")
    private AndroidElement yes_cancel_transaction_cta;

    @AndroidFindBy(id = "tvViewMore")
    private AndroidElement View_bank_ac_details_cta;

    @AndroidFindBy(xpath = "//*[@text='Account Number']/following-sibling::android.widget.TextView")
    private AndroidElement account_number;

    @AndroidFindBy(xpath = "//*[@text='IFSC Number']/following-sibling::android.widget.TextView")
    private AndroidElement ifsc_number;

    @AndroidFindBy(xpath = "//*[@text='Account Holder Name']/following-sibling::android.widget.TextView")
    private AndroidElement account_holder_name;

    @AndroidFindBy(xpath = "//*[@text='Bank Name']/following-sibling::android.widget.TextView")
    private AndroidElement bank_name;

    @AndroidFindBy(xpath = "//*[@text='Account Type']/following-sibling::android.widget.TextView")
    private AndroidElement account_type;

    @AndroidFindBy(id = "mkab_left_icon")
    private AndroidElement back_button_Bank_details_page;

    @AndroidFindBy(id="header_layout")
    private AndroidElement checkout_Page_header;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='RECOMMENDED METHODS']")
    private AndroidElement recommanded_bottomsheet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pay Later']")
    private AndroidElement zip_module;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pay Later']/following-sibling::android.widget.ImageView")
//    private AndroidElement zip_module_checkBox;

    @AndroidFindBy(id="fee")
    private AndroidElement conv_fee;

    @AndroidFindBy(id="text_conv_fee")
    private AndroidElement conv_fee_breakup;

    @AndroidFindBy(id="text_payable_amount")
    private AndroidElement payable_amount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='More payment options']")
    private AndroidElement more_payment_options_cta;

    @AndroidFindBy(id="restore_widget")
    private AndroidElement upi_restore_widget;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DEBIT CARDS']")
    private AndroidElement debit_cards;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CREDIT CARDS']")
    private AndroidElement credit_cards;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='UPI Apps']")
    private AndroidElement upi_intent_option;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Net Banking']")
    private AndroidElement netbanking_option;
















    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectNBOnCheckoutScreen() throws InterruptedException {
        Element.waitForVisibility(driver,selectNBOnCheckoutScreen);
        Element.selectElement(driver, selectNBOnCheckoutScreen, "Select NetBanking From Checkout Screen");
    }

    public void selectIMPSOnCheckoutScreen() throws InterruptedException {
        Element.waitForVisibility(driver,selectIMPSOnCheckoutScreen);
        Element.selectElement(driver, selectIMPSOnCheckoutScreen, "Select IMPS From Checkout Screen");
    }

    public Boolean isUpiModeVisible() throws InterruptedException {
        Element.waitForVisibility(driver,selectIMPSOnCheckoutScreen);
        return Elements.isElementPresent(driver, checkoutUpiMode);
    }



    public void selectKotakBankFromBAnkList() throws InterruptedException {
        Element.selectElement(driver, kotakBankCta, "Select Kotak Bank From Netbanking Bank List");
    }

    public String getBankPageTitleNetbanking() throws InterruptedException {
        return Elements.getText(driver, bank_page, "Heading on Bank Page");
    }

    public String getBankPageTitleWeb() throws InterruptedException {
        Element.waitForVisibility(driver, bank_Web_Page);
        return Elements.getText(driver, bank_Web_Page, "Heading on Bank Page");
    }

    public void selectBackBtn() throws InterruptedException {
        Elements.selectElement(driver, back_btn_netbanking_web_page, "Click on Back Button");
    }

    public Boolean isCancelTransactionPopUpShown() throws InterruptedException {
        return Elements.isElementPresent(driver, cancel_transaction_popup);
    }

    public void yesCancelTransaction() throws InterruptedException {
        Elements.selectElement(driver, yes_cancel_transaction_cta, "Click on Yes Cancel Transaction");
    }

    public Boolean isImpsPageOpened() throws InterruptedException {
        return Elements.isElementPresent(driver, View_bank_ac_details_cta);
    }

    public void clickViewBankAccountDetails() throws InterruptedException {
        Element.waitForVisibility(driver,View_bank_ac_details_cta );
         Elements.selectElement(driver, View_bank_ac_details_cta, "Select View bank a/c details");
    }


    public String getBankDetailsAccountNumber() throws InterruptedException{
        return Elements.getText(driver, account_number, "Account Number").trim();
    }

    public String getBankDetailsIFSCNumber() throws InterruptedException{
        return Elements.getText(driver, ifsc_number, "IFSC Number").trim();
    }

    public String getBankDetailsAccountHolderName() throws InterruptedException{
        return Elements.getText(driver, account_holder_name, "Account Holder Name").trim();
    }

    public String getBankDetailsBankName() throws InterruptedException{
        return Elements.getText(driver, bank_name, "Bank Name").trim();
    }

    public String getBankDetailsAccountType() throws InterruptedException{
        return Elements.getText(driver, account_type, "Account Type").trim();
    }

    public void goBackFromBankDetailsPage() throws InterruptedException{
        Elements.selectElement(driver,back_button_Bank_details_page,"Go Back to checkout ");
    }

    public Boolean isCheckoutPageOpened() throws InterruptedException {
        return Elements.isElementPresent(driver, checkout_Page_header);
    }

    public Boolean isRecommendedSheetOpened() throws InterruptedException{
        return Elements.isElementPresent(driver, recommanded_bottomsheet);
    }

    public Boolean isZipModuleAvailable() throws InterruptedException{
        return Elements.isElementPresent(driver, zip_module);
    }

    public void selectZipModule() throws InterruptedException{
         Elements.selectElement(driver, zip_module, "Selecting Zip Module");
    }

//    public Boolean isZIpModuleSelected() throws InterruptedException{
//        return Elements.isElementEnabled(driver, zip_module_checkBox);
//    }

    public Integer getConvFee() throws InterruptedException{
        String convFee= Elements.getText(driver, conv_fee, "Extracting Conv Fee").replace(" Conv. fees", "").replace("₹", "");
        return Integer.parseInt(convFee);
    }

    public Integer getConvFeeInBreakup() throws InterruptedException{
        String convFee= Elements.getText(driver, conv_fee_breakup, "Extracting Conv Fee in Breakup Module").replace(",", "").replace("₹", "");
        return Integer.parseInt(convFee);
    }

    public Integer getPayableAmountBreakup() throws InterruptedException{
        String payableAmount= Elements.getText(driver, payable_amount, "Extracting Payable Amount in Breakup Module").replace(",", "").replace("₹", "");
        return Integer.parseInt(payableAmount);
    }

    public void clickMorePaymentOptionsCta() throws InterruptedException{
        Elements.selectElement(driver,more_payment_options_cta,"Click on More Payment options Cta");
    }

    public Boolean isUPIRestoreModuleAvailable() throws InterruptedException{
        return Elements.isElementPresent(driver, upi_restore_widget);
    }

    public Boolean areMultipleDebitCardsAvailable() throws InterruptedException{
        return Elements.isElementPresent(driver, debit_cards);
    }

    public Boolean areMultipleCreditCardsAvailable() throws InterruptedException{
        return Elements.isElementPresent(driver, credit_cards);
    }


    public Boolean isUpiIntentoptionAvailable() throws InterruptedException{
        return Elements.isElementPresent(driver, upi_intent_option);
    }

    public Boolean isNetbankingOptionAvailable() throws InterruptedException{
        return Elements.isElementPresent(driver, netbanking_option);
    }











}
