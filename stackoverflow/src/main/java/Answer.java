import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Answer implements Commentable, Voteable {
    private final String id;
    private String content;
    private Question associatedQuestion;
    private List<Comment> comments;
    private List<Vote> votes;
    private final User author;
    private Instant creationDate;
    private boolean accepted;

    public Answer(String content, Question associatedQuestion, User author) {
        this.id = generateId();
        this.content = content;
        this.associatedQuestion = associatedQuestion;
        this.author = author;
        comments = new ArrayList<>();
        votes = new ArrayList<>();
        creationDate = Instant.now();
        accepted = false;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user) {
        votes.add(new Vote(user));
    }

    @Override
    public int getVoteCount() {
        return votes.size();
    }

    public void markAccepted() {
        accepted = true;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
