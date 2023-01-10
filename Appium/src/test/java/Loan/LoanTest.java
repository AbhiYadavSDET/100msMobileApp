package Loan;

import Helpers.LoanHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoanTest extends TestBase {


    @Test(groups = {"sanity", "verifyLoanPage"}, priority = 0, description = "Wallet To Wallet transfer")
    public void Test01_verifyLoanPage() throws IOException, InterruptedException {

        Log.info("======= START : Loan Verify test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        LoanHelper loanHelper = new LoanHelper(getAndroidDriver());
        loanHelper.verifyLoan("Get offer upto ₹2,00,000 and pay in easy EMIs", "Get started");

        Log.info("======= END : Loan Verify test =======");


    }
}
