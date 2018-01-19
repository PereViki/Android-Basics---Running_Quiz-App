package com.example.android.runningquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] quizQuestions = new String[6];

        quizQuestions[0] = "1. kérdés";
        quizQuestions[1] = "2. kérdés";

        quizQuestions[4] = "5. kérdés";


        Log.i("MainActivity", "1st question: " + quizQuestions[0]);
        Log.i("MainActivity", "5th question: " + quizQuestions[4]);
    }

    // Upon clilking on the Start Quiz button the Quiz activity will open.

    public void startQuiz(View view) {
        Intent openQuiz = new Intent(this, Quiz.class);
                startActivity(openQuiz);
    }

}
