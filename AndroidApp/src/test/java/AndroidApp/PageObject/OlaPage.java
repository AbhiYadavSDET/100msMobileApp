package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OlaPage {

    AndroidDriver driver;



    @AndroidFindBy(id = "com.mobikwik_new:id/gps_turn_txt")
    private AndroidElement text_gps_off;

    @AndroidFindBy(id = "com.mobikwik_new:id/gps_turn_on_btn")
    private AndroidElement button_turn_on_gps;

    @AndroidFindBy(id= "com.mobikwik_new:id/drop_loc_layout")
    private AndroidElement click_drop_location;

    //Ola Setup web view




    public OlaPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Ola Page*****");
    }
}
