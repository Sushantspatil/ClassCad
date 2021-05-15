package com.example.classcad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class wedTT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wed_t_t);
    }

    public void backwed1(View view) {
        startActivity(new Intent(getApplicationContext(),TimeTable.class));
        finish();
    }
}