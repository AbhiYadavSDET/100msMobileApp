package PageObject;

import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GasBillPage {

//    String allServicesTab ="All Services";
//    String moreButton="More";
//    String pipedGasButton="Piped Gas";
//    String enterOperator="Select an Operator";
//    String selectOperator="android.widget.ImageView";
//    String bpNumber="BP Number";
//    String continueButton ="Continue";
//    String noDuesText ="No Dues";
//    String billPaymentForText="Bill Payment for";
//    String unableToFetchBill="Unable to get bill details";

//    String text="text";
//    String clas="class";

    AndroidDriver driver;

    @AndroidFindBy(xpath="//*[@text='All Services']")
    private AndroidElement allServicesTab;

    @AndroidFindBy(xpath="//*[@text='More']")
    private AndroidElement moreButton;

    @AndroidFindBy(xpath="//*[@text='Piped Gas']")
    private AndroidElement pipedGasButton;

    @AndroidFindBy(xpath="//*[@text='Select an Operator']")
    private AndroidElement enterOperator;

    @AndroidFindBy(xpath="//*[@class='android.widget.ImageView']")
    private AndroidElement selectOperator;

    @AndroidFindBy(xpath="//*[@text='BP Number']")
    private AndroidElement bpNumber;

    @AndroidFindBy(xpath="//*[@text='Continue']")
    private AndroidElement continueButton;

    @AndroidFindBy(xpath="//*[@text='No Dues')]")
    private AndroidElement noDuesText;

    @AndroidFindBy(xpath="//*[@text='Bill Payment for']")
    private AndroidElement billPaymentForText;

    @AndroidFindBy(xpath="//*[@text='Unable to get bill details']")
    private AndroidElement unableToFetchBill;

    public GasBillPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void checkResultScreen(String operator) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,operator,10);
//        Thread.sleep(5000);
        if(Elements.isElementPresent(driver,unableToFetchBill)){
            Config.logComment("Unable to get bill details due to some issue");
        }else if(Elements.isElementPresent(driver,billPaymentForText)){
            Config.logComment("Bill is present for current bill");
        }else if(Elements.isElementPresent(driver,noDuesText)){
            Config.logComment("No dues for current bill");
        }
    }

    public void clickAllServicesTab() {
        Elements.selectElement(driver,allServicesTab,"Click All Services tab");
    }

    public void clickMoreButton() {
        Elements.selectElement(driver,moreButton,"Click more button");
    }

    public void clickPipedGasButton() {
        Elements.selectElement(driver,pipedGasButton,"Click piped gas button");
    }

    public void enterOperator(String operatorName) {
        Elements.enterToElement(driver, enterOperator, operatorName,"Enter operator name");
    }

    public void selectOperator() {
        Elements.selectElement(driver,selectOperator,"Click gas operator");
    }

    public void enterBPNumber(String BP_Number) {
        Elements.waitForElementToVisibleOnPage(driver,bpNumber,5);
        Elements.enterToElement(driver, bpNumber, BP_Number,"Enter BP Number");
    }

    public void clickContinue() {
        Elements.selectElement(driver,continueButton,"Click continue button");
    }
}
