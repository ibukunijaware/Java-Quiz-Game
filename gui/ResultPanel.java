package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import game.QuizGame;

public class ResultPanel extends JPanel {
    private JLabel gameOverLabel;
    private JLabel resultLabel;
    private JButton restartButton;

    private QuizGame game; 

    public ResultPanel(QuizGame game) {
        this.game = game;

        // Create the labels
        gameOverLabel = new JLabel("Game Over!");
        resultLabel = new JLabel("Your Score: 0 / 10");

        // Create the restart button
        restartButton = new JButton("Play Again");

        // Add the labels and restart button to the panel
        add(gameOverLabel);
        add(resultLabel);
        add(restartButton);
    }
   public void showResult(){
        int score = game.getScore();
        int totalQuestions = game.getTotalQuestions();
        resultLabel.setText("Your Score: " + score + " / " + totalQuestions);
    }
   

    public JButton getRestartButton() {
        return restartButton;
    }
}

    

