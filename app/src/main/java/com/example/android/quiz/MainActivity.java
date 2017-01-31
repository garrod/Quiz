package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.android.quiz.R.id.answer;
import static com.example.android.quiz.R.id.radio_buttons;
import static com.example.android.quiz.R.id.radio_group;

public class MainActivity extends AppCompatActivity {

    Question[] questions = {
            new Question("Jak ma na imię nasza córka ? ",QuestionType.TEXT_EDIT,"Gabi"),
            new Question("Ile zębów ma nasza córka ?",QuestionType.RADIO_BUTTON,"2 zęby"),
            new Question("W co ubieramy naszą córkę ?",QuestionType.CHECK_BOX,"RajstopyBody")
    };

    boolean[] answers = new boolean[3];

    View firstView, secondView, thirdView;
    LinearLayout textEdit, radioButtons, checkBoxes;
    CheckBox checkboxSombrero,checkboxRajstopy,checkboxSzpilki,checkboxBody;
    CheckBox[] checkboxAnswers = {};
    EditText answer;
    RadioGroup radioGroup;
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

        checkboxSombrero = (CheckBox) findViewById(R.id.id_sombrero);
        checkboxRajstopy = (CheckBox) findViewById(R.id.id_rajstopy);
        checkboxSzpilki = (CheckBox) findViewById(R.id.id_szpilki);
        checkboxBody = (CheckBox) findViewById(R.id.id_body);
        checkboxAnswers = new CheckBox[]{checkboxSombrero, checkboxRajstopy, checkboxSzpilki, checkboxBody};

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        firstView.setVisibility(View.VISIBLE);
        secondView.setVisibility(View.GONE);
        thirdView.setVisibility(View.GONE);

        textEdit.setVisibility(View.VISIBLE);
        radioButtons.setVisibility(View.GONE);
        checkBoxes.setVisibility(View.GONE);

        answer = (EditText) findViewById(R.id.answer);

        questionField = (TextView) findViewById(R.id.question_field);
    }

    //przejscie do pytan
    public void gotoQuestions(View view) {
        firstView.setVisibility(View.GONE);
        secondView.setVisibility(View.VISIBLE);
        addQuestion();
    }

    //przejscie do podsumowania
    public void gotoSummary() {
        secondView.setVisibility(View.GONE);
        thirdView.setVisibility(View.VISIBLE);
        int countGood = 0;
        int countWrong = 0;
        int average = 0;

        for (Question questionCorrect : questions) {
            countGood += questionCorrect.isCorrect() ? 1 : 0;
            countWrong += questionCorrect.isCorrect() ? 0 : 1;
        }

        TextView goodAnswers = (TextView) findViewById(R.id.good_answers);
        TextView wrongAnswers = (TextView) findViewById(R.id.wrong_answers);
        TextView averageAnswers = (TextView) findViewById(R.id.average_answers);

//        String goodA = "Poprawne odpowiedzi : "+countGood;
        goodAnswers.setText("Poprawne odpowiedzi : " + countGood);
        wrongAnswers.setText("Błędne odpowiedzi : " + countWrong);
        average = (int) (((double)countGood/(double)questions.length)*100);
        averageAnswers.setText("Średnia : " + average + "%");
    }

    public void reset_quiz(View view) {
        thirdView.setVisibility(View.GONE);
        firstView.setVisibility(View.VISIBLE);

        textEdit.setVisibility(View.VISIBLE);
        checkBoxes.setVisibility(View.GONE);

        answer.setText("");
        questionNumber = 0;

        radioGroup.clearCheck();
        for (CheckBox checkb : checkboxAnswers) {
            checkb.setChecked(false);
        }
    }

    // wypisanie pytania
    private void addQuestion() {
        questionField.setText(questions[questionNumber].getQuestion());
    }

    // sprawdzanie kolejnych pytan
    public void nextQuestion(View view) {
        if(questionNumber==0){

//            answers[0] = answer.getText().toString().equals(questions[questionNumber].getAnswer());
            questions[questionNumber].setCorrect(answer.getText().toString().equals(questions[questionNumber].getAnswer()));

            textEdit.setVisibility(View.GONE);
            radioButtons.setVisibility(View.VISIBLE);
            questionNumber+=1;
            addQuestion();
        }
        else if(questionNumber==1) {
            radioGroup = (RadioGroup) findViewById(R.id.radio_group);

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
            String selectedValue = selectedRadioButton.getText().toString();

            questions[questionNumber].setCorrect(selectedValue.equals(questions[questionNumber].getAnswer()));

            radioButtons.setVisibility(View.GONE);
            checkBoxes.setVisibility(View.VISIBLE);
            questionNumber+=1;
            addQuestion();
        }
        else if(questionNumber==2) {
            String checkboxAnswer = "";

            for (CheckBox check : checkboxAnswers) {
                if(check.isChecked()) {
                    checkboxAnswer += check.getText().toString();
                }
            }

            questions[questionNumber].setCorrect(checkboxAnswer.equals(questions[questionNumber].getAnswer()));

            gotoSummary();
        }
    }

    public void checkboxClick(CheckBox checkbox) {

    }
}
