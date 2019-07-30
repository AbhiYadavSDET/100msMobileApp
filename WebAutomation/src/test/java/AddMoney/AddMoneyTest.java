package AddMoney;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class AddMoneyTest extends TestBase {


    @Test(groups = {"addMoneySanity"}, priority = 0, description = "Verify Add Money via Netbanking")
    public void Test_AddMoney_Netbanking() throws InterruptedException {

        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(driver);
        addMoneyHelper.addMoneyViaNetBanking("5", AddMoneyHelper.BankName.ICICI, "https://shopping.icicibank.com/corp/BANKAWAY");
        addMoneyHelper.addMoneyViaNetBanking("5", AddMoneyHelper.BankName.HDFC, "https://netbanking.hdfcbank.com/netbanking/merchant");
        addMoneyHelper.addMoneyViaNetBanking("5", AddMoneyHelper.BankName.CITI, "https://www.citibank.co.in/servlets/TransReq");
        addMoneyHelper.addMoneyViaNetBanking("5", AddMoneyHelper.BankName.AXIS, "https://retail.axisbank.co.in/wps/portal/rBanking/AxisSMRetailLogin/axissmretailpage?AuthenticationFG.MENU_ID=CIMSHP&AuthenticationFG.CALL_MODE=2&CATEGORY_ID=IRZAAK");


    }


}
