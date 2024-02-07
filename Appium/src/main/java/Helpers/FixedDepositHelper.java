package Helpers;

import Logger.Log;
import PageObject.FixedDepositPage;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;


public class FixedDepositHelper {
    AndroidDriver<AndroidElement> driver;

    FixedDepositPage fixedDepositPage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;

    public FixedDepositHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        fixedDepositPage = new FixedDepositPage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbReporter = new MBReporter(driver);

    }

    /**
     * This method is to Test standalone Account aggregator flow from Wealth dashboard
     */

    public void existingUserHomePage(String exptitleViewInvestmentSummary,String exptitleTopPlans,String exptitleInterest,String exptitleTenure,String exptitleBook,String exptitleChooseCustomtenure,String exptitleFemale,String exptitleSeniorCitizen,String exptitleMaximizeYourFDReturn,String expttitleFAQ,String expctaContactUs) throws InterruptedException, IOException {

        fixedDepositPage.allServicesCTA();
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);

        fixedDepositPage.fixedDepositCTA();

        String titleViewInvestmentSummary = fixedDepositPage.getTitleViewInvestmetnSummary();
        String titleTopPlans = fixedDepositPage.getTitleTopPlans();
        String titleInterest = fixedDepositPage.getCTAInterest();
        String titleTenure = fixedDepositPage.getCTATenure();
        String titleBook = fixedDepositPage.getCTABook();


        Log.info("Verify For Existing user first paymenthistory title :" + titleViewInvestmentSummary);
        Log.info("Top Plans Title :" + titleViewInvestmentSummary);
        Log.info("Interest Title :" + titleInterest);
        Log.info("Tenure Title :" + titleTenure);
        Log.info("Book button CTA :" + titleBook);
        // Add assertions
        mbReporter.verifyEqualsWithLogging(titleViewInvestmentSummary, exptitleViewInvestmentSummary, "Verify For Existing user first paymenthistory text on home page", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleTopPlans, exptitleTopPlans, "Top Plans Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleInterest, exptitleInterest, "Title Interest", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleTenure, exptitleTenure, "Title Tenure", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleBook, exptitleBook, "Book button CTA", false, false, true);

        screen.swipeUpMore(driver);

        String titleChooseCustomtenure = fixedDepositPage.getCTAChooseCustomTenure();
        String titleSeniorCitizen = fixedDepositPage.getCTASeniorCitizen();
        String titleFemale = fixedDepositPage.getCTAFemale();

        Log.info("Choose custom tenure title :" + titleChooseCustomtenure);
        Log.info("Senior Citizen Title :" + titleSeniorCitizen);
        Log.info(" Female Title :" + titleFemale);

        mbReporter.verifyEqualsWithLogging(titleChooseCustomtenure, exptitleChooseCustomtenure, "Choose custom tenure title", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleSeniorCitizen, exptitleSeniorCitizen, "Senior Citizen Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleFemale, exptitleFemale, "Female Title", false, false, true);


        String titleMaximizeYourFDReturn = fixedDepositPage.getCTAMaximizeYourFD();
        Log.info("Choose maximize Your FD Return :" + titleMaximizeYourFDReturn);
        mbReporter.verifyEqualsWithLogging(titleMaximizeYourFDReturn, exptitleMaximizeYourFDReturn, "Choose maximize Your FD Return", false, false, true);
        screen.swipeUpMore(driver);
        String titleFAQ = fixedDepositPage.getCTAFAQ();
        Log.info("FAQ :" + titleFAQ);
        mbReporter.verifyEqualsWithLogging(titleFAQ, expttitleFAQ, "FAQ", false, false, true);

        screen.swipeUpMore(driver);
        String ctaContactUs = fixedDepositPage.getCTAContactUs();
        Log.info("Contact us :" + ctaContactUs);
        mbReporter.verifyEqualsWithLogging(ctaContactUs, expctaContactUs, "Contact Us", false, false, true);
        screen.swipeUpMore(driver);

    }


    public void fdBooking(String exptitleTenure,String exptitleAnnualYield,String exptitleInterestRate,String exptitleSelectDepositAmount) throws InterruptedException, IOException {

        fixedDepositPage.allServicesCTA();
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);

        Log.info("-----Fixed Deposit-----");

        fixedDepositPage.fixedDepositCTA();
        fixedDepositPage.bookCTA();

        String titleTenure = fixedDepositPage.getCTATenure();
        String titleAnnualYield=fixedDepositPage.getCTAAnnualYield();
        String titleInterestRate=fixedDepositPage.getCTAInterestRate();
        String titleSelectDepositAmount=fixedDepositPage.GetCTADepositAmount();


        Log.info("Title Interest :" + titleTenure);
        Log.info("Title Annual Yield :" + titleAnnualYield);
        Log.info("Title Interest Rate :" + titleInterestRate);
        Log.info("Title Select Deposit Amount :" + titleSelectDepositAmount);

        // Add assertions
        mbReporter.verifyEqualsWithLogging(titleTenure, exptitleTenure, "Tenure", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleAnnualYield, exptitleAnnualYield, "Title Annual Yield", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleInterestRate, exptitleInterestRate, "Title Interest Rate ", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleSelectDepositAmount, exptitleSelectDepositAmount, "Title Select Deposit Amount", false, false, true);

        //CTA click for next screen
        fixedDepositPage.ctaNext();

        //CTA click for next screen where payment page will come
        fixedDepositPage.ctaProceedToPay();

    }

    public void personaldetailsEdit() throws InterruptedException, IOException {

        fixedDepositPage.allServicesCTA();
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);

        Log.info("-----Fixed Deposit-----");

        //Click on Fixed deposit CTA
        fixedDepositPage.fixedDepositCTA();

        //Click on Book button on Fd home screen
        fixedDepositPage.bookCTA();

        //Click on Book next page on amount screen
        fixedDepositPage.ctaNext();

        Thread.sleep(3000);
        screen.swipeUpMore(driver);

        //Click on Edit cta on summary screen
        fixedDepositPage.ctaEdit();

        //Click on married field from form
        fixedDepositPage.ctaMarried();

        //Click on father's name field on  profile form page
        fixedDepositPage.ctafathername();

        //Enter fathers name field on  profile form page
        fixedDepositPage.enterFatherName("RajKishore");

        //Click on Educational field on  profile form page
        fixedDepositPage.ctaEducationQualification();

        //Select from dropdown  field on  profile form page for educationfield
        fixedDepositPage.dropdownPostGraduate();

        // For outer click on form page after filling the form
        fixedDepositPage.ctaMarried();

        //Click on Occupation field on  profile form page
        fixedDepositPage.ctaDropdownOccupationType();

        //Select Occupation field on  profile form page
        fixedDepositPage.ctaDropdownOccupationTypeSelect();

        // Click on  proceed page
        fixedDepositPage.ctaProceed();


    }

    public void nomineeEdit(String exptitleNomineeEditHeading,String exptitleNomineeNameonEditScreen,String exptitleRelationship,String exptitleDob,String exptitleAddress) throws InterruptedException, IOException {

        fixedDepositPage.allServicesCTA();
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);

        Log.info("-----Fixed Deposit-----");

        //Click on Fixed Deposit CTA
        fixedDepositPage.fixedDepositCTA();

        //Click on Book button on Fd home screen
        fixedDepositPage.bookCTA();

        //Click on Next button on Fd amount page
        fixedDepositPage.ctaNext();
        Thread.sleep(3000);
        screen.swipeUpMore(driver);

        //Click on Nominee name button on summary page
        fixedDepositPage.ctaNomineeName();

        //Click on first nominee page
        fixedDepositPage.clickEditNomineeFirstField();

        String titleNomineeEditHeading = fixedDepositPage.getctaNomineeDetailHeading();
        String titleNomineeNameonEditScreen=fixedDepositPage.getNomineeNameOnViewEdit();
        String titleRelationship=fixedDepositPage.getRelationship();
        String titleMobile=fixedDepositPage.getMobile();
        String titleDob=fixedDepositPage.getDob();
        String titleAddress=fixedDepositPage.getAddress();


        Log.info("Title Nominee Edit Heading :" + titleNomineeEditHeading);
        Log.info("Title Nominee Name on Edit Screen :" + titleNomineeNameonEditScreen);
        Log.info("Title Relationship :" + titleRelationship);
        Log.info("Title Mobile :" + titleMobile);
        Log.info("Title DOB :" + titleDob);
        Log.info("Title Address :" + titleAddress);

        // Add assertions
        mbReporter.verifyEqualsWithLogging(titleNomineeEditHeading, exptitleNomineeEditHeading, "Title Nominee Edit Heading", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleNomineeNameonEditScreen, exptitleNomineeNameonEditScreen, "Title Nominee Name on Edit Screen ", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleRelationship, exptitleRelationship, "Title Relationship ", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleDob, exptitleDob, "Title DOB", false, false, true);
        mbReporter.verifyEqualsWithLogging(titleAddress, exptitleAddress, "Title Address", false, false, true);
        fixedDepositPage.getEditOnNomineeDetails();

    }

}

