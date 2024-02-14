package Login;

import Helpers.LoginHelper;
import Logger.Log;
import org.testng.annotations.Test;
import Utils.ExtentReport;
import Utils.TestBase;

import java.io.IOException;

public class LoginTest extends TestBase {

    @Test(groups = {"loginFlow"}, priority = 0, description = "Verify Login Flow on android app")
    public void Test_Login_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

    }


    @Test(groups = {"logoutFlow"}, priority = 0, description = "Verify Logout Flow on android app")
    public void Test_Logout_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Logout test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("7042338867", "547372");
        loginHelp.logout("Login/Signup","Continue");
        Log.info("======= END : Logout test =======");

    }
}
