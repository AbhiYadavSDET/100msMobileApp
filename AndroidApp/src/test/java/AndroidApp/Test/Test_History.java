package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import logger.Log;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.TransactionHistoryHelper;

/**
 * automated test to verify Add Money.
 */

public class Test_History extends CreateSession {
    TransactionHistoryHelper transactionHistoryHelper;

    @Test(groups = {"loginSanity", "transactionHistoryVerification"}, priority = 0)
    public void transactionHistoryVerificationLoggedOut() throws Exception {

        Log.info("START : Transaction History verification for logged-out user");
        transactionHistoryHelper = new TransactionHistoryHelper(getAndroidDriver());
        transactionHistoryHelper.transactionHistoryVerificationLoggedOut();
        Log.info("END : Transaction History verification for logged-out user");
    }

    @Test(groups = {"loginSanity", "transactionHistoryVerification"}, priority = 1)
    public void transactionHistoryVerificationLoggedIn() throws Exception {

        Log.info("START : Transaction History verification for logged-in user");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");

        transactionHistoryHelper = new TransactionHistoryHelper(getAndroidDriver());
        transactionHistoryHelper.transactionHistoryVerificationLoggedIn();
        Log.info("END : Transaction History verification for logged-in user");


    }
}



