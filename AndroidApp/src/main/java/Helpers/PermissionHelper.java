package Helpers;

import PageObject.PermissionPage;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.openqa.selenium.By;
import utils.Element;

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
        Thread.sleep(3000);

        if (Element.isElementPresent(driver, By.id("com.android.packageinstaller:id/dialog_container"))) {
            return true;
        } else {
            Log.info("Permission Popup is not present");
            return false;
        }
    }

    public boolean isHintForMobileNoVisible() throws InterruptedException {
        Thread.sleep(2000);

        if (Element.isElementPresent(driver, By.id("com.google.android.gms:id/credential_picker_layout"))) {
            return true;
        } else {
            Log.info("Hint For Mobile No. Popup is not present");
            return false;
        }

    }

    public void permissionAllow() throws InterruptedException {
        if (isPermissionPopUpPresent()) {
            permissionPage.clickOnPermissionAllow();
        }
    }

    public void dismissHintPopup() throws InterruptedException {
        if (isHintForMobileNoVisible()) {
            permissionPage.clickOnCancelHint();
        }
    }

    public void permissionDeny() throws InterruptedException {
        if (isPermissionPopUpPresent()) {
            permissionPage.clickOnPermissionDeny();
        }
    }


}
