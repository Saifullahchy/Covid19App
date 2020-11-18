package com.example.covid_19.myths;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import com.example.covid_19.R;
import com.example.covid_19.homepage;
import com.example.covid_19.progressBar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MythsActivity extends AppCompatActivity {

    private static  final String TAG = "Myth activity";

    private DatabaseReference reference;
    private ImageView imageView;
    private StorageReference mStorageReference;

    private Context mContext = MythsActivity.this;
    RecyclerView mythRecycler;

    private ArrayList<MythsItem> mythsItems;

    private MythsAdapter mythsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myths);

        Log.d(TAG,"onCreated: started");


        mythRecycler = (RecyclerView)findViewById(R.id.mythRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mythRecycler.setLayoutManager(layoutManager);
      //  mythRecycler.setHasFixedSize(true);

        mythsItems = new ArrayList<>();


        reference = FirebaseDatabase.getInstance().getReference();

        mStorageReference = FirebaseStorage.getInstance().getReference();

        init();

    }

    private void init(){
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(MythsActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
             android.R.color.transparent
        );

        clearAll();
        Query query = reference.child("myths");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                 MythsItem images = new MythsItem();
                  images.setUrl(snapshot.child("url").getValue().toString());

                  mythsItems.add(images);

               }

               mythsAdapter = new MythsAdapter(mContext,mythsItems);
               mythRecycler.setAdapter(mythsAdapter);
               mythsAdapter.notifyDataSetChanged();


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                },7000);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void clearAll(){
        if(mythsItems !=null){

            mythsItems.clear();

            if(mythsAdapter != null){

                mythsAdapter.notifyDataSetChanged();

            }
        }

        mythsItems = new ArrayList<>();
    }
}
