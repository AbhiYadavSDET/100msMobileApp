package test.java.AndroidApp.Test.DeepLink.Sanity;

import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.DeepLinkHelper;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Test.DeepLink.DeepLinkDataProviderClass;

import java.io.IOException;

public class Test_Deep_Link_UPI_Sanity extends CreateSession
{ @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
@Test(groups = {"deeplink","UPIsanity"}, priority = 0, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
public void deep_link_bank_transfer(String userName, String password) throws IOException, JSONException, InterruptedException {


    LoginHelper loginHelper = new LoginHelper(getIOSDriver());

    loginHelper.quickLoginViaEmail(userName, password);

    //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

    DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

    deepLinkHelper.getdeeplink("mobikwik://moneytransfer/upi/bank?account=20241958617&ifsc=SBIN0010897&name=Priyanka", "Confirm Payment", "cta");



}
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","UPIsanity"}, priority = 1,dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_check_balance(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());
        loginHelper.quickLoginViaEmail(userName, password);

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/checkbalance", "Money Transfer ID", "upi_id_label");



    }
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","UPIsanity"}, priority = 2, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_ID_Transfer(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());
        loginHelper.quickLoginViaEmail(userName, password);

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/verifyVpa?vpa=priyankaigdtuw@oksbi", "View transaction limit", "view_transaction_limit");



    }
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","UPIsanity"}, priority = 3, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_Intent_DeepLink(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());
        loginHelper.quickLoginViaEmail(userName, password);

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("upi://pay?pa=priyankaigdtuw@oksbi&pn=Priyanka", "0", "amount_field");



    }
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","UPIsanity"}, priority = 4, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_pending(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());
        loginHelper.quickLoginViaEmail(userName, password);

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/pending", "Money Transfer ID", "upi_id_label");



    }
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","UPIsanity"}, priority = 5, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_remainder(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());
        loginHelper.quickLoginViaEmail(userName, password);

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://remindersetup", "Payment Reminder", "mkab_title");



    }
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","UPIsanity"}, priority = 6, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_self_transfer(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());

        loginHelper.quickLoginViaEmail(userName, password);

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/selftransfer", "Send to Self", "mkab_title");



    }
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink","UPIsanity"}, priority = 7, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_transfer_screen(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getIOSDriver());
        loginHelper.quickLoginViaEmail(userName, password);


        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getIOSDriver());

        deepLinkHelper.getdeeplink("mobikwik://moneytransfer/upi", "Transfer Money from UPI", "mkab_title");



    }

}
