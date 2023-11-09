package DeepLink.Sanity;
/*
import Helpers.DeepLinkHelper;
import Helpers.LoginHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Deep_Link_UPI_Sanity extends CreateSession {
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity","deeplinkSanity"}, priority = 0, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_bank_transfer(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://moneytransfer/upi/bank?account=20241958617&ifsc=SBIN0010897&name=Priyanka", "Confirm Payment", "cta");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity", "deeplinkSanity"}, priority = 1, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_check_balance(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/checkbalance", "Money Transfer ID", "upi_id_label");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity","deeplinkSanity"}, priority = 2, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_ID_Transfer(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/verifyVpa?vpa=priyankaigdtuw@oksbi", "View transaction limit", "view_transaction_limit");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity"}, priority = 3, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_Intent_DeepLink(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("upi://pay?pa=priyankaigdtuw@oksbi&pn=Priyanka", "0", "amount_field");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity", "deeplinkSanity"}, priority = 4, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_pending(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/pending", "Money Transfer ID", "upi_id_label");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity", "deeplinkSanity"}, priority = 5, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_remainder(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://remindersetup", "Payment Reminder", "mkab_title");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity", "deeplinkSanity"}, priority = 6, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_self_transfer(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/selftransfer", "Send to Self", "mkab_title");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity"}, priority = 7, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_transfer_screen(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://moneytransfer/upi", "Transfer Money from UPI", "mkab_title");


    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplink", "UPIsanity", "deeplinkSanity"}, priority = 8, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_request(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://upi/request", "Request Money", "mkab_title");


    }

}


 */