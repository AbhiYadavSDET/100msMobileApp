package DeepLink;
/*
import Helpers.DeepLinkHelper;
import Helpers.LoginHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Deep_Link extends CreateSession {
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink"}, priority = 0, dataProvider = "deepLinkData", dataProviderClass = DeepLinkDataProviderClass.class)
    public void deep_link(String deeplinkstring, String deeplinkverify, String elementID) throws IOException, JSONException, InterruptedException {

        FrontEndEntity frontEndEntity = new FrontEndEntity();
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.getdeeplink(deeplinkstring, deeplinkverify, elementID);


    }
}


 */