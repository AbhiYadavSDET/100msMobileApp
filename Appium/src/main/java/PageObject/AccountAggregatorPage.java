package PageObject;

import Logger.Log;
import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountAggregatorPage {
    AndroidDriver driver;

    @AndroidFindBy(id="tx_balance")
    private AndroidElement userLoggedIn;

    @AndroidFindBy(id="btn_continue")
    private AndroidElement continue_cta_newbootsheet;

    @AndroidFindBy(xpath = "//*[@text = 'All Services']")
    private AndroidElement allServicesCTA;

    @AndroidFindBy(xpath = "//*[@text = 'Money +']")
    private AndroidElement moneyPlusCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Track Bank Accounts')]")
    private AndroidElement TrackBankAccountsCTA;

    @AndroidFindBy(xpath = "//*[@text = 'Track investments']")
    private AndroidElement trackInvestmentCTA;


    @AndroidFindBy(xpath = "//*[@text='Bank Accounts']")
    private AndroidElement accountAggregatorCard;

    @AndroidFindBy(id="touch_outside")
    private AndroidElement touchOutsideCTA;

    @AndroidFindBy(id="icon_chevron")
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

    @AndroidFindBy(id = "txt_heading")
    private AndroidElement title;

    @AndroidFindBy(id = "tv_month_filter")
    private AndroidElement calender;

    @AndroidFindBy(id = "incoming_amount")
    private AndroidElement incoming;

    @AndroidFindBy(xpath = "//*[@text='MONEY OUT']")
    private AndroidElement moneyOutTitle;

    @AndroidFindBy(xpath = "//*[@text='Cashflow']")
    private AndroidElement cashFlow;

    @AndroidFindBy(id = "ll_root")
    private AndroidElement tooltip_search;

    @AndroidFindBy(xpath = "//*[@text='EMI']")
    private AndroidElement outgoingFirstSubTitle;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Bank Accounts']")
    private AndroidElement bankAccount;

    @AndroidFindBy(xpath = "//*[@text='vs last month']")
    private AndroidElement outgoingSecondSubTitle;

    @AndroidFindBy(xpath = "//*[@text='EMI']")
    private AndroidElement outgoingThirdSubTitle;

    @AndroidFindBy(xpath = "//*[@text='Investment']")
    private AndroidElement outgoingFourthSubTitle;

    @AndroidFindBy(xpath = "//*[@text='Your Monthly Summary']")
    private AndroidElement yourMonthlySummery;

    @AndroidFindBy(id = "cta_text")
    private AndroidElement mainDashboardAnalyserCTA;

    @AndroidFindBy(xpath = "//*[@text='HIGHLIGHTS']")
    private AndroidElement dashboardHighlightTitle;

    @AndroidFindBy(xpath = "//*[@text='MONEY IN']")
    private AndroidElement moneyInTitle;

    @AndroidFindBy(xpath = "//*[@text='Add Account']")
    private AndroidElement addAccountTitle;

    @AndroidFindBy(xpath = "//*[@text='+ Add Account']")
    private AndroidElement addAccountTitleonBankscreen;

    @AndroidFindBy(xpath = "//*[@text='Refer Your Friends']")
    private AndroidElement referTitle;

    @AndroidFindBy(xpath = "//*[@text='Manage']")
    private AndroidElement manageTitle;

    @AndroidFindBy(xpath = "//*[@text='View Insights & Highlights']")
    private AndroidElement viewHighlighttext;

    @AndroidFindBy(xpath = "//*[@text='Interest Credit']")
    private AndroidElement interestCreditviewHighlight;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Current Month']")
    private AndroidElement currentmonthSelectFilter;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = '+Add']")
    private AndroidElement nicknameAddCta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Last Month']")
    private AndroidElement lastmonthSelectFilter;

