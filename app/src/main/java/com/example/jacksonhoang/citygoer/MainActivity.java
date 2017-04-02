package com.example.jacksonhoang.citygoer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void phraseSelection(View view) {
        Intent startPhrase = new Intent(this, phrasesActivity.class);
        startActivity(startPhrase);
    }

    public void foodSelection(View view) {
        Intent startFood = new Intent(this, foodActivity.class);
        startActivity(startFood);
    }

    public void attractionSelection(View view) {
        Intent startAttraction = new Intent(this, attractionActivity.class);
        startActivity(startAttraction);
    }

    public void factsSelection(View view) {
        Intent startAttraction = new Intent(this, factsActivity.class);
        startActivity(startAttraction);
    }
}
