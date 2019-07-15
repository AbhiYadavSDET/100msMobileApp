package test.java.AndroidApp.Test.Mgm;

import customexception.TestParametersNotFound;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import main.java.utils.DatabaseSqlHelper;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

public class MgmDataProviderClass {
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    public static int key;


    @DataProvider(name = "mgmData")
    public Object[][] getFrontEndTestData(Method method) throws SQLException, TestParametersNotFound {
        return new Object[][]{{"8447405515@nocash.mobikwik.com","priyanka123"}};

    }}
