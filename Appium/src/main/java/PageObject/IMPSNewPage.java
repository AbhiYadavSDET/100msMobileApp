package PageObject;
import Utils.Element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import Utils.Elements;

import java.io.IOException;


//Author - HarshTyagiOMK2165

public class IMPSNewPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "right")
    private AndroidElement label_amount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Wallet to Bank']")
    private AndroidElement imps_page_title;

    @AndroidFindBy(id = "title")
    private AndroidElement label_success_message;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Wallet to Bank Transfer']")
    private AndroidElement wallet_to_bank;

    @AndroidFindBy(id = "btn_new_transfer")
    private AndroidElement transfer_to_new_account;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text ='Beneficiary Name']")
    private  AndroidElement beneficiary_name_field;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Account Number']")
    private  AndroidElement account_number_field;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'IFSC Code']")
    private  AndroidElement ifsc_code_field;

    @AndroidFindBy(id = "btn_continue")
    private  AndroidElement continue_cta;

    @AndroidFindBy(id = "edit_text")
    private  AndroidElement amount_field;

    @AndroidFindBy(id = "btn_pin_submit")
    private  AndroidElement btn_set_amount;

    @AndroidFindBy(xpath = "//android.widget.Button[@text ='Continue']")
    private  AndroidElement continue_pin_cta;

    @AndroidFindBy(id = "edit_text_mket")
    private  AndroidElement security_pin_field;

    @AndroidFindBy(id ="radio_upi")
    private AndroidElement radio_upi;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement upi_field;

    @AndroidFindBy(id = "btn_continue")
    private AndroidElement upi_continue_cta ;

    @AndroidFindBy(id = "i_agree")
    private AndroidElement advertisementCheckBox ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='7795709569@paytm']")
    private AndroidElement saved_vpa ;

    @AndroidFindBy(id = "txInsuranceTitle")
    private AndroidElement advertisementText ;

    @AndroidFindBy(id = "btn_pin_submit")
    private AndroidElement pin_continue_cta ;

    @AndroidFindBy(id = "cta")
    private AndroidElement checkoutContinueButton ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Refer & Earn']")
    private AndroidElement refer_Earn ;

    @AndroidFindBy(id = "search_ifsc")
    private AndroidElement find_ifsc ;

    @AndroidFindBy(id ="et_search")
    private AndroidElement searchBox ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Icici Bank Limited']")
    private AndroidElement selectIciciBank;


    @AndroidFindBy(id ="cell_container")
    private AndroidElement selectBank ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Beneficiary Name cannot be empty']")
    private AndroidElement beneficiaryMessage ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Account Number cannot be empty']")
    private AndroidElement accountNumberMessage ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='IFSC Code cannot be empty']")
    private AndroidElement ifscCodeMessage ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter valid UPI Id']")
    private AndroidElement upiIdMessage ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='We've pre-filled global IFSC code for ICICI BANK LIMITED. This can be used for transfers to any account']")
    private AndroidElement globalIfscMessage ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Check Limits']")
    private AndroidElement checkLimits ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TRANSFER LIMITS']")
    private AndroidElement transferLimits ;

    @AndroidFindBy(id = "close_button")
    private AndroidElement closeCheckLimit ;

    public IMPSNewPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("*****IMPS New Page*****");
    }

    public void clickOnWalletToBank() throws InterruptedException{
        Elements.selectElement(driver,wallet_to_bank,"Tapped on Wallet To Bank Transfer Button");
        if(!Elements.isElementPresent(driver,imps_page_title)){
            driver.navigate().back();
            Elements.selectElement(driver,wallet_to_bank,"Tapped on Wallet To Bank Transfer Button");
        }

    }
    public void clickOnTransferToNewAccount() throws InterruptedException{
        Elements.selectElement(driver,transfer_to_new_account,"Tapped on Transfer to New Account");
    }

    public void setBeneficiaryName(String name) throws InterruptedException{
        Elements.enterToElement(driver,beneficiary_name_field,name,"Beneficiary Name set..");
    }
    public void setAccountNumber(String account_number) throws InterruptedException{
        Elements.enterToElement(driver,account_number_field,account_number,"Account Number set..");
    }

    public void setIFSC_Code(String ifsc) throws InterruptedException{
        Elements.enterToElement(driver,ifsc_code_field,ifsc,"IFSC Code set..");
    }

    public void clickOnContinueCTA() throws InterruptedException{
        Elements.selectElement(driver,continue_cta,"Continue to Entering Amount");
    }

    public void setAmount(String amt) throws InterruptedException{
        Elements.clearText(driver,amount_field,"Clear if any");
        Elements.enterToElement(driver,amount_field,amt,"Amount set..");
    }

    public void clickOnSetAmount() throws InterruptedException{
        Element.waitForVisibility(driver, By.id("info_message"));
        Elements.selectElement(driver,btn_set_amount,"Amount is correct. Go !!!");
    }


    public void clickOnContinueToPinCTA() throws  InterruptedException{
        Elements.selectElement(driver,pin_continue_cta,"Click on continue now to pay amount");
    }

    public void clickOnAdvertisementCheckBox() throws  InterruptedException{
        Elements.selectElement(driver,advertisementCheckBox,"Click on insurance checkbox");
    }

    public boolean isAdvertisementPresent() throws InterruptedException {
        return Elements.isElementPresent(driver,advertisementCheckBox);
    }

    public String getInsuranceMessage() throws InterruptedException{
        return Elements.getText(driver, advertisementText, "Get insurance text message on checkout page ");
    }


    public void clickOnContinueToCheckoutCTA() throws  InterruptedException{
        Elements.selectElement(driver,checkoutContinueButton,"Now switching to Security PIN Windows");
    }

   /* public void clickOnContinueToPinCTA() throws  InterruptedException{
        Elements.selectElement(driver,continue_pin_cta,"Now switching to Security PIN Windows");
    }
*/
    public boolean checkSecurityPINPage() throws  InterruptedException{
        return Elements.isElementPresent(driver,security_pin_field);
    }
    public void setSecurityPIN(String pin) throws InterruptedException{
        Elements.enterToElement(driver,security_pin_field,pin,"Pin set....");
    }

    public String getSuccessMessage() throws InterruptedException{
        return Elements.getText(driver, label_success_message, "Success Message");
    }

    public String getSuccessPageAmount() throws InterruptedException{
        return Elements.getText(driver, label_amount, "Success Page | Amount");
    }

    public void clickOnUPIRadioBtn() throws InterruptedException{
        Elements.selectElement(driver,radio_upi,"Tapped on UPI Radio Button");
    }

    public void setUPIID(String upi) throws InterruptedException{
        Elements.enterToElement(driver, upi_field,upi,"UPI Field set");
    }

    public void clickOnContinueToAmtCTA() throws InterruptedException{
        Elements.selectElement(driver, upi_continue_cta,"Tapped on Continue to Amt Page CTA");
    }

 /*   public void clickOnSavedVPA(AndroidElement saved_vpa) throws InterruptedException{

        Elements.waitForElementToVisibleOnPage(driver,saved_vpa,5);
        String comment= "Tapped on Saved VPA "+saved_vpa;
        Elements.selectElement(driver,saved_vpa,comment);
    }*/
    public void clickOnSavedVPA() throws InterruptedException{

        if(Elements.isElementPresent(driver,saved_vpa)) {
            Elements.selectElement(driver, saved_vpa, "Click on first saved recipient");
        }else {
           clickOnTransferToNewAccount();
           clickOnUPIRadioBtn();
            //Entering UPI ID
            setUPIID("7795709569@paytm");
            clickOnContinueToAmtCTA();
        }
    }



    public void clickOnReferAndEarn() throws InterruptedException{
        Elements.selectElement(driver,refer_Earn,"Tapped on Refer & Earn");
    }

    public void clickOnFindiFSC() throws InterruptedException{
        Elements.selectElement(driver,find_ifsc,"Tapped on find ifsc");
    }
    public void clickOnSearchBox() throws InterruptedException{
        Elements.selectElement(driver,searchBox,"Tapped on search box");
    }

    public void enterBankNameOnImps(String bankName) throws InterruptedException{
        Elements.selectElement(driver, searchBox, "Click on Search box Field");
        Elements.clearText(driver, searchBox, "Clear before pasting");
        Elements.enterToElement(driver,searchBox,bankName,"Searching bank name :"+bankName);
    }
    public void selectIciciBankOnImps() throws InterruptedException{
        Elements.selectElement(driver,selectIciciBank,"Selecting ICICI  bank name :");
    }

    public void selectBankOnImps() throws InterruptedException{
        Elements.selectElement(driver,selectBank,"Selecting bank name :");
    }

    public String  getGlobalMessage() throws InterruptedException{
        return Elements.getText(driver, globalIfscMessage, "Global Message for IFSC code");
    }

    public String getBeneficiaryMessage() throws InterruptedException{
        return Elements.getText(driver, beneficiaryMessage, "Success Message");
    }

    public String getAccountNumberMessage() throws InterruptedException{
        return Elements.getText(driver, accountNumberMessage, "Success Message");
    }

    public String getIfscCodeMessage() throws InterruptedException{
        return Elements.getText(driver, ifscCodeMessage, "Success Message");
    }

    public String getUPIMessage() throws InterruptedException{
        return Elements.getText(driver, upiIdMessage, "Success Message");
    }
    public void clickOnCheckLimits() throws InterruptedException{
        Elements.selectElement(driver,checkLimits,"Tapped on check limits");
    }

    public String getTransferLimitsMessage() throws InterruptedException{
        return Elements.getText(driver, transferLimits, "transfer limit text");
    }


    public void clickOnCloseCheckLimits() throws InterruptedException{
        Elements.selectElement(driver,closeCheckLimit,"Tapped on close check limits ");
    }




}

