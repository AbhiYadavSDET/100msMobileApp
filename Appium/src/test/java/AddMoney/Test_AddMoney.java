package AddMoney;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import org.testng.annotations.Test;
import Utils.ExtentReport;
import Utils.TestBase;

import java.io.IOException;

public class Test_AddMoney extends TestBase {

    @Test(groups = {"addMoney", "Sanity"}, priority = 1,description = "Stand Alone Add money Testing from home page via Saved Card")
    public void Test02_addmoney_via_Savedcard() throws IOException, InterruptedException {


        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        AddMoneyHelper addMoneyHelper= new AddMoneyHelper(getAndroidDriver());
       addMoneyHelper.addMoneyViaCard("5", "068","You Added","to your wallet","₹5","Add money","+ ₹5", "Success");

    }

}


