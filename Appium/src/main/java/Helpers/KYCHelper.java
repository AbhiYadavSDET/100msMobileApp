package Helpers;

import PageObject.*;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class KYCHelper {


    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Elements element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    IMPSNewPage impsPage;
    SecurityPinPage securityPinPage;
    KYCPage kycPage;
    PermissionPage permissionPage;

    public KYCHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Elements(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        securityPinPage = new SecurityPinPage(driver);
        kycPage = new KYCPage(driver);
        permissionPage = new PermissionPage(driver);
    }

    public void OnboardingNonKycFlow(String firstName, String lastName,String pan) throws InterruptedException {

        // Full kyc flow from Onboarding
        kycPage.clickOnContinueButtonOnBoradingScreen();
        handelPopups();

        //Enter first name
        kycPage.setFirstName(firstName);

        //enter last name
        kycPage.setLastName(lastName);

        //click on proceed after entering name
        kycPage.clickOnProceedAfterName();

        //enter pan card number
        kycPage.setPanNumber(pan);

        //click on date optin
        kycPage.clickOnDateOption();

        //clcik on select date field
        kycPage.clickOnSelectDate();

       // click on kyc consent checkbox
        kycPage.clickOnKycConsent();

    }

    public void ErrorMessageOnNonKycFlow() throws InterruptedException, IOException {

        //Error message validation on full kyc flow from Onboarding
        kycPage.clickOnContinueButtonOnBoradingScreen();
        handelPopups();

        //Enter invalid first name
       kycPage.setFirstName("Abhishek123");

        //enter invalid last name
        kycPage.setLastName("Yadav123");

        //click on proceed after entering name
        kycPage.clickOnProceedAfterName();
        String error = kycPage.getNameErrorMessage();
        mbReporter.verifyEqualsWithLogging(error,"Please enter a valid name","Verifing error message on name",false,false);

        //Enter valid first name
        kycPage.setFirstNameWithErrorMessage("Abhishek");

        //enter invalid last name
        kycPage.setLastNameWithErrorMessage("Yadav123");
        kycPage.clickOnProceedAfterName();
        mbReporter.verifyEqualsWithLogging(error,"Please enter a valid name","Verifing error message on name",false,false);

        //enter valid last name
        kycPage.setLastNameWithErrorMessage("Yadav");

        //click on proceed after entering name
        kycPage.clickOnProceedAfterName();
        // enter invalid pan
        kycPage.setPanNumber("HTIPKQWERT");

        //click on date option
        kycPage.clickOnDateOption();

        //select date from popup
        kycPage.clickOnSelectDate();

        // click on kyc consent checkbox
        kycPage.clickOnKycConsent();

        // enter valid pan card
        kycPage.setPanNumberWithErrorMessage("HTIPK7865M");
    }


    public void fullKycFromCKYC() throws InterruptedException {

        // Full kyc VIA CKYC

        //Back button from complete your kyc screen
        kycPage.clickOnBackButtonFromCompleteYourKycScreen();

        // click on complete using other options
        kycPage.clickOnCompleteUsingOtherOptions();

        //click on fetch from ckyc
        kycPage.clickOnFetchFromCKYC();

        //enter invalid first name
        kycPage.setFirstName("Abhishek");

        //enter invalid last name
        kycPage.setLastName("yadav");

        //click on proceed after entering name
        kycPage.clickOnProceedAfterName();

        // enter valid pan card
        kycPage.setPanNumber("HTIPK7865K");

        //click on date option
        kycPage.clickOnDateOption();

        // click on select date
        kycPage.clickOnSelectDate();

        // click on kyc consent checkbox
        kycPage.clickOnKycConsent();

    }
    public void fullKycFromDigilocker(String firstFourDigits,String secondFourDigits,String lastFourDigits,String otp) throws InterruptedException {
     // Full kyc VIA Digi locker

        // press back button from kyc sreen
        kycPage.clickOnBackButtonFromCompleteYourKycScreen();

        // click on complete using other options
        kycPage.clickOnCompleteUsingOtherOptions();

        // click on via digilocker
        kycPage.clickOnViaDigiLocker();
        Thread.sleep(2000);

        // set first 4 digits of adhaar card
        kycPage.setAdharCardFirstDigits(firstFourDigits);

        // set middle 4 digits of adhaar card
      kycPage.setAdharCardSecondDigits(secondFourDigits);

        // set last 4 digits of adhaar card
      kycPage.setAdharCardThirdDigits(lastFourDigits);

      // click on next button on digilocker
      kycPage.clickOnNextButtonOnDigilocker();

      // enter otp on digilocker
      kycPage.setEnterOtpOnDigiLocker(otp);
    }

    public void fullKycFromAdharWebsite(String adharNumber, String securityCode) throws InterruptedException {
        // Full kyc VIA Adhaar website
        kycPage.clickOnBackButtonFromCompleteYourKycScreen();

        // click on complete using other options
        kycPage.clickOnCompleteUsingOtherOptions();

        // click on via adhaar website
        kycPage.clickOnViaAadharWebsite();

        //handeled permission popup
        handelPopups();

        // Enter adhaar number
        kycPage.setAdharNumberOnAdharWebsite(adharNumber);

        // click on kyc consent checkbox
        kycPage.clickOnKycConsent();

        // click on arrow button
        kycPage.clickOnArrowButtonOnAdhaarWebsite();

        //enter security code
        kycPage.setSecurityCode(securityCode);
    }

    public void fullKycFromCKYCOnFailureFromAdhaarWebsite(String adharNumber, String securityCode,String firstName,String lastName,String pan) throws InterruptedException {

        // String Full kyc VIA Adhaar website
        kycPage.clickOnBackButtonFromCompleteYourKycScreen();

        // click on complete using other options
        kycPage.clickOnCompleteUsingOtherOptions();

        // click on via adhaar website
        kycPage.clickOnViaAadharWebsite();

        //handeled permission popup
        handelPopups();

        // enter adhaar number
        kycPage.setAdharNumberOnAdharWebsite(adharNumber);

        // click on kyc consent checkbox
        kycPage.clickOnKycConsent();

        // click on arror button on adhaar website
        kycPage.clickOnArrowButtonOnAdhaarWebsite();

        // enter security code
        kycPage.setSecurityCode(securityCode);

        // click on arrow button on adhaar website
        kycPage.clickOnArrowButtonOnAdhaarWebsite();

        // click ok on captcha failure
        kycPage.clickOkOnCaptcaFailure();

        // On failire VIA adhar website, user should  be redircted to CKYC flow
        //enter invalid first name
        kycPage.setFirstName("Abhishek");

        //enter invalid last name
        kycPage.setLastName("yadav");

        //click on proceed after entering name
        kycPage.clickOnProceedAfterName();

        // enter valid pan card
        kycPage.setPanNumber("HTIPK7865K");

        //click on date option
        kycPage.clickOnDateOption();

        // click on select date
        kycPage.clickOnSelectDate();

        // click on kyc consent checkbox
        kycPage.clickOnKycConsent();
    }
    public void handelPopups() throws InterruptedException {

        if (kycPage.isPermissionScreenVisible()) {

            // click allow on in app permission
            kycPage.clickOnPermissionScreen();

            // click on while using app
            kycPage.clickOnWhileUsingApp();

            // click on allow button
            kycPage.clickOnAllowButton();

            // click on allow button
            kycPage.clickOnAllowButton();

        }
    }
}
