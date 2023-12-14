package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class PipedGasPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home Services\"]")
    private IOSElement homeServices;

    @iOSXCUITFindBy(id = "Piped Gas")
    private IOSElement pipedGas;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Search Electricity Board']")
    private IOSElement searchElectricityBrand;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[starts-with(@name,'See More')])[1]")
    private IOSElement seeMore;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[starts-with(@name, 'Aavantika Gas')])[1]")
    private IOSElement savedPipedGasConnection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name,'Pay')]")
    private IOSElement payButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private IOSElement userName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private IOSElement title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private IOSElement subtitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private IOSElement totalBillPayment;


    public PipedGasPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickHomeServices() { Elements.click(driver, homeServices, "Click on Home services");   }


    public void clickPipedGas() {
        Elements.click(driver, pipedGas, "Click on Piped Gas");
    }

    public void clickSeeMore() { Elements.click(driver, seeMore,"Click on see More");}

    public boolean isSeeMorePresent() throws InterruptedException {
        return Elements.isElementPresent(driver, seeMore);
    }

    public boolean isSavedPipedGasConnectionPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, savedPipedGasConnection);
    }

    public void clickSavedPipedGasConnection() { Elements.click(driver, savedPipedGasConnection, "Click on saved connection"); }

    public boolean isBillFetched() throws InterruptedException {
        return Elements.isElementPresent(driver, payButton);
    }

    public String getUserName() throws InterruptedException {
        return Elements.getText(driver, userName, "User Name");
    }

    public void clickPay(){
        Elements.selectElement(driver, payButton,"Click on Pay button");
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
        //Elements.isElementPresent(driver, searchElectricityBrand);
        Elements.enterToElement(driver, searchElectricityBrand, brandName,"Enter Brand Name");
    }

}
