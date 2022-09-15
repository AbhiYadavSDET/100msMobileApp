package Login;

import Helpers.LoginHelper;
import org.testng.annotations.Test;
import Utils.ExtentReport;
import Utils.TestBase;

import java.io.IOException;

public class LoginTest extends TestBase {

    @Test(groups = {"loginFlow"}, priority = 0, description = "Verify Login Flow on android app")
    public void Test_Login_Flow() throws InterruptedException, IOException {

        ExtentReport.EXTENTREPORT.createTest("Verify Login Flow on android app");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

    }

}
