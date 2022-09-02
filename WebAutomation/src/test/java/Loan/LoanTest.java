package Loan;


import Helpers.LoanHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoanTest extends TestBase{


    @Test(groups = {"loanSanity"}, priority = 1, description = "Verify loan page")
    public void Test_Loan () throws InterruptedException, IOException {

        LoanHelper loanHelper = new LoanHelper(getWebDriver());
        loanHelper.loanHelper();

    }
}
