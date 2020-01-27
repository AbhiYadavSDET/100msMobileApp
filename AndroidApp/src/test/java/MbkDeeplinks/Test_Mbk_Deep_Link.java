package MbkDeeplinks;

import Helpers.DeepLinkHelper;
import Helpers.LoginHelper;
import Helpers.MBKCommonControlsHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.deeplink_data.entity.DeeplinkEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.ExtentReport;

import java.io.IOException;

public class Test_Mbk_Deep_Link extends CreateSession {


    @Test(groups = {"Recharge", "DeeplinkSanity"}, priority = 0, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Recharge(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }


    @Test(groups = {"Insurance", "DeeplinkSanity"}, priority = 1, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Insurance(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }

    @Test(groups = {"Loan", "DeeplinkSanity"}, priority = 2, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Loan(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Loan");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }


    @Test(groups = {"MutualFunds", "DeeplinkSanity"}, priority = 3, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void MutualFunds(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }

    @Test(groups = {"Gold", "DeeplinkSanity"}, priority = 4, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Gold(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }

    @Test(groups = {"RedeemVouchers", "DeeplinkSanity"}, priority = 5, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void RedeemVouchers(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }

    @Test(groups = {"ReferAndEarn", "DeeplinkSanity"}, priority = 6, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void ReferAndEarn(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }

    @Test(groups = {"Help", "DeeplinkSanity"}, priority = 7, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Help(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }

    @Test(groups = {"MyWallet", "DeeplinkSanity"}, priority = 8, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void MyWallet(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }


}
