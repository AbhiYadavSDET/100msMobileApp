package PageObject;

import Utils.Element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MutualFundPage {
    AndroidDriver driver;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Direct Mutual Funds']")
    private AndroidElement directMutualFunds;

    @AndroidFindBy(id = "btn_get_started")
    private AndroidElement getStarted;

    @AndroidFindBy(id = "tv_explore_button")
    private AndroidElement exploreMutualFunds;

    @AndroidFindBy(id = "title")
    private AndroidElement mutualFundName;

    @AndroidFindBy(id = "mininvestment_tv_value")
    private AndroidElement minimumInvestmentValue;

    @AndroidFindBy(id = "returns_value")
    private AndroidElement returnsValue;

    @AndroidFindBy(id = "rating_tv_value")
    private AndroidElement rating;

    @AndroidFindBy(id = "dropDownView")
    private AndroidElement selectMutualFunds;

    @AndroidFindBy(id = "btnOneTime")
    private AndroidElement oneTime;

    @AndroidFindBy(id = "btnSip")
    private AndroidElement sip;

    @AndroidFindBy(id = "vertical_button_2")
    private AndroidElement backToHome;

    @AndroidFindBy(id = "title_text")
    private AndroidElement popUPTitle;

    @AndroidFindBy(id = "body_text")
    private AndroidElement popUPSubTitle;

    @AndroidFindBy(id = "primary_button")
    private AndroidElement popUPCtaText;


    @AndroidFindBy(id = "icon_profile")
    private AndroidElement profileIcon;

    @AndroidFindBy(id = "tv_edit")
    private AndroidElement editButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Retake']")
    private AndroidElement retakeButoon;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Start Now']")
    private AndroidElement startNow;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='More than 10 years'])")
    private AndroidElement investmentTimeFor;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='I plan to withdraw my funds all at once.'])")
    private AndroidElement investmentTimeLast;

    @AndroidFindBy(id = "btn_save")
    private AndroidElement saveButtonOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='5 - 10 lakhs']")
    private AndroidElement annualIncomeOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Yes']")
    private AndroidElement isPrimaryBreadWinnderOption;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Avoiding loss, minimum risks']")
    private AndroidElement careMostOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Buy more']")
    private AndroidElement investmentDownOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Very comfortable']")
    private AndroidElement investmentGoUpOption;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='10 - 25 lakhs']\n")
    private AndroidElement currentSavingOption;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Learn about Mutual Funds']")
    private AndroidElement learnAboutMutualFunds;


    @AndroidFindBy(id = "tv_title")
    private AndroidElement faqText;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']\n")
    private AndroidElement privacyPolicy;


    @AndroidFindBy(id = "tv_title")
    private AndroidElement privacyPolicyText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recommended combination for you']")
    private AndroidElement riskAnalyserSuccess;



    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Liquid Funds']")
    private AndroidElement liquidFunds;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Better Than FD']")
    private AndroidElement betterThanFd;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tax Saver']")
    private AndroidElement taxSaver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Get Rich']")
    private AndroidElement getRich;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement titleofFDs;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement backButton;




































    public MutualFundPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnMutualFunds() throws InterruptedException {
        Element.selectElement(driver, directMutualFunds, "Click on Mutual Funds");
    }

