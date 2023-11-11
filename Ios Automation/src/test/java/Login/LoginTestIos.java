package Login;

import Helpers.LoginHelperIos;
import Logger.Log;
import Utils.TestBaseIos;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestIos extends TestBaseIos {

    @Test(groups = {"loginFlow"}, priority = 0, description = "Verify Login Flow on Ios app")
    public void Test_Login_Flow_Ios() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelperIos loginHelperIos = new LoginHelperIos(getIosDriver());
        loginHelperIos.loginViaOtp("8076595767", "547372");

        Log.info("======= END : Login test =======");

    }
}
