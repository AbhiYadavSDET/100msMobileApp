package PageObject;

import Utils.Config;
import Utils.Elements;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class RechargeBillPage {

    String bpNumber="BP Number";
    String noDuesText ="No Dues";
    String unableToFetchBill="Unable to get bill details";

    @AndroidFindBy(xpath="//*[@text='All Services']")
    private AndroidElement allService;

    @AndroidFindBy(xpath="//*[@text='Home']")
    private AndroidElement homeTab;

    @AndroidFindBy(xpath="//*[@text='Continue']")
    private AndroidElement continueButton;

    @AndroidFindBy(xpath="//*[@text='Mobile']")
    private AndroidElement mobileButton;

    @AndroidFindBy(xpath="//*[@class='android.widget.EditText']")
    private AndroidElement enterNumber;

    @AndroidFindBy(xpath="//*[@text='Bill Payment for']")
    private AndroidElement billPaymentForText;

    @AndroidFindBy(xpath="//*[@text='Recharge for']")
    private AndroidElement rechargeForText;

    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private AndroidElement selectMobile;

    @AndroidFindBy(xpath="//*[@text='w']")
    private AndroidElement nextCTA;

    @AndroidFindBy(xpath="//*[@text='Confirm']")
    private AndroidElement confirmButton;

    @AndroidFindBy(xpath="//*[@text='Recharge & Pay Bills']")
    private AndroidElement rechargeBills;

    @AndroidFindBy(xpath="//*[@text='Security PIN']")
    private AndroidElement clickSecurityPin;

    @AndroidFindBy(xpath="//*[@class='android.widget.Switch']")
    private AndroidElement operatorType;

    @AndroidFindBy(xpath="//android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
    private AndroidElement clickPayButton;

    @AndroidFindBy(xpath="//*[@text='OFF']")
    private AndroidElement offText;

    @AndroidFindBy(xpath="//*[@text='ON']")
    private AndroidElement onText;

    @AndroidFindBy(xpath="//*[@text='Yes']")
    private AndroidElement yesButton;

    @AndroidFindBy(xpath="//*[@text='Skip']")
    private AndroidElement skipButton;

    @AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.View[2]")
    private AndroidElement checkSwipLeftPopUp;

    @AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[3]")
    private AndroidElement clickSideDrawer;

    @AndroidFindBy(xpath="//*[@text='Allow only while using the app']")
    private AndroidElement checkLocationAccess;

    @AndroidFindBy(xpath="//*[@text='Accounts']")
    private AndroidElement clickAccounts;

    @AndroidFindBy(xpath="//*[@text='Logout']")
    private AndroidElement clickLogout;


    AndroidDriver driver;

    public RechargeBillPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean checkResultScreen(String operator) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,operator,10);
        if(Elements.isElementPresent(driver,billPaymentForText)){
            Config.logComment("Bill is present for current bill");
            return true;
        }else if(Elements.isElementPresent(driver,rechargeForText)){
            Config.logComment("Bill is present for current bill");
            return true;
        }else{
            Config.logComment("Currently bill is not present or unable to fetch bill");
            return false;
        }
    }

    public void clickAllServicesTab() {
        Elements.selectElement(driver,allService,"Click All Services tab");
    }

    public void selectOperator(String operator) {
        Elements.selectElement(driver,operator,"Click gas operator");
    }

    public void clickMobileButton() {
        Elements.selectElement(driver,mobileButton,"Click mobile button");
    }

    public void enterMobileNumber(String number) {
        Elements.waitForElementToVisibleOnPage(driver,enterNumber,5);
        Elements.enterToElement(driver, enterNumber, number,"Enter Mobile Number");
    }

    public void selectNumber() {
        Elements.selectElement(driver,selectMobile,"Click mobile number");
    }

    public void selectCircle(String circle) {
        Elements.selectElement(driver,circle,"Click your sim circle");
    }

    public void enterAmount(String amount) {
        Elements.waitForElementToVisibleOnPage(driver,enterNumber,5);
        for(int i=0;i<amount.length();i++) {
            Elements.selectElement(driver, amount.substring(i,i+1), "Enter amount");
        }
    }

    public void clickNextCTA() throws InterruptedException {
        if(Elements.isElementEnabled(driver,nextCTA)) {
            Elements.selectElement( driver, nextCTA, "Click next CTA");
        }else{
            Config.logComment("Next CTA is not clickable ,Please check");
        }
    }

    public void clickConfirm() {
        Elements.selectElement(driver,confirmButton,"Click Confirm button");
    }

    public void enterSecurityPin(String pin) {
        Elements.waitForElementToVisibleOnPage(driver,clickSecurityPin,5);
        for(int i=0;i<pin.length();i++) {
            Elements.selectElement(driver, pin.substring(i,i+1), "Enter Security Pin");
        }
    }

    public void clickPayButton() {
        Elements.waitForElementToVisibleOnPage(driver,clickPayButton,15);
        Elements.selectElement(driver,clickPayButton,"Click Pay button");
    }

    public void clickHomeTab() {
        Elements.selectElement(driver,homeTab,"Click Home tab");
    }

    public void clickRechargePayBill() {
        Elements.selectElement(driver,rechargeBills,"Click Recharge & Pay Bills");
    }

    public void clickContinue() {
        Elements.selectElement(driver,continueButton,"Click Continue button");
    }

    public void changeType() {
        Elements.selectElement(driver,operatorType,"Change type of operator");
    }

    public boolean checkOperatorType(String operatorType) throws InterruptedException {
        if(operatorType.toLowerCase(Locale.ROOT).equals("prepaid") && Elements.isElementPresent(driver,offText)){
            return false;
        }else if(operatorType.toLowerCase(Locale.ROOT).equals("postpaid") && Elements.isElementPresent(driver,onText)){
            return false;
        }else{
            return true;
        }
    }

    public void clickYes() {
        Elements.waitForElementToVisibleOnPage(driver,yesButton,5);
        Elements.selectElement(driver,yesButton,"Click yes");
    }

    public void clickSwipPopUp() {

        Elements.selectElement(driver,checkSwipLeftPopUp,"Click Swipe left to explore more services");
    }

    public void clickSkip() {
        Elements.selectElement(driver,skipButton,"Click Skip");
    }

    public void clickLocationAccess() {
        Elements.selectElement(driver,checkLocationAccess,"Click allow location");
    }

    public void openSideDrawr() {
        Elements.selectElement(driver,clickSideDrawer,"Open side drawer");
//        double anchorPercentage=0.8;
//        double startPercentage= 0.9;
//        double endPercentage= 0.2;
//        Dimension size = driver.manage().window().getSize();
//        int anchor = (int) (size.height * anchorPercentage);
//        int startPoint = (int) (size.width * startPercentage);
//        int endPoint = (int) (size.width * endPercentage);
//        new TouchAction(driver)
//                .press(point(startPoint, anchor))
//                .waitAction(waitOptions(ofMillis(1000)))
//                .moveTo(point(endPoint, anchor))
//                .release().perform();
    }

    public void clickAccounts() {
        Elements.selectElement(driver,clickAccounts,"Click accounts button");
    }

    public void clickLogout() {
        Elements.waitForElementToVisibleOnPageUsingText(driver,"Account",5);
        double anchorPercentage=0.5;
        double startPercentage= 0.9;
        double endPercentage= 0.2;
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
        Elements.selectElement(driver,clickLogout,"Click Logout button");
    }
}
