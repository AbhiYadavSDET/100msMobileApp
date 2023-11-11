package Login;

import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {

    @Test(groups = {"loginFlow"}, priority = 0, description = "Verify Login Flow on Ios app")
    public void Test_Login_Flow_Ios() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("8076595767", "547372");

        Log.info("======= END : Login test =======");

    }
}
