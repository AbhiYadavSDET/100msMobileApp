import Helpers.GasHelper;
import Helpers.LoginHelper;
import Utils.Config;
import Utils.Excel;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class BillViewGas extends TestBase {

    @Test(groups = {"gasFlow"}, priority = 0, description = "Verify gas bill Flow on android app")
    public void Test_Gas_Bill_Flow() throws InterruptedException, IOException {
        // Start the test
        for(int i=1;i<=2;i++) {
            String[] data = Excel.readData(i,"Gas");
//            String[] excelData = data.split(" split ");

            GasHelper gasHelper = new GasHelper(initiateTest());
            gasHelper.viewGasBill(data[0], data[1]);
        }

    }

}
