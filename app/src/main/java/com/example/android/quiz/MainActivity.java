package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Question[] questions = {
            new Question("Jak ma na imię nasza córka ? ",QuestionType.TEXT_EDIT),
            new Question("Ile zębów ma nasza córka ?",QuestionType.RADIO_BUTTON),
            new Question("W co ubieramy naszą córkę ?",QuestionType.CHECK_BOX)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
