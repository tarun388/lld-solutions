import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {
    private static StackOverflow instance;
    private final Map<String, User> users;
    private final Map<String, Question> questions;
    private final Map<String, Answer> answers;

    private StackOverflow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
    }

    public static synchronized StackOverflow getInstance() {
        if (instance == null) {
            instance = new StackOverflow();
        }
        return instance;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags) {
        Question question = new Question(title, content, user, tags);
        questions.put(question.getId(), question);
        user.addQuestion(question);
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer = new Answer(content, question, user);
        answers.put(answer.getId(), answer);
        question.addAnswer(answer);
        user.addAnswer(answer);
        return answer;
    }

    public void addComment(User user, Commentable commentable, String content) {
        Comment comment = new Comment(user, content);
        commentable.addComment(comment);
    }

    public void voteQuestion(User user, Question question, int value) {
        question.vote(user);
    }

    public void voteAnswer(User user, Answer answer, int value) {
        answer.vote(user);
    }

    public void acceptAnswer(Answer answer) {
        answer.markAccepted();
    }

    public List<Question> searchQuestions(String query) {
        return questions.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTags().stream().anyMatch(t -> t.getName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }
}
