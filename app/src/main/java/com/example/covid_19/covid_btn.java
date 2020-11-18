package com.example.covid_19;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.Model.Content;
import com.example.covid_19.ViewHolder.ContentViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class covid_btn extends AppCompatActivity {
    //variables
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

 //   ProgressDialog progressDialog;
      progressBar progressBar;
    //initialising firebase Recycler adapter
    FirebaseRecyclerAdapter<Content, ContentViewHolder> adapter;

    //calling firebase database
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_btn);
        progressBar  = new progressBar(covid_btn.this);

        //Firebase database initializing
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Content"); //set content into the reference...



        //Initializing RecyclerView and layout manager...

        recyclerView  = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
         showList();



    }
    private void showList(){

        progressBar.startLoadingDialog();
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Content>()
                .setQuery(reference,Content.class)
                .build();



        //adapter that show data in mainActivity by connecting item_content
        adapter = new FirebaseRecyclerAdapter<Content, ContentViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ContentViewHolder contentViewHolder, int i, @NonNull Content content) {

                contentViewHolder.textQuestion.setText(content.getQuestion());
                contentViewHolder.textAns.setText(content.getAns());
                progressBar.dismissDialog();
            }

            @NonNull
            @Override
            public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_content,parent,false);

                return new ContentViewHolder(view);
            }
     };
        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);




 }

 }
