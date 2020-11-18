package com.example.covid_19;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19.CountryData.CountryDataActivity;

import com.example.covid_19.myths.MythsActivity;



import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static android.R.*;

public class homepage extends AppCompatActivity {



    Context mContext;

    //global
    private TextView tvTotalConfirmed,tvTotalDeaths,tvTotalRecovered,tvTodayDeaths,tvTodaycases,tvActive,tvCritical,coronabd;

    //bd
    private TextView  tvTotalCOnfirmedbd,tvTotalDeathsbd,recoveredbd,tvTodaybdDeaths,tvTodaybdCases,tvBdActive,tvBdCritical;

    private ImageView about ;
    //progressDialog

 //   final progressBar progressBar = new progressBar(homepage.this);

    ProgressDialog progressDialog;



    RelativeLayout btn_1;
    RelativeLayout btn_2;
    RelativeLayout btn_3;
    RelativeLayout btn_4;
    RelativeLayout btn_5;
    RelativeLayout btn_6;
    RelativeLayout btn_7;
    RelativeLayout btn_8;
    Button em_call_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);




       //Clickable activity transaction ...
       btn_1 = (RelativeLayout)findViewById(R.id.btn1);
       btn_2 = (RelativeLayout)findViewById(R.id.btn2);
       btn_3 = (RelativeLayout)findViewById(R.id.btn3);
       btn_5 = (RelativeLayout)findViewById(R.id.btn5);
       btn_6 = (RelativeLayout)findViewById(R.id.btn6);
       btn_4 = (RelativeLayout)findViewById(R.id.donation_btn);
       btn_7 = (RelativeLayout)findViewById(R.id.btn7);
       btn_8 =(RelativeLayout)findViewById(R.id.btn8);
       em_call_btn = (Button)findViewById(R.id.emg_call_btn);
        about = (ImageView)findViewById(R.id.about);
        coronabd = (TextView) findViewById(R.id.coronabd);
       //OnCLick

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,AboutActicity.class);
                startActivity(intent);
            }
        });

        coronabd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://corona.gov.bd/"));
                startActivity(intent);
            }
        });

       btn_1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               Intent intent = new Intent(homepage.this,covid_btn.class);

               startActivity(intent);
           }
       });
       btn_2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(homepage.this,doc_em_btn.class);
               startActivity(intent);
           }
       });


       btn_3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(homepage.this,sym_prv_btn.class);
               startActivity(intent);
           }
       });

       btn_4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(homepage.this,Donation.class);
               startActivity(intent);
           }
       });

       btn_5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(homepage.this,news_activity.class);
               startActivity(intent);
           }
       });

      btn_6.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(homepage.this, CountryDataActivity.class);
              startActivity(intent);
          }
      });

      btn_7.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(homepage.this, MythsActivity.class);
              startActivity(intent);
          }
      });

      btn_8.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.prothomalo.com/live"));
              startActivity(intent );
          }
      });


      em_call_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+10655"));
              startActivity(intent);
          }
      });

        //global
        tvTotalConfirmed = findViewById(R.id.tvTotalConfirmed);
        tvTotalDeaths = findViewById(R.id.tvTotalDead);
        tvTotalRecovered = findViewById(R.id.tvTotalRecoverd);
        tvTodaycases = findViewById(R.id.tvTodayCases);
        tvTodayDeaths = findViewById(R.id.todayDeaths);
        tvActive = findViewById(R.id.tvActive);
        tvCritical = findViewById(R.id.global_critical);

        //initialaizing bd

        tvTotalCOnfirmedbd = findViewById(R.id.tvTotalConfirmedbd);
        tvTotalDeathsbd = findViewById(R.id.tvTotalDeadbd);
        recoveredbd  = findViewById(R.id.tvTotalRecoverdbd);

        tvTodaybdCases = findViewById(R.id.tvTodayBDCases);
        tvTodaybdDeaths = findViewById(R.id.tvTodayBdDeaths);
        tvBdActive = findViewById(R.id.tvBdactive);
        tvBdCritical = findViewById(R.id.tvBdCritical);

        getBdData();

        getData();
    }

    private void getData(){
        progressDialog = new ProgressDialog(homepage.this);
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setContentView(R.layout.progress_dialog);
       progressDialog.getWindow().setBackgroundDrawableResource(
              android.R.color.transparent
       );
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://corona.lmao.ninja/v2/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    tvTotalConfirmed.setText(jsonObject.getString("cases"));
                    tvTotalDeaths.setText(jsonObject.getString("deaths"));
                    tvTotalRecovered.setText(jsonObject.getString("recovered"));
                    tvTodaycases.setText(jsonObject.getString("todayCases"));
                    tvTodayDeaths.setText(jsonObject.getString("todayDeaths"));
                    tvActive.setText(jsonObject.getString("active"));
                    tvCritical.setText(jsonObject.getString("critical"));
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error Response",error.toString());
            }
        });
        queue.add(stringRequest);


    }

    private void getBdData(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url =" https://corona.lmao.ninja/v2/countries/Bangladesh";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    tvTotalCOnfirmedbd.setText(jsonObject.getString("cases"));
                    tvTotalDeathsbd.setText(jsonObject.getString("deaths"));
                    recoveredbd.setText(jsonObject.getString("recovered"));
                    tvTodaybdCases.setText(jsonObject.getString("todayCases"));
                    tvTodaybdDeaths.setText(jsonObject.getString("todayDeaths"));
                    tvBdActive.setText(jsonObject.getString("active"));
                    tvBdCritical.setText(jsonObject.getString("critical"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       progressDialog.dismiss();
                    }
                },4000);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error Response",error.toString());

            }
  });

        queue.add(stringRequest);

    }



}
