package com.example.classcad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TimeTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
    }

    public void mon1(View view) {
        startActivity(new Intent(getApplicationContext(),monTT.class));
        finish();
    }

    public void backTT(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    public void tue1(View view) {
        startActivity(new Intent(getApplicationContext(),tueTT.class));
        finish();
    }
}