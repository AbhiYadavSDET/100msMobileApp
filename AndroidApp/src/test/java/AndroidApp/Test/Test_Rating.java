package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

public class Test_Rating extends CreateSession {

    @Test(groups = {"ratingInGold"}, description = "5-star rating flow : GOLD.")
    public void Test_RatingGold() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginViaEmail(7);
    }






}
