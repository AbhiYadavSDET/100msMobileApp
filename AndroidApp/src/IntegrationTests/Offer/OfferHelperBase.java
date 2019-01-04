package IntegrationTests.Offer;

import org.json.JSONException;

import java.io.IOException;

public abstract class OfferHelperBase {

    public abstract void offerSearch(String offerName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void offerCategoryCheck(String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
