package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OlaPage {

    IOSDriver driver;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/gps_turn_txt")
    private IOSElement text_gps_off;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/gps_turn_on_btn")
    private IOSElement button_turn_on_gps;


}
