package singletonPattern;

// Main.java
public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("Another log message.");

        // Check if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Same Logger instance confirmed.");
        }
    }
}

