package com.example.covid_19;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class landingpage extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;  //AFTER 5 SEC IT WILL MOVE TO NEXT PAGE

    //variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView text_1, text_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.landingpage);

     //   Toast.makeText(landingpage.this,"firebase connection success",Toast.LENGTH_LONG).show(); //toasting connection

        //Animation conntected from res :- anim
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);


        //hooks
        image = findViewById(R.id.logo);
        text_1 = findViewById(R.id.corona_V);
        text_2 = findViewById(R.id.covid_19);

        //combaining animation with page

        image.setAnimation(topAnim);
        text_1.setAnimation(bottomAnim);
        text_2.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(landingpage.this,homepage.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}

