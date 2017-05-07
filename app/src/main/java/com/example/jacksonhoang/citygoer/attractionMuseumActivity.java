package com.example.jacksonhoang.citygoer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import layout.ArtFragment;
import layout.AviationFragment;
import layout.CapitalFragment;
import layout.FilmFragment;
import layout.NationalFragment;
import layout.TechFragment;


public class attractionMuseumActivity extends AppCompatActivity {

    ImageButton b1;

    public void init() {
        b1 = (ImageButton) findViewById(R.id.capitalMuseum1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CapitalFragment();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init2() {
        b1 = (ImageButton) findViewById(R.id.artMuseum1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ArtFragment();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init3() {
        b1 = (ImageButton) findViewById(R.id.nationalMuseum1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new NationalFragment();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init4() {
        b1 = (ImageButton) findViewById(R.id.filmMuseum1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FilmFragment();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init5() {
        b1 = (ImageButton) findViewById(R.id.aviationMuseum1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AviationFragment();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }
    public void init6() {
        b1 = (ImageButton) findViewById(R.id.techMuseum1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new TechFragment();
                FragmentTransaction map = getSupportFragmentManager().beginTransaction();
                map.replace(R.id.activity_main, fragment).commit();
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_museum);

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
        init6();
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
