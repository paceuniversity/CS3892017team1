package com.example.jacksonhoang.citygoer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class factsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);

        FirebaseDatabase db = FirebaseDatabase.getInstance();

      // DatabaseReference ref =    db.getReference("https://citygoer-518e1.firebaseio.com/");



        DatabaseReference myRef = db.getReference("Fact1");

        //System.out.println(db.toString());

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        TextView fact1 = (TextView) findViewById(R.id.facts_text);
        fact1.setText(myRef.getKey());

        /** final ArrayList<String> facts =new ArrayList<String>();
         facts.add("Beijing is the capital of the People's republic of China");
         facts.add("Bei means northern and jin means capital. Thus, Beijing literally means the north capital");
         facts.add("It is home to the world's longest wall");
         facts.add("Beijing's Forbidden City is the largest palace in the world");
         facts.add("Bejing was the capital for more than 6 dynsaties and governments");
         facts.add("Has 13 suburban districts: Changping, Daxing, Dongcheng, Fangshan, Fengtai Huairou, Mentougou, Miyun, Pinggu, hijingshan, Shunyi, Tongzhou, Yanqing");
         facts.add("Two main airports: Capital International and Nanyuan Airport");
         facts.add("The Forbidden City has a Palace Museum with imperial collections of Chinese art");
         facts.add("Beijing City was established over 3,000 years ago");
         facts.add("Beijing hosts one of the earliest living humans called Peking Man");
         facts.add("On October 1st 1949, the People's Republic of China was founded");
         facts.add("Forbidden City consists of 980 buildings taking 7,800,000 square feet");

         final int info = facts.size()-1;
         int numb =  (int)(Math.random()*info);
         String factOutput= facts.get(numb);
         TextView fact1 = (TextView) findViewById(R.id.facts_text);
         fact1.setText(factOutput.toString());

         Button button = (Button) findViewById(R.id.refreshbutton);

         button.setOnClickListener(new View.OnClickListener() {

             public void onClick(View v) {
                 int numb =  (int)(Math.random()*info);
                 String factOutput= facts.get(numb);
                 TextView fact1 = (TextView) findViewById(R.id.facts_text);
                 fact1.setText(factOutput.toString());


             }
         }); **/
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
