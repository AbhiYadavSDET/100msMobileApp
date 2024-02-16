package Helpers;

import Logger.Log;
import PageObject.InsurancePage;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class InsuranceHelper {

    AndroidDriver driver;
    InsurancePage insurancePage;
    Screen screen;
    MBReporter mbReporter;

    public InsuranceHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        insurancePage = new InsurancePage(driver);
        mbReporter = new MBReporter(driver);
    }

    public void insuranceHomePage(String expheaderTextInurance, String expsubheaderFirstTab, String expsubheaderSecondTab, String expheadingLossOfjob, String expheadingPersonalAccident, String expheadingWalletProtectInsurance, String expheadinggetHealthInsurance, String expheadingDocAssure, String expheadingPayyourPremium) throws InterruptedException, IOException {
        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();

        // Get Header for Insurance Home screen
        String headerTextInurance = insurancePage.getInsuranceText();

        // Get all Insurance Text on Insurance Home page
        String subheaderFirstTab = insurancePage.getHeadingGroupInsurance();
        String subheaderSecondTab = insurancePage.getSecondSubheaderRetailInsurance();
        String headingLossOfjob = insurancePage.getLossOfJob();
        String headingPersonalAccident = insurancePage.getPersonalAccidentInsurance();
        String headingWalletProtectInsurance = insurancePage.getWalletProtectInsurance();
        String headinggetHealthInsurance = insurancePage.getHealthInsurance();
        String headingDocAssure = insurancePage.getDocAssure();
        String headingPayyourPremium = insurancePage.getPayyourexistinginsurancePremium();

        // Display the values
        Log.info("First Top Header on Insurance Home Page : " + subheaderFirstTab);
        Log.info("First Subheader  on Insurance Home Page " + subheaderSecondTab);
        Log.info("Loss of Job" + headingLossOfjob);
        Log.info("Personal Accident" + headingPersonalAccident);
        Log.info("Heading Wallet Protect Insurance " + headingWalletProtectInsurance);
        Log.info("Heading Health Insurance" + headinggetHealthInsurance);
        Log.info("Heading Doc assure " + headingDocAssure);
        Log.info("Pay your existing Premium " + headingPayyourPremium);


        // Add the assertions
        mbReporter.verifyEqualsWithLogging(headerTextInurance, expheaderTextInurance, "First Top Header on Insurance Home Page", false, false, true);
        mbReporter.verifyEqualsWithLogging(subheaderFirstTab, expsubheaderFirstTab, "First Subheader  on Insurance Home Page Group Insurance", false, false, true);
        mbReporter.verifyEqualsWithLogging(subheaderSecondTab, expsubheaderSecondTab, "Retail insurance", false, false, true);
        mbReporter.verifyEqualsWithLogging(headingLossOfjob, expheadingLossOfjob, "Heading of Loss of Job", false, false, true);
        mbReporter.verifyEqualsWithLogging(headingPersonalAccident, expheadingPersonalAccident, "Heading Personal Accident ", false, false, true);
        mbReporter.verifyEqualsWithLogging(headingWalletProtectInsurance, expheadingWalletProtectInsurance, "Heading Wallet Protect", false, false, true);
        mbReporter.verifyEqualsWithLogging(headinggetHealthInsurance, expheadinggetHealthInsurance, "Health Insurance", false, false, true);
        mbReporter.verifyEqualsWithLogging(headingDocAssure, expheadingDocAssure, "Doc assure", false, false, true);
        mbReporter.verifyEqualsWithLogging(headingPayyourPremium, expheadingPayyourPremium, "Pay your existing Premium", false, false, true);

    }


    public void docAssureInsurance(String expheaderTextDocassure,String exptextselectSumInssured,String exptextproductBenifit,String exptextMarketValue,String exptextPartnerName,String exptextStartDate,String exptextEndDate,String exptextAmounttobePaid,String exptextpayableAmount) throws InterruptedException, IOException {
        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();
        insurancePage.clickOnDocAssureInsurance();

        // Get Header for Insurance Home screen
        String headerTextDocassure = insurancePage.getDocAssure();
        String textselectSumInssured = insurancePage.getSelectSumassured();
        String textproductBenifit = insurancePage.getProductBenifit();

        // Display the values
        Log.info("First Top Header on DocAssure : " + headerTextDocassure);
        Log.info("Text Sum Insured" + textselectSumInssured);
        Log.info("Product Benifit" + textproductBenifit);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(headerTextDocassure, expheaderTextDocassure, "First Top Header on Doc Assure", false, false, true);
        mbReporter.verifyEqualsWithLogging(textselectSumInssured, exptextselectSumInssured, "Sum Insured Text", false, false, true);
        mbReporter.verifyEqualsWithLogging(textproductBenifit, exptextproductBenifit, "Product Benifits", false, false, true);

        //Click on Sum Insured value
        insurancePage.clickOncheckBox();
        insurancePage.clickOnsumassuredbutton();

        String textMarketValue = insurancePage.getMarketValue();
        String textPartnerName = insurancePage.getPartnerName();
        String textStartDate = insurancePage.getStartDate();
        String textEndDate = insurancePage.getEndDate();
        String textAmounttobePaid = insurancePage.getAmounttobePaid();

        Log.info("Text Market Value : " + textMarketValue);
        Log.info("Text Partner Name" + textPartnerName);
        Log.info("Text Start Date" + textStartDate);
        Log.info("Text End Date" + textEndDate);
        Log.info("Text Amount to be Paid" + textAmounttobePaid);

        mbReporter.verifyEqualsWithLogging(textMarketValue, exptextMarketValue, "Text Market Value", false, false, true);
        mbReporter.verifyEqualsWithLogging(textPartnerName, exptextPartnerName, "Text Partner Name", false, false, true);
        mbReporter.verifyEqualsWithLogging(textStartDate, exptextStartDate, "Text Start Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textEndDate, exptextEndDate, "Text End Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textAmounttobePaid, exptextAmounttobePaid, "ext Amount to be Paid", false, false, true);

        //Click On Make Payment
        insurancePage.clickOnMakePayment();
        String textpayableAmount = insurancePage.getPayableAmount();

        Log.info("Text Payable Amount : " + textpayableAmount);
        mbReporter.verifyEqualsWithLogging(textpayableAmount, exptextpayableAmount, "Text Payable Amount", false, false, true);


    }

    public void walletProtectInsurance(String expheaderTextwalletProtect,String exptextselectSumInssured,String exptextproductBenifit,String exptextCoverage,String exptextInsuredBy,String  exptextStartDate,String exptextEndDate,String exptextAmounttobePaid,String exptextpayableAmount) throws InterruptedException, IOException {
        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();
        insurancePage.clickOnWalletProtectInsurance();

        // Get Header for Insurance Home screen
        String headerTextwalletProtect = insurancePage.getWalletProtectInsurance();
        String textselectSumInssured = insurancePage.getSelectSumassured();
        String textproductBenifit = insurancePage.getProductBenifit();

        // Display the values
        Log.info("First Top Header on DocAssure : " + headerTextwalletProtect);
        Log.info("Text Sum Insured" + textselectSumInssured);
        Log.info("Product Benifit" + textproductBenifit);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(headerTextwalletProtect, expheaderTextwalletProtect, "First Top Header Wallet Protect", false, false, true);
        mbReporter.verifyEqualsWithLogging(textselectSumInssured, exptextselectSumInssured, "Sum Insured Text", false, false, true);
        mbReporter.verifyEqualsWithLogging(textproductBenifit, exptextproductBenifit, "Product Benifits", false, false, true);

        //Click on Sum Insured value
        insurancePage.clickOncheckBox();
        insurancePage.clickOnsumassuredbutton();

        String textCoverage = insurancePage.getCoverage();
        String textInsuredBy = insurancePage.getInsuredBy();
        String textStartDate = insurancePage.getStartDate();
        String textEndDate = insurancePage.getEndDate();
        String textAmounttobePaid = insurancePage.getAmounttobePaid();

        Log.info("Text Coverage : " + textCoverage);
        Log.info("Text Partner Name" + textInsuredBy);
        Log.info("Text Start Date" + textStartDate);
        Log.info("Text End Date" + textEndDate);
        Log.info("Text Amount to be Paid" + textAmounttobePaid);

        mbReporter.verifyEqualsWithLogging(textCoverage, exptextCoverage, "Text Coverage", false, false, true);
        mbReporter.verifyEqualsWithLogging(textInsuredBy, exptextInsuredBy, "Text Insured By", false, false, true);
        mbReporter.verifyEqualsWithLogging(textStartDate, exptextStartDate, "Text Start Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textEndDate, exptextEndDate, "Text End Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textAmounttobePaid, exptextAmounttobePaid, "Text Amount to be Paid", false, false, true);

        //Click On Make Payment
        insurancePage.clickOnMakePayment();
        String textpayableAmount = insurancePage.getPayableAmount();

        Log.info("Text Payable Amount : " + textpayableAmount);
        mbReporter.verifyEqualsWithLogging(textpayableAmount, exptextpayableAmount, "Text Payable Amount", false, false, true);


    }



    public void hospicashInsurance(String expheaderTextHospicash,String exptextselectSumInssured,String exptextyourPolicyCovers,String exptextCoverage,String exptextInsuredBy,String  exptextStartDate,String exptextEndDate,String exptextAmounttobePaid,String exptextpayableAmount) throws InterruptedException, IOException {
        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();
        insurancePage.clickOnHealthInsuranceInsurance();
        insurancePage.clickOnHospicash();

        // Get Header for Insurance Home screen
        String headerTextHospicash = insurancePage.getHospicashText();
        String textselectSumInssured = insurancePage.getSelectSumassured();
        String textyourPolicyCovers = insurancePage.getyourPolicyCovers();

        // Display the values
        Log.info("First Top Header on Hospicash: " + headerTextHospicash);
        Log.info("Text Sum Insured" + textselectSumInssured);
        Log.info("Policy Covers" + textyourPolicyCovers);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(headerTextHospicash, expheaderTextHospicash, "First Top Header Hospicash", false, false, true);
        mbReporter.verifyEqualsWithLogging(textselectSumInssured, exptextselectSumInssured, "Sum Insured Text", false, false, true);
        mbReporter.verifyEqualsWithLogging(textyourPolicyCovers, exptextyourPolicyCovers, "Product Benifits", false, false, true);

        //Click on Sum Insured value
        insurancePage.clickOncheckBox();
        insurancePage.clickOnsumassuredbutton();

        String textCoverage = insurancePage.get30DaysCoveage();
        String textInsuredBy = insurancePage.getInsuredBy();
        String textStartDate = insurancePage.getStartDate();
        String textEndDate = insurancePage.getEndDate();
        String textAmounttobePaid = insurancePage.getAmounttobePaid();

        Log.info("Text Coverage : " + textCoverage);
        Log.info("Text Partner Name" + textInsuredBy);
        Log.info("Text Start Date" + textStartDate);
        Log.info("Text End Date" + textEndDate);
        Log.info("Text Amount to be Paid" + textAmounttobePaid);

        mbReporter.verifyEqualsWithLogging(textCoverage, exptextCoverage, "Text 30 days Coverage", false, false, true);
        mbReporter.verifyEqualsWithLogging(textInsuredBy, exptextInsuredBy, "Text Insured By", false, false, true);
        mbReporter.verifyEqualsWithLogging(textStartDate, exptextStartDate, "Text Start Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textEndDate, exptextEndDate, "Text End Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textAmounttobePaid, exptextAmounttobePaid, "Text Amount to be Paid", false, false, true);

        //Click On Make Payment
        insurancePage.clickOnMakePayment();
        String textpayableAmount = insurancePage.getPayableAmount();

        Log.info("Text Payable Amount : " + textpayableAmount);
        mbReporter.verifyEqualsWithLogging(textpayableAmount, exptextpayableAmount, "Text Payable Amount", false, false, true);


    }



    public void dengueInsurance(String expheaderTextDengue,String exptextselectSumInssured,String exptextInsuredBy,String  exptextStartDate,String exptextEndDate,String exptextAmounttobePaid,String exptextpayableAmount) throws InterruptedException, IOException {
        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();
        insurancePage.clickOnHealthInsuranceInsurance();
        insurancePage.clickOnDengue();

        // Get Header for Insurance Home screen
        String headerTextDengue = insurancePage.gettextDengue();
        String textselectSumInssured = insurancePage.getSelectSumassured();

        // Display the values
        Log.info("First Top Header on Dengue: " + headerTextDengue);
        Log.info("Text Sum Insured" + textselectSumInssured);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(headerTextDengue, expheaderTextDengue, "First Top Header Dengue", false, false, true);
        mbReporter.verifyEqualsWithLogging(textselectSumInssured, exptextselectSumInssured, "Sum Insured Text", false, false, true);
        //Click on Sum Insured value
        insurancePage.clickOncheckBox();
        insurancePage.clickOnsumassuredbutton();

        String textInsuredBy = insurancePage.getInsuredBy();
        String textStartDate = insurancePage.getStartDate();
        String textEndDate = insurancePage.getEndDate();
        String textAmounttobePaid = insurancePage.getAmounttobePaid();

        Log.info("Text Partner Name" + textInsuredBy);
        Log.info("Text Start Date" + textStartDate);
        Log.info("Text End Date" + textEndDate);
        Log.info("Text Amount to be Paid" + textAmounttobePaid);

        mbReporter.verifyEqualsWithLogging(textInsuredBy, exptextInsuredBy, "Text Insured By", false, false, true);
        mbReporter.verifyEqualsWithLogging(textStartDate, exptextStartDate, "Text Start Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textEndDate, exptextEndDate, "Text End Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textAmounttobePaid, exptextAmounttobePaid, "Text Amount to be Paid", false, false, true);

        //Click On Make Payment
        insurancePage.clickOnMakePayment();
        String textpayableAmount = insurancePage.getPayableAmount();

        Log.info("Text Payable Amount : " + textpayableAmount);
        mbReporter.verifyEqualsWithLogging(textpayableAmount, exptextpayableAmount, "Text Payable Amount", false, false, true);


    }


    public void communicableDisesInsurance(String expheaderTextCommunicableDises,String exptextselectSumInssured,String exptextInsuredBy,String  exptextStartDate,String exptextEndDate,String exptextAmounttobePaid,String exptextpayableAmount) throws InterruptedException, IOException {
        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();
        insurancePage.clickOnHealthInsuranceInsurance();
        screen.swipeUpMore(driver);

        insurancePage.clickOnCommunicableDisesInsurance();

        // Get Header for Insurance Home screen
        String headerTextCommunicableDises = insurancePage.getCommunicableDisesInsuranceText();
        String textselectSumInssured = insurancePage.getSelectSumassured();

        // Display the values
        Log.info("First Top Header on Communicable diseases: " + headerTextCommunicableDises);
        Log.info("Text Sum Insured" + textselectSumInssured);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(headerTextCommunicableDises, expheaderTextCommunicableDises, "First Top Header Communicable Diseases", false, false, true);
        mbReporter.verifyEqualsWithLogging(textselectSumInssured, exptextselectSumInssured, "Sum Insured Text", false, false, true);
        //Click on Sum Insured value
        insurancePage.clickOncheckBox();
        insurancePage.clickOnsumassuredbutton();

        String textInsuredBy = insurancePage.getInsuredBy();
        String textStartDate = insurancePage.getStartDate();
        String textEndDate = insurancePage.getEndDate();
        String textAmounttobePaid = insurancePage.getAmounttobePaid();

        Log.info("Text Partner Name" + textInsuredBy);
        Log.info("Text Start Date" + textStartDate);
        Log.info("Text End Date" + textEndDate);
        Log.info("Text Amount to be Paid" + textAmounttobePaid);

        mbReporter.verifyEqualsWithLogging(textInsuredBy, exptextInsuredBy, "Text Insured By", false, false, true);
        mbReporter.verifyEqualsWithLogging(textStartDate, exptextStartDate, "Text Start Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textEndDate, exptextEndDate, "Text End Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textAmounttobePaid, exptextAmounttobePaid, "Text Amount to be Paid", false, false, true);

        //Click On Make Payment
        insurancePage.clickOnMakePayment();
        String textpayableAmount = insurancePage.getPayableAmount();

        Log.info("Text Payable Amount : " + textpayableAmount);
        mbReporter.verifyEqualsWithLogging(textpayableAmount, exptextpayableAmount, "Text Payable Amount", false, false, true);


    }


    public void comprehensivePersonalAccidentInsurance(String expheaderTextPersonalAccident,String exptextselectSumInssured,String exptextInsuredBy,String  exptextStartDate,String exptextEndDate,String exptextAmounttobePaid,String exptextpayableAmount) throws InterruptedException, IOException {
        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();
        insurancePage.clickOnPersonalAccidentInsurance();
        insurancePage.clickComprehensivePersonalAccidentInsurance();


        // Get Header for Insurance Home screen
        String headerTextComprehensivePersonalAccident = insurancePage.getComprehensivePersonalAccidentInsurance();
        String textselectSumInssured = insurancePage.getSelectSumassured();

        // Display the values
        Log.info("First Top Header on Comprehensive Personal Accident: " + headerTextComprehensivePersonalAccident);
        Log.info("Text Sum Insured" + textselectSumInssured);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(headerTextComprehensivePersonalAccident, expheaderTextPersonalAccident, "First Top Header personal", false, false, true);
        mbReporter.verifyEqualsWithLogging(textselectSumInssured, exptextselectSumInssured, "Sum Insured Text", false, false, true);
        //Click on Sum Insured value
        insurancePage.clickOncheckBox();
        insurancePage.clickOnsumassuredbutton();

        String textInsuredBy = insurancePage.getInsuredBy();
        String textStartDate = insurancePage.getStartDate();
        String textEndDate = insurancePage.getEndDate();
        String textAmounttobePaid = insurancePage.getAmounttobePaid();

        Log.info("Text Partner Name" + textInsuredBy);
        Log.info("Text Start Date" + textStartDate);
        Log.info("Text End Date" + textEndDate);
        Log.info("Text Amount to be Paid" + textAmounttobePaid);

        mbReporter.verifyEqualsWithLogging(textInsuredBy, exptextInsuredBy, "Text Insured By", false, false, true);
        mbReporter.verifyEqualsWithLogging(textStartDate, exptextStartDate, "Text Start Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textEndDate, exptextEndDate, "Text End Date", false, false, true);
        mbReporter.verifyEqualsWithLogging(textAmounttobePaid, exptextAmounttobePaid, "Text Amount to be Paid", false, false, true);

        //Click On Make Payment
        insurancePage.clickOnMakePayment();
        String textpayableAmount = insurancePage.getPayableAmount();

        Log.info("Text Payable Amount : " + textpayableAmount);
        mbReporter.verifyEqualsWithLogging(textpayableAmount, exptextpayableAmount, "Text Payable Amount", false, false, true);


    }






}