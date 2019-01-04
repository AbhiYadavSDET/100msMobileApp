package IntegrationTests.Screens;

import UITestFramework.MobiKwikScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NearByScreen extends MobiKwikScreen {
    public NearByScreen(AndroidDriver driver) {
        super(driver);

    }

    public By services = By.xpath("//android.widget.TextView[@text = 'Services']");
    public By nearbyIcon = By.xpath("//android.widget.TextView[@text = 'Local Stores']");
    public By storesByAdd = By.id("com.mobikwik_new:id/tv_store_address");
    public By searchIcon = By.id("com.mobikwik_new:id/icon_search_nearby");
    public By searchBar = By.id("com.mobikwik_new:id/etSearch");
    public By searchIcon2 = By.id("com.mobikwik_new:id/searchIcon");
    public By storesByAdd1 = By.id("com.mobikwik_new:id/tvResultCount");

}
