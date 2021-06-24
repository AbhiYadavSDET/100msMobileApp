package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class MutualFundPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "viewAllFunds")
    private AndroidElement viewFunds;

    @AndroidFindBy(id = "mkiv_image")
    private AndroidElement image_growth;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Wealth Portfolios']")
    private AndroidElement cta_wealth_portfolios;

    @AndroidFindBy(id="tv_label_pack_list")
    private AndroidElement get_Label_text;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Kwik Save: Instant Withdrawal']")
    private AndroidElement cta_kwik_save_instant_withdrawal;

    @AndroidFindBy(id="content_title")
    private AndroidElement get_title_text;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Save monthly with SIPs']")
    private AndroidElement cta_save_monthly_with_sip;

    @AndroidFindBy(id="riskBaseTitle")
    private AndroidElement get_risk_base_title;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Make a one time investment']")
    private AndroidElement cta_make_a_one_time_investment;

    @AndroidFindBy(id="mkab_title")
    private  AndroidElement get_header_text;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Save Taxes with ELSS Mutual Funds']")
    private AndroidElement cta_elss_mutual_funds;

    @AndroidFindBy(id="icon_back")
    private AndroidElement back_button;




    public MutualFundPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isViewAllFunds() throws InterruptedException {
        return (Element.isElementPresent(driver, (By.id("viewAllFunds"))));
    }

    public boolean isVisibleGrowthImage() throws InterruptedException {
        return (Element.isElementPresent(driver, By.id("mkiv_image")));
    }

    public void clickOnWealthPortfolios() throws InterruptedException {
        Element.selectElement(driver, cta_wealth_portfolios, " Click on Wealth Portfolios");
    }

    public String getLabelText() throws InterruptedException{
        return Element.getText(driver, get_Label_text, "Get Label Text");
    }

    public void clickOnKwikSave() throws InterruptedException {
        Element.selectElement(driver, cta_kwik_save_instant_withdrawal, " Click on Kwik Save");
    }

    public String getTitleText() throws InterruptedException{
        return Element.getText(driver, get_title_text, "Get Title Text");
    }

    public void clickOnMonthlySip() throws InterruptedException {
        Element.selectElement(driver, cta_save_monthly_with_sip, " Click on Save on Monthly SIP");
    }

    public String getRiskBaseTitle() throws InterruptedException{
        return Element.getText(driver, get_risk_base_title, "Get Risk Base Title");
    }

    public void clickOnOneTimeInvestment() throws InterruptedException {
        Element.selectElement(driver, cta_make_a_one_time_investment, " Click on One Time Investment");
    }

    public String getHeaderTitleText() throws InterruptedException{
        return Element.getText(driver, get_header_text, "Get Header Title Page");
    }

    public void clickOnElssMutualFunds() throws InterruptedException {
        Element.selectElement(driver, cta_elss_mutual_funds, " Click on Elss Mutual Funds");
    }

    public void clickOnBackButton() throws InterruptedException {
        Element.selectElement(driver, back_button, " Click on Back button");
    }
}
