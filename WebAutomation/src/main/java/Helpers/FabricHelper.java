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
    public static Boolean MAILFLAG = false;


    public FabricHelper(WebDriver driver) {
        this.driver = driver;
        fabricPage = new FabricPage(driver);
        status = new ArrayList<>();

    }

    public void fabricLogin(String username, String password) {
        // Enter the user details
        fabricPage.enterUserName(username);
        fabricPage.enterPassword(password);
        fabricPage.clickSignIn();
        fabricPage.clickMobikwikAndroid();
    }

    public String fabricActiveUsers() {
        // Fetch the active users
        String activeUsers = fabricPage.getActiveUsers();
        Log.info("Active Users : " + activeUsers);
        return activeUsers;
    }

    public List<String> fabricStatus(String stringExpectedCrashFreeUsers7Days, String stringExpectedCrashFreeSessions7Days, String stringExpectedCrashFreeUsers30Days, String stringExpectedCrashFreeSessions30Days) throws InterruptedException {


        // Select the crashlytics tab
        fabricPage.hoverOnIconCrashlytics();
        fabricPage.clickCrashlytics();
        fabricPage.hoverOnLabelCrashes();

        // Display the status
        String crashFreeUsers = fabricPage.getCrashFreeUsers();
        String crashFreeSessions = fabricPage.getCrashFreeSessions();
        Log.info("Last 07 Days | Crash Free Users : " + crashFreeUsers + " | Crash Fee Sessions : " + crashFreeSessions);
        status.add("<H2>Crash Rate</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:60%;text-align: centre;\">" + "<tr><th>Duration</th><th>Crash Free Users</th><th>Crash Free Sessions</th>" + "</tr><tr><td>Last 07 Days</td><td>" + crashFreeUsers + "</td><td>" + crashFreeSessions + "</td></tr>");

        // setting the mail flag
        Double expectedCrashFreeUsers7Days = Double.parseDouble(stringExpectedCrashFreeUsers7Days);
        Double expectedCrashFreeSessions7Days = Double.parseDouble(stringExpectedCrashFreeSessions7Days);
        if (Double.parseDouble(crashFreeUsers.replace("%", "")) < expectedCrashFreeUsers7Days || Double.parseDouble(crashFreeSessions.replace("%", "")) < expectedCrashFreeSessions7Days) {
            Log.info("Set Flag true", "7 days");
            MAILFLAG = true;
        }

        fabricPage.clickDropDownArrow();
        fabricPage.selectLast30Days();
        crashFreeUsers = fabricPage.getCrashFreeUsers();
        crashFreeSessions = fabricPage.getCrashFreeSessions();
        Log.info("Last 30 Days | Crash Free Users : " + crashFreeUsers + " | Crash Fee Sessions : " + crashFreeSessions);
        status.add("</tr><tr><td>Last 30 Days</td><td>" + crashFreeUsers + "</td><td>" + crashFreeSessions + "</td></tr></table>");

        // setting the mail flag
        Double expectedCrashFreeUsers30Days = Double.parseDouble(stringExpectedCrashFreeUsers30Days);
        Double expectedCrashFreeSessions30Days = Double.parseDouble(stringExpectedCrashFreeSessions30Days);
        if (Double.parseDouble(crashFreeUsers.replace("%", "")) < expectedCrashFreeUsers30Days || Double.parseDouble(crashFreeSessions.replace("%", "")) < expectedCrashFreeSessions30Days) {
            Log.info("Set Flag true", "30 days");
            MAILFLAG = true;
        }

        return status;
    }

    public HashMap<String, String> top3Crashes(String count) throws InterruptedException {


        HashMap<String, String> crashDetails = new HashMap<>();


        // Fetch the top 3 crashes
        fabricPage.clickDropDownArrow();
        fabricPage.selectLast60Minutes();

        Thread.sleep(5000);
        fabricPage.moveToCrashes();
        crashDetails.put("1", fabricPage.getCrash1Title() + " | " + fabricPage.getCrash1Description() + " | " + fabricPage.getCrash1AppVersion() + " | " + fabricPage.getCrash1Crashes() + " | " + fabricPage.getCrash1Users() + " | " + fabricPage.getCrash1Link());
        crashDetails.put("2", fabricPage.getCrash2Title() + " | " + fabricPage.getCrash2Description() + " | " + fabricPage.getCrash2AppVersion() + " | " + fabricPage.getCrash2Crashes() + " | " + fabricPage.getCrash2Users() + " | " + fabricPage.getCrash2Link());
        crashDetails.put("3", fabricPage.getCrash3Title() + " | " + fabricPage.getCrash3Description() + " | " + fabricPage.getCrash3AppVersion() + " | " + fabricPage.getCrash3Crashes() + " | " + fabricPage.getCrash3Users() + " | " + fabricPage.getCrash3Link());

        // Print the top 3 crashes
        Log.info("Crash 1 : " + crashDetails.get("1"));
        Log.info("Crash 2 : " + crashDetails.get("2"));
        Log.info("Crash 3 : " + crashDetails.get("3"));

        // setting the mail flag
        Integer crashCount = Integer.parseInt(count);
        Integer actualCrashCount = Integer.valueOf(crashDetails.get("1").split("\\|")[3].replaceAll(" ", ""));
        System.out.println("Log: " + actualCrashCount);
        if (actualCrashCount > crashCount) {
            Log.info("Set Flag true", "Top 3 crashes");
            MAILFLAG = true;
        }

        return crashDetails;
    }
}
