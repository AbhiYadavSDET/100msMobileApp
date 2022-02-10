package DeepLink.Sanity;

import Helpers.DeepLinkHelper;
import Helpers.LoginHelper;
import UITestFramework.CreateSession;
import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Deep_Link_Expense_Managr extends CreateSession {
    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    @Test(groups = {"deeplinkEM",}, priority = 0, dataProvider = "deepLinkSanityData", dataProviderClass = DeepLinkSanityDataProvider.class)
    public void deep_link_cricket(String userName, String password) throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(userName, password);

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.getdeeplink("mobikwik://expense", "One passbook for all expenses", "heading1");

    }
}