//    public boolean isGetStartedPresent() throws InterruptedException {
//        return Element.isElementPresent(driver,getStarted);
//    }

    public void clickOnGetStarted() throws InterruptedException {
        Element.selectElement(driver, getStarted, "Click on Get Started");
    }


    public void clickOnExploreMutualFunds() throws InterruptedException {
        Element.selectElement(driver, exploreMutualFunds, "Click on Explore Mutual Funds");
    }

    public void selectMutualFund() throws InterruptedException {
        Element.selectElement(driver, selectMutualFunds, "Click on Mutual Fund");
    }

    public void clickOnOneTime() throws InterruptedException {
        Element.selectElement(driver, oneTime, "Click on one time pay");
    }

    public void clickOnSip() throws InterruptedException {
        Element.selectElement(driver, sip, "Click on SIP");
    }

    public void clickOnBackToHome() throws InterruptedException {
        Element.selectElement(driver, backToHome, "Click on Wealth Portfolios");
    }

    public String getMutualFundName() throws InterruptedException {
        return Element.getText(driver, mutualFundName, "Get Mutual Fund Name");
    }

    public String getMinimumInvestmentAmount() throws InterruptedException {
        return Element.getText(driver, minimumInvestmentValue, "Get Minimum Investment Amount");
    }

    public String getReturns() throws InterruptedException {
        return Element.getText(driver, returnsValue, "Get Mutual Fund Returns");
    }

    public String getRating() throws InterruptedException {
        return Element.getText(driver, rating, "Get Mutual Fund Rating");
    }

    public String getPopUpTitle() throws InterruptedException {
        return Element.getText(driver, popUPTitle, "Pop Up Title");
    }

    public String getPopUpSubTitle() throws InterruptedException {
        return Element.getText(driver, popUPSubTitle, "Pop Up Sub Title");
    }

    public String getPopUpCtaText() throws InterruptedException {
        return Element.getText(driver, popUPCtaText, "Pop Up Cta Text");
    }

    public void clickOnProfile() throws InterruptedException {
        Element.selectElement(driver, profileIcon, "Click on Profile icon on MF home page");
    }
    public void clickOnEditButton() throws InterruptedException {
        Element.selectElement(driver, editButton, "Click on Edit button on prfile page ");
    }



    public void clickOnRetakeButton() throws InterruptedException {
        Element.selectElement(driver, retakeButoon, "Click on retake button");
    }
    public void clickOnStartNow() throws InterruptedException {
        Element.selectElement(driver, startNow, "Click on Start now");
    }
    public void clickOnInvsetmentTimeFor() throws InterruptedException {
        Element.selectElement(driver, investmentTimeFor, "select investmentTimeFor option ");
    }

    public void clickOnInvsetmentTimeLast() throws InterruptedException {
        Element.selectElement(driver, investmentTimeLast, "select investmentTimeLast option ");
    }

    public void clickOnAnnualIncomeOption() throws InterruptedException {
        Element.selectElement(driver, annualIncomeOption, "select annual income  option ");
    }
    public void clickOnIsPrimaryBreadWinner() throws InterruptedException {
        Element.selectElement(driver, isPrimaryBreadWinnderOption, "select is primary bread winner option ");
    }
    public void clickOnCareMostOption() throws InterruptedException {
        Element.selectElement(driver, careMostOption, "select care most  option ");
    }
    public void clickOnInvestmentDownOption() throws InterruptedException {
        Element.selectElement(driver, investmentDownOption, "select investment down option ");
    }
    public void clickOnInvestmentGoUpDownOption() throws InterruptedException {
        Element.selectElement(driver, investmentGoUpOption, "select investment go up and down  situation ");
    }
    public void clickOnCurrentSavingOption() throws InterruptedException {
        Element.selectElement(driver, currentSavingOption, "select investmentTimeLast option ");
    }

    public void clickOnSaveButton() throws InterruptedException {
        Element.selectElement(driver, saveButtonOption, "Click on save button ");
    }

    public void clickOnLearnAboutMutualFunds() throws InterruptedException {
        Element.selectElement(driver, learnAboutMutualFunds, "Click on Learn mutual funds ");
    }
    public void clickOnFaq() throws InterruptedException {
        Element.selectElement(driver,learnAboutMutualFunds, "Click on FAQ ");
    }

    public String getTitleOnFaq(){
        return Element.getText(driver, faqText, " title on FAQ page");
    }

    public void clickOnPrivacyPolicy() throws InterruptedException {
        Element.selectElement(driver, privacyPolicy, "Click on privacy policy");
    }

    public String getTitleOnPrivacyPolicy(){
        return Element.getText(driver, privacyPolicyText, " title on privacy policy ");
    }

    public String getTextOnRiskAnalyserSuccessScreen(){
        return Element.getText(driver, riskAnalyserSuccess, " Risk analyser text on success screen ");
    }


    public void clickOnLiquidFunds() throws InterruptedException {
        Element.selectElement(driver, liquidFunds, "Click on Liquid Funds");
    }
    public void clickOnBetterThanFd() throws InterruptedException {
        Element.selectElement(driver, betterThanFd, "Click onbetter than FD");
    }
    public void clickOnTaxSaver() throws InterruptedException {
        Element.selectElement(driver, taxSaver, "Click on Tax saver");
    }
    public void clickOnGetRich() throws InterruptedException {
        Element.selectElement(driver, getRich, "Click on get Rich");
    }

    public String getTitleOfFDs(){
        return Element.getText(driver, titleofFDs, " Title of FDs ");
    }

    public void clickOnBackButton() throws InterruptedException {
        Element.selectElement(driver, backButton, "Click on back button");
    }

}