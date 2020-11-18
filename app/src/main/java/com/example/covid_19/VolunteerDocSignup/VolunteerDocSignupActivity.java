package com.example.covid_19.VolunteerDocSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covid_19.Donation;
import com.example.covid_19.R;
import com.example.covid_19.progressBar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.ReferenceQueue;

public class VolunteerDocSignupActivity extends AppCompatActivity {

    TextInputLayout Docname,workPlace,docPhone,docEmail;
    Button  regBtn;
    FirebaseDatabase database;
    DatabaseReference reference;

    progressBar progressBar = new progressBar(VolunteerDocSignupActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_doc_signup);
        Docname = findViewById(R.id.doctorName);
        workPlace = findViewById(R.id.workplace);
        docPhone = findViewById(R.id.doctorPhone);
        docEmail = findViewById(R.id.docEmail);

        regBtn = findViewById(R.id.docReg);



        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VolunteerDocSignupActivity.this, Donation.class);
                startActivity(intent);

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("docsignup");

                String name = Docname.getEditText().getText().toString();
                String workplace = workPlace.getEditText().getText().toString() ;
                String phone = docPhone.getEditText().getText().toString();
                String email = docEmail.getEditText().getText().toString();

                VolunteerHelperClass volunteerHelperClass = new VolunteerHelperClass(name,workplace,phone,email);

                reference.child(phone).setValue(volunteerHelperClass);
                if(TextUtils.isEmpty(name)){

                    Toast.makeText(VolunteerDocSignupActivity.this,"Name is empty",Toast.LENGTH_SHORT);
                }
                if(TextUtils.isEmpty(workplace)){
                    Toast.makeText(getApplicationContext(),"Hospital Name is Empty",Toast.LENGTH_SHORT);

                }
                if(TextUtils.isEmpty(phone)){

                    Toast.makeText(getApplicationContext(),"Phone is Empty",Toast.LENGTH_SHORT);
                }
                if(TextUtils.isEmpty(email)){

                    Toast.makeText(getApplicationContext(),"Email is Empty",Toast.LENGTH_SHORT);
                }

            }


        });

    }


}
