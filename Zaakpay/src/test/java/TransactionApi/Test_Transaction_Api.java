package TransactionApi;

import Helpers.TransactionApiHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class Test_Transaction_Api extends TestBase {


    @Test(groups = {"transactionSanity"}, description = "Verify Transaction Flow via Debit Card")
    public void Test_Transaction_Via_Debit_Card() {

        TransactionApiHelper transactionApiHelper = new TransactionApiHelper(driver);
        transactionApiHelper.transactionViaDebitCard("mayank.suneja@gmail.com", "5");
    }


}
