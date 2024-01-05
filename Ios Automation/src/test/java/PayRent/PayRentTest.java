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
    public void Test_PayRent_Add_New_Property() throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Add new property flow for old User =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.addNewPropertyOnPayRent("135701525110","ICIC0001437","Abhishek Yadav","5500");

        Log.info("======= END : Pay rent - Add new property flow for old User =======");
    }

 @Test(groups = {"payRentFlow","payRentNewUserFlow", "regression"}, priority = 0, description = "Verify Add new property on pay rent for new user")
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
  @Test(groups = {"payRentFlow","payRentWithPanCardFlow","regression"}, priority = 0, description = "Verify Add new property on pay rent with pan card entered")
    public void Test_PayRent_Add_New_Property_WithPanCard() throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Verify Pan card option on rent pay =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.addNewPropertyNewUserWithPan("135701525113","ICIC0001437","Abhishek Yadav","55000","FSMPP7878E");

        Log.info("======= END : Pay rent - Verify Pan card option on rent pay =======");

    }

    @Test(groups = {"payRentFlow","payRentWithCouponCodeFlow","regression"}, priority = 0, description = "Verify Add new property on pay rent with coupon code")
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

   @Test(groups = {"payRentFlow","faqButtonOnPayRent","regression"}, priority = 0, description = "Verify faq button on rent pay")
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

   @Test(groups = {"payRentFlow","deletOnPayRent","regression"}, priority = 0, description = "Verify Delete button on rent pay")
    public void Test_PayRent_Delete_Recipient () throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Verify Delete option on rent pay =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.deleteRecipientOnRentPay();

        Log.info("======= END : Pay rent - Verify Delete option on rent pay =======");

    }

    @Test(groups = {"payRentFlow","deletOnPayRent","regression"}, priority = 0, description = "Verify Conv fee calculation  on rent pay")
    public void Test_PayRent_ConvFee () throws InterruptedException, IOException {

        Log.info("======= START : Pay rent - Verify Conv fee calculation  on rent pay =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        PayRentHelper payRentHelper = new PayRentHelper(getIosDriver());
        payRentHelper.verifyConvFeeOnPayRent("135701525113","ICIC0001437","Abhishek Yadav","5000");

        Log.info("======= END : Verify Conv fee calculation  on rent pay=======");

    }



}