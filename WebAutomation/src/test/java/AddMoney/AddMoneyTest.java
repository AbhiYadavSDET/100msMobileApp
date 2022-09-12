package AddMoney;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddMoneyTest extends TestBase {



    @Test(groups = {"addMoneySanity"}, priority = 1, description = "Verify Add Money via New Card")
    public void Test_AddMoney_Newcard() throws InterruptedException, IOException {

        LoginHelper loginHelper = new LoginHelper(getWebDriver());
        loginHelper.loginViaOtp("9205299330" ,"mobi testu", "mkwik9330@gmail.com", "9205299330");

        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
        addMoneyHelper.addMoneyViaNewcard("5", "4389760052036060","06","2029", "068", "", "Money Added Successfully");
    }

//    @Test(groups = {"addMoneySanity"}, priority = 2, description = "Verify Add Money via Saved Card")
//    public void Test_AddMoney_SavedCard() throws InterruptedException, IOException {
//
//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9205299330" ,"mobi testu", "mkwik9330@gmail.com", "9205299330");
//
//        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
//        addMoneyHelper.addMoneyViaSavedcard("5", "239", "Paraj@1234", "Money Added Successfully", false, "ADDTST5M", "You will get ₹ 1.0 SuperCash");
//    }

//    @Test(groups = {"addMoneySanity"}, priority = 3, description = "Verify Add Money via Saved Card with Coupon Code")
//    public void Test_AddMoney_SavedCard_with_coupon() throws InterruptedException, IOException {
//
//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9205299330" ,"mobi testu", "mkwik9330@gmail.com", "9205299330");
//
//        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
//        addMoneyHelper.addMoneyViaSavedcard("90", "239", "Paraj@1234", "Money Added Successfully", true, "ADDTST5M", "You will get ₹ 1.0 SuperCash");
//    }


}
