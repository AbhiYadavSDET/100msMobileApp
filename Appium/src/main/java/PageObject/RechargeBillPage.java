package PageObject;

import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class RechargeBillPage {

    String bpNumber="BP Number";
    String continueButton ="Continue";
    String noDuesText ="No Dues";
    String unableToFetchBill="Unable to get bill details";

    @AndroidFindBy(xpath="//*[@text='All Services']")
    private AndroidElement allService;

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

    @AndroidFindBy(xpath="//*[@text='Security PIN']")
    private AndroidElement clickSecurityPin;

    @AndroidFindBy(xpath="//android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
    private AndroidElement clickPayButton;


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
        Elements.waitForElementToVisibleOnPage(driver,clickPayButton,5);
        Elements.selectElement(driver,clickPayButton,"Click Pay button");
    }
}
