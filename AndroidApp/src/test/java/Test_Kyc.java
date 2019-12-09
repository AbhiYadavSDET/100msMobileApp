
import Helpers.LoginHelper;
import Helpers.WalletPageHelper;
import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_Kyc extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @Test(groups = {"noKycCheck", "kycSanity"}, priority = 0)
    public void No_kyc_check() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        WalletPageHelper walletPageHelper = new WalletPageHelper(driver);
        walletPageHelper.checkIfNoKycUser();

    }


}