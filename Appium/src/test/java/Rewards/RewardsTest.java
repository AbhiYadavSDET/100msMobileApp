package Rewards;

import Helpers.LoginHelper;
import Helpers.RewardsHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class RewardsTest extends TestBase {


    @Test(groups = {"sanity", "spinthewheel", "regression", "test"}, priority = 0, description = "Spin the Wheel")
    public void Test_Rewards_spinTheWheel() throws IOException, InterruptedException {

        Log.info("======= START : Spin the Wheel test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");
        //loginHelper.quickLoginViaOtp("9953138474", "");

        // Execute the test
        RewardsHelper rewardsHelper = new RewardsHelper(getAndroidDriver());
        rewardsHelper.spinTheWheel("Voucher", "After claiming your voucher will be available after 24 hours.");

        Log.info("======= END : Spin the Wheel test =======");


    }

    @Test(groups = {"sanity", "spinthewheel", "regression", "test"}, priority = 0, description = "Check Rewards")
    public void Test_Rewards_CheckRewards() throws IOException, InterruptedException {

        Log.info("======= START : Check Rewards Test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");
        //loginHelper.quickLoginViaOtp("9953138474", "");

        // Execute the test
        RewardsHelper rewardsHelper = new RewardsHelper(getAndroidDriver());
        rewardsHelper.checkRewards("Voucher", "You claimed your rewards, share your experience with your friends");

        Log.info("======= END : Check Rewards Test =======");


    }

    @Test(groups = {"sanity1", "spinthewheel", "regression", "test"}, priority = 0, description = "Check cashback history")
    public void Test_Rewards_CashbackHistory() throws IOException, InterruptedException {

        Log.info("======= START : Check Cashback History Test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");
        //loginHelper.quickLoginViaOtp("9953138474", "");

        // Execute the test
        RewardsHelper rewardsHelper = new RewardsHelper(getAndroidDriver());
        rewardsHelper.cashbackHistroy("Current Balance");

        Log.info("======= END : Check Cashback History Test =======");

    }

    @Test(groups = {"sanity1", "spinthewheel", "regression", "test"}, priority = 0, description = "Check supercash history")
    public void Test_Rewards_SupercashHistory() throws IOException, InterruptedException {

        Log.info("======= START : Check Supercash History Test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");
        //loginHelper.quickLoginViaOtp("9953138474", "");

        // Execute the test
        RewardsHelper rewardsHelper = new RewardsHelper(getAndroidDriver());
        rewardsHelper.superCashHistory("Earned Supercash");

        Log.info("======= END : Check Supercash History Test =======");

    }

    @Test(groups = {"sanity1", "spinthewheel", "regression", "test"}, priority = 0, description = "Check voucher history")
    public void Test_Rewards_VoucherHistory() throws IOException, InterruptedException {

        Log.info("======= START : Check Voucher History Test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");
        //loginHelper.quickLoginViaOtp("9953138474", "");

        // Execute the test
        RewardsHelper rewardsHelper = new RewardsHelper(getAndroidDriver());
        rewardsHelper.voucherHistory("Active Voucher");

        Log.info("======= END : Check Voucher Test =======");

    }

}
