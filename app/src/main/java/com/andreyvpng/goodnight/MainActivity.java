package com.andreyvpng.goodnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main__menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_start) {
            EditText text = findViewById(R.id.activity_main__input_timer);
            String str = text.getText().toString();


            Intent intent = new Intent(this, NightLightActivity.class);
            intent.putExtra("TIMER", str);
            startActivity(intent);
        }
        return true;
    }
}
