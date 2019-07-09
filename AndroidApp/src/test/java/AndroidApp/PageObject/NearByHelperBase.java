package test.java.AndroidApp.PageObject;

import org.json.JSONException;

import java.io.IOException;
public abstract class NearByHelperBase {
    public abstract void nearbyStoreListMap(String directoryName, String screenName) throws InterruptedException, IOException, JSONException;
    public abstract void nearbySearchCategory(String categoryName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;
    public abstract void nearbySearchStore(String storeName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;
    
}
