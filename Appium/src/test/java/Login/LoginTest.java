package Login;

import Helpers.LoginHelper;
import utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {

    @Test(groups = {"loginFlow"}, priority = 0, description = "Verify Login Flow on android app")
    public void Test_Login_Flow() throws InterruptedException, IOException {
        // Start the test
        LoginHelper loginHelp = new LoginHelper(initiateTest());
        loginHelp.loginViaOtp("9818484290" ,"Udit Gupta", "uditgupta5j@gmail.com");

    }

}
