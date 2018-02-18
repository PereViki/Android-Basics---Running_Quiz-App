package com.example.android.runningquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String userName;
    EditText userNameTV;
    String text;
    int duration;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameTV = findViewById(R.id.userName);

    }

    // Upon clilking on the Start Quiz button the Quiz activity will open.
    public void startQuiz(View view) {
        userName = userNameTV.getText().toString();
        if (userName.equals("")) {
            text = getString(R.string.toast_message_username_error);
            duration = Toast.LENGTH_LONG;

            toast = Toast.makeText(this, text, duration);
            toast.show();
        } else {
            Intent openQuiz = new Intent(this, Quiz.class);
            openQuiz.putExtra("userName", userName);
            startActivity(openQuiz);
        }
    }
}
