package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
//import utils.Element;

import java.io.IOException;

public class OfferPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "btn_search")
    private AndroidElement offer_search_icon;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.view.ViewGroup")
    private AndroidElement offer_list;

    @AndroidFindBy(id = "offerSearchView")
    private AndroidElement offerSearchView;

    @AndroidFindBy(id = "btn_categories")
    private AndroidElement offer_categories;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.view.ViewGroup")
    private AndroidElement offer_list2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'REDEEM SUPERCASH']")
    private AndroidElement redeemOffer;

    String close = "close_button";

    String categoryText = "text";

    String redeemOfferList = "card_view";


    public OfferPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("*****Offer Page*****");
    }
/*
    public void clickOnSearchOption() throws InterruptedException {
        Element.selectElement(driver, offer_search_icon, "Search Option");
    }

    public int noOfOffers() throws InterruptedException {
        return Element.findElements(driver, By.xpath("//android.widget.LinearLayout/android.view.ViewGroup")).size();
    }

    public void selectCategoryOption() throws InterruptedException {
        Element.selectElement(driver, offer_categories, "Select category option");
    }

    public void sendOfferName(String offerName) throws InterruptedException {
        Element.enterText(driver, offerSearchView, offerName, "Enter offer name ");
    }

    public boolean isCloseButtonVisible() throws InterruptedException {
        return Element.waitForVisibility(driver, By.id(close));
    }

    public int fetchCategoryList() throws InterruptedException {
        return Element.findElements(driver, By.id(categoryText)).size();
    }

    public void clickOnRedeemOffer() throws InterruptedException {
        Element.selectElement(driver, redeemOffer, "redeem offer");
    }

    public int fetchRedeemOffers() throws InterruptedException {
        return Element.findElements(driver, By.id(redeemOfferList)).size();
    }

 */

/*

    public void navigateBack() throws InterruptedException{
        Element.
    }
*/


}
