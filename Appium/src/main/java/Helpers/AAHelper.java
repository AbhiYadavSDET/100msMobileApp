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


                Log.info("OutGoing Title :" + outgoingTitleOnDashboard);
                Log.info("First Sub Title :" + outgoingFirstSubTitleOnDashboard);
                Log.info("Second Sub Title :" + outgoingSecondSubTitleOnDashboard);


                // Add assertions
                mbReporter.verifyEqualsWithLogging(outgoingTitleOnDashboard, expOutgoingTitleOnDashboard, "Verify Outgoing Title on MainDashboard", false, false, true);
                mbReporter.verifyEqualsWithLogging(outgoingFirstSubTitleOnDashboard, expOutgoingFirstSubTitleOnDashboard, "Verify First Outgoing SubTitle on MainDashboard", false, false, true);
                mbReporter.verifyEqualsWithLogging(outgoingSecondSubTitleOnDashboard, expOutgoingSecondSubTitleOnDashboard, "Verify Second Outgoing SubTitle on MainDashboard", false, false, true);
            } else {
                Log.info("Out Going Data is bot present");
            }


            // Verification on the Category Page
            String outgoingFirstSubTitleOnDashboard = aaPage.getOutgoingFirstSubTitle();
            Log.info("Outgoing First Subtitle On MainDashboard Page : " + expOutgoingFirstSubTitleOnDashboard);
            // Add the assertions
            mbReporter.verifyEqualsWithLogging(outgoingFirstSubTitleOnDashboard, expOutgoingFirstSubTitleOnDashboard, "Verify First Outgoing SubTitle on MainDashboard", false, false, true);

            // Verification on the Category Page
            String outgoingSecondSubTitleOnDashboard = aaPage.getOutgoingSecondSubTitle();
            Log.info("Outgoing Second Subtitle On MainDashboard Page : " + expOutgoingSecondSubTitleOnDashboard);

            // Add the assertions
            mbReporter.verifyEqualsWithLogging(outgoingSecondSubTitleOnDashboard, expOutgoingSecondSubTitleOnDashboard, "Verify Second Outgoing SubTitle on MainDashboard", false, false, true);
            mbReporter.verifyTrueWithLogging(aaPage.getMoneyTrf(), "Is Value Available", false, false);

            mbReporter.verifyTrueWithLogging(aaPage.getExpensesPercentage(), "Is Expense Value percentage Available", false, false);

            mbReporter.verifyTrueWithLogging(aaPage.getSipePercentage(), "Is Expense Value percentage Available", false, false);

            mbReporter.verifyTrueWithLogging(aaPage.getBankChargesPercentage(), "Is Expense Value percentage Available", false, false);

            // Verification on the Category Page
            String outgoingThirdSubTitleOnDashboard = aaPage.getOutgoingThirdSubTitle();
            Log.info("Outgoing Third Subtitle On MainDashboard Page : " + expOutgoingThirdSubTitleOnDashboard);
            // Add the assertions
            mbReporter.verifyEqualsWithLogging(outgoingThirdSubTitleOnDashboard, expOutgoingThirdSubTitleOnDashboard, "Verify Third Outgoing SubTitle on MainDashboard", false, false, true);

            // Verification on the Category Page
            String outgoingFourthSubTitleOnDashboard = aaPage.getOutgoingFourthSubTitle();
            Log.info("Outgoing Fourth Subtitle On MainDashboard Page : " + expoutgoingFourthSubTitleOnDashboard);
            // Add the assertions
            String titleOfmainDashboardAnalyser = aaPage.mainDashboardAnalyserCTA();
            mbReporter.verifyEqualsWithLogging(outgoingFourthSubTitleOnDashboard, expoutgoingFourthSubTitleOnDashboard, "Verify Fourth Outgoing SubTitle on MainDashboard", false, false, true);

            screen.swipeUpMore(driver);

            String titleOfMonthlySummary = aaPage.getMonthlySummeryCTA();
            Log.info("Monthly summery text on MainDashboard : " + exptitleOfMonthlySummary);
            mbReporter.verifyEqualsWithLogging(titleOfMonthlySummary, exptitleOfMonthlySummary, "Verify Monthly summery title on dashboard", false, false, true);

            String dashBoardHighlightTitle = aaPage.dashboardHighlightTitle();
            Log.info("Highlight Title on MainDashboard : " + expdashBoardHighlightTitle);
            mbReporter.verifyEqualsWithLogging(dashBoardHighlightTitle, expdashBoardHighlightTitle, "Verify Highlight Title on Main Dashboardd", false, false, true);

            screen.swipeUpMore(driver);

            // screen.swipeUpMore(driver);
            if (aaPage.dashboardHighlightTitle() != null) {
                screen.swipeUpMore(driver);
            }
            String accounTTitle = aaPage.accountTitle();
            Log.info("Account Title on MainDashboard : " + expaccountTitle);
            mbReporter.verifyEqualsWithLogging(accounTTitle, expaccountTitle, "Verify Account Title on MainDashboard", false, false, true);

            String settingsTitle = aaPage.settingsTitle();
            Log.info("Setting Title on MainDashboard : " + expsettingsTitle);
            mbReporter.verifyEqualsWithLogging(settingsTitle, expsettingsTitle, "Verify Account settings Title on MainDashboard", false, false, true);

            screen.swipeUpMore(driver);
            String downloadStatementsTitle = aaPage.downloadStatementsTitle();
            Log.info("Download Statements Title on MainDashboard : " + expdownloadStatementsTitle);
            mbReporter.verifyEqualsWithLogging(downloadStatementsTitle, expdownloadStatementsTitle, "Verify Account Download Statements Title on MainDashboardd", false, false, true);

            String helpSupportTitle = aaPage.helpSupportTitle();
            Log.info("Help Support Title on MainDashboard : " + exphelpSupportTitle);
            mbReporter.verifyEqualsWithLogging(helpSupportTitle, exphelpSupportTitle, "help Support Title on MainDashboard", false, false, true);
        } else {
            //If user is logged out
            System.out.println("Login to continue");
        }

    }

    //User Monthly Summery
    public void existingUserMonthlySummary(String expTitleLastmonthIncoming, String expTitleLastmonthOutgoing, String expTitleLastmonthinvested, String expTitleLastmonthRemaining, String expTitleLastmonthSpendbycayegoryOutgoing, String expExpensesSpendbycategory, String expSipEmiSpendbycategory, String expBankChargesSpendbycategory, String expOthersSpendbycategory, String expHighestSpendonMontlysummary, String expgetTopCategoryMontlysummary, String expSpenbyDatedonMontlysummary, String expMoneyReceived) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        screen.swipeUpMore(driver);
        aaPage.trackBankAccountsCTA();
        Thread.sleep(2000);
        if (aaPage.isOutgoingTitlePresent()) {
            screen.swipeUpMore(driver);
        } else {
            aaPage.clickMonthlySummaryOnHomePage();
            Log.info("Click On Monthly Summary bar on Home Page : ");
            Thread.sleep(2000);
            mbReporter.verifyTrueWithLogging(aaPage.getCalender(), "Verify Monthly calender is present on monthly page", false, false);
            Thread.sleep(2000);
            mbReporter.verifyTrueWithLogging(aaPage.getIncomingOnMonthlySummary(), "Verify Incoming Value", false, false);

            String incomingtextOnMonthlySummary = aaPage.getIncomingtextOnMonthlySummary();
            Log.info("Incoming Title on monthly summary page: " + expTitleLastmonthIncoming);
            mbReporter.verifyEqualsWithLogging(incomingtextOnMonthlySummary, expTitleLastmonthIncoming, "Incoming Title on monthly summary page:", false, true, true);

            String outgoingtextOnMonthlySummary = aaPage.getOutingtextOnMonthlySummary();
            Log.info("Outgoing Title on monthly summary page: " + expTitleLastmonthOutgoing);
            mbReporter.verifyEqualsWithLogging(outgoingtextOnMonthlySummary, expTitleLastmonthOutgoing, "Outging Title on monthly summary page:", false, false, true);

            if (aaPage.IsInvestedtextOnMonthlySummaryVisible()) {
                String investedtextOnMonthlySummary = aaPage.getInvestedtextOnMonthlySummary();
                Log.info("Invested Title on monthly summary page: " + expTitleLastmonthinvested);
                mbReporter.verifyEqualsWithLogging(investedtextOnMonthlySummary, expTitleLastmonthinvested, "Invested Title on monthly summary page:", false, true, true);
            }
            String remaingtextOnMonthlySummary = aaPage.getRemaingtextOnMonthlySummary();
            Log.info("Remainging Title on monthly summary page: " + expTitleLastmonthRemaining);
            mbReporter.verifyEqualsWithLogging(remaingtextOnMonthlySummary, expTitleLastmonthRemaining, "Remaining Title on monthly summary page:", false, false, true);

            String outgoingtextOnMonthlySummarySpendbycategory = aaPage.getOutgoingtextOnMonthlySummarySpendbycategory();
            Log.info("Outing Title on monthly summary page Spend by category section: " + expTitleLastmonthSpendbycayegoryOutgoing);
            mbReporter.verifyEqualsWithLogging(outgoingtextOnMonthlySummarySpendbycategory, expTitleLastmonthSpendbycayegoryOutgoing, "Remaining Title on monthly summary page:", false, false, true);


            String expensesSpendbycategory = aaPage.getExpensesSpendbycategory();
            Log.info("Spend By category First title: " + expExpensesSpendbycategory);
            mbReporter.verifyEqualsWithLogging(expensesSpendbycategory, expExpensesSpendbycategory, "Spend By category First title", false, false, true);

            String sipEmiSpendbycategory = aaPage.getSipEmiSpendbycategory();
            Log.info("Spend By category Second title: " + expSipEmiSpendbycategory);
            mbReporter.verifyEqualsWithLogging(sipEmiSpendbycategory, expSipEmiSpendbycategory, "Spend By category Second title:", false, false, true);

            String bankChargesSpendbycategory = aaPage.getBankChargesSpendbycategory();
            Log.info("Spend By category third title: " + expBankChargesSpendbycategory);
            mbReporter.verifyEqualsWithLogging(bankChargesSpendbycategory, expBankChargesSpendbycategory, "Spend By category third title:", false, false, true);

            String otherssSpendbycategory = aaPage.getOthersSpendbycategory();
            Log.info("Spend By category fourth title: " + expOthersSpendbycategory);
            mbReporter.verifyEqualsWithLogging(otherssSpendbycategory, expOthersSpendbycategory, "Spend By category fourth title:", false, false, true);

            screen.swipeUpMore(driver);

            String spendbyDatedonMontlysummary = aaPage.getSpenbyDatedonMontlysummary();
            Log.info("Spend By Date graph  title: " + expSpenbyDatedonMontlysummary);
            mbReporter.verifyEqualsWithLogging(spendbyDatedonMontlysummary, expSpenbyDatedonMontlysummary, "Spend By Date graph  title:", false, false, true);

            String highestSpendonMontlysummary = aaPage.getHighestSpendonMontlysummary();
            Log.info("Highest Spend card Title " + expHighestSpendonMontlysummary);
            mbReporter.verifyEqualsWithLogging(highestSpendonMontlysummary, expHighestSpendonMontlysummary, "Highest Spend card Title", false, false, true);

            String topCategoryMontlysummary = aaPage.getTopCategoryMontlysummary();
            Log.info("Top category on Monthly summary card title " + expgetTopCategoryMontlysummary);
            mbReporter.verifyEqualsWithLogging(topCategoryMontlysummary, expgetTopCategoryMontlysummary, "Top category on Monthly summary card title ", false, false, true);

            screen.swipeUpMore(driver);

            String moneyReceivedMontlysummary = aaPage.getMoneyReceivedMontlysummary();
            Log.info("Monthly summary mONEY received" + expMoneyReceived);
            mbReporter.verifyEqualsWithLogging(moneyReceivedMontlysummary, expMoneyReceived, "Monthly summary mONEY received ", false, false, true);

        }
    }

    public void existingUserAnalyser(String expDebitText, String expCreditText, String expWeekText, String expMonthText, String expYearText, String expdebitedThisWeekText) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        screen.swipeUpMore(driver);
        aaPage.trackBankAccountsCTA();
        Thread.sleep(2500);
        aaPage.clickonAnalyserOnAAHomePage();
        Log.info("Click On Analyser HomePage ");
        Thread.sleep(2000);

        screen.swipeUpMore(driver);

        String debitText = aaPage.getDebitText();
        Log.info("Debit text on Analyser screen " + expDebitText);
        mbReporter.verifyEqualsWithLogging(debitText, expDebitText, "Debit text on Analyser screen", false, false, true);

        String creditText = aaPage.getCreditText();
        Log.info("Credit text on Analyser screen " + expCreditText);
        mbReporter.verifyEqualsWithLogging(creditText, expCreditText, "Credit text on Analyser screen", false, false, true);

        String weekText = aaPage.getweekText();
        Log.info("Week text on Analyser screen " + expWeekText);
        mbReporter.verifyEqualsWithLogging(weekText, expWeekText, "Week text on Analyser screen", false, false, true);

        String monthText = aaPage.getMonthText();
        Log.info("Month text on Analyser screen " + expMonthText);
        mbReporter.verifyEqualsWithLogging(monthText, expMonthText, "Month text on Analyser screen", false, false, true);

        String yearText = aaPage.getYearText();
        Log.info("Year text on Analyser screen " + expYearText);
        mbReporter.verifyEqualsWithLogging(yearText, expYearText, "Year text on Analyser screen", false, false, true);

        String debitedThisWeekrText = aaPage.getdebitedthisweekText();
        Log.info("debited this week text on Analyser screen " + debitedThisWeekrText);
        mbReporter.verifyEqualsWithLogging(debitedThisWeekrText, expdebitedThisWeekText, "debited this week text on Analyser screen", false, false, true);

    }

    public void existingUserManage(String expautoRefreshext, String expmanageConsentText, String exphelpText) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        screen.swipeUpMore(driver);
        aaPage.trackBankAccountsCTA();
        Thread.sleep(2000);
        screen.swipeUpMore(driver);
        aaPage.selectSetting();
        Thread.sleep(2000);
        String autoRefreshext = aaPage.autoRefreshext();
        Log.info("AutorRefresh Frequency on Setting screen " + expautoRefreshext);
        mbReporter.verifyEqualsWithLogging(autoRefreshext, expautoRefreshext, "Auto refresh Text on setting screen", false, false, true);

        String manageConsentText = aaPage.manageConsentText();
        Log.info("ManageConsent on Setting screen" + expmanageConsentText);
        mbReporter.verifyEqualsWithLogging(manageConsentText, expmanageConsentText, "ManageConsent on Setting screen", false, false, true);
        String helpText = aaPage.helpText();
        Log.info("Help Text on Setting screen" + exphelpText);
        mbReporter.verifyEqualsWithLogging(helpText, exphelpText, "Help Text on Setting screen", false, false, true);
        aaPage.selectAutoRefreshext();
        aaPage.selectOutsideOfAutoRefresh();
        //mbReporter.verifyTrueWithLogging(aaPage.getsnackbarAfterupdatingAutoupdatey(), "Verify snackbar is present", false,false);
        aaPage.clickManageConsent();
        aaPage.clickBackButtonOnManageConsentInside();
        aaPage.clickBackButtonOnManageConsentInside();
        aaPage.helpSupportTitleClick();
        aaPage.clickBackButtonOnManageConsentInside();
        aaPage.selectDownloadStatement();
        aaPage.clickDownload();

    }

    public void existingUserBankAccountDetails() throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        screen.swipeUpMore(driver);
        aaPage.trackBankAccountsCTA();
        Thread.sleep(2500);
        screen.swipeUpMore(driver);
        aaPage.clickOnYourSavedBankAccount();
        Log.info("Click On Your saved Bank account ");
        Thread.sleep(2500);
        List<AndroidElement> elements = Element.findElements(driver, By.id("txt_transaction_type"));
        int noOftransaction = elements.size();
        Log.info("no Of Transaction - " + noOftransaction);
        mbReporter.verifyTrueWithLogging(noOftransaction >= 0, "Verify No of transaction should be greater than or equalto 0", false, false);
        for (int i = 1; i < noOftransaction; i++) {
            //String leftDetails = element.findElement(driver, By.id("ts_cta")).getText();;
            // Log.info(leftDetails);
            Log.info(elements.get(i).getText());
        }

    }

}

