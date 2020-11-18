package com.example.covid_19.CallNationalHelpLine;

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

import com.example.covid_19.R;

import java.util.ArrayList;

public class
helplineAdapter extends RecyclerView.Adapter<helplineAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<helplineItem> helplineItems;

    public helplineAdapter(Context mContext, ArrayList<helplineItem> helplineItems) {
        this.mContext = mContext;
        this.helplineItems = helplineItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_hotline_contact, parent, false);
        return new helplineAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final helplineItem nhelplineItem = helplineItems.get(position);

        TextView address = holder.address;
        TextView NtlcontactNumber = holder.NtlcontactNumber;
        RelativeLayout nationalCallBtn = holder.nationalCallBtn;

        address.setText(nhelplineItem.getHelplineAddress());
        NtlcontactNumber.setText(nhelplineItem.getHelplineNumber());

        nationalCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + nhelplineItem.getHelplineNumber()));
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return helplineItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView address;
        TextView NtlcontactNumber;
        RelativeLayout nationalCallBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            address = itemView.findViewById(R.id.address);
            NtlcontactNumber = itemView.findViewById(R.id.naitonal_contact_number);
            nationalCallBtn = itemView.findViewById(R.id.nt_call_btn);
        }
    }
}
