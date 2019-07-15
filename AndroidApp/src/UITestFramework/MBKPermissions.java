package UITestFramework;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MBKPermissions extends MobiKwikScreen {


    public MBKPermissions(AndroidDriver driver) {
        super(driver);
    }

    public void selectElement(By target) throws InterruptedException {
        waitForVisibility(target);
        findElement(target).click();
    }


}
