package com.example.covid_19;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class sym_prv_btn extends AppCompatActivity {



    RelativeLayout card1;
    RelativeLayout card2;
    RelativeLayout card3;
    RelativeLayout card4;
    RelativeLayout card5;
    RelativeLayout card6;
    RelativeLayout card7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sym_prv_btn);



        card1 = (RelativeLayout)findViewById(R.id.ques1);
        card2 = (RelativeLayout) findViewById(R.id.ques2);
        card3 = (RelativeLayout)findViewById(R.id.ques3);
        card4 = (RelativeLayout)findViewById(R.id.ques4);
        card5 = (RelativeLayout)findViewById(R.id.ques5);
        card6 = (RelativeLayout)findViewById(R.id.ques6);
        card7 = (RelativeLayout)findViewById(R.id.ques7);



        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/if-you-are-sick/steps-when-sick.html"));
                startActivity(intent);
            }
        });



        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/prevention.html"));
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/daily-life-coping/checklist-household-ready.html"));
                startActivity(intent);
            }
        });



        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/diy-cloth-face-coverings.html"));
                startActivity(intent);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/daily-life-coping/children.html"));
                startActivity(intent);
            }
        });


        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/daily-life-coping/managing-stress-anxiety.html"));
                startActivity(intent);
            }
        });

        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Intent.ACTION_VIEW,Uri.parse("http://103.247.238.81/webportal/pages/covid19.php"));
                startActivity(intent);
            }
        });
    }
}
