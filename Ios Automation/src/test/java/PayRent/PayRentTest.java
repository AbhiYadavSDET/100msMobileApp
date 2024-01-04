package PayRent;

import Helpers.LoginHelper;
import Helpers.P2PExtraHelper;
import Helpers.PayRentHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class PayRentTest extends TestBase {

   @Test(groups = {"payRentFlow","payRentOldUserFlow", "regression"}, priority = 0, description = "Verify Add new property on pay rent for Existing user")
    public void Test_PayRent_Add_New_Property_Old_User() throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Add new property flow for old User =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.addNewPropertyOldUser("135701525113","ICIC0001437","Abhishek Yadav","5500");

        Log.info("======= END : Pay rent - Add new property flow for old User =======");

    }

  @Test(groups = {"payRentFlow","payRentNewUserFlow", "regression"}, priority = 1, description = "Verify Add new property on pay rent for new user")
    public void Test_PayRent_Add_New_Property_New_User() throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Add new property flow for new User =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.addNewPropertyNewUser("135701525113","ICIC0001437","Abhishek Yadav","5500");

        Log.info("======= END : Pay rent - Add new property flow for new User =======");

    }
   @Test(groups = {"payRentFlow","payRentWithPanCardFlow","regression"}, priority = 2, description = "Verify Add new property on pay rent with pan card entered")
    public void Test_PayRent_Add_New_Property_WithPanCard() throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Verify Pan card option on rent pay =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.addNewPropertyNewUserWithPan("135701525113","ICIC0001437","Abhishek Yadav","55000","HTIPK1234M");

        Log.info("======= END : Pay rent - Verify Pan card option on rent pay =======");

    }

    @Test(groups = {"payRentFlow","payRentWithCouponCodeFlow","regression"}, priority = 3, description = "Verify Add new property on pay rent with coupon code")
    public void Test_PayRent_Add_New_Property_With_Coupon_Code () throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Verify Coupon code option on rent pay =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.addNewPropertyNewUserWithCouponCode("135701525113","ICIC0001437","Abhishek Yadav","5000","HTIPK1234M");

        Log.info("======= END : Pay rent - Verify Coupon code option on rent pay =======");

    }

    @Test(groups = {"payRentFlow","faqButtonOnPayRent","regression"}, priority = 4, description = "Verify faq button on rent pay")
    public void Test_PayRent_FAQ () throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Verify FAQ option on rent pay =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.faqOnRentPay();

        Log.info("======= END : Pay rent - Verify FAQ option on rent pay =======");

    }


}
