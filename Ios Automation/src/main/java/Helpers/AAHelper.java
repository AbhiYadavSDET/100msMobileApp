package Helpers;
import Utils.Element;
import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AAHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PermissionPage permissionPage;
    Screen screen;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    AAPage aaPage;
    MBReporter mbReporter;
    HistoryPage historyPage;

    public AAHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        //screen = new Screen(driver);
        homePage = new HomePage(driver);
        aaPage = new AAPage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        mbReporter = new MBReporter(driver);
        historyPage = new HistoryPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void aaExistingUserDashboard(String expTitleOnCategoryPage, String expOutgoingFirstSubTitleOnDashboard, String expOutgoingSecondSubTitleOnDashboard, String expOutgoingThirdSubTitleOnDashboard, String expoutgoingFourthSubTitleOnDashboard, String expOutgoingTitleOnDashboard, String exptitleOfMonthlySummary, String expdashBoardHighlightTitle, String expaccountTitle, String expsettingsTitle, String expdownloadStatementsTitle, String exphelpSupportTitle) throws InterruptedException, IOException {

        //Click Recharge and Pay Bills option
        homePage.clickAllServices();

        Screen.swipeUpMoreios(driver);

        Thread.sleep(2800);
        // click on money plus icon
        aaPage.trackBankAccountsCTA();
        Thread.sleep(2000);

        // Verification on the Category Page
        String titleOnCategoryPage = aaPage.getTitle();
        Log.info("First Title On MainDashboard Page : " + expTitleOnCategoryPage);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(titleOnCategoryPage, expTitleOnCategoryPage, "Verify heading On Category Page", true, false, true);

        if (Element.isElementPresent(driver, By.xpath("//XCUIElementTypeStaticText[@name=\"OUTGOING\"]"))) {

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

            //mbReporter.verifyTrueWithLogging(aaPage.getMoneyTrf(), "Is Value Available", false, false);
            //mbReporter.verifyTrueWithLogging(aaPage.getExpensesPercentage(), "Is Expense Value percentage Available", false, false);
            //mbReporter.verifyTrueWithLogging(aaPage.getSipPercentage(), "Is Expense Value percentage Available", false, false);
            // mbReporter.verifyTrueWithLogging(aaPage.getBankChargesPercentage(), "Is Expense Value percentage Available", false, false);

        } else {
            Log.info("Outgoing Data is not present");
        }


        //If element is not present
        if (!aaPage.checkMonthlySummeryCTA()) {
            screen.swipeUpMoreios(driver);
        }
        String titleOfMonthlySummary = aaPage.getMonthlySummeryCTA();

        // String titleOfmainDashboardAnalyser = aaPage.mainDashboardAnalyserCTA();
        Log.info("Monthly summery text on MainDashboard : " + exptitleOfMonthlySummary);
        mbReporter.verifyEqualsWithLogging(titleOfMonthlySummary, exptitleOfMonthlySummary, "Verify Monthly summery title on dashboard", false, false, true);

        //  screen.swipeUpMoreios(driver);
        if (!aaPage.checkDashboardHighlightTitle()) {
            screen.swipeUpMoreios(driver);
        }
        String dashBoardHighlightTitle = aaPage.dashboardHighlightTitletext();
        Log.info("Highlight Title on MainDashboard : " + expdashBoardHighlightTitle);
        mbReporter.verifyEqualsWithLogging(dashBoardHighlightTitle, expdashBoardHighlightTitle, "Verify Highlight Title on Main Dashboardd", false, false, true);

        //Screen.swipeUpMoreios(driver);

        //Screen.swipeUpMoreios(driver);
//            if (aaPage.dashboardHighlightTitle() != null) {
//                screen.swipeUpMore(driver);
//            }

        String accounTTitle = aaPage.accountTitle();
        String settingsTitle = aaPage.settingsTitle();

        Log.info("Account Title on MainDashboard : " + expaccountTitle);
        Log.info("Setting Title on MainDashboard : " + expsettingsTitle);

        mbReporter.verifyEqualsWithLogging(accounTTitle, expaccountTitle, "Verify Account Title on MainDashboard", false, false, true);
        mbReporter.verifyEqualsWithLogging(settingsTitle, expsettingsTitle, "Verify Account settings Title on MainDashboard", false, false, true);

        // Screen.swipeUpMoreios(driver);

        String downloadStatementsTitle = aaPage.downloadStatementsTitle();
        String helpSupportTitle = aaPage.helpSupportTitle();

        Log.info("Download Statements Title on MainDashboard : " + expdownloadStatementsTitle);
        Log.info("Help Support Title on MainDashboard : " + exphelpSupportTitle);

        mbReporter.verifyEqualsWithLogging(downloadStatementsTitle, expdownloadStatementsTitle, "Verify Account Download Statements Title on MainDashboardd", false, false, true);
        mbReporter.verifyEqualsWithLogging(helpSupportTitle, exphelpSupportTitle, "help Support Title on MainDashboard", false, false, true);

    }

    public void existingUserMonthlySummary(String expTitleLastmonthIncoming, String expTitleLastmonthOutgoing, String expTitleLastmonthinvested, String expTitleLastmonthRemaining, String expTitleLastmonthSpendbycayegoryOutgoing, String expExpensesSpendbycategory, String expSipEmiSpendbycategory, String expBankChargesSpendbycategory, String expOthersSpendbycategory, String expHighestSpendonMontlysummary, String expgetTopCategoryMontlysummary, String expSpenbyDatedonMontlysummary, String expMoneyReceived) throws InterruptedException, IOException {

        homePage.clickAllServices();

        Screen.swipeUpMoreios(driver);

        Thread.sleep(2800);
        // click on money plus icon
        aaPage.trackBankAccountsCTA();
        Thread.sleep(2000);


            aaPage.clickMonthlySummaryOnHomePage();
            Log.info("Click On Monthly Summary bar on Home Page : ");
            Thread.sleep(2000);

            mbReporter.verifyTrueWithLogging(aaPage.getCalender(), "Verify Monthly calender is present on monthly page", false, false);
            Thread.sleep(2000);
            mbReporter.verifyTrueWithLogging(aaPage.getIncomingOnMonthlySummary(), "Verify Incoming Value", false, false);
             //nite incoming monthly value xpath is not correct
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

           // screen.swipeUpMore(driver);

            String spendbyDatedonMontlysummary = aaPage.getSpenbyDatedonMontlysummary();
            String highestSpendonMontlysummary = aaPage.getHighestSpendonMontlysummary();
            String topCategoryMontlysummary = aaPage.getTopCategoryMontlysummary();

            Log.info("Spend By Date graph  title: " + expSpenbyDatedonMontlysummary);
            Log.info("Highest Spend card Title " + expHighestSpendonMontlysummary);
            Log.info("Top category on Monthly summary card title " + expgetTopCategoryMontlysummary);

            mbReporter.verifyEqualsWithLogging(spendbyDatedonMontlysummary, expSpenbyDatedonMontlysummary, "Spend By Date graph  title:", false, false, true);
            mbReporter.verifyEqualsWithLogging(highestSpendonMontlysummary, expHighestSpendonMontlysummary, "Highest Spend card Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(topCategoryMontlysummary, expgetTopCategoryMontlysummary, "Top category on Monthly summary card title ", false, false, true);

           // screen.swipeUpMore(driver);

            String moneyReceivedMontlysummary = aaPage.getMoneyReceivedMontlysummary();

            Log.info("Monthly summary mONEY received" + expMoneyReceived);

            mbReporter.verifyEqualsWithLogging(moneyReceivedMontlysummary, expMoneyReceived, "Monthly summary mONEY received ", false, false, true);

        }
    }




