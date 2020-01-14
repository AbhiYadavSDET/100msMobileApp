package Helpers;

import PageObject.PermissionPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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

    public boolean isPermissionPopUpPresentV2() throws InterruptedException {
        //Thread.sleep(3000);

        if (Element.isElementPresent(driver, By.id("com.android.permissioncontroller:id/permission_message"))) {
            return true;
        } else {
            Log.info("Permission PopupV2 is not present");
            return false;
        }
    }

    public String permissionPopOpTextV2() throws InterruptedException {
        if (Element.isElementPresent(driver, By.id("com.android.permissioncontroller:id/permission_message"))) {
            return Element.getText(driver, (AndroidElement) driver.findElementById("com.android.permissioncontroller:id/permission_message"), "Permission Message");
        }
        else{return null;}
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
        if(isPermissionPopUpPresentV2())
        {
            if(permissionPopOpTextV2().contains("location"))
            {permissionPage.clickOnPermissionAlwaysAllowV2();}
                else {permissionPage.clickOnPermissionAllowV2();}
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
        if (isPermissionPopUpPresentV2()) {
            permissionPage.clickOnPermissionDenyV2();
        }
    }


}
