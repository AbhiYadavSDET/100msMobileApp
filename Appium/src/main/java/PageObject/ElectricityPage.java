package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ElectricityPage {

    AndroidDriver driver;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Services']")
    private AndroidElement allServices;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Electricity']")
    private AndroidElement electricity;

    @AndroidFindBy(id = "et_search")
    private AndroidElement searchElectricityBrand;

    @AndroidFindBy(id = "operator_layout")
    private AndroidElement selectBrand;

//    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'BSES Yamuna']")
//    private AndroidElement selectBrand;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement caNumber;

    @AndroidFindBy(id = "continue_button")
    private AndroidElement continueButton;

    @AndroidFindBy(id = "recharge_for_name")
    private AndroidElement userName;

    @AndroidFindBy(id = "heading_value")
    private AndroidElement dueDate;

    @AndroidFindBy(id = "cta")
    private AndroidElement pay;

    @AndroidFindBy(id = "cn")
    private AndroidElement title;

    @AndroidFindBy(id = "op")
    private AndroidElement subtitle;

    @AndroidFindBy(id = "amount_value")
    private AndroidElement billPayment;



    public ElectricityPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickAllServices(){
        Elements.selectElement(driver, allServices,"Click on All Services");
    }

    public void clickElectricity(){
        Elements.selectElement(driver, electricity,"Click on Electricity");
    }

    public void clickSearchElectricityBrand(){
        Elements.selectElement(driver, searchElectricityBrand, "Click Search ElectricityBrand");

    }

    public void enterSearchElectricityBrand(String brandName) throws InterruptedException {
        //Elements.isElementPresent(driver, searchElectricityBrand);
        Elements.enterToElement(driver, searchElectricityBrand, brandName,"Enter Brand Name");
    }

    public void clickSelectBrand(){
        Elements.selectElement(driver, selectBrand, "Click on Brand");
    }

    public void clickCaNumber(){
        Elements.selectElement(driver, caNumber, "Click on CA Number text field");
    }

    public void enterCaNumber(String CA_Number) throws InterruptedException {
        //Elements.isElementPresent(driver, caNumber);
        Elements.enterToElement(driver, caNumber, CA_Number, "Enter CA number");
        }

    public void clickContinueButton(){
        Elements.selectElement(driver, continueButton,"Click on Continue button");
    }

    public void clickPay(){
        Elements.selectElement(driver, pay,"Click on Pay button");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Base Title");
    }

    public String getSubTitle() throws InterruptedException {
        return Elements.getText(driver, subtitle, "Sub Title");
    }

    public String getUserName() throws InterruptedException {
        return Elements.getText(driver, userName, "User Name");
    }

    public String getDueDate() throws InterruptedException {
        return Elements.getText(driver, dueDate, "Due Date");
    }

    public String getBillPayment() throws InterruptedException {
        return Elements.getText(driver, billPayment, "Bill Payment amount");
    }

    public boolean isBillFetched() throws InterruptedException {
        return Elements.isElementPresent(driver, pay);
    }

}

