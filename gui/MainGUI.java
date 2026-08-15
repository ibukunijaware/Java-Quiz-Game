package gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

// Import the QuizGame class
import game.QuizGame; 


public class MainGUI extends JFrame {
    // Panels for different stages of the quiz
    private StartPanel startPanel;
    private QuizPanel quizPanel;
    private ResultPanel resultPanel;
    private QuizGame game; // Reference to the QuizGame class
    
    private CardLayout cardLayout;
    private JPanel mainPanel;


    public MainGUI() {
        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window


        //create the card layout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create the panels 
        game = new QuizGame(); // Initialize the QuizGame instance

        startPanel = new StartPanel();
        resultPanel = new ResultPanel(game);

        quizPanel = new QuizPanel(game, () -> {
            resultPanel.showResult(); 
            cardLayout.show(mainPanel, "RESULT"); 
        });

        // Add the panels to the main panel
        mainPanel.add(startPanel, "START");
        mainPanel.add(quizPanel, "QUIZ");
        mainPanel.add(resultPanel, "RESULT");

        // Add the main panel to the frame
        add(mainPanel);

        // Display the start panel first
        cardLayout.show(mainPanel, "START");

        // Add action listeners to the buttons
        startPanel.getStartButton().addActionListener(e -> {
            cardLayout.show(mainPanel, "QUIZ");
        });

        // Play again functionality
        resultPanel.getRestartButton().addActionListener(e -> {
            cardLayout.show(mainPanel, "START");
        });

        // Set the frame to be visible
        setVisible(true);
    }
    

    public static void main(String[] args) {
            new MainGUI();
    }
}   
