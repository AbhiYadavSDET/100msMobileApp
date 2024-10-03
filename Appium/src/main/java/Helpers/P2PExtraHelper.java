package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.MbkCommonControlsPage;
import PageObject.P2PExtraPage;
import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import com.mongodb.annotations.NotThreadSafe;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.io.IOException;


public class P2PExtraHelper {

    AndroidDriver driver;
    HomePage homePage;
    P2PExtraPage p2PExtraPage;
    Screen screen;
    Element element;
    MBReporter mbReporter;
    MbkCommonControlsPage mbkCommonControlsPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;


    public P2PExtraHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        p2PExtraPage = new P2PExtraPage(driver);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);

    }

    public void withdraw(String amount, String expAmount, String expStatus, String expErrorMainTitle, String expErrorTitle, String expErrorAmount) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        if(p2PExtraPage.checkInfoPageHeading()){
            p2PExtraPage.clickGotIt();
        }

        //if(mbkCommonControlsPage.isWhitePopUpPresent()){ mbkCommonControlsPage.closeWhitePopUp(); }

        // Click on Got it to remove referral bottom sheet.
        //Thread.sleep(1000);
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

//        if (!p2PExtraPage.checkInvestMoreCta())
//
//            mbkCommonControlsHelper.pressback();
//
//        // Click on screen to remove bottom sheet.
//        // p2PExtraPage.tapOutsideBottomSheet();
//
//        // Printing portfolio values.
//        String portfolioValue = p2PExtraPage.getPortfolioValue();
////        String investedAmount = p2PExtraPage.getInvestedAmount();
////        String earnedAmount = p2PExtraPage.getEarnedAmount();
//        String perDayEarning = p2PExtraPage.getPerDayEarning();
//
//        Log.info("Portfolio Value : " + portfolioValue);
////        Log.info("Invested Amount : " + investedAmount);
////        Log.info("Earned Amount : " + earnedAmount);
//        Log.info("Per Day Earning : " + perDayEarning);
//
//        // If notification alerts are present, then swipe up
//        //if(p2PExtraPage.checkNotificationAlert()) screen.swipeUpMedium(driver);
//


        screen.swipeUpLess(driver);
    //   if ((!p2PExtraPage.checkWithdrawCta()) || p2PExtraPage.checkFixedInvestmentDesc()) {
    //    screen.swipeUpLess(driver);
    //    }

        // Click on withdraw on Xtra main page.
        p2PExtraPage.selectWithdraw();

        // Click on Got it to remove one time withdrawal bottom sheet.
        Thread.sleep(1000);
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on Got it to remove bank holiday bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Enter amount on withdrawal amount page.
        p2PExtraPage.enterAmount(amount);

        //Click on withdraw on withdrawal amount page.
        p2PExtraPage.selectWithdrawOnWithdrawAmount();

        //Click on Confirm CTA on the bottom sheet.
        p2PExtraPage.selectWithdrawOnBottomSheet();

        Thread.sleep(1000);

        // Checking pending withdrawal request bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) {

            // Add the assertions accordingly
            Log.info("You already have pending withdrawal request");

            String actualMainTitle = p2PExtraPage.getErrorMainTitle();
            String actualTitle = p2PExtraPage.getErrorTitle();
            String actualAmount = p2PExtraPage.getErrorAmount();

            Log.info("Error Main Title : " + actualMainTitle);
            Log.info("Error Main Title : " + actualTitle);
            Log.info("Error Main Title : " + actualAmount);

            mbReporter.verifyEqualsWithLogging(actualMainTitle, expErrorMainTitle, "Verify Error Main title", false, false, true);
            mbReporter.verifyEqualsWithLogging(actualTitle, expErrorTitle, "Verify Error Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(actualAmount, expErrorAmount, "Verify Error Amount", false, false, true);


        } else {

            // Verification on the Success Screen
            String actualAmount = p2PExtraPage.getWithdrawalAmount();
            String actualStatus = p2PExtraPage.getWithdrawalStatus();

            // Display the values
            Log.info("Withdrawal amount : " + actualAmount);
            Log.info("Withdrawal status : " + actualStatus);

            // Add the assertions
            mbReporter.verifyEqualsWithLogging(actualAmount, expAmount, "Verify Withdrawal amount", false, false, true);
            mbReporter.verifyEqualsWithLogging(actualStatus, expStatus, "Verify Withdrawal status", false, false, true);

        }


    }


    public void investInFlexi(String expTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("expTitle : " + expTitle);

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();


//        if (mbkCommonControlsPage.isWhitePopUpPresent()) {
//            mbkCommonControlsPage.closeWhitePopUp();
//        }

        Thread.sleep(1000);
        if(p2PExtraPage.checkInfoPageHeading()){
            p2PExtraPage.clickGotIt();
        }

        // Click on Got it to remove referral bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();

        //Click on tooltip of XTRA Plus If comes
//        Thread.sleep(1000);
//        if (p2PExtraPage.checkOkfromPlusPopUp()) p2PExtraPage.selectOkfromPlusPopUp();

        // CLick on Got it CTA on Borrower Mapping Report Bottomsheet
        p2PExtraPage.clickGotItCtaBorrowerMappingReport();

        // Click on the Tooltip
        if (p2PExtraPage.isselectOkfromPlusPopUp()) {
            p2PExtraPage.selectOkfromPlusPopUp();
        }

        if(!p2PExtraPage.checkNavbar()) {
           Log.info("Currently FLexi Investments are closed");
        }
        else {
            // Click Flexi from slider
            p2PExtraPage.selectFlexiFromNavBar();

            // CLick on Got it CTA on Borrower Mapping Report Bottomsheet
            //pkchanges p2PExtraPage.clickGotItCtaBorrowerMappingReport();

            // Used to click Invest Now btn on Xtra FLEXI amount page
            p2PExtraPage.selectInvestMore();

            // Select NetBanking from XTRA checkout screen
            p2PExtraPage.selectNBOnCheckoutScreen();
        }

    }

    public void investInFixed(String expTitle,String expectedAmount) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("expTitle : " + expTitle);

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        // Click on Got it to remove referral bottom sheet.
        Thread.sleep(1000);

        if(p2PExtraPage.checkInfoPageHeading()){
            p2PExtraPage.clickGotIt();
        }

        if (p2PExtraPage.isBottomSheetPresent())
        {
            p2PExtraPage.removeBottomSheet();
        }

        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();
