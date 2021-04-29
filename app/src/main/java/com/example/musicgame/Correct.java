
package com.example.musicgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Correct extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // change image
        Intent image = getIntent();

        String imageID = image.getExtras().getString("title");//name of the song
        int id = getResources().getIdentifier(imageID, "drawable", getPackageName());//matches the song name with actual song file.
        Drawable drawable = getResources().getDrawable(id);//making R.Drawable.songName

        // pop up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correct);



        //image
        ImageView myImageView = (ImageView) findViewById(R.id.imageView);
        myImageView.setImageDrawable(drawable);

        // end
        Button endbutton = (Button) findViewById(R.id.btnContinue);
        endbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
