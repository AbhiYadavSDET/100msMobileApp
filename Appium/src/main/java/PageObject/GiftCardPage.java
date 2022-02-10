package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class GiftCardPage {
    AndroidDriver driver;


    @AndroidFindBy(id= "body_text")
    private AndroidElement error_popup_text;

    @AndroidFindBy(id="primary_button")
    private AndroidElement cta_error_ok;

    @AndroidFindBy(id = "btn_action")
    private AndroidElement cta_view_gift_cards;


    @AndroidFindBy(id = "btn_search")
    private AndroidElement navigate_search_gift_cards;

    @AndroidFindBy(id = "offerSearchView")
    private AndroidElement search_gift_cards;

    @AndroidFindBy(id = "offer_brand")
    private AndroidElement get_brand_name;

    @AndroidFindBy(id = "offer_brand")
    private AndroidElement select_brand_gift_card;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='X100']")
    private AndroidElement enter_amount;

    @AndroidFindBy(id = "action_button")
    private AndroidElement cta_next;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Name']/following::android.widget.EditText")
    private AndroidElement text_box_name;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Phone Number']/following::android.widget.EditText")
    private AndroidElement text_phone_no;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Email Address']/following::android.widget.EditText")
    private AndroidElement text_email_id;

    @AndroidFindBy(id = "btnPreview")
    private AndroidElement cta_buy_card;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement back_button;

    //Success Page

    @AndroidFindBy(id = "base_title")
    private AndroidElement gift_card_success_page_title;

    @AndroidFindBy(id = "brand")
    private AndroidElement success_page_brand_name;

    @AndroidFindBy(id = "buttonViewHoldings")
    private AndroidElement cta_ok;

    @AndroidFindBy(id = "base_icon_close")
    private AndroidElement cross_icon;

    @AndroidFindBy(id = "textActionButton")
    private AndroidElement cta_my_gifts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Sent']")
    private AndroidElement sent_gift_cards;

    @AndroidFindBy(id = "order_id_txt")
    private AndroidElement order_id;

    @AndroidFindBy(id = "recipient_txt")
    private AndroidElement reciepient;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'More']")
    private AndroidElement icon_more;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'e-Com and Online']")
    private AndroidElement icon_trending;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Gift a loved one']")
    private AndroidElement gift_to_loved_one;

    public GiftCardPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickViewGiftCards() throws InterruptedException {
        Element.selectElement(driver, cta_view_gift_cards, "View Gift Cards");
    }


    public void searchGiftCard() throws InterruptedException {
        Element.selectElement(driver, navigate_search_gift_cards, "Naviagte to search");
    }


    public void enterGiftCard(String giftCard) throws InterruptedException {
        Element.enterText(driver, search_gift_cards, giftCard, "Enter Gift Card  to search");
    }

    public String getBrandName() throws InterruptedException {
        return Element.getText(driver, get_brand_name, "Get Brand name displayed after search");
    }

    public void selectBrandGiftCard() throws InterruptedException {
        Element.selectElement(driver, select_brand_gift_card, "Select gift Card");
    }

    public void enterAmount(String amount) throws InterruptedException {

        Element.enterText(driver, enter_amount, amount, "Enter min amount 100");
    }

    public void selectAmount() throws InterruptedException {
        Element.selectElement(driver, enter_amount, "Select 100 Rs Amount");
    }

    public void clickNext() throws InterruptedException {
        Element.selectElement(driver, cta_next, "Click Next Button");
    }

    public void enterName(String name) throws InterruptedException {
        String oldName = Element.getText(driver, text_box_name, "Get Text");

        Element.clearText(driver, text_box_name, oldName, "Clear old name");

        Element.enterText(driver, text_box_name, name, "Enter Required name");

    }

    public void enterPhoneNumber(String phoneNumber) throws InterruptedException {

        Element.enterText(driver, text_phone_no, phoneNumber, "Enter Required phone Number");

    }

    public void enterEmailId(String emailId) throws InterruptedException {
        String oldEmailId = Element.getText(driver, text_email_id, "Get Text");

        Element.clearText(driver, text_email_id, oldEmailId, "Clear old Email Id");

        Element.enterText(driver, text_email_id, emailId, "Enter Required email Id");

    }


    public void clickBuyCard() throws InterruptedException {
        Element.selectElement(driver, cta_buy_card, "Buy Card");
    }

    public String getSuccessPageTitle() throws InterruptedException {
        return Element.getText(driver, gift_card_success_page_title, "Success Page Title");
    }

    public String getErrorPopUpText() throws InterruptedException{
        return Element.getText(driver, error_popup_text, "Error Pop Up Text");
    }

    public String getSuccessPageBrand() throws InterruptedException {
        return Element.getText(driver, success_page_brand_name, "Brand name on success page");
    }


    public void clickOk() throws InterruptedException {
        Element.selectElement(driver, cta_ok, "Click on OK button");
    }

    public void clickOnCross() throws InterruptedException {
        Element.selectElement(driver, cross_icon, "Click on Cross Icon");
    }

    public void clickBackToHome() throws InterruptedException {
        Element.waitForVisibility(driver, By.id("mkab_icon_1"));
        Element.selectElement(driver, back_button, "Navigate back to Home Page.");
    }

    public void clickMyGiftsButton() throws InterruptedException {
        Element.selectElement(driver, cta_my_gifts, "Navigate to My gifts section");
    }

    public void checkSentGiftCards() throws InterruptedException {
        Element.selectElement(driver, sent_gift_cards, "Check Sent Gift Cards");
    }


    public String getOrderId() throws InterruptedException {
        return Element.getText(driver, order_id, "Get order Id displayed");
    }


    public String getRecipientName() throws InterruptedException {
        return Element.getText(driver, reciepient, "Get order Id displayed");
    }


    public void clickMoreIcon() throws InterruptedException {
        Element.selectElement(driver, icon_more, "Click on More");
    }

    public void clickTrendingIcon() throws InterruptedException {
        Element.selectElement(driver, icon_trending, "Click on Trending");
    }

    public void pressOk() throws InterruptedException{
        Element.selectElement(driver, cta_error_ok, "Press Ohk");
    }

    public void selectGiftToLovedOne() throws InterruptedException{
        Element.selectElement(driver, gift_to_loved_one, "Select Gift to Loved One");
    }

}