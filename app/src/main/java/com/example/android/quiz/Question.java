package com.example.android.quiz;

import static android.R.attr.type;

/**
 * Created by astudzinska on 25.01.2017.
 */

public class Question {

    private String question;
    private QuestionType type;

    public Question(String question, QuestionType type) {
        this.question = question;
        this.type = type;
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
