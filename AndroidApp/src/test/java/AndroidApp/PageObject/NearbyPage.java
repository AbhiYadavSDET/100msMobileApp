package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;

public class NearbyPage {

    AndroidDriver driver;



    @AndroidFindBy(id = "com.mobikwik_new:id/backIcon")
    private AndroidElement back_button_from_nearby_page;

    @AndroidFindBy(id= "com.mobikwik_new:id/mkab_icon_1")
    private AndroidElement back_button_from_nearby_internal_pages;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'KYC Centre']")
    private AndroidElement icon_kyc_centre;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Grocery']")
    private AndroidElement icon_grocery;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Loan Center']")
    private AndroidElement icon_loan_center;

    @AndroidFindBy(id= "com.mobikwik_new:id/mkab_title")
    private AndroidElement category_store_list;

    @AndroidFindBy(id= "com.mobikwik_new:id/search_nearby")
    private AndroidElement cta_search_nearby;

    @AndroidFindBy(id= "com.mobikwik_new:id/etSearch")
    private AndroidElement enter_search_store;

    @AndroidFindBy(id= "com.mobikwik_new:id/searchIcon")
    private AndroidElement cta_search_icon;




    public NearbyPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */
        Log.info("*****On Ola Page*****");
    }


public void clickOnBackButton() throws InterruptedException{
        Element.selectElement(driver, back_button_from_nearby_page, "Navigate back to Home");
}

public void clickOnBackButtonFromInternalPages() throws InterruptedException{
        Element.selectElement(driver, back_button_from_nearby_internal_pages, "Navigate back to Nearby Home");
    }

public void clickOnCategoryIcon(String choice) throws InterruptedException{


        switch (choice){

            case "KYC Centre":
                Element.selectElement(driver, icon_kyc_centre, "Select Kyc Centre");
                break;

            case "Grocery":
                Element.selectElement(driver, icon_grocery, "select Grocery");
                break;

            case "Loan Center":
                Element.selectElement(driver, icon_loan_center, "Select Loan centre");
                break;


        }


}

public String getCategoryStoreTitle() throws InterruptedException{

        return Element.getText(driver, category_store_list, "Get Category Page header");
}

public void clickSearchNearbyStores() throws InterruptedException{

        Element.selectElement(driver, cta_search_nearby, "Navigate to Search Page");
}

public void enterStore(String store) throws InterruptedException{
        Element.enterText(driver, enter_search_store, store,"Enter Store details");
}


public void clickSearchIcon() throws InterruptedException{
        Element.selectElement(driver, cta_search_icon, "Search Store");
}



}
