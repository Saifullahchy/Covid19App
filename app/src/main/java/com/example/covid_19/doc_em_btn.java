package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.covid_19.CallDoctor.CallDoctorActivity;
import com.example.covid_19.CallNationalHelpLine.callNationalHelplineActivity;
import com.example.covid_19.gov_hospital.govHospitalActivity;

public class doc_em_btn extends AppCompatActivity {
    RelativeLayout hotline_btn;
    RelativeLayout doc_btn;
    RelativeLayout gov_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_em_btn);
        hotline_btn = (RelativeLayout)findViewById(R.id.hotline_btn);
        doc_btn = (RelativeLayout)findViewById(R.id.call_doc_btn);
        gov_btn = (RelativeLayout)findViewById(R.id.call_gov_btn);



        hotline_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doc_em_btn.this, callNationalHelplineActivity.class);
                startActivity(intent);
            }
        });

        doc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doc_em_btn.this, CallDoctorActivity.class);
                startActivity(intent);
            }
        });
        gov_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doc_em_btn.this, govHospitalActivity.class);
                startActivity(intent);
            }
        });



    }
}
