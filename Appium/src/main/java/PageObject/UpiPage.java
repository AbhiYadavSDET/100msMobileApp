package PageObject;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    @AndroidFindBy(id = "cta_btn")
    private AndroidElement cta_confirm_payment_choose_payment_mode_bottomsheet;

    @AndroidFindBy(id="tv_title")
    private AndroidElement choose_payment_mode_bottonsheet;

    @AndroidFindBy(id="tv_state_title")
    private AndroidElement restore_UPI_option;

    @AndroidFindBy(id="start_button")
    private AndroidElement start_upi_restore_journey;



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

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
    private AndroidElement allowContactPermission;

    @AndroidFindBy(id="left_container")
    private AndroidElement backButtonOnUPIPage;

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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add New Bank Account']")
    private AndroidElement add_new_bank_account;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hdfc Bank']")
    private AndroidElement hdfc_bank;

    //"You don’t seem to have an account in this bank"
    @AndroidFindBy(id="description")
    private AndroidElement errormessage_description;

    @AndroidFindBy(id="mkab_left_icon")
    private AndroidElement back_button_errorPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add New Credit Card']")
    private AndroidElement add_new_bank_credit_card;

    @AndroidFindBy(id="subtitle")
    private AndroidElement add_credit_card_landing_page_subtitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HDFC Bank Credit Card']")
    private AndroidElement hdfc_bank_credit_card;













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

//
    @AndroidFindBy(id="ic_menu")
    private AndroidElement menu_icon_manageUpi_page;

    @AndroidFindBy(id="manage")
    private AndroidElement manage_upi_number;

    @AndroidFindBy(id="deregister")
    private AndroidElement deregister_upi;


    @AndroidFindBy(id="secondary_button")
    private AndroidElement deregister_upi_number_cta;

    @AndroidFindBy(id="fab_add_number")
    private AndroidElement add_new_upi_number;

    @AndroidFindBy(id="title_text")
    private AndroidElement confirmation_pop_up_title;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Deactivate']")
    private AndroidElement bottomsheet_deactivate_cta;


//    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Deactivate'])[1]")
//    private AndroidElement deactivate_cta_1_primary_number;

