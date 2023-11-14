package Helpers;

import Logger.Log;
import PageObject.LoginPage;
import PageObject.PermissionPage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MbkCommonControlHelper {

    IOSDriver<IOSElement> driver;
    PermissionPage permissionPage;

    public MbkCommonControlHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        permissionPage = new PermissionPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void handleHomePageLanding() throws InterruptedException {

        while(permissionPage.isPermissionPopUpPresent()){
            // Click Allow on Permission Pop Up
            permissionPage.clickOnAllow();
        }

        if(permissionPage.isEnablePasscodePopUpPresent()){
            // Click Later on Permission Pop Up
            permissionPage.clickOnLater();
        }
    }
}
