package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Question[] questions = {
            new Question("Jak ma na imię nasza córka ? ",QuestionType.TEXT_EDIT,"Gabrysia"),
            new Question("Ile zębów ma nasza córka ?",QuestionType.RADIO_BUTTON,"2"),
            new Question("W co ubieramy naszą córkę ?",QuestionType.CHECK_BOX,"Rajstopy,Body")
    };

    View firstView, secondView, thirdView;
    TextView questionField;
    int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstView = (View) findViewById(R.id.first_view);
        secondView = (View) findViewById(R.id.second_view);
        thirdView = (View) findViewById(R.id.third_view);

        firstView.setVisibility(View.VISIBLE);
        secondView.setVisibility(View.GONE);
        thirdView.setVisibility(View.GONE);

        questionField = (TextView) findViewById(R.id.question_field);
    }

    //przejscie do pytan
    public void gotoQuestions(View view) {
        firstView.setVisibility(View.GONE);
        secondView.setVisibility(View.VISIBLE);
        addQuestion();
    }

    private void addQuestion() {
        questionField.setText(questions[questionNumber].getQuestion());
    }

    private void nextQuestion() {
        if(questionNumber==0){

        }
        else if(questionNumber==1) {

        }
        else if(questionNumber==2) {

        }
    }
}
