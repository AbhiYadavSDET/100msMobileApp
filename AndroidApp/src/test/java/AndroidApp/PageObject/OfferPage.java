package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OfferPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "btn_search")
    private AndroidElement offer_search_icon;

    @AndroidFindBy(xpath="//android.widget.LinearLayout/android.view.ViewGroup")
    private AndroidElement offer_list;

    @AndroidFindBy(id="offerSearchView")
    private AndroidElement offerSearchView;

    @AndroidFindBy(id="btn_categories")
    private AndroidElement offer_categories;

    @AndroidFindBy(xpath="//android.widget.LinearLayout/android.view.ViewGroup")
    private AndroidElement offer_list2;

    String close = "close_button";

    public OfferPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("*****Offer Page*****");
    }

    public void clickOnSearchOption() throws InterruptedException {
        Element.selectElement(driver, offer_search_icon, "Search Option");
    }

    public int noOfOffers() throws InterruptedException {
        return Element.findElements(driver, By.xpath("//android.widget.LinearLayout/android.view.ViewGroup")).size();
    }

    public void selectCategoryOption() throws InterruptedException{
        Element.selectElement(driver, offer_categories, "Select category option");
    }

    public void sendOfferName(String offerName) throws InterruptedException{
        Element.enterText(driver, offerSearchView, offerName, "Enter offer name "  );
    }

    public boolean isCloseButtonVisible() throws InterruptedException{
        return Element.waitForVisibility(driver, By.id(close));
    }





}
