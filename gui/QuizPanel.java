package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import game.QuizGame;
import game.Questions;

public class QuizPanel extends JPanel {

    private JLabel questionLabel;
    private JLabel scoreLabel;
    private JButton[] optionButtons;

    private QuizGame game; // Reference to the QuizGame class
    private Runnable onQuizEnd; // Callback to be executed when the quiz ends



    public QuizPanel(QuizGame game, Runnable onQuizEnd) {
        this.game = game;
        this.onQuizEnd = onQuizEnd;
        //create the labels
        questionLabel = new JLabel("Question");
        scoreLabel = new JLabel("Score: 0");
       
        //create the option buttons
        optionButtons = new JButton[4];

        for (int i = 0; i < optionButtons.length; i++) {
            
                optionButtons[i] = new JButton();

                 // Capture the index for use in the action listener
                final int answerIndex = i; 
               

                optionButtons[i].addActionListener(e -> {

                    // Convert index to corresponding character (A, B, C, D)
                    char answer = (char) ('A' + answerIndex); 

                    // Check the answer using the QuizGame instance
                    game.checkAnswer(answer); 

                    if (game.isQuizOver()) {
                        // If the quiz is over, execute the callback to show results
                        onQuizEnd.run(); 
                    } else{
                        // Move to the next question
                        game.nextQuestion(); 

                        // Update the displayed question and score
                        showQuestion();
                    }
                });
            }
                    
        

        // Add the labels and option buttons to the panel
        add(questionLabel);
        add(scoreLabel);

        // Display the first question when the panel is initialized
        showQuestion(); 


        for (JButton button : optionButtons) {
            add(button);
        }  
    }

    // Display current question
    private void showQuestion(){
        Questions question = game.getCurrentQuestion();

        setQuestion(question.getQuestion());
        setOptions(question.getOptions());
        setScore(game.getScore());
    }
    
    // Update Questions displayed
    public void  setQuestion(String question) {
        questionLabel.setText(question);
    }

    // Update Score displayed
    public void setScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    // Update Option Buttons displayed
    public void setOptions(String[] answers) {

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText(answers[i]);
        }
    }

    // Getters for the option buttons
    public JButton[] getOptionButtons() {
        return optionButtons;
    }
}


