package singletonPattern;
// Logger.java
public class Logger {
    // Private static instance - Eager initialization
    private static final Logger instance = new Logger();

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialization logic if needed
    }

    // Public method to get the single instance
    public static Logger getInstance() {
        return instance;
    }

    // Log method
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
