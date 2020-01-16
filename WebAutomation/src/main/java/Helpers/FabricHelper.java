package Helpers;

import PageObject.FabricPage;
import Utils.Log;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FabricHelper {


    WebDriver driver;
    FabricPage fabricPage;
    List<String> status;


    public FabricHelper(WebDriver driver) {
        this.driver = driver;
        fabricPage = new FabricPage(driver);
        status = new ArrayList<>();

    }

    public void fabricLogin() {
        // Enter the user details
        fabricPage.enterUserName("mayank.suneja@mobikwik.com");
        fabricPage.enterPassword("Tuesday20");
        fabricPage.clickSignIn();
        fabricPage.clickMobikwikAndroid();
    }

    public String fabricActiveUsers() {
        // Fetch the active users
        String activeUsers = fabricPage.getActiveUsers();
        Log.info("Active Users : " + activeUsers);
        return activeUsers;
    }

    public List<String> fabricStatus() throws InterruptedException {


        // Select the crashlytics tab
        fabricPage.hoverOnIconCrashlytics();
        fabricPage.clickCrashlytics();
        fabricPage.hoverOnLabelCrashes();

        // Display the status
        String crashFreeUsers = fabricPage.getCrashFreeUsers();
        String crashFreeSessions = fabricPage.getCrashFreeSessions();
        Log.info("Last 07 Days | Crash Free Users : " + crashFreeUsers + " | Crash Fee Sessions : " + crashFreeSessions);
        status.add("Last 07 Days | Crash Free Users : " + crashFreeUsers + " | Crash Fee Sessions : " + crashFreeSessions);

        fabricPage.clickDropDownArrow();
        fabricPage.selectLast30Days();
        crashFreeUsers = fabricPage.getCrashFreeUsers();
        crashFreeSessions = fabricPage.getCrashFreeSessions();
        Log.info("Last 30 Days | Crash Free Users : " + crashFreeUsers + " | Crash Fee Sessions : " + crashFreeSessions);
        status.add("Last 30 Days | Crash Free Users : " + crashFreeUsers + " | Crash Fee Sessions : " + crashFreeSessions);

        return status;
    }

    public HashMap<String, String> top3Crashes() throws InterruptedException {


        HashMap<String, String> crashDetails = new HashMap<>();


        // Fetch the top 3 crashes
        fabricPage.clickDropDownArrow();
        fabricPage.selectLast60Minutes();

        Thread.sleep(5000);
        fabricPage.moveToCrashes();
        crashDetails.put("1", fabricPage.getCrash1Title() + " | " + fabricPage.getCrash1Description() + " | " + fabricPage.getCrash1AppVersion() + " | " + fabricPage.getCrash1Crashes() + " | " + fabricPage.getCrash1Users());
        crashDetails.put("2", fabricPage.getCrash2Title() + " | " + fabricPage.getCrash2Description() + " | " + fabricPage.getCrash2AppVersion() + " | " + fabricPage.getCrash2Crashes() + " | " + fabricPage.getCrash2Users());
        crashDetails.put("3", fabricPage.getCrash3Title() + " | " + fabricPage.getCrash3Description() + " | " + fabricPage.getCrash3AppVersion() + " | " + fabricPage.getCrash3Crashes() + " | " + fabricPage.getCrash3Users());

        // Print the top 3 crashes
        Log.info("Crash 1 : " + crashDetails.get("1"));
        Log.info("Crash 2 : " + crashDetails.get("2"));
        Log.info("Crash 3 : " + crashDetails.get("3"));


        return crashDetails;
    }
}
