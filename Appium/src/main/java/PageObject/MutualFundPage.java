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

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/title_text")
    private AndroidElement popUPTitle;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/body_text")
    private AndroidElement popUPSubTitle;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/primary_button")
    private AndroidElement popUPCtaText;


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

}