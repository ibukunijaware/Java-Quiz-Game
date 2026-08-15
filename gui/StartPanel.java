package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class StartPanel extends JPanel {
    private JButton startButton;
    private JLabel titleLabel;

   public StartPanel() {
    // Create the title 

    titleLabel = new JLabel("QUIZ GAME");

    //create the start button
    startButton = new JButton("Start");

    // Add the title and start button to the panel
    add(titleLabel);
    add(startButton);
   }

   public JButton getStartButton() {
    return startButton;
   }

}
