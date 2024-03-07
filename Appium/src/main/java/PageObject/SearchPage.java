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

    public Map<String , String> getTop8SearchResults() throws InterruptedException{


        Map<String, String> results = new HashMap<>();

        List<AndroidElement> title = Element.findElements(driver, By.id("title"));
        List<AndroidElement> description = Element.findElements(driver, By.id("description"));

//        for(int k=0; k<5;k++) {
//            Screen.swipeUpMoreFromRightSide(driver);
//            title.addAll(Element.findElements(driver, By.id("title")));
//            description.addAll(Element.findElements(driver, By.id("description")));
//
//        }

        for(int i=0; i<8;i++) {

            results.put(title.get(i+1).getText(), description.get(i).getText());
            Log.info(title.get(i+1).getText(), description.get(i).getText());

        }



        return results;

    }






}


