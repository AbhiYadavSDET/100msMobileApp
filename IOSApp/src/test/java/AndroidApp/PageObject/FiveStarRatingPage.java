package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class FiveStarRatingPage {

    IOSDriver driver;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/rating_stars")
    private IOSElement rating_stars;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/rating_button")
    private IOSElement cta_rate_five_stars;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/maybe_later")
    private IOSElement cta_maybe_later;


    public FiveStarRatingPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Five Star Rating Page*****");
    }

    public boolean isRatingPopUpDisplayed() throws InterruptedException {

        if(Element.isElementPresent(driver, By.id("com.mobikwik_new:id/rating_stars"))){
            return true;


        }else {

            return false;
        }
    }

    public void clickOnRateFiveStars(){
        Element.selectElement(driver, cta_rate_five_stars, "Click on Rate 5 Stars");

    }
    public void clickOnMaybeLater(){
        Element.selectElement(driver, cta_maybe_later, "Click on Maybe Later");

    }

}
