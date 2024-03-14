package PageObject;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import Utils.Element;
import Utils.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpiPage {

    AndroidDriver driver;



    @AndroidFindBy(id = "search_upi")
    private AndroidElement cta_enter_upi_id;

    @AndroidFindBy(id = "search_upi")
    private AndroidElement enter_upi_id_or_number;

    @AndroidFindBy(id = "send_money")
    private AndroidElement result_upi_id;

    @AndroidFindBy(id="transfer_to")
    private AndroidElement transfer_to;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enter_amount;

    @AndroidFindBy(id = "messageEditText")
    private AndroidElement enter_message;


    @AndroidFindBy(id = "setup_message")
    private AndroidElement setup_message;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta_confirm_payment;


    @AndroidFindBy(id = "status")
    private AndroidElement payment_succes_message;


    @AndroidFindBy(id = "amount")
    private AndroidElement amount_paid;

    @AndroidFindBy(id = "name")
    private AndroidElement receiver_name;

    @AndroidFindBy(id = "transfer_bank_account")
    private AndroidElement radio_button_to_bank_account;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private AndroidElement enter_beneficiary_name;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private AndroidElement enter_account_number;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    private AndroidElement enter_ifsc;

    @AndroidFindBy(id = "continue_button")
    private AndroidElement cta_confirm_bank_details;

    @AndroidFindBy(id = "back_icon")
    private AndroidElement click_on_cross;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Additional verification required']")
    private AndroidElement TwoFA_page_displayed;

    @AndroidFindBy(id="continue_button")
    private AndroidElement TwoFA_page_cta;

    @AndroidFindBy(id = "continue_button")
    private AndroidElement cta_start_upi_setup;

    @AndroidFindBy(id="qr_image")
    private AndroidElement qr_image;

    @AndroidFindBy(id="upi_id_view")
    private AndroidElement qr_bottomsheet_upi_id;

    @AndroidFindBy(id="upi_id")
    private AndroidElement manage_section_upi_id;

    @AndroidFindBy(id="upi_number")
    private AndroidElement manage_section_upi_number;

    @AndroidFindBy(id="continue_btn")
    private AndroidElement continue_cta_contact1;

    @AndroidFindBy(id="continue_button")
    private AndroidElement continue_cta_contact2;

    @AndroidFindBy(id="contact_name")
    private AndroidElement contact_name;

    @AndroidFindBy(id="logo")
    private AndroidElement vpa1;

    @AndroidFindBy(id="manage")
    private AndroidElement manage_cta;

    @AndroidFindBy(id="link_account_btn")
    private AndroidElement link_account_cta;




    @AndroidFindBy(id="txtHowToUseUpi")
    private AndroidElement how_to_use_upi_cta;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='English']")
    private AndroidElement select_language;

    @AndroidFindBy(id="com.android.chrome:id/title_url_container")
    private AndroidElement isWebsiteOpened;


    @AndroidFindBy(id="bank_name")
    private AndroidElement primary_bank_account;

    @AndroidFindBy(id="primary_tag")
    private AndroidElement primary_tag;

    @AndroidFindBy(id="manage_upi_subscriptions_view")
    private AndroidElement manage_upi_autopay;

    @AndroidFindBy(id="tv_title")
    private AndroidElement page_title;

    @AndroidFindBy(id="mkab_icon_1")
    private AndroidElement back_button;











////////////////////////////////Pocket UPI

    @AndroidFindBy(id = "pocket_upi_title")
    private AndroidElement pocketUpi_bottomsheet;

    @AndroidFindBy(id = "title")
    private AndroidElement pocketUpi_bottomsheet_title;
    @AndroidFindBy(id = "desc")
    private AndroidElement pocketUpi_bottomsheet_description;

    @AndroidFindBy(id = "cta")
    private AndroidElement pocketUpi_bottomsheet_continue_cta;

    @AndroidFindBy(id="pocket_upi_header")
    private AndroidElement pocketUpi_homePage_header;

    //Pocket UPI ID: 9205299330@mbk
    @AndroidFindBy(id="pocket_upi_id")
    private AndroidElement pocket_upi_id;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Transfer Now']")
    private AndroidElement pocketUpi_homePage_transferNow_cta;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Scan any QR code']")
    private AndroidElement pocketUpi_homePage_scanAnyQR_cta;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Show my QR code']")
    private AndroidElement pocketUpi_homePage_showMyQr_cta;

    //should be "Pocket UPI"
    @AndroidFindBy(id = "selected_bank_account")
    private AndroidElement pre_selected_bank_account;

    //should be equal to "Pocket UPI"
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Payment Mode']/following-sibling::android.widget.TextView")
    private AndroidElement success_page_validation_payment_mode;





















