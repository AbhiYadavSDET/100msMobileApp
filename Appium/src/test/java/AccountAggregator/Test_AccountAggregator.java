package AccountAggregator;

import Helpers.AAHelper;
import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_AccountAggregator extends TestBase {

    @Test(groups = {"AccountAggregator", "Sanity"}, priority = 0, description = "Verify Existing User flow in AA")
    public void Test01_existing_User() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7367905899");

        // Thread.sleep(5000);

        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        aaHelper.existingUser();

    }


}
