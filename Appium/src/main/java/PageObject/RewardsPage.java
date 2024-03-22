package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class RewardsPage {


    AndroidDriver driver;

    @AndroidFindBy(id = "trophy")
    private AndroidElement trophyIcon;

    @AndroidFindBy(id = "lottie_trophy")
    private AndroidElement trophyIcon2;

    @AndroidFindBy(id = "game_intro_cta")
    private AndroidElement ctaGetStarted;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Spin Wheel']")
    private AndroidElement ctaSpinTheWheel;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Check Rewards']")
    private AndroidElement ctaCheckRewards;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement title;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[2]")
    private AndroidElement prizeTitle;

    @AndroidFindBy(id = "tv_sub_title_2")
    private AndroidElement prizeSubTitle;

    @AndroidFindBy(id = "cta")
    private AndroidElement ctaClaimNow;

    @AndroidFindBy(id = "iv_cross")
    private AndroidElement crossButton;

    @AndroidFindBy(id = "tv_cta")
    private AndroidElement ctaNotifyMe;

    @AndroidFindBy(id = "tv_cashback")
    private AndroidElement cashback;


    @AndroidFindBy(id = "tv_super_cash")
    private AndroidElement supercash;


    @AndroidFindBy(id = "tv_voucher")
    private AndroidElement voucher;

    @AndroidFindBy(id = "reward_title")
    private AndroidElement rewardTitle;

    @AndroidFindBy(id = "active_vouchers")
    private AndroidElement activeVouchers;


    // ---------------------------------


    public RewardsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickTrophyIcon() {
        Elements.selectElement(driver, trophyIcon, "Trophy Icon");
    }

    public void clickTrophyIcon2() {
        Elements.selectElement(driver, trophyIcon2, "Trophy Icon");
    }

    public void clickGetStarted() {
        Elements.selectElement(driver, ctaGetStarted, "Get Started");
    }

    public boolean isSpinTheWheelPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, ctaSpinTheWheel);
    }

    public boolean isCheckRewardsPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, ctaCheckRewards);
    }

    public boolean isTrophyIconPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, trophyIcon);
    }

    public void clickSpinTheWheel() {
        Elements.selectElement(driver, ctaSpinTheWheel, "Spin the Wheel");
    }

    public void clickCheckRewards() {
        Elements.selectElement(driver, ctaCheckRewards, "Check Rewards");
    }

    public String getPrizeTitle() throws InterruptedException {
        return Elements.getText(driver, prizeTitle, "title");
    }

    public String getPrizeSubTitle() throws InterruptedException {
        return Elements.getText(driver, prizeSubTitle, "sub title");
    }

    public String getCtaText() throws InterruptedException {
        return Elements.getText(driver, ctaClaimNow, "Claim now");
    }

    public void clickCrossButton() {
        Elements.selectElement(driver, crossButton, "Cross Button");
    }

    public void clickNotifyMe() {
        Elements.selectElement(driver, ctaNotifyMe, "Cross Button");
    }

    public boolean isCheckTitlePresent() throws InterruptedException {
      return  Elements.isElementPresent(driver, title);
    }

    public boolean isCashbackPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, cashback);
    }

    public void clickOnCashback(){
        Elements.selectElement(driver, cashback, "Click on cashback");
    }

    public boolean isSupercashPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, supercash);
    }

    public void clickOnSuperCash(){
        Elements.selectElement(driver, supercash, "Click on supercash");
    }

    public boolean isVoucherPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, voucher);
    }

    public void clickOnVoucher(){
        Elements.selectElement(driver, voucher, "Click on voucher");
    }

    public String getCashbackTitle() throws InterruptedException {
        return Elements.getText(driver, rewardTitle,"Title on cashback history");
    }

    public String getActiveVoucher() throws InterruptedException {
        return Elements.getText(driver, activeVouchers,"Count of active vouchers");
    }
}
