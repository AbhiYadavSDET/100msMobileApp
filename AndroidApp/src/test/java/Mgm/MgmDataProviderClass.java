package Mgm;

import customexception.TestParametersNotFound;
import org.testng.annotations.DataProvider;
import utils.DatabaseSqlHelper;

import java.lang.reflect.Method;
import java.sql.SQLException;

public class MgmDataProviderClass {
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    public static int key;


    @DataProvider(name = "mgmData")
    public Object[][] getFrontEndTestData(Method method) throws SQLException, TestParametersNotFound {
        return new Object[][]{{"8447405515@nocash.mobikwik.com", "priyanka123"}};

    }
}
