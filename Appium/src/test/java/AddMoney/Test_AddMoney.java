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
    String userName = "ashishkumarpradhan";

    @Parameters({"deviceID","userName"})
    @Test(groups = {"addMoney", "sanity"}, priority = 0,description = "Stand Alone Add money Testing from home page via Saved Card")
    public void Test02_addmoney_via_Savedcard(@Optional String deviceID, @Optional String userName) throws IOException, InterruptedException {

        if (deviceID == null) {
            deviceID = this.deviceID;
        }
        if (userName == null) {
            userName = this.userName;
        }
        Log.info(deviceID);
        Log.info(userName);

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        AddMoneyHelper addMoneyHelper= new AddMoneyHelper(getAndroidDriver());
       addMoneyHelper.addMoneyViaCard("5", "068","You Added","to your wallet","₹5","Add money","+ ₹5", "Success", deviceID , userName);

    }

}


