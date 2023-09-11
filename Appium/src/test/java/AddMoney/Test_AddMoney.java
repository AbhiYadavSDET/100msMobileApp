package AddMoney;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utils.ExtentReport;
import Utils.TestBase;

import java.io.IOException;

public class Test_AddMoney extends TestBase {

    String deviceID = "0";

    @Parameters({"deviceID"})
    @Test(groups = {"addMoney", "sanity", "regression"}, priority = 0,description = "Stand Alone Add money Testing from home page via Saved Card")
    public void Test02_addmoney_via_Savedcard(@Optional String deviceID) throws IOException, InterruptedException {

        if (deviceID == null) {
            deviceID = this.deviceID;
        }
        Log.info(deviceID);

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        AddMoneyHelper addMoneyHelper= new AddMoneyHelper(getAndroidDriver());
       addMoneyHelper.addMoneyViaCard("15", "068","You Added","to your wallet","₹15","Add money","+ ₹15", "Success", deviceID );

    }

}


