package fabric;

import Helpers.FabricHelper;
import Utils.ExtentReport;
import Utils.Log;
import Utils.TestBase;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;


public class FabricTest extends TestBase {


    @Test(groups = {"display"}, priority = 0, description = "Display the fabric status", dataProvider = "fabricData", dataProviderClass = FabricDataProviderClass.class)
    public void Test_Fabric_Status_Display(FrontEndEntity frontEndEntity) throws InterruptedException {


        FabricHelper fabricHelper = new FabricHelper(getWebDriver());

        fabricHelper.fabricLogin(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        String activeUsers = fabricHelper.fabricActiveUsers();

        List<String> status = fabricHelper.fabricStatus(frontEndEntity.getAmount(), frontEndEntity.getBankName(), frontEndEntity.getBankPageLocator(), frontEndEntity.getCardNo());

        HashMap<String, String> top3Crashes = fabricHelper.top3Crashes(frontEndEntity.getExpiryMonth());

        List<String> topDevices = fabricHelper.getTopDevices();
        List<String> topOS = fabricHelper.getTopOS();

        Log.info("Top Devices");
        if (topDevices != null) {
            for (String e : topDevices) {
                Log.info(e);
            }
        }

        Log.info("Top OS");
        if (topOS != null) {
            for (String e : topOS) {
                Log.info(e);
            }
        }

        String mailBody = "<H2>Active Users</H2>" + activeUsers + status.get(0) + status.get(1)
                + "<br><H2>Top 3 Crashes in Last 60 Minutes</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:90%;text-align: centre;\" ><tr><th>Title</th><th>Description</th><th>App Version</th><th>Crashes</th><th>Users</th><th>Link</th></tr>" + "<tr><td>" + top3Crashes.get("1").split("\\|")[0].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("1").split("\\|")[1].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("1").split("\\|")[2].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("1").split("\\|")[3].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("1").split("\\|")[4].replaceAll(" ", "") + "</td><td><a href=" + top3Crashes.get("1").split("\\|")[5].replaceAll(" ", "") + "> Link </a></td></tr>" + "<tr><td>" + top3Crashes.get("2").split("\\|")[0].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("2").split("\\|")[1].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("2").split("\\|")[2].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("2").split("\\|")[3].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("2").split("\\|")[4].replaceAll(" ", "") + "</td><td><a href=" + top3Crashes.get("2").split("\\|")[5].replaceAll(" ", "") + "> Link </a></td></tr>" + "<tr><td>" + top3Crashes.get("3").split("\\|")[0].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("3").split("\\|")[1].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("3").split("\\|")[2].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("3").split("\\|")[3].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("3").split("\\|")[4].replaceAll(" ", "") + "</td><td><a href=" + top3Crashes.get("3").split("\\|")[5].replaceAll(" ", "") + "> Link </a></td></tr></table>"
                + "<br><H2>Top 3 Devices & OS Versions</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:50%;text-align: centre;\" ><tr><th>Devices</th><th>OS Version</th></tr>" + "<tr><td>" + topDevices.get(0) + "</td><td>" + topOS.get(0) + "</td></tr>" + "<tr><td>" + topDevices.get(1) + "</td><td>" + topOS.get(1) + "</td></tr>" + "<tr><td>" + topDevices.get(2) + "</td><td>" + topOS.get(2) + "</td></tr>" + "</table>";

        //log.info(mailBody);

        if (FabricHelper.MAILFLAG) {

            Log.info("SEND", "MAIL");
            Long timestamp;
            timestamp = System.currentTimeMillis();

            Log.info(mailBody);
            ExtentReport.sendFabricStatusMail("Fabric | Android | Status | " + timestamp, mailBody);
        } else {
            Log.info("!SEND", "MAIL");

        }


    }

    @Test(groups = {"displayLastestApp"}, priority = 1, description = "Display the fabric status for latest App", dataProvider = "fabricData", dataProviderClass = FabricDataProviderClass.class)
    public void Test_Fabric_Status_Display_Latest_App(FrontEndEntity frontEndEntity) throws InterruptedException {

        FabricHelper fabricHelper = new FabricHelper(getWebDriver());

        fabricHelper.fabricLogin(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        String activeUsers = fabricHelper.fabricActiveUsers();

        fabricHelper.selectLatestAppVersions(frontEndEntity.getCardPassword());

        List<String> status = fabricHelper.fabricStatus();

        HashMap<String, String> top3Crashes = fabricHelper.top3Crashes(frontEndEntity.getExpiryMonth());

//        List<String> topDevices = fabricHelper.getTopDevices();
//        List<String> topOS = fabricHelper.getTopOS();
//
//        Log.info("Top Devices");
//        if (topDevices != null) {
//            for (String e : topDevices) {
//                Log.info(e);
//            }
//        }
//
//        Log.info("Top OS");
//        if (topOS != null) {
//            for (String e : topOS) {
//                Log.info(e);
//            }
//        }

        String mailBody = "<H2>Active Users</H2>" + activeUsers + status.get(0)
                + "<br><H2>Top 3 Crashes in Last 60 Minutes</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:90%;text-align: centre;\" ><tr><th>Title</th><th>Description</th><th>App Version</th><th>Crashes</th><th>Users</th><th>Link</th></tr>" + "<tr><td>" + top3Crashes.get("1").split("\\|")[0].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("1").split("\\|")[1].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("1").split("\\|")[2].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("1").split("\\|")[3].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("1").split("\\|")[4].replaceAll(" ", "") + "</td><td><a href=" + top3Crashes.get("1").split("\\|")[5].replaceAll(" ", "") + "> Link </a></td></tr>" + "<tr><td>" + top3Crashes.get("2").split("\\|")[0].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("2").split("\\|")[1].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("2").split("\\|")[2].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("2").split("\\|")[3].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("2").split("\\|")[4].replaceAll(" ", "") + "</td><td><a href=" + top3Crashes.get("2").split("\\|")[5].replaceAll(" ", "") + "> Link </a></td></tr>" + "<tr><td>" + top3Crashes.get("3").split("\\|")[0].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("3").split("\\|")[1].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("3").split("\\|")[2].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("3").split("\\|")[3].replaceAll(" ", "") + "</td><td>" + top3Crashes.get("3").split("\\|")[4].replaceAll(" ", "") + "</td><td><a href=" + top3Crashes.get("3").split("\\|")[5].replaceAll(" ", "") + "> Link </a></td></tr></table>";
//                + "<br><H2>Top 3 Devices & OS Versions</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:50%;text-align: centre;\" ><tr><th>Devices</th><th>OS Version</th></tr>" + "<tr><td>" + topDevices.get(0) + "</td><td>" + topOS.get(0) + "</td></tr>" + "<tr><td>" + topDevices.get(1) + "</td><td>" + topOS.get(1) + "</td></tr>" + "<tr><td>" + topDevices.get(2) + "</td><td>" + topOS.get(2) + "</td></tr>" + "</table>";

        if (frontEndEntity.getExpiryYear().equalsIgnoreCase("Enable")) {

            Log.info("SEND", "MAIL");
            Long timestamp;
            timestamp = System.currentTimeMillis();

            Log.info(mailBody);
            ExtentReport.sendLatestAppFabricStatusMail("Fabric | Android | Latest App | Status | " + timestamp, mailBody);
        } else {
            Log.info("!SEND", "MAIL");

        }
    }

}
