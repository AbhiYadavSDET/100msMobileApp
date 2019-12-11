package BankTransferFlow;

import Helpers.BankTransferHelper;
import Helpers.LoginHelper;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankTransferTest extends TestBase {


    @Test(groups = {"bankTransferFlow"}, priority = 0, description = "Verify Bank Transfer Flow on Web")
    public void Test_Bank_Transfer_Flow() throws InterruptedException, IOException {
        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Test_Bank_Transfer_Flow");


        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9953138474", "Ashwani Garg", "ashwani.garg@mobikwik.com", "9953138474");


        BankTransferHelper bankTransferHelper = new BankTransferHelper(getWebDriver());
        bankTransferHelper.bankTransfer("Ashwani Garg", "07281610015491", "HDFC0000728", "50", "Money sent successfully");


    }


}
