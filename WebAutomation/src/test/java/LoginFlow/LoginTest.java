package LoginFlow;

import Helpers.LoginHelper;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {


    @Test(groups = {"loginFlow"}, priority = 0, description = "Verify Login Flow on Web")
    public void Test_Login_Flow() throws InterruptedException, IOException {
        // Start the test
//        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Test_Login_Flow");

        LoginHelper loginHelper = new LoginHelper(getWebDriver());
        loginHelper.loginViaOtp("9205299330", "mobi testu", "mkwik9330@gmail.com", "9205299330");

    }


}
