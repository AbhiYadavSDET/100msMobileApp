package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import logger.Log;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.TransactionHistoryHelper;

import java.io.IOException;

/**
 * automated test to verify Add Money.
 */

public class Test_History extends CreateSession {
    TransactionHistoryHelper transactionHistoryHelperBase;

    @Test(groups = {"loginSanity", "transactionHistoryVerification"}, priority = 1)
    public void transactionHistoryVerificationLoggedOut() throws Exception {

        Log.info("START : Transaction History verification for logged-out user");

        transactionHistoryHelperBase = new TransactionHistoryHelper(getAndroidDriver());

        transactionHistoryHelperBase.transactionHistoryVerificationLoggedOut();
        Log.info("END : Transaction History verification for logged-out user");
    }

    @Test(groups = {"loginSanity", "transactionHistoryVerification"}, priority = 0)
    public void transactionHistoryVerificationLoggedIn() throws Exception {

        Log.info("START : Transaction History verification for logged-in user");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        //loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("rashia15@gmail.com", "india@123");

        transactionHistoryHelperBase = new TransactionHistoryHelper(getAndroidDriver());

        transactionHistoryHelperBase.transactionHistoryVerificationLoggedIn();
        Log.info("END : Transaction History verification for logged-out user");


    }
}



