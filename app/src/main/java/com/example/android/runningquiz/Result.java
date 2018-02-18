package com.example.android.runningquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    int finalPoints;
    int percent;
    TextView resultPercentage;
    String userName;
    Intent mailIntent;
    String mailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        finalPoints = getIntent().getExtras().getInt("points");
        percent = (finalPoints * 100) / 5;

        resultPercentage = findViewById(R.id.result_percentage);
        resultPercentage.setText(percent + getString(R.string.percent));

        userName = getIntent().getExtras().getString("userName");
    }

    // Composing an e-mail with the results
    // and the correct answers
    public void sendResult(View view) {

        mailBody = getString(R.string.email_body_1, userName) +
                "\n" + getString(R.string.email_body_2) + resultPercentage.getText() +
                "\n\n" + getString(R.string.email_body_7)
                +
                "\n\n" + getText(R.string.question_1) +
                "\n" + getText(R.string.answer_1_c)
                +
                "\n\n" + getText(R.string.question_2) +
                "\n" + getText(R.string.answer_2_b)
                +
                "\n\n" + getText(R.string.question_3) +
                "\n" + getText(R.string.answer_3_a) + getText(R.string.email_body_3) +
                "\n" + getText(R.string.answer_3_d)
                +
                "\n\n" + getText(R.string.question_4) +
                "\n" + getText(R.string.answer_4_a) + getText(R.string.email_body_3) +
                "\n" + getText(R.string.answer_4_b) + getText(R.string.email_body_3) +
                "\n" + getText(R.string.answer_4_c)
                +
                "\n\n" + getText(R.string.question_5) +
                "\n" + getText(R.string.answer_5_a)
                +
                "\n\n" + getString(R.string.email_body_4) +
                "\n" + getString(R.string.email_body_6);

        mailIntent = new Intent(Intent.ACTION_SENDTO);
        mailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject, userName));
        mailIntent.putExtra(Intent.EXTRA_TEXT, mailBody);
        if (mailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mailIntent);
        }
    }
}
