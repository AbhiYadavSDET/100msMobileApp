package PageObject;

import Logger.Log;
import Utils.Element;
import Utils.Elements;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchPage {

    AndroidDriver driver;

    @AndroidFindBy (id="et_search")
    private AndroidElement search_bar;




    public SearchPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****All Services Page*****");
    }

    public void clickOnSearchBar() throws InterruptedException{
        Element.selectElement(driver, search_bar, "Click on Search Bar");

    }

    public Boolean isSearchPageOpen() throws InterruptedException{
        return Elements.isElementPresent(driver, search_bar);
    }
    public Map<String, String> getSearchResults() throws InterruptedException {
        Map<String, String> results = new LinkedHashMap<>();
        boolean isFirstIndexRight = false;

        for (int scrollCount = 0; scrollCount < 7; scrollCount++) {
            // Find all title and description elements after each scroll
            List<AndroidElement> titles = Element.findElements(driver, By.id("title"));
            List<AndroidElement> descriptions = Element.findElements(driver, By.id("description"));
            String titleText,descriptionText;

            // Ensure the size of titles and descriptions is the same
            int size = Math.min(titles.size() , descriptions.size());

            for (int i = 0; i < size; i++) {
                // Get text of title and description

                if (!isFirstIndexRight){
                     titleText = titles.get(i + 1).getText();
                }else{
                     titleText = titles.get(i ).getText();
                }

                 descriptionText = descriptions.get(i).getText();

                // Put them into results map
                results.put(titleText, descriptionText);
            }

            // Swipe to reveal more elements
            Screen.swipeUpMoreFromRightSide(driver);
            isFirstIndexRight = true;
        }
        return results;
    }
}


