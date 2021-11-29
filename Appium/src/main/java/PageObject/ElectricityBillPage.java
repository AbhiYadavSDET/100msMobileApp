package PageObject;

import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ElectricityBillPage {

//    String allServicesTab ="All Services";
//    String electricityButton="Electricity";
//    String enterBoard="Select an Electricity Board";
//    String selectBoard="android.widget.ImageView";
//    String enterNumber="android.widget.EditText";
//    String continueButton ="Continue";
//    String noDuesText ="No Dues";
//    String billPaymentForText="Bill Payment for";
//    String unableToFetchBill="Unable to get bill details";

//    String text="text";
//    String clas="class";

    AndroidDriver driver;

    @AndroidFindBy(xpath="//*[@text='All Services']")
    private AndroidElement allServicesTab;

    @AndroidFindBy(xpath="//*[@text='Electricity']")
    private AndroidElement electricityButton;

    @AndroidFindBy(xpath="//*[@text='Select an Electricity Board']")
    private AndroidElement enterBoard;

    @AndroidFindBy(xpath="//*[@class='android.widget.ImageView']")
    private AndroidElement selectBoard;

    @AndroidFindBy(xpath="//*[@class='android.widget.EditText']")
    private AndroidElement enterNumber;

    @AndroidFindBy(xpath="//*[@text='Continue']")
    private AndroidElement continueButton;

    @AndroidFindBy(xpath="//*[@text='No Dues']")
    private AndroidElement noDuesText;

    @AndroidFindBy(xpath="//*[@text='Bill Payment for']")
    private AndroidElement billPaymentForText;

    @AndroidFindBy(xpath="//*[@text='Unable to get bill details']")
    private AndroidElement unableToFetchBill;

    public ElectricityBillPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void checkResultScreen(String operator) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,operator,10);
//        Thread.sleep(5000);
        if(Elements.isElementPresent(driver,noDuesText)){
            Config.logComment("No dues for current bill");
        }else if(Elements.isElementPresent(driver,billPaymentForText)){
            Config.logComment("Bill is present for current bill");
        }else if(Elements.isElementPresent(driver,unableToFetchBill)){
            Config.logComment("Unable to get bill details due to some issue");
        }
    }

    public void clickAllServicesTab() {
        Elements.selectElement(driver,allServicesTab,"Click All Services tab");
    }

    public void clickElectricityButton() {
        Elements.selectElement(driver,electricityButton,"Click electricity button");
    }

    public void enterBoard(String operatorName) {
        Elements.enterToElement(driver, enterBoard, operatorName,"Enter board name");
    }

    public void selectBoard() {
        Elements.selectElement(driver,selectBoard,"Click electricity board");
    }

    public void enterNumber(String BP_Number) {
        Elements.waitForElementToVisibleOnPage(driver,enterNumber,5);
        Elements.enterToElement(driver, enterNumber, BP_Number,"Enter Number");
    }

    public void clickContinue() {
        Elements.selectElement(driver,continueButton,"Click continue button");
    }
}
