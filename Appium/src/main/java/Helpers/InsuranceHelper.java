package Helpers;

import Logger.Log;
import PageObject.InsurancePage;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import com.beust.jcommander.internal.Lists;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.Dimension;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InsuranceHelper {

    AndroidDriver driver;
    InsurancePage insurancePage;
    Screen screen;
    Dimension dimension;
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

    public void lossOfJobInsurance(String expheaderTextLossOfJob,String exptextselectSumInssured,String exptextInsuredBy,String  exptextStartDate,String exptextEndDate,String exptextAmounttobePaid,String exptextpayableAmount) throws InterruptedException, IOException {
        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();
        insurancePage.clickOnLossOfJob();
        insurancePage.clickOndobfield();
        insurancePage.clickOnselectCTA();
        insurancePage.enterMonthlyGrossSalary("11000");
        insurancePage.enterNameOfCurrentOrganization("mobikwik");
        insurancePage.clickOnContinueButton();

        // Get Header for Insurance Home screen
        String headerTextLossOfJob = insurancePage.getLossOfJob();


        String textselectSumInssured = insurancePage.getSelectSumassured();

        // Display the values
        Log.info("First Top Header Loss Of job: " + headerTextLossOfJob);
        Log.info("Text Sum Insured" + textselectSumInssured);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(headerTextLossOfJob, expheaderTextLossOfJob, "First Top Header Loss Of job", false, false, true);
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

    }

    public void personalAccidentInsuranceBuy() throws InterruptedException, IOException {

        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();

        //click on Personal accident
        insurancePage.clickOnPersonalAccidentInsurance();

        //click on Personal accident compprehensive insurance
        insurancePage.clickComprehensivePersonalAccidentInsurance();


        insurancePage.clickOncheckBox();
        insurancePage.clickOnsumassuredbutton1();

        //Insufficent flow
        insurancePage.clickOnMakePayment();

    }

    public void mypolicyRefund(String exptextfullname,String exptextGender,String exptextphoneno,String exptextcongratulation,String exptextDownloadPolicy) throws InterruptedException, IOException {

        insurancePage.clickAllServices();
        insurancePage.scrollToInsurance();
        insurancePage.clickOnInsurance();
        insurancePage.clickOnPersonalAccidentInsurance();
        insurancePage.clickOnPersonalAccidentInsurancesubheading();


       if (insurancePage.isViewMorePresent())
        {

            String textcongratulation = insurancePage.gettextCongratulation();
            String textDownloadPolicy = insurancePage.gettextDownloadPolicy();


            Log.info("Text Congratulation" + textcongratulation);
            Log.info("Text Download Policy" + textDownloadPolicy);

            mbReporter.verifyEqualsWithLogging(textcongratulation, exptextcongratulation, "Text Congratulation", false, false, true);
            mbReporter.verifyEqualsWithLogging(textDownloadPolicy, exptextDownloadPolicy, "Text Download Policy", false, false, true);

            insurancePage.clickOnBackIcon();
            insurancePage.clickOnMyPolicies();
            insurancePage.clickonCancelPolicyOnHistory();

        }
        else
        {

            insurancePage.clickOncheckBox();
            insurancePage.clickOnsumassured20button();
            insurancePage.clickOnMakePayment();

            String textfullname = insurancePage.gettextfullName();
            String textGender = insurancePage.gettextSelectGender();
            String textphoneno = insurancePage.gettextPhoneNo();

            Log.info("Text full Name" + textfullname);
            Log.info("Text Gender" + textGender);
            Log.info("Text Phone No" + textphoneno);

            mbReporter.verifyEqualsWithLogging(textfullname, exptextfullname, "Text full Name", false, false, true);
            mbReporter.verifyEqualsWithLogging(textGender, exptextGender, "Text Gender", false, false, true);
            mbReporter.verifyEqualsWithLogging(textphoneno, exptextphoneno, "Text Phone No", false, false, true);
            insurancePage.clickOnCalender();

//            org.openqa.selenium.Dimension windowSize = driver.manage().window().getSize();
//            Map<String, Object> args = new HashMap<>();
//            args.put("command", "input");
//            args.put("args", Lists.newArrayList("swipe", windowSize.width / 2,
//                    windowSize.height / 2, windowSize.width / 2, windowSize.height));
//            while (driver.findElements(By.xpath("//android.widget.EditText[@text='2004']")).size() == 0) {
//
//                driver.executeScript("mobile: shell", args);
//            }
//            driver.findElement(By.xpath("//android.widget.EditText[@text='2004']")).click();

            insurancePage.clickOnselectCTA();
            insurancePage.scrollToContinueButton();
            insurancePage.clickOnContinueButtonOnFormPage();

            // Enter invalid age for error case
            insurancePage.enterOnNomineeAge("123");

            insurancePage.scrollToContinueButton();
            insurancePage.clickOnContinueButtonOnFormPage();
            insurancePage.clickOnselectCTA();
            insurancePage.scrollToContinueButton();
            insurancePage.clickOnContinueButtonOnFormPage();

            // Skip Nominee and continue
            insurancePage.clickOnskipNominee();
            insurancePage.clickOnGeneratePolicy();

            //Insurance Success screen

            String textcongratulation = insurancePage.gettextCongratulation();
            String textDownloadPolicy = insurancePage.gettextDownloadPolicy();

            Log.info("Text Congratulation" + textcongratulation);
            Log.info("Text Download Policy" + textDownloadPolicy);

            mbReporter.verifyEqualsWithLogging(textcongratulation, exptextcongratulation, "Text Congratulation", false, false, true);
            mbReporter.verifyEqualsWithLogging(textDownloadPolicy, exptextDownloadPolicy, "Text Download Policy", false, false, true);

            insurancePage.clickOnBackIcon();
            insurancePage.clickOnMyPolicies();
            insurancePage.clickonCancelPolicyOnHistory();
            Element.waitForVisibility(driver, By.id("i_agree"));
            insurancePage.clickOncheckBox();
            insurancePage.clickonCancelConfirmationYesPlease();

        }

    }



}