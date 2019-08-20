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

public class OfferPage {
    IOSDriver driver;

    @iOSXCUITFindBy(id = "btn_search")
    private IOSElement offer_search_icon;

    @iOSXCUITFindBy(xpath="//android.widget.LinearLayout/android.view.ViewGroup")
    private IOSElement offer_list;

    @iOSXCUITFindBy(id="offerSearchView")
    private IOSElement offerSearchView;

    @iOSXCUITFindBy(id="btn_categories")
    private IOSElement offer_categories;

    @iOSXCUITFindBy(xpath="//android.widget.LinearLayout/android.view.ViewGroup")
    private IOSElement offer_list2;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Redeem SuperCash']")
    private IOSElement redeemOffer;

    String close = "close_button";

    String categoryText = "text";

    String redeemOfferList = "com.mobikwik_new:id/click_view";


    public OfferPage(IOSDriver driver) throws IOException {
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

    public int fetchCategoryList() throws InterruptedException{
        return Element.findElements(driver, By.id(categoryText)).size();
    }

    public void clickOnRedeemOffer() throws InterruptedException{
        Element.selectElement(driver, redeemOffer, "redeem offer");
    }

    public int fetchRedeemOffers() throws InterruptedException{
        return Element.findElements(driver, By.id(redeemOfferList)).size();
    }

/*

    public void navigateBack() throws InterruptedException{
        Element.
    }
*/


}
