package main.java.utils;

import UITestFramework.CreateSession;
import org.testng.Assert;

import java.sql.Timestamp;
import java.util.HashMap;

public class Config extends CreateSession {


    static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public static HashMap<String, TestDataReader> testDataReaderHashMap = new HashMap<String, TestDataReader>();
    static TestDataReader testDataReaderObj;


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    /**
     * This Method is used to log comment
     *
     * @param message
     * @author manojkumar
     */
    public static void logComment(String message) {
        log.info(message);
    }

    /**
     * This Method is used to log fatal message
     *
     * @param message
     * @author manojkumar
     */
    public static void logFatal(String message) {
        log.fatal(message);
    }

    /**
     * This Method is used to log error
     *
     * @param message
     * @author manojkumar
     */
    public static void logError(String message) {
        log.error(message);
    }

    /**
     * This Method is used to log warning.
     *
     * @param message
     * @author manojkumar
     */
    public static void logWarning(String message) {
        log.info(message);
    }

    /**
     * This Method is used to log warning
     *
     * @param expected
     * @param actual
     * @author manojkumar
     */
    public static void logWarning(String what, String expected, String actual) {
        //testResult = false;
        String message = " Expected '" + what + "' was :-'" + expected + "'. But actual is '" + actual + "'";
        log.warn(message);
    }


    /**
     * This Method is used to log failure message
     *
     * @param message
     * @author manojkumar
     */
    public static void logFail(String message) {
        logComment(message);
        Assert.fail(message);
    }

    /**
     * This Method is used to log failure message
     *
     * @param expected
     * @param actual
     * @author manojkumar
     */
    public static void logFail(String what, String expected, String actual) {
        logComment(ANSI_RED + "Expected " + what + " was '" + expected + "', but actual is '" + actual + "'" + ANSI_RED);
        Assert.fail();
    }

    /**
     * This Method is used to log pass mesage
     *
     * @param what
     * @param actual
     * @author manojkumar
     */
    public static void logPass(String what, String actual) {
        logComment(ANSI_GREEN + "Verified '" + what + "' as '" + actual + "'" + ANSI_RESET);
    }

    /**
     * This Method is used to log pass message
     *
     * @param message
     * @author manojkumar
     */
    public static void logPass(String message) {
        logComment(ANSI_GREEN + message + ANSI_RESET);
    }


    /**
     * Add the given key value pair in the Run Time Properties
     *
     * @param key
     * @param value
     * @author manojkumar
     */
    public static void putRunTimeProperty(String key, String value) {
        String keyName = key.toLowerCase();
        properties.put(keyName, value);
        logComment("Putting Run-Time key-" + keyName + " value:-'" + value + "'");
    }

    /**
     * Add the given key value pair in the Run Time Properties
     *
     * @param key
     * @param value
     * @author manojkumar
     */
    public static void putRunTimeProperty(String key, Object value) {
        String keyName = key.toLowerCase();
        properties.put(keyName, value);
        logComment("Putting Run-Time key-" + keyName + " value:-'" + value + "'");
    }

    /**
     * Removes the given key from the Run Time Properties
     *
     * @param key
     * @author manojkumar
     */
    public static void removeRunTimeProperty(String key) {
        //	String keyName = key.toLowerCase();
        logComment("Removing Run-Time key-" + key);
        properties.remove(key);
    }

    /**
     * Get the Run Time Property value
     *
     * @param key key name whose value is needed
     * @return value of the specified key
     * @author manojkumar
     */
    public static String getRunTimeProperty(String key) {
        //	String keyName = key.toLowerCase();
        String value = "";
        try {
            value = properties.getProperty(key).toString();
            value = Helper.replaceArgumentsWithRunTimeProperties(value);
            logComment("Reading Run-Time key-" + key + " value:-'" + value + "'");
        } catch (Exception e) {
            logComment(e.toString());
            logComment("'" + key + "' not found in Run Time Properties");

            return null;
        }
        return value;
    }

    /**
     * Get the cached TestDataReader Object for the given sheet. If it is not
     * cached, it will be cached for future use
     * <p>
     * To read datasheet other than TestDataSheet, pass filename and sheet name separated by dot (i.e filename.sheetname)
     *
     * @param sheetName
     * @return TestDataReader object or null if object is not in cache
     * @author manojkumar
     */
    public static TestDataReader getCachedTestDataReaderObject(String sheetName) {
        String path = getRunTimeProperty("TestDataSheet");
        if (sheetName.contains(".")) {
            path = System.getProperty("user.dir") + getRunTimeProperty(sheetName.split("\\.")[0]);
            sheetName = sheetName.split("\\.")[1];

        }
        return getCachedTestDataReaderObject(sheetName, path);
    }


    /**
     * Get the cached TestDataReader Object for the given sheet in the excel
     * specified by path. If it is not cached, it will be cached for future use
     *
     * @param sheetName
     * @param path      Path of excel sheet to read
     * @return TestDataReader object or null if object is not in cache
     * @author manojkumar
     */
    public static TestDataReader getCachedTestDataReaderObject(String sheetName, String path) {
        TestDataReader obj = testDataReaderHashMap.get(path + sheetName);
        // Object is not in the cache
        if (obj == null) {
            // cache for future use
            synchronized (Config.class) {
                cacheTestDataReaderObject(sheetName, path);
                obj = testDataReaderHashMap.get(path + sheetName);
            }
        }
        return obj;
    }

    /**
     * Create TestDataReader object for the given sheet and cache it can be
     * fetched using - getCachedTestDataReaderObject()
     *
     * @param sheetName
     * @author manojkumar
     */
    private static void cacheTestDataReaderObject(String sheetName, String path) {
        if (testDataReaderHashMap.get(path + sheetName) == null) {
            testDataReaderObj = new TestDataReader(sheetName, path);
            testDataReaderHashMap.put(path + sheetName, testDataReaderObj);
        }
    }


}