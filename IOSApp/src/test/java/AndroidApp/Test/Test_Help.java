package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import logger.Log;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.HelpHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

public class Test_Help extends CreateSession {
    HelpHelper helpHelper;

    @Test(groups = {"helpSanity"}, priority = 1)
    public void helpRaiseTicket() throws Exception {
        Log.info("START : Help sanity test");

        LoginHelper loginHelper = new LoginHelper(getIOSDriver());

        loginHelper.quickLoginViaEmail("mayank.suneja@mobikwik.com", "Tuesday20");

        helpHelper = new HelpHelper(getIOSDriver());

        helpHelper.helpVerification();
        Log.info("END : Help sanity test");

    }


}
