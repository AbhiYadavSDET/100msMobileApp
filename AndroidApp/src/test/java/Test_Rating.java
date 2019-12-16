
import Helpers.LoginHelper;
import Helpers.RatingPageHelper;
import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Rating extends CreateSession {

    @Test(groups = {"ratingInGold"}, description = "5-star rating flow : GOLD.")
    public void Test_RatingGold() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        //loginHelper.doLoginViaEmail(3);
        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");


        RatingPageHelper ratingPageHelper = new RatingPageHelper(getAndroidDriver());
        ratingPageHelper.ratingGold(1);
    }


}
