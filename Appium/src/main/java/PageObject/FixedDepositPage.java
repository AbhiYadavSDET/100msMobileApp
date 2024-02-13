package PageObject;

import Logger.Log;
import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FixedDepositPage {
    AndroidDriver driver;
    @AndroidFindBy(xpath = "//*[@text = 'All Services']")
    private AndroidElement allServicesCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Fixed Deposits']")
    private AndroidElement fixedDepositCTA;


    @AndroidFindBy(xpath = "//*[@text = 'Fixed Deposits']")
    private AndroidElement fixedDepositCTA1;
    @AndroidFindBy(xpath = "//*[@text = 'View Investment Activity']")
    private AndroidElement titleViewInvestmentSummary;

    @AndroidFindBy(xpath = "//*[@text = 'TOP PLANS']")
    private AndroidElement titleTopPlans;

    @AndroidFindBy(xpath = "//*[@text = 'Interest']")
    private AndroidElement titleInterest;
    @AndroidFindBy(xpath = "//*[@text = 'Tenure']")
    private AndroidElement titleTenure;
    @AndroidFindBy(xpath = "//*[@text = 'Book']")
    private AndroidElement ctaBook;
    @AndroidFindBy(xpath = "//*[@text = 'Choose Custom Tenure']")
    private AndroidElement ctaChooseCustomTenure;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Citizen')]")
    private AndroidElement ctaSeniorCitizen;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Females')]")
    private AndroidElement ctaFemale;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Frequently')]")
    private AndroidElement ctaFAQ;

    @AndroidFindBy(xpath = "//*[@text = 'Maximize Your FD Returns']")
    private AndroidElement ctaMaximizeYourFD;

    @AndroidFindBy(xpath = "//*[@text = 'Interest Rate']")
    private AndroidElement ctaInterestRate;

    @AndroidFindBy(xpath = "//*[@text = 'Contact us']")
    private AndroidElement ctaContactUs;

    @AndroidFindBy(xpath = "//*[@text = 'Annual Yield']")
    private AndroidElement ctaAnnualYield;

    @AndroidFindBy(id="tvYourInvestmentLabel")
    private AndroidElement ctaSelectDepositAmount;

    @AndroidFindBy(xpath = "//*[@text = 'Next']")
    private AndroidElement ctaNext;

    @AndroidFindBy(xpath = "//*[@text = 'Proceed To Pay']")
    private AndroidElement ctaProceedToPay;

    @AndroidFindBy(id="tv_profile_edit")
    private AndroidElement ctaEdit;

    @AndroidFindBy(id="ctaEdit")
    private AndroidElement ctaEditNomineeprefilledPage;
    @AndroidFindBy(xpath = "//*[@text = 'Married']")
    private AndroidElement ctaMarried;

    @AndroidFindBy(xpath = "//*[@text = 'Indian']")
    private AndroidElement ctaIndian;

    @AndroidFindBy(xpath = "//*[@text = 'Education Qualification']")
    private AndroidElement ctaEducationQualification;

    @AndroidFindBy(xpath = "//*[@text = 'Post Graduate']")
    private AndroidElement ctaPostGraduate;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText)[2]")
    private AndroidElement enter_fathername;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Occupation')]")
    private AndroidElement ctaDropdownOccupationtype;
    @AndroidFindBy(xpath = "//*[@text = 'Student']")
    private AndroidElement selectOccupationType;

    @AndroidFindBy(xpath = "//*[@text = 'Proceed']")
    private AndroidElement ctaProceed;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Nominee']/../android.view.ViewGroup/android.widget.TextView")
    private AndroidElement ctaNomineeName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Bank Account']/../android.view.ViewGroup/android.widget.TextView")
    private AndroidElement ctaBankAccountno;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Partner Bank/NBFC']/../android.view.ViewGroup/android.widget.TextView")
    private AndroidElement text_partner;

    @AndroidFindBy(id="tv_name")
    private AndroidElement clickEditNomineeFirstField;

    @AndroidFindBy(xpath = "//*[@text = 'Nominee Details']")
    private AndroidElement ctaNomineeDetailHeading;
    @AndroidFindBy(xpath = "//*[@text = 'NAME']")
    private AndroidElement ctaNomineeNameOnViewEdit;
    @AndroidFindBy(xpath = "//*[@text = 'RELATIONSHIP']")
    private AndroidElement ctaRelationship;
    @AndroidFindBy(xpath = "//*[@text = 'DOB']")
    private AndroidElement ctaDOB;
    @AndroidFindBy(xpath = "//*[@text = 'ADDRESS']")
    private AndroidElement ctaAddress;
    @AndroidFindBy(xpath = "//*[@text = 'MOBILE']")
    private AndroidElement ctaMobile;
    @AndroidFindBy(xpath = "//*[@text = 'Edit']")
    private AndroidElement ctaEditonNomineeDetails;

    @AndroidFindBy(xpath = "//*[@text = 'Partner Bank/NBFC']")
    private AndroidElement ctaPartnerBank;

    @AndroidFindBy(xpath = "//*[@text = 'Interest p.a.']")
    private AndroidElement ctaInterestPA;

    @AndroidFindBy(xpath = "//*[@text = 'Interest Payout']")
    private AndroidElement ctaInterestPayout;
    @AndroidFindBy(xpath = "//*[@text = 'Maturity Amount']")
    private AndroidElement ctaMaturityAmount;

    @AndroidFindBy(xpath = "//*[@text = 'Total Gains']")
    private AndroidElement ctaTotalGains;

    @AndroidFindBy(xpath = "//*[@text = 'Pre-mature withdrawals']")
    private AndroidElement ctaPrematurewithdrawals;

    @AndroidFindBy(xpath = "//*[@text = 'Bank Account']")
    private AndroidElement ctaBankAccount;

    @AndroidFindBy(id="tv_hint_know_more")
    private AndroidElement ctaKnowmoreforBankAccount;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'HDFC BANK']")
    private AndroidElement clickOnHdfcBank;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'View Investment Activity']")
    private AndroidElement CTAViewInvestmentActivity;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'On-going']")
    private AndroidElement CTAOngoing;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Past']")
    private AndroidElement CTAPast;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Payment History']")
    private AndroidElement CTAPaymentHistory;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Invested Amount']")
    private AndroidElement text_Investedamount;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Matures On']")
    private AndroidElement text_matureon;
    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Maturity Amount']")
    private AndroidElement text_Maturity_amount;
    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Gains']")
    private AndroidElement text_Gains;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText)[3]")
    private AndroidElement enter_phone_no;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Secure')]")
    private AndroidElement clickOutside;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Proceed')]")
    private AndroidElement ctaProceedtoPay;

    @AndroidFindBy(id="ctaConfirm")
    private AndroidElement ctaConfirm;
    //
    @AndroidFindBy(id="tv_title")
    private AndroidElement tenuremonth_top;

    @AndroidFindBy(id="switch_auto_pay")
    private AndroidElement radio_button_srcitizen;

    @AndroidFindBy(id="tvInterest")
    private AndroidElement click_interest_pa;

    @AndroidFindBy(id="tv_key")
    private AndroidElement tenure_filter_list;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Help & Support']")
    private AndroidElement helpsupporttitle;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'What are fixed deposits?']")
    private AndroidElement faqfirstitems;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Investment']")
    private AndroidElement text_investment;

    @AndroidFindBy(id="left_container")
    private AndroidElement click_back_cta_history;

    public FixedDepositPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("***** Account Aggregator *****");
    }

    public void allServicesCTA() throws InterruptedException{
        Elements.selectElement(driver,allServicesCTA,"Click on all services");
    }

    public boolean scrollToFixedDeposit() throws InterruptedException {
        return Elements.scrollToElement(driver, fixedDepositCTA);
    }
    public void fixedDepositCTA() throws InterruptedException{
        Elements.selectElement(driver,fixedDepositCTA,"Fixed Deposit CTA");
    }

    public String getTitleViewInvestmetnSummary() throws InterruptedException {
        return Elements.getText(driver,titleViewInvestmentSummary, "ViewInvestment Activity");
    }

    public String getTitleTopPlans() throws InterruptedException {
        return Elements.getText(driver,titleTopPlans, "Top plans Title");
    }

    public String clickonfirstfaq() throws InterruptedException {
        return Elements.getText(driver,faqfirstitems, "FAQ first items");
    }

    public String getCTAInterest() throws InterruptedException {
        return Elements.getText(driver,titleInterest, "Title of Interest");
    }

    public String getCTATenure() throws InterruptedException {
        return Elements.getText(driver,titleTenure, "Title of Tenure");
    }

    public String getCTABook() throws InterruptedException {
        return Elements.getText(driver,ctaBook, "CTA book");
    }

    public void bookCTA() throws InterruptedException{
        Elements.selectElement(driver,ctaBook,"Click on Book button");
    }

    public String getCTAChooseCustomTenure() throws InterruptedException {
        return Elements.getText(driver,ctaChooseCustomTenure, "Choose Custom Tenure");
    }

    public void clickOnChooseCustomTenure() throws InterruptedException{
        Elements.selectElement(driver,ctaChooseCustomTenure,"Click on Custom Tenure");
    }

    public String getCTASeniorCitizen() throws InterruptedException {
        return Elements.getText(driver,ctaSeniorCitizen, "CTA Senior Citizen");
    }

    public String getCTAFemale() throws InterruptedException {
        return Elements.getText(driver,ctaFemale, "CTA Female");
    }

    public String getCTAMaximizeYourFD() throws InterruptedException {
        return Elements.getText(driver,ctaMaximizeYourFD, "CTA Maximize your FD");
    }

    public String getCTAFAQ() throws InterruptedException {
        return Elements.getText(driver,ctaFAQ, "CTA FAQ");
    }


    public boolean scrollFrequentlyAskedQuestion() throws InterruptedException {
        return Elements.scrollToElement(driver, ctaFAQ);
    }

    public String getCTAContactUs() throws InterruptedException {
        return Elements.getText(driver,ctaContactUs, "CTA Contact Us");
    }

    public boolean scrolltoNeedHelp() throws InterruptedException {
        return Elements.scrollToElement(driver, ctaContactUs);
    }

    public void clickonContactUs() throws InterruptedException{
        Elements.selectElement(driver,ctaContactUs,"Click on contact us ");
    }

    public void clickotenureyearfromTop() throws InterruptedException{
        Elements.selectElement(driver,tenuremonth_top,"Click on tenure month from top ");
    }

    public void clickonRadiobutton() throws InterruptedException{
        Elements.selectElement(driver,radio_button_srcitizen,"Click on radio button from senior citizen ");
    }

    public void clickonTenureOnFilterPage() throws InterruptedException{
        Elements.selectElement(driver,titleTenure,"Click on Tenure ");
    }

    public void clickonInterestpa() throws InterruptedException{
        Elements.selectElement(driver,click_interest_pa,"Click on interest pa ");
    }

    public void clickontenuremonthfromList() throws InterruptedException{
        Elements.selectElement(driver,tenure_filter_list,"Click on first tenure from filter ");
    }

    public String getHeaderTextHelp() throws InterruptedException {
        return Elements.getText(driver,helpsupporttitle, "Help & Support");
    }
    public String getCTAInterestRate() throws InterruptedException {
        return Elements.getText(driver,ctaInterestRate, "CTA Interest Rate");
    }


    public String getCTAAnnualYield() throws InterruptedException {
        return Elements.getText(driver,ctaAnnualYield, "CTA Annual Yield");
    }

    public String GetCTADepositAmount() throws InterruptedException {
        return Elements.getText(driver,ctaSelectDepositAmount, "CTA Select Deposit Amount");
    }
    public void ctaNext() throws InterruptedException{
        Elements.selectElement(driver,ctaNext,"CTA Next");
    }


    public void ctaProceedToPay() throws InterruptedException{
        Elements.selectElement(driver,ctaProceedToPay,"CTA Proceed to pay");
    }

    public void ctaEdit() throws InterruptedException{
        Elements.selectElement(driver,ctaEdit,"CTA Edit on Profile");
    }

    public void ctaMarried() throws InterruptedException{
        Elements.selectElement(driver,ctaMarried,"CTA Married field");
    }

    public void ctaIndian() throws InterruptedException{
        Elements.selectElement(driver,ctaIndian,"CTA Indian");
    }

    public void ctaEducationQualification() throws InterruptedException{
        Elements.selectElement(driver,ctaEducationQualification,"Education Qualification");
    }

    public void dropdownPostGraduate() throws InterruptedException{
        Elements.selectElement(driver,ctaPostGraduate,"Post Graduate");
    }


    public void ctafathername() throws InterruptedException{
        Elements.selectElement(driver,enter_fathername,"select father name ");
    }
    public void enterFatherName(String fathername) throws InterruptedException {
        Elements.enterToElement(driver, enter_fathername, fathername, "Enter Father Name");
    }

    public void enterFatherNameErrorCase(String fathername) throws InterruptedException {
        Elements.enterToElement(driver, enter_fathername, fathername, "Enter Father Name");
    }
    public void ctaDropdownOccupationType() throws InterruptedException{
        Elements.selectElement(driver,ctaDropdownOccupationtype,"Occupation TYpe");
    }
    public void ctaDropdownOccupationTypeSelect() throws InterruptedException{
        Elements.selectElement(driver,selectOccupationType,"Select Occupation TYpe");
    }

    public void ctaProceed() throws InterruptedException{
        Elements.selectElement(driver,ctaProceed,"Select Proceed");
    }

    public void ctaProceedtoPay() throws InterruptedException{
        Elements.selectElement(driver,ctaProceedtoPay,"Select Proceed to pay");
    }

    public void ctaNomineeName() throws InterruptedException{
        Elements.selectElement(driver,ctaNomineeName,"Select Nominee name");
    }

    public void clickBankAccount() throws InterruptedException{
        Elements.selectElement(driver,ctaBankAccountno,"Select Bank Account");
    }

    public void clickBankAccountHDFC() throws InterruptedException{
        Elements.selectElement(driver,clickOnHdfcBank,"Select Bank Account HDFC");
    }

    public void clickPartnerBank() throws InterruptedException{
        Elements.selectElement(driver,text_partner,"click partner from list");
    }

    public void clickEditNomineeFirstField() throws InterruptedException{
        Elements.selectElement(driver,clickEditNomineeFirstField,"Click on the first Nominee from the nominee list");
    }


    public String getctaNomineeDetailHeading() throws InterruptedException {
        return Elements.getText(driver,ctaNomineeDetailHeading, "CTA nominee detail heading");
    }

    public String getNomineeNameOnViewEdit() throws InterruptedException{
        return Elements.getText(driver,ctaNomineeNameOnViewEdit,"CTA nominee name");

    }

    public String getRelationship() throws InterruptedException{
        return Elements.getText(driver,ctaRelationship,"CTA relationship");

    }

    public String getMobile() throws InterruptedException{
        return   Elements.getText(driver,ctaMobile,"CTA mobile");

    }

    public String getDob() throws InterruptedException{
        return Elements.getText(driver,ctaDOB,"CTA  DOB");

    }

    public String getAddress() throws InterruptedException{
        return  Elements.getText(driver,ctaAddress,"CTA Address");

    }


    public String getPartnerBank() throws InterruptedException{
        return   Elements.getText(driver,ctaPartnerBank,"Partner Bank");

    }

    public String getInterestPA() throws InterruptedException{
        return Elements.getText(driver,ctaInterestPA,"Interest PA");

    }

    public String getInterestPayout() throws InterruptedException{
        return Elements.getText(driver,ctaInterestPayout,"Interest Payout");

    }
    public String getMaturityAmountOnHistory() throws InterruptedException{
        return Elements.getText(driver,ctaMaturityAmount,"Maturity Amount");

    }
    public String getTotalGains() throws InterruptedException{
        return Elements.getText(driver,ctaTotalGains,"Total Gains");

    }
    public String getPrematurewithdrawals() throws InterruptedException{
        return  Elements.getText(driver,ctaPrematurewithdrawals,"Premature withdrawals");

    }
    public String getBankAccount() throws InterruptedException{
        return Elements.getText(driver,ctaBankAccount,"Bank Account");

    }

    public String getKnowmoreforBankAccount() throws InterruptedException{
        return Elements.getText(driver,ctaKnowmoreforBankAccount,"Know more for bank on bottom sheet");

    }

    public void clickViewInvestmentActivity() throws InterruptedException{
        Elements.selectElement(driver,CTAViewInvestmentActivity,"View Invested Activity ");
    }

    public void clickOngoing() throws InterruptedException{
        Elements.selectElement(driver,CTAOngoing,"on going");
    }

    public String getPast() throws InterruptedException{
        return Elements.getText(driver,CTAPast,"get Past");

    }
    public void clickOnPAST() throws InterruptedException{
        Elements.selectElement(driver,CTAPast,"Past CLICK");
    }

    public void clickOnPaymentHistory() throws InterruptedException{
        Elements.selectElement(driver,CTAPaymentHistory,"Payment History");
    }


    public String getInvestedamount() throws InterruptedException{
        return Elements.getText(driver,text_Investedamount,"Invested amount");

    }

    public void clickOnOngoingHistoryFirstValue() throws InterruptedException{
        Elements.selectElement(driver,text_Investedamount,"click on first history from ongoing");
    }

    public void clickOnbackCTAOnmhistory() throws InterruptedException{
        Elements.selectElement(driver,click_back_cta_history,"click on Back < CTA");
    }

    public String getMaturesOn() throws InterruptedException{
        return Elements.getText(driver,text_matureon,"Mature on");

    }
    public String getMaturityAmount() throws InterruptedException{
        return Elements.getText(driver,text_Maturity_amount,"Maturity amount");

    }
    public String getGains() throws InterruptedException{
        return Elements.getText(driver,text_Gains,"Gains");

    }

    public void clickOnEditOnNomineePrefiledpage() throws InterruptedException{
        Elements.selectElement(driver,ctaEditNomineeprefilledPage,"Edit click");
    }


    public void ctaphoneno() throws InterruptedException{
        Elements.selectElement(driver,enter_phone_no,"select phone no");
    }
    public void enterctaphoneno(String phoneno) throws InterruptedException {
        Elements.enterToElement(driver, enter_phone_no, phoneno, "Enter Phone no");
    }

    public void setClickOutside() throws InterruptedException{
        Elements.selectElement(driver,clickOutside,"Click outside");
    }

    public void clickCtaConfirm() throws InterruptedException{
        Elements.selectElement(driver,ctaConfirm,"Click Confirm cta");
    }


    public String getInvestmenttextOnhistory() throws InterruptedException {
        return Elements.getText(driver,text_investment, "text Investment");
    }
}






















