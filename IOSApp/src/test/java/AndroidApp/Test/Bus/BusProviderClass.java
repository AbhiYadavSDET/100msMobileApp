package test.java.AndroidApp.Test.Bus;

import customexception.TestParametersNotFound;
import main.java.utils.DatabaseSqlHelper;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.sql.SQLException;

public class BusProviderClass {
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    public static int key;


    @DataProvider(name = "busData")
    public Object[][] getFrontEndTestData(Method method) throws SQLException, TestParametersNotFound {
        //return new Object[][]{{"8447405515@nocash.mobikwik.com","priyanka123"}};
        return new Object[][]{{"mayank.suneja@mobikwik.com", "Tuesday20"}};
    }
}
