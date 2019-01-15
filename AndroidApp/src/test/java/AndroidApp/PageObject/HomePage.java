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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mutual Fund']")
    private AndroidElement icon_mutualFund;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Insurance']")
    private AndroidElement icon_insurance;


    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Home Page*****");
    }

    public SideDrawerPage clickHamburgerIcon() {
        Element.selectElement(driver, sidedrawer_icon, "Hamburger Icon");
        return new SideDrawerPage(driver);
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


}
