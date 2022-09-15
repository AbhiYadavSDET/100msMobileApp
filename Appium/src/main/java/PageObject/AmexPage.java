package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
//import utils.Element;

import java.io.IOException;

public class AmexPage {

    AndroidDriver driver;

    @AndroidFindBy(id="img_card_front")
    private AndroidElement amex_card_front;

    @AndroidFindBy(id="tv_name")
    private AndroidElement name_card;

    @AndroidFindBy(id="tv_offer")
    private AndroidElement offer_text;

    @AndroidFindBy(id="tv_tap_to_view")
    private AndroidElement otp_text;

    @AndroidFindBy(id="recent_history_title")
    private AndroidElement dropdown_transaction_history;

    @AndroidFindBy(id="ic_supercash")
    private AndroidElement close_dropdown;

    @AndroidFindBy(id="mkab_icon_1")
    private AndroidElement cta_back_button;



    public AmexPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Amex Page*****");
    }
/*
    public void selectAmexCard() throws InterruptedException {
        Element.selectElement(driver, amex_card_front, "Select Amex Card");
    }

    public String getOfferText() throws InterruptedException {
        return Element.getText(driver, offer_text, "Get Offer Text");
    }

    public String getOtpText() throws InterruptedException {
        return Element.getText(driver, otp_text, "Get Otp Text");
    }

    public boolean getNameOnCard() throws InterruptedException {
        return Element.isElementPresent(driver, By.id("tv_name"));
    }

    public void selectTransactionHistory() throws InterruptedException {
        Element.selectElement(driver, dropdown_transaction_history, "Select Transaction History");
    }

    public void closeDropdown() throws InterruptedException {
        Element.selectElement(driver, close_dropdown, "Close Transaction History");
    }

    public void clickOnBackButton() throws InterruptedException {
        Element.selectElement(driver, cta_back_button, "Click on Back Button");
    }

 */

}
