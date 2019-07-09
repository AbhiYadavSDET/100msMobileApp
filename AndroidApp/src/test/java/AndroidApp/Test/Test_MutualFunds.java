package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import logger.Log;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.MutualFundsHelper;

public class Test_MutualFunds extends CreateSession {
    MutualFundsHelper mutualFundsHelper;

    @Test(groups = {"mfSanity"}, priority = 1)
    public void transactionHistoryVerificationLoggedOut() throws Exception {
        Log.info("START : Mutual Funds sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        //loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());

        mutualFundsHelper.mutualFundsVerification();
        Log.info("END : Mutual Funds sanity test");

    }


}
