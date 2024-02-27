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
        kycPage.clickOnContinueButtonOnBoradingScreen();
        handelPopups();
        kycPage.setFirstName(firstName);
        kycPage.setLastName(lastName);
        kycPage.clickOnProceedAfterName();
        kycPage.setPanNumber(pan);
        kycPage.clickOnDateOption();
        kycPage.clickOnSelectDate();
        kycPage.clickOnKycConsent();

    }

    public void ErrorMessageOnNonKycFlow() throws InterruptedException, IOException {
        kycPage.clickOnContinueButtonOnBoradingScreen();
        handelPopups();
        kycPage.setFirstName("Abhishek123");
        kycPage.setLastName("Yadav123");
        kycPage.clickOnProceedAfterName();
        String error = kycPage.getNameErrorMessage();
        mbReporter.verifyEqualsWithLogging(error,"Please enter a valid name","Verifing error message on name",false,false);

        kycPage.setFirstNameWithErrorMessage("Abhishek");
        kycPage.setLastNameWithErrorMessage("Yadav123");
        kycPage.clickOnProceedAfterName();
        mbReporter.verifyEqualsWithLogging(error,"Please enter a valid name","Verifing error message on name",false,false);

        kycPage.setLastNameWithErrorMessage("Yadav");
        kycPage.clickOnProceedAfterName();

        kycPage.setPanNumber("HTIPKQWERT");
        kycPage.clickOnDateOption();
        kycPage.clickOnSelectDate();
        kycPage.clickOnKycConsent();

        kycPage.setPanNumberWithErrorMessage("HTIPK7865M");
    }


    public void fullKycFromCKYC() throws InterruptedException {

        // Full kyc from CKYC flow
        kycPage.clickOnBackButtonFromCompleteYourKycScreen();
        kycPage.clickOnCompleteUsingOtherOptions();
        kycPage.clickOnFetchFromCKYC();
        kycPage.setFirstName("Abhishek");
        kycPage.setLastName("yadav");
        kycPage.clickOnProceedAfterName();
        kycPage.setPanNumber("HTIPK7865K");
        kycPage.clickOnDateOption();
        kycPage.clickOnSelectDate();
        kycPage.clickOnKycConsent();

    }
    public void fullKycFromDigilocker(String firstFourDigits,String secondFourDigits,String lastFourDigits,String otp) throws InterruptedException {
     // Full kyc from Digi locker
        kycPage.clickOnBackButtonFromCompleteYourKycScreen();
        kycPage.clickOnCompleteUsingOtherOptions();
        kycPage.clickOnViaDigiLocker();
        Thread.sleep(2000);
        kycPage.setAdharCardFirstDigits(firstFourDigits);
      kycPage.setAdharCardSecondDigits(secondFourDigits);
      kycPage.setAdharCardThirdDigits(lastFourDigits);
      kycPage.clickOnNextButtonOnDigilocker();
      kycPage.setEnterOtpOnDigiLocker(otp);
    }

    public void fullKycFromAdharWebsite(String adharNumber, String securityCode) throws InterruptedException {
        // Full kyc from Adhaar website
        kycPage.clickOnBackButtonFromCompleteYourKycScreen();
        kycPage.clickOnCompleteUsingOtherOptions();
        kycPage.clickOnViaAadharWebsite();
        handelPopups();
        Thread.sleep(3000);
        kycPage.setAdharNumberOnAdharWebsite(adharNumber);
        kycPage.clickOnKycConsent();
        kycPage.clickOnArrowButtonOnAdhaarWebsite();
        kycPage.setSecurityCode(securityCode);
    }

    public void fullKycFromCKYCOnFailureFromAdhaarWebsite(String adharNumber, String securityCode,String firstName,String lastName,String pan) throws InterruptedException {

        // String Full kyc from Adhaar website
        kycPage.clickOnBackButtonFromCompleteYourKycScreen();
        kycPage.clickOnCompleteUsingOtherOptions();
        kycPage.clickOnViaAadharWebsite();
        handelPopups();
        Thread.sleep(3000);
        kycPage.setAdharNumberOnAdharWebsite(adharNumber);
        kycPage.clickOnKycConsent();
        kycPage.clickOnArrowButtonOnAdhaarWebsite();
        kycPage.setSecurityCode(securityCode);
        kycPage.clickOnArrowButtonOnAdhaarWebsite();
        kycPage.clickOkOnCaptcaFailure();

        // On failire from adhar website, user should  be redircted to CKYC flow
        kycPage.setFirstName(firstName);
        kycPage.setLastName(lastName);
        kycPage.clickOnProceedAfterName();
        kycPage.setPanNumber(pan);
        kycPage.clickOnDateOption();
        kycPage.clickOnSelectDate();
        kycPage.clickOnKycConsent();
    }
    public void handelPopups() throws InterruptedException {

        if (kycPage.isPermissionScreenVisible()) {
            kycPage.clickOnPermissionScreen();
            kycPage.clickOnWhileUsingApp();
            kycPage.clickOnAllowButton();
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
