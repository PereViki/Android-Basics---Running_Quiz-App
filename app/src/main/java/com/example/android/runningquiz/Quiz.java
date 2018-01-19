package com.example.android.runningquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void submitAnswers(View view) {

        int points = 0;

        /*
        Check first answer - RADIO BUTTON
         */

        RadioButton rb1 = findViewById(R.id.right_answer_1);
        if (rb1.isChecked()) {
            points += 1;
            Log.i("QuizActivity", "1. Pontok: " + points);
        }

        /*
        Check second answer RADIO BUTTON
         */

        RadioButton rb2 = findViewById(R.id.right_answer_2);
        if (rb2.isChecked()) {
            points += 1;
            Log.i("QuizActivity", "2. Pontok: " + points);
        }

          /*
        Check third answers CHECKBOXES
         */

        CheckBox cb3_1 = findViewById(R.id.right_answer_3_1);
        CheckBox cb3_2 = findViewById(R.id.wrong_answer_3_2);
        CheckBox cb3_3 = findViewById(R.id.wrong_answer_3_3);
        CheckBox cb3_4 = findViewById(R.id.right_answer_3_4);
        if (cb3_1.isChecked() && !cb3_2.isChecked() && !cb3_3.isChecked() && cb3_4.isChecked()) {
            points += 1;
            Log.i("QuizActivity", "3. Pontok: " + points);
        }

        /*
        Check fourth answers CHECKBOXES
         */

        CheckBox cb4_1 = findViewById(R.id.right_answer_4_1);
        CheckBox cb4_2 = findViewById(R.id.right_answer_4_2);
        CheckBox cb4_3 = findViewById(R.id.right_answer_4_3);
        CheckBox cb4_4 = findViewById(R.id.wrong_answer_4_4);
        if (cb4_1.isChecked() && cb4_2.isChecked() && cb4_3.isChecked() && !cb4_4.isChecked()) {
            points += 1;
            Log.i("QuizActivity", "4. Pontok: " + points);
        }

        /*
        Check fifth answer EDIT TEXT
         */

        EditText et1 = findViewById(R.id.right_answer_5);
        String et1Text = et1.getText().toString();
        String rightAnswer = getString(R.string.answer_5_a);
        if (et1Text.equals(rightAnswer)) {
            points += 1;
            Log.i("QuizActivity", "5. Pontok: " + points);
        }

         /*
        Calculate result
         */

        CharSequence text = getString(R.string.toast_message, points);
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();

        Intent openResult = new Intent(this, Result.class);
        openResult.putExtra("points", points);
        startActivity(openResult);
    }
}
