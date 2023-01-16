package PageObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
import Utils.Elements;

import java.io.IOException;


//Author - HarshTyagiOMK2165

public class IMPSNewPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "right")
    private AndroidElement label_amount;

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

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = '0']")
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


    public IMPSNewPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("*****IMPS New Page*****");
    }

    public void clickOnWalletToBank() throws InterruptedException{
        Elements.selectElement(driver,wallet_to_bank,"Tapped on Wallet To Bank Transfer Button");
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
        Elements.enterToElement(driver,amount_field,amt,"Amount set..");
    }

    public void clickOnSetAmount() throws InterruptedException{
        Elements.selectElement(driver,btn_set_amount,"Amount is correct. Go !!!");
    }

    public void clickOnContinueToPinCTA() throws  InterruptedException{
        Elements.selectElement(driver,continue_pin_cta,"Now switching to Security PIN Windows");
    }

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
        Elements.enterToElement(driver,upi_field,"9555746475@ibl","UPI Field set");
    }

    public void clickOnContinueToAmtCTA() throws InterruptedException{
        Elements.selectElement(driver,upi_continue_cta,"Tapped on Continue to Amt Page CTA");
    }

    public void clickOnSavedVPA(AndroidElement saved_vpa) throws InterruptedException{
        String comment= "Tapped on Saved VPA "+saved_vpa;
        Elements.selectElement(driver,saved_vpa,comment);
    }
}

