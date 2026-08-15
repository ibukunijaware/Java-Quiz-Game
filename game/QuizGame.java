package game;



public class QuizGame{
    private QuizManager quizManager;
    private ScoreManager scoreManager;
    private int currentQuestion;

    public QuizGame() {
        quizManager = new QuizManager();
        scoreManager = new ScoreManager();
        currentQuestion = 0;

        addQuestions();
    }

    private void addQuestions() {
        Questions question1 = new Questions("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 'A');
        
        Questions question2 = new Questions("What is the largest planet in our solar system?", new String[]{"Earth", "Jupiter", "Saturn", "Mars"}, 'B');
        
        Questions question3 = new Questions("What is the chemical symbol for water?", new String[]{"H2O", "CO2", "O2", "NaCl"}, 'A');
    
        Questions question4 = new Questions("What is the currency of Japan?", new String[]{"Yen", "Dollar", "Euro", "Pound"}, 'A');
       
        Questions question5 = new Questions("What is the largest ocean on Earth?", new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 'D');
        
        Questions question6 = new Questions("What is the smallest prime number?", new String[]{"0", "1", "2", "3"}, 'C');
        
        Questions question7 = new Questions("What is the chemical symbol for gold?", new String[]{ "Au", "Ag", "Fe", "Hg"}, 'A');
        
        Questions question8 = new Questions("What is the largest continent on Earth?", new String[]{"Africa", "Asia", "Europe", "North America"}, 'B');
       
        Questions question9 = new Questions("What is the fastest land animal?", new String[]{"Cheetah", "Lion", "Tiger", "Horse"}, 'A');
       
        Questions question10 = new Questions("What is Java?", new String[]{"Food", "Country", "Planet", "Language"}, 'D');
       
        // Add questions to the quiz manager
        quizManager.addQuestion(question1);
        quizManager.addQuestion(question2);
        quizManager.addQuestion(question3);
        quizManager.addQuestion(question4);
        quizManager.addQuestion(question5);
        quizManager.addQuestion(question6);
        quizManager.addQuestion(question7);
        quizManager.addQuestion(question8);
        quizManager.addQuestion(question9);
        quizManager.addQuestion(question10);
    }

    // Get the current question
    public Questions getCurrentQuestion() {
        return quizManager.getQuestionsList().get(currentQuestion);
    }

    // Check the user's answer
    public boolean checkAnswer(char answer){
        if(answer == getCurrentQuestion().getCorrectAnswer()){

            scoreManager.incrementScore();
            return true;
        }
        return false;
    }

    // Move to the next question
    public void nextQuestion(){
        if (currentQuestion < quizManager.getQuestionsList().size() - 1) {
            currentQuestion++;
        }
    }

    public boolean isQuizOver(){
        return currentQuestion >= quizManager.getQuestionsList().size() - 1;
    }

    // Get the current score
    public int getScore(){
        return scoreManager.getScore();
    }

    // Get current question number
    public int getQuestionNumber(){
        return currentQuestion;
    }

    // Get total number of questions
    public int getTotalQuestions(){
        return quizManager.getQuestionsList().size();
    }

    // Reset the game to start over
    public void resetGame(){

        currentQuestion = 0;
        scoreManager.resetScore();
    }
}
    