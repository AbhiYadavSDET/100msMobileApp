package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CentralMapperPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'UPI Transfer']")
    private AndroidElement upi_transfer;

    @AndroidFindBy(id = "search_upi")
    private AndroidElement search_upi;

    @AndroidFindBy(id = "send_money")
    private AndroidElement send_money;

    @AndroidFindBy(id = "transfer_to")
    private AndroidElement transfer_name;

    @AndroidFindBy(id = "transfer_desc")
    private AndroidElement transfer_vpa;

    @AndroidFindBy(id = "merchant_code")
    private AndroidElement tap_search_upi;

    public CentralMapperPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnUpiTransfer() {
        Elements.selectElement(driver, upi_transfer, "Click On UPI Transfer");
    }

    public void clickOnSendMoney() {
        Elements.selectElement(driver, send_money, "Click On Send Money");
    }

    public void tapOnSearchUpiId() { Elements.selectElement(driver, tap_search_upi, "tap On Search Upi Id"); }

    public String getName() throws InterruptedException {
        return Elements.getText(driver, transfer_name, "Get Name");
    }

    public String getVpa() throws InterruptedException {
        return Elements.getText(driver, transfer_vpa, "Get VPA");
    }

    public void enterMappedNumber(String mappedNumber) {
        Elements.enterToElement(driver, search_upi, mappedNumber, "Enter Mapped Number");
    }



}
