package Loan;

import Helpers.AddMoneyHelper;
import Helpers.LoanHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utils.TestBase.getWebDriver;

public class LoanTest extends TestBase{


    @Test(groups = {"loanSanity"}, priority = 1, description = "Verify loan page")
    public void Test_Loan () throws InterruptedException, IOException {

        LoanHelper loanHelper = new LoanHelper(getWebDriver());
        loanHelper.loanHelper();

    }
}
