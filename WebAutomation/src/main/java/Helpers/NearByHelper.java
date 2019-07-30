package Helpers;

import PageObject.DashboardPage;
import PageObject.NearByPage;
import PageObject.OffersPage;
import PageObject.Recharge.LandlinePage;
import PageObject.Recharge.RechargePage;
import Utils.Log;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class NearByHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    MbkReporter mbkReporter;
    NearByPage nearByPage;

    public NearByHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }

    public void verifyLocalStores(String text){
        nearByPage = dashboardPage.clickOnLocalStoreSideDrawer();

        mbkReporter.verifyTrue(nearByPage.noOfStores() > 0, "Page Loaded | Verify no of local stores", true);
        Log.info("Count of stores" + nearByPage.noOfStores());

        nearByPage.enterSearchBox(text);

        nearByPage.clickSearch();

        mbkReporter.verifyTrue(nearByPage.noOfStores() > 0, "Page Reloaded | Verify no of local stores", true);
        Log.info("Count of stores" + nearByPage.noOfStores());

    }
}
