package com.example.task1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Getting an intent
        Intent intent = getIntent();

        textView = findViewById(R.id.text2);

        textView.setText(intent.getStringExtra(MainActivity.EXTRA_TEXT));

    }
}
