import java.time.Instant;

public class LogMessage {
    private String content;
    private LogLevel level;
    private Instant timestamp;

    public LogMessage(String content, LogLevel level) {
        this.content = content;
        this.level = level;
        this.timestamp = Instant.now();
    }

    @Override
    public String toString() {
        return "[" + level + "] " + timestamp + " - " + content;
    }
}
