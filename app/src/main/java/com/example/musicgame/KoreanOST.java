package com.example.musicgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class KoreanOST extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button btnCheck;
    private String title;
    private final ArrayList<KdramaInfo> kDrama = new ArrayList<>();
    private int random = 0;
    private int count = 1;
    private int errorCount = 0;
    private final int number = 15;
    private int point = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korean_o_s_t);

        // class
        kDrama.add(new KdramaInfo("Are You Human Too", R.raw.love, "are_you_human_too"));
        kDrama.add(new KdramaInfo("Goblin", R.raw.stay_with_me, "goblin"));
        kDrama.add(new KdramaInfo("Boys Over Flowers", R.raw.paradise, "boys_over_flowers"));
        kDrama.add(new KdramaInfo("Crash Landing on You", R.raw.give_you_my_heart, "crash_landing_on_you"));
        kDrama.add(new KdramaInfo("Descendants of the Sun", R.raw.you_are_my_everything, "descendants_of_the_sun"));
        kDrama.add(new KdramaInfo("Hotel Del Luna", R.raw.remember_me, "hotel_del_luna"));
        kDrama.add(new KdramaInfo("It's Okay to Not Be Okay", R.raw.you_are_cold, "its_okay_to_not_be_okay"));
        kDrama.add(new KdramaInfo("Moon Lovers", R.raw.say_yes, "moon_lovers"));
        kDrama.add(new KdramaInfo("My love from the star", R.raw.my_destiny, "my_love_from_the_star"));
        kDrama.add(new KdramaInfo("Oh Hae Young Again", R.raw.if_it_is_you, "oh_hae_young_again"));
        kDrama.add(new KdramaInfo("Princess Hours", R.raw.perhaps_love, "princess_hours"));
        kDrama.add(new KdramaInfo("Start Up", R.raw.one_day, "start_up"));
        kDrama.add(new KdramaInfo("Master's Sun", R.raw.touch_love, "masters_sun"));
        kDrama.add(new KdramaInfo("Suspicious Partner", R.raw.how_do_you_say, "suspicious_partner"));
        kDrama.add(new KdramaInfo("Who Are You school 2015", R.raw.reset, "who_are_you_school_2015"));

        randomize();

        // music play
        Button playButton = (Button) findViewById(R.id.btnMusicPlay);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(KoreanOST.this, "The song is over", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // music stop
        Button pauseButton = (Button) findViewById(R.id.btnMusicPause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        // check
        EditText titleInput = (EditText) findViewById(R.id.plaintxtTitle);
        EditText pointText = (EditText) findViewById(R.id.pointText);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.equalsIgnoreCase(titleInput.getText().toString())) {

                    Intent correct = new Intent (KoreanOST.this, Correct.class);
                    correct.putExtra("title", kDrama.get(random).getImage());
                    startActivity(correct);

//                    Toast.makeText(KoreanOST.this, title, Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();

                    if (count <number)
                        randomize();

                    if(errorCount == 0)
                        point += 100;
                    else if(errorCount == 1)
                        point += 70;
                    else if(errorCount == 2)
                        point += 30;


                    ++count;
                    errorCount = 0;
                } else if (errorCount < 2) {
                    mediaPlayer.pause();
                    ++errorCount;

                    Intent mistake = new Intent (KoreanOST.this, Mistake.class);
                    mistake.putExtra("count", errorCount);
                    startActivity(mistake);
                }else {
                    Intent wrong = new Intent (KoreanOST.this, Wrong.class);
                    wrong.putExtra("image", kDrama.get(random).getImage());
                    wrong.putExtra("title", kDrama.get(random).getTitle());
                    startActivity(wrong);

                    mediaPlayer.stop();
                    randomize();
                    errorCount = 0;
                }
                titleInput.setText("");
                pointText.setText("Point : " + point);
            }


        });
    }

    public void randomize() {

        do {
            random = (int) (number * Math.random());
        } while (!kDrama.get(random).isAvailable());

        kDrama.get(random).setAvailable(false);

        title = kDrama.get(random).getTitle();

        mediaPlayer = MediaPlayer.create(this, kDrama.get(random).getMp3Title());
    }
}