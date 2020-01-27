package MbkDeeplinks;

import customexception.TestParametersNotFound;
import dbutil.mysql.automationtest.deeplink_data.entity.DeeplinkEntity;
import logger.Log;
import org.testng.annotations.DataProvider;
import utils.DatabaseSqlHelper;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

public class MbkDeepLinkDataProviderClass {
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    //    DatabaseMongoHelper databaseMongoHelper = new DatabaseMongoHelper();
    public static int key;


    @DataProvider(name = "mbkdeepLinkData")
    public Object[][] getDeeplinkTestData(Method method) throws SQLException, TestParametersNotFound {
        databaseSqlHelper.initiateDeeplinkTest();

        Log.info("method Name : " + method.getName());

        List<DeeplinkEntity> dbData = databaseSqlHelper.getDeeplinkTestData(method.getName());
        Log.info("size : " + databaseSqlHelper.getDeeplinkTestData(method.getName()).size());
        Object[][] array = new Object[dbData.size()][1];
        for (int i = 1; i <= dbData.size(); i++) {
            array[i - 1][0] = dbData.get(i - 1);
        }
        return array;
    }
}
