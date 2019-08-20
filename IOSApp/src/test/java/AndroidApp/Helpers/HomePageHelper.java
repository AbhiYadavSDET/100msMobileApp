package test.java.AndroidApp.Helpers;


import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;

public class HomePageHelper {

    IOSDriver driver;
    HomePage homePage;

    public HomePageHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);


    }

    public void clickOn(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");


    }


}
