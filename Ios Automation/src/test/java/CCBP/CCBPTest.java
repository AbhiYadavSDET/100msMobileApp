package CCBP;

import Helpers.CCBPHelper;
import Helpers.LoginHelper;
import Helpers.RechargeHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class CCBPTest extends TestBase {

    @Test(groups = {"CreditCardPayment"}, priority = 0, description = "Verify credit card payment")

    public void Test_CreditCardPayment_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("8076595767", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Credit Card Payment Flow test =======");

        CCBPHelper ccbpHelper = new CCBPHelper(getIosDriver());
        ccbpHelper.creditCardPayment("4375517199762008","100","₹100","ICICI BANK LTD","4375 5171 9976 2008");

        Log.info("======= END : Credit Card Payment Flow test =======");

    }


}
