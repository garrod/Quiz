package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.android.quiz.R.id.answer;
import static com.example.android.quiz.R.id.radio_buttons;

public class MainActivity extends AppCompatActivity {

    Question[] questions = {
            new Question("Jak ma na imię nasza córka ? ",QuestionType.TEXT_EDIT,"Gabi"),
            new Question("Ile zębów ma nasza córka ?",QuestionType.RADIO_BUTTON,"2 zęby"),
            new Question("W co ubieramy naszą córkę ?",QuestionType.CHECK_BOX,"Rajstopy,Body")
    };

    boolean[] answers = new boolean[3];

    View firstView, secondView, thirdView;
    LinearLayout textEdit, radioButtons, checkBoxes;
    TextView questionField;
    int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstView = (View) findViewById(R.id.first_view);
        secondView = (View) findViewById(R.id.second_view);
        thirdView = (View) findViewById(R.id.third_view);

        textEdit = (LinearLayout) findViewById(R.id.text_edit);
        radioButtons = (LinearLayout) findViewById(R.id.radio_buttons);
        checkBoxes = (LinearLayout) findViewById(R.id.check_boxes);

        firstView.setVisibility(View.VISIBLE);
        secondView.setVisibility(View.GONE);
        thirdView.setVisibility(View.GONE);

        textEdit.setVisibility(View.VISIBLE);
        radioButtons.setVisibility(View.GONE);
        checkBoxes.setVisibility(View.GONE);

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

    public void nextQuestion(View view) {
        if(questionNumber==0){
            EditText answer = (EditText) findViewById(R.id.answer);

            answers[0] = answer.getText().toString().equals(questions[questionNumber].getAnswer());

            textEdit.setVisibility(View.GONE);
            radioButtons.setVisibility(View.VISIBLE);
            questionNumber+=1;
        }
        else if(questionNumber==1) {
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
            String selectedValue = selectedRadioButton.getText().toString();
            answers[1] = selectedValue.equals(questions[questionNumber].getAnswer());

            radioButtons.setVisibility(View.GONE);
            checkBoxes.setVisibility(View.VISIBLE);
            questionNumber+=1;
        }
        else if(questionNumber==2) {

        }
    }
}
