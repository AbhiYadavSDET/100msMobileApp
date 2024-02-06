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

    @AndroidFindBy(xpath = "//*[@text = 'Contact us']")
    private AndroidElement ctaContactUs;

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
}






















