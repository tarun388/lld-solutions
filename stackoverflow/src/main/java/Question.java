import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Question implements Commentable, Voteable {
    private final String id;
    private String title;
    private String content;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Vote> votes;
    private final User author;
    private List<Tag> tags;
    private final Instant creationDate;

    public Question(String title, String content, User author, List<String> tags) {
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        creationDate = Instant.now();
        answers = new ArrayList<>();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
        this.tags = new ArrayList<>();
        tags.forEach(name -> this.tags.add(new Tag(name)));
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
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

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }
}
