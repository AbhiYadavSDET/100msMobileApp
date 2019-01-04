package logger;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * contains all the methods to show the logs on console
 * and save the logs in LogFile.txt of each run.
 */
public class Log {

    private static final Logger LOGGER = Logger.getLogger("logger");
    private static PatternLayout layout = new PatternLayout("%d{dd MMM yyyy HH:mm:ss} %5p %c{1} - %m%n");
    private static FileAppender appender;
    private static ConsoleAppender consoleAppender;


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static {
        try {
            consoleAppender = new ConsoleAppender(layout, "System.out");
            appender = new FileAppender(layout, "LogFile.txt", true);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * method to display errors in log.
     *
     * @param className  name of class in which error occurred.
     * @param methodName name of method in which error occurred.
     * @param exception  stack trace of exception
     */
    public static void logError(String className, String methodName, String exception) {
        LOGGER.addAppender(appender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info("ClassName :" + className);
        LOGGER.info("MethodName :" + methodName);
        LOGGER.info("Exception :" + exception);
        LOGGER.info("-----------------------------------------------------------------------------------");
    }

    /**
     * method to display information in logs
     *
     * @param message message to be displayed
     */
    public static void info(String message) {
        consoleAppender.setName("Console");
        LOGGER.addAppender(consoleAppender);
        LOGGER.addAppender(appender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info(ANSI_RESET + message);
    }

    public static String info(String action, String description) {
        consoleAppender.setName("Console");
        LOGGER.addAppender(consoleAppender);
        LOGGER.addAppender(appender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info(padRight(action, 13) + " | " + description);

        return padRight(action, 13) + " | " + description;
    }

    public static void infoStartTest(String message) {
        consoleAppender.setName("Console");
        LOGGER.addAppender(consoleAppender);
        LOGGER.addAppender(appender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info(ANSI_CYAN + "############### " + padRight("START : ", 8) + message + " ###############" + ANSI_RESET);
    }

    public static void infoEndTest(String message) {
        consoleAppender.setName("Console");
        LOGGER.addAppender(consoleAppender);
        LOGGER.addAppender(appender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info(ANSI_CYAN + "############### " + padRight("END : ", 8) + message + " ###############" + ANSI_RESET);
    }


    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }


}