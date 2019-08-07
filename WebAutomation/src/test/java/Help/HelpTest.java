package Help;


import Helpers.HelpHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;


public class HelpTest extends TestBase {

    @Test(groups = {"helpFlow"}, priority = 0, description = "Verify Help Flow on Web")
    public void Test_Help_Flow() throws InterruptedException {

        LoginHelper loginHelper= new LoginHelper(driver);
        loginHelper.loginViaOtp("7795709569", "para jain", "par.ajjain@gmail.com", "7795709569");

        HelpHelper helpHelper= new HelpHelper(driver);
        helpHelper.help("This is a test ticket being raised by automation suite. In case you are reading this , Please close the ticket.-MobiKwik Team");


    }










}
