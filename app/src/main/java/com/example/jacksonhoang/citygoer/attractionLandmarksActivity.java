package com.example.jacksonhoang.citygoer;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import layout.ForbiddenCity;
import layout.MingTombs;
import layout.SummerPalace;
import layout.TempleOfHeaven;
import layout.greatwall_fragment;


public class attractionLandmarksActivity extends AppCompatActivity {

    ImageButton b1;

    public void init() {
        b1 = (ImageButton) findViewById(R.id.greatWall1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new greatwall_fragment();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init2() {
        b1 = (ImageButton) findViewById(R.id.forbiddenCity1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ForbiddenCity();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init3() {
        b1 = (ImageButton) findViewById(R.id.templeOfHeaven1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new TempleOfHeaven();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init4() {
        b1 = (ImageButton) findViewById(R.id.mingTombs1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MingTombs();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init5() {
        b1 = (ImageButton) findViewById(R.id.summerPalace1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SummerPalace();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_landmarks);

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
        init2();
        init3();
        init4();
        init5();
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
