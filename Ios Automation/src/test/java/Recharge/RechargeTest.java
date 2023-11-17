package Recharge;

import Helpers.LoginHelper;
import Helpers.RechargeHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class RechargeTest extends TestBase {

    @Test(groups = {"prepaidRechargeFlow"}, priority = 0, description = "Verify Prepaid recharge Flow on Ios app")

    public void Test_Prepaid_Recharge_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("8076595767", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Prepaid Recharge Flow test =======");

        RechargeHelper rechargeHelper = new RechargeHelper(getIosDriver());
        rechargeHelper.prepaidRecharge();

        Log.info("======= END : Prepaid Recharge Flow test =======");

    }
}