/*
        // CLick on Got it CTA on Borrower Mapping Report Bottomsheet
        p2PExtraPage.clickGotItCtaBorrowerMappingReport();

        // Click on the Tooltip
        if (p2PExtraPage.isselectOkfromPlusPopUp()) {
            p2PExtraPage.selectOkfromPlusPopUp();
        }


        // Click Flexi from slider
        if(p2PExtraPage.checkNavbar()) {
            p2PExtraPage.selectFixedFromNavBar();
        }
  */


        //Click on Review & Pay Btn on Amount Summary Page
        p2PExtraPage.clickReviewPayBtn();

        String actualAmount = p2PExtraPage.getAmountOnSummaryPage();

        Log.info("Amount on Summary Screen : " + actualAmount);

        mbReporter.verifyEqualsWithLogging(actualAmount,expectedAmount,"Verify Amount",false,false,true);

        //p2PExtraPage.clickBorrowerPreferenceOnSummaryPage();

        //driver.navigate().back();

        String amountOnCTA = p2PExtraPage.getAmountOnCTA().substring(5);

        Log.info("Amount on Pay button: " + amountOnCTA);

        mbReporter.verifyEquals(actualAmount,amountOnCTA,"Check for the Amount on CTA",false,false);

        //Click Invest Now btn on Xtra FIXED amount page
        p2PExtraPage.clickPayBtn();

        // Select NetBanking from XTRA checkout screen
        if(p2PExtraPage.isNBOnCheckoutScreenPresent()) {
            mbReporter.verifyTrueWithLogging(p2PExtraPage.isNBOnCheckoutScreenPresent(),"Checking for NetBanking on Checkout",false,false);
            p2PExtraPage.selectNBOnCheckoutScreen();
        }


    }


    public void newUserFlow(String expTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("expTitle : " + expTitle);

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        // Click on Got it to remove referral bottom sheet.
        Thread.sleep(1000);
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        //Click on Get Started button on XTRA Pitch Page
        p2PExtraPage.selectGetStarted();

        //For NON-KYCED User Flow
        if (p2PExtraPage.isKYCBottomSheetPresent()) {

            String Kyc_status_title = p2PExtraPage.getKycBottomsheetTitle();
            Log.info("KYC STATUS : " + Kyc_status_title);

            // Add the assertions
            mbReporter.verifyEqualsWithLogging(Kyc_status_title, expTitle, "Verify New User Flow", false, false, true);

            //Click Proceed button on Complete KYC bottomsheet
            //p2PExtraPage.selectProceedKYC();

        }


    }


    public void referAndEarnFlow(String expTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        if (mbkCommonControlsPage.isWhitePopUpPresent()) {
            mbkCommonControlsPage.closeWhitePopUp();
        }

        // Click on Got it to remove referral bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        // Printing portfolio values.
        String portfolioValue = p2PExtraPage.getPortfolioValue();
        String perDayEarning = p2PExtraPage.getPerDayEarning();
        Log.info("Portfolio Value : " + portfolioValue);
        Log.info("Per Day Earning : " + perDayEarning);

        // If notification alerts are present, then swipe up
        if (p2PExtraPage.checkNotificationAlert() || p2PExtraPage.checkInvestContainer()) screen.swipeUpMedium(driver);

        //Swipe till Refer & Earn Widget
        screen.swipeUpMore(driver);

        // Check for more swipe if not visible
        if (!p2PExtraPage.checkReferralWidget()) screen.swipeUpLess(driver);

        // Click on Refer & earn Widget on XTRA dashboard
        p2PExtraPage.clickReferAndEarnWidget();

        //Swipe up complete on Total Earnings Page
        screen.swipeUpMore(driver);

        // Click on Earnings table
        p2PExtraPage.clickEarningsTable();

        //Swipe up complete on Referrals Page
        screen.swipeUpMore(driver);

        //Select Back button
        p2PExtraPage.selectBackBtn();

        String check_know_more_optn = p2PExtraPage.getKnowMoreOptn();

        Log.info("Text Check :" + check_know_more_optn);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(check_know_more_optn, expTitle, "Verify Refer & Earn Flow", false, false, true);


    }


    public void setDefaultBankAccountFlow(String expSubTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        if (mbkCommonControlsPage.isWhitePopUpPresent()) {
            mbkCommonControlsPage.closeWhitePopUp();
        }

        // Click on Got it to remove referral bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        if (!p2PExtraPage.checkSettingsOptn()) {
            //Swipe till the bottom | Settings Option
            screen.swipeUpMore(driver);
            screen.swipeUpMore(driver);
        }

        //Click on Settings option on XTRA dashboard
        p2PExtraPage.clickSettings();


        //If Default Bank Account is already setup
        //if(!p2PExtraPage.checkAddBankOptn())

        //Click on Default Bank Account
        p2PExtraPage.clickDefaultBankAccount();

        //Wait for 1 sec
        Thread.sleep(1000);

        String Title = p2PExtraPage.getDefaultBankAccTitle();

        Log.info("Title : " + Title);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(Title, expSubTitle, "Verify Title", false, false, true);

        // Click on cancel button to remove bottom sheet
        p2PExtraPage.clickCancelBtn();


    }


    public void setNomineeFlow(String expStatus, String expSubTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        if (mbkCommonControlsPage.isWhitePopUpPresent()) {
            mbkCommonControlsPage.closeWhitePopUp();
        }

        // Click on Got it to remove referral bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        if (!p2PExtraPage.checkSettingsOptn()) {
            //Swipe till the bottom | Settings Option
            screen.swipeUpMore(driver);
            screen.swipeUpMore(driver);
        }

        //Click on Settings option on XTRA dashboard
        p2PExtraPage.clickSettings();

        //Click on Add Nominee Option
        p2PExtraPage.clickAddNominee();

        //Wait for 2 seconds
        Thread.sleep(2000);

        String subTitle = p2PExtraPage.getNomineeTitle();

        Log.info("Sub-Title : " + subTitle);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Title", false, false, true);

        //Click on Back Button
        p2PExtraPage.clickBackBtn();

    }


    //User already added XTRA-Nominee
    public void checkNomineeDetailsFlow(String expStatus, String expName, String expSubTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        if (mbkCommonControlsPage.isWhitePopUpPresent()) {
            mbkCommonControlsPage.closeWhitePopUp();
        }

        // Click on Got it to remove referral bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        if (!p2PExtraPage.checkSettingsOptn()) {

            //Swipe till the bottom | Settings Option
            screen.swipeUpMore(driver);
            screen.swipeUpMore(driver);
        }

        //Click on Settings option on XTRA dashboard
        p2PExtraPage.clickSettings();

        //Click on Nominee Option
        p2PExtraPage.clickNominee();

        String subTitle = p2PExtraPage.getNomineeTitle();
        Log.info("Sub-Title : " + subTitle);
        String name = p2PExtraPage.getNomineeName();
        Log.info("Name of Nominee : " + name);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(name, expName, "Verify Title", false, false, true);


    }


    public void reinvestFixed(String expStatus1, String expStatus2) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");


        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        // If notification alerts are present, then swipe up
        // if(p2PExtraPage.checkNotificationAlert()) screen.swipeUpMore(driver);

        if(p2PExtraPage.checkInfoPageHeading()){
            p2PExtraPage.clickGotIt();
        }

        // Check for View All Button on the XTRA dashboard
        if (!p2PExtraPage.checkViewAllBtn()) {

            if (mbkCommonControlsPage.isWhitePopUpPresent()) {
                mbkCommonControlsPage.closeWhitePopUp();
            }

            // Click on Got it to remove referral bottom sheet.
            if (p2PExtraPage.isBottomSheetPresent()){
                p2PExtraPage.removeBottomSheet();
            }

            p2PExtraPage.scrollToViewAllBtn();
        }

        //Click on View All button
        p2PExtraPage.selectViewAllBtn();

        //Click on first fixed investment
        //p2PExtraPage.click1stFixedInvestment();

        // Click on First Investment
        p2PExtraPage.selectFirstInvestment();

        // Click on On-Maturity Option
        p2PExtraPage.selectMaturityOptn();

        //If User already selected reinvest while investing
        if (p2PExtraPage.checkReinvestBtn()) {

            //Click on Re-invest Option
            p2PExtraPage.selectReinvestBtn();

            //Wait for 1 second
            Thread.sleep(1000);

            //Change to Transfer to Bank Option
            p2PExtraPage.selectTransferToBankOption();

            //Wait for 1 second
            Thread.sleep(1000);

            String actualStatus1 = p2PExtraPage.getTransferToBankBtn();
            Log.info("Check text :" + actualStatus1);

            // Assertion
            mbReporter.verifyEqualsWithLogging(actualStatus1, expStatus1, "Verify Re-invest Fixed", false, false, true);


        } else {
            //If User already selected transfer to Flexi  while investing
            //Click on Transfer to Flexi Option
            p2PExtraPage.selectTransferToFlexiBtn();

            //Wait for 1 second
            Thread.sleep(1000);

            //Change to Reinvest option
            p2PExtraPage.selectReinvestoption();

            //Wait for 1 second
            Thread.sleep(1000);

            String actualStatus2 = p2PExtraPage.getReinvestoption();
            Log.info("Check text :");
            Log.info("Check text :" + actualStatus2);

            // Assertion
            mbReporter.verifyEqualsWithLogging(actualStatus2, expStatus2, "Verify Re-invest Fixed", false, false, true);


        }


    }


    public void reinvestFlexi(String Amount, String expText, String expStatus) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        if (mbkCommonControlsPage.isWhitePopUpPresent()) {
            mbkCommonControlsPage.closeWhitePopUp();
        }

        // Click on Got it to remove referral bottom sheet.
        //if(p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // If notification alerts are present, then swipe up
        //if(p2PExtraPage.checkNotificationAlert() || p2PExtraPage.checkInvestContainer()) screen.swipeUpMedium(driver);

        if (!p2PExtraPage.checkInvestMoreCta()) mbkCommonControlsHelper.pressback();

        // Check for Withdraw Cta on Flexi Card
       // if (!p2PExtraPage.checkWithdrawCta()) screen.swipeUpMedium(driver);

        // Check for Withdraw Cta on Flexi Card
        //if(!p2PExtraPage.checkWithdrawCta()) screen.swipeUpMedium(driver);

        //if (!p2PExtraPage.checkWithdrawCta() || p2PExtraPage.checkFixedInvestmentDesc()) {
        //    screen.swipeUpLess(driver);
        //}

        screen.swipeUpLess(driver);

        // Click on withdraw on Xtra main page.
        p2PExtraPage.selectWithdraw();

        // Click on Got it to remove one time withdrawal bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on Got it to remove bank holiday bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Enter amount on withdrawal amount page.
        p2PExtraPage.enterAmount(Amount);

        // Click on Transfer to Plus button if activates
        p2PExtraPage.selectTransferToPlusBtn();

        // Verification on the Success Screen
        String actualText = p2PExtraPage.getConfirmCtaText();

        Log.info("actualText :" + actualText);

        // Assertion
        mbReporter.verifyEqualsWithLogging(actualText, expText, "Verify Re-invested amount", false, false, true);


    }

    public void investInFixedErrorCase(String expTitle,String expErrormessage) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("expTitle : " + expTitle);

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        // Click on Got it to remove referral bottom sheet.
        Thread.sleep(1000);
        if (p2PExtraPage.isBottomSheetPresent()) {
            p2PExtraPage.removeBottomSheet();
        }

        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();

        // CLick on Got it CTA on Borrower Mapping Report Bottomsheet
        p2PExtraPage.clickGotItCtaBorrowerMappingReport();

        if (p2PExtraPage.isselectOkfromPlusPopUp()) {
            p2PExtraPage.selectOkfromPlusPopUp();
        }
      //  Thread.sleep(5000);
        p2PExtraPage.enterInvestmentAmount("1000000");

        String erorMessage = p2PExtraPage.getErrortextMessageOnAmountScreen();

        Log.info("Error message " + erorMessage);

        mbReporter.verifyEqualsWithLogging(erorMessage, expErrormessage, "Error message", false, false, true);

    }


    public void xtraLoanCreation(String expPortfoliotxt,String expnextRepaymenttxt,String expstatus,String expestimatedInterest) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");


        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();
        Element.waitForVisibility(driver, By.xpath("//*/android.widget.TextView[@text = 'History']"));

        if(p2PExtraPage.IsletterToInvestor()) {
            p2PExtraPage.letterToInvestor();
            p2PExtraPage.iUnderstand();
        }

        //Your Portfolio for invested users
        String portfoliotxt = p2PExtraPage.getPortfoliotxt();
        Log.info("Portfolio txt :" + portfoliotxt);

        //Next repayment txt
        String nextRepaymenttxt = p2PExtraPage.getnextRepaymenttxt();
        Log.info("next Repayment txt  :" + nextRepaymenttxt);

        // Assertion
        mbReporter.verifyEqualsWithLogging(portfoliotxt, expPortfoliotxt, "Portfolio txt", false, false, true);
        mbReporter.verifyEqualsWithLogging(nextRepaymenttxt, expnextRepaymenttxt, "Next repayment txt", false, false, true);

        //Click on first loan section
        p2PExtraPage.clickOnInvestedAmt();

       //Verify text on Perticular loan section when we click on any loan
        String status = p2PExtraPage.getStatus();
        Log.info("next Status txt  :" + status);

        String estimatedInterest = p2PExtraPage.getEstimatedInterest();
        Log.info("next estimated Interest txt  :" + estimatedInterest);
        // Assertion
        mbReporter.verifyEqualsWithLogging(status, expstatus, "status", false, false, true);
        mbReporter.verifyEqualsWithLogging(estimatedInterest, expestimatedInterest, "estimatedInterest", false, false, true);

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        p2PExtraPage.scrollToViewAllDisbursedLoan();
        p2PExtraPage.clickOnViewAllDisbursedLoan();

        mbReporter.verifyEqualsWithLogging(nextRepaymenttxt, expnextRepaymenttxt, "Next repayment txt", false, false, true);
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        p2PExtraPage.scrollToSetting();
        p2PExtraPage.clickonSetting();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        p2PExtraPage.scrollToReportAndStatement();
        p2PExtraPage.clickOnReportAndStatement();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

    }


    public void checkManageFlow(String expinterestCertificate, String exptransactionStatement) throws InterruptedException, IOException {

        Log.info("----------- Manage Section report and download  ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        //Click on Settings option on XTRA dashboard
       // p2PExtraPage.scrollToReportAndStatement();
        p2PExtraPage.scrollToFAQ();
        //cLICK ON REPORT AND STATEMENT ON XTRA HOME PAGE UNDER MANAGE
        p2PExtraPage.clickOnReportAndStatement();

        String interestCertificate = p2PExtraPage.getInterestCertificate();
        Log.info("interest Certificate : " + interestCertificate);

        // String transactionStatement = p2PExtraPage.getTransactionStatement();
       // Log.info("Transaction Statement : " + transactionStatement);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(interestCertificate, expinterestCertificate, "interest Certificate", false, false, true);
        //mbReporter.verifyEqualsWithLogging(transactionStatement, exptransactionStatement, "Transaction Statement", false, false, true);

        // select Interest certificate on Manage section
        p2PExtraPage.selectInterestCertificate();

        // select Fist date from financial year
        p2PExtraPage.selectDownload();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        p2PExtraPage.clickOnReportAndStatement();

        /*
        // select Transaction Statement on Manage section
        p2PExtraPage.selectTransactionStatement();

        //Seletc first duration on the bottomsheet of select duration
        p2PExtraPage.selectThisMonthStatement();
        */
    }


    public void settingFlow(String expSubTitleNominee, String expEmailTitle,String expPrimaryBankAccountTitle) throws InterruptedException, IOException {

        Log.info("----------- Manage Setting Flow ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.allServicesCTA();
        p2PExtraPage.scrollToXtra();
        p2PExtraPage.selectXtra();

        //Click on Settings option on XTRA dashboard
        p2PExtraPage.scrollToReportAndStatement();

        //Click on Settings option on XTRA dashboard
        p2PExtraPage.clickSettings();

        //Click on Add Nominee Option
        p2PExtraPage.clickNominee();

        //Wait for 2 seconds
        Thread.sleep(2000);

        //Nominee tititle on Setting screen
        String subTitleNominee = p2PExtraPage.getNomineeTitle();

        Log.info("Sub-Title : " + subTitleNominee);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(subTitleNominee, expSubTitleNominee, "Verify Title", false, false, true);

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        //Email title on Setting screen

        String emailTitle = p2PExtraPage.getEmailTitle();

        Log.info("emailTitle : " + emailTitle);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(emailTitle, expEmailTitle, "Verify Email Title", false, false, true);

        //Click on default bank account
        p2PExtraPage.clickDefaultBankAccount();

        //Primary Bank account title on Bottomsheet after clicking on default bank on setting screen

        String primaryBankAccountTitle = p2PExtraPage.getPrimaryBankAccountTitle();

        Log.info("primaryBankAccountTitle : " + primaryBankAccountTitle);

        mbReporter.verifyEqualsWithLogging(primaryBankAccountTitle, expPrimaryBankAccountTitle, "Verify primary Bank Account Title", false, false, true);

    }

}

