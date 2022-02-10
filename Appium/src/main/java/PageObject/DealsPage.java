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

public class DealsPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "cross_icon")
    private AndroidElement cross_icon;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.view.ViewGroup")
    private AndroidElement offer_list;

    @AndroidFindBy(id = "categories_search")
    private AndroidElement cta_categories;

    @AndroidFindBy(id = "btn_categories")
    private AndroidElement offer_categories;

   @AndroidFindBy(xpath= "//android.widget.TextView[@text='JioSaavn']")
   private AndroidElement jio_offer;

   @AndroidFindBy(id= "description_text")
   private AndroidElement get_description_text;

    @AndroidFindBy(id= "voucher_txt")
    private AndroidElement get_voucher_text;

    @AndroidFindBy(id="get_now_btn")
    private AndroidElement cta_buy_now;

    @AndroidFindBy(id= "mkab_icon_1")
    private AndroidElement back_button;


    String categorybox = "category_recycler_view";

    String categoryText = "icon_txt";

    String redeemOfferList = "card_view";


    public DealsPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("*****Offer Page*****");
    }

    public void closeBottomSheet() throws InterruptedException {
        Element.selectElement(driver, cross_icon, "Close Bottom Sheet");
    }


    public void selectCategoryOption() throws InterruptedException {
        Element.selectElement(driver, cta_categories, "Select category option");
    }

    public boolean isCategoryBottomSheetVisible() throws InterruptedException {
        return Element.waitForVisibility(driver, By.id(categorybox));
    }

    public int fetchCategoryList() throws InterruptedException {
        return Element.findElements(driver, By.id(categoryText)).size();
    }

    public void selectJioDeal() throws InterruptedException{
        Element.selectElement(driver, jio_offer, "Select Jio Offer");
    }

    public String getDescriptionText() throws InterruptedException{
        return Element.getText(driver, get_description_text, "Select Jio Offer Description");
    }

    public String getVoucherText() throws InterruptedException{
        return Element.getText(driver, get_voucher_text, "Select Jio Offer Voucher Details");
    }

    public void clickOnBuyNow() throws InterruptedException{
        Element.selectElement(driver, cta_buy_now, "Click on Buy Now");
    }

    public void clickOnBackButton() throws InterruptedException{
        Element.selectElement(driver, back_button, "Press Back Button");
    }


/*

    public void navigateBack() throws InterruptedException{
        Element.
    }
*/


}
