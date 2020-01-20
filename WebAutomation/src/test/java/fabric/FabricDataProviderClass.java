package fabric;

import Utils.DatabaseSqlHelper;
import Utils.Log;
import customexception.TestParametersNotFound;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

public class FabricDataProviderClass {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    public static int key;


    @DataProvider(name = "fabricData")
    public Object[][] getFabricData(Method method) throws SQLException, TestParametersNotFound {
        databaseSqlHelper.initiateFrontEndTest();

        Log.info("method Name : " + method.getName());

        List<FrontEndEntity> dbData = databaseSqlHelper.getFrontEndTestData(method.getName());
        Log.info("size : " + databaseSqlHelper.getFrontEndTestData(method.getName()).size());
        Object[][] array = new Object[dbData.size()][1];
        for (int i = 1; i <= dbData.size(); i++) {
            array[i - 1][0] = dbData.get(i - 1);
        }
        return array;
    }
}
