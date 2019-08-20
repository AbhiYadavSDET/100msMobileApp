package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class WalletPage {


    IOSDriver driver;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/kyc_card")
    public IOSElement card_kyc_upgrade;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btn_upgrade")
    public IOSElement cta_upgrade_button;

    public WalletPage(IOSDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Wallet Page*****");

    }

    public boolean ifKycCardDisplayed() throws InterruptedException {
       if(Element.isElementPresent(driver, By.id("com.mobikwik_new:id/kyc_card"))) {

           return true;
       }else{
           return false;
       }
    }

    public boolean ifUpgradeButtonDisplayed() throws InterruptedException {
        if(Element.isElementPresent(driver, By.id("com.mobikwik_new:id/btn_upgrade"))) {

            return true;
        }else{
            return false;
        }
    }
}


















