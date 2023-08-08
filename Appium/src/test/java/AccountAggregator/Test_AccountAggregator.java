package AccountAggregator;

import Helpers.AAHelper;
import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_AccountAggregator extends TestBase {

    @Test(groups = {"AccountAggregator", "sanity"}, priority = 0, description = "Verify Existing User flow in AA")
    public void Test01_existing_User() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569" , "547372");


        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        aaHelper.existingUser();

    }


}
