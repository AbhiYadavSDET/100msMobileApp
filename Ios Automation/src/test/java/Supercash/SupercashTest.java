package Supercash;

import Helpers.SupercashHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class SupercashTest extends TestBase {

    @Test(groups = {"supercashFlow"}, priority = 0, description = "Verify Supercash Flow on android app")
    public void Test_Supercash_Flow() throws InterruptedException, IOException {
        // Start the test
        SupercashHelper supercashHelper = new SupercashHelper(getAndroidDriver());
        supercashHelper.supercashView("9818484290" ,"Udit Gupta", "uditgupta5j15@gmail.com");

    }

}
