package test.java.AndroidApp.Helpers;

import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;

public class HomePageHelper {

    AndroidDriver driver;
    HomePage homePage;

    public HomePageHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);


    }

    public void clickOn(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");


    }


}
