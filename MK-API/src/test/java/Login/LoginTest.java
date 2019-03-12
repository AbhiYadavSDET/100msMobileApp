package Login;

import Login.Api.OtpCell;
import Login.Helper.OtpCellHelper;
import Login.Models.RequestDto.OtpCellDto;
import Utils.Log;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTest {

    Response response;


    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(Method method) {
        Log.info("****************:" + method.getName() + "****************");
    }


    @Test(groups = "insuranceSanity", priority = 1)
    public void Test01_generate_otp() {
        int count = 0;

        OtpCellDto otpCellDto = new OtpCellDto();
        otpCellDto.setCell("9953138474");


        OtpCell otpCell = new OtpCell(otpCellDto);
        response = otpCell.execute();

        System.out.println(response.getBody().asString());

        OtpCellHelper otpCellHelper = new OtpCellHelper(response.getBody().asString());

        //Assertions
        otpCellHelper.verifySuccessResponse();
        otpCellHelper.verifyData();


    }

}
