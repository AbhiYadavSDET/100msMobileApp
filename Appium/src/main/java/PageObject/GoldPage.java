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

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Gold']")
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


    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = 'Explore Gold SIP']")
    private AndroidElement explore_cta;

    @AndroidFindBy(id="txt_description_amount")
    private AndroidElement error_text;

    //Gold  Coin
    @AndroidFindBy(id = "goldCoinLbl")
    private AndroidElement goldCoin_txt;

    @AndroidFindBy(id = "mkiv_image")
    private AndroidElement goldCoin_img;

    @AndroidFindBy(id = "safegold_know_more")
    private AndroidElement safegold_know_more;

    @AndroidFindBy(id = "mkab_title")
    private AndroidElement title_aboutsafegold;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement enter_pincode;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'History']")
    private AndroidElement ctaHistory;

    @AndroidFindBy(id = "tv_gold_sip_heading")
    private AndroidElement tv_gold_sip_heading;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Gold SIP']")
    private AndroidElement txt_gold_sip;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Daily']")
    private AndroidElement txt_daily;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Monthly']")
    private AndroidElement txt_monthly;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Min ₹10']")
    private AndroidElement txt_daily_mininvestment_amt;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Min ₹100']")
    private AndroidElement txt_monthly_mininvestment_amt;

    @AndroidFindBy(id = "text_view_label")
    private AndroidElement select_date_calender;

    @AndroidFindBy(id = "heading")
    private AndroidElement heading_calender;

    @AndroidFindBy(id = "tvDate")
    private AndroidElement dropdown_list_calender;
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

    public boolean checkEXploreSipBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, explore_cta);
    }

    public String getErrorText() throws InterruptedException {
        return Elements.getText(driver, error_text, "Fetching Error Text");
    }

    public Boolean isErrorTextVisible() throws InterruptedException {
        return Elements.isElementPresent(driver, error_text);
    }

    public boolean scrollToGoldCointXT() throws InterruptedException {
        return Elements.scrollToElement(driver, goldCoin_txt);
    }
    public String getGoldCoinTxt() throws InterruptedException {
        return Elements.getText(driver, goldCoin_txt, "Gold Coin txt");
    }

    public String getKnowMoreTx() throws InterruptedException {
        return Elements.getText(driver, safegold_know_more, "Know More Txt");
    }

    public void clickKnowMoretxt() {
        Elements.selectElement(driver, safegold_know_more, "Click on know More Txt");
    }
    public void clickSafeGoldIcon() {
        Elements.selectElement(driver, goldCoin_img, "Click on Safe Gold Coin Image");
    }

    public String gettitleAboutSafeGold() throws InterruptedException {
        return Elements.getText(driver, title_aboutsafegold, "title about safe gold,Gold History");
    }

    public void clickOnHistory() {
        Elements.selectElement(driver, ctaHistory, "Click on kHistory");
    }

    public void enterPincode(String amount) {
        Elements.enterToElement(driver, enter_pincode, amount, "EnterPincode");
    }

    public String getGoldSIPBannerTitle() throws InterruptedException {
        return Elements.getText(driver, tv_gold_sip_heading, "title Sip banner heading");
    }

    public void clickOnSIPBannerTitle() {
        Elements.selectElement(driver, tv_gold_sip_heading, "Click on Sip banner heading");
    }

    public String getGoldSIPTitleOnGoldSipPage() throws InterruptedException {
        return Elements.getText(driver, txt_gold_sip, "title Sip on gold Sip page");
    }

    public String getDailyTitleOnGoldSipPage() throws InterruptedException {
        return Elements.getText(driver, txt_daily, "title Daily On Gold Sip Page");
    }

    public String getMonthlyTitleOnGoldSipPage() throws InterruptedException {
        return Elements.getText(driver, txt_monthly, "title Monthly On Gold Sip Page");
    }

    public void clickOnMonthlyTitle() {
        Elements.selectElement(driver, txt_monthly, "Click on Monthly Tab");
    }

    public void clickOnCalenderDropdown() {
        Elements.selectElement(driver, dropdown_list_calender, "Click on dropdownlist calender");
    }


    public String getMinAmountofInvestmentONDaily() throws InterruptedException {
        return Elements.getText(driver, txt_daily_mininvestment_amt, "Text Min Amount of Investment on Daily");
    }

    public String getMinAmountofInvestmentOnMonthly() throws InterruptedException {
        return Elements.getText(driver, txt_monthly_mininvestment_amt, "Text Min Amount of Investment on Monthly");
    }

    public void enterDailySip(String amount) {
        Elements.enterToElement(driver, txt_daily_mininvestment_amt, amount, "Enter Daily Sip ");
    }

    public void clickOnCalender() {
        Elements.selectElement(driver, select_date_calender, "Click on Calender");
    }

    public String getMHeadingOnCalenderView() throws InterruptedException {
        return Elements.getText(driver, heading_calender, "Get Heading of calender");
    }


}
