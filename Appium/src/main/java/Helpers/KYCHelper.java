package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

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
        kycPage.setFirstName("Abhishek123");
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

    public void homePageLand() throws InterruptedException {

        // Press Back
        mbkCommonControlsHelper.pressback();

        // Check Onboarding Pop Up Present
        if(kycPage.isOnboardingPopUpPresent()) kycPage.clickIDontWantBenefits();

        // Press Back
        mbkCommonControlsHelper.pressback();

        // Check Onboarding Pop Up Present
        if(kycPage.isOnboardingPopUpPresent()) kycPage.clickIDontWantBenefits();

        // Go to Home Page
        mbkCommonControlsHelper.handleHomePageLanding();
    }

    public void profileMinKycFlow(String pan, String fullName, String expTitle, String expSubTitle, String expScreenText) throws InterruptedException, IOException {

        // Go to Home Page
        homePageLand();

        // Click On Profile Button
        kycPage.clickOnProfileButton();

        Thread.sleep(2000);

        // Check CC Tool Tip Present
        if(kycPage.isCCToolTipPresent()) {
            screen.tapAtCentre(driver);
            screen.tapAtCentre(driver);
        }

        // Click On Complete Your Kyc
        kycPage.clickOnCompleteYourKyc();

        // Click On Min Kyc
        kycPage.clickOnMinKyc();

        // Click On Pan Card
        kycPage.clickOnMinKycPanCard();


        // Verification on the Success Screen
        String title = kycPage.getMinKycScreenTitle();
        String subTitle = kycPage.getminKycScreenSubTitle();
        String screenText = kycPage.getMinKycScreenText();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Screen Text : " + screenText);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(screenText, expScreenText, "Verify Screen Text", false, false, true);

    }


    public void profileFullKycFlow(String pan, String aadhaar, String firstName, String lastName, String kycType, String userType, String expTitle, String expSubTitle) throws InterruptedException, IOException {

        // Go to Home Page
        homePageLand();

        // Click On Profile Button
        kycPage.clickOnProfileButton();

        Thread.sleep(2000);

        // Check CC Tool Tip Present
        if(kycPage.isCCToolTipPresent()) {
            screen.tapAtCentre(driver);
            screen.tapAtCentre(driver);
        }

        // Click On Complete Your Kyc
        kycPage.clickOnCompleteYourKyc();

        if(userType.equals("NOKYC")){
            // Click On Full Kyc
            kycPage.clickOnFullKyc();
        }

        // Verification on the Success Screen
        String title = kycPage.getProfileKycScreenTitle();
        String subTitle = kycPage.getProfileKycScreenSubTitle();
        String screenText = kycPage.getProfileKycScreenText();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Screen Text : " + screenText);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false, true);


        // select kyc Consent
        kycPage.clickOnKycConsent();

        if(kycType.equals("CKYC")){

            // Click Continue
            kycPage.clickPofileKycContinue();

            // Set First Name
            kycPage.setFirstName(firstName);

            // Set Last Name
            kycPage.setLastName(lastName);

            // Click On Proceed
            kycPage.clickOnProceedAfterName();

            // Set Pan
            kycPage.setPanNumber(pan);

            // click On Date
            kycPage.clickOnDateOption();

            // Select Date
            kycPage.clickOnSelectDate();

            // select kyc Consent
            kycPage.clickOnKycConsent();
        }
        else if(kycType.equals("OKYC")){

            // click Pofile Aadhaar
            kycPage.clickPofileAadhaar();

            // Click Continue
            kycPage.clickPofileKycContinue();

            // check Profile Aadhaar Pop up
            if(kycPage.isProfileAadhaarPopUpPresent()) kycPage.removeProfileAadhaarPopUp();

            Thread.sleep(3000);

            // Enter Aadhaar
            kycPage.enterProfileAadhaarTextBox(aadhaar);

            // Submit Aadhaar
            kycPage.clickPofileAadhaarSubmit();

            // Enter captcha
            kycPage.enterAadhaarCaptcha("gcysd");


        }
        else {

            // click Profile
            kycPage.clickPofileDigilocker();

            // Click Continue
            kycPage.clickPofileKycContinue();

            Thread.sleep(2000);

            // Set first four digits
            kycPage.setAdharCardFirstDigits(aadhaar.substring(0,4));

            // Set middle four digits
            kycPage.setAdharCardSecondDigits(aadhaar.substring(4,8));

            // Set last four digits
            kycPage.setAdharCardThirdDigits(aadhaar.substring(8,12));

            // click On Digilocker
            kycPage.clickOnNextButtonOnDigilocker();

            // set Otp
            kycPage.setEnterOtpOnDigiLocker("00000");
        }

    }

}
