package TransactionHistory;

import Helpers.AddMoneyHelper;
import Helpers.LoanHelper;
import Helpers.LoginHelper;
import Helpers.TransactionHistoryHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utils.TestBase.getWebDriver;

public class TransactionHistoryTest extends TestBase {

    @Test(groups = {"transactionHistorySanity"}, priority = 1, description = "Verify Transaction History")
    public void Test_Transaction_History() throws InterruptedException, IOException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9149237812", "Sumit Chauhan", "sumitch853@gmail.com", "9149237812");

        TransactionHistoryHelper transactionHistoryHelper = new TransactionHistoryHelper(getWebDriver());
        transactionHistoryHelper.transactionHistoryHelper();
    }
}
