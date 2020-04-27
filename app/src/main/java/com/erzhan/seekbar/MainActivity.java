package com.erzhan.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView score, seekBarText;
    TextView answer;
    Button button;
    static int scoreInt = 0;
    int x, differ, differ1;
    final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        seekBar = findViewById(R.id.seekBar);
        score = findViewById(R.id.score);
        answer = findViewById(R.id.answer);
        button = findViewById(R.id.click);
        seekBarText = findViewById(R.id.seekBarText);
        x = random.nextInt((100) + 1);
        differ = x - 10;
        differ1 = x + 10;

        Log.d("ololo", "otvet: " + differ);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x == seekBar.getProgress()) {
                    answer.setText("Сорвал КУШ! \n + 500 очков");
                    scoreInt = scoreInt + 500;
                    score.setText(String.valueOf(scoreInt));
                } else if (differ <= seekBar.getProgress() && differ1 >= seekBar.getProgress()) {
                    answer.setText("Близко,но мимо \n +50 очков");
                    scoreInt = scoreInt + 50;
                    score.setText(String.valueOf(scoreInt));
                } else {
                    answer.setText("Не угадал \n -10 очков");
                    scoreInt = scoreInt - 10;
                    score.setText(String.valueOf(scoreInt));
                }
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarText.setText("" + progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });


    }

}

