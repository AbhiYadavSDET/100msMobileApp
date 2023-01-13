package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OfferPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Offers']")
    private AndroidElement offerButton;

    @AndroidFindBy(id = "btn_search")
    private AndroidElement searchOffersButton;

    @AndroidFindBy(id = "offerSearchView")
    private AndroidElement searchTextBox;

    @AndroidFindBy(id = "offer_desc")
    private AndroidElement tileTitle;

    @AndroidFindBy(id = "offer_type")
    private AndroidElement tileDescription;

    @AndroidFindBy(id = "logo_image")
    private AndroidElement tileLogo;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement title;

    @AndroidFindBy(id = "button_launch_mobile_site")
    private AndroidElement cta;


    // -----------------------------------


    public OfferPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickOffers() {
        Elements.selectElement(driver, offerButton, "Offers");
    }

    public void clickSearchOfferButton() {
        Elements.selectElement(driver, searchOffersButton, "Search Offers");
    }

    public void enterOffer(String offer) {
        Elements.enterToElement(driver, searchTextBox, offer, "Enter Offer");
    }

    public String getTileTitle() throws InterruptedException {
        return Elements.getText(driver, tileTitle, "Tile Title");
    }

    public String getTileDescription() throws InterruptedException {
        return Elements.getText(driver, tileDescription, "Tile Description");
    }

    public void clickLogo() {
        Elements.selectElement(driver, tileLogo, "Logo");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Title");
    }

    public String getCtaText() throws InterruptedException {
        return Elements.getText(driver, cta, "Cta Text");
    }


}
