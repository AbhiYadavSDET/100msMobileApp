package test.java.AndroidApp.PageObject;

import org.json.JSONException;

import java.io.IOException;

public abstract class MgmHelperBase {
    public abstract void verifyMgm(String directoryName, String screenName) throws InterruptedException, IOException, JSONException;
}
