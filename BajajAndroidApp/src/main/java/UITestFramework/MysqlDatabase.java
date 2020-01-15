package UITestFramework;

import logger.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MysqlDatabase {

    public static Properties testDataFile = new Properties();
    File file = new File("");
    FileInputStream configFis;
    Statement statement = null;
    String DBURL;
    String username;
    String password;
    String driver;
    String DBURL_beta;
    String username_beta;
    String password_beta;

    String DBURL_StagingMobile;
    String driver_StagingMobile;
    String username_StagingMobile;
    String password_StagingMobile;

    public MysqlDatabase() throws IOException {
        // TODO Auto-generated constructor stub

        configFis = new FileInputStream(file.getAbsoluteFile() + "//src//config//config.properties");
        testDataFile.load(configFis);

        DBURL = testDataFile.getProperty("DBURL").trim();
        username = testDataFile.getProperty("username").trim();
        password = testDataFile.getProperty("password").trim();
        DBURL_beta = testDataFile.getProperty("DBURL_beta").trim();
        username_beta = testDataFile.getProperty("username_beta").trim();
        password_beta = testDataFile.getProperty("password_beta").trim();
        driver = testDataFile.getProperty("driver").trim();
        // DBURL_StagingMobile="jdbc:mysql://staging.mobikwik.com:3306/mobikwik";
        DBURL_StagingMobile = "jdbc:mysql://mbkmob-staging.cloudapp.net/mobikwik";
        username_StagingMobile = "root";
        password_StagingMobile = "M0B!KW$K";
        driver_StagingMobile = "com.mysql.jdbc.Driver";

    }

    public static void main(String[] args) throws Exception {

        MysqlDatabase readDB = new MysqlDatabase();

        //ResultSet dbResultSet = readDB.readProdDatabase(testDataFile.getProperty("getBalanceQuery").trim(),
        //		"read OTP and order id");

        //	readDB.getTableData(dbResultSet, "balance");
    }

	/*

	public ResultSet readStagingMobile(String sql, String message) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(driver);
			// Setup the connection with the DB
			Log.info(DBURL_StagingMobile);
			Log.info(username_StagingMobile);
			Log.info(password_StagingMobile);
			connect = (Connection) DriverManager.getConnection(DBURL_StagingMobile, username_StagingMobile,
					password_StagingMobile);
			Log.info("connection successful to " + message);
			// Statements allow to issue SQL queries to the database
			statement = (Statement) connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			
			
			return rs;
		} catch (Exception e) {
			Log.logError(this.getClass().getName(), "readStagingDatabase",
					"Exception occured while reading staging databse");
			throw new Exception(e.getMessage());
		}

	}*/

    public Object getTableData(ResultSet resultSet, String column) throws SQLException {
        // ResultSet is initially before the first data set
        String result = "";
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);apiPrototype
            result = resultSet.getString(column);
            Log.info("result: " + result);

        }
        return result;
    }

	/*public ResultSet readProdDatabase(String sql, String message) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(driver);
			// Setup the connection with the DB
			connect = (Connection) DriverManager.getConnection(DBURL_beta, username_beta, password_beta);
			Log.info("connection successful to " + message);
			// Statements allow to issue SQL queries to the database
			statement = (Statement) connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			Log.logError(this.getClass().getName(), "readProdDatabase", "Exception occured while reading beta databse");
			throw new Exception(e.getMessage());
		}

	}*/
}
