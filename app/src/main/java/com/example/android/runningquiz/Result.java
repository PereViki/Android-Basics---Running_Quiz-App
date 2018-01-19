package com.example.android.runningquiz;

import android.net.wifi.aware.PublishConfig;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int finalPoints = getIntent().getExtras().getInt("points");
        int percent = (finalPoints * 100) / 5;

        TextView resultPercentage = (TextView) findViewById(R.id.result_percentage);
        resultPercentage.setText(percent + "%");
    }



}
