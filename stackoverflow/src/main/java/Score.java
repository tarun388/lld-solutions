public class Score {
    private int score;
    public static final int QUESTION_POINTS = 5;
    public static final int ANSWER_POINTS = 6;

    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
