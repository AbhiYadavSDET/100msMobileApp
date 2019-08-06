package AddMoney;

import Helpers.AddMoneyHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class AddMoneyTest extends TestBase {


    @Test(groups = {"addMoneySanity"}, priority = 0, description = "Verify Add Money via Netbanking")
    public void Test_AddMoney_Netbanking() throws InterruptedException {

//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
        addMoneyHelper.addMoneyViaNetBanking("5", AddMoneyHelper.BankName.ICICI, "https://shopping.icicibank.com/corp/BANKAWAY");
        addMoneyHelper.addMoneyViaNetBanking("5", AddMoneyHelper.BankName.HDFC, "https://netbanking.hdfcbank.com/netbanking/merchant");
        addMoneyHelper.addMoneyViaNetBanking("5", AddMoneyHelper.BankName.CITI, "https://www.citibank.co.in/servlets/TransReq");
        addMoneyHelper.addMoneyViaNetBanking("5", AddMoneyHelper.BankName.AXIS, "https://retail.axisbank.co.in/wps/portal/rBanking/AxisSMRetailLogin/axissmretailpage?AuthenticationFG.MENU_ID=CIMSHP&AuthenticationFG.CALL_MODE=2&CATEGORY_ID=IRZAAK");


    }

    @Test(groups = {"addMoneySanity"}, priority = 1, description = "Verify Add Money via New Card")
    public void Test_AddMoney_Newcard() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
        addMoneyHelper.addMoneyViaNewcard("5", "4363931800224460", "239", "Paraj@1234", "Money Added Successfully");
    }

    @Test(groups = {"addMoneySanity"}, priority = 2, description = "Verify Add Money via Saved Card")
    public void Test_AddMoney_SavedCard() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
        addMoneyHelper.addMoneyViaSavedcard("5", "239", "Paraj@1234", "Money Added Successfully", false, "ADDTST5M", "You will get ₹ 1.0 SuperCash");
    }

    @Test(groups = {"addMoneySanity"}, priority = 3, description = "Verify Add Money via Saved Card with Coupon Code")
    public void Test_AddMoney_SavedCard_with_coupon() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
        addMoneyHelper.addMoneyViaSavedcard("80", "239", "Paraj@1234", "Money Added Successfully", true, "ADDTST5M", "You will get ₹ 1.0 SuperCash");
    }


}
