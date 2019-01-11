package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

public class FiveStarRatingPage {

    AndroidDriver driver;


    @AndroidFindBy(id = "com.mobikwik_new:id/rating_stars")
    private AndroidElement rating_stars;

    @AndroidFindBy(id = "com.mobikwik_new:id/rating_button")
    private AndroidElement cta_rate_five_stars;

    @AndroidFindBy(id = "com.mobikwik_new:id/maybe_later")
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

}
