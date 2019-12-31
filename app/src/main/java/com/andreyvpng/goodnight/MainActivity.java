package com.andreyvpng.goodnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        FloatingActionButton play_button = findViewById(R.id.activity_main__play_button);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = findViewById(R.id.activity_main__input_timer);
                String str = text.getText().toString();


                Intent intent = new Intent(getApplicationContext(), NightLightActivity.class);
                intent.putExtra("TIMER", str);
                startActivity(intent);
            }
        });
    }
}
