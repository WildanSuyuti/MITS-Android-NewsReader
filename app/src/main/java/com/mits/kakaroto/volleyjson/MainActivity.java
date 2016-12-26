package com.mits.kakaroto.volleyjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    TextView results;

    String JsonURL = "https://newsapi.org/v1/articles?source=techcrunch&apiKey=49a941acf9da4909bf7f08284debe208";
    JSONArray artticle = null;
    private String author;

    String data = "";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);

        results = (TextView) findViewById(R.id.jsonData);

        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            String status = response.get("status").toString();
                            artticle = response.getJSONArray("articles");

                            for (int i = 0; i< artticle.length(); i++){
                                JSONObject obj = artticle.getJSONObject(i);
                                author = obj.getString("author");
                            }

                            data += "Color Name: " + status+ " \n"+ author;

                            results.setText(data);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        requestQueue.add(obreq);
    }
}