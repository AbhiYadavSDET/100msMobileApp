package MyWallet;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Helpers.MyWalletHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyWalletTest extends TestBase {



    @Test(groups = {"myWallet"}, priority = 1, description = "Verify my wallet flow")
    public void Test_myWallet() throws InterruptedException, IOException {

        LoginHelper loginHelper = new LoginHelper(getWebDriver());
        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        MyWalletHelper myWalletHelper = new MyWalletHelper(getWebDriver());
        myWalletHelper.myWalletDetails();
    }

}
