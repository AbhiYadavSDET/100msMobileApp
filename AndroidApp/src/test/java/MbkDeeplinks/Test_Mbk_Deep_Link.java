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

    @Test(groups = {"UPI", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void UPI(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"addMoney", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void addMoney(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"expenseManager", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void expenseManager(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"grandSlam", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void grandSlam(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"History", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void History(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"IMPS", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void IMPS(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Offers", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Offers(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"P2P", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void P2P(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"P2M", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void P2M(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Giftcard", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Giftcard(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"splitBill", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void splitBill(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Supercash", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Supercash(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Bus", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Bus(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Ola", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Ola(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Nearby", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Nearby(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );

//        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Payback", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Payback(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


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


