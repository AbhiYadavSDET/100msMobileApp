package DeepLink.Sanity;
/*
import DeepLink.DeepLinkDataProviderClass;
import Helpers.DeepLinkHelper;
import Helpers.LoginHelper;
import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Deep_Link_HubServicesforMerchant extends CreateSession {
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "merchantsanity"}, priority = 0, dataProvider = "deepLinkData", dataProviderClass = DeepLinkDataProviderClass.class)
    public void deep_link_refer_loan(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        //for bank mandate 9958314430@nocash.mobikwik.com india@123
        loginHelper.quickLoginViaEmail(userName, password);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://hubspoke?serviceid=1", "Accept referral for Loan", "service_name");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "merchantsanity"}, priority = 1, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_refer_screen(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        loginHelper.quickLoginViaEmail(userName, password);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://hub-services/loan", "Refer for Loan", "mkab_title");


    }
}


 */