import java.util.logging.*;

public class MyLogger {
    private static Handler handler;
    private static Formatter formatter;
    private static Logger logger;
    static{
        formatter = new SimpleFormatter();
        handler = new ConsoleHandler();
        handler.setFormatter(formatter);
        handler.setLevel(Level.ALL);
    }
    private static void loggerConf(String name){
        logger = Logger.getLogger(name);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
    }
    public static void log(String name, String message){
        loggerConf(name);
        logger.fine(message);
    }
}
