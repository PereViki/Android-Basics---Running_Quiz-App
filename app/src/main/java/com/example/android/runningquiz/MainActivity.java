package com.example.android.runningquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Upon clilking on the Start Quiz button the Quiz activity will open.

    public void startQuiz(View view) {
        Intent openQuiz = new Intent(this, Quiz.class);
                startActivity(openQuiz);
    }

}
