package com.example.covid_19.CallNationalHelpLine;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.CallDoctor.CallDoctorActivity;
import com.example.covid_19.CallDoctor.DoctorAdapter;
import com.example.covid_19.R;
import com.example.covid_19.progressBar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class callNationalHelplineActivity extends AppCompatActivity {

    final progressBar progressBar = new progressBar(callNationalHelplineActivity.this);
    private RecyclerView ntl_btn_recycler;
    private ArrayList<helplineItem> helplineItems = new ArrayList<>();
    private helplineAdapter NationalHotlineAdapter;

    DatabaseReference reference;

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_hotline_btn);

        progressBar.startLoadingDialog();
        ntl_btn_recycler = findViewById(R.id.recyclerView_nat_hotline);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(callNationalHelplineActivity.this);
        ntl_btn_recycler.setLayoutManager(linearLayoutManager);
        NationalHotlineAdapter = new helplineAdapter(callNationalHelplineActivity.this,helplineItems);

        reference = FirebaseDatabase.getInstance().getReference().child("Hotline");
        reference.keepSynced(true);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                collectFirebaseData((Map<String , Object>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void collectFirebaseData(Map<String, Object> value) {

        for(Map.Entry<String, Object> entry : value.entrySet()){
            Map singleData = (Map) entry.getValue();
            helplineItems.add(new helplineItem(String.valueOf(singleData.get("address")), String.valueOf(singleData.get("phone"))));

            //            Log.d("DEBUGLOG", String.valueOf(singleData.get("Name")));
            //            Log.d("DEBUGLOG", String.valueOf(singleData.get("phone")));
        }
        ntl_btn_recycler.setAdapter(NationalHotlineAdapter);
        progressBar.dismissDialog();
    }
}
