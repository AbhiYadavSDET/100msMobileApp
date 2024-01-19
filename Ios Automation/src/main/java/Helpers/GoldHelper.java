package Helpers;

import PageObject.*;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GoldHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PermissionPage permissionPage;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    RechargePage rechargePage;
    MBReporter mbReporter;
    HistoryPage historyPage;
    CCBPPage ccbpPage;
    GoldPage goldPage;

    public GoldHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        rechargePage = new RechargePage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        mbReporter = new MBReporter(driver);
        historyPage = new HistoryPage(driver);
        ccbpPage = new CCBPPage(driver);
        goldPage = new GoldPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void goldBuy() throws InterruptedException {

        //Click All services
        homePage.clickAllServices();

        Screen.swipeUp(driver);

        //Click on gold
        goldPage.clickGold();

        Thread.sleep(2000);

        Screen.tapOutsideBottomSheetByCoordinates(driver);




    }
}
