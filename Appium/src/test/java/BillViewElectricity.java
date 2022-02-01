import Helpers.ElectricityHelper;
import Helpers.GasHelper;
import Utils.Excel;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class BillViewElectricity extends TestBase {

    @Test(groups = {"electricityFlow"}, priority = 0, description = "Verify electricity bill Flow on android app")
    public void Test_Gas_Bill_Flow() throws InterruptedException, IOException {
        // Start the test
        for(int i=1;i<=2;i++) {
            String[] data = Excel.readData(i,"Electricity");
//            String[] excelData = data.split(" split ");

            ElectricityHelper electricityHelper = new ElectricityHelper(initiateTest());
            electricityHelper.viewElectricityBill(data[0], data[1]);
        }

    }

}
