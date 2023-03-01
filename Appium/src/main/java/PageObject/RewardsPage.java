package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class RewardsPage {


    AndroidDriver driver;

    @AndroidFindBy(id = "lottie_trophy")
    private AndroidElement trophyIcon;

    @AndroidFindBy(id = "cta")
    private AndroidElement ctaGetStarted;

    @AndroidFindBy(id = "cta")
    private AndroidElement ctaSpinTheWheel;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement claimNowBottomSheetTitle;

    @AndroidFindBy(id = "tv_sub_title")
    private AndroidElement claimNowBottomSheetSubTitle;

    @AndroidFindBy(id = "cta")
    private AndroidElement ctaClaimNow;

    @AndroidFindBy(id = "iv_cross")
    private AndroidElement crossButton;


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

    public String getClaimNowScreenTitle() throws InterruptedException {
        return Elements.getText(driver, claimNowBottomSheetTitle, "Claim now bottom sheet title");
    }

    public String getClaimNowScreenSubTitle() throws InterruptedException {
        return Elements.getText(driver, claimNowBottomSheetSubTitle, "Claim now bottom sheet sub title");
    }

    public String getCtaText() throws InterruptedException {
        return Elements.getText(driver, ctaClaimNow, "Claim now");
    }

    public void clickCrossButton() {
        Elements.selectElement(driver, crossButton, "Cross Button");
    }


}
