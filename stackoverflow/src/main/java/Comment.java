import java.util.UUID;

public class Comment {
    private final String id;
    private User author;
    private String content;

    public Comment(User author, String content) {
        this.id = generateId();
        this.author = author;
        this.content = content;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
