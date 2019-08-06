package PageObject.Recharge;

import PageObject.BankTransferPage;
import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RechargePage {

    WebDriver driver;

    public RechargePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, mobile);
        Config.logComment("*****On money Transfer Page*****");
    }

    @FindBy(xpath = "//label[text()='Mobile']")
    private WebElement mobile;

    @FindBy(xpath = "//label[text()='Landline']")
    private WebElement landline;

    @FindBy(xpath = "//label[text()='Gas']")
    private WebElement gas;

    @FindBy(xpath = "//label[text()='DTH']")
    private WebElement dth;

    public MobileRechargePage clickOnMobile() {
        Element.selectElement(driver, mobile, "Mobile Recharge page");
        return new MobileRechargePage(driver);
    }

    public LandlinePage clickOnLandline() {
        Element.selectElement(driver,landline , "Landline page");
        return new LandlinePage(driver);
    }

    public GasPage clickOnGas() {
        Element.selectElement(driver, gas, "Gas page");
        return new GasPage(driver);
    }

    public DthPage clickOnDth() {
        Element.selectElement(driver, dth, "Dth page");
        return new DthPage(driver);
    }

}
