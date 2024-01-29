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
        profileHelp.profileView("9205299330" ,"mobile test number", "mkwik9330@gmail.com","UPI ID: 9205299330@mbk");

    }

}
