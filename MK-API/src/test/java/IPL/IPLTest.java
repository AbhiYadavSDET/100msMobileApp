package IPL;

import IPL.Api.TeamList;
import IPL.Helper.TeamListHelper;
import Utils.ExtentReport;
import Utils.Log;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class IPLTest {

    Response response;


    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(Method method) {
        Log.info("****************:" + method.getName() + "****************");
    }


    @Test(groups = "IPLSanity", priority = 1)
    public void Test01_get_team_list() throws IOException {

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.startTest("Test01_get_team_list");

        TeamList teamList = new TeamList("1");
        response = teamList.execute();


        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);
        ExtentReport.extentReportDisplay(ExtentReport.Status.PASS, "STEP 1", "Validate Response Code = 200");

        //Assertions
        TeamListHelper teamListHelper = new TeamListHelper(response.getBody().asString());
        teamListHelper.verifySuccessResponse();
        teamListHelper.verifyListOfCategoriesSize(8);


        // End the test
        ExtentReport.EXTENTREPORT.endTest(ExtentReport.EXTENTTEST);
    }


}