//text
    @AndroidFindBy(id = "mkab_left_icon")
    private AndroidElement cross_click;

    @AndroidFindBy(id = "cta_allow")
    private AndroidElement allow_onbottomsheet;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = 'Allow']")
    private AndroidElement permission_allow_button_popup;

    @AndroidFindBy(id = "permission_allow_button")
    private AndroidElement permission_allow_button_popup1;

    @AndroidFindBy(id = "cta")
    private AndroidElement downloadTitle;

    @AndroidFindBy(id = "txt_masked_acc_no")
    private AndroidElement maskedbankAccount;

    @AndroidFindBy(id = "txt_filter")
    private AndroidElement monthSelectFilter;

    @AndroidFindBy(xpath = "//*[@text='Help & Support']")
    private AndroidElement  helpSupportTitle;

    @AndroidFindBy(xpath = "//*[@text='Show All Highlights']")
    private AndroidElement  showAllHighlights;

    // Last month banner all locator
    @AndroidFindBy(xpath = "//*[@text='Your Monthly Summary']")
    private AndroidElement  clickonLastMonthBanner;

    @AndroidFindBy(xpath = "//*[@text='Incoming']")
    private AndroidElement  incomingonmonthlysummery;

    @AndroidFindBy(xpath = "//*[@text='Outgoing']")
    private AndroidElement  outgoingonmonthlysummery;

    @AndroidFindBy(xpath = "//*[@text='Invested']")
    private AndroidElement  investedonmonthlysummery;

    @AndroidFindBy(xpath = "//*[@text='Remaining']")
    private AndroidElement  remainingonmonthlysummery;

    @AndroidFindBy(id="transaction_title")
    private AndroidElement  outgoingonSpendBycategory;

    @AndroidFindBy(xpath = "//*[@text='Expenses']")
    private AndroidElement  expensesnmonthlysummery;

    @AndroidFindBy(xpath = "//*[@text='EMI']")
    private AndroidElement  sIPsEMIsmonthlysummery;

    @AndroidFindBy(xpath = "//*[@text='Bank charges']")
    private AndroidElement  bankChargesmonthlysummery;

    @AndroidFindBy(xpath = "//*[@text='Others']")
    private AndroidElement  othersgonmonthlysummery;

    @AndroidFindBy(xpath = "//*[@text='Spends by Date']")
    private AndroidElement  spendsbyDateonmonthlysummery;

    @AndroidFindBy(xpath = "//*[@text='Highest Spend']")
    private AndroidElement  highestSpend;

    @AndroidFindBy(xpath = "//*[@text='HDFC Bank XX0088']")
    private AndroidElement  bankNo;

    @AndroidFindBy(xpath = "//*[@text='Top Category']")
    private AndroidElement  topCategory;

    @AndroidFindBy(xpath = "//*[@text='Money Received']")
    private AndroidElement  moneyReceived;

    @AndroidFindBy(xpath = "//*[@text='MONEY IN']")
    private AndroidElement  anayseronAAhomepage;

    @AndroidFindBy(xpath = "//*[@text='DEBITS']")
    private AndroidElement  debitTextOnAnlyser;

    @AndroidFindBy(xpath = "//*[@text='Credits']")
    private AndroidElement  creditTextOnAnlyser;

    @AndroidFindBy(id="icon_check_box")
    private AndroidElement consent_checkbox;

    @AndroidFindBy(id="cta_exit")
    private AndroidElement cta_exit;
    @AndroidFindBy(id="txt_update_at")
    private AndroidElement  debitedthisweekTextOnAnlyser;

    @AndroidFindBy(xpath = "//*[@text='Week']")
    private AndroidElement  weekTextOnAnlyser;

    @AndroidFindBy(xpath = "//*[@text='Month']")
    private AndroidElement  monthTextOnAnlyser;

    @AndroidFindBy(xpath = "//*[@text='Year']")
    private AndroidElement  yearTextOnAnlyser;

    @AndroidFindBy(id="ctaApply")
    private AndroidElement apply_cta;

    @AndroidFindBy(xpath = "//*[@text='Auto Refresh Frequency']")
    private AndroidElement  autoRefreshFrequently;

    @AndroidFindBy(xpath = "//*[@text='Manage Consent']")
    private AndroidElement  manageConsent;

    @AndroidFindBy(xpath = "//*[@text='Help']")
    private AndroidElement  helpText;

    @AndroidFindBy(id="touch_outside")
    private AndroidElement  every15days;

    @AndroidFindBy(id="snackbar_text")
    private AndroidElement  snackbarAfterupdatingAutoupdate;

    @AndroidFindBy(id="mkab_left_icon")
    private AndroidElement  backbuttonOnManageConsentInside;

    @AndroidFindBy(id="action_button")
    private AndroidElement  confirm_cta;

    @AndroidFindBy(id="ic_arrow_down")
    private AndroidElement  downArrow;

    @AndroidFindBy(id="et_search")
    private AndroidElement  bankname_enter;

    @AndroidFindBy(id="cl_root")
    private AndroidElement  yourBankAccountonHomePage;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Connect Your Accounts']")
    private AndroidElement connectyoueaccount_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='View Statement']")
    private AndroidElement viewStatement;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Download Statement']")
    private AndroidElement downloadStatement;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Download Smart Statement']")
    private AndroidElement downloadsmartStatement;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Last 7 Days']")
    private AndroidElement txtLast7Days;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Last 30 Days']")
    private AndroidElement txtLast30Days;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Last 6 Months']")
    private AndroidElement Last6Months;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Last 12 Months']")
    private AndroidElement Last12Months;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='This Year']")
    private AndroidElement txtThisYear;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Financial Year']")
    private AndroidElement txtFinancialYear;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Update Name']")
    private AndroidElement update_name;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text ='Payee Name']")
    private AndroidElement enterPayeeName;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'SKIP']")
    private AndroidElement skip_cta;

    @AndroidFindBy(xpath = "//*[@text='Sort']")
    private AndroidElement  sortFilter;

    @AndroidFindBy(xpath = "//*[@text='High To Low']")
    private AndroidElement  highToLowFilter;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Bank Balance']")
    private AndroidElement allBankBalance;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Nickname']")
    private AndroidElement getTextNickName;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Nickname']/..//android.widget.TextView[contains(@resource-id,'tvValue')]")
    private AndroidElement getTextNickNameVal;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Category']/..//android.widget.TextView[contains(@resource-id,'tvValue')]")
    private AndroidElement getTextCategoryValue;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Sub Category']/..//android.widget.TextView[contains(@resource-id,'tvValue')]")
    private AndroidElement getTextSubCategoryValue;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Category']")
    private AndroidElement getCategoryOnRetagging;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Sub Category']")
    private AndroidElement getSubCategoryOnRetagging;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Payment Mode']")
    private AndroidElement getPaymentModeOnRetagging;

    @AndroidFindBy(id="txt_intro_title")
    private AndroidElement  intro_txt;

    @AndroidFindBy(id="et_phone_number")
    private AndroidElement  enter_phone_no;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Enter valid 10 digit number']")
    private AndroidElement invalid_mobile_enter_error;

    @AndroidFindBy(id = "mkiv_image")
    private AndroidElement SearchIcon;

    @AndroidFindBy(xpath="//*[(contains(@text,'MobiKwik']")
    private AndroidElement firstSearchTxt1;

    @AndroidFindBy(id = "tv_search_result")
    private AndroidElement firstSearchTxt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Filter']")
    private AndroidElement txtFilter;

    @AndroidFindBy(id="left_container")
    private AndroidElement  left_container;

    public AccountAggregatorPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("***** Account Aggregator *****");

    }

    public void clickonfilter() throws InterruptedException{
        Elements.selectElement(driver,txtFilter, " Click on Filter");
    }

    public void clickonleftIcon() throws InterruptedException{
        Elements.selectElement(driver,left_container, " Click on left icon");
    }


    public void clickonApplyCta() throws InterruptedException{
        Elements.selectElement(driver,apply_cta, " Click on Apply");
    }

    public void clickonBankFilter() throws InterruptedException{
        Elements.selectElement(driver,bankNo, " Click on Bank from list");
    }

    public void clickonSort() throws InterruptedException{
        Elements.selectElement(driver,sortFilter, " Click on sort filter ");
    }

    public void clickonHighToLowFilter() throws InterruptedException{
        Elements.selectElement(driver,highToLowFilter, " Click on sort filter ");
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
        Elements.scrollToElement(driver,TrackBankAccountsCTA);
        Elements.selectElement(driver,TrackBankAccountsCTA,"Click on Track bank account lens icon");
    }

    public void scrollTotrackBankAccounts() throws InterruptedException {
         Elements.scrollToElement(driver,TrackBankAccountsCTA);
    }

    public void clickOnTrackBankAccounts() throws InterruptedException{
        Elements.selectElement(driver,TrackBankAccountsCTA,"Click on Track bank account");
    }

    public void clickOnAAOnHomeScreen() throws InterruptedException{
        Elements.selectElement(driver,TrackBankAccountsCTA,"Track bank account");
    }

    public boolean scrollToAAOnHomeScreen() throws InterruptedException {
        return Elements.scrollToElement(driver,TrackBankAccountsCTA);
    }
