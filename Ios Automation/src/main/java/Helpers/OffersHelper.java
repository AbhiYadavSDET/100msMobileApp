package Helpers;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.OffersPage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OffersHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    OffersPage offersPage;
    MbkCommonControlHelper mbkCommonControlHelper;

    public OffersHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        offersPage = new OffersPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void offersVerify(String offersName) throws InterruptedException, IOException {

        homePage.clickOnOffers();

        offersPage.clickOnSearchOffers();

        offersPage.enterOffersName(offersName);

        offersPage.clickOnSearchedOffer();

    }
}
