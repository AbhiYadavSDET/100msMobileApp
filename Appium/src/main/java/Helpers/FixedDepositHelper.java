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
       // screen.swipeUpMore(driver);

        String titleMaximizeYourFDReturn = fixedDepositPage.getCTAMaximizeYourFD();
        Log.info("Choose maximize Your FD Return :" + titleMaximizeYourFDReturn);
        mbReporter.verifyEqualsWithLogging(titleMaximizeYourFDReturn, exptitleMaximizeYourFDReturn, "Choose maximize Your FD Return", false, false, true);
        screen.swipeUpMore(driver);

        String titleFAQ = fixedDepositPage.getCTAFAQ();
        Log.info("FAQ :" + titleFAQ);
        mbReporter.verifyEqualsWithLogging(titleFAQ, expttitleFAQ, "FAQ", false, false, true);
        screen.swipeUpMore(driver);

        screen.swipeUpMore(driver);
        String ctaContactUs = fixedDepositPage.getCTAContactUs();
        Log.info("Contact us :" + ctaContactUs);
        mbReporter.verifyEqualsWithLogging(ctaContactUs, expctaContactUs, "Contact Us", false, false, true);


    }

}

