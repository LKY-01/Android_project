package com.example.media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_play,btn_last,btn_next;
    Boolean ispause = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.music1);


        btn_play = findViewById(R.id.btn_play);
        btn_last = findViewById(R.id.btn_last);
        btn_next = findViewById(R.id.btn_next);
        btn_play.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying() && !ispause){
                    mediaPlayer.pause();
                    ispause=true;
                    btn_play.setImageResource(R.drawable.stop);
                }
                else {
                    mediaPlayer.start();
                    ispause=false;
                    btn_play.setImageResource(R.drawable.on);
                }
            }
        });

        btn_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mediaPlayer.reset();
//                try {
//                    mediaPlayer.setDataSource(file.getAbsolutePath());
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }

//    @Override
//    protected void onDestroy() {
//        if (mediaPlayer.isPlaying()){
//            mediaPlayer.stop();
//        }
//        mediaPlayer.release();
//        super.onDestroy();
//    }
}
