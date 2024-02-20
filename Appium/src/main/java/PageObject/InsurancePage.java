package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
//import utils.Element;

import java.io.IOException;

public class InsurancePage {

    AndroidDriver driver;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Services']")
    private AndroidElement allServices;
    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Insurance']")
    private AndroidElement insuranceCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Group Insurance']")
    private AndroidElement sub_heading_group_insurance;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Loss of Job']")
    private AndroidElement text_LossofJob;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Retail Insurance']")
    private AndroidElement sub_heading_retail_insurance;
    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Personal Accident Insurance']")
    private AndroidElement text_personalAccidentInsurance;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text = 'Personal Accident Insurance'])[2]")
    private AndroidElement text_personalAccidentInsurance_subheading;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Comprehensive Accidental Insurance']")
    private AndroidElement text_comprehensivepersonalAccidentInsura;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'J']")
    private AndroidElement calender_click;
    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Wallet Protect']")
    private AndroidElement text_walletProtect;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Health Insurance']")
    private AndroidElement text_healthInsurance;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'DocAssure']")
    private AndroidElement text_docAssure;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Pay your existing insurance Premium']")
    private AndroidElement text_payyourexistinginsurancePremium;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'My Policies']")
    private AndroidElement heading_myPolices;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Select Sum Insured']")
    private AndroidElement heading_selectSumIssured;


    @AndroidFindBy(id = "btnPrice")
    private AndroidElement picebutton_onDocInsurancePage;


    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '₹99']")
    private AndroidElement picebutton_onDocInsurancePage1;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '₹20']")
    private AndroidElement picebutton20_onInsurancePage1;

    @AndroidFindBy(id = "i_agree")
    private AndroidElement checkbox;

    @AndroidFindBy(id = "ctaCancel")
    private AndroidElement ctaCancel_yesplease_myPolicy;

    @AndroidFindBy(id = "dynamic_btn_1")
    private AndroidElement cta_cancelPolicy;

    @AndroidFindBy(id = "text_payment_label")
    private AndroidElement text_payable_amount;
    @AndroidFindBy(id = "btnGeneratePolicy")
    private AndroidElement generatePolicy_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Your Risk Exposure']")
    private AndroidElement text_your_risk_exposure;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Product Benefits']")
    private AndroidElement text_product_benefits;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Market Value']")
    private AndroidElement text_market_value;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Partner Name']")
    private AndroidElement text_partner_name;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Start Date']")
    private AndroidElement text_start_date;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'End Date']")
    private AndroidElement text_end_date;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Amount to be paid']")
    private AndroidElement text_amount_to_be_paid;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = 'Make payment']")
    private AndroidElement cta_make_payment;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Coverage']")
    private AndroidElement text_coverage;
    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Insured By']")
    private AndroidElement text_insured_by;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Your policy covers']")

    private AndroidElement text_policy_cover;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Hospital Cash + Personal Accident']")
    private AndroidElement text_hospicash;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = '30 Days Coverage']")
    private AndroidElement text_30daysCoverage;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Dengue Insurance']")
    private AndroidElement text_dengue;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Communicable Diseases']")
    private AndroidElement text_communicable_dises;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'J']")
    private AndroidElement dateofbirth_textview;

    @AndroidFindBy(xpath = "//android.widget.AutoCompleteTextView[@text= 'Monthly Gross Salary']")
    private AndroidElement monthly_gross_salary;

    @AndroidFindBy(id = "button_continue")
    private AndroidElement cta_continue;

    @AndroidFindBy(id = "btnContinue")
    private AndroidElement cta_continue_formfield;

    @AndroidFindBy(id = "skipButton")
    private AndroidElement skip_nominee;


    @AndroidFindBy(id = "back_icon")
    private AndroidElement back_arrow;
    @AndroidFindBy(id = "view_detail_text")
    private AndroidElement text_viewMore;

    @AndroidFindBy(id = "primary_button")
    private AndroidElement select_cta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Full Name']")
    private AndroidElement text_fullname;

    @AndroidFindBy(xpath = "//android.widget.AutoCompleteTextView[@text= 'Name of Current Organization']")
    private AndroidElement current_organization;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Select Gender']")
    private AndroidElement text_selectgender;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile Number']")
    private AndroidElement text_phoneno;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Download Policy']")
    private AndroidElement text_downloadPolicy;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Congratulations']")
    private AndroidElement text_congratulation;

    @AndroidFindBy(xpath = "//android.widget.AutoCompleteTextView[@text= 'Age should be between 18-99']")
    private AndroidElement nominee_age_enterfield;

    public void clickOnNomineeAge() throws InterruptedException{
        Elements.selectElement(driver,nominee_age_enterfield,"Click on Nominee Age");
    }

    public void clickonCancelConfirmationYesPlease() throws InterruptedException{
        Elements.selectElement(driver,ctaCancel_yesplease_myPolicy,"Click on Yes,please cancel");
    }

    public void clickonCancelPolicyOnHistory() throws InterruptedException{
        Elements.selectElement(driver,cta_cancelPolicy,"Click on History button cancel Policy");
    }

    public void enterOnNomineeAge(String age) throws InterruptedException {
        Elements.enterToElement(driver, nominee_age_enterfield, age, "Enter Nominee Name");
    }

    public String gettextfullName() throws InterruptedException {
        return Elements.getText(driver,text_fullname, "Text Full name");
    }

    public String gettextSelectGender() throws InterruptedException {
        return Elements.getText(driver,text_selectgender, "text select gender");
    }


    public String gettextCongratulation() throws InterruptedException {
        return Elements.getText(driver,text_congratulation, "text congratulation");
    }

    public String gettextDownloadPolicy() throws InterruptedException {
        return Elements.getText(driver,text_downloadPolicy, "text download policy");
    }

    public String gettextViewMore() throws InterruptedException {
        return Elements.getText(driver,text_viewMore, "text view more");
    }

    public String gettextPhoneNo() throws InterruptedException {
        return Elements.getText(driver,text_phoneno, "Text phone no");
    }

    public void clickOnMonthlyGrossSalaryTextfield() throws InterruptedException{
        Elements.selectElement(driver,monthly_gross_salary,"Click on Monthly gross Salary");
    }

    public void clickOndobfield() throws InterruptedException{
        Elements.selectElement(driver,dateofbirth_textview,"Click on Date of birth");
    }

    public void clickOnselectCTA() throws InterruptedException{
        Elements.selectElement(driver,select_cta,"Click on Select");
    }

    public void clickOnBackIcon() throws InterruptedException{
        Elements.selectElement(driver,back_arrow,"Click on BackButton");
    }

    public void clickOnMonthlyGrossSalary() throws InterruptedException{
        Elements.selectElement(driver,monthly_gross_salary,"Monthly Gross Salary");
    }
    public void enterMonthlyGrossSalary(String grosssalary) {
        Elements.enterToElement(driver, monthly_gross_salary, grosssalary, "Monthly Gross Salary");
    }

    public void enterNameOfCurrentOrganization(String currentorganization) {
        Elements.enterToElement(driver, current_organization, currentorganization, "Name of Current Organization");
    }
    public void clickOnContinueButton() throws InterruptedException{
        Elements.selectElement(driver,cta_continue,"Click on Continue button");
    }

    public void clickOnContinueButtonOnFormPage() throws InterruptedException{
        Elements.selectElement(driver,cta_continue_formfield,"Click on Continue button on form field");
    }

    public void clickOnskipNominee() throws InterruptedException{
        Elements.selectElement(driver,skip_nominee,"Click on Exit Nominee");
    }


    public void clickAllServices() {
        Elements.selectElement(driver, allServices, "All Services");
    }
    public boolean scrollToInsurance() throws InterruptedException {
        return Elements.scrollToElement(driver,insuranceCTA);
    }


    public boolean scrollToContinueButton() throws InterruptedException {
        return Elements.scrollToElement(driver,cta_continue_formfield);
    }

    public void clickOnCommunicableDisesInsurance() throws InterruptedException{
        Elements.selectElement(driver,text_communicable_dises,"Click on Communicable Diseases Insurance");
    }
    public String getCommunicableDisesInsuranceText() throws InterruptedException {
        return Elements.getText(driver,text_communicable_dises, "Heading Communicable Diseases Insurance");
    }

    public void clickOnInsurance() throws InterruptedException{
        Elements.selectElement(driver,insuranceCTA,"Click on Insurance");
    }
    public String getInsuranceText() throws InterruptedException {
        return Elements.getText(driver,insuranceCTA, "Heading Insurance");
    }
    public String getHeadingGroupInsurance() throws InterruptedException {
        return Elements.getText(driver,sub_heading_group_insurance, "Heading Group Insurance");
    }
    public String getLossOfJob() throws InterruptedException {
        return Elements.getText(driver,text_LossofJob, "Loss of Job Text");
    }

    public void clickOnLossOfJob() throws InterruptedException{
        Elements.selectElement(driver,text_LossofJob,"Loss of Job Text");
    }

    public String getyourPolicyCovers() throws InterruptedException {
        return Elements.getText(driver,text_policy_cover, "your policy covers");
    }

    public String getSecondSubheaderRetailInsurance() throws InterruptedException {
        return Elements.getText(driver,sub_heading_retail_insurance, "Retail Insurance");
    }


    public String getPersonalAccidentInsurance() throws InterruptedException {
        return Elements.getText(driver,text_personalAccidentInsurance, "Personal Accident Insurance");
    }

    public String getComprehensivePersonalAccidentInsurance() throws InterruptedException {
        return Elements.getText(driver,text_comprehensivepersonalAccidentInsura, "Comprehensive Personal Accident Insurance");
    }

    public void clickComprehensivePersonalAccidentInsurance() throws InterruptedException{
        Elements.selectElement(driver,text_comprehensivepersonalAccidentInsura,"Comprehensive Personal Accident Insurance");
    }

    public void clickOnCalender() throws InterruptedException{
        Elements.selectElement(driver,calender_click,"Calender Click");
    }

    public void clickOnGeneratePolicy() throws InterruptedException{
        Elements.selectElement(driver,generatePolicy_cta,"Generate Policy");
    }

    public void clickOnPersonalAccidentInsurance() throws InterruptedException{
        Elements.selectElement(driver,text_personalAccidentInsurance,"Personal Accident Insurance");
    }

    public void clickOnPersonalAccidentInsurancesubheading() throws InterruptedException{
        Elements.selectElement(driver,text_personalAccidentInsurance_subheading,"Personal Accident Insurance subheading");
    }

    public String getWalletProtectInsurance() throws InterruptedException {
        return Elements.getText(driver,text_walletProtect, "Wallet Protect");
    }

    public void clickOnWalletProtectInsurance() throws InterruptedException{
        Elements.selectElement(driver,text_walletProtect,"Click on Wallet Protect");
    }

    public String getHealthInsurance() throws InterruptedException {
        return Elements.getText(driver,text_healthInsurance, "Health Insurance");
    }

    public void clickOnHealthInsuranceInsurance() throws InterruptedException{
        Elements.selectElement(driver,text_healthInsurance,"Health Insurance");
    }

    public String getDocAssure() throws InterruptedException {
        return Elements.getText(driver,text_docAssure, "DOc assure");
    }

    public void clickOnDocAssureInsurance() throws InterruptedException{
        Elements.selectElement(driver,text_docAssure,"DOc assure");
    }

    public String getPayyourexistinginsurancePremium() throws InterruptedException {
        return Elements.getText(driver,text_payyourexistinginsurancePremium, "Pay your existing insurance Premium");
    }

    public void clickOnsumassuredbutton() throws InterruptedException{
        Elements.selectElement(driver,picebutton_onDocInsurancePage,"Pay your existing insurance Premium");
    }

    public void clickOnsumassuredbutton1() throws InterruptedException{
        Elements.selectElement(driver,picebutton_onDocInsurancePage1,"Pay your existing insurance Premium");
    }

    public void clickOnsumassured20button() throws InterruptedException{
        Elements.selectElement(driver,picebutton20_onInsurancePage1,"Pay 20 your existing insurance Premium");
    }



    public void clickOnPayyourexistinginsurance() throws InterruptedException{
        Elements.selectElement(driver,text_payyourexistinginsurancePremium,"Pay your existing insurance Premium");
    }

    public String getMyPolicies() throws InterruptedException {
        return Elements.getText(driver,heading_myPolices, "My Policies");
    }

    public void clickOnMyPolicies() throws InterruptedException{
        Elements.selectElement(driver,heading_myPolices,"My Policies");
    }

    public String getMakePayment() throws InterruptedException {
        return Elements.getText(driver,cta_make_payment, "Make Payment");
    }

    public String getSelectSumassured() throws InterruptedException {
        return Elements.getText(driver,heading_selectSumIssured, "Select Sum Insured");
    }

    public String getProductBenifit() throws InterruptedException {
        return Elements.getText(driver,text_product_benefits, "Product Benifit");
    }

    public String getMarketValue() throws InterruptedException {
        return Elements.getText(driver,text_market_value, "Market Value");
    }

    public String getPartnerName() throws InterruptedException {
        return Elements.getText(driver,text_partner_name, "Partner Name");
    }

    public String getStartDate() throws InterruptedException {
        return Elements.getText(driver,text_start_date, "Start Date");
    }

    public String getEndDate() throws InterruptedException {
        return Elements.getText(driver,text_end_date, "End Date");
    }

    public String getAmounttobePaid() throws InterruptedException {
        return Elements.getText(driver,text_amount_to_be_paid, "Amount to be paid");
    }

    public String getCoverage() throws InterruptedException {
        return Elements.getText(driver,text_coverage, "Get Coverage");
    }

    public String getInsuredBy() throws InterruptedException {
        return Elements.getText(driver,text_insured_by, "Get Insured By");
    }

    public void clickOncheckBox() throws InterruptedException{
        Elements.selectElement(driver,checkbox,"Click on CheckBox");
    }
    public void clickOnMakePayment() throws InterruptedException{
        Elements.selectElement(driver,cta_make_payment,"Make Payments");
    }

    public String getPayableAmount() throws InterruptedException {
        return Elements.getText(driver,text_payable_amount, "Amount to be paid");
    }

    public void clickOnHospicash() throws InterruptedException{
        Elements.selectElement(driver,text_hospicash,"Click on Hospicash");
    }

    public String getHospicashText() throws InterruptedException {
        return Elements.getText(driver,text_hospicash, "get text  Hospicash");
    }

    public String get30DaysCoveage() throws InterruptedException {
        return Elements.getText(driver,text_30daysCoverage, "Get 30 days coverage");
    }

    public void clickOnDengue() throws InterruptedException{
        Elements.selectElement(driver,text_dengue,"Click on Dengue");
    }

    public String gettextDengue() throws InterruptedException {
        return Elements.getText(driver,text_dengue, " get text Dengue");
    }


    public InsurancePage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        Log.info("*****Insurance Page*****");
    }

}