package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class HomePage {

    AndroidDriver driver;

    @AndroidFindBy(id = "icon_drawer")
    public AndroidElement sidedrawer_icon;

    @AndroidFindBy(id = "icon")
    private AndroidElement mbk_logo;

    @AndroidFindBy(id = "tx_balance")
    private AndroidElement label_view_balance;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pay to Merchant']")
    private AndroidElement button_pay_to_merchant;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Via Wallet']/preceding-sibling::android.widget.FrameLayout")
    private AndroidElement button_transfer_money;

    @AndroidFindBy(id = "tx_add_money")
    private AndroidElement button_add_money;

    @AndroidFindBy(id = "magic_btn")
    private AndroidElement button_magic;

    @AndroidFindBy(id = "tx_balance")
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Piped Gas']")
    private AndroidElement icon_gas;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Credit Card Bill']")
    private AndroidElement icon_credit_card;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Landline']")
    private AndroidElement icon_landline;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='More']")
    private AndroidElement icon_more;

    @AndroidFindBy(id = "navigation_history")
    private AndroidElement history_tab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Offers']")
    private AndroidElement offers_tab;

    @AndroidFindBy(id = "skip")
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

    @AndroidFindBy(id = "btn_logout")
    private AndroidElement label_logout;

    //Nearby
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='More Services']/following::android.widget.TextView[@text='More']")
    private AndroidElement more_icon_under_more_services;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Local Stores']")
    private AndroidElement icon_nearby;

    @AndroidFindBy(id = "tx_tag")
    private AndroidElement store_count;

    @AndroidFindBy(id = "close_button")
    private AndroidElement cross_icon_for_more_services_overlay;

    //////////////

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bus']")
    private AndroidElement icon_bus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gift Cards']")
    private AndroidElement icon_gift_card;


    @AndroidFindBy(id = "navigation_wallet")
    private AndroidElement navigate_wallet_page;

    //    @AndroidFindBy(id ="com.mobikwik_new.debug:id/tx_upi_id")
    @AndroidFindBy(id = "tx_upi_id")
    private AndroidElement navigate_upi_page;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Via UPI']")
    private AndroidElement navigate_upi_send_money;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Request']")
    private AndroidElement navigate_upi_request;

    //Check Balance Flow
    @AndroidFindBy(id = "tx_bank_balance")
    private AndroidElement cta_check_balance;

    @AndroidFindBy(id = "balance")
    private AndroidElement account_balance;

    @AndroidFindBy(id = "cross_button")
    private AndroidElement click_cross_overlay;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Link Your Bank Account']")
    private AndroidElement link_bank_account;

    @AndroidFindBy(id = "add_account_button")
    private AndroidElement cta_link_bank_account;

    @AndroidFindBy(id = "close_button")
    private AndroidElement cross_icon_for_recharge_services_overlay;

    //onboarding Flow

    @AndroidFindBy(id = "title_text")
    private AndroidElement heading_secondary_email_screen;

    //Ola Flow

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ola Cabs']")
    private AndroidElement icon_ola;


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

    public void clickOnCrossButton() throws InterruptedException, IOException {
        if (Element.isElementPresent(driver, (By.id("cross_button")))) {
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("cross_button")), "Cross Button");
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

    public RechargePage clickCreditCardIcon() throws IOException {
        Element.selectElement(driver, icon_credit_card, "Credit Card Icon");
        return new RechargePage(driver);
    }


    public RechargePage clickLandlineIcon() throws IOException {
        Element.selectElement(driver, icon_landline, "Landline Icon");
        return new RechargePage(driver);
    }

    public void clickMoreIcon() throws IOException {
        Element.selectElement(driver, icon_more, "More Icon");
    }

    public OlaPage clickOnOlaIcon() throws IOException {
        Element.selectElement(driver, icon_ola, "Ola button");
        return new OlaPage(driver);
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

    public TransactionHistoryPage clickOnBottomBarHistory() throws IOException {
        Element.selectElement(driver, button_history, "Botton Bar History");
        return new TransactionHistoryPage(driver);
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

    public void clickMoreIconUnderMoreServices() throws IOException {
        Element.selectElement(driver, more_icon_under_more_services, "More Services Icon under More Services");
    }

    public BusPage clickBusIcon() throws IOException {
        Element.selectElement(driver, icon_bus, "Bus Icon");
        return new BusPage(driver);
    }

    public GiftCardPage clickGiftCardIcon() throws IOException {
        Element.selectElement(driver, icon_gift_card, "Gift Card Icon");
        return new GiftCardPage(driver);
    }

    public InsurancePage clickOnInsuranceIcon() throws IOException {
        Element.selectElement(driver, icon_insurance, "InsuranceApi Icon");
        return new InsurancePage(driver);
    }

    public WalletPage clickWalletNavigate() throws IOException {
        Element.selectElement(driver, navigate_wallet_page, "Navigate to Wallet Page");
        return new WalletPage(driver);
    }

    public UpiPage clickOnUpiId() throws IOException {
        Element.selectElement(driver, navigate_upi_page, "Navigate to UPI Page");
        return new UpiPage(driver);
    }

    public void clickCheckBalance() throws IOException {
        Element.selectElement(driver, cta_check_balance, "Get Account Balance");
    }

    public UpiPage clickOnLinkBankAccount() throws IOException {
        Element.selectElement(driver, cta_link_bank_account, "Link Bank Account");
        return new UpiPage(driver);
    }

    public String getAccountBalance() throws IOException {
        String balance = Element.getText(driver, account_balance, "Account Balance").replace("Account Balance: ₹ ", "");
        return balance;
    }

    public void dismissOverlay() throws IOException {
        Element.selectElement(driver, click_cross_overlay, "Dismiss Overlay");
    }

    public void closeRechargeServicesOverlay() throws InterruptedException {
        Element.selectElement(driver, cross_icon_for_recharge_services_overlay, "Close Recharge Overlay");
    }

    public String getTitleMessageSecondaryEmail() throws InterruptedException {

        return Element.getText(driver, heading_secondary_email_screen, "Get Heading Text");
    }

    public NearbyPage clickNearbyIcon() throws IOException {
        Element.selectElement(driver, icon_nearby, "Nearby Icon");
        return new NearbyPage(driver);
    }

    public String getStoreCount() throws InterruptedException {
        return Element.getText(driver, store_count, "Get Store Count");
    }

    public void closeMoreServicesOverlay() throws InterruptedException {
        Element.selectElement(driver, cross_icon_for_more_services_overlay, "Close More Services Overlay");
    }

}
