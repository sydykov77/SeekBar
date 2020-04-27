package com.erzhan.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView score,seekBarText;
    TextView answer;
    Button button;
    static int scoreInt;
    Integer x;
    final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        seekBar = findViewById(R.id.seekBar);
        score = findViewById(R.id.score);
        answer = findViewById(R.id.answer);
        button = findViewById(R.id.click);
        seekBarText=findViewById(R.id.seekBarText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seekBar.getProgress() == random.nextInt(101)) {
                    scoreInt = scoreInt + 500;
                    answer.setText("В точку!+ 500 очков!");
                } else {
                    scoreInt = scoreInt - 50;
                    answer.setText("Попробуй еще раз!");
                }

            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarText.setText("" + progress );



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}

