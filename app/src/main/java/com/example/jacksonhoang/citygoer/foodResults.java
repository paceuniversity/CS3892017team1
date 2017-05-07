package com.example.jacksonhoang.citygoer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import layout.greatwall_fragment;

public class foodResults extends AppCompatActivity {

    ImageButton b1;

    public void init() {
        b1 = (ImageButton) findViewById(R.id.foodaddress);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FoodAddress();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }

    public void init1() {
        b1 = (ImageButton) findViewById(R.id.foodaddress1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FoodAddress();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }

    public void init2() {
        b1 = (ImageButton) findViewById(R.id.foodaddress2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FoodAddress();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }

    public void init3() {
        b1 = (ImageButton) findViewById(R.id.foodaddress3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FoodAddress();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_results);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        init();
        init1();
        init2();
        init3();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
