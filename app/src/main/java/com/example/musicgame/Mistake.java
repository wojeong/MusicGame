package com.example.musicgame;

import android.app.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Mistake extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // change image
        Intent image = getIntent();

        // pop up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mistake);


        // change title
        int counter = image.getExtras().getInt("count");

        TextView kDramaTitle = findViewById(R.id.mistakeCount);
        kDramaTitle.setText(counter + "/ 3");

        // end
        Button endbutton = (Button) findViewById(R.id.btnContinue);
        endbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}