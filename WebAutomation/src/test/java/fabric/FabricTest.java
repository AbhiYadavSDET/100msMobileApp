package fabric;

import Helpers.FabricHelper;
import Utils.ExtentReport;
import Utils.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;


public class FabricTest extends TestBase {


    @Test(groups = {"display"}, priority = 0, description = "Display the fabric status")
    public void Test_Fabric_Status_Display() throws InterruptedException {


        FabricHelper fabricHelper = new FabricHelper(getWebDriver());

        fabricHelper.fabricLogin();

        String activeUsers = fabricHelper.fabricActiveUsers();

        List<String> status = fabricHelper.fabricStatus();

        HashMap<String, String> top3Crashes = fabricHelper.top3Crashes();

        String mailBody = "<H2>Active Users</H2>" + activeUsers + "<H2>Crash Rate</H2>" + status.get(0) + "<br>" + status.get(1) + "<br>" + "<br>" + "<H2>Top 3 Crashes in Last 60 Minutes</H2>" + "<H4>Crash 1 : </H4>" + top3Crashes.get("1") + "<br>" + "<H4>Crash 2 : </H4>" + top3Crashes.get("2") + "<br>" + "<H4>Crash 3 : </H4>" + top3Crashes.get("3");

        Log.info(mailBody);
        ExtentReport.sendFabricStatusMail("Fabric | Android | Status", mailBody);


    }

}
