package Help;


import Helpers.HelpHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class HelpTest extends TestBase {

    @Test(groups = {"helpFlow"}, priority = 0, description = "Verify Help Flow on Web")
    public void Test_Help_Flow() throws InterruptedException, IOException {

//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        HelpHelper helpHelper = new HelpHelper(getWebDriver());
        helpHelper.help("This is a test ticket being raised by automation suite. In case you are reading this , Please close the ticket.-MobiKwik Team");


    }


}
