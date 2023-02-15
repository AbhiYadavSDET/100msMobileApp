package PageObject;

import Logger.Log;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountAggregatorPage {
    AndroidDriver driver;

    @AndroidFindBy(id="tx_balance")
    private AndroidElement userLoggedIn;

    @AndroidFindBy(xpath = "//*[@text = 'All Services']")
    private AndroidElement allServicesCTA;

    @AndroidFindBy(xpath = "//*[@text = 'Money +']")
    private AndroidElement moneyPlusCTA;

    @AndroidFindBy(xpath = "//*[@text = 'Track investments']")
    private AndroidElement trackInvestmentCTA;


    @AndroidFindBy(xpath = "//*[@text='Bank Accounts']")
    private AndroidElement accountAggregatorCard;

    @AndroidFindBy(id="touch_outside")
    private AndroidElement touchOutsideCTA;



    @AndroidFindBy(id="com.mobikwik_new.debug:id/icon_chevron")
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

    @AndroidFindBy(xpath = "//*[@text='Account Holder Name']")
    private AndroidElement userDetails;

    @AndroidFindBy(id="left_icon_filter")
    private AndroidElement applyFilter;






    public AccountAggregatorPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("***** Account Aggregator *****");

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

    //for Entry from track all investment cta ---
    public void trackInvestmentCTA() throws InterruptedException{
        Elements.selectElement(driver, trackInvestmentCTA, "Click on Track all your investment cta");
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


    public void userDetails() throws InterruptedException{Elements.selectElement(driver, userDetails, "Check the user details");}

    public void applyFilter() throws InterruptedException{Elements.selectElement(driver,applyFilter, "Apply filter");}
    public void bankDetailsCTA() throws InterruptedException{Elements.selectElement(driver,bankDetailsCTA, "Click on bank details cta");}

    public String getuserDetails() throws InterruptedException
    {
        return Elements.getText(driver, userDetails, "Check for the details");

    }
}




