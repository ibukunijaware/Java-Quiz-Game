package game;

import java.util.ArrayList;

public class QuizManager {
    private ArrayList<Questions> questionsList;

    public QuizManager() {
        questionsList = new ArrayList<>();
    }

    public void addQuestion(Questions question) {
        questionsList.add(question);
    }

    public ArrayList<Questions> getQuestionsList() {
        return questionsList;
    }

}