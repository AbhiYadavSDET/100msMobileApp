package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.SearchPage;
import PageObject.UpiPage;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.omg.PortableInterceptor.HOLDING;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;

public class SearchHelper {
    AndroidDriver<AndroidElement> driver;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    Map<String, String> searchResult;

    HomePage homePage;

    SearchPage searchPage;
    UpiPage upiPage;




    public SearchHelper(AndroidDriver<AndroidElement> driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        homePage=new HomePage(driver);
        searchPage= new SearchPage(driver);
        upiPage = new UpiPage(driver);

    }
    public void checkSearchPage() throws InterruptedException, IOException {

        //Click on xearch button
        searchPage=homePage.clickOnSearchCta();

        Element.waitForVisibility(driver, By.id("et_search"));

        //Get all results on search page
        searchResult=searchPage.getSearchResults();

        for (Map.Entry<String, String> entry : searchResult.entrySet()) {
            if (entry.getValue() != null) {
                Log.info(entry.getKey() + "=" + entry.getValue());
            }
        }
    }
    public void searchQueries(String [] validQueries) throws IOException, InterruptedException {

        String  product ;
        int length = validQueries.length;
        boolean isPermissionGiven = false;

        for(int i =0;i<length;i++){
            product = validQueries[i];

            //Check if String is having only digits
          if(  containsOnlyNumbers(product)) {

              //Check if contact permission is given
              if (!isPermissionGiven) {

                  // If only digit is present so contact permission need to give
                  if (searchPage.isBackbuttonPresent()) {

                      //Press back from search page
                      searchPage.backFromSearchPage();

                      //handle popups, bottomsheet
                      mbkCommonControlsHelper.handleHomePageLanding();
                  }

                  homePage.clickOnUPITransfers();

                  Screen.swipeUpMore(driver);
                  Screen.swipeUpMore(driver);

                  //Click on continue
                  upiPage.clickContinueForContacts1();

                 // Click on continue
                  upiPage.clickContinueForContacts2();

                  //Click on allow permission
                  upiPage.clickOnAllowContact();

                  //Permission is given alreay now so marking this true
                  isPermissionGiven = true;

                  //Press back from UPI page
                  upiPage.clickOnBackFromUPIpage();

                  //handle popups, bottomsheet
                  mbkCommonControlsHelper.handleHomePageLanding();
              }
          }

         if(! searchPage.isSearchPageOpen()){
             searchPage=homePage.clickOnSearchCta();
            }
            searchPage.enterText(product);
           // String resultXpath = "//android.widget.TextView[contains(@text, '" + product + "')]";

            mbReporter.verifyTrueWithLogging
                            (Element.isElementPresent(driver,By.xpath
                            ("//android.widget.TextView[contains(@text, '" + product + "')]"))
                            ,"Verifying search result ",false,false);

        }
    }

    public void searchInvalidQuery(String invalidData) throws IOException, InterruptedException {

        //Click on search button
        searchPage=homePage.clickOnSearchCta();

        //Enter invalid data
        searchPage.enterText(invalidData);

        mbReporter.verifyTrueWithLogging
                (Element.isElementPresent(driver,By.id
                                ("no_search_results"))
                        ,"Verifying invalid search result ",false,false);
    }

    public static boolean containsOnlyNumbers(String str) {

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
