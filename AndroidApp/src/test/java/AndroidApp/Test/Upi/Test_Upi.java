package test.java.AndroidApp.Test.Upi;

import UITestFramework.CreateSession;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.UpiHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;


public class Test_Upi extends CreateSession {


    @Test(groups = {"upiSendMoney", "upiSanity"}, priority = 0)
    public void Upi_Send_Money() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper= new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyViaUpi("paraj@ikwik", "1", "Test", "121212");

    }

    @Test(groups = {"upiSendMoneyToBank", "upiSanity"}, priority = 0)
    public void Upi_Send_Money_To_Bank() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper= new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyToBankViaUpi("Paraj Jain", "218101502680", "ICIC0002181","1", "Test", "121212");

    }

    @Test(groups = {"upiRequestMoney", "upiSanity"}, priority = 0)
    public void Upi_Request_Money() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper= new UpiHelper(getAndroidDriver());
        upiHelper.requestMoneyViaUpi("paraj@ikwik", "1", "Test");

    }

    @Test(groups = {"upiCheckBalance", "upiSanity"}, priority = 0)
    public void Upi_Check_Balance() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper= new UpiHelper(getAndroidDriver());
        upiHelper.checkAccountBalance("121212");

    }

    //Payment Successful
    //Money added into your wallet successfully

    @Test(groups = {"addMoneyViaUpi", "upiSanity"}, priority = 0)
    public void Upi_Add_Money() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper= new UpiHelper(getAndroidDriver());
        upiHelper.addMoneyViaUpi("121212", "5", "Payment Successful", "Money added into your wallet successfully");

    }

    @Test(groups = {"deregisterUpi", "upiSanity"}, priority = 0)
    public void Upi_Deregister() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper= new UpiHelper(getAndroidDriver());
        upiHelper.deregisterUpi();
    }


}