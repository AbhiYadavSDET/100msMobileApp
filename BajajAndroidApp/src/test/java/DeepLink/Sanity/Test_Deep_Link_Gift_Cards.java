package DeepLink.Sanity;

import Helpers.DeepLinkHelper;
import Helpers.LoginHelper;
import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Deep_Link_Gift_Cards extends CreateSession {
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "giftcardsanity"}, priority = 0, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_history(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        //for bank mandate 9958314430@nocash.mobikwik.com india@123
        loginHelper.quickLoginViaEmail(userName, password);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://giftcard/history", "View Gift Cards", "btn_action");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "giftcardsanity"}, priority = 1, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_homescreen(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        //for bank mandate 9958314430@nocash.mobikwik.com india@123
        loginHelper.quickLoginViaEmail(userName, password);

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://giftcard", "View Gift Cards", "btn_action");


    }

}
