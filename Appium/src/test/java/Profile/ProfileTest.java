package Profile;

import Helpers.LoginHelper;
import Helpers.ProfileHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProfileTest extends TestBase {

    @Test(groups = {"profileFlow"}, priority = 0, description = "Verify Profile Flow on android app")
    public void Test_Profile_Flow() throws InterruptedException, IOException {
        // Start the test
        Log.info("======= START : Profile Section =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");

        ProfileHelper profileHelp = new ProfileHelper(getAndroidDriver());
        profileHelp.profileView("9818484290" ,"Udit Gupta", "uditgupta5j15@gmail.com");

    }

}
