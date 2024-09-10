package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class IMPSPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Check Limits']")
    private IOSElement checkLimits;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Transfer to a new account']")
    private IOSElement transferToNewAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='M']")
    private IOSElement crossButtonOnImps;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[starts-with(@name,'Beneficiary Name')]")
    private IOSElement beneficiaryName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[starts-with(@name,'Account Number')]")
    private IOSElement accNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[starts-with(@name,'IFSC')]")
    private IOSElement ifscCode;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeButton[@name='Continue']")
    private IOSElement continueButtonOnImps;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeStaticText[@name='UPI ID']")
    private IOSElement upiIdRadioButton;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    private IOSElement upiIdField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]")
    private IOSElement nameOnEnterAmountScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[2]")
    private IOSElement accountNumberOnEnterAmountScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private IOSElement enterAmount;

//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='MobiKwik']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
//    private IOSElement amountOnCheckout;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TRANSFER LIMITS']")
    private IOSElement transferLimitBottomSheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='M']")
    private IOSElement closeCheckLimitBottomSheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer money from Credit Card to bank account']")
    private IOSElement transferNowPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Transfer now']")
    private IOSElement transferNowButton;


    public IMPSPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    public void clickBeneficiaryName() { Elements.click(driver, beneficiaryName,"Click on Beneficiary name");   }

    public void enterBeneficiaryName(String name)
    {
        Elements.enterToElement(driver, beneficiaryName, name , "Entered Beneficiary name : "+ name);
    }

    public void clickAccountNumber() { Elements.click(driver, accNumber,"Click on Account number");   }

    public void enterAccountNumber(String accountNumber)
    {
        Elements.enterToElement(driver, accNumber, accountNumber , "Entered account number : "+ accountNumber);
    }

    public void clickIfsc() { Elements.click(driver, ifscCode,"Click on ifsc code");   }

    public void enterIfscCode(String ifsc)
    {
        Elements.enterToElement(driver, ifscCode ,ifsc, "Entered IFSC Code number : "+ ifsc);
    }

    public void clickOnContinue(){
        Elements.click(driver,continueButtonOnImps,"Click on Continue button on beneficiary page");
    }

    public void clickOnUPIOption(){
        Elements.click(driver,upiIdRadioButton,"Click on upi radio button");
    }

    public void clickOnUpiIdField() { Elements.click(driver, upiIdField,"Click on UPI ID text field");   }

    public void enterUPIId(String upi){
        Elements.enterToElement(driver, upiIdField ,upi, "Entered UPI ID number : "+ upi);
    }

    public void clickOnTransferToAccountButton() { Elements.click(driver,transferToNewAccount,"Click on Transfer to a new account");     }

    public String getBeneficiaryNameOnEnterAmountScreen() throws InterruptedException{
        return Elements.getText(driver, nameOnEnterAmountScreen);
    }

    public String getAccountNumberOnEnterAmountScreen() throws InterruptedException{
        return Elements.getText(driver, accountNumberOnEnterAmountScreen);
    }

//    public String getAmountOnCheckout() throws InterruptedException{
//        return Elements.getText(driver, amountOnCheckout);
//    }

    public void clickCheckLimits() { Elements.click(driver, checkLimits, "Click on check limits"); }

    public String getTransferLimitPageTitle() throws InterruptedException{
        return Elements.getText(driver, transferLimitBottomSheet);
    }

    public void clickCloseCheckLimitBottomSheet() { Elements.click(driver, closeCheckLimitBottomSheet,"Close Check limit sheet");    }

    public String getBeneficiaryFieldErrorMessage() throws InterruptedException{
        return Elements.getText(driver, beneficiaryName);
    }

    public String getAccountNumberFieldErrorMessage() throws InterruptedException{
        return Elements.getText(driver, accNumber);
    }

    public String getIfscFieldErrorMessage() throws InterruptedException{
        return Elements.getText(driver, ifscCode);
    }

    public String getUpiFieldErrorMessage() throws InterruptedException{
        return Elements.getText(driver, upiIdField);
    }

    public boolean isTransferNowPagePresent() throws InterruptedException{
        return Elements.isElementPresent(driver, transferNowPage, "isTransferNowPagePresent");
    }

    public void clickOnTransferNowButton() {
        Elements.click(driver, transferNowButton,"Click on Transfer now");
    }

}
