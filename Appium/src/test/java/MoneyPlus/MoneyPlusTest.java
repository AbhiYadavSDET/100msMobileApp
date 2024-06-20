package MoneyPlus;

import Helpers.LoginHelper;
import Helpers.MoneyPlusHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class MoneyPlusTest extends TestBase {


    @Test(groups = {"sanity", "verifyMoneyPlusPage", "regression"}, priority = 0, description = "Verify Money Plus Page")
    public void Test_MoneyPlusFlow() throws IOException, InterruptedException {

        Log.info("======= START : Money Plus Verify test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        // Execute the test
        MoneyPlusHelper moneyPlusHelper= new MoneyPlusHelper(getAndroidDriver());
        moneyPlusHelper.verifyMoneyPlusFlow("Track your bank accounts with 100% accuracy","Watch your money grow", "Get Started", "Track your Employee Provident Fund");

        Log.info("======= END : Money Plus Verify test =======");

    }


}
