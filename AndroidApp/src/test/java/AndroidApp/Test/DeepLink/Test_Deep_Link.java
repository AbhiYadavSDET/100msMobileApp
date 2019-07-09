package test.java.AndroidApp.Test.DeepLink;

import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import main.java.utils.DatabaseSqlHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.java.AndroidApp.Helpers.DeepLinkHelper;
import test.java.AndroidApp.Helpers.LoginHelper;
import UITestFramework.CreateSession;

import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Test.AddMoney.AddMoneyProviderClass;
import test.java.AndroidApp.Test.DeepLink.DeepLinkDataProviderClass;
import test.java.AndroidApp.Test.IMPS.ImpsDataProviderClass;


import java.io.IOException;

public class Test_Deep_Link extends CreateSession {
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink"}, priority = 0, dataProvider = "deepLinkData", dataProviderClass = DeepLinkDataProviderClass.class)
    public void deep_link(String deeplinkstring, String deeplinkverify, String elementID) throws IOException, JSONException, InterruptedException {

        FrontEndEntity frontEndEntity=new FrontEndEntity();
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.getdeeplink(deeplinkstring, deeplinkverify, elementID);


    }
}
