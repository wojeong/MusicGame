package com.example.musicgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TopicSelection extends AppCompatActivity {
    private Button btnKorean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);

        btnKorean = (Button) findViewById(R.id.btnKdrama);
        btnKorean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openAfterKoreanDrama(); }
        });
    }

    public void openAfterKoreanDrama() {
        Intent intent = new Intent(this, KoreanOST.class);
        startActivity(intent);
    }
}