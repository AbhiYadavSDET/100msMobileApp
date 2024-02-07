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
    @AndroidFindBy(xpath = "//*[@text = 'Fixed Deposits']")
    private AndroidElement fixedDepositCTA;
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

    @AndroidFindBy(xpath = "//*[@text = 'Married']")
    private AndroidElement ctaMarried;

    @AndroidFindBy(xpath = "//*[@text = 'Indian']")
    private AndroidElement ctaIndian;

    @AndroidFindBy(xpath = "//*[@text = 'Education Qualification']")
    private AndroidElement ctaEducationQualification;

    @AndroidFindBy(xpath = "//*[@text = 'Post Graduate']")
    private AndroidElement ctaPostGraduate;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Father')]")
    private AndroidElement select_fathername;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[4]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    private AndroidElement enter_fathername;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[contains(@text, 'Occupation')]")
    private AndroidElement ctaDropdownOccupationtype;
    @AndroidFindBy(xpath = "//*[@text = 'Student']")
    private AndroidElement selectOccupationType;

    @AndroidFindBy(xpath = "//*[@text = 'Proceed']")
    private AndroidElement ctaProceed;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement ctaNomineeName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[4]/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
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

    public FixedDepositPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("***** Account Aggregator *****");
    }

    public void allServicesCTA() throws InterruptedException{
        Elements.selectElement(driver,allServicesCTA,"Click on all services");
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

    public String getCTAContactUs() throws InterruptedException {
        return Elements.getText(driver,ctaContactUs, "CTA Contact Us");
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
        Elements.selectElement(driver,select_fathername,"select father name ");
    }
    public void enterFatherName(String fathername) throws InterruptedException {
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

    public void ctaNomineeName() throws InterruptedException{
        Elements.selectElement(driver,ctaNomineeName,"Select Nominee name");
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

    public void getEditOnNomineeDetails() throws InterruptedException{
         Elements.getText(driver,ctaEditonNomineeDetails,"CTA Edit");

    }


}






















