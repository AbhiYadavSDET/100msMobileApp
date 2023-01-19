package Rewards;

import Helpers.LoginHelper;
import Helpers.RewardsHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class RewardsTest extends TestBase {


    @Test(groups = {"sanity", "spinthewheel"}, priority = 0, description = "Spin the Wheel")
    public void Test01_buyGold() throws IOException, InterruptedException {

        Log.info("======= START : Spin the Wheel test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");
        //loginHelper.quickLoginViaOtp("9953138474", "");

        // Execute the test
        RewardsHelper rewardsHelper = new RewardsHelper(getAndroidDriver());
        rewardsHelper.spinTheWheel("Feeling Lucky?", "Spin the wheel and win exciting rewards everyday.", "Spin the wheel");

        Log.info("======= END : Spin the Wheel test =======");


    }

}
