package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

public class FiveStarRatingPage {

    AndroidDriver driver;


    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/rating_stars")
    private AndroidElement rating_stars;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/rating_button")
    private AndroidElement cta_rate_five_stars;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/maybe_later")
    private AndroidElement cta_maybe_later;


    public FiveStarRatingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Five Star Rating Page*****");
    }

    public boolean isRatingPopUpDisplayed() throws InterruptedException {

        if (Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/rating_stars"))) {
            return true;


        } else {

            return false;
        }
    }

    public void clickOnRateFiveStars() {
        Element.selectElement(driver, cta_rate_five_stars, "Click on Rate 5 Stars");

    }

    public void clickOnMaybeLater() {
        Element.selectElement(driver, cta_maybe_later, "Click on Maybe Later");

    }

}
