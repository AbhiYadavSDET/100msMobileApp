package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.PermissionPage;
import PageObject.RechargePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RechargeHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PermissionPage permissionPage;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    RechargePage rechargePage;

    public RechargeHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        rechargePage = new RechargePage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void prepaidRecharge() throws InterruptedException {

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        //Provide loaction access while using app
        permissionPage.clickAllowWhileUsingApp();

        //Click on Mobile option
        rechargePage.clickMobile();

    }

}
