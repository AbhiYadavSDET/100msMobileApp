package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {

    AndroidDriver driver;

    @AndroidFindBy(id = "com.mobikwik_new:id/icon_drawer")
    private AndroidElement sidedrawer_icon;

    @AndroidFindBy(id = "com.mobikwik_new:id/icon")
    private AndroidElement mbk_logo;

    @AndroidFindBy(id = "com.mobikwik_new:id/tx_view_balance")
    private AndroidElement label_view_balance;

    @AndroidFindBy(id = "com.mobikwik_new:id/btn_p2m")
    private AndroidElement button_pay_to_merchant;

    @AndroidFindBy(id = "com.mobikwik_new:id/btn_p2p")
    private AndroidElement button_transfer_money;

    @AndroidFindBy(id = "com.mobikwik_new:id/tx_add_money")
    private AndroidElement button_add_money;

    @AndroidFindBy(id = "com.mobikwik_new:id/magic_btn")
    private AndroidElement button_magic;

    @AndroidFindBy(id = "com.mobikwik_new:id/tx_balance")
    private AndroidElement login_signup_button;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gold']")
    private AndroidElement icon_gold;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Boost Loan']")
    private AndroidElement icon_boostLoan;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mutual Funds']")
    private AndroidElement icon_mutualFund;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Insurance']")
    private AndroidElement icon_insurance;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile']")
    public AndroidElement icon_mobile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DTH']")
    private AndroidElement icon_dth;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gas']")
    private AndroidElement icon_gas;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Landline']")
    private AndroidElement icon_landline;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='More']")
    private AndroidElement icon_more;

    @AndroidFindBy(id = "com.mobikwik_new:id/navigation_history")
    private AndroidElement history_tab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Offers']")
    private AndroidElement offers_tab;

    @AndroidFindBy(id="com.mobikwik_new:id/skip")
    public AndroidElement skip_button;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wallet']")
    private AndroidElement button_wallet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='History']")
    private AndroidElement button_history;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Expense']")
    private AndroidElement button_expense;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private AndroidElement button_home;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Offers']")
    private AndroidElement button_offers;

    @AndroidFindBy(id = "com.mobikwik_new:id/btn_logout")
    private AndroidElement label_logout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='More Services']/following::android.widget.TextView[@text='More']")
    private AndroidElement icon_service_more;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bus']")
    private AndroidElement icon_bus;

    @AndroidFindBy(id = "com.mobikwik_new:id/navigation_wallet")
    private AndroidElement navigate_wallet_page;

    public HomePage(AndroidDriver driver) {
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

    public WalletPage clickWalletNavigate() throws IOException{
        Element.selectElement(driver, navigate_wallet_page, "Navigate to Wallet Page");
        return new WalletPage(driver);
    }


}
