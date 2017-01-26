package com.example.android.quiz;

import static android.R.attr.type;

/**
 * Created by astudzinska on 25.01.2017.
 */

public class Question {

    private String question;
    private QuestionType type;
    private String answer;
    private boolean correct;

    public Question(String question, QuestionType type, String answer) {
        this.question = question;
        this.type = type;
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }


}
