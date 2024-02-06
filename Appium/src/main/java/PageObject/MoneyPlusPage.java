package PageObject;

import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MoneyPlusPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Services']")
    private AndroidElement allServices;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Money +']")
    private AndroidElement moneyPlus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Track all your bank accounts in one place']")
    private AndroidElement account_agregator_card;

    @AndroidFindBy(id = "txtIntro")
    private AndroidElement account_agregator_intro_page_text;

    @AndroidFindBy(id="mkab_left_icon")
    private AndroidElement navigate_back;

    @AndroidFindBy(id="btn_back")
    private AndroidElement navigate_back2;

    @AndroidFindBy(id="tvNetWorthAmount")
    private AndroidElement net_worth_amount;

    @AndroidFindBy(id="tvNetIncrement")
    private AndroidElement net_increment;

    @AndroidFindBy(id="tvNetIncrementPercent")
    private AndroidElement net_increment_percent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Start Investing']")
    private AndroidElement xtra_card;

    @AndroidFindBy(id="title")
    private AndroidElement xtra_page_title;

    @AndroidFindBy(id = "tvAmountLeft")
    private AndroidElement gold_current_value;

    @AndroidFindBy(id = "tvAmountRight")
    private AndroidElement gold_1_day_change_value;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Build wealth with direct mutual funds']")
    private AndroidElement mf_card;

    @AndroidFindBy(id="btn_get_started")
    private AndroidElement mf_introPage_cta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PF account balance']")
    private AndroidElement epfo_card;

    @AndroidFindBy(id="txtIntroTitle")
    private AndroidElement epfo_introPage_title;


    public MoneyPlusPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickAllServices(){
        Elements.selectElement(driver, allServices,"Click on All Services");
    }

    public boolean scrollToOnMoneyPlusOptn() throws InterruptedException {
        return Elements.scrollToElement(driver, moneyPlus);
    }

    public void clickOnMoneyPlus(){
        Elements.selectElement(driver, moneyPlus,"Click on Money +");
    }

    public boolean checkMoneyPlusOptn() throws InterruptedException {
        return Elements.isElementPresent(driver, moneyPlus);
    }

    public void clickOnAccountAggregatorCard(){
        Elements.selectElement(driver, account_agregator_card,"Click on Account Aggregator Card");
    }

    public String fetchAccountAggregatorIntroText() throws InterruptedException{
        return Elements.getText(driver, account_agregator_intro_page_text);

    }

    public void navigateBack() throws InterruptedException{

        if(Element.isElementPresent(driver,By.id("mkab_left_icon"))) {
            Elements.selectElement(driver, navigate_back, "Navigating Back");
        }else {
            Elements.selectElement(driver, navigate_back2, "Navigating Back");
        }
    }

    public String fetchNetWorthAmount() throws InterruptedException{
        return Elements.getText(driver, net_worth_amount);

    }
    public String fetchNetIncrement() throws InterruptedException{
        return Elements.getText(driver, net_increment);

    }

    public String fetchNetIncrementPercentage() throws InterruptedException{
        return Elements.getText(driver, net_increment_percent);

    }

    public void clickOnXtraCard() throws InterruptedException {
        Elements.selectElement(driver, xtra_card,"Click on Xtra Card");
    }

    public String fetchXtraIntroText() throws InterruptedException{
        return Elements.getText(driver, xtra_page_title);

    }

    public String fetchGoldCurrentValue() throws InterruptedException{
        return Elements.getText(driver, gold_current_value).replace("₹", "");

    }

    public String fetchGold1DayChangeValue() throws InterruptedException{
        return Elements.getText(driver, gold_1_day_change_value);

    }

    public void clickOnMutualFundCard() throws InterruptedException {
        Elements.selectElement(driver, mf_card,"Click on MF Card");
    }

    public String fetchMFIntroPageCtaValue() throws InterruptedException{
        return Elements.getText(driver, mf_introPage_cta);

    }

    public void clickOnEpfoCard() throws InterruptedException {
        Elements.selectElement(driver, epfo_card,"Click on EPFO Card");
    }

    public String fetchEPFOIntroPageTitleValue() throws InterruptedException{
        return Elements.getText(driver, epfo_introPage_title);

    }








}
