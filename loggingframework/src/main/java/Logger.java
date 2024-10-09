public class Logger {
    private static Logger instance;
    private LoggerConfig config;

    private Logger() {
        config = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= config.getLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(message, level);
            config.getAppender().append(logMessage);
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void setConfig(LoggerConfig config) {
        this.config = config;
    }
}
