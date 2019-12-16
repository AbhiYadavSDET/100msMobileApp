package test.java.AndroidApp.Test.Rooted;

import UITestFramework.CreateSession;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.RootedHelper;

import java.io.IOException;

public class Test_Rooted extends CreateSession {

    @Test(groups = {"rootedSanity"})
    public void Test_rootedDevice() throws JSONException, IOException {

        Log.info("START : Rooted Device sanity test");
        RootedHelper rootedHelper = new RootedHelper(getAndroidDriver());
        rootedHelper.assertText();
        Log.info("END : Rooted Device sanity test");
    }
}
