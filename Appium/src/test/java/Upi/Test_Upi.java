package Upi;
/*
import Helpers.LoginHelper;
import Helpers.UpiHelper;
import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test_Upi extends CreateSession {

    @Test(groups = {"deregisterUpi", "upiSanity"}, priority = 0)
    public void Upi_Deregister() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.deregisterUpi();
    }

    @Test(groups = {"registerUpi", "upiSanity"}, priority = 1)
    public void Upi_register() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.registerUpi("Kotak");
    }


    @Test(groups = {"upiSendMoney", "upiSanity"}, priority = 2)
    public void Upi_Send_Money() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyViaUpi("paraj@ikwik", "1", "Test", "121212");

    }

    @Test(groups = {"upiSendMoneyToBank", "upiSanity"}, priority = 3)
    public void Upi_Send_Money_To_Bank() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.sendMoneyToBankViaUpi("Paraj Jain", "218101502680", "ICIC0002181", "1", "Test", "121212");

    }

    @Test(groups = {"upiRequestMoney", "upiSanity"}, priority = 4)
    public void Upi_Request_Money() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.requestMoneyViaUpi("paraj@ikwik", "1", "Test");

    }

    @Test(groups = {"upiCheckBalance", "upiSanity"}, priority = 5)
    public void Upi_Check_Balance() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.checkAccountBalance("121212");

    }

    //Payment Successful
    //Money added into your wallet successfully

    @Test(groups = {"addMoneyViaUpi", "upiSanity"}, priority = 6)
    public void Upi_Add_Money() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");


        UpiHelper upiHelper = new UpiHelper(getAndroidDriver());
        upiHelper.addMoneyViaUpi("121212", "6", "Payment Successful", "Money added into your wallet successfully");

    }

}

 */