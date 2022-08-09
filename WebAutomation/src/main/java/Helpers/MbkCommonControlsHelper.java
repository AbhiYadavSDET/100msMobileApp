package Helpers;

import PageObject.HomePage;
import PageObject.MbkCommonControlsPage;
import PageObject.Recharge.GasPage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class MbkCommonControlsHelper {
    WebDriver driver;
    MbkReporter mbkReporter;
    GasPage gasPage;
    HomePage homePage;
    MbkCommonControlsPage mbkCommonControlsPage;

    public MbkCommonControlsHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
    }
    public String homeScreenBalance(){
        String balance=mbkCommonControlsPage.getBalance();
        return balance;
    }


}
