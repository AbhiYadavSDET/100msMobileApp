package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'History']")
    private AndroidElement historyTab;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Home']")
    private AndroidElement homeTab;

    @AndroidFindBy(id = "txt_transaction_summary")
    private AndroidElement historyDescription;

    @AndroidFindBy(xpath = "//*/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[2]")
    private AndroidElement historyAmount;

    @AndroidFindBy(id = "txt_status")
    private AndroidElement historyStatus;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'MobiKwik']")
    private AndroidElement mobikwik_header;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Bank A/C']")
    private AndroidElement bankAccount_header;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Credit Card']")
    private AndroidElement creditCard_header;

    @AndroidFindBy(id = "tv_btn")
    private AndroidElement letdoit_cta;

    @AndroidFindBy(id = "iv_title")
    private AndroidElement firsttimeuser_description_on_hisory;

    @AndroidFindBy(id = "txt_aa_not_setup_cta")
    private AndroidElement txt_aa_not_setup_cta;
    @AndroidFindBy(id = "txt_aa_not_setup_title")
    private AndroidElement txt_aa_not_setup_title;


    public HistoryPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickHistoryTab() {
        Elements.selectElement(driver, historyTab, "History Tab");
    }

    public void clickHomeTab() {
        Elements.selectElement(driver, homeTab, "Home Tab");
    }

    public boolean isHistoryDesciptionPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, historyDescription);
    }

    public String getDescription() throws InterruptedException {
        return Elements.getText(driver, historyDescription, "History Description");
    }

    public String getAmount() throws InterruptedException {
        return Elements.getText(driver, historyAmount, "History Amount");
    }

    public String getStatus() throws InterruptedException {
        return Elements.getText(driver, historyStatus, "History Status");
    }

    public void clickMobikwikHeaderOnHistory() {
        Elements.selectElement(driver, mobikwik_header, "Mobikwik Tab on History Section");
    }

    public void clickBankAccountOnHistory() {
        Elements.selectElement(driver, bankAccount_header, "Bank Account Tab on History Section");
    }

    public void clickCreditCardOnHistory() {
        Elements.selectElement(driver, creditCard_header, "Credit card Tab on History Section");
    }

    public boolean isLetsDobuttonPresentOnMobiwiktab() throws InterruptedException {
        return Elements.isElementPresent(driver, letdoit_cta);
    }

    public boolean isdescriptionPresentOnMobiwiktab() throws InterruptedException {
        return Elements.isElementPresent(driver, firsttimeuser_description_on_hisory);
    }

    public boolean isNotSetupAACTA() throws InterruptedException {
        return Elements.isElementPresent(driver, txt_aa_not_setup_cta);
    }

    public boolean isNotSetupAAtTitle() throws InterruptedException {
        return Elements.isElementPresent(driver, txt_aa_not_setup_title);
    }


    }


