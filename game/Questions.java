package game;


/**  This class represents a question in the quiz game

@author Ibukunoluwa Oladunni Ijaware
@version 1.0

*/

public class Questions {
    private String question;
    private String[] options;
    private char correctAnswer;


    public Questions(String question, String[] options, char correctAnswer) {
        // Check that the options array has exactly 4 elements
        if (options.length != 4) {
            throw new IllegalArgumentException("Options array must have exactly 4 elements.");
        }
        
        // Check that the correct answer is one of the options
        if (correctAnswer < 'A' || correctAnswer > 'D') {
            throw new IllegalArgumentException("Correct answer must be one of the options: A, B, C, or D.");
        }
        
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}





