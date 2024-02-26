package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class KYCPage {

    AndroidDriver driver;

    public KYCPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    private AndroidElement continueButtonOnLendingScreen;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
    private AndroidElement allowButtonOnBottomsheetPermissionScreen;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='WHILE USING THE APP']")
    private AndroidElement whileUsingTheApp;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
    private AndroidElement allowButtonOnContactPermission;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='First Name']")
    private AndroidElement firstName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Abhishek123']")
    private AndroidElement firstNameWithErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Last Name']")
    private AndroidElement lastName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Yadav123']")
    private AndroidElement lastNameWithErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed']")
    private AndroidElement proceedButtonAfterName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter a valid name']")
    private AndroidElement errorOnNameMessage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='PAN Card Number']")
    private AndroidElement panCardNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='HTIPKQWERT']")
    private AndroidElement panCardNumberWithErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invalid PAN Number']")
    private AndroidElement errorOnPanNumber;

    @AndroidFindBy(id = "cbKycConsent")
    private AndroidElement checkBoxConsent;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Date of Birth']")
    private AndroidElement dateOfBirth;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Select']")
    private AndroidElement selectDate;

    public void clickOnContinueButtonOnBoradingScreen() {
        Elements.selectElement(driver, continueButtonOnLendingScreen, "Click on continue button on lending page for KYC");
    }

    public void setFirstName(String name) throws InterruptedException{
        Elements.enterToElement(driver, firstName,name,"First Name set ");
    }

    public void setFirstNameWithErrorMessage(String name) throws InterruptedException{
        Elements.clearText(driver,firstNameWithErrorMessage,"Clearing text");
        Elements.enterToElement(driver, firstName,name,"First Name set ");
    }

    public void setLastName(String name) throws InterruptedException{
        Elements.enterToElement(driver, lastName,name,"Last Name set ");
    }
    public void setLastNameWithErrorMessage(String name) throws InterruptedException{
        Elements.clearText(driver,lastNameWithErrorMessage,"Clearing text");
        Elements.enterToElement(driver, lastName,name,"Last Name set ");
    }

    public void clickOnProceedAfterName() {
        Elements.selectElement(driver, proceedButtonAfterName, "Click on proceed button after name ");
    }

    public String  getNameErrorMessage() throws InterruptedException{
        return Elements.getText(driver, errorOnNameMessage, "Error message on name ");
    }

    public void setPanNumber(String pan) throws InterruptedException{
        Elements.enterToElement(driver, panCardNumber,pan,"Pan Card set ");
    }

    public void setPanNumberWithErrorMessage(String pan) throws InterruptedException{
        Elements.clearText(driver,panCardNumberWithErrorMessage,"Clearing text");
        Elements.enterToElement(driver, panCardNumber,pan,"Pan Card set ");
    }

    public void clickOnDateOption() {
        Elements.selectElement(driver, dateOfBirth, "Click on date option ");
    }

    public void clickOnSelectDate() {
        Elements.selectElement(driver, selectDate, "Click on select date option ");
    }

    public void clickOnKycConsent(){
        Elements.selectElement(driver, checkBoxConsent, "Click on check box for KYC consent ");
    }

    public void clickOnPermissionScreen(){
        Elements.selectElement(driver, allowButtonOnBottomsheetPermissionScreen, "Click on allow button on permission screen ");
    }
    public void clickOnWhileUsingApp(){
        Elements.selectElement(driver, whileUsingTheApp, "Click on while using app ");
    }
    public void clickOnAllowButton(){
        Elements.selectElement(driver, allowButtonOnContactPermission, "Click on ALLOW button ");
    }

    public boolean isPermissionScreenVisible() throws InterruptedException {
        return Elements.isElementPresent(driver,allowButtonOnBottomsheetPermissionScreen);
    }
    public boolean isWhileUsingpresent() throws InterruptedException {
        return Elements.isElementPresent(driver,whileUsingTheApp);
    }
    public boolean isAllowButtonPresent() throws InterruptedException {
        return Elements.isElementPresent(driver,allowButtonOnContactPermission);
    }


}
