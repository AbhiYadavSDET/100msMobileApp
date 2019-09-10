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


}