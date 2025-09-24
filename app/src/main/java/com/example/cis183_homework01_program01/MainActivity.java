package com.example.cis183_homework01_program01;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//==================================================================
//Author: Allison DeCarlo
//Date  : 10/05/2025
//Desc  : RGB Homework02
//==================================================================
public class MainActivity extends AppCompatActivity
{
    TextView tv_j_redNum;
    TextView tv_j_greenNum;
    TextView tv_j_blueNum;
    TextView tv_j_hex;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hexRep;
    Button btn_j_save;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;

    int redProgress = 0;
    int greenProgress = 0;
    int blueProgress = 0;

    String hexFinal;

    ConstraintLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_j_redNum = findViewById(R.id.tv_v_redNum);
        tv_j_greenNum = findViewById(R.id.tv_v_greenNum);
        tv_j_blueNum = findViewById(R.id.tv_v_blueNum);
        tv_j_hex = findViewById(R.id.tv_v_hex);
        tv_j_hexRep = findViewById(R.id.tv_v_hexRep);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        btn_j_save = findViewById(R.id.btn_v_save);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        main = findViewById(R.id.main);

        SliderChangeListener();

    }

    public void SliderChangeListener()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                tv_j_redNum.setText(String.valueOf(progress));
                redProgress = progress;
                RGBHexConverter();
                String hex = "#" + hexFinal;
                main.setBackgroundColor(Color.parseColor(hex));
                BackgroundTextColorChanger();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                tv_j_greenNum.setText(String.valueOf(progress));
                greenProgress = progress;
                RGBHexConverter();
                String hex = "#" + hexFinal;
                main.setBackgroundColor(Color.parseColor(hex));
                BackgroundTextColorChanger();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                tv_j_blueNum.setText(String.valueOf(progress));
                blueProgress = progress;
                RGBHexConverter();
                String hex = "#" + hexFinal;
                main.setBackgroundColor(Color.parseColor(hex));
                BackgroundTextColorChanger();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    public void BackgroundTextColorChanger()
    {
        //Info is from stackoverflow.com in a post titled
        //"Formula to determine perceived brightness of RGB color"
        //https://stackoverflow.com/questions/596216/formula-to-determine-perceived-brightness-of-rgb-color

        //the brain contributes around 30% of the brightness to red colors, 59% for green,
        //and 11% for blue
        double brightnessLevel = 0.299 * redProgress + 0.587 * greenProgress + 0.114 * blueProgress;

        if(brightnessLevel < 128)
        {
            tv_j_hexRep.setTextColor(Color.WHITE);
            tv_j_red.setTextColor(Color.WHITE);
            tv_j_green.setTextColor(Color.WHITE);
            tv_j_blue.setTextColor(Color.WHITE);
            tv_j_redNum.setTextColor(Color.WHITE);
            tv_j_greenNum.setTextColor(Color.WHITE);
            tv_j_blueNum.setTextColor(Color.WHITE);
            tv_j_hex.setTextColor(Color.WHITE);
        }
        if(brightnessLevel > 128)
        {
            tv_j_hexRep.setTextColor(Color.BLACK);
            tv_j_red.setTextColor(Color.BLACK);
            tv_j_green.setTextColor(Color.BLACK);
            tv_j_blue.setTextColor(Color.BLACK);
            tv_j_redNum.setTextColor(Color.BLACK);
            tv_j_greenNum.setTextColor(Color.BLACK);
            tv_j_blueNum.setTextColor(Color.BLACK);
            tv_j_hex.setTextColor(Color.BLACK);
        }


    }

    public void RGBHexConverter()
    {
        int firstRedDigit = redProgress / 16;
        int secondRedDigit = redProgress % 16;
        int firstGreenDigit = greenProgress / 16;
        int secondGreenDigit = greenProgress % 16;
        int firstBlueDigit = blueProgress / 16;
        int secondBlueDigit = blueProgress % 16;
        String r1 = "";
        String r2 = "";
        String g1 = "";
        String g2 = "";
        String b1 = "";
        String b2 = "";


        //===============================
        //RED
        //===============================
        if(firstRedDigit > 9)
        {
            if(firstRedDigit == 10)
            {
                r1 = "A";
            }

            if(firstRedDigit == 11)
            {
                r1 = "B";
            }

            if(firstRedDigit == 12)
            {
                r1 = "C";
            }

            if(firstRedDigit == 13)
            {
                r1 = "D";
            }

            if(firstRedDigit == 14)
            {
                r1 = "E";
            }

            if(firstRedDigit == 15)
            {
                r1 = "F";
            }
        }
        else if(firstRedDigit <= 9)
        {
            r1 = String.valueOf(firstRedDigit);
        }

        if(secondRedDigit > 9)
        {
            if(secondRedDigit == 10)
            {
                r2 = "A";
            }

            if(secondRedDigit == 11)
            {
                r2 = "B";
            }

            if(secondRedDigit == 12)
            {
                r2 = "C";
            }

            if(secondRedDigit == 13)
            {
                r2 = "D";
            }

            if(secondRedDigit == 14)
            {
                r2 = "E";
            }

            if(secondRedDigit == 15)
            {
                r2 = "F";
            }
        }
        else if(secondRedDigit <= 9)
        {
            r2 = String.valueOf(secondRedDigit);
        }

        //===============================
        //GREEN
        //===============================

        if(firstGreenDigit > 9)
        {
            if(firstGreenDigit == 10)
            {
                g1 = "A";
            }

            if(firstGreenDigit == 11)
            {
                g1 = "B";
            }

            if(firstGreenDigit == 12)
            {
                g1 = "C";
            }

            if(firstGreenDigit == 13)
            {
                g1 = "D";
            }

            if(firstGreenDigit == 14)
            {
                g1 = "E";
            }

            if(firstGreenDigit == 15)
            {
                g1 = "F";
            }
        }
        else if(firstGreenDigit <= 9)
        {
            g1 = String.valueOf(firstGreenDigit);
        }

        if(secondGreenDigit > 9)
        {
            if(secondGreenDigit == 10)
            {
                g2 = "A";
            }

            if(secondGreenDigit == 11)
            {
                g2 = "B";
            }

            if(secondGreenDigit == 12)
            {
                g2 = "C";
            }

            if(secondGreenDigit == 13)
            {
                g2 = "D";
            }

            if(secondGreenDigit == 14)
            {
                g2 = "E";
            }

            if(secondGreenDigit == 15)
            {
                g2 = "F";
            }
        }
        else if(secondGreenDigit <= 9)
        {
            g2 = String.valueOf(secondGreenDigit);
        }

        //===============================
        //BLUE
        //===============================

        if(firstBlueDigit > 9)
        {
            if(firstBlueDigit == 10)
            {
                b1 = "A";
            }

            if(firstBlueDigit == 11)
            {
                b1 = "B";
            }

            if(firstBlueDigit == 12)
            {
                b1 = "C";
            }

            if(firstBlueDigit == 13)
            {
                b1 = "D";
            }

            if(firstBlueDigit == 14)
            {
                b1 = "E";
            }

            if(firstBlueDigit == 15)
            {
                b1 = "F";
            }
        }
        else if(firstBlueDigit <= 9)
        {
            b1 = String.valueOf(firstBlueDigit);
        }

        if(secondBlueDigit > 9)
        {
            if(secondBlueDigit == 10)
            {
                b2 = "A";
            }

            if(secondBlueDigit == 11)
            {
                b2 = "B";
            }

            if(secondBlueDigit == 12)
            {
                b2 = "C";
            }

            if(secondBlueDigit == 13)
            {
                b2 = "D";
            }

            if(secondBlueDigit == 14)
            {
                b2 = "E";
            }

            if(secondBlueDigit == 15)
            {
                b2 = "F";
            }
        }
        else if(secondBlueDigit <= 9)
        {
            b2 = String.valueOf(secondBlueDigit);
        }

        hexFinal = r1 + r2 + g1 + g2 + b1 + b2;
        tv_j_hex.setText(hexFinal);
    }
}