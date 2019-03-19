package IPL;

import IPL.Api.TeamList;
import IPL.Helper.TeamListHelper;
import Utils.Log;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class IPLTest {

    Response response;


    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(Method method) {
        Log.info("****************:" + method.getName() + "****************");
    }


    @Test(groups = "insuranceSanity", priority = 1)
    public void Test01_get_team_list() {


        TeamList teamList = new TeamList("1");
        response = teamList.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Assertions
        TeamListHelper teamListHelper = new TeamListHelper(response.getBody().asString());
        teamListHelper.verifySuccessResponse();
        teamListHelper.verifyListOfCategoriesSize(8);


    }

}
