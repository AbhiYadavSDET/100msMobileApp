import Helpers.GasHelper;
import Helpers.RechargeHelper;
import Utils.Excel;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class BillViewRecharge extends TestBase {

    @Test(groups = {"rechargeFlow"}, priority = 0, description = "Verify mobile bill Flow on android app")
    public void Test_Recharge_Bill_Flow() throws InterruptedException, IOException {
        // Start the test
//        int j=1;
//        for(int i=1;i<=j;i++) {
//            String data = Excel.readData(i, "Gas");
//            String[] excelData = data.split(" split ");
            RechargeHelper rechargeHelper = new RechargeHelper(initiateTest());
            rechargeHelper.viewRechargeBill("9818484290", "VI", "Delhi NCR", "100","112233");
//        }
    }

}
