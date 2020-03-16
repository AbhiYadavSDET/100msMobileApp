package Helpers;


import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;

/**
 * contains all methods to test Add Money Flow
 */
public class CheckBalanceHelper {
    AndroidDriver driver;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    public static HashMap<String, String> currentBalance;


    public CheckBalanceHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);

    }


    public void checkBalance(String amount) throws InterruptedException, IOException,
            JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        currentBalance = mbkCommonControlsHelper.getBalance();

        Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(currentBalance, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;

        Double requiredBalance = Double.parseDouble(amount) * 100;

        if (actualMainBalance < requiredBalance) {

            AddMoneyHelper addMoneyHelper = new AddMoneyHelper(driver);

            int requiredAmount= (int)(requiredBalance-actualMainBalance) / 100;

//            Double requiredAmount= (requiredBalance-actualMainBalance) / 100;

            addMoneyHelper.addMoneyViaSavedCardWithinFlow(String.valueOf(requiredAmount), "4363 XXXX XXXX 4460", "239", "Paraj@1234");
            Log.info("Money Added");

        } else {

            Log.info("Sufficient Balance available");

        }


    }
}