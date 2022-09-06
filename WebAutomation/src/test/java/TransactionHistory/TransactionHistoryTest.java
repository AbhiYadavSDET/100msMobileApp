package TransactionHistory;

import Helpers.LoginHelper;
import Helpers.TransactionHistoryHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class TransactionHistoryTest extends TestBase {

    @Test(groups = {"transactionHistorySanity"}, priority = 1, description = "Verify Transaction History")
    public void Test_Transaction_History() throws InterruptedException, IOException {
//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        TransactionHistoryHelper transactionHistoryHelper = new TransactionHistoryHelper(getWebDriver());
        transactionHistoryHelper.transactionHistoryHelper();
    }
}
