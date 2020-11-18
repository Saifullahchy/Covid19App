package com.example.covid_19.gov_hospital;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.CallDoctor.DoctorItems;
import com.example.covid_19.R;

import java.util.ArrayList;

public class GovHospitalAdapter extends RecyclerView.Adapter<GovHospitalAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<GovHospotalItems> govHospitalItems;

    public GovHospitalAdapter(Context mContext, ArrayList<GovHospotalItems> govHospitalItems) {
        this.mContext = mContext;
        this.govHospitalItems = govHospitalItems;
    }

    @NonNull
    @Override
    public GovHospitalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_hospital, parent, false);

        return new GovHospitalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GovHospitalAdapter.ViewHolder holder, int position) {
        final GovHospotalItems nGovHospitalItems = govHospitalItems.get(position);
        TextView hospitalName = holder.hospitalName;
        TextView hospitalAdd = holder.hospitalAdd;
        TextView hospitalCont = holder.hospitalCont;
        RelativeLayout call_btn = holder.call_btn;

        hospitalName.setText(nGovHospitalItems.getHospitalName());
        hospitalAdd.setText(nGovHospitalItems.getHospitalAdd());
        hospitalCont.setText(nGovHospitalItems.getHospitalCont());
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + nGovHospitalItems.getHospitalCont()));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return govHospitalItems.size();
    }

    public void filter(ArrayList<GovHospotalItems> filterHospitalName) {
        govHospitalItems = filterHospitalName;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hospitalName ,hospitalAdd,hospitalCont;
        RelativeLayout call_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hospitalName = itemView.findViewById(R.id.hospitalName);
            hospitalAdd = itemView.findViewById(R.id.hospitaAddress);
            hospitalCont = itemView.findViewById(R.id.hospitalContact);
            call_btn = itemView.findViewById(R.id.call_hospital_list_btn);
        }
    }
}
