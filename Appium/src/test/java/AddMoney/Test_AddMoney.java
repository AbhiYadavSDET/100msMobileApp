package AddMoney;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import org.testng.annotations.Test;
import utils.ExtentReport;
import utils.TestBase;

import java.io.IOException;

public class Test_AddMoney extends TestBase {

    @Test(groups = {"addMoneyStandAloneViaNewCard", "addMoneySanity"}, priority = 0,description = "Stand Alone Add money Testing from home page via New Card")
    public void Test01_addmoney_via_Savedcard() throws IOException, InterruptedException {

        ExtentReport.EXTENTREPORT.createTest("Verify Add Money Flow");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        AddMoneyHelper addMoneyHelper= new AddMoneyHelper(getAndroidDriver());
        addMoneyHelper.addMoneyViaCard(false, "5", "4389760052036060", "06/29", "068", "Payment Successful", "Money added into your wallet successfully");

    }

    @Test(groups = {"addMoneyStandAloneViaSavedCard", "addMoneySanity"}, priority = 1,description = "Stand Alone Add money Testing from home page via Saved Card")
    public void Test02_addmoney_via_Savedcard() throws IOException, InterruptedException {

        ExtentReport.EXTENTREPORT.createTest("Verify Add Money Flow");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        AddMoneyHelper addMoneyHelper= new AddMoneyHelper(getAndroidDriver());
        addMoneyHelper.addMoneyViaCard(true, "5", "4389760052036060", "06/29", "068", "Payment Successful", "Money added into your wallet successfully");

    }

}


