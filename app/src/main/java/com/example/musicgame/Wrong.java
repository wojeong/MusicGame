package com.example.musicgame;

import android.content.Intent;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class Wrong extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // change image
        Intent image = getIntent();

        String imageID = image.getExtras().getString("image");//name of the song
        int id = getResources().getIdentifier(imageID, "drawable", getPackageName());//matches the song name with actual song file
        Drawable drawable = getResources().getDrawable(id);//making R.Drawable.songName

        // pop up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);


        //image
        ImageView myImageView = (ImageView) findViewById(R.id.imageView);
        myImageView.setImageDrawable(drawable);

        // change title
        String title = image.getExtras().getString("title");

        TextView kDramaTitle = findViewById(R.id.txtTitleKDrama);
        kDramaTitle.setText(title);

        // end
        Button endbutton = (Button) findViewById(R.id.btnContinue);
        endbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}