package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.WalletPageHelper;


import java.io.IOException;

public class Test_Kyc extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @Test(groups = {"noKycCheck", "kycSanity"}, priority = 0)
    public void No_kyc_check() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getIOSDriver());
        loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        WalletPageHelper walletPageHelper = new WalletPageHelper(driver);
        walletPageHelper.checkIfNoKycUser();

    }


}