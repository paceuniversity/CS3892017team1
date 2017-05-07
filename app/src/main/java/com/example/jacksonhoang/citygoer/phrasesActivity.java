package com.example.jacksonhoang.citygoer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


public class phrasesActivity extends AppCompatActivity {

    Button translateButton;
    TextView translatedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        translateButton = (Button)findViewById(R.id.translateButton);
        translatedText =(TextView)findViewById(R.id.translatedText);
        translateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                translatedText.setText(getMessageToTranslate());
            }
        });
    }

    public String getMessageToTranslate() {
        EditText messageToTranslate = (EditText) findViewById(R.id.messageToTranslate);
        String textToTranslate = messageToTranslate.getText().toString();
        return textToTranslate;
    }


}
