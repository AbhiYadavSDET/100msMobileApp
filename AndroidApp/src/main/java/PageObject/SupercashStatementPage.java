package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

public class SupercashStatementPage {

    AndroidDriver driver;

    @AndroidFindBy(id="layout_add_money")
    private AndroidElement wallet_button;

    @AndroidFindBy(id="points_balance")
    private AndroidElement supercash_balance;

    @AndroidFindBy(id="date")
    private AndroidElement supercash_record_date;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Statement']")
    private AndroidElement statement_button;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'HISTORY']")
    private AndroidElement history_tab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SUMMARY']")
    private AndroidElement summary_tab;

    @AndroidFindBy(id="tv_right")
    private AndroidElement faq;

    @AndroidFindBy(id="tv_use_here")
    private AndroidElement use_here;

    @AndroidFindBy(id="redeem_supercash")
    private AndroidElement redeem_button;

    @AndroidFindBy(id="monthly_saving_icon")
    private AndroidElement month_change_icon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Buy Now']")
    private AndroidElement buy_now_button;

    public SupercashStatementPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Supercash Statement Page*****");
    }

    public void validateSupercashDate() throws InterruptedException{
        Element.isElementPresent(driver, By.id("supercash_record_date"));
    }
    public void clickWalletButton() throws InterruptedException{
        Element.selectElement(driver, wallet_button, "Click on Wallet Button");}

    public void clickStatementButton() throws InterruptedException{
        Element.selectElement(driver, statement_button, "Click on Statement Button");
    }

    public void switchToSummaryTab() throws  InterruptedException{
        Element.selectElement(driver,summary_tab,"Switching to Summary Tab");
    }

    public void switchToHistoryTab() throws  InterruptedException{
        Element.selectElement(driver,history_tab,"Switching to History Tab");
    }

    public String getPointsBalance() throws InterruptedException{
        return Element.getText(driver, supercash_balance, "Supercash Balance");
    }

    public void changeMonthButton() throws InterruptedException{
        Element.selectElement(driver, month_change_icon, "To change date");
    }

    public void clickOnFAQ() throws InterruptedException{
        Element.selectElement(driver, faq, "Click on FAQ Button");
    }

    public void clickOnUseHere() throws InterruptedException{
        Element.selectElement(driver, use_here, "Click on Use Here Button");
    }

    public void clickOnRedeemButton() throws InterruptedException{
        Element.selectElement(driver, redeem_button, "Click on Redeem Button");
    }

    public void clickOnOfferButton() throws InterruptedException{
        Element.selectElement(driver, buy_now_button, "Click on Buy Now");
    }
}
