package com.example.covid_19.CallDoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.covid_19.Model.Content;
import com.example.covid_19.Model.doc_content;
import com.example.covid_19.R;
import com.example.covid_19.ViewHolder.ContentViewHolder;
import com.example.covid_19.ViewHolder.DocVIewContent;
import com.example.covid_19.progressBar;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class CallDoctorActivity extends AppCompatActivity {

    private RecyclerView doctorRecycler;
    private ArrayList<DoctorItems> doctorItems = new ArrayList<>();
    private DoctorAdapter doctorAdapter;

    DatabaseReference reference;
    private ProgressDialog progressDialog;
    final progressBar progressBar = new progressBar(CallDoctorActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_doctor2);

        //progressBar

        progressBar.startLoadingDialog();

        doctorRecycler = findViewById(R.id.doctorRecycler);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CallDoctorActivity.this);
        doctorRecycler.setLayoutManager(linearLayoutManager);
        doctorAdapter = new DoctorAdapter(CallDoctorActivity.this, doctorItems);

        reference = FirebaseDatabase.getInstance().getReference().child("doctor");
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
            doctorItems.add(new DoctorItems(String.valueOf(singleData.get("Name")), String.valueOf(singleData.get("phone"))));

            //            Log.d("DEBUGLOG", String.valueOf(singleData.get("Name")));
            //            Log.d("DEBUGLOG", String.valueOf(singleData.get("phone")));
        }
        doctorRecycler.setAdapter(doctorAdapter);
        progressBar.dismissDialog();
    }



}
