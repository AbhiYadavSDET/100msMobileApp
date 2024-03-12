package Upi;

import Helpers.LoginHelper;
import Helpers.UpiHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;


public class Test_Upi extends TestBase {


    @Test(groups = {"upiSendMoney", "upiSanity"}, priority = 0, description = "UPI Send Money to UPI ID test")
    public void Test01_Upi_Send_Money_to_VPA() throws IOException, InterruptedException {

        Log.info("======= START : UPI Send Money to UPI ID test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyViaUpi("7795709569@paytm", "1", "Automation Transfer to VPA", "Paraj Jain", "121212","Paraj Jain" );

    }

    @Test(groups = {"upiSendMoneyToBank", "upiSanity"}, priority = 0, description = "UPI Send Money to Bank test")
    public void Upi_Send_Money_To_Bank() throws IOException, InterruptedException {

        Log.info("======= START : UPI Send Money to Bank test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyToBankViaUpi("Paraj Jain", "218101502680", "ICIC0002181", "1", "Automation Transfer to Bank Account", "Paraj Jain", "121212", "Paraj Jain");

    }

    @Test(groups = {"upiCheckBalance", "upiSanity"}, priority = 0, description = "UPI Check Account Balance test")
    public void Upi_Check_Balance() throws IOException, InterruptedException {

        Log.info("======= START : UPI Check Account Balance test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.checkAccountBalance("121212");

    }


    @Test(groups = {"upiRequestMoney", "upiSanity"}, priority = 0, description = "UPI Request Money test")
    public void Upi_Request_Money() throws IOException, InterruptedException {

        Log.info("======= START : UPI Request Money test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.requestMoneyViaUpi("9205299330@paytm", "1", "Automation Request Money Flow", "Ashwani Garg", "Ashwani Garg");

    }



//
//    @Test(groups = {"addMoneyViaUpi", "upiSanity"}, priority = 0, description = "Add Money via UPI test")
//    public void Upi_Add_Money() throws IOException, InterruptedException {
//
//        Log.info("======= START : Add Money via UPI test =======");
//
//        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaOtp("9205299330", "547372");
//
//
//        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
//        upiHelper.addMoneyViaUpi("121212", "5", "Payment Successful", "Money added into your wallet successfully");
//
//    }
//
//    @Test(groups = {"deregisterUpi"}, priority = 0, description = "Deregister UPI test")
//    public void Upi_Deregister() throws IOException, InterruptedException {
//
//        Log.info("======= START : Deregister UPI test =======");
//
//        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaOtp("9205299330", "547372");
//
//
//        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
//        upiHelper.deregisterUpi();
//    }
//
//    @Test(groups = {"registerUpi"}, priority = 0, description = "Register UPI test")
//    public void Upi_register() throws IOException, InterruptedException {
//
//        Log.info("======= START : Register UPI test =======");
//
//        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaOtp("8216", "547372");
//
//
//        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
//        upiHelper.registerUpi("Kotak");
//    }

}

