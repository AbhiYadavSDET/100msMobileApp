package FeedbackForm;

import Helpers.FeedbackFormHelper;
import Helpers.LoginHelper;
import Helpers.PipedGasHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class FeedbackFormTest extends TestBase {

    @Test(groups = {"sanity", "Submit Feedback Form"}, priority = 0, description = "Submit Feedback Form")

    public void FeedbackForm_Test01_submitFeedbackForm()throws InterruptedException, IOException {


        Log.info("======= START : Login Test =======");
        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Submit Feedback form =======");

        // Execute the test
        FeedbackFormHelper feedbackFormHelper  = new FeedbackFormHelper(getAndroidDriver());
        feedbackFormHelper.submitFeedbackForm("Recharge & Bill Payments");

        Log.info("======= END : View Piped Gas Bill =======");
    }


}

