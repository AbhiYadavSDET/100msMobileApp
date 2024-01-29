package Helpers;

import Logger.Log;
import PageObject.CCBPPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.PermissionPage;
import Utils.Screen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MbkCommonControlHelper {

    IOSDriver<IOSElement> driver;
    PermissionPage permissionPage;
    HomePage homePage;
    CCBPPage ccbpPage;

    public MbkCommonControlHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        permissionPage = new PermissionPage(driver);
        homePage = new HomePage(driver);
        ccbpPage = new CCBPPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void handleHomePageLanding() throws InterruptedException {

        while(permissionPage.isPermissionPopUpPresent()){
            // Click Allow on Permission Pop Up
            permissionPage.clickOnAllow();
        }

        if(ccbpPage.isCCBPHomeBottomSheetShown()){
            // Click outside CCBP bottom sheet
            Screen.tapOutsideBottomSheetByCoordinates(driver);
        }

        if(homePage.isBillReminderPresent()){
            Screen.tapOutsideBottomSheetByCoordinates(driver);
        }

        if(permissionPage.isZipBottomSheetShown()){
            // Click outside zip bottom sheet
            Screen.tapOutsideBottomSheetByCoordinates(driver);
        }

        if(permissionPage.isEnablePasscodePopUpPresent()){
            // Click Later on Permission Pop Up
            permissionPage.clickOnLater();
        }

        if(homePage.isFloatingWidgitPresent()){
            // Close Floating Widgit
            homePage.closeFloatingWidgit();
        }
    }
}
