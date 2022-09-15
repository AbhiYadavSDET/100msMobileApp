package Logger;

import org.apache.log4j.*;

import java.io.IOException;

/**
 * contains all the methods to show the results on console
 * and save the results in ResultFile.txt of each run.
 */
public class Result {

    private static final Logger RESULT = Logger.getLogger("resultLogger");
    private static PatternLayout resultLayout = new PatternLayout("%d{dd MMM yyyy HH:mm:ss} %5p %c{1} - %m%n");
    private static FileAppender resultAppender;
    private static ConsoleAppender resultConsoleAppender;

    static {
        try {
            resultConsoleAppender = new ConsoleAppender(resultLayout, "System.out");
            resultAppender = new FileAppender(resultLayout, "ResultFile.txt", true);
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
    public static void resultError(String className, String methodName, String exception) {
        RESULT.addAppender(resultAppender);
        RESULT.setLevel((Level) Level.INFO);
        RESULT.info("ClassName :" + className);
        RESULT.info("MethodName :" + methodName);
        RESULT.info("Exception :" + exception);
        RESULT.info("-----------------------------------------------------------------------------------");
    }

    /**
     * method to display information in logs
     *
     * @param message message to be displayed
     */
    public static void info(String message) {
        resultConsoleAppender.setName("resultConsole");
        RESULT.addAppender(resultConsoleAppender);
        RESULT.addAppender(resultAppender);
        RESULT.setLevel((Level) Level.INFO);
        RESULT.info(message);
    }

}