import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private String username;
    private String email;
    private final Score score;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    public User(String name, String email) {
        this.id = generateId();
        this.username = name;
        this.email = email;
        score = new Score();
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
        updateScore(Score.QUESTION_POINTS);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        updateScore(Score.ANSWER_POINTS);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
     private void updateScore(int points) {
        score.setScore(score.getScore() + points);
     }

     public int getReputation() {
        return score.getScore();
     }

    public List<Question> getQuestions() {
        return questions;
    }
}
