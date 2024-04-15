package Upi;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Helpers.UpiHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;


public class Test_Upi extends TestBase {


    @Test(groups = {"upiSendMoney", "upiSanity", "sanity"}, priority = 0, description = "UPI Send Money to UPI ID test")
    public void Test01_Upi_Send_Money_To_VPA() throws IOException, InterruptedException {

        Log.info("======= START : UPI Send Money to UPI ID test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyViaUpi("7795709569@paytm", "1", "Automation Transfer to VPA", "Paraj Jain", "121212","Paraj Jain" );

    }

    @Test(groups = {"upiSendMoneyToBank", "upiSanity", "sanity"}, priority = 0, description = "UPI Send Money to Bank test")
    public void Test02_Upi_Send_Money_To_Bank() throws IOException, InterruptedException {

        Log.info("======= START : UPI Send Money to Bank test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyToBankViaUpi("Paraj Jain", "218101502680", "ICIC0002181", "1", "Automation Transfer to Bank Account", "Paraj Jain", "121212", "Paraj Jain");

    }

    @Test(groups = {"upiCheckBalance", "upiSanity", "sanity"}, priority = 0, description = "UPI Check Account Balance test")
    public void Test03_Upi_Check_Balance() throws IOException, InterruptedException {

        Log.info("======= START : UPI Check Account Balance test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.checkAccountBalance("121212");

    }


    @Test(groups = {"upiRequestMoney", "upiSanity", "sanity"}, priority = 0, description = "UPI Request Money test")
    public void Test04_Upi_Request_Money() throws IOException, InterruptedException {

        Log.info("======= START : UPI Request Money test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.requestMoneyViaUpi("9205299330@paytm", "1", "Automation Request Money Flow", "Ashwani Garg", "Ashwani Garg");

    }




    @Test(groups = {"addMoneyViaUpi", "upiSanity", "sanity"}, priority = 0, description = "Add Money via UPI test")
    public void Test05_Upi_Add_Money() throws IOException, InterruptedException {

        Log.info("======= START : Add Money via UPI test =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");


        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addMoneyHelper.addMoneyViaUPI("5", "You Added","to your wallet","₹5", "Add Money via UPI", "+₹5", "Success", "121212" );

    }

    @Test(groups = {"upiViewQr", "upiSanity"}, priority = 0, description = "View UPI QR test")
    public void Test06_View_UPI_QR() throws IOException, InterruptedException {

        Log.info("======= START : View UPI QR test=======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.viewUPIQR();
    }

    @Test(groups = {"upiViewQr", "upiSanity"}, priority = 0, description = "View Pocket UPI QR test")
    public void Test07_View_Pocket_UPI_QR() throws IOException, InterruptedException {

        Log.info("======= START : View Pocket UPI QR test=======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.viewPocketUPIQR();
    }

    @Test(groups = {"upiSendMoney", "upiSanity"}, priority = 0, description = "UPI Send Money to Contact")
    public void Test08_Upi_Send_Money_To_Contact() throws IOException, InterruptedException {

        Log.info("======= START : UPI Send Money to Contact =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyViaContact( "1", "Automation Transfer to Contact", "Paraj Jain", "121212","Paraj Jain" );

    }

    @Test(groups = {"pocketUpi", "upiSanity", "sanity"}, priority = 0, description = "Pocket UPI Send Money via pocketUpi")
    public void Test09_Upi_Send_Money_Via_PocketUpi() throws IOException, InterruptedException {

        Log.info("======= START : Pocket UPI Send Money via pocketUpi =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.pocketUPITransferNow("1", "Automation Transfer via Pocket UPI", "Paraj Jain","7795709569@paytm", "Paraj Jain");
    }

    @Test(groups = {"pocketUpi", "upiSanity"}, priority = 0, description = "Pocket UPI Show My QR from Pocket UPI Home Page")
    public void Test10_Upi_PocketUpi_Show_My_QR() throws IOException, InterruptedException {

        Log.info("======= START : Pocket UPI Show My QR from Pocket UPI Home Page =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.pocketUPIHomePageShowMyQrCode();
    }

    @Test(groups = {"manageUpi", "upiSanity"}, priority = 0, description = "Manage UPI Section")
    public void Test11_Manage_UPI() throws IOException, InterruptedException {

        Log.info("======= START : Manage UPI Section =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.manageUpi();
    }

    @Test(groups = {"manageUpi", "upiSanity", "sanity"}, priority = 0, description = "Add New Bank account and Credit Card flow")
    public void Test12_Add_Account_CreditCard() throws IOException, InterruptedException {

        Log.info("======= START : Add New Bank account and Credit Card flow =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.addNewBankAccountAndCreditCard();
    }

    @Test(groups = {"numberMapper", "upiSanity", "sanity"}, priority = 0, description = "Validate Manage UPI Number")
    public void Test13_Manage_Upi_Number() throws IOException, InterruptedException {

        Log.info("======= START : Validate Manage UPI Number =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.manageUpiNumber();
    }





    @Test(groups = {"deregisterUpi", "upiSanity"}, priority = 0, description = "Validate Deregister UPI till confirmation")
    public void Test14_Upi_Deregister() throws IOException, InterruptedException {

        Log.info("======= START : Validate Deregister UPI till confirmation =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.deregisterUpi();
    }





    @Test(groups = {"upiSanity","PocketUPIScanQRTxn","sanity"}, priority = 0, description = "Validate SonuQR txn via Pocket UPI ")
    public void Test15_PocketUpi_SonuQR() throws IOException, InterruptedException {

        Log.info("======= START : P2M flow Sonu QR =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.pocketUPISonuQRTxn("1","Sonu Kumar","Direct Txn");

        Log.info("======= END : P2M flow Sonu QR =======");


    }


    @Test(groups = {"upiSanity", "RecentMerchantSonu","sanity"}, priority = 0, description = "Validate Recent Merchant Txn ")
    public void Test16_RecentMerchant_PocketUPI_Sonu() throws IOException, InterruptedException {

        Log.info("======= START : P2M Recent Merchant Txn =======");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtpAutoRead("9205299330", "547372");

        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.pocketUPISonuQRTxn("1","Sonu Kumar","RecentMerchant");

        Log.info("======= END : P2M Recent Merchant Txn  =======");


    }




}

