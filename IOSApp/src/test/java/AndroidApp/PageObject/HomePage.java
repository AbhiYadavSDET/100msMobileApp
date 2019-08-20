package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "MenuLogo")
    public IOSElement sidedrawer_icon;

    @iOSXCUITFindBy(id = "r")
    private IOSElement mbk_logo;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/tx_balance")
    private IOSElement label_view_balance;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Pay to Merchant']")
    private IOSElement button_pay_to_merchant;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Via Wallet']/preceding-sibling::android.widget.FrameLayout")
    private IOSElement button_transfer_money;

    @iOSXCUITFindBy(id = "Add Money")
    private IOSElement button_add_money;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/magic_btn")
    private IOSElement button_magic;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Login/Signup']/following::XCUIElementTypeButton[1]")
    private IOSElement login_signup_button;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Gold']")
    private IOSElement icon_gold;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Boost Loan']")
    private IOSElement icon_boostLoan;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Mutual Funds']")
    private IOSElement icon_mutualFund;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Insurance']")
    private IOSElement icon_insurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile']")
    public IOSElement icon_mobile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DTH']")
    private IOSElement icon_dth;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Gas']")
    private IOSElement icon_gas;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Electricity']")
    private IOSElement icon_landline;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='More']")
    private IOSElement icon_more;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/navigation_history")
    private IOSElement history_tab;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Offers']")
    private IOSElement offers_tab;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/skip")
    public IOSElement skip_button;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Wallet']")
    private IOSElement button_wallet;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='History']")
    private IOSElement button_history;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Expense']")
    private IOSElement button_expense;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private IOSElement button_home;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Offers']")
    private IOSElement button_offers;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btn_logout")
    private IOSElement label_logout;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='More Services']/following::android.widget.TextView[@text='More']")
    private IOSElement icon_service_more;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Bus']")
    private IOSElement icon_bus;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/navigation_wallet")
    private IOSElement navigate_wallet_page;


    public HomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Home Page*****");
    }

    public P2MPage clickOnButtonPayToMerchant() throws InterruptedException, IOException {
        Element.selectElement(driver, button_pay_to_merchant, "Pay To Merchant");
        return new P2MPage(driver);
    }

    public void clickOnCrossButton() throws InterruptedException, IOException {
        if (Element.isElementPresent(driver, (By.id("cross_button")))) {
            Element.selectElement(driver, (IOSElement) driver.findElement(By.id("cross_button")), "Cross Button");
        }
    }

    public TransferPage clickOnButtonP2P() throws IOException {
        Element.selectElement(driver, button_transfer_money, "Pay Via Wallet");
        return new TransferPage(driver);


    }

    public SideDrawerPage clickHamburgerIcon() {
        Element.selectElement(driver, sidedrawer_icon, "Hamburger Icon");
        return new SideDrawerPage(driver);
    }

    public WalletBalancePage clickOnViewBalance() throws IOException {
        Element.selectElement(driver, label_view_balance, "View balance label");
        return new WalletBalancePage(driver);
    }

    public LoginPage clickLoginSignupButton() throws IOException {
        Element.selectElement(driver, login_signup_button, "Login/Signup Button");
        return new LoginPage(driver);
    }

    public void clickHomePageMbkLogo() {
        Element.selectElement(driver, mbk_logo, "MobiKwik Homescreen Logo");
    }

    public GoldPage clickGoldIcon() {
        Element.selectElement(driver, icon_gold, "Gold Icon");
        return new GoldPage(driver);
    }

    public AddMoneyPage clickOnAddMoneyButton() throws IOException {
        Element.selectElement(driver, button_add_money, "Add Money button");
        return new AddMoneyPage(driver);
    }

    public RechargePage clickOnMobileButton() throws IOException {
        Element.selectElement(driver, icon_mobile, "Mobile button");
        return new RechargePage(driver);
    }

    public RechargePage clickOnDthButton() throws IOException {
        Element.selectElement(driver, icon_dth, "Dth button");
        return new RechargePage(driver);
    }

    public RechargePage clickGasIcon() throws IOException {
        Element.selectElement(driver, icon_gas, "Gas Icon");
        return new RechargePage(driver);
    }

    public RechargePage clickLandlineIcon() throws IOException {
        Element.selectElement(driver, icon_landline, "Landline Icon");
        return new RechargePage(driver);
    }

    public void clickMoreIcon() throws IOException {
        Element.selectElement(driver, icon_more, "More Icon");
    }

    public void clickOnBottomBarHome() throws IOException {
        Element.selectElement(driver, button_home, "Botton Bar Home");
    }

    public void clickOnBottomBarExpense() throws IOException {
        Element.selectElement(driver, button_expense, "Botton Bar Expense");
    }

    public void clickOnBottomBarOffers() throws IOException {
        Element.selectElement(driver, button_offers, "Botton Bar Offers");
    }

    public void clickOnBottomBarHistory() throws IOException {
        Element.selectElement(driver, button_history, "Botton Bar History");
    }

    public void clickOnBottomBarWallet() throws IOException {
        Element.selectElement(driver, button_wallet, "Botton Bar Wallet");
    }

    public void clickOnlogout() throws IOException {
        Element.selectElement(driver, label_logout, "Logout Button");
    }

    public OfferPage clickOffers() throws IOException {
        Element.selectElement(driver, offers_tab, "Offers");
        return new OfferPage(driver);
    }

    public MutualFundPage clickMutualFunds() throws IOException {
        Element.selectElement(driver, icon_mutualFund, "Mutual Funds");
        return new MutualFundPage(driver);
    }

    public TransactionHistoryPage clickHistory() throws IOException {
        Element.selectElement(driver, history_tab, "History");
        return new TransactionHistoryPage(driver);
    }

    public void clickOnSkip() throws InterruptedException {
        Element.selectElement(driver, skip_button, "Skip");
    }

    public void clickMoreServicesIcon() throws IOException {
        Element.selectElement(driver, icon_service_more, "More Services Icon under More Services");
    }

    public BusPage clickBusIcon() throws IOException {
        Element.selectElement(driver, icon_bus, "Bus Icon");
        return new BusPage(driver);
    }

    public InsurancePage clickOnInsuranceIcon() throws IOException {
        Element.selectElement(driver, icon_insurance, "InsuranceApi Icon");
        return new InsurancePage(driver);
    }

    public WalletPage clickWalletNavigate() throws IOException {
        Element.selectElement(driver, navigate_wallet_page, "Navigate to Wallet Page");
        return new WalletPage(driver);
    }


}
