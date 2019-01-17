package test.java.AndroidApp.Helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import main.java.utils.Element;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.MbkCommonControlsPage;

import java.io.IOException;

public class MBKCommonControlsHelper {

    AndroidDriver driver;
    MbkCommonControlsPage mbkCommonControlsPage;
    Element element;

    public MBKCommonControlsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
        element = new Element(driver);

    }


    public void applyPromoCodeGold(String promoCode) {
        mbkCommonControlsPage.applyPromoCode(promoCode);
    }

    public void applyPromoCodeRecharge() {

    }

    public void applyPromoCodeAddMoney() {

    }

    public void handleSecurityPin(String pin) throws InterruptedException {
        String[] pinArr = pin.split("|");

        if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {

            for (String e : pinArr) {
                //Log.info("PRESS", e);
                AndroidElement androidElement = element.findElement(driver, By.id("btn_pin_" + e));
                Element.selectElement(driver, androidElement, e);
            }

        }
    }

    public void clickUpButton() {
        mbkCommonControlsPage.clickOnUpButton();
    }
}