//    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Deactivate'])[2]")
//    private AndroidElement deactivate_cta_2_secondary_number;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='9205299330']/following-sibling::android.widget.TextView")
    private AndroidElement activate_cta_1_primary_number;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Activate'])[2]")
    private AndroidElement activate_cta_2_secondary_number;

    @AndroidFindBy (id="btn_link")
    private AndroidElement number_mapper_activate_cta_manage_page;

    @AndroidFindBy(id="btn_check_availablity")
    private AndroidElement check_avaibility_cta;


    @AndroidFindBy(id="edit_text")
    private AndroidElement mapper_number_enter_field;

    @AndroidFindBy(id="tick")
    private AndroidElement mapper_number_available;

    //Deregister

    @AndroidFindBy(id="title_text")
    private AndroidElement deregister_pop_up_titleText;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='No']")
    private AndroidElement deregister_popup_no_cta;































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

    public Boolean isChoosePaymentModeBottomsheetDisplayed() throws InterruptedException {
        return Elements.isElementPresent(driver,choose_payment_mode_bottonsheet);
    }

    public void clickOnRestoreUpiInChoosePaymentModeBottomsheet() throws InterruptedException {
        Element.selectElement(driver, restore_UPI_option, "Click on Restore Upi in Choose Payment Mode Bottomsheet");
    }

    public void clickStartUpiRestoreJourney() throws InterruptedException {
        Element.selectElement(driver, start_upi_restore_journey, "Click start upi restore journey");
    }



    public void clickOnConfirmPayment() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_payment, "Click on Confirm Payment");
    }

    public void clickOnConfirmPaymentChoosePaymentModeBottomsheet() throws InterruptedException{
        Element.selectElement(driver, cta_confirm_payment_choose_payment_mode_bottomsheet, "Click on Confirm Payment in bottomsheet");
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


    public void navigateToAddNewBankAccountAndSelect() throws InterruptedException {
        Elements.scrollToElement(driver, add_new_bank_account );
        Element.selectElement(driver, add_new_bank_account, "Select Add new Bank Account");
    }


    public void selectHdfcBankFromList() throws InterruptedException {
        Element.waitForVisibility(driver,hdfc_bank );
        Element.selectElement(driver, hdfc_bank, "Select HDFC Bank Account");
    }



    //"You don’t seem to have an account in this bank"
    public String validateErrorMessage() throws InterruptedException {
        return Element.getText(driver, errormessage_description, " Fetching Error Message");
    }


    public void goBackAddFlow() throws InterruptedException {
        Element.selectElement(driver, back_button_errorPage, "Go Back");
    }

    public void navigateToAddNewCreditCardAndSelect() throws InterruptedException {
        Elements.scrollToElement(driver, add_new_bank_credit_card );
        Element.selectElement(driver, add_new_bank_credit_card, "Select Add new Credit card");
    }


    public String getAddCreditCardLandingPageMessage() throws InterruptedException {
        return Element.getText(driver, add_credit_card_landing_page_subtitle, " Fetching Add Credit Card Landing Page Message");
    }

    public void selectHdfcBankCreditCardFromList() throws InterruptedException {
        Element.waitForVisibility(driver,hdfc_bank_credit_card );
        Element.selectElement(driver, hdfc_bank_credit_card, "Select HDFC Bank Credit Card");
    }




/////////

    public void selectMenuIconManageUpiPage() throws InterruptedException {
        Element.selectElement(driver, menu_icon_manageUpi_page, "Select Menu Icon Manage Upi Page");
    }

    public void selectManageUpiNumber() throws InterruptedException {
        Element.selectElement(driver, manage_upi_number, "Select Manage UPI Number");
    }

    public void selectDeregisterUpi() throws InterruptedException {
        Element.selectElement(driver, deregister_upi, "Select Deregister UPI");
    }

    //Primary Number



    public String getSecondaryNumberDeregisterStatusCtaText() throws InterruptedException{
        return Elements.getText(driver, deregister_upi_number_cta);
    }
    public void secondaryNumberDeregisterCta() throws InterruptedException {
        Element.selectElement(driver, deregister_upi_number_cta, "Deregister Secondary Number Cta");
    }

    public String getPrimaryNumberStatusCtaText() throws InterruptedException{

        return Element.getText(driver, activate_cta_1_primary_number, " Fetch Cta text fro Primary Number");

    }
    public void primaryNumberActivateDeactivateCta() throws InterruptedException, NoSuchElementException {
        Element.selectElement(driver, activate_cta_1_primary_number, "Tap on Activate cta for Primary Number" );
    }

//    public String getSecondaryNumberStatusCtaText() throws InterruptedException{
//        if(Elements.isElementPresent(driver,activate_cta_2_secondary_number)){
//            return Elements.getText(driver, activate_cta_2_secondary_number);
//        }else if(Elements.isElementPresent(driver,deactivate_cta_2_secondary_number)){
//            return Elements.getText(driver, deactivate_cta_2_secondary_number);
//        }else {
//            return "NA";
//        }
//
//    }
//    public void secondaryNumberActivateDeactivateCta() throws InterruptedException, NoSuchElementException {
//
//        if(Elements.isElementPresent(driver,activate_cta_2_secondary_number)){
//            Element.selectElement(driver, activate_cta_2_secondary_number, "Tap on Activate cta for Secondary Number" );
//        }else if(Elements.isElementPresent(driver,deactivate_cta_2_secondary_number)){
//            Element.selectElement(driver, deactivate_cta_2_secondary_number, "Tap on Deactivate cta for Secondary Number" );
//        }else {
//
//            Log.info("Element not Present");
//        }
//    }

    public void goBackNumberMapperPage() throws InterruptedException {
        Element.selectElement(driver, back_button_errorPage, "Go Back");
    }

    public String getDeactivateConfirmationPopUpTitleText() throws InterruptedException{
        return Elements.getText(driver, confirmation_pop_up_title);
    }

    public void deactivateConfirmationPopUpCta() throws InterruptedException {
        Element.selectElement(driver, bottomsheet_deactivate_cta, "Deactivate Number Confirmation Pop UP CTA");
    }

    public Boolean isActivateCtaPresentUpiNumberManagePage() throws InterruptedException{
        return Elements.isElementPresent(driver, number_mapper_activate_cta_manage_page);
    }

    public void clickOnActivateCtaManagePage() throws InterruptedException{
        Elements.scrollToElement(driver, number_mapper_activate_cta_manage_page);
         Element.selectElement(driver, number_mapper_activate_cta_manage_page, "Click on Activate Upi number Cta Manage Page");
    }

    public void addNewUpiNumberCta() throws InterruptedException {
        Element.selectElement(driver, add_new_upi_number, "Click on Add New Upi Number Cta");
    }

    public void checkAvaibilityCta() throws InterruptedException {
        Element.selectElement(driver, check_avaibility_cta, "Click on Check Avaibility Cta");
    }

    public void enterNewMapperNumber(String number) throws InterruptedException {
        //188698756
        Element.enterText(driver, mapper_number_enter_field, number, "Enter New Number for Mapping");
    }

    public Boolean isMapperNumberAvailable() throws InterruptedException{
        return Elements.isElementPresent(driver, mapper_number_available);
    }

    //Deregister



    public String getDeregisterPopUpTitleText() throws InterruptedException{
        return Elements.getText(driver, deregister_pop_up_titleText);
    }

    public void clickNoOnDeregisterUpiPopUp() throws InterruptedException {
        Element.selectElement(driver, deregister_popup_no_cta, "Click No on Deregister Pop Up");
    }

    public void clickOnAllowContact() throws InterruptedException {
        Element.selectElement(driver, allowContactPermission, "Click On allow button on contact permission");
    }

    public void clickOnBackFromUPIpage() throws InterruptedException {
        Element.selectElement(driver, backButtonOnUPIPage, "Click On back button from UPI page");
    }
}