////////////////////////////////



    @AndroidFindBy(id = "header_text")
    private AndroidElement text_header_upi_setup;




    @AndroidFindBy(id = "send_money_title")
    private AndroidElement cta_send_money;
    @AndroidFindBy(id = "confirm_button")
    private AndroidElement cta_confirm_upi;

    @AndroidFindBy(id = "view_transaction_limit")
    private AndroidElement get_transaction_limit;

    @AndroidFindBy(id = "touch_outside")
    private AndroidElement click_outside;

    //Request Money Flow
    @AndroidFindBy(id = "request_money_title")
    private AndroidElement cta_request_money;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta_confirm_request;


    //Check Balance Flow


    //Setup UPI

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement enter_bank_name;

    @AndroidFindBy(id = "bank_name")
    private AndroidElement select_bank_from_list;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Select the phone number linked with your Kotak Mahindra Bank Account. An SMS will be triggered from the number to verify your bank account.']")
    private AndroidElement sim_select_view;

    @AndroidFindBy(id = "sim1_button")
    private AndroidElement select_sim_1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Create New VPA']")
    private AndroidElement header_create_vpa;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement enter_vpa;

    @AndroidFindBy(id = "submit_button")
    private AndroidElement submit_vpa;

    @AndroidFindBy(id = "upi_id_text")
    private AndroidElement get_upi_id;

    @AndroidFindBy(id = "back_to_home")
    private AndroidElement upi_setup_success_back_to_home_cta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Restore your UPI account']")
    private AndroidElement restore_upi_widget_checkout;

    @AndroidFindBy(id="masked_account_number")
    private AndroidElement checkout_upi_account;






    public UpiPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****UPI Page*****");
    }


    public void selectEnterUPI() throws InterruptedException {
        Element.selectElement(driver, cta_enter_upi_id, "Click on Enter UPI ID");
    }

    public void enterUpiId(String upiId) throws InterruptedException {
        Element.enterText(driver, enter_upi_id_or_number, upiId, "Enter UPI ID");
    }

    public void selectResultUpi() throws InterruptedException {
        Element.waitForVisibility(driver, result_upi_id);
         Element.selectElement(driver, result_upi_id, "Select UPI in search");
    }

    public String getAmountPageTransferTo() throws InterruptedException {
        return Element.getText(driver,transfer_to , "Get Amount Page Transfer To");
    }

    public void enterAmount(String amount) throws InterruptedException {
        Element.enterText(driver, enter_amount, amount, "Enter Amount");
    }

    public void enterMessage(String message) throws InterruptedException {
        Element.enterText(driver, enter_message, message, "Enter Message");
    }

    public Boolean isSetupMessageDisplayed() throws InterruptedException {
        return Elements.isElementPresent(driver,setup_message);
    }

    public void clickOnConfirmPayment() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_payment, "Click on Confirm Payment");
    }

    public Boolean is2FAPageDisplayed() throws InterruptedException {
        return Elements.isElementPresent(driver,TwoFA_page_displayed);
    }

    public void clickOnContinue2FAPage() throws InterruptedException {
        Element.selectElement(driver, TwoFA_page_cta, "Click on Continue on 2FA Page");
    }

    public String getPaymentSuccessMessage() throws InterruptedException {
        return Element.getText(driver, payment_succes_message, "Get Success Message");
    }

    public String getAmountPaid() throws InterruptedException {
        return Element.getText(driver, amount_paid, "Get Amount Paid");
    }

    public String getReceiverName() throws InterruptedException {
        return Element.getText(driver, receiver_name, "Get Receiver Name");
    }

    public void selectTransfertoBank() throws InterruptedException {
        Element.selectElement(driver, radio_button_to_bank_account, "Select radio button to Bank");
    }

    public void enterBeneficiaryName(String beneficiaryName) throws InterruptedException {
        Element.waitForVisibility(driver,enter_beneficiary_name);
        Element.enterText(driver, enter_beneficiary_name, beneficiaryName, "Enter Beneficiary Name");
    }

    public void enterAccountNumber(String accountNumber) throws InterruptedException {
        Element.enterText(driver, enter_account_number, accountNumber, "Enter Account Number");
    }

    public void enterIfsc(String ifsc) throws InterruptedException {
        Element.enterText(driver, enter_ifsc, ifsc, "Enter IFSC");
    }

    public void clickConfirmBankDetails() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_bank_details, "Confrim Bank details");
    }

    public void returnToHomePage() throws InterruptedException {
        Element.selectElement(driver, click_on_cross, "Click on Cross");
    }

    public void clickOnUpiSetupCta() throws InterruptedException {
        Element.selectElement(driver, cta_start_upi_setup, "Permission Consent Page Continue CTA");
    }


    public Boolean isRestoreUpiCheckoutWidgetShown() throws InterruptedException {
        return Elements.isElementPresent(driver,restore_upi_widget_checkout);
    }

    public void clickOnRestoreUpiCheckout() throws InterruptedException {
        Element.selectElement(driver, restore_upi_widget_checkout, "Checkout Restore UPI Widget.");
    }

    public void clickOnUpiAccountInCheckout() throws InterruptedException {
        Element.selectElement(driver, checkout_upi_account, "Select UPI account in Checkout");
    }

    public Boolean isQRPresent() throws InterruptedException{
        return Elements.isElementPresent(driver, qr_image);
    }

    public String fetchUPIID() throws InterruptedException{
        return Elements.getText(driver, qr_bottomsheet_upi_id, " Fetch UPi ID from QR Bottomsheet").replace("UPI ID : ", "");
    }

    public void clickContinueForContacts1() throws InterruptedException{
        Element.selectElement(driver,continue_cta_contact1, "Select Continue1 for Contact Permission");
    }

    public void clickContinueForContacts2() throws InterruptedException{
        Element.selectElement(driver,continue_cta_contact2, "Select Continue2 for Contact Permission");
    }

    public void selectFirstContactFromList() throws InterruptedException{
        Element.selectElement(driver,contact_name, "Select Contact from Contact List");
    }

    public Map<String , String> getAllVpaList() throws InterruptedException{


        Map<String, String> results = new HashMap<>();

        List<AndroidElement> title = Element.findElements(driver, By.id("title"));
        List<AndroidElement> description = Element.findElements(driver, By.id("subtitle"));

        for(int i=1; i<description.size();i++) {

            results.put(title.get(i).getText(), description.get(i).getText());
            Log.info(title.get(i).getText(), description.get(i).getText());

        }

        return results;

    }

    public void selectFirstVpaFromList() throws InterruptedException{
        Element.selectElement(driver,vpa1, "Select Vpa from List");
    }

    public void selectManageCta() throws InterruptedException{
        Element.selectElement(driver,manage_cta, "Click on Manage Cta");
    }

    ///////Pocket UPI Methods



    public Boolean isWalletNowPocketUpiBottomsheetPresent() throws InterruptedException{
        return Elements.isElementPresent(driver, pocketUpi_bottomsheet);
    }

    public String getbottomsheetTitle() throws InterruptedException {
        return Element.getText(driver, pocketUpi_bottomsheet_title, "Get PocketUpi Bottomsheet title");
    }

    public String getbottomsheetDescription() throws InterruptedException {
        return Element.getText(driver, pocketUpi_bottomsheet_description, "Get PocketUpi Bottomsheet Description");
    }


    public void selectContinueCta() throws InterruptedException{
        Element.selectElement(driver,pocketUpi_bottomsheet_continue_cta, "Select PocketUpi bottomsheet Continue cta");
    }

    public String getPocketUpiId() throws InterruptedException {
        return Element.getText(driver, pocket_upi_id, "Get PocketUpi ID");
    }


    public void selectPocketUpiTransferNowCta() throws InterruptedException{
        Element.selectElement(driver,pocketUpi_homePage_transferNow_cta, "Select PocketUpi Transfer Now cta");
    }

    public void selectPocketUpiScanAnyQRCta() throws InterruptedException{
        Elements.scrollToElement(driver,pocketUpi_homePage_scanAnyQR_cta );
        Element.selectElement(driver,pocketUpi_homePage_scanAnyQR_cta, "Select PocketUpi Sacn Any QR cta");
    }


    public void selectPocketUpiShowMyQRCta() throws InterruptedException{
        Elements.scrollToElement(driver,pocketUpi_homePage_showMyQr_cta );
        Element.selectElement(driver,pocketUpi_homePage_showMyQr_cta, "Select PocketUpi Show my QR cta");
    }

    public Boolean isPocketUPIPreSelected() throws InterruptedException{
        if(Element.getText(driver, pre_selected_bank_account, "Fetching Pre Selected PayMode" ).equals("Pocket UPI")){
            return true;
        }else {
            return false;
        }
    }

    public Boolean isPayModeOnSuccessScreenPocketUPI() throws InterruptedException{
        if(Element.getText(driver, success_page_validation_payment_mode, "Fetching Success Page PayMode" ).equals("Pocket UPI")){
            return true;
        }else {
            return false;
        }
    }


    public void clickLinkAccount() throws InterruptedException {
        Element.selectElement(driver, link_account_cta, "Click on Link Account");
    }

    public String fetchUPIIDManageSection() throws InterruptedException{
        return Elements.getText(driver, manage_section_upi_id, " Fetch UPi ID in Manage Section").replace("UPI ID : ", "");
    }


    public String fetchUPINumberManageSection() throws InterruptedException{
        return Elements.getText(driver, manage_section_upi_number, " Fetch UPi Number in Manage Section").replace("UPI ID : ", "");
    }



    public void clickHowToUseUpi() throws InterruptedException {
        Element.selectElement(driver, how_to_use_upi_cta, "Click on how to use UPI");
    }

    public void selectLanguage() throws InterruptedException {
        Element.selectElement(driver, select_language, "Select Language from the list");
    }

    public Boolean isWebsiteOpened() throws InterruptedException{
        return Elements.isElementPresent(driver, isWebsiteOpened);
    }


    public void scrollToBankList() throws InterruptedException{
        Thread.sleep(2000);
        Elements.scrollToElement(driver, manage_upi_autopay);
    }


    public Boolean isPrimaryTagVisible() throws InterruptedException{
        if(Elements.isElementPresent(driver, primary_tag)){
            return true;
        }else {
            return false;
        }
    }


    public void clickOnManageUpiAutopay() throws InterruptedException {
        Elements.scrollToElement(driver, manage_upi_autopay);
        Element.selectElement(driver, manage_upi_autopay, "Click on Manage Upi Autopay");
    }

    public Boolean verifyPageTitleUpiAutopay() throws InterruptedException{
        if(Elements.getText(driver, page_title, "Fetching Title Text").equals("UPI Subscriptions")){
            return true;
        }else {
            return false;
        }
    }

    public void clickOnBackButton() throws InterruptedException {
        Element.selectElement(driver, back_button, "Click on Back Button");
    }

















    //////////////////////////////////////////////



    public String verifySetupPopUp(String amount) throws InterruptedException {
        return Element.getText(driver, text_header_upi_setup, "Get Header Text");
    }

    public void clickSendMoney() throws InterruptedException {
        Element.selectElement(driver, cta_send_money, "Click on Send Money");
    }

    public void clickConfrimUpi() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_upi, "Click on Confirm UPI");
    }



    public void clickRequestMoney() throws InterruptedException {
        Element.selectElement(driver, cta_request_money, "Click on Request Money");
    }

    public void clickOnConfirmRequest() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_request, "Click on Confirm Request");
    }



    public void enterBankName(String bankName) throws InterruptedException {
        Element.enterText(driver, enter_bank_name, bankName, "Enter Bank Name");
    }

    public void selectBankFromList() throws InterruptedException {
        Element.selectElement(driver, select_bank_from_list, "Select Bank from List");
    }

    public void selectSim1() throws InterruptedException {
        Element.selectElement(driver, select_sim_1, "Select Sim 1");
    }

    public void enterVpa(String enterVpa) throws InterruptedException {
        Element.enterText(driver, enter_vpa, enterVpa, "Enter Random VPA");
    }

    public void submitVpa() throws InterruptedException {
        Element.selectElement(driver, submit_vpa, "Submit VPA");
    }

    public String upiIdGenerated() throws InterruptedException {
        return Element.getText(driver, get_upi_id, "Get Upi Id generated");
    }

    public HomePage clickBackToHomeFromSetupSuccess() throws InterruptedException {
        Element.selectElement(driver, upi_setup_success_back_to_home_cta, "Click Back tom Home");
        return new HomePage(driver);
    }










}
