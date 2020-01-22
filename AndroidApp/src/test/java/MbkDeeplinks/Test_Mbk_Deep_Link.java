package MbkDeeplinks;

import Helpers.DeepLinkHelper;
import Helpers.LoginHelper;
import Helpers.MBKCommonControlsHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.deeplink_data.entity.DeeplinkEntity;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Mbk_Deep_Link extends CreateSession {


    @Test(groups = {"Recharge", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Recharge(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");



        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);




    }
}
