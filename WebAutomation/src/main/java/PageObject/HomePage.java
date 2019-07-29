package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//label[text() = 'Mobile']")
    private WebElement icon_mobile;

    @FindBy(xpath = "//label[text() = 'DTH']")
    private WebElement icon_dth;

    @FindBy(xpath = "//label[text() = 'Datacard']")
    private WebElement icon_datacard;

    @FindBy(xpath = "//label[text() = 'Landline']")
    private WebElement icon_landline;

    @FindBy(xpath = "//label[text() = 'Broadband']")
    private WebElement icon_broadband;

    @FindBy(xpath = "//label[text() = 'Electricity']")
    private WebElement icon_electricity;

    @FindBy(xpath = "//label[text() = 'Gas']")
    private WebElement icon_gas;

    @FindBy(xpath = "//label[text() = 'Insurance']")
    private WebElement icon_insurance;

    @FindBy(xpath = "//label[text() = 'Metro']")
    private WebElement icon_metro;

    @FindBy(xpath = "//label[text() = 'More']")
    private WebElement icon_more;

    @FindBy(xpath = "//label[text() = 'Water']")
    private WebElement icon_water;

    @FindBy(xpath = "//label[text() = 'Housing']")
    private WebElement icon_housing;

    @FindBy(xpath = "//h1[text() = 'Online Mobile Recharge']")
    private WebElement load_homepage;

    @FindBy(xpath = "//a[@class = 'mar20 mbottom dpBLock csrPtr noblur']")
    private WebElement logo_mbk;

    @FindBy(xpath = "//a[text() = 'Login']")
    private WebElement label_login;

    @FindBy(xpath = "//a[text() = 'Signup']")
    private WebElement label_signup;

    @FindBy(xpath = "//a[text() = 'My Wallet']")
    private WebElement label_my_wallet;

    @FindBy(xpath = "//a[text() = 'History']")
    private WebElement label_history;

    @FindBy(xpath = "//span[text() = 'Available Balance:']/following::span[1]")
    private WebElement label_available_balance;

    @FindBy(xpath = "//span[text() = '+ Add Money']")
    private WebElement button_add_money;

    @FindBy(xpath = "//span[@class = 'dpInBLockMid ft11 mar2 mbottom mg mtop pad8 pleft pright themecolor mg_icotriangle_arrow_down csrPtr']")
    private WebElement dropdown_balance;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, load_homepage);
        Config.logComment("*****On Home-Page*****");
    }


    public void clickOnAddMoneyButton() {
        Element.selectElement(driver, button_add_money, "Add Money Button");
    }

    public void clickOnMobile() {
        Element.selectElement(driver, icon_mobile, "Icon Mobile");
    }

    public void clickOnDth() {
        Element.selectElement(driver, icon_dth, "Icon Dth");
    }

    public void clickOnDataCard() {
        Element.selectElement(driver, icon_datacard, "Icon Datacard");
    }

    public void clickOnLandline() {
        Element.selectElement(driver, icon_landline, "Icon Landline");
    }

    public void clickOnBroadband() {
        Element.selectElement(driver, icon_broadband, "Icon Broadband");
    }

    public void clickOnElectricity() {
        Element.selectElement(driver, icon_electricity, "Icon Electricity");
    }

    public void clickOnGas() {
        Element.selectElement(driver, icon_gas, "Icon Gas");
    }

    public void clickOnInsurance() {
        Element.selectElement(driver, icon_insurance, "Icon Insurance");
    }

    public void clickOnMetro() {
        Element.selectElement(driver, icon_metro, "Icon Metro");
    }

    public void clickOnMore() {
        Element.selectElement(driver, icon_more, "Icon More");
    }

    public void clickOnHousing() {
        Element.selectElement(driver, icon_housing, "Icon Housing");
    }

    public void clickOnLogoMbk() {
        Element.selectElement(driver, logo_mbk, "Logo Mbk");
    }

    public void clickOnMyWallet() {
        Element.selectElement(driver, logo_mbk, "My Wallet");
    }

    public void clickOnHistory() {
        Element.selectElement(driver, label_history, "History");
    }

    public void clickOnAddMoney() {
        Element.selectElement(driver, button_add_money, "Add Money");
    }

    public String getAvailableBalance() {
        return Element.getText(driver, label_available_balance, "Available Balance");
    }

    public void clickOnBalanceDropdown() {
        Element.selectElement(driver, dropdown_balance, "Balance Dropdown");
    }


}








