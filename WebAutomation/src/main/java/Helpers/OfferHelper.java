package Helpers;

import PageObject.DashboardPage;
import PageObject.OffersPage;
import PageObject.Recharge.LandlinePage;
import PageObject.Recharge.RechargePage;
import Utils.Log;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class OfferHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    MbkReporter mbkReporter;
    OffersPage offersPage;

    public OfferHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }

    public void verifyOffers(String text){
        offersPage = dashboardPage.clickOnOffersSideDrawer();

        offersPage.enterSearchBox(text);

        offersPage.clickSearch();

        mbkReporter.verifyTrue(offersPage.noOfOffers() > 0, "Verify no of offers", true);
        Log.info("Count of offers" + offersPage.noOfOffers());

    }
}
