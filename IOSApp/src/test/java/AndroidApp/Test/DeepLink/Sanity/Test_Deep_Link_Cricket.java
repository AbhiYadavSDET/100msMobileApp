package test.java.AndroidApp.Test.DeepLink.Sanity;

import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.DeepLinkHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

public class Test_Deep_Link_Cricket extends CreateSession {
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplinkCricket",}, priority = 0,  dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_cricker(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());
        loginHelper.quickLoginViaEmail(userName, password);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://predict-and-win", "Let's Start", "btn_action");

    }}
