package com.example.covid_19;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.LayoutInflater;

import com.example.covid_19.myths.MythsActivity;

public class progressBar {

    Activity activity;
    AlertDialog dialog;
    ProgressDialog progressDialog;
    public progressBar(Activity myActivity){

        activity = myActivity;
    }

    public void startLoadingDialog(){

        progressDialog = new ProgressDialog(activity);
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
        android.R.color.transparent
        );
  }

    public void  dismissDialog(){
      progressDialog.dismiss();
    }
}


