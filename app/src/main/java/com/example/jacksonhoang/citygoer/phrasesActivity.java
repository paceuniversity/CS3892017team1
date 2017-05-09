package com.example.jacksonhoang.citygoer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


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
//                translatedText.setText(getMessageToTranslate());
                EditText messageToTranslate = (EditText) findViewById(R.id.messageToTranslate);
                String textToTranslate = messageToTranslate.getText().toString();
                sendRequest(textToTranslate);
            }
        });
    }

    public void sendRequest(String input){
        final TextView mTxtDisplay;
        ImageView mImageView;
        mTxtDisplay = (TextView) findViewById(R.id.translatedText); //xml things
//        This works! now gonna test something with the URL...
//        String url = "https://translation.googleapis.com/language/translate/v2?target=en&q=bonjour&key=AIzaSyCjTLl2fQYYfd4n1n2QN5smy0Cu85-7ySI";
        String url = "https://translation.googleapis.com/language/translate/v2?";
        String target = "target=zh-CN";
//        Make sure the input replaces spaces with %20!
        String q = "&q="+input;
        String key = "&key=AIzaSyCjTLl2fQYYfd4n1n2QN5smy0Cu85-7ySI";
        url = url.concat(target).concat(q).concat(key);
        url = url.replaceAll(" ", "%20");


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, (String)null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
//                        Call a method to parse the response
                        String parsedResponse="";
                        try {
                            parsedResponse = parseResponse(response);
                            mTxtDisplay.setText(parsedResponse);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            mTxtDisplay.setText("Something went wrong");
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        mTxtDisplay.setText("Didn't work :(");
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }

    public String parseResponse(JSONObject response) throws JSONException {
        JSONObject mainObject = response.getJSONObject("data");
        JSONObject obj = mainObject.getJSONArray("translations").getJSONObject(0);
        String translatedText = obj.getString("translatedText");

        return translatedText;
    }



}
