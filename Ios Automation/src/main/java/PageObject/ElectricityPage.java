package PageObject;


import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectricityPage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "Electricity")
    private IOSElement electricity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Search Electricity Board']")
    private IOSElement searchElectricityBrand;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[starts-with(@name,'See More')])[1]")
    private IOSElement seeMore;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[starts-with(@name, 'Kota Electricity')])[1]")
    private IOSElement savedElectricityConnection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private IOSElement billFetched;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name,'Pay')]")
    private IOSElement payButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bill Payment for\"]/following:: XCUIElementTypeStaticText[1]")
    private IOSElement userName;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[1]/following:: XCUIElementTypeStaticText[1]")
    private IOSElement title;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[1]/following:: XCUIElementTypeStaticText[3]")
    private IOSElement subtitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private IOSElement totalBillPayment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]")
    private IOSElement message;

    public ElectricityPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickElectricity() {
        Elements.click(driver, electricity, "Click on Electricity");
    }

    public void clickSeeMore() { Elements.click(driver, seeMore,"Click on see More");}

    public boolean isSeeMorePresent() throws InterruptedException {
        return Elements.isElementPresent(driver, seeMore, "isSeeMorePresent");
    }

    public boolean isSavedConnectionPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, savedElectricityConnection, "isSavedConnectionPresent");
    }

    public void clickSavedElectricityConnection() { Elements.click(driver, savedElectricityConnection, "Click on saved connection"); }

    public boolean isBillFetched() throws InterruptedException {
        return Elements.isElementPresent(driver, billFetched, "isBillFetched" );
    }

    public String getUserName() throws InterruptedException {
        return Elements.getText(driver, userName, "User Name");
    }

    public void clickPay(){
        Elements.selectElement(driver, payButton,"Pay button");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Base Title");
    }

    public String getSubTitle() throws InterruptedException {
        return Elements.getText(driver, subtitle, "Sub Title");
    }

    public String getBillPayment() throws InterruptedException {
        return Elements.getText(driver, totalBillPayment, "Bill Payment amount");
    }

    public void clickSearchElectricityBrand() {
        Elements.click(driver, searchElectricityBrand, "Click on search electricity bill");
    }

    public void enterSearchElectricityBrand(String brandName) throws InterruptedException {
//        Elements.isElementPresent(driver, searchElectricityBrand, "enterSearchElectricityBrand");
        Elements.enterToElement(driver, searchElectricityBrand, brandName,"Enter Brand Name");
    }

    public String getMessage() throws InterruptedException {
        return Elements.getText(driver, message);
    }

   /* public void clickSelectBrand(){
        Elements.selectElement(driver, selectBrand, "Click on Brand");
    }

    public void clickCaNumber(){
        Elements.selectElement(driver, caNumber, "Click on CA Number text field");
    }

    public void enterCaNumber(String CA_Number) throws InterruptedException {
        //Elements.isElementPresent(driver, caNumber, "enterCaNumber);
        Elements.enterToElement(driver, caNumber, CA_Number, "Enter CA number");
    }

    public void clickContinueButton(){
        Elements.selectElement(driver, continueButton,"Click on Continue button");
    }

    */




}
