package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class IMPSPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Check Limits\"]")
    private IOSElement checkLimits;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Transfer to a new account\"]")
    private IOSElement transferToNewAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"M\"]")
    private IOSElement crossButtonOnImps;

    @iOSXCUITFindBy(id = "Beneficiary Name")
    private IOSElement beneficiaryName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Account Number\"]")
    private IOSElement accountNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Account Number, Account Number cannot be empty\"]")
    private IOSElement ifscCodeErrorMessage;

    @iOSXCUITFindBy(id = "IFSC Code")
    private IOSElement ifscCode;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeButton[@name=\"Continue\"]")
    private IOSElement continueButtonOnImps;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeStaticText[@name=\"UPI ID\"]")
    private IOSElement upiIdRadioButton;


    // wrong xpath need to change for UPI radio button or upi id


    @iOSXCUITFindBy(xpath= "//XCUIElementTypeTextField[@name=\"UPI ID\"]")
    private IOSElement upiIdField;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private IOSElement amountField;


    @iOSXCUITFindBy(xpath= "//XCUIElementTypeTextField[@name=\"UPI ID, Please enter valid UPI Id\"]")
    private IOSElement errorMessageOnUPINumber;


    @iOSXCUITFindBy(xpath= "//XCUIElementTypeTextField[@name=\"IFSC Code, Please enter correct IFSC Code\"]")
    private IOSElement errorMessageOnIfscCode;


    @iOSXCUITFindBy(xpath= "//XCUIElementTypeTextField[@name=\"Beneficiary Name, Beneficiary Name cannot be empty\"]")
    private IOSElement errorMessageOnBeneficiaryName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Account Number, Account Number cannot be empty\"]")
    private IOSElement errorAccountNumberMessage;


    public IMPSPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public IOSElement getCheckLimits() {
        return checkLimits;
    }

    public IOSElement getTransferToNewAccount() {
        return transferToNewAccount;
    }

    public IOSElement getCrossButtonOnImps() {
        return crossButtonOnImps;
    }

    public IOSElement getBeneficiaryName() {
        return beneficiaryName;
    }

    public IOSElement getAccountNumber() {
        return accountNumber;
    }

    public IOSElement getIfscCode() {
        return ifscCode;
    }

    public IOSElement getContinueButtonOnBeneficiaryPage() {
        return continueButtonOnImps;
    }

    public IOSElement getUpiIdBox() {
        return upiIdRadioButton;
    }

    public IOSElement getUpiIdField() {
        return upiIdField;
    }

    public IOSElement getAmountField() {
        return amountField;
    }

    public IOSElement getErrorMessageOnUPINumber() {
        return errorMessageOnUPINumber;
    }

    public IOSElement getErrorMessageOnIfscCode() {
        return errorMessageOnIfscCode;
    }

    public IOSElement getErrorMessageOnBeneficiaryName() {
        return errorMessageOnBeneficiaryName;
    }

    public void enterBeneficiaryName(String name)
    {
        Elements.enterToElement(driver, beneficiaryName, name , "Entered Beneficiary name : "+ name);
    }

    public void enterAccountNumber(String account)
    {
        Elements.enterToElement(driver, accountNumber, account , "Entered account numeber : "+ account);
    }

    public void enterIfscCode(String ifsc)
    {
        Elements.enterToElement(driver, ifscCode ,ifsc, "Entered IFSC Code numeber : "+ ifsc);
    }

    public void clickOnContinue(){
        Elements.click(driver,continueButtonOnImps,"Click on Continue button on beneficiary page");
    }

    public String getBeneficiaryErrorMessage() throws InterruptedException {
       return Elements.getText(driver,errorMessageOnBeneficiaryName,"Error message on beneficiary name ");
    }

    public String getAccountNumberErrorMessage() throws InterruptedException {
        return Elements.getText(driver,errorAccountNumberMessage,"Error message on Account number ");
    }

    public String getIfscCodeErrorMessage() throws InterruptedException {
        return Elements.getText(driver,errorMessageOnIfscCode,"Error message on IFSC code ");
    }

    public void clickOnUPIOption(){
        Elements.click(driver,upiIdRadioButton,"Click on upi radio button");
    }

    public void enterUPIId(String upi){
        Elements.enterToElement(driver, upiIdField ,upi, "Entered UPI ID number : "+ upi);
    }

    

}
