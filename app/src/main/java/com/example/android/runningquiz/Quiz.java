package com.example.android.runningquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    RadioButton rb1_1;
    RadioButton rb1_2;
    RadioButton rb1_3;
    RadioButton rb1_4;
    RadioButton rb2_1;
    RadioButton rb2_2;
    RadioButton rb2_3;
    RadioButton rb2_4;
    CheckBox cb3_1;
    CheckBox cb3_2;
    CheckBox cb3_3;
    CheckBox cb3_4;
    CheckBox cb4_1;
    CheckBox cb4_2;
    CheckBox cb4_3;
    CheckBox cb4_4;
    EditText et1;
    String et1Text;
    CharSequence text;
    int duration;
    Toast toast;
    Intent openResult;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rb1_1 = findViewById(R.id.wrong_answer_1_1);
        rb1_2 = findViewById(R.id.wrong_answer_1_2);
        rb1_3 = findViewById(R.id.right_answer_1_3);
        rb1_4 = findViewById(R.id.wrong_answer_1_4);
        rb2_1 = findViewById(R.id.wrong_answer_2_1);
        rb2_2 = findViewById(R.id.right_answer_2_2);
        rb2_3 = findViewById(R.id.wrong_answer_2_3);
        rb2_4 = findViewById(R.id.wrong_answer_2_4);
        cb3_1 = findViewById(R.id.right_answer_3_1);
        cb3_2 = findViewById(R.id.wrong_answer_3_2);
        cb3_3 = findViewById(R.id.wrong_answer_3_3);
        cb3_4 = findViewById(R.id.right_answer_3_4);
        cb4_1 = findViewById(R.id.right_answer_4_1);
        cb4_2 = findViewById(R.id.right_answer_4_2);
        cb4_3 = findViewById(R.id.right_answer_4_3);
        cb4_4 = findViewById(R.id.wrong_answer_4_4);
        et1 = findViewById(R.id.right_answer_5);


        userName = getIntent().getExtras().getString("userName");

    }

    public void submitAnswers(View view) {

        int points = 0;

        if ((rb1_1.isChecked() || rb1_2.isChecked() || rb1_3.isChecked() || rb1_4.isChecked())
                && (rb2_1.isChecked() || rb2_2.isChecked() || rb2_3.isChecked() || rb2_4.isChecked())
                && (cb3_1.isChecked() || cb3_2.isChecked() || cb3_3.isChecked() || cb3_4.isChecked())
                && (cb4_1.isChecked() || cb4_2.isChecked() || cb4_3.isChecked() || cb4_4.isChecked())
                && !et1.getText().toString().equals("")) {

            // Check first answer - RADIO BUTTON

            if (rb1_3.isChecked()) {
                points += 1;
            }

            // Check second answer RADIO BUTTON

            if (rb2_2.isChecked()) {
                points += 1;
            }

            // Check third answers CHECKBOXES

            if (cb3_1.isChecked() && !cb3_2.isChecked() && !cb3_3.isChecked() && cb3_4.isChecked()) {
                points += 1;
            }

            // Check fourth answers CHECKBOXES

            if (cb4_1.isChecked() && cb4_2.isChecked() && cb4_3.isChecked() && !cb4_4.isChecked()) {
                points += 1;
            }

            // Check fifth answer EDIT TEXT

            et1Text = et1.getText().toString();
            String rightAnswer = getString(R.string.answer_5_a);
            if (et1Text.equals(rightAnswer)) {
                points += 1;
            }

            // Calculate result

            text = getString(R.string.toast_message, points);
            duration = Toast.LENGTH_LONG;

            toast = Toast.makeText(this, text, duration);
            toast.show();

            openResult = new Intent(this, Result.class);
            openResult.putExtra("points", points);
            openResult.putExtra("userName", userName);
            startActivity(openResult);

        } else {
            text = getString(R.string.toast_message_fill_error);
            duration = Toast.LENGTH_LONG;

            toast = Toast.makeText(this, text, duration);
            toast.show();
        }
    }
}