//2
    public boolean scrollToAddAccountOnHomeScreen() throws InterruptedException {
        return Elements.scrollToElement(driver,addAccountTitle);
    }

    public void clickOnToAddAccountOnHomeScreen() throws InterruptedException{
        Elements.selectElement(driver,addAccountTitle,"Click on Add Account");
    }

    public void clickOnToAddAccountOnBankListScreen() throws InterruptedException{
        Elements.selectElement(driver,addAccountTitleonBankscreen,"Click on Add Account on bank list screen");
    }

    public void clickOnSearchIcon() throws InterruptedException{
        Elements.selectElement(driver,SearchIcon,"Click on Search Icon");
    }

    public void clickOnToAddAccount() throws InterruptedException{
        Elements.selectElement(driver,addAccountTitle,"Click on Add Account");
    }

    public void clickOnexitbutoonOnfeedback() throws InterruptedException{
        Elements.selectElement(driver,cta_exit,"Click on Exit button on feedback");
    }

    public void clickOnTocrossButtonOnOTPFetch() throws InterruptedException{

        Elements.selectElement(driver,cross_click,"Click on Cross");
    }
    public void clickOnAllowCTaOnBottomsheet() throws InterruptedException{
        Elements.selectElement(driver,allow_onbottomsheet,"Click on Allow on bottomsheet");
    }

    public void clickOnAllowCTaOnPopUp() throws InterruptedException{
        Elements.selectElement(driver,permission_allow_button_popup,"Click on Allow on pop up");
    }


    public void clickOnBankAccount() throws InterruptedException{
        Elements.selectElement(driver,bankAccount, "click on bank account");
    }

    public void scrollToBankAccount() throws InterruptedException {
        Elements.scrollToElement(driver,bankAccount);
    }

    public void clickOndownArrowNexttoBankOnHomePage() throws InterruptedException{
        Elements.selectElement(driver,downArrow, "click on down arrow next to bankpage");
    }
    public boolean checkTrackbankAccountsCTA() throws InterruptedException {
        return Elements.isElementPresent(driver, TrackBankAccountsCTA);
    }

    //for Entry from track all investment cta ---
    public void trackInvestmentCTA() throws InterruptedException{
        Elements.selectElement(driver, trackInvestmentCTA, "Click on Track all your investment cta");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Base Title");
    }

    public String getLast7daysTxt() throws InterruptedException {
        return Elements.getText(driver, txtLast7Days, "txt Last 7 Days");
    }

    public String getLast30daysTxt() throws InterruptedException {
        return Elements.getText(driver, txtLast30Days, "txt Last 30 Days");
    }

    public String getLast6monthTxt() throws InterruptedException {
        return Elements.getText(driver, Last6Months, "txt Last 6 Months");
    }

    public String getLast12monthTxt() throws InterruptedException {
        return Elements.getText(driver, Last12Months, "txt Last 12 Months");
    }

    public String getThisYearTxt() throws InterruptedException {
        return Elements.getText(driver, txtThisYear, "txt this Year");
    }

    public String getFinanacialYearTxt() throws InterruptedException {
        return Elements.getText(driver, txtFinancialYear, "txt financial Year");
    }

    public Boolean getCalender() throws InterruptedException {
        return Elements.isElementPresent(driver, calender);
    }

    public Boolean getIncomingOnMonthlySummary() throws InterruptedException {
        return Elements.isElementPresent(driver, incoming);
    }
    public Boolean getMoneyTrf() throws InterruptedException {
        String moneyPercentage = Elements.getText(driver, get_MoneyTrfPercentage);
        if(moneyPercentage != null) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean getExpensesPercentage() throws InterruptedException {
        String expensesPercentage = Elements.getText(driver, get_MoneyTrfPercentage);
        if(expensesPercentage != null) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean getSipPercentage() throws InterruptedException {
        String sipPercentage = Elements.getText(driver, get_MoneyTrfPercentage);
        if(sipPercentage != null) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean getBankChargesPercentage() throws InterruptedException {
        String bankChargesPercentage = Elements.getText(driver, get_MoneyTrfPercentage);
        if(bankChargesPercentage != null) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean isOutgoingTitlePresent() throws InterruptedException {
        return Elements.isElementPresent(driver, moneyOutTitle);
    }


    public String getOutgoingTitle() throws InterruptedException {
        return Elements.getText(driver, moneyOutTitle, "MONEY OUT TITLE");
    }

    public String getAllBankBalanceText() throws InterruptedException {
        return Elements.getText(driver, allBankBalance, "All Bank balance text");
    }


    public String getNickNameAddCTA() throws InterruptedException {
        return Elements.getText(driver, nicknameAddCta, "+Add cta on Nick Name is present");
    }


    public String getTextRetaggingNickName() throws InterruptedException {
        return Elements.getText(driver, getTextNickName, "Get Text NickNAME");
    }

    public String getTextNickNameVal() throws InterruptedException {
        return Elements.getText(driver, getTextNickNameVal, "Get Value of NickNAME ID");
    }

    public String getTextCategoryVal() throws InterruptedException {
        return Elements.getText(driver, getTextCategoryValue, "Get Value of Category");
    }

    public void clickonTextCategoryVa() throws InterruptedException{
        Elements.selectElement(driver,getTextCategoryValue,"click on Category name");
    }

    public void clickonTextSubCategoryVa() throws InterruptedException{
        Elements.selectElement(driver,getTextSubCategoryValue,"click on subcategory value");
    }

    public String getTextCategory() throws InterruptedException {
        return Elements.getText(driver, getCategoryOnRetagging, "Get Category heading");
    }

    public String getTextSubCategory() throws InterruptedException {
        return Elements.getText(driver, getSubCategoryOnRetagging, "Get SubcategoryCategory heading");
    }

    public String getTextpaymentMode() throws InterruptedException {
        return Elements.getText(driver, getPaymentModeOnRetagging, "Get payment mode heading");
    }


    public void setpayeeName(String amount) {
        Elements.enterToElement(driver, enterPayeeName, amount,"enter PayeeName");
    }

    public void clickonUpdateName() throws InterruptedException{
        Elements.selectElement(driver,update_name,"click on Update name");
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


    public Boolean isTextRetaggingNickNamePresent() throws InterruptedException {
        return  Elements.isElementPresent(driver, getTextNickName);
    }

    public String getMonthlySummeryCTA() throws InterruptedException {
        return Elements.getText(driver, yourMonthlySummery, "Monthly Summery text");
    }

    public String mainDashboardAnalyserCTA() throws InterruptedException {
        return Elements.getText(driver, mainDashboardAnalyserCTA, "Main Dashboard Analyser CTA");
    }

    public String dashboardHighlightTitletext() throws InterruptedException {
        return Elements.getText(driver, dashboardHighlightTitle, "Dashboard Highlight Title Title");
    }

    public boolean checkDashboardHighlightTitle() throws InterruptedException {
        return Elements.isElementPresent(driver, dashboardHighlightTitle);
    }

    public String moneyinTitle() throws InterruptedException {
        return Elements.getText(driver, moneyInTitle, "Scroll to money in title");
    }

    public void scrollTomoneyinTitle() throws InterruptedException {
         Elements.scrollToElement(driver, moneyInTitle);
    }
    public void scrollToCashflow() throws InterruptedException {
        Elements.scrollToElement(driver, cashFlow);
    }

    public void scrollTomoneyOutTitle() throws InterruptedException {
        Elements.scrollToElement(driver, moneyOutTitle);
    }

    public String ReferTitle() throws InterruptedException {
        return Elements.getText(driver, referTitle, "Dashboard Refer Title");
    }

    public void scrollToReferYourFriend() throws InterruptedException {
         Elements.scrollToElement(driver, referTitle);
    }

    public void scrolltoManage() throws InterruptedException {
        Elements.scrollToElement(driver, manageTitle);
    }

    public void scrolltoViewHighlights() throws InterruptedException {
        Elements.scrollToElement(driver, viewHighlighttext);
    }

    public void scrolltoViewStatement() throws InterruptedException {
        Elements.scrollToElement(driver, viewStatement);
    }

    public void clickOnViewStatement() throws InterruptedException{
        Elements.selectElement(driver,viewStatement, "click on View Statement");
    }

    public void clickOnDownloadStatement() throws InterruptedException{
        Elements.selectElement(driver,downloadStatement, "click on Download statement");
    }

    public void clickOnDownloadSmartStatement() throws InterruptedException{
        Elements.selectElement(driver,downloadsmartStatement, "click on Download smart statement");
    }

    public void clickOnviewHighlisht() throws InterruptedException{
        Elements.selectElement(driver,viewHighlighttext, "click on ViewHightligted");
    }

    public void clickOnOneHighlightInterestCredit() throws InterruptedException{
        Elements.selectElement(driver,interestCreditviewHighlight, "click on interest credit");
    }


    public void clickOnAddbutton() throws InterruptedException{
        Elements.selectElement(driver,nicknameAddCta, "click on add button");
    }


    public String manageTitle() throws InterruptedException {
        return Elements.getText(driver, manageTitle, "Manage Title");
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
    public void clickContinueOnbottomSheet() throws InterruptedException {
        Elements.selectElement(driver, continue_cta_newbootsheet, "Click on Continue cta on new bottomsheet");
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

    //Your Monthly summary

    public void clickMonthlySummaryOnHomePage(){
        Elements.selectElement(driver, clickonLastMonthBanner, "Click Monthly summary bar on AA home Page");

    }

    public String getIncomingtextOnMonthlySummary() throws InterruptedException {
        return Elements.getText(driver, incomingonmonthlysummery);
    }

    public String getOutingtextOnMonthlySummary() throws InterruptedException {
        return Elements.getText(driver, outgoingonmonthlysummery);
    }

    public String getInvestedtextOnMonthlySummary() throws InterruptedException {
        return Elements.getText(driver, investedonmonthlysummery);
    }

    public Boolean IsInvestedtextOnMonthlySummaryVisible() throws InterruptedException {
        return Elements.isElementPresent(driver, investedonmonthlysummery);
    }

    public String getRemaingtextOnMonthlySummary() throws InterruptedException {
        if(Elements.isElementPresent(driver,remainingonmonthlysummery)){
        return Elements.getText(driver, remainingonmonthlysummery);
        }else {
            return "";
        }
    }

    public String getOutgoingtextOnMonthlySummarySpendbycategory() throws InterruptedException {
        if(Elements.isElementPresent(driver,outgoingonSpendBycategory)){
            return Elements.getText(driver, outgoingonSpendBycategory);
        }else {
            return "";
        }

    }

    public String getExpensesSpendbycategory() throws InterruptedException {
        if(Elements.isElementPresent(driver,expensesnmonthlysummery)){
            return Elements.getText(driver, expensesnmonthlysummery);
        }else {
            return "";
        }

    }

    public String getSipEmiSpendbycategory() throws InterruptedException {
        if(Elements.isElementPresent(driver,sIPsEMIsmonthlysummery)){
            return Elements.getText(driver, sIPsEMIsmonthlysummery);
        }else {
            return "";
        }

    }

    public String getBankChargesSpendbycategory() throws InterruptedException {
        if(Elements.isElementPresent(driver,bankChargesmonthlysummery)){
            return Elements.getText(driver, bankChargesmonthlysummery);
        }else {
            return "";
        }

    }

    public String getOthersSpendbycategory() throws InterruptedException {
        if(Elements.isElementPresent(driver,othersgonmonthlysummery)){
            return Elements.getText(driver, othersgonmonthlysummery);
        }else {
            return "";
        }

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
        Elements.selectElement(driver,moneyOutTitle,"Click on Analyser");
    }

    public void scrollToMoneyOut() throws InterruptedException {
        Elements.scrollToElement(driver,moneyOutTitle);
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

    public String autoRefreshext() throws InterruptedException {
        return Elements.getText(driver, autoRefreshFrequently);
    }

    public String manageConsentText() throws InterruptedException {
        return Elements.getText(driver, manageConsent);
    }

    public String helpText() throws InterruptedException {
       return Elements.getText(driver, helpText,"Click on Help option");
    }

    public void selectHelpOptn() throws InterruptedException {
         Elements.selectElement(driver, helpText,"Click on Help option");
    }

    public void selectAutoRefreshext() throws InterruptedException{
        Elements.selectElement(driver,autoRefreshFrequently,"Click on Auto refresh frequency");
    }

    public void selectOutsideOfAutoRefresh() throws InterruptedException{
        Elements.selectElement(driver,every15days,"Click on Every 15 days");
    }


    public void enterBankDetail(String bankdetails) throws InterruptedException {
        Elements.enterToElement(driver, bankname_enter, bankdetails, "Enter Bank Name");

    }

    public void clickonConsentcheckBox() throws InterruptedException{
        Elements.selectElement(driver,consent_checkbox,"click on checkbox");
    }

    public void clickConfirmButtonOnFIPPage() throws InterruptedException{
        Elements.selectElement(driver,confirm_cta,"Click on Confirm button");
    }

    public Boolean getsnackbarAfterupdatingAutoupdatey() throws InterruptedException {
        return Elements.isElementPresent(driver, snackbarAfterupdatingAutoupdate);
    }

    public void clickManageConsent() throws InterruptedException{
        Elements.selectElement(driver,manageConsent,"Select Manage Consent");
    }


    public void clickBackButtonOnManageConsentInside() throws InterruptedException{
        Elements.selectElement(driver,backbuttonOnManageConsentInside,"Click on back button on ManageConsent Inside");
    }

    public void helpSupportTitleClick() throws InterruptedException{
        Elements.selectElement(driver,helpSupportTitle,"Click on Help and support");
    }

    public void clickOnYourSavedBankAccount() throws InterruptedException{
        Elements.selectElement(driver,yourBankAccountonHomePage,"Click on Your Account");
    }

    public Boolean savedBankAccount() throws InterruptedException {
        return Elements.isElementPresent(driver, yourBankAccountonHomePage);
    }


    public Boolean isBankAccoutPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, maskedbankAccount);
    }
    public void userDetails() throws InterruptedException{Elements.selectElement(driver, userDetails, "Check the user details");}

    public void applyFilter() throws InterruptedException{Elements.selectElement(driver,applyFilter, "Apply filter");}
    public void bankDetailsCTA() throws InterruptedException{Elements.selectElement(driver,bankDetailsCTA, "Click on bank details cta");}


    public String getuserDetails() throws InterruptedException
    {
        return Elements.getText(driver, userDetails, "Check for the details");

    }

    public void clicktoConnectYourAccount() throws InterruptedException{
        Elements.selectElement(driver,connectyoueaccount_cta,"Click on Connect Your Account");
    }


    public void enterMobileNo(String number){
        Elements.enterToElement(driver, enter_phone_no,number, "Enter Mobile no");
    }


    public void skipCTA() throws InterruptedException{
        Elements.selectElement(driver, skip_cta, "Click on Skip CTA");
    }


    public void clickOntooltip() throws InterruptedException{
        Elements.selectElement(driver,tooltip_search,"Click on tooltip");
    }

    public void ckickOnIntro() throws InterruptedException{
        Elements.selectElement(driver, intro_txt, "Click on Intro CTA");
    }


    public String getinvalidMobileNoError() throws InterruptedException
    {
        return Elements.getText(driver, invalid_mobile_enter_error, "error message on invalid input");

    }

    public void clickonnewMonthSelectFilter() throws InterruptedException{
        Elements.selectElement(driver,monthSelectFilter,"Click on Month select filter");
    }

    public void clickonCurrentMonth() throws InterruptedException{
        Elements.selectElement(driver,currentmonthSelectFilter,"Click on current Month from filter");
    }
    public String getCurrentMonthtxt() throws InterruptedException {
        return Elements.getText(driver, currentmonthSelectFilter);
    }

    public void clickonLastMonth() throws InterruptedException{
        Elements.selectElement(driver,lastmonthSelectFilter,"Click on last month from filter");
    }

    public String getlastMonthtxt() throws InterruptedException {
        return Elements.getText(driver, lastmonthSelectFilter);
    }

    public void clickOnFirstSearchvalue() throws InterruptedException{
        Elements.selectElement(driver,firstSearchTxt,"Click on first search text");
    }


}




