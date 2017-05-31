package org.androidtown.a20170525_lab7;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//   Declare LinearLayout for music list.
    LinearLayout L1;
    LinearLayout L2;

//   Declare MediaPlayer.
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Find LinearLayout by id.
        L1 = (LinearLayout)findViewById(R.id.m1);
        L2 = (LinearLayout)findViewById(R.id.m2);

//        When pressed L1 LinearLayout, change background color and start music1.
        L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Change background color for LinearLayout.
//                L1 -> Gray
//                L2 -> Transparent color
                L1.setBackgroundColor(Color.argb(5, 0, 0, 0));
                L2.setBackgroundColor(Color.argb(0, 0, 0, 0));

//                Already the music is playing, then stop music.
                if(mp!=null && mp.isPlaying())
                    mp.stop();

//                Set music1 file.
                int id = getResources().getIdentifier((String)L1.getTag(), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), id);

//                Start music.
                mp.start();

//                Toast the message.
                Toast.makeText(MainActivity.this, "Background Music #1 START!", Toast.LENGTH_SHORT).show();
            }
        });

//        When pressed L2 LinearLayout, change background color and start music2.
        L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Change background color for LinearLayout.
//                L1 -> Transparent color
//                L2 -> Gray
                L1.setBackgroundColor(Color.argb(0, 0, 0, 0));
                L2.setBackgroundColor(Color.argb(5, 0, 0, 0));

//                Already the music is playing, then stop music.
                if(mp!=null && mp.isPlaying())
                    mp.stop();

//                Set music2 file.
                int id = getResources().getIdentifier((String)L2.getTag(), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), id);

//                Start music.
                mp.start();

//                Toast the message.
                Toast.makeText(MainActivity.this, "Background Music #2 START!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
