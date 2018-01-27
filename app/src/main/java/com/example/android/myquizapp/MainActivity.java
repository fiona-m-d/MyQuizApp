package com.example.android.myquizapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    /**
     * Setting global variable for score
     */
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.main_scroll_view).requestFocus();
    }


    /**
     * Q1 hint toast message
     */
    public void hintQ1(View view) {
        Toast.makeText(this, R.string.Q1_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q2 hint toast message
     */
    public void hintQ2(View view) {
        Toast.makeText(this, R.string.Q2_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q3 hint toast message
     */
    public void hintQ3(View view) {
        Toast.makeText(this, R.string.Q3_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q4 hint toast message
     */
    public void hintQ4(View view) {
        Toast.makeText(this, R.string.Q4_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q5 hint toast message
     */
    public void hintQ5(View view) {
        Toast.makeText(this, R.string.Q5_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q6 hint toast message
     */
    public void hintQ6(View view) {
        Toast.makeText(this, R.string.Q6_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q7 hint toast message
     */
    public void hintQ7(View view) {
        Toast.makeText(this, R.string.Q7_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q8 hint toast message
     */
    public void hintQ8(View view) {
        Toast.makeText(this, R.string.Q8_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q9 hint toast message
     */
    public void hintQ9(View view) {
        Toast.makeText(this, R.string.Q9_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Q10 hint toast message
     */
    public void hintQ10(View view) {
        Toast.makeText(this, R.string.Q10_hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * This method calculates the score after answers are submitted
     */
    public void calculateScore(View view) {
        String answerQ1;
        String answerQ2;
        String answerQ3;
        String answerQ4;
        String answerQ5;
        String answerQ6;
        String answerQ7;
        String answerQ8;
        String answerQ9;
        String answerQ10;
        boolean questionFour;
        boolean questionSeven;

        RadioButton questionOneAnswerThree = findViewById(R.id.Q1_answer_3);
        if (questionOneAnswerThree.isChecked()) {
            answerQ1 = "correct";
            score += 1;
        } else answerQ1 = "wrong";

        RadioButton questionTwoAnswerFour = findViewById(R.id.Q2_answer_4);
        if (questionTwoAnswerFour.isChecked()) {
            answerQ2 = "correct";
            score += 1;
        } else answerQ2 = "wrong";

        RadioButton questionThreeAnswerFour = findViewById(R.id.Q3_answer_4);
        if (questionThreeAnswerFour.isChecked()) {
            answerQ3 = "correct";
            score += 1;
        } else answerQ3 = "wrong";

        /**Q4 needs calculated separately to check if all four states are correct */
        questionFour = calculateQuestionFourScore();
        if (questionFour == true) {
            answerQ4 = "correct";
            score += 1;
        } else answerQ4 = "wrong";

        RadioButton questionFiveAnswerFour = findViewById(R.id.Q5_answer_4);
        if (questionFiveAnswerFour.isChecked()) {
            answerQ5 = "correct";
            score += 1;
        } else answerQ5 = "wrong";

        RadioButton questionSixAnswerThree = findViewById(R.id.Q6_answer_3);
        if (questionSixAnswerThree.isChecked()) {
            answerQ6 = "correct";
            score += 1;
        } else answerQ6 = "wrong";

        /**Q7 needs to be string matched */
        questionSeven = calculateQuestionSevenScore();
        if (questionSeven == true) {
            answerQ7 = "correct";
            score += 1;
        } else answerQ7 = "wrong";

        RadioButton questionEightAnswerOne = findViewById(R.id.Q8_answer_1);
        if (questionEightAnswerOne.isChecked()) {
            answerQ8 = "correct";
            score += 1;
        } else answerQ8 = "wrong";

        RadioButton questionNineAnswerFour = findViewById(R.id.Q9_answer_4);
        if (questionNineAnswerFour.isChecked()) {
            answerQ9 = "correct";
            score += 1;
        } else answerQ9 = "wrong";

        RadioButton questionTenAnswerTwo = findViewById(R.id.Q10_answer_2);
        if (questionTenAnswerTwo.isChecked()) {
            answerQ10 = "correct";
            score += 1;
        } else answerQ10 = "wrong";


        String resultsToastMessage = createResultsMessage(answerQ1, answerQ2, answerQ3, answerQ4, answerQ5, answerQ6, answerQ7, answerQ8, answerQ9, answerQ10);


    }

    /**
     * This method calculates the score after answers are submitted
     */
    private String createResultsMessage(String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String Q7, String Q8, String Q9, String Q10) {
        String resultsMessage = getString(R.string.summary_main_line, score);
        resultsMessage += "\n" + "\n" + getString(R.string.summary_Q1, Q1);
        resultsMessage += "\n" + getString(R.string.summary_Q2, Q2);
        resultsMessage += "\n" + getString(R.string.summary_Q3, Q3);
        resultsMessage += "\n" + getString(R.string.summary_Q4, Q4);
        resultsMessage += "\n" + getString(R.string.summary_Q5, Q5);
        resultsMessage += "\n" + getString(R.string.summary_Q6, Q6);
        resultsMessage += "\n" + getString(R.string.summary_Q7, Q7);
        resultsMessage += "\n" + getString(R.string.summary_Q8, Q8);
        resultsMessage += "\n" + getString(R.string.summary_Q9, Q9);
        resultsMessage += "\n" + getString(R.string.summary_Q10, Q10);

        Toast.makeText(this, resultsMessage, Toast.LENGTH_LONG).show();

        score = 0;

        return resultsMessage;
    }


    /**
     * This method calculates whether question four was answered correctly or not
     */

    private boolean calculateQuestionFourScore() {
        int questionFourScore = 0;
        boolean questionFourCorrect;

        CheckBox questionFourAnswerOne = findViewById(R.id.Q4_answer1);
        if (questionFourAnswerOne.isChecked()) {
            questionFourScore += 1;
        }

        CheckBox questionFourAnswerTwo = findViewById(R.id.Q4_answer2);
        if (questionFourAnswerTwo.isChecked()) {
            questionFourScore += 1;
        }

        CheckBox questionFourAnswerThree = findViewById(R.id.Q4_answer3);
        if (questionFourAnswerThree.isChecked()) {
            questionFourScore = questionFourScore - 1;
        }

        CheckBox questionFourAnswerFour = findViewById(R.id.Q4_answer4);
        if (questionFourAnswerFour.isChecked()) {
            questionFourScore += 1;
        }

        if (questionFourScore == 3) {
            questionFourCorrect = true;
        } else {
            questionFourCorrect = false;
        }

        return questionFourCorrect;
    }

    /**
     * This method calculates whether question seven was answered correctly or not
     */

    private boolean calculateQuestionSevenScore() {
        EditText questionThreeAnswer = (EditText) findViewById(R.id.Q7_answer_entry);
        String userAnswer = questionThreeAnswer.getText().toString().trim();
        boolean questionThreeCorrect;

        if (userAnswer.equals("1966")) {
            questionThreeCorrect = true;
        } else {
            questionThreeCorrect = false;
        }

        return questionThreeCorrect;
    }

    /**
     * This method resets the quiz
     */
    public void resetScore(View view) {
        RadioGroup answers_Q1 = (RadioGroup) findViewById(R.id.Q1_answer_group);
        answers_Q1.clearCheck();

        RadioGroup answers_Q2 = (RadioGroup) findViewById(R.id.Q2_answer_group);
        answers_Q2.clearCheck();

        RadioGroup answers_Q3 = (RadioGroup) findViewById(R.id.Q3_answer_group);
        answers_Q3.clearCheck();

        final CheckBox questionFourAnswerOne = (CheckBox) findViewById(R.id.Q4_answer1);
        if (questionFourAnswerOne.isChecked()) {
            questionFourAnswerOne.setChecked(false);
        }

        final CheckBox questionFourAnswerTwo = (CheckBox) findViewById(R.id.Q4_answer2);
        if (questionFourAnswerTwo.isChecked()) {
            questionFourAnswerTwo.setChecked(false);
        }

        final CheckBox questionFourAnswerThree = (CheckBox) findViewById(R.id.Q4_answer3);
        if (questionFourAnswerThree.isChecked()) {
            questionFourAnswerThree.setChecked(false);
        }

        final CheckBox questionFourAnswerFour = (CheckBox) findViewById(R.id.Q4_answer4);
        if (questionFourAnswerFour.isChecked()) {
            questionFourAnswerFour.setChecked(false);
        }

        RadioGroup answers_Q5 = (RadioGroup) findViewById(R.id.Q5_answer_group);
        answers_Q5.clearCheck();

        RadioGroup answers_Q6 = (RadioGroup) findViewById(R.id.Q6_answer_group);
        answers_Q6.clearCheck();

        EditText answer_Q7 = (EditText) findViewById(R.id.Q7_answer_entry);
        answer_Q7.getText().clear();

        RadioGroup answers_Q8 = (RadioGroup) findViewById(R.id.Q8_answer_group);
        answers_Q8.clearCheck();

        RadioGroup answers_Q9 = (RadioGroup) findViewById(R.id.Q9_answer_group);
        answers_Q9.clearCheck();

        RadioGroup answers_Q10 = (RadioGroup) findViewById(R.id.Q10_answer_group);
        answers_Q10.clearCheck();


        final ScrollView mainScrollView = (ScrollView)findViewById(R.id.main_scroll_view);
        mainScrollView.post(new Runnable() {
            public void run() {
                mainScrollView.scrollTo(0, 0);
            }
        });

        Toast.makeText(this, R.string.resetMessage, Toast.LENGTH_SHORT).show();


    }
}





