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
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private TextView results;
    //private String JsonURL = "http://api.androidhive.info/volley/person_object.json";
    private String JsonURL = "https://newsapi.org/v1/articles?source=techcrunch&apiKey=49a941acf9da4909bf7f08284debe208";
    private String data = "";
    private RequestQueue requestQueue;
    private JsonObjectRequest obreq;
    private String name, email, home, mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);

        results = (TextView) findViewById(R.id.jsonData);
        initJsonObject();
    }

    private void initJsonObject(){
        obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            name = response.getString("source");
//                            email = response.getString("email");

                            JSONObject phone = response.getJSONObject("articles");
                            home = phone.getString("author");
//                            mobile = phone.getString("mobile");

                            data += "Name: " + name + "\n" + "Home : " + home + "\n";

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