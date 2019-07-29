package PageObject;

import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;


    @FindBy(xpath = "//span[text()='Recharge & Bill Pay']")
    private WebElement side_drawer_recharge;

    @FindBy(xpath = "//span[text()='Transfer to Bank']")
    private WebElement side_drawer_bank_transfer;


    @FindBy(xpath = "//span[text()='Bus Tickets']")
    private WebElement side_drawer_bus;

    @FindBy(xpath = "//span[text()='Offers & Deals']")
    private WebElement side_drawer_offers;

    @FindBy(xpath = "//span[text()='Wallet Transfer']")
    private WebElement side_drawer_wallet_transfer;

    @FindBy(xpath = "//span[text()='Insurance']")
    private WebElement side_drawer_insurance;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        // Browser.waitForPageLoad(driver, label_page_load_text);
        //Config.logComment("*****On Dashboard Page*****");
    }


    public MoneyTransferPage clickOnWalletTransferSideDrawer() {
        Element.selectElement(driver, side_drawer_wallet_transfer, "Wallet Trasnfer from Dashboard");
        return new MoneyTransferPage(driver);
    }


    public InsurancePage clickOnInsuranceSideDrawer() {
        Element.selectElement(driver, side_drawer_insurance, "Recharge page");
        return new InsurancePage(driver);
    }


}
