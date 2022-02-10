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

public class WalletPage {


    AndroidDriver driver;

    @AndroidFindBy(id = "kyc_card")
    public AndroidElement card_kyc_upgrade;

    @AndroidFindBy(id = "btn_upgrade")
    public AndroidElement cta_upgrade_button;

    @AndroidFindBy(id = "btn_logout")
    private AndroidElement label_logout;

    public WalletPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Wallet Page*****");

    }

    public boolean ifKycCardDisplayed() throws InterruptedException {
        if (Element.isElementPresent(driver, By.id("kyc_card"))) {

            return true;
        } else {
            return false;
        }
    }

    public boolean ifUpgradeButtonDisplayed() throws InterruptedException {
        if (Element.isElementPresent(driver, By.id("btn_upgrade"))) {

            return true;
        } else {
            return false;
        }
    }

    public void clickOnlogout() throws IOException {
        Element.selectElement(driver, label_logout, "Logout Button");
    }


}

















