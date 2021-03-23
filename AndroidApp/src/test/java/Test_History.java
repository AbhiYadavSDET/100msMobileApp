
import Helpers.LoginHelper;
import Helpers.TransactionHistoryHelper;
import UITestFramework.CreateSession;
import logger.Log;
import org.testng.annotations.Test;

/**
 * automated test to verify Add Money.
 */

public class Test_History extends CreateSession {
    TransactionHistoryHelper transactionHistoryHelper;

//    @Test(groups = {"loginSanity", "transactionHistoryVerification"}, priority = 0)
//    public void transactionHistoryVerificationLoggedOut() throws Exception {
//
//        Log.info("START : Transaction History verification for logged-out user");
//        transactionHistoryHelper = new TransactionHistoryHelper(getAndroidDriver());
//        transactionHistoryHelper.transactionHistoryVerificationLoggedOut();
//        Log.info("END : Transaction History verification for logged-out user");
//    }

    @Test(groups = {"loginSanity", "transactionHistoryVerification"}, priority = 1)
    public void transactionHistoryVerificationLoggedIn() throws Exception {

        Log.info("START : Transaction History verification for logged-in user");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        transactionHistoryHelper = new TransactionHistoryHelper(getAndroidDriver());
        transactionHistoryHelper.transactionHistoryVerificationLoggedIn();
        Log.info("END : Transaction History verification for logged-in user");


    }
}



