package game;

public class ScoreManager {
    private int score;

    public ScoreManager() {
        score=0;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }  
}
