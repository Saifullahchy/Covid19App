package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class  AboutActicity extends AppCompatActivity {

    ImageView myFb,myGit,rafatFb,rafatGit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        myFb = findViewById(R.id.myFb);
        myGit = findViewById(R.id.myGit);
        rafatFb = findViewById(R.id.rafatFb);
        rafatGit = findViewById(R.id.rafatGit);


        myFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/saifullahchowdhurysaimun"));
                startActivity(intent);
            }
        });
        myGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/Saifullahchy"));
                startActivity(intent);
            }
        });

        rafatFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/rafat.hossain.12"));
                startActivity(intent);
            }
        });
        rafatGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/rafathossain96"));
                startActivity(intent);
            }
        });
    }
}
