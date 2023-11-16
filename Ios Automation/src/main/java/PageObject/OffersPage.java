package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='MobiKwik']//XCUIElementTypeScrollView//XCUIElementTypeButton[1]")
    private IOSElement search_offers;

    @iOSXCUITFindBy(id = "Search")
    private IOSElement search;

    @iOSXCUITFindBy(id = "DISCOUNT")
    private IOSElement searched_offer;

    public OffersPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnSearchOffers() {
        Elements.click(driver, search_offers,"Search Offers");
    }

    public void clickOnSearchedOffer() {
        Elements.click(driver, searched_offer,"Searched Offer");
    }

    public void enterOffersName(String offersName) {
        Elements.enterToElement(driver, search, offersName, "Enter Offers Name");
    }
}
