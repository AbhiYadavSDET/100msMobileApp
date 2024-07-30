package PageObject;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;

public class EpfoPage {

    AndroidDriver driver;

    public EpfoPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Services']")
    private AndroidElement allServicesButton;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Track EPF Balance']")
    private AndroidElement ctaTrackBalance;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Total EPF Balance']")
    private AndroidElement totalEpfBalanceCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'RECENT CONTRIBUTION']")
    private AndroidElement recentContributionCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'View Full Statement']")
    private AndroidElement viewFullStatementCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Total Balance']")
    private AndroidElement totalBalanceCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'YOUR RETIREMENT FUND']")
    private AndroidElement yourRetirementFundCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'CURRENT EMPLOYER']")
    private AndroidElement currentEmployeeCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Invite family & friends to track their EPF']")
    private AndroidElement inviteFriendText;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Need help ?']")
    private AndroidElement NeedHelpTxt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Contact us']")
    private AndroidElement contactUsCTA;

    @AndroidFindBy(id = "toolbar")
    private AndroidElement back_arrow;

    @AndroidFindBy(xpath = "//*[contains(@text,'View All Employers')]")
    private AndroidElement viewAllEmp;

    @AndroidFindBy(id = "txt_net_amount")
    private AndroidElement txt_net_amount;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Track your Employee Provident Fund']")
    private AndroidElement trackYourEmpoProvidenttxt;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = 'Continue']")
    private AndroidElement continueCTA;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Input your UAN']")
    private AndroidElement inputYourUAN;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Know more about activation']")
    private AndroidElement   knowmoreaboutActivationTxt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Find your UAN']")
    private AndroidElement   findYourUAN;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Enter UAN Number']")
    private AndroidElement enterUANNumber;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = 'Proceed']")
    private AndroidElement proceedCTA;

    @AndroidFindBy(id = "icon_info")
    private AndroidElement icfoIcon;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Interest Earned']")
    private AndroidElement interestEarned_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Name']")
    private AndroidElement name_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Active since']")
    private AndroidElement activesince_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Work experience']")
    private AndroidElement workexperience_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Employee Share']")
    private AndroidElement employeesShare_txt_bottomsheet;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Employer Share']")
    private AndroidElement employersShare_txt_bottomsheet;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Employee’s Share']")
    private AndroidElement EmployeesShare_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Employer’s Share']")
    private AndroidElement employersShare_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Pension Share (EPS)']")
    private AndroidElement pensionShare_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Total EPF Balance']")
    private AndroidElement totalEPFBalance_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Fiscal Year']")
    private AndroidElement fiscalYear;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Fiscal Year']")
    private AndroidElement fy201112;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Deposit']")
    private AndroidElement deposit;

    @AndroidFindBy(id = "txtType")
    private AndroidElement desposit_array_1st;

    public void clickOnInfoIcon() {
        Elements.selectElement(driver, icfoIcon, "click On Info Icon");
    }

    public void clickOnInterestEarned() {
        Elements.selectElement(driver, interestEarned_txt, "click On Info Icon next to interest i");
    }

    public String getInterestEarned() throws InterruptedException {
        return Elements.getText(driver, interestEarned_txt, "Get ifo Icon interest");
    }

    public String getNametxt() throws InterruptedException {
        return Elements.getText(driver, name_txt, "Get Name");
    }

    public String getActivesince() throws InterruptedException {
        return Elements.getText(driver,activesince_txt, "Get Active since");
    }

    public String getWorkexperience() throws InterruptedException {
        return Elements.getText(driver,workexperience_txt, "Get Work experience");
    }

    public String getemployeeShare() throws InterruptedException {
        return Elements.getText(driver, EmployeesShare_txt, "Get Employee’s Share");
    }
    public String getemployersShare() throws InterruptedException {
        return Elements.getText(driver, employersShare_txt, "Get Employer’s Share");
    }

    public String getemployeeSharebottomsheet() throws InterruptedException {
        return Elements.getText(driver, employeesShare_txt_bottomsheet, "Get Employee’s Share");
    }

    public String getemployerSharebottomsheet() throws InterruptedException {
        return Elements.getText(driver, employersShare_txt_bottomsheet, "Get Employer Share");
    }

    public String getPensionShare() throws InterruptedException {
        return Elements.getText(driver, pensionShare_txt, "Get Pension Share");
    }

    public void clickPensionShare() {
        Elements.selectElement(driver, pensionShare_txt, "click on pension Share");
    }

    public String getTotalEPFBalance() throws InterruptedException {
        return Elements.getText(driver, totalEPFBalance_txt, "Get Total EPF Balance");
    }

    public void clickAllServices() {
        Elements.selectElement(driver, allServicesButton, "All Services");
    }

    public void scrollToTrackEpfBalance() throws InterruptedException {
        Elements.scrollToElement(driver,ctaTrackBalance);
    }
    public void clickTrackEpfBalance() {
        Elements.selectElement(driver, ctaTrackBalance, "Track EPF Balance");

    }

    public String getTotalEpfBalanceCTA() throws InterruptedException {
        return Elements.getText(driver, totalEpfBalanceCTA, "Total EPF Balance");
    }

    public String getRecentContributionCTA() throws InterruptedException {
        return Elements.getText(driver, recentContributionCTA, "Get Recent Contribution");
    }

    public String getViewFullStatementCTA() throws InterruptedException {
        return Elements.getText(driver, viewFullStatementCTA, "View Full Statement");
    }

    public void clickOnViewFullStatementCTA() {
        Elements.selectElement(driver, viewFullStatementCTA, "View Full Statement");

    }

    public void scrollToTotalBalanceCTA() throws InterruptedException {
        Elements.scrollToElement(driver,totalBalanceCTA);
    }

    public String getViewYourRetirementFund() throws InterruptedException {
        return Elements.getText(driver, yourRetirementFundCTA, "Your Retirement Fund");
    }

    public void scrollToCurrentEmployee() throws InterruptedException {
             Elements.scrollToElement(driver,currentEmployeeCTA);
    }

    public void clickToCurrentEmployee() {
        Elements.selectElement(driver, currentEmployeeCTA, "Click on Current Employee cta");

    }

    public void scrollToInviteFriendBanner() throws InterruptedException {
        Elements.scrollToElement(driver,inviteFriendText);
    }

    public void scrollToNeedHelp() throws InterruptedException {
        Elements.scrollToElement(driver,NeedHelpTxt);
    }

    public String getContactUsCTA() throws InterruptedException {
        return Elements.getText(driver, contactUsCTA, "Contact us CTA");
    }

    public Boolean isViewAllEmplyCTA() throws InterruptedException {
        return  Elements.isElementPresent(driver,viewAllEmp );
    }

    public Boolean isBalancePresent() throws InterruptedException {
        return  Elements.isElementPresent(driver,txt_net_amount );
    }


    public String getTrackYourEmpoProvidentFund() throws InterruptedException {
        return Elements.getText(driver, trackYourEmpoProvidenttxt, "Track Your Emp oProvident Fund");
    }

    public void clickContinueCTA() {
        Elements.selectElement(driver, continueCTA, "Click on Continue CTA");
    }

    public String getInutyourUANtxt() throws InterruptedException {
        return Elements.getText(driver, inputYourUAN, "input Your UAN txt ");
    }

    public String getknowMoreActivation() throws InterruptedException {
        return Elements.getText(driver, knowmoreaboutActivationTxt, "know more about Activation Txt");
    }

    public String getFindyourUAN() throws InterruptedException {
        return Elements.getText(driver, findYourUAN, "find Your UAN");
    }
    public void enterUANNumber(String UAN) {
        Elements.enterToElement(driver, enterUANNumber, UAN,"enter UAN number");
    }

    public String getProceedTxt() throws InterruptedException {
        return Elements.getText(driver, proceedCTA, "ProceedCTA");
    }

    public void clickOnDeposit() {
        Elements.selectElement(driver, deposit, "click On Deposit");
    }

    public void clickOnDepositfirstArrayItem() {
        Elements.selectElement(driver, desposit_array_1st, "click On Deposit first array items");
    }

    public void clickOnFiscalYear() {
        Elements.selectElement(driver, fiscalYear, "click On Fiscal Year");
    }


}
