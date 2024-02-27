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
        kycPage.setFirstName(firstName);
        kycPage.setLastName(lastName);
        kycPage.clickOnProceedAfterName();
        kycPage.setPanNumber(pan);
        kycPage.clickOnDateOption();
        kycPage.clickOnSelectDate();
        kycPage.clickOnKycConsent();

    }

    public void ErrorMessageOnNonKycFlow() throws InterruptedException, IOException {
        //Error message validation on full kyc flow from Onboarding
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

        // Full kyc VIA CKYC
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
     // Full kyc VIA Digi locker
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
        // Full kyc VIA Adhaar website
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

        // String Full kyc VIA Adhaar website
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

        // On failire VIA adhar website, user should  be redircted to CKYC flow
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
}
