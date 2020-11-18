package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.covid_19.VolunteerDocSignup.VolunteerDocSignupActivity;

public class Donation extends AppCompatActivity {

    RelativeLayout bidda;
    RelativeLayout missonbd;
    RelativeLayout docSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        bidda = (RelativeLayout)findViewById(R.id.bidda);
        missonbd = (RelativeLayout)findViewById(R.id.savebd);
        docSignup = (RelativeLayout)findViewById(R.id.docSingupbtn);

        bidda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bkash.com/bkash-donation/donation?page=bidyanondo"));
                startActivity(intent);
            }
        });

        missonbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Intent.ACTION_VIEW,Uri.parse("https://pl.sheba.xyz/@Shebapos"));
                startActivity(intent);
            }
        });

        docSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Donation.this, VolunteerDocSignupActivity.class);
                startActivity(intent);
            }
        });

    }
}
