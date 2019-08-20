package UITestFramework;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class MBKPermissions extends MobiKwikScreen {


    public MBKPermissions(IOSDriver driver) {
        super(driver);
    }

    public void selectElement(By target) throws InterruptedException {
        waitForVisibility(target);
        findElement(target).click();
    }


}
