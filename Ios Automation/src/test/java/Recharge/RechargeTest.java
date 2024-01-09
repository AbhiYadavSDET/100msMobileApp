package Recharge;

import Helpers.LoginHelper;
import Helpers.RechargeHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class RechargeTest extends TestBase {

    @Test(groups = {"RechargeFlow"}, priority = 1, description = "Verify Prepaid recharge Flow on Ios app")

    public void Test_Prepaid_Recharge_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Prepaid Recharge Flow test =======");

        RechargeHelper rechargeHelper = new RechargeHelper(getIosDriver());
        rechargeHelper.prepaidRecharge("10","₹10", "Payment Successful","₹10");

        Log.info("======= END : Prepaid Recharge Flow test =======");

    }

    @Test(groups = {"RechargeFlow", "regression"}, priority = 2, description = "Verify postpaid recharge Flow on Ios app")

    public void Test_Postpaid_Recharge_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Postpaid Recharge Flow test =======");

        RechargeHelper rechargeHelper = new RechargeHelper(getIosDriver());
        rechargeHelper.postpaidRecharge("9311878235","1","₹1","Payment Successful","₹1");

        Log.info("======= END : Postpaid Recharge Flow test =======");

    }

    @Test(groups = {"RechargeFlow", "regression"}, priority = 0, description = "Verify change operator flow")

    public void Test_Change_Operator_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Change Operator Flow test =======");

        RechargeHelper rechargeHelper = new RechargeHelper(getIosDriver());
        rechargeHelper.changeOperator("Delhi","Reliance Prepaid", "Delhi NCR");

        Log.info("======= END : Change Operator Flow test =======");

    }
}
