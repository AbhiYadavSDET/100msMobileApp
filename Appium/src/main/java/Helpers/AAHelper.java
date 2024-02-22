package Helpers;

import Logger.Log;
import PageObject.AccountAggregatorPage;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;


public class AAHelper {
    AndroidDriver<AndroidElement> driver;


    AccountAggregatorPage aaPage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    //  mbReporter = new MBReporter(driver);
    //  mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    //     PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    //   PermissionPage permissionPage;


    public AAHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        aaPage = new AccountAggregatorPage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbReporter = new MBReporter(driver);

    }

    /**
     * This method is to Test standalone Account aggregator flow from Wealth dashboard
     */
    public void existingUser(String expTitleOnCategoryPage, String exptitleOfMonthlySummary, String expmainDashboardAnalyser, String expdashBoardHighlightTitle, String expaccountTitle, String expOutgoingTitleOnDashboard, String expOutgoingFirstSubTitleOnDashboard, String expOutgoingSecondSubTitleOnDashboard, String expOutgoingThirdSubTitleOnDashboard, String expoutgoingFourthSubTitleOnDashboard, String expsettingsTitle, String expdownloadStatementsTitle, String exphelpSupportTitle) throws InterruptedException, IOException {

        if (Element.isElementPresent(driver, By.id("tx_balance"))) {

            // Click on All services to see money plus icon
            aaPage.allServicesCTA();

            Log.info("START", "Account Aggregator");
            Log.info("AA flow for existing user");
            Log.info("-------------------------------------");

            // Swipe up for wealth dashboard
            screen.swipeUpMore(driver);
            screen.swipeUpMore(driver);

            if(!aaPage.checkTrackbankAccountsCTA())
            {
                screen.swipeUpMedium(driver);
            }

            // click on money plus icon
            aaPage.trackBankAccountsCTA();
            Thread.sleep(2000);

            // Verification on the Category Page
            String titleOnCategoryPage = aaPage.getTitle();
            Log.info("First Title On MainDashboard Page : " + expTitleOnCategoryPage);

            // Add the assertions
            mbReporter.verifyEqualsWithLogging(titleOnCategoryPage, expTitleOnCategoryPage, "Verify heading On Category Page", true, false, true);

            // Verification on the Category Page

            if (Element.isElementPresent(driver, By.xpath("//*[@text='OUTGOING']"))) {

                // Fetch the other text on the screen
                String outgoingTitleOnDashboard = aaPage.getOutgoingTitle();
                String outgoingFirstSubTitleOnDashboard = aaPage.getOutgoingFirstSubTitle();
                String outgoingSecondSubTitleOnDashboard = aaPage.getOutgoingSecondSubTitle();
                String outgoingThirdSubTitleOnDashboard = aaPage.getOutgoingThirdSubTitle();
                String outgoingFourthSubTitleOnDashboard = aaPage.getOutgoingFourthSubTitle();

                Log.info("OutGoing Title :" + outgoingTitleOnDashboard);
                Log.info("First Sub Title :" + outgoingFirstSubTitleOnDashboard);
                Log.info("Second Sub Title :" + outgoingSecondSubTitleOnDashboard);
                Log.info("Outgoing Third Subtitle On MainDashboard Page : " + expOutgoingThirdSubTitleOnDashboard);
                Log.info("Outgoing Fourth Subtitle On MainDashboard Page : " + expoutgoingFourthSubTitleOnDashboard);

                // Add assertions
                mbReporter.verifyEqualsWithLogging(outgoingTitleOnDashboard, expOutgoingTitleOnDashboard, "Verify Outgoing Title on MainDashboard", false, false, true);
                mbReporter.verifyEqualsWithLogging(outgoingFirstSubTitleOnDashboard, expOutgoingFirstSubTitleOnDashboard, "Verify First Outgoing SubTitle on MainDashboard", false, false, true);
                mbReporter.verifyEqualsWithLogging(outgoingSecondSubTitleOnDashboard, expOutgoingSecondSubTitleOnDashboard, "Verify Second Outgoing SubTitle on MainDashboard", false, false, true);
                mbReporter.verifyEqualsWithLogging(outgoingThirdSubTitleOnDashboard, expOutgoingThirdSubTitleOnDashboard, "Verify Third Outgoing SubTitle on MainDashboard", false, false, true);
                mbReporter.verifyEqualsWithLogging(outgoingFourthSubTitleOnDashboard, expoutgoingFourthSubTitleOnDashboard, "Verify Fourth Outgoing SubTitle on MainDashboard", false, false, true);

                mbReporter.verifyTrueWithLogging(aaPage.getMoneyTrf(), "Is Value Available", false, false);
                mbReporter.verifyTrueWithLogging(aaPage.getExpensesPercentage(), "Is Expense Value percentage Available", false, false);
                mbReporter.verifyTrueWithLogging(aaPage.getSipPercentage(), "Is Expense Value percentage Available", false, false);
                mbReporter.verifyTrueWithLogging(aaPage.getBankChargesPercentage(), "Is Expense Value percentage Available", false, false);

            }
            else {
                Log.info("Outgoing Data is not present");
            }

            // Add the assertions

            //If element is not present
            if(!aaPage.checkMonthlySummeryCTA()){
                screen.swipeUpMedium(driver);
            }
            String titleOfMonthlySummary = aaPage.getMonthlySummeryCTA();

           // String titleOfmainDashboardAnalyser = aaPage.mainDashboardAnalyserCTA();
            Log.info("Monthly summery text on MainDashboard : " + exptitleOfMonthlySummary);
            mbReporter.verifyEqualsWithLogging(titleOfMonthlySummary, exptitleOfMonthlySummary, "Verify Monthly summery title on dashboard", false, false, true);

            screen.swipeUpLess(driver);
            if(!aaPage.checkDashboardHighlightTitle()) {
                screen.swipeUpLess(driver);
            }
            String dashBoardHighlightTitle = aaPage.dashboardHighlightTitletext();
            Log.info("Highlight Title on MainDashboard : " + expdashBoardHighlightTitle);
            mbReporter.verifyEqualsWithLogging(dashBoardHighlightTitle, expdashBoardHighlightTitle, "Verify Highlight Title on Main Dashboardd", false, false, true);

            screen.swipeUpMore(driver);

            screen.swipeUpMore(driver);
//            if (aaPage.dashboardHighlightTitle() != null) {
//                screen.swipeUpMore(driver);
//            }

            String accounTTitle = aaPage.accountTitle();
            String settingsTitle = aaPage.settingsTitle();

            Log.info("Account Title on MainDashboard : " + expaccountTitle);
            Log.info("Setting Title on MainDashboard : " + expsettingsTitle);

            mbReporter.verifyEqualsWithLogging(accounTTitle, expaccountTitle, "Verify Account Title on MainDashboard", false, false, true);
            mbReporter.verifyEqualsWithLogging(settingsTitle, expsettingsTitle, "Verify Account settings Title on MainDashboard", false, false, true);

            screen.swipeUpMore(driver);

            String downloadStatementsTitle = aaPage.downloadStatementsTitle();
            String helpSupportTitle = aaPage.helpSupportTitle();

            Log.info("Download Statements Title on MainDashboard : " + expdownloadStatementsTitle);
            Log.info("Help Support Title on MainDashboard : " + exphelpSupportTitle);

            mbReporter.verifyEqualsWithLogging(downloadStatementsTitle, expdownloadStatementsTitle, "Verify Account Download Statements Title on MainDashboardd", false, false, true);
            mbReporter.verifyEqualsWithLogging(helpSupportTitle, exphelpSupportTitle, "help Support Title on MainDashboard", false, false, true);

        } else {
            //If user is logged out
            System.out.println("Not swipe up");
        }

    }

    //User Monthly Summery
    public void existingUserMonthlySummary(String expTitleLastmonthIncoming, String expTitleLastmonthOutgoing, String expTitleLastmonthinvested, String expTitleLastmonthRemaining, String expTitleLastmonthSpendbycayegoryOutgoing, String expExpensesSpendbycategory, String expSipEmiSpendbycategory, String expBankChargesSpendbycategory, String expOthersSpendbycategory, String expHighestSpendonMontlysummary, String expgetTopCategoryMontlysummary, String expSpenbyDatedonMontlysummary, String expMoneyReceived) throws InterruptedException, IOException {

        aaPage.allServicesCTA();

        int count = 0;

        while(!aaPage.checkTrackbankAccountsCTA() && count < 3){
            screen.swipeUpMore(driver);
            count++;
        }

        aaPage.trackBankAccountsCTA();
        Thread.sleep(2000);

        if (aaPage.isOutgoingTitlePresent()) {
            screen.swipeUpMore(driver);
        }
        else
        {
            aaPage.clickMonthlySummaryOnHomePage();
            Log.info("Click On Monthly Summary bar on Home Page : ");
            Thread.sleep(2000);

            mbReporter.verifyTrueWithLogging(aaPage.getCalender(), "Verify Monthly calender is present on monthly page", false, false);
            Thread.sleep(2000);
            mbReporter.verifyTrueWithLogging(aaPage.getIncomingOnMonthlySummary(), "Verify Incoming Value", false, false);

            String incomingtextOnMonthlySummary = aaPage.getIncomingtextOnMonthlySummary();
            String outgoingtextOnMonthlySummary = aaPage.getOutingtextOnMonthlySummary();

            Log.info("Incoming Title on monthly summary page: " + expTitleLastmonthIncoming);
            Log.info("Outgoing Title on monthly summary page: " + expTitleLastmonthOutgoing);

            mbReporter.verifyEqualsWithLogging(incomingtextOnMonthlySummary, expTitleLastmonthIncoming, "Incoming Title on monthly summary page:", false, true, true);
            mbReporter.verifyEqualsWithLogging(outgoingtextOnMonthlySummary, expTitleLastmonthOutgoing, "Outging Title on monthly summary page:", false, false, true);

            if (aaPage.IsInvestedtextOnMonthlySummaryVisible())
            {
                String investedtextOnMonthlySummary = aaPage.getInvestedtextOnMonthlySummary();

                Log.info("Invested Title on monthly summary page: " + expTitleLastmonthinvested);

                mbReporter.verifyEqualsWithLogging(investedtextOnMonthlySummary, expTitleLastmonthinvested, "Invested Title on monthly summary page:", false, true, true);
            }

            String remaingtextOnMonthlySummary = aaPage.getRemaingtextOnMonthlySummary();
            String outgoingtextOnMonthlySummarySpendbycategory = aaPage.getOutgoingtextOnMonthlySummarySpendbycategory();
            String expensesSpendbycategory = aaPage.getExpensesSpendbycategory();
            String sipEmiSpendbycategory = aaPage.getSipEmiSpendbycategory();
            String bankChargesSpendbycategory = aaPage.getBankChargesSpendbycategory();
            String otherssSpendbycategory = aaPage.getOthersSpendbycategory();

            Log.info("Remainging Title on monthly summary page: " + expTitleLastmonthRemaining);
            Log.info("Outing Title on monthly summary page Spend by category section: " + expTitleLastmonthSpendbycayegoryOutgoing);
            Log.info("Spend By category First title: " + expExpensesSpendbycategory);
            Log.info("Spend By category Second title: " + expSipEmiSpendbycategory);
            Log.info("Spend By category third title: " + expBankChargesSpendbycategory);
            Log.info("Spend By category fourth title: " + expOthersSpendbycategory);

            mbReporter.verifyEqualsWithLogging(remaingtextOnMonthlySummary, expTitleLastmonthRemaining, "Remaining Title on monthly summary page:", false, false, true);
            mbReporter.verifyEqualsWithLogging(outgoingtextOnMonthlySummarySpendbycategory, expTitleLastmonthSpendbycayegoryOutgoing, "Remaining Title on monthly summary page:", false, false, true);
            mbReporter.verifyEqualsWithLogging(expensesSpendbycategory, expExpensesSpendbycategory, "Spend By category First title", false, false, true);
            mbReporter.verifyEqualsWithLogging(sipEmiSpendbycategory, expSipEmiSpendbycategory, "Spend By category Second title:", false, false, true);
            mbReporter.verifyEqualsWithLogging(bankChargesSpendbycategory, expBankChargesSpendbycategory, "Spend By category third title:", false, false, true);
            mbReporter.verifyEqualsWithLogging(otherssSpendbycategory, expOthersSpendbycategory, "Spend By category fourth title:", false, false, true);

            screen.swipeUpMore(driver);

            String spendbyDatedonMontlysummary = aaPage.getSpenbyDatedonMontlysummary();
            String highestSpendonMontlysummary = aaPage.getHighestSpendonMontlysummary();
            String topCategoryMontlysummary = aaPage.getTopCategoryMontlysummary();

            Log.info("Spend By Date graph  title: " + expSpenbyDatedonMontlysummary);
            Log.info("Highest Spend card Title " + expHighestSpendonMontlysummary);
            Log.info("Top category on Monthly summary card title " + expgetTopCategoryMontlysummary);

            mbReporter.verifyEqualsWithLogging(spendbyDatedonMontlysummary, expSpenbyDatedonMontlysummary, "Spend By Date graph  title:", false, false, true);
            mbReporter.verifyEqualsWithLogging(highestSpendonMontlysummary, expHighestSpendonMontlysummary, "Highest Spend card Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(topCategoryMontlysummary, expgetTopCategoryMontlysummary, "Top category on Monthly summary card title ", false, false, true);

            screen.swipeUpMore(driver);

            String moneyReceivedMontlysummary = aaPage.getMoneyReceivedMontlysummary();

            Log.info("Monthly summary mONEY received" + expMoneyReceived);

            mbReporter.verifyEqualsWithLogging(moneyReceivedMontlysummary, expMoneyReceived, "Monthly summary mONEY received ", false, false, true);

        }
    }

    public void existingUserAnalyser(String expDebitText, String expCreditText, String expWeekText, String expMonthText, String expYearText, String expdebitedThisWeekText) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
//        screen.swipeUpMore(driver);
//        screen.swipeUpMore(driver);
        aaPage.trackBankAccountsCTA();
        Thread.sleep(2500);
        aaPage.clickonAnalyserOnAAHomePage();
        Log.info("Click On Analyser HomePage ");
        Thread.sleep(2000);

        screen.swipeUpMore(driver);

        String debitText = aaPage.getDebitText();
        String creditText = aaPage.getCreditText();
        String weekText = aaPage.getweekText();
        String monthText = aaPage.getMonthText();
        String yearText = aaPage.getYearText();
        String debitedThisWeekrText = aaPage.getdebitedthisweekText();

        Log.info("Debit text on Analyser screen " + expDebitText);
        Log.info("Credit text on Analyser screen " + expCreditText);
        Log.info("Week text on Analyser screen " + expWeekText);
        Log.info("Month text on Analyser screen " + expMonthText);
        Log.info("Year text on Analyser screen " + expYearText);
        Log.info("debited this week text on Analyser screen " + debitedThisWeekrText);

        mbReporter.verifyEqualsWithLogging(debitText, expDebitText, "Debit text on Analyser screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(creditText, expCreditText, "Credit text on Analyser screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(weekText, expWeekText, "Week text on Analyser screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(monthText, expMonthText, "Month text on Analyser screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(yearText, expYearText, "Year text on Analyser screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(debitedThisWeekrText, expdebitedThisWeekText, "debited this week text on Analyser screen", false, false, true);

    }

    public void existingUserManage(String expautoRefreshext, String expmanageConsentText, String exphelpText) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.trackBankAccountsCTA();
       /* screen.swipeUpMore(driver);

        if(!aaPage.checkSettingCta()) {
            screen.swipeUpMore(driver);
        }*/
        aaPage.scrollToSetting();
        aaPage.selectSetting();
       // Thread.sleep(2000);
        String autoRefreshext = aaPage.autoRefreshext();
        String manageConsentText = aaPage.manageConsentText();
        String helpText = aaPage.helpText();

        Log.info("AutorRefresh Frequency on Setting screen " + expautoRefreshext);
        Log.info("ManageConsent on Setting screen" + expmanageConsentText);
        Log.info("Help Text on Setting screen" + exphelpText);

        mbReporter.verifyEqualsWithLogging(autoRefreshext, expautoRefreshext, "Auto refresh Text on setting screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(manageConsentText, expmanageConsentText, "ManageConsent on Setting screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(helpText, exphelpText, "Help Text on Setting screen", false, false, true);
        aaPage.selectAutoRefreshext();
        aaPage.selectOutsideOfAutoRefresh();
        aaPage.clickManageConsent();
        aaPage.clickBackButtonOnManageConsentInside();
        aaPage.selectHelpOptn();
        aaPage.clickBackButtonOnManageConsentInside();
        Thread.sleep(1000);
        aaPage.clickBackButtonOnManageConsentInside();
        aaPage.selectDownloadStatement();

    }

    public void existingUserBankAccountDetails() throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        aaPage.trackBankAccountsCTA();
        screen.swipeUpMore(driver);

        if(!aaPage.savedBankAccount())
        {
            screen.swipeUpMore(driver);
        }
        aaPage.clickOnYourSavedBankAccount();
        Log.info("Click On Your saved Bank account ");
        List<AndroidElement> elements = Element.findElements(driver, By.id("txt_transaction_type"));
        int noOftransaction = elements.size();
        Log.info("no Of Transaction - " + noOftransaction);
        mbReporter.verifyTrueWithLogging(noOftransaction >= 0, "Verify No of transaction should be greater than or equal to 0", false, false);


    }


    public void addAccountNewScreen() throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollToAAOnHomeScreen();
        aaPage.clickOnAAOnHomeScreen();
        aaPage.scrollToAddAccountOnHomeScreen();
        aaPage.clickOnToAddAccountOnHomeScreen();
        aaPage.clickContinueOnbottomSheet();
        aaPage.enterBankDetail("HDFC");

    }



}

