import Helpers.ProfileHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProfileTest extends TestBase {

    @Test(groups = {"profileFlow"}, priority = 0, description = "Verify Profile Flow on android app")
    public void Test_Profile_Flow() throws InterruptedException, IOException {
        // Start the test
        ProfileHelper profileHelp = new ProfileHelper(initiateTest());
        profileHelp.profileView("9818484290" ,"Udit Gupta", "uditgupta5j15@gmail.com");

    }

}
