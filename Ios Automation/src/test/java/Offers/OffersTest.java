package Offers;

import Helpers.LoginHelper;
import Helpers.OffersHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class OffersTest extends TestBase {

    @Test(groups = {"offersFlow"}, priority = 0, description = "Verify Login Flow on Ios app")
    public void Test_Login_Flow_Ios() throws InterruptedException, IOException {

        Log.info("======= START : Offers test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("8076595767", "547372");

        OffersHelper offersHelper = new OffersHelper(getIosDriver());
        offersHelper.offersVerify("Cleartrip");

        Log.info("======= END : Offers test =======");

    }
}
