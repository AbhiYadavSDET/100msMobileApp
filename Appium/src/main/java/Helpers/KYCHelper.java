package Helpers;

import Logger.Log;
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
    LoginHelper loginHelp;

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
        loginHelp = new LoginHelper(driver);
    }
    public void OnboardingFullKycFlow(String firstName, String lastName, String pan,String adhaarTweleveDigits,String captcha,boolean onlyCkyc) throws InterruptedException {

        // Full kyc flow from Onboarding
        kycPage.clickOnContinueButtonOnBoradingScreen();
        handelPopups();

        if(onlyCkyc) {

            if (!kycPage.isDigiLockerScreenOpened()) {

                Log.info("============ CKYC screen opened =======");

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
                Log.info("=======================CKYC test passed ======================== ");
            }
        }else{
            if(!kycPage.isDigiLockerScreenOpened()){

                Log.info("============ CKYC screen opened =======");

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

                kycPage.clickOkcontinueOnCkyc();
                Thread.sleep(3000);
            }else if(kycPage.isDigiLockerScreenOpened()){

                Log.info("============ Digilocker screen opened =======");
                kycPage.setAdharCard(adhaarTweleveDigits);
                kycPage.enterDigilockerCaptchaCode(captcha);

                // click on return to mobikwik
                kycPage.clickOnReturnToMobikwik();
                kycPage.clickOnYesReturnToMobikwik();

                kycPage.clickOkDigilockAcessNotProvided();

                Thread.sleep(5000);


                if( kycPage.isEkycScreenOpened()){

                    Log.info("===========Ekyc screen opened after failure from digilocker===========");
                }else{

                    for(int i =0;i<2;i++){
                        kycPage.clickOnRetryOnEkyc();
                        if(kycPage.isEkycScreenOpened()){
                            Log.info(("Ekyc screen opened after failure from digilocker after trying :"+i+2 + "time/s"));
                            break;
                        }else{
                            Log.info("=========== ISSUE - > Ekyc screen not opened after trying :"+i+2 + "time/s");
                        }
                    }
                }
            }
        }
    }



    public void ErrorMessageOnCKycFlow() throws InterruptedException, IOException {

        //Error message validation on full kyc flow from Onboarding

        // Click On Profile Button
        kycPage.clickOnProfileButton();

        Thread.sleep(2000);

        // Check CC Tool Tip Present
        if (kycPage.isCCToolTipPresent()) {
            screen.tapAtCentre(driver);
//            screen.tapAtCentre(driver);
        }

        // Click On Complete Your Kyc
        kycPage.clickOnCompleteYourKyc();

        //enter invalid last name
        kycPage.setFirstName("Abhishek123");

        // enter last name
        kycPage.setLastName("Yadav123");

        //click on proceed after entering name
        kycPage.clickOnProceedAfterName();
        String error = kycPage.getNameErrorMessage();
        mbReporter.verifyEqualsWithLogging(error, "Please enter a valid name", "Verifing error message on name", false, false);

        //Enter valid first name
        kycPage.setFirstNameWithErrorMessage("Abhishek");

        //enter invalid last name
        kycPage.setLastNameWithErrorMessage("Yadav123");
        kycPage.clickOnProceedAfterName();
        mbReporter.verifyEqualsWithLogging(error, "Please enter a valid name", "Verifing error message on name", false, false);

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

    public void profileMinKycFlow(String pan, String fullName, String expTitle, String expSubTitle, String expScreenText) throws InterruptedException, IOException {

        // Go to Home Page
        //   homePageLand();

        // Click On Profile Button
        kycPage.clickOnProfileButton();

        Thread.sleep(2000);

        // Check CC Tool Tip Present
        if (kycPage.isCCToolTipPresent()) {
            screen.tapAtCentre(driver);
//            screen.tapAtCentre(driver);
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


    public void profileFullKycFlow(String pan, String firstName, String lastName, String expTitle, String expSubTitle,String adhaarTweleveDigits,String captcha,boolean onlyCkyc) throws InterruptedException, IOException {

        // Click On Profile Button
        kycPage.clickOnProfileButton();

        Thread.sleep(2000);

        /* Check CC Tool Tip Present */
        if (kycPage.isCCToolTipPresent()) {
            screen.tapAtCentre(driver);

        }

        // Click On Complete Your Kyc
        kycPage.clickOnCompleteYourKyc();

        if(onlyCkyc) {

            if (!kycPage.isDigiLockerScreenOpened()) {

                Log.info("============ CKYC screen opened =======");

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
                Log.info("=======================CKYC test passed ======================== ");
            }
        }else{
            if(!kycPage.isDigiLockerScreenOpened()){

                Log.info("============ CKYC screen opened =======");

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

                kycPage.clickOkcontinueOnCkyc();
                Thread.sleep(3000);

            }else if
            (kycPage.isDigiLockerScreenOpened()){

                Log.info("============ Digilocker screen opened =======");
                kycPage.setAdharCard(adhaarTweleveDigits);
                kycPage.enterDigilockerCaptchaCode(captcha);

                // click on return to mobikwik
                kycPage.clickOnReturnToMobikwik();
                kycPage.clickOnYesReturnToMobikwik();

                kycPage.clickOkDigilockAcessNotProvided();

                Thread.sleep(5000);


                if( kycPage.isEkycScreenOpened()){

                    Log.info("===========Ekyc screen opened after failure from digilocker===========");
                }else{

                    for(int i =0;i<2;i++){
                        kycPage.clickOnRetryOnEkyc();
                        if(kycPage.isEkycScreenOpened()){
                            Log.info(("Ekyc screen opened after failure from digilocker after trying :"+i+2 +" "+ "time/s"));
                            break;
                        }else{
                            Log.info("=========== ISSUE - > Ekyc screen not opened after trying :"+i+2 +" "+ "time/s");
                        }
                    }
                }
            }
        }

    }


    public void homePageLand() throws InterruptedException {

        // Press Back
        mbkCommonControlsHelper.pressback();

        // Check Onboarding Pop Up Present
        if (kycPage.isOnboardingPopUpPresent()) kycPage.clickIDontWantBenefits();

        // Press Back
        mbkCommonControlsHelper.pressback();

        // Check Onboarding Pop Up Present
        if (kycPage.isOnboardingPopUpPresent()) kycPage.clickIDontWantBenefits();

        // Go to Home Page
        mbkCommonControlsHelper.handleHomePageLanding();
    }

    public void handelPopups() throws InterruptedException {

        if (kycPage.isPermissionScreenVisible()) {

            // click allow on in app permission
            kycPage.clickOnPermissionScreen();

            // click on while using app
        //    kycPage.clickOnWhileUsingApp();

            // click on allow button
            kycPage.clickOnAllowButton();

            // click on allow button
            kycPage.clickOnAllowButton();

        }
    }




}
