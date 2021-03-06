package com.mits.kakaroto.volleyjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView results;

    String JsonURL = "https://newsapi.org/v1/articles?source=techcrunch&apiKey=49a941acf9da4909bf7f08284debe208";
    JSONArray artticle = null;
    JsonObjectRequest obreq;
    String data = "";
    RequestQueue requestQueue;
    private ArticleAdapter adapter;
    private RecyclerView recyclerView;
    private List<Articles> articlesList;
    private ImageView image;
    private String author, title, description, url, urlImage, published;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        image = (ImageView) findViewById(R.id.img_article);
        results = (TextView) findViewById(R.id.jsonData);
        showProgressDialog();
        initJson();
    }

    public void initJson(){
        articlesList = new ArrayList<>();
        obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            artticle = response.getJSONArray("articles");

                            for (int i = 0; i< artticle.length(); i++){

                                JSONObject obj = artticle.getJSONObject(i);
                                String source = response.get("source").toString();
                                author = obj.getString("author");
                                title = obj.getString("title");
                                description = obj.getString("description");
                                url = obj.getString("url");
                                urlImage = obj.getString("urlToImage");
                                published = obj.getString("publishedAt");

                                articlesList.add(new Articles(author, title,description, url, urlImage, published));
                                results.setText(source.toUpperCase());

                                adapter = new ArticleAdapter(MainActivity.this, articlesList);
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                recyclerView.setAdapter(adapter);

//                                Picasso.with(context).load(articlesList.get(i).getUrlImage()).into(image);
                            }

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


        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        requestQueue.add(obreq);
    }

    private void showProgressDialog(){
        //Deklarasi variabel dengan tipe AlertDialog
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        //Mengeset judul dialog
        progressDialog.setTitle("Loading ....");

        //Mengeset agar dialog tidak dapat dibatalkan
        progressDialog.setCancelable(false);

        //Mengeset konten/isi pedan pada dialog
        progressDialog.setMessage("Please wait being processed");

        //Mengeset tombol Negative
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });

        //Menampilkan dialog
        progressDialog.show();

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                progressDialog.dismiss();
            }}, 5000);
    }
}