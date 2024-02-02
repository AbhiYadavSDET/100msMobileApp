package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GoldPage {


    AndroidDriver driver;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Services']")
    private AndroidElement allServicesButton;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Buy 99.5% pure gold']")
    private AndroidElement goldButton;

    @AndroidFindBy(id = "buy_gold_btn")
    private AndroidElement buyGoldButton;

    @AndroidFindBy(id = "sell_gold_btn")
    private AndroidElement sellGoldButton;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'In Rupees']")
    private AndroidElement textAmount;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'In grams']")
    private AndroidElement textWeight;

    @AndroidFindBy(id = "buy_now_button")
    private AndroidElement buyNowCta;

    @AndroidFindBy(id = "btn_gold_action")
    private AndroidElement continueCta;

    @AndroidFindBy(id = "btn_gold_action")
    private AndroidElement sellGoldCta;

    @AndroidFindBy(id = "base_title")
    private AndroidElement successScreenBaseTitle;

    @AndroidFindBy(id = "base_subtitle")
    private AndroidElement successScreenBaseSubTitle;

    @AndroidFindBy(id = "txt_amount")
    private AndroidElement successScreenGoldWeight;

    @AndroidFindBy(id = "txt_total_amount")
    private AndroidElement successScreenTrxAmount;

    @AndroidFindBy(id = "base_icon_close")
    private AndroidElement successScreenCloseIcon;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement successScreenUpButton;

    public GoldPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickAllServices() {
        Elements.selectElement(driver, allServicesButton, "All Services");
    }

    public boolean scrollToBuyGold() throws InterruptedException {
        return Elements.scrollToElement(driver, goldButton);
    }

    public void clickBuyGold() {
        Elements.selectElement(driver, goldButton, "Buy Gold");
    }

    public boolean isBuyGoldPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, buyGoldButton);
    }

    public void clickBuyCta() {
        Elements.selectElement(driver, buyGoldButton, "Buy Gold");
    }

    public void clickSellCta() {
        Elements.selectElement(driver, sellGoldButton, "Sell Gold");
    }

    public void enterAmount(String amount) {
        Elements.enterToElement(driver, textAmount, amount, "Amount");
    }

    public void clickPayCta() {
        Elements.selectElement(driver, buyNowCta, "Pay Now");
    }

    public void clickContinueCta() {
        Elements.selectElement(driver, continueCta, "Continue");
    }

    public void clickSellGoldCta() {
        Elements.selectElement(driver, sellGoldCta, "Sell Gold");
    }

    // Success Screen methods
    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, successScreenBaseTitle, "Base Title");
    }

    public String getSubTitle() throws InterruptedException {
        return Elements.getText(driver, successScreenBaseSubTitle, "Sub Title");
    }

    public String getGoldAmount() throws InterruptedException {
        return Elements.getText(driver, successScreenGoldWeight, "Gold Amount");
    }

    public String getAmount() throws InterruptedException {
        return Elements.getText(driver, successScreenTrxAmount, "Amount");
    }

    public void clickCloseIcon() {
        Elements.selectElement(driver, successScreenCloseIcon, "Close Icon");
    }

    public void clickUpIcon() {
        Elements.selectElement(driver, successScreenUpButton, "Up Icon");
    }

}
