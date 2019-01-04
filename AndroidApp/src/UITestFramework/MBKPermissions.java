package UITestFramework;

import IntegrationTests.Screens.OnboardingScreen;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.openqa.selenium.By;

public class MBKPermissions extends MobiKwikScreen {
    OnboardingScreen onboardingScreen;


    public MBKPermissions(AndroidDriver driver) {
        super(driver);
        onboardingScreen = new OnboardingScreen(driver);
    }

    public void selectElement(By target) throws InterruptedException {
        waitForVisibility(target);
        findElement(target).click();
    }

    public int selectElementWithScreenshot(By target, String directoryName, String screenName, int ssCount)
            throws InterruptedException {
        waitForVisibility(target);
        onboardingScreen.screenShot1(directoryName, screenName + "_" + ++ssCount);
        findElement(target).click();

        return ssCount;
    }


    public int handleKYCScreen(String directoryName, String screenName, int ssCount) throws InterruptedException {
        Thread.sleep(3000);

        if (onboardingScreen.isElementPresent(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]"))) {
            Log.info("Handle the KYC Popup");
            onboardingScreen.findElement(By.name("Skip")).click();

            onboardingScreen.iosDriverWait(20, By.name("No, Thanks"));
            onboardingScreen.findElement(By.name("No, Thanks")).click();
        }

        return ssCount;
    }

    public int handleNPSScreen(String directoryName, String screenName, int ssCount) throws InterruptedException {
        Thread.sleep(3000);

        if (onboardingScreen.isElementPresent(By.id("rating_container"))) {
            Log.info("Handle the NPS Popup");
            onboardingScreen.selectElement(By.id("close_button"));


            onboardingScreen.selectElement(By.id("base_icon_close"));

        }

        return ssCount;
    }


}
