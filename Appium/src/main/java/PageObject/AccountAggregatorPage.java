package PageObject;

import Logger.Log;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountAggregatorPage {
    AndroidDriver driver;

    @AndroidFindBy(id="tx_balance")
    private AndroidElement userLoggedIn;

    @AndroidFindBy(xpath = "//*[@text = 'All Services']")
    private AndroidElement allServicesCTA;

    @AndroidFindBy(xpath = "//*[@text = 'Money +']")
    private AndroidElement moneyPlusCTA;

    @AndroidFindBy(xpath = "//*[@text = 'Track Bank Accounts']")
    private AndroidElement TrackBankAccountsCTA;

    @AndroidFindBy(xpath = "//*[@text = 'Track investments']")
    private AndroidElement trackInvestmentCTA;


    @AndroidFindBy(xpath = "//*[@text='Bank Accounts']")
    private AndroidElement accountAggregatorCard;

    @AndroidFindBy(id="touch_outside")
    private AndroidElement touchOutsideCTA;



    @AndroidFindBy(id="com.mobikwik_new.debug:id/icon_chevron")
    private AndroidElement AA_card;

    @AndroidFindBy(id="view_icon_bg")
    private AndroidElement checkCTA;

    @AndroidFindBy(xpath = "//*[@text = 'Refresh']")
    private AndroidElement refreshCTA;

    @AndroidFindBy(xpath = "//*[@text='Statement']" )
    private AndroidElement bankCard;

    @AndroidFindBy(xpath = "//*[@text='Filter']")
    private AndroidElement filterCTA;

    @AndroidFindBy(id="btnStatement")
    private AndroidElement downloadCTA;

    @AndroidFindBy(id="arrow_button")
    private AndroidElement bankDetailsCTA;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private AndroidElement get_MoneyTrfPercentage;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.view.ViewGroup[2]/android.widget.TextView[2]")
    private AndroidElement get_ExpensePercentage;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.view.ViewGroup[3]/android.widget.TextView[2]")
    private AndroidElement get_SipPercentage;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.view.ViewGroup[3]/android.widget.TextView[2]")
    private AndroidElement get_BankChargesPercentage;
    
    @AndroidFindBy(xpath = "//*[@text='Account Holder Name']")
    private AndroidElement userDetails;

    @AndroidFindBy(id="left_icon_filter")
    private AndroidElement applyFilter;

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_heading")
    private AndroidElement title;

    @AndroidFindBy(xpath = "//*[@text='OUTGOING']")
    private AndroidElement outgoingTitle;

    @AndroidFindBy(xpath = "//*[@text='Money Trf & Others']")
    private AndroidElement outgoingFirstSubTitle;

    @AndroidFindBy(xpath = "//*[@text='Expenses']")
    private AndroidElement outgoingSecondSubTitle;

    @AndroidFindBy(xpath = "//*[@text='SIPs & EMIs']")
    private AndroidElement outgoingThirdSubTitle;

    @AndroidFindBy(xpath = "//*[@text='Bank charges']")
    private AndroidElement outgoingFourthSubTitle;

    @AndroidFindBy(xpath = "//*[@text='Your Monthly Summary']")
    private AndroidElement yourMonthlySummery;

    @AndroidFindBy(id = "com.mobikwik_new:id/cta_text")
    private AndroidElement mainDashboardAnalyserCTA;

    @AndroidFindBy(xpath = "//*[@text='HIGHLIGHTS']")
    private AndroidElement dashboardHighlightTitle;

    @AndroidFindBy(xpath = "//*[@text='YOUR ACCOUNTS']")
    private AndroidElement accountTitle;

    @AndroidFindBy(xpath = "//*[@text='Add Account']")
    private AndroidElement addAccountTitle;

    @AndroidFindBy(xpath = "//*[@text='Settings']")
    private AndroidElement settingsTitle;

    @AndroidFindBy(xpath = "//*[@text='Download Statements']")
    private AndroidElement downloadStatementsTitle;

    @AndroidFindBy(xpath = "//*[@text='Help & Support']")
    private AndroidElement  helpSupportTitle;

    public AccountAggregatorPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("***** Account Aggregator *****");

    }

    public void userLoggedIn() throws InterruptedException{
        Elements.selectElement(driver,userLoggedIn, " Check if user is logged in");
    }
    public void allServicesCTA() throws InterruptedException{
        Elements.selectElement(driver,allServicesCTA,"Click on all services");
    }

    //for Entry from Money Plus icon in all services ----

    public void moneyPlusCTA() throws InterruptedException{
        Elements.selectElement(driver, moneyPlusCTA, "Click on money plus icon");
    }

    public void trackBankAccountsCTA() throws InterruptedException{
        Elements.selectElement(driver, TrackBankAccountsCTA, "Click on Track bank account lens icon");
    }

    //for Entry from track all investment cta ---
    public void trackInvestmentCTA() throws InterruptedException{
        Elements.selectElement(driver, trackInvestmentCTA, "Click on Track all your investment cta");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Base Title");
    }

    public Boolean getMoneyTrf() throws InterruptedException {
        int output= Integer.parseInt(Elements.getText(driver, get_MoneyTrfPercentage, "Money trf  percentge").replace("%",""));
        if(output>=0){
            Log.info(""+output+"");
            return true;
        }else {
            Log.info(""+output+"");
            return false;
        }
    }


    public Boolean getExpensesPercentage() throws InterruptedException {
        int output= Integer.parseInt(Elements.getText(driver, get_ExpensePercentage, "Expense pERCENTAGE").replace("%",""));
        if(output>=0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean getSipePercentage() throws InterruptedException {
        int output= Integer.parseInt(Elements.getText(driver, get_SipPercentage, "Sip Percentage").replace("%",""));
        if(output>=0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean getBankChargesPercentage() throws InterruptedException {
        int output= Integer.parseInt(Elements.getText(driver, get_BankChargesPercentage, "Sip Percentage").replace("%",""));
        if(output>=0){
            return true;
        }else {

            return false;
        }
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

    public String mainDashboardAnalyserCTA() throws InterruptedException {
        return Elements.getText(driver, mainDashboardAnalyserCTA, "Main Dashboard Analyser CTA");
    }

    public String dashboardHighlightTitle() throws InterruptedException {
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

    public String addAccountTitle() throws InterruptedException {
        return Elements.getText(driver, addAccountTitle, "Dashboard  add Account Title");
    }


    public void accountAggregatorCard()  throws InterruptedException{
        Elements.selectElement(driver, accountAggregatorCard, "Click on AA card in services section on Wealth dashboard");
    }

    public void touchOutsideCTA() throws InterruptedException{
        Elements.selectElement(driver,touchOutsideCTA, "Touch outside for closing the bottom sheet");
    }

    //for Entry from Wallet dropdown ----
    public void AA_card() throws InterruptedException {
        Elements.selectElement(driver, AA_card, "Click on AA Card in wallet dropdown");
    }

    public void checkCTA() throws InterruptedException {
        Elements.selectElement(driver, checkCTA, "Click on check cta AA Card in wallet dropdown");
    }


    public void refreshCTA() throws InterruptedException {
        Elements.selectElement(driver, refreshCTA, "Click on refresh cta");

    }

    public void bankCard() throws InterruptedException {
        Elements.selectElement(driver, bankCard, "Bank card CTA");
    }

    public void filterCTA() throws InterruptedException{
        Elements.selectElement(driver, filterCTA, "Filter cta");
    }

    public void downloadCTA() throws InterruptedException{
        Elements.selectElement(driver, downloadCTA, "Click on download cta");
    }


    public void userDetails() throws InterruptedException{Elements.selectElement(driver, userDetails, "Check the user details");}

    public void applyFilter() throws InterruptedException{Elements.selectElement(driver,applyFilter, "Apply filter");}
    public void bankDetailsCTA() throws InterruptedException{Elements.selectElement(driver,bankDetailsCTA, "Click on bank details cta");}

    public String getuserDetails() throws InterruptedException
    {
        return Elements.getText(driver, userDetails, "Check for the details");

    }
}




