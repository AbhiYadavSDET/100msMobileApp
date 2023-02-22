package CCBP;

import Helpers.CCBPHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class CCBPTest extends TestBase {

    @Test(groups = {"sanity", "ccbp Payment"}, priority = 1, description = "ccbp Payment")

    public void creditCardBill_Payment() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Credit Card Bill Payment =======");

        // Execute the test
        CCBPHelper ccbpHelper  = new CCBPHelper(getAndroidDriver());
        ccbpHelper.creditCardBillPayment("100", "₹100", "4375517199762008","Payment Successful", "for Credit Card XXXXXXXXXXXX2008", "₹100","Credit Card Bill Payment", "Success","₹101.18");

        Log.info("======= END : Credit card bill Payment =======");
    }

    @Test(groups = {"sanity", "ccbp Payment"}, priority = 0, description = "existing user ccbp Payment")

    public void existingUserCreditCardBill_Payment() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Existing user Credit Card Bill Payment Flow =======");

        // Execute the test
        CCBPHelper ccbpHelper  = new CCBPHelper(getAndroidDriver());
        ccbpHelper.existingUserCCBP("100", "₹100","CCPAY Applied!" ,"4375517199762008","Payment Successful", "for Credit Card XXXXXXXXXXXX2008", "₹100","Credit Card Bill Payment", "Success","₹101.18");

        Log.info("======= END : Existing User Credit card bill Payment Flow=======");
    }



}
