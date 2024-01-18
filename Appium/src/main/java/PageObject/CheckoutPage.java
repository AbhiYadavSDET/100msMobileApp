package PageObject;

import Utils.Element;
import Utils.Elements;
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









    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectNBOnCheckoutScreen() throws InterruptedException {
        Element.selectElement(driver, selectNBOnCheckoutScreen, "Select NetBanking From Checkout Screen");
    }

    public void selectIMPSOnCheckoutScreen() throws InterruptedException {
        Element.selectElement(driver, selectIMPSOnCheckoutScreen, "Select IMPS From Checkout Screen");
    }

    public void selectKotakBankFromBAnkList() throws InterruptedException {
        Element.selectElement(driver, kotakBankCta, "Select Kotak Bank From Netbanking Bank List");
    }

    public String getBankPageTitleNetbanking() throws InterruptedException {
        return Elements.getText(driver, bank_page, "Heading on Bank Page");
    }

    public String getBankPageTitleWeb() throws InterruptedException {
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
         Elements.selectElement(driver, View_bank_ac_details_cta, "Select View bank a/c details");
    }


    public String getBankDetailsAccountNumber() throws InterruptedException{
        return Elements.getText(driver, account_number, "Account Number");
    }

    public String getBankDetailsIFSCNumber() throws InterruptedException{
        return Elements.getText(driver, ifsc_number, "IFSC Number");
    }

    public String getBankDetailsAccountHolderName() throws InterruptedException{
        return Elements.getText(driver, account_holder_name, "Account Holder Name");
    }

    public String getBankDetailsBankName() throws InterruptedException{
        return Elements.getText(driver, bank_name, "Bank Name");
    }

    public String getBankDetailsAccountType() throws InterruptedException{
        return Elements.getText(driver, account_type, "Account Type");
    }

    public void goBackFromBankDetailsPage() throws InterruptedException{
        Elements.selectElement(driver,back_button_Bank_details_page,"Go Back to checkout ");
    }










}
