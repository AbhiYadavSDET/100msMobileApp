package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.SearchPage;
import Utils.Element;
import Utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class SearchHelper {
    AndroidDriver<AndroidElement> driver;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    Map<String, String> searchResult;

    HomePage homePage;

    SearchPage searchPage;




    public SearchHelper(AndroidDriver<AndroidElement> driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        homePage=new HomePage(driver);
        searchPage= new SearchPage(driver);

    }
    public void checkSearchPage() throws InterruptedException, IOException {

        searchPage=homePage.clickOnSearchCta();

        Element.waitForVisibility(driver, By.id("et_search"));

        searchResult=searchPage.getSearchResults();

        for (Map.Entry<String, String> entry : searchResult.entrySet()) {
            if (entry.getValue() != null) {
                Log.info(entry.getKey() + "=" + entry.getValue());
            }
        }







    }
}
