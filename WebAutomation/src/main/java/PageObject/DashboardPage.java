package PageObject;

import PageObject.Recharge.RechargePage;
import Utils.Browser;
import Utils.Config;
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

    @FindBy(xpath = "//span[text()='Local Stores']")
    private WebElement side_local_store;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, side_drawer_recharge);
        Config.logComment("*****On Dashboard Page*****");
    }


    public MoneyTransferPage clickOnWalletTransferSideDrawer() {
        Element.selectElement(driver, side_drawer_wallet_transfer, "Wallet Trasnfer from Dashboard");
        return new MoneyTransferPage(driver);
    }


    public InsurancePage clickOnInsuranceSideDrawer() {
        Element.selectElement(driver, side_drawer_insurance, "Insurance From page");
        return new InsurancePage(driver);
    }

    public RechargePage clickOnRechargeSideDrawer() {
        Element.selectElement(driver, side_drawer_recharge, "Recharge page");
        return new RechargePage(driver);
    }

    public BankTransferPage clickOnBankTransferSideDrawer() {
        Element.selectElement(driver, side_drawer_bank_transfer, "Recharge page");
        return new BankTransferPage(driver);
    }
//
//
    public BusPage clickOnBusSideDrawer() {
        Element.selectElement(driver, side_drawer_bus, "Recharge page");
        return new BusPage(driver);
    }
//
//
      public OffersPage clickOnOffersSideDrawer() {
          Element.selectElement(driver, side_drawer_offers, "Offers page");
          return new OffersPage(driver);
      }

      public NearByPage clickOnLocalStoreSideDrawer() {
          Element.selectElement(driver, side_local_store, "Local Store page");
          return new NearByPage(driver);
      }
//
//
//    public WalletTransferPage clickOnWalletTransferSideDrawer() {
//        Element.selectElement(driver, side_drawer_wallet_transfer, "Recharge page");
//        return new WalletTransferPage(driver);
//    }
//
//
//    public InsurancePage clickOnInsuranceSideDrawer() {
//        Element.selectElement(driver, side_drawer_insurance, "Recharge page");
//        return new InsurancePage(driver);
//    }





}
