package module.three.lld.patterns.creational;

class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (Logger.instance == null) {
            Logger.instance = new Logger();
        }
        return Logger.instance;
    }

    public void logError(String error) {
        System.err.println("Error: " + error);
    }

    public void logMessage(String message) {
        System.out.println("Message: " + message);
    }
}

/**
 * Ensures that a class has only one instance and provides global access to it.
 * For shared resources like configuration, logging, database. (Here resources should be shared i.e only one instance should be created)
 * */
public class _1Singleton {

    public static void main(String[] args) {
        Logger errorLogger = Logger.getInstance();
        Logger messageLogger = Logger.getInstance();
        System.out.println(errorLogger == messageLogger);
        errorLogger.logError("This is an error message");
        messageLogger.logMessage("This is a simple message");
    }

}
