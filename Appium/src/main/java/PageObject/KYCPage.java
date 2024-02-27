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

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement backButtonFromCompleteYourKycScreen;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='I don’t want benefits']")
    private AndroidElement iDontWantbenefits;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Complete using other options']")
    private AndroidElement completeUsingOtherOptions;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue with your KYC']")
    private AndroidElement continueWithYourkyc;

    @AndroidFindBy(id = "close_button")
    private AndroidElement closeButtonOnKycPopup;

    @AndroidFindBy(id = "iv_arrow_down")
    private AndroidElement profile_button;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Do it Later']")
    private AndroidElement cc_toolTip;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Complete your KYC']")
    private AndroidElement completeYourKycProfile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Proceed with Min KYC']")
    private AndroidElement bottomSheetMinKyc;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Proceed with Full KYC']")
    private AndroidElement bottomSheetFullKyc;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PAN Card']")
    private AndroidElement minKycPanCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter PAN Card number']")
    private AndroidElement minKycPanCardNumber;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Full name']")
    private AndroidElement minKycFullName;


    @AndroidFindBy(id = "mkab_title")
    private AndroidElement minKycScreenTitle;

    @AndroidFindBy(id = "tx_static5")
    private AndroidElement minKycScreenSubTitle;

    @AndroidFindBy(id = "tx_static6")
    private AndroidElement minKycScreenText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fetch From Digilocker']")
    private AndroidElement profileDigilocker;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Through Aadhaar Details']")
    private AndroidElement profileAadhar;

    @AndroidFindBy(id = "btnContinue")
    private AndroidElement profileKycContinue;


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

    public void clickOnBackButtonFromCompleteYourKycScreen(){
        Elements.selectElement(driver, backButtonFromCompleteYourKycScreen, "Click on Back button ");
    }

    public void clickOnIDontWantBenefits(){
        Elements.selectElement(driver, iDontWantbenefits, "Click on i don't want benefits ");
    }

    public void clickOnCompleteUsingOtherOptions(){
        Elements.selectElement(driver, completeUsingOtherOptions, "Click on complete using other options");
    }

    public void clickOnContinueWithYourKyc(){
        Elements.selectElement(driver, continueWithYourkyc, "Click on Continue with yout kyc ");
    }

    public void clickOnPopupClosePopup(){
        Elements.selectElement(driver, closeButtonOnKycPopup, "Click on close on popup ");
    }

    public void clickOnProfileButton(){
        Elements.selectElement(driver, profile_button, "Click on Profile Button");
    }

    public boolean isCCToolTipPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, cc_toolTip);
    }

    public void removeCCToolTip(){
        Elements.selectElement(driver, cc_toolTip, "Remove CC Tool Tip");
    }

    public void clickOnCompleteYourKyc(){
        Elements.selectElement(driver, completeYourKycProfile, "Click On Complete Your Kyc");
    }

    public void clickOnMinKyc(){
        Elements.selectElement(driver, bottomSheetMinKyc, "Click on Min Kyc");
    }

    public void clickOnFullKyc(){
        Elements.selectElement(driver, bottomSheetFullKyc, "Click on Full Kyc");
    }

    public void clickOnMinKycPanCard(){
        Elements.selectElement(driver, minKycPanCard, "Click on Min Kyc Pan Card");
    }

    public void enterPanCardNumber(String pan) throws InterruptedException{
        Elements.enterToElement(driver, minKycPanCardNumber, pan,"Enter Pan Card Number");
    }

    public void enterFullName(String fullName) throws InterruptedException{
        Elements.enterToElement(driver, minKycFullName, fullName,"Enter Full Name");
    }

    public boolean isOnboardingPopUpPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, iDontWantbenefits);
    }

    public void clickIDontWantBenefits(){
        Elements.selectElement(driver, iDontWantbenefits, "Click on I Dont Want Benefits");
    }

    public String getMinKycScreenTitle() throws InterruptedException {
        return Elements.getText(driver, minKycScreenTitle, "Min Kyc Screen Title");
    }

    public String getminKycScreenSubTitle() throws InterruptedException {
        return Elements.getText(driver, minKycScreenSubTitle, "Min Kyc Screen Sub Title");
    }

    public String getMinKycScreenText() throws InterruptedException {
        return Elements.getText(driver, minKycScreenText, "Min Kyc Screen Text");
    }

    public void clickPofileKycContinue(){
        Elements.selectElement(driver, profileKycContinue, "Click on continue");
    }


}
