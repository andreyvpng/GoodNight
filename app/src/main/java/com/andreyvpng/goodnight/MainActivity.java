package com.andreyvpng.goodnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    private OnClickListener playButton = new OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText text = findViewById(R.id.activity_main__input_timer);
            String str = text.getText().toString();
            RadioGroup colors_group = findViewById(R.id.activity_main__group_colors);
            RadioButton button_color = findViewById(colors_group.getCheckedRadioButtonId());

            Intent intent = new Intent(getApplicationContext(), NightLightActivity.class);
            intent.putExtra("TIMER", str);
            intent.putExtra("COLOR", button_color.getText().toString());
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton play_button = findViewById(R.id.activity_main__play_button);
        play_button.setOnClickListener(playButton);
    }


}
