package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

public class Test_Login extends CreateSession {

    @Test(groups = {"successfulLoginOnboarding"}, description = "Successful Login from Onboarding")
    public void Test_SuccessFulLoginOnboarding() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginFromOboarding(3);
    }

    @Test(groups = {"successfulLogViaMobileNo"}, description = "Successful Login via MobileNo")
    public void Test_SuccessFulLoginViaMobileNo() throws IOException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginViaMobileNo(3);
    }

    @Test(groups = {"successfulLoginViaEmail"}, description = "Successful Login via Email")
    public void Test_SuccessFulLoginViaEmail() throws IOException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");
    }

}
