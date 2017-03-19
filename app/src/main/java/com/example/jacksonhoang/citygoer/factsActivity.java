package com.example.jacksonhoang.citygoer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class factsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);
        TextView fact1 = (TextView) findViewById(R.id.fact1);
        fact1.setMovementMethod(new ScrollingMovementMethod());
    }

    public void mainSelection(View view) {
        Intent startmain = new Intent(this, MainActivity.class);
        startActivity(startmain);
    }
}
