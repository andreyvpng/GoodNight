package com.andreyvpng.goodnight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Objects;

public class NightLightActivity extends AppCompatActivity {

    public int getColorByName(String name) {
        int colorId = 0;

        try {
            Class res = R.color.class;
            Field field = res.getField(name);
            colorId = field.getInt(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return colorId;
    }

    void setBackground(Intent intent) {
        String color = Objects.requireNonNull(intent.getStringExtra("COLOR")).toLowerCase();
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(getColorByName(color)));
    }

    void setTimer(Intent intent) {
        String timer_str = intent.getStringExtra("TIMER");
        int timer_time;
        if (timer_str != null && !Objects.equals(timer_str, ""))
            timer_time = Integer.parseInt(timer_str);
        else
            timer_time = 0;

        new CountDownTimer(1000 * 60 * timer_time, 1000) {
            TextView textView = findViewById(R.id.activity_night_light__textView);
            @SuppressLint("DefaultLocale")
            public void onTick(long millisUntilFinished) {
                int minutes = (int) (millisUntilFinished / (60 * 1000));
                int seconds = (int) (millisUntilFinished / 1000);

                if (minutes != 0) {
                    seconds -= 60 * minutes;
                }
                textView.setText(String.format("%d:%d", minutes, seconds));
            }

            public void onFinish() {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                Toast.makeText(getApplicationContext(), "DONE", Toast.LENGTH_SHORT).show();
                finish();
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_light);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Intent intent = getIntent();
        setBackground(intent);
        setTimer(intent);
    }
}
