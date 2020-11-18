package com.example.covid_19.CallDoctor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;

import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<DoctorItems> doctorItems;

    public DoctorAdapter(Context mContext, ArrayList<DoctorItems> doctorItems) {
        this.mContext = mContext;
        this.doctorItems = doctorItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.item_doc_list, parent, false);

        return new DoctorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DoctorItems nDoctorItems = doctorItems.get(position);

        TextView doctorName = holder.doctorName;
        TextView doctorPhone = holder.doctorPhone;
        RelativeLayout callDoc = holder.callDoc;

        doctorName.setText(nDoctorItems.getDoctorName());
        doctorPhone.setText(nDoctorItems.getDoctorPhone());

        callDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + nDoctorItems.getDoctorPhone()));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctorItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView doctorName, doctorPhone;
        RelativeLayout callDoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorName = itemView.findViewById(R.id.docName);
            doctorPhone = itemView.findViewById(R.id.contactNumber);
            callDoc = itemView.findViewById(R.id.call_doc_list_btn);
        }
    }
}
