package Help;

import Helpers.HelpHelper;
import Helpers.LoginHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.testng.annotations.Test;

public class Test_Help extends CreateSession {
    HelpHelper helpHelper;


    @Test(groups = {"helpSanity"}, priority = 1, dataProvider = "helpData", dataProviderClass = HelpProviderClass.class)
    public void Test01_help_raise_ticket(FrontEndEntity frontEndEntity) throws Exception {
        Log.info("START : Help sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

//        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");

        helpHelper = new HelpHelper(getAndroidDriver());

        helpHelper.helpVerification();
        Log.info("END : Help sanity test");

    }


}
