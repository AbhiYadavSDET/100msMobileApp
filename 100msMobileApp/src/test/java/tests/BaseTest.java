package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Pixel_4");
            capabilities.setCapability("app", "/Users/Abhishekkumar/IdeaProjects/100msMobileApp/100msMobileApp/app/base.apk");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("autoGrantPermissions", true);

            // Ensure you're connecting to the correct Appium server URL
            URL appiumServerUrl = new URL("http://127.0.0.1:4723"); // URL for Appium v2
            driver = new AndroidDriver<>(appiumServerUrl, capabilities);
        }

        // Initialize page elements using the driver, and ensure driver is not null
        if (driver != null) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            throw new IllegalStateException("Driver is not initialized.");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
