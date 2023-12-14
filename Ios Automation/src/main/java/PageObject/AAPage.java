package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class AAPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Track Bank Accounts\"]")
    private IOSElement trackBankAccounts;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"All Bank Balance\"]")
    private IOSElement title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OUTGOING\"]")
    private IOSElement outgoingTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Others\"]")
    private IOSElement outgoingFirstSubTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Expenses\"]")
    private IOSElement outgoingSecondSubTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIPs & EMIs\"]")
    private IOSElement outgoingThirdSubTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bank charges\"]")
    private IOSElement outgoingFourthSubTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your Monthly Summary\"]")
    private IOSElement yourMonthlySummery;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"YOUR ACCOUNTS\"]")
    private IOSElement accountTitle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings\"]")
    private IOSElement settingsTitle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Download Statements\"]")
    private IOSElement downloadStatementsTitle;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name=\"HIGHLIGHTS\"]")
    private IOSElement dashboardHighlightTitle;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name=\"Help & Support\"]")
    private IOSElement helpSupportTitle;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name=\"Your Monthly Summary\"]")
    private IOSElement clickonLastMonthBanner;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    private IOSElement calender;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name=\"Incoming\"]")
    private IOSElement incoming;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name=\"Incoming\"]")
    private IOSElement incomingonmonthlysummery;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name=\"Outgoing\"]")
    private IOSElement outgoingonmonthlysummery;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Invested\"]")
    private IOSElement investedonmonthlysummery;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remaining\"]")
    private IOSElement remainingonmonthlysummery;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Outgoing\"]")
    private IOSElement outgoingonSpendBycategory;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Others\"]")
    private IOSElement othersgonmonthlysummery;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Expenses\"]")
    private IOSElement expensesnmonthlysummery;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIPs & EMIs\"]")
    private IOSElement sIPsEMIsmonthlysummery;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bank charges\"]")
    private IOSElement bankChargesmonthlysummery;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Spends by Date\"]")
    private IOSElement spendsbyDateonmonthlysummery;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Highest Spend\"]")
    private IOSElement highestSpend;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Top Category\"]")
    private IOSElement topCategory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Analyser\"]")
    private IOSElement anayseronAAhomepage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"DEBITS\"]")
    private IOSElement debitTextOnAnlyser;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Credits\"]")
    private IOSElement creditTextOnAnlyser;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Debited this week\"]")
    private IOSElement debitedthisweekTextOnAnlyser;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Week\"]")
    private IOSElement weekTextOnAnlyser;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Month\"]")
    private IOSElement monthTextOnAnlyser;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Year\"]")
    private IOSElement yearTextOnAnlyser;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Money Received\"]")
    private IOSElement moneyReceived;
    public AAPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void trackBankAccountsCTA() { Elements.click(driver, trackBankAccounts, "Click on Track bank accounts");   }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Top Title");
    }

    public String getOutgoingTitle() throws InterruptedException {
        return Elements.getText(driver, outgoingTitle, "Outgoing Title");
    }

    public String getOutgoingFirstSubTitle() throws InterruptedException {
        return Elements.getText(driver, outgoingFirstSubTitle, "Outgoing first Subtitle");
    }

    public String getOutgoingSecondSubTitle() throws InterruptedException {
        return Elements.getText(driver, outgoingSecondSubTitle, "Outgoing Second Subtitle");
    }

    public String getOutgoingThirdSubTitle() throws InterruptedException {
        return Elements.getText(driver, outgoingThirdSubTitle, "Outgoing Third Subtitle");
    }
    public String getOutgoingFourthSubTitle() throws InterruptedException {
        return Elements.getText(driver, outgoingFourthSubTitle, "Outgoing Fourth Subtitle");
    }

    public String getMonthlySummeryCTA() throws InterruptedException {
        return Elements.getText(driver, yourMonthlySummery, "Monthly Summery text");
    }

    public Boolean checkMonthlySummeryCTA() throws InterruptedException {
        return  Elements.isElementPresent(driver, yourMonthlySummery);
    }

    public boolean checkDashboardHighlightTitle() throws InterruptedException {
        return Elements.isElementPresent(driver, dashboardHighlightTitle);
    }

    public String dashboardHighlightTitletext() throws InterruptedException {
        return Elements.getText(driver, dashboardHighlightTitle, "Dashboard Highlight Title Title");
    }

    public String accountTitle() throws InterruptedException {
        return Elements.getText(driver, accountTitle, "Dashboard Account Title");
    }
    public String settingsTitle() throws InterruptedException {
        return Elements.getText(driver, settingsTitle, "Dashboard Setting Title");
    }

    public String downloadStatementsTitle() throws InterruptedException {
        return Elements.getText(driver, downloadStatementsTitle, "Dashboard Download Title");
    }

    public String helpSupportTitle() throws InterruptedException {
        return Elements.getText(driver, helpSupportTitle, "Dashboard help Support Title");
    }

    public Boolean isOutgoingTitlePresent() throws InterruptedException {
        return Elements.isElementPresent(driver, outgoingTitle);
    }


    public void clickMonthlySummaryOnHomePage(){
        Elements.selectElement(driver, clickonLastMonthBanner, "Click Monthly summary bar on AA home Page");
    }

    public Boolean getCalender() throws InterruptedException {
        return Elements.isElementPresent(driver, calender);
    }


    public Boolean getIncomingOnMonthlySummary() throws InterruptedException {
        return Elements.isElementPresent(driver, incoming);
    }

    public String getIncomingtextOnMonthlySummary() throws InterruptedException {
        return Elements.getText(driver, incomingonmonthlysummery);
    }

    public String getOutingtextOnMonthlySummary() throws InterruptedException {
        return Elements.getText(driver, outgoingonmonthlysummery);
    }

    public Boolean IsInvestedtextOnMonthlySummaryVisible() throws InterruptedException {
        return Elements.isElementPresent(driver, investedonmonthlysummery);
    }

    public Boolean remaingtextOnMonthlySummary() throws InterruptedException {
        return Elements.isElementPresent(driver, remainingonmonthlysummery);
    }

    public String getInvestedtextOnMonthlySummary() throws InterruptedException {
        return Elements.getText(driver, investedonmonthlysummery);
    }

    public String getRemaingtextOnMonthlySummary() throws InterruptedException {
        return Elements.getText(driver, remainingonmonthlysummery);
    }
    public String getOthersSpendbycategory() throws InterruptedException {
        return Elements.getText(driver, othersgonmonthlysummery);
    }
    public String getOutgoingtextOnMonthlySummarySpendbycategory() throws InterruptedException {
        return Elements.getText(driver, outgoingonSpendBycategory);
    }


    public String getExpensesSpendbycategory() throws InterruptedException {
        return Elements.getText(driver, expensesnmonthlysummery);
    }

    public String getSipEmiSpendbycategory() throws InterruptedException {
        return Elements.getText(driver, sIPsEMIsmonthlysummery);
    }

    public String getBankChargesSpendbycategory() throws InterruptedException {
        return Elements.getText(driver, bankChargesmonthlysummery);
    }


    public String getSpenbyDatedonMontlysummary() throws InterruptedException {
        return Elements.getText(driver, spendsbyDateonmonthlysummery);
    }

    public String getHighestSpendonMontlysummary() throws InterruptedException {
        return Elements.getText(driver, highestSpend);
    }

    public String getTopCategoryMontlysummary() throws InterruptedException {
        return Elements.getText(driver, topCategory);
    }

    public String getMoneyReceivedMontlysummary() throws InterruptedException {
        return Elements.getText(driver, moneyReceived);
    }

    public void clickonAnalyserOnAAHomePage() throws InterruptedException{
        Elements.selectElement(driver,anayseronAAhomepage,"Click on Analyser");
    }

    public String getDebitText() throws InterruptedException {
        return Elements.getText(driver, debitTextOnAnlyser);
    }

    public String getCreditText() throws InterruptedException {
        return Elements.getText(driver, creditTextOnAnlyser);
    }

    public String getdebitedthisweekText() throws InterruptedException {
        return Elements.getText(driver, debitedthisweekTextOnAnlyser);
    }

    public String getweekText() throws InterruptedException {
        return Elements.getText(driver, weekTextOnAnlyser);
    }

    public String getMonthText() throws InterruptedException {
        return Elements.getText(driver, monthTextOnAnlyser);
    }

    public String getYearText() throws InterruptedException {
        return Elements.getText(driver, yearTextOnAnlyser);
    }

}
