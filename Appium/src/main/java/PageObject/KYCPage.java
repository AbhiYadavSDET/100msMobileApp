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

    @AndroidFindBy(id = "button_accept")
    private AndroidElement allowButtonOnInAppPermissionScreen;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement whileUsingTheApp;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement allowButtonOnContactPermissionCaps;

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
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fetch From CKYC']")
    private AndroidElement fetchFromCKYC;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='via Digilocker']")
    private AndroidElement viaDigiLocker;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='via Aadhaar Website']")
    private AndroidElement viaAadharWebsite;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='via PAN Card']")
    private AndroidElement viaPanCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='via Passport']")
    private AndroidElement viaPassport;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Full name']")
    private AndroidElement minKycFullName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='via NREGA Job Card']")
    private AndroidElement viaNREGA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='via Driving License']")
    private AndroidElement viaDrivingLiscence;

    @AndroidFindBy(id = "mkab_title")
    private AndroidElement minKycScreenTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='via Voter ID Card']")
    private AndroidElement viaVoterIdCard;

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
    @AndroidFindBy(id = "eft_container")
    private AndroidElement backFromDigiLockerScreen;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[1]")
    private AndroidElement adharCardFirstDigits;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[2]")
    private AndroidElement adharCardSecondDigits;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[3]")
    private AndroidElement adharCardThirdDigits;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    private AndroidElement nextButtonOnDigilockerAadharCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Try another way']")
    private AndroidElement tryAnotherWayOnDigilocker;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText")
    private AndroidElement enterOtpOnDigiLocker;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Submit']")
    private AndroidElement submitButtonOnDigilocker;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Other Banks']")
    private AndroidElement otherBanksOptionOnSetup;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Aadhaar Number']")
    private AndroidElement adhaarNumberOptionOnAdhaarWebsite;


    @AndroidFindBy(id = "btn_submit")
    private AndroidElement arrowbuttonOnAdhaarWebsite;



    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter security code']")
    private AndroidElement enterSecurityCodeOnAdhaarWebsite;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private AndroidElement okOnCaptchaFailurePopup;

    @AndroidFindBy(xpath = "//android.view.View[@text='Please enter a valid aadhaar number.']")
    private AndroidElement errorMessageOfAdhaarOnDigilocker;
    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement profileAadhaarEditText;

    @AndroidFindBy(id = "btnSubmit")
    private AndroidElement profileAadhaarSubmit;

    @AndroidFindBy(id = "primary_button")
    private AndroidElement profileAadhaarPopUp;

    @AndroidFindBy(id = "advantages_text")
    private AndroidElement profileKycTitle;

    @AndroidFindBy(id = "tx_kyc_cond")
    private AndroidElement profileKycSubTitle;


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
        Elements.selectElement(driver, allowButtonOnInAppPermissionScreen, "Click on allow button on permission screen ");
    }

    public void clickOnWhileUsingApp(){
        Elements.selectElement(driver, whileUsingTheApp, "Click on while using app ");
    }
    public void clickOnAllowButton(){
        Elements.selectElement(driver, allowButtonOnContactPermissionCaps, "Click on ALLOW button ");
    }


    public boolean isPermissionScreenVisible() throws InterruptedException {
        return Elements.isElementPresent(driver,allowButtonOnInAppPermissionScreen);
    }

    public boolean isAllowButtonPresent() throws InterruptedException {
        return Elements.isElementPresent(driver,allowButtonOnContactPermissionCaps);
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

    public void clickOnFetchFromCKYC(){
        Elements.selectElement(driver, fetchFromCKYC, "Click on close on popup ");
    }
    public void clickOnViaDigiLocker(){
        Elements.selectElement(driver, viaDigiLocker, "Click on viaDigiLocker ");
    }
    public void clickOnViaAadharWebsite(){
        Elements.selectElement(driver, viaAadharWebsite, "Click on viaAadharWebsite ");
    }
    public void clickOnViapanCard(){
        Elements.selectElement(driver, viaPanCard, "Click on viaPanCard ");
    }
    public void clickOnViaPassport(){
        Elements.selectElement(driver, viaPassport, "Click on viaPassport");
    }
    public void clickOnViaNREGA(){
        Elements.selectElement(driver, viaNREGA, "Click on viaNREGA ");
    }
    public void clickOnViaDrivingLiscence(){
        Elements.selectElement(driver, viaDrivingLiscence, "Click on viaDrivingLiscence");
    }
    public void clickOnViaVoterIdCard(){
        Elements.selectElement(driver, viaVoterIdCard, "Click on viaVoterIdCard");
    }

    public void clickOnBackFromDigilocker(){
        Elements.selectElement(driver, backFromDigiLockerScreen, "Click on Back from DigiLocker screen");
    }

    public void setAdharCardFirstDigits(String digits) throws InterruptedException{
        Elements.enterToElement(driver, adharCardFirstDigits,digits,"Set Adhar card first 4 digits ");
    }

    public void setAdharCardSecondDigits(String digits) throws InterruptedException{
        Elements.enterToElement(driver, adharCardSecondDigits,digits,"Set Adhar card middle 4 digits  ");
    }

    public void setAdharCardThirdDigits(String digits) throws InterruptedException{
        Elements.enterToElement(driver, adharCardThirdDigits,digits,"Set Adhar card last 4 digits  ");
    }

    public void clickOnNextButtonOnDigilocker(){
        Elements.selectElement(driver, nextButtonOnDigilockerAadharCard, "Click on next button from digilocker screem");
    }
    public void clickOnTryAnotherWayOnDigilocker(){
        Elements.selectElement(driver, tryAnotherWayOnDigilocker, "Click on try another way on digilocker");
    }

    public void setEnterOtpOnDigiLocker(String otp) throws InterruptedException{
        Elements.enterToElement(driver, enterOtpOnDigiLocker,otp,"Set OTP on digi locker ");
    }

    public void clickOnSubmitButtonOnDigilocker(){
        Elements.selectElement(driver, submitButtonOnDigilocker, "Click on submit button on  digilocker");
    }

    public void clickOnOtherOptionsOnUPISetupPage(){
        Elements.selectElement(driver, otherBanksOptionOnSetup, "Click on other options on upi setup page.");
    }

    public void setAdharNumberOnAdharWebsite(String adhaarNumber) throws InterruptedException{
        Elements.enterToElement(driver, adhaarNumberOptionOnAdhaarWebsite,adhaarNumber,"Set adhar number on adhaar website ");
    }

    public void clickOnArrowButtonOnAdhaarWebsite(){
        Elements.selectElement(driver, arrowbuttonOnAdhaarWebsite, "Click on arrow button on adhaar website.");
    }

    public void setSecurityCode(String securityCode) throws InterruptedException{
        Elements.enterToElement(driver,enterSecurityCodeOnAdhaarWebsite ,securityCode,"Set security code on  website ");
    }

    public void clickOkOnCaptcaFailure(){
        Elements.selectElement(driver, okOnCaptchaFailurePopup, "Click ok on captcha failure ");
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

    public void clickPofileAadhaar(){
        Elements.selectElement(driver, profileAadhar, "Click on Aadhaar");
    }

    public void clickPofileDigilocker(){
        Elements.selectElement(driver, profileDigilocker, "Click on Digilocker");
    }

    public void enterProfileAadhaarTextBox(String aadhaarNumber) throws InterruptedException{
        Elements.enterToElement(driver, profileAadhaarEditText, aadhaarNumber,"Enter Aadhaar Number");
    }

    public void enterAadhaarCaptcha(String aadhaarCaptcha) throws InterruptedException{
        Elements.enterToElement(driver, profileAadhaarEditText, aadhaarCaptcha,"Enter Aadhaar Captcha");
    }

    public void clickPofileAadhaarSubmit(){
        Elements.selectElement(driver, profileAadhaarSubmit, "Click on Submit");
    }

    public boolean isProfileAadhaarPopUpPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, profileAadhaarPopUp);
    }

    public void removeProfileAadhaarPopUp(){
        Elements.selectElement(driver, profileAadhaarPopUp, "Click on Submit");
    }

    public String getProfileKycScreenTitle() throws InterruptedException {
        return Elements.getText(driver, profileKycTitle, "Profile Kyc Screen Title");
    }

    public String getProfileKycScreenSubTitle() throws InterruptedException {
        return Elements.getText(driver, profileKycSubTitle, "Profile Kyc Screen Sub Title");
    }

    public String getProfileKycScreenText() throws InterruptedException {
        return Elements.getText(driver, checkBoxConsent, "Profile Kyc Screen Text");
    }

    public  boolean isOnboardingOptionsScreenPresent() throws InterruptedException {
        return Elements.isElementPresent(driver,bottomSheetFullKyc);
    }

}
