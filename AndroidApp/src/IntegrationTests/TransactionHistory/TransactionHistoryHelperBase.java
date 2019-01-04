package IntegrationTests.TransactionHistory;

import org.json.JSONException;

import java.io.IOException;

public abstract class TransactionHistoryHelperBase {

    public abstract void transactionHistoryVerification(String expectedDescription, String expectedDate, String expectedAmount, String transactionType, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
