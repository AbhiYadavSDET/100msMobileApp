package Loan;

import Helpers.AddMoneyHelper;
import Helpers.LoanHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utils.TestBase.getWebDriver;

public class LoanTest extends TestBase{


    @Test(groups = {"addMoneySanity"}, priority = 1, description = "Verify Add Money via New Card")
    public void Test_Loan () throws InterruptedException, IOException {

        LoanHelper loanHelper = new LoanHelper(getWebDriver());
        loanHelper.loanHelper();

    }
}
