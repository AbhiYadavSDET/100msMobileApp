package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.AddMoneyHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

public class Test_AddMoney extends CreateSession {

    @Test(groups = {"addMoneyNetBankingICICI", "addMoneyNetBanking"}, priority = 0, description = "Add Money via Netbanking ICICI")
    public void addMoneyNetBankingICICI() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginViaEmail(3);

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.netbanking(1);
    }

    @Test(groups = {"addMoneyNetBankingHDFC", "addMoneyNetBanking"}, priority = 1, description = "Add Money via Netbanking HDFC")
    public void addMoneyNetBankingHDFC() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginViaEmail(3);

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.netbanking(2);
    }


    @Test(groups = {"addMoneyNetBankingCITI", "addMoneyNetBanking"}, priority = 2, description = "Add Money via Netbanking CITI")
    public void addMoneyNetBankingCITI() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginViaEmail(3);

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.netbanking(3);
    }


    @Test(groups = {"addMoneyNetBankingAXIS", "addMoneyNetBanking"}, priority = 3, description = "Add Money via Netbanking AXIS")
    public void addMoneyNetBankingAXIS() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginViaEmail(3);

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.netbanking(4);
    }


}
