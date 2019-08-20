package test.java.AndroidApp.Test.DeepLink.Sanity;

import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.DeepLinkHelper;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Test.DeepLink.DeepLinkDataProviderClass;

import java.io.IOException;

public class Test_Deep_Link_Mutual_Funds_Sanity_Stag extends CreateSession {
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","mfstagsanity"}, priority = 0, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_KYC(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());

        loginHelper.quickLoginViaEmail(userName, password);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://mutual-funds/kyc", "Mutual Funds Portfolio", "mkab_title");



    }
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","mfstagsanity"}, priority = 1,dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_open_mandate(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());

        loginHelper.quickLoginViaEmail(userName, password);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://mutual-funds/bank-mandate", "Auto-Pay Set Up", "mkab_title");



    }
}
