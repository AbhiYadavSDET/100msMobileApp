package test.java.AndroidApp.Helpers;

import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.PermissionPage;

import java.util.HashMap;

public class PermissionHelper {
    AndroidDriver driver;
    PermissionPage permissionPage;
    public static HashMap<String, String> map;


    public PermissionHelper(AndroidDriver driver) {
        this.driver = driver;
        permissionPage = new PermissionPage(driver);
    }

    public boolean isPermissionPopUpPresent() throws InterruptedException {
        Thread.sleep(5000);

        if (Element.isElementPresent(driver, By.id("com.android.packageinstaller:id/dialog_container"))) {
            return true;
        } else {
            Log.info("Permission Popup is not present");
            return false;
        }
    }

    public void permissionAllow() throws InterruptedException {
        if (isPermissionPopUpPresent()) {
            permissionPage.clickOnPermissionAllow();
        }
    }

    public void permissionDeny() throws InterruptedException {
        if (isPermissionPopUpPresent()) {
            permissionPage.clickOnPermissionDeny();
        }
    }


}
