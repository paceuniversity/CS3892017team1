package com.example.jacksonhoang.citygoer;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.Category;
import com.yelp.clientlib.entities.SearchResponse;
import com.yelp.clientlib.entities.options.CoordinateOptions;
import com.yelp.clientlib.exception.exceptions.UnavailableForLocation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;

public class foodActivity3 extends AppCompatActivity {

    ImageView mMainImage;
    TextView mTitle;
    TextView mCostCat;
    ProgressBar mLoading;
    private OkHttpClient mClient;
    final private String restaurantsKey = "RESTAURANTS_KEY";
    private int i;
    private int iLast;
    private List<Restaurant> mRestaurants = new ArrayList<>();
    YelpAPIFactory apiFactory = new YelpAPIFactory(
            getString(R.string.consumerKey),
            getString(R.string.consumerSecret),
            getString(R.string.token),
            getString(R.string.tokenSecret));
    YelpAPI yelpAPI = apiFactory.createAPI();
    Map<String, String> params;
    CoordinateOptions coordinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food3);

        mMainImage = (ImageView) findViewById(com.example.jacksonhoang.citygoer.R.id.mainImage);
        mTitle = (TextView) findViewById(com.example.jacksonhoang.citygoer.R.id.restaurantLabel);
        mCostCat = (TextView) findViewById(com.example.jacksonhoang.citygoer.R.id.costCatLabel);
        mLoading = (ProgressBar) findViewById(com.example.jacksonhoang.citygoer.R.id.loading);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mRestaurants = savedInstanceState.getParcelableArrayList(restaurantsKey);

        params = new HashMap<>();
        params.put("term", "food");

        mMainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRestaurants.size() > i) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(mRestaurants.get(i).getMainUrl()));
                    startActivity(intent);
                }
            }
        });

        initLocation();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

    public void initLocation() {
        new foodActivity3.searchFood().execute("0");

        coordinate = CoordinateOptions.builder()
                .latitude(37.7577)
                .longitude(-122.4376).build();
    }

    public void loadingScreen() {
        mMainImage.setImageResource(android.R.color.transparent);
        mCostCat.setText("");
        mTitle.setText("");
        mLoading.setVisibility(View.VISIBLE);
    }


    class searchFood extends AsyncTask<String, Restaurant, String> {

        List<Restaurant> restaurants = null;

        @Override
        protected String doInBackground(String... strings) {
            String page = strings[0];
            params.put("offset", page);
            Call<SearchResponse> call = yelpAPI.search(coordinate, params);
            Response<SearchResponse> response = null;
            try {
                response = call.execute();
            } catch (UnavailableForLocation e) {
                publishProgress(null);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            if (response != null) {
                restaurants = new ArrayList<>();
                List<Business> businesses = response.body().businesses();
                Collections.shuffle(businesses, new Random(System.nanoTime()));
                for (Business b : businesses) {
                    Restaurant r = new Restaurant(b.name(), b.url());
                    r.setCostCat(b.rating() + " " + categoriesToString(b.categories()));
                    restaurants.add(r);
                }
            }
            return null;
        }

        private String categoriesToString(List<Category> cats) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cats.size(); i++) {
                sb.append(cats.get(i).name());
                if (i != cats.size() - 1) {
                    sb.append(", ");
                }
            }
            return sb.toString();
        }

    }
}