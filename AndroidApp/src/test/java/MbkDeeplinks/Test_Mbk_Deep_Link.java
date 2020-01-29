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

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Recharge");

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

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Insurance");

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

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("MutualFunds");

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

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Gold");

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

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("RedeemVouchers");

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

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("ReferAndEarn");

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

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Help");

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

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("MyWallet");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword());

        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);

    }


    @Test(groups = {"UPI", "DeeplinkSanity"}, priority = 9, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void UPI(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("UPI");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"addMoney", "DeeplinkSanity"}, priority = 10, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void addMoney(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("addMoney");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"expenseManager", "DeeplinkSanity"}, priority = 11, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void expenseManager(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("expenseManager");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"grandSlam", "DeeplinkSanity"}, priority = 12, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void grandSlam(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("grandSlam");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"History", "DeeplinkSanity"}, priority = 13, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void History(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("History");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"IMPS", "DeeplinkSanity"}, priority = 14, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void IMPS(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("IMPS");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Offers", "DeeplinkSanity"}, priority = 15, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Offers(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Offers");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"P2P", "DeeplinkSanity"}, priority = 16, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void P2P(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("P2P");


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"P2M", "DeeplinkSanity"}, priority = 17, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void P2M(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("P2M");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Giftcard", "DeeplinkSanity"}, priority = 18, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Giftcard(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Giftcard");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"splitBill", "DeeplinkSanity"}, priority = 19, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void splitBill(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("splitBill");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Supercash", "DeeplinkSanity"}, priority = 20, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Supercash(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Supercash");


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Bus", "DeeplinkSanity"}, priority = 21, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Bus(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Bus");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Ola", "DeeplinkSanity"}, priority = 21, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Ola(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Ola");


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Nearby", "DeeplinkSanity"}, priority = 22, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Nearby(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Nearby");


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }

    @Test(groups = {"Payback", "DeeplinkSanity"}, priority = 23, dataProvider = "mbkdeepLinkData", dataProviderClass = MbkDeepLinkDataProviderClass.class)
    public void Payback(DeeplinkEntity deeplinkEntity) throws IOException, JSONException, InterruptedException {


        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Payback");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(deeplinkEntity.getUserName(), deeplinkEntity.getPassword() );


        MBKCommonControlsHelper mbkCommonControlsHelper = new MBKCommonControlsHelper(getAndroidDriver());
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());
        deepLinkHelper.validateDeeplink(deeplinkEntity.getDeeplink(), deeplinkEntity.getAppName(), deeplinkEntity.getElement(), deeplinkEntity.getElementType(), deeplinkEntity.getModule());

        Thread.sleep(2000);
    }
}



