package IntegrationTests.Screens;

import UITestFramework.MobiKwikScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * contains all the locators present on the Add MOney Screen
 */
public class OnboardingScreen extends MobiKwikScreen {

    public OnboardingScreen(AndroidDriver driver) {
        super(driver);

    }

    // Add Money Screen
    public By addMoneySymbol = By.xpath("//android.widget.TextView[@text='4']");
    public By otpField = By.id("com.mobikwik_new:id/otp_field");
}
