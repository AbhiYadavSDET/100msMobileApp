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

    @AndroidFindBy(id = "game_intro_cta")
    private AndroidElement ctaGetStarted;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Spin Wheel']")
    private AndroidElement ctaSpinTheWheel;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Check Rewards']")
    private AndroidElement ctaCheckRewards;

    @AndroidFindBy(id = "tv_sub_title")
    private AndroidElement prizeTitle;

    @AndroidFindBy(id = "tv_sub_title_2")
    private AndroidElement prizeSubTitle;

    @AndroidFindBy(id = "cta")
    private AndroidElement ctaClaimNow;

    @AndroidFindBy(id = "iv_cross")
    private AndroidElement crossButton;

    @AndroidFindBy(id = "tv_cta")
    private AndroidElement ctaNotifyMe;


    // ---------------------------------


    public RewardsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickTrophyIcon() {
        Elements.selectElement(driver, trophyIcon, "Trophy Icon");
    }

    public void clickGetStarted() {
        Elements.selectElement(driver, ctaGetStarted, "Get Started");
    }

    public boolean isSpinTheWheelPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, ctaSpinTheWheel);
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


}
