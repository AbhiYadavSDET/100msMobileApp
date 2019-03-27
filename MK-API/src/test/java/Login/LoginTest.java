package Login;

import Config.Configuration;
import Login.Api.OnboardVerify;
import Login.Api.OtpCell;
import Login.Helper.OtpCellHelper;
import Login.Models.RequestDto.OnboardVerifyRequestDto;
import Login.Models.RequestDto.OtpCellDto;
import Utils.DatabaseSqlHelper;
import Utils.Log;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTest {

    Response response;
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @BeforeClass(alwaysRun = true)
    public void BeforeClass() {
        databaseSqlHelper.initiateOtpData();
    }


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

    @Test(groups = "insuranceSanity", priority = 2, dependsOnMethods = "Test01_generate_otp")
    public void Test02_view_Hash() {

        String otp = databaseSqlHelper.getOtp("9953138474");
        Log.info(otp);

        OnboardVerifyRequestDto onboardVerifyRequestDto = new OnboardVerifyRequestDto();
        onboardVerifyRequestDto.setAv(Integer.parseInt(Configuration.Payment.X_App_Version));
        onboardVerifyRequestDto.setV("2");
        onboardVerifyRequestDto.setCell("9953138474");
        onboardVerifyRequestDto.setOtp(otp);
        onboardVerifyRequestDto.setDeviceId(Configuration.Payment.DEVICE_ID);


        OnboardVerify onboardVerify = new OnboardVerify(onboardVerifyRequestDto);
        response = onboardVerify.execute();

        System.out.println(response.getBody().asString());

        String token = response.getHeader("token");
        String hashId = response.getHeader("hashId");

        Log.info("Token + Hash", hashId + "." + token);


    }

}
