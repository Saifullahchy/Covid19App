package com.example.covid_19.myths;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MythsAdapter extends RecyclerView.Adapter<MythsAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<MythsItem>mythsItems;


    public MythsAdapter(Context mContext, ArrayList<MythsItem> mythsItems) {
        this.mContext = mContext;
        this.mythsItems = mythsItems;
    }

    @NonNull
    @Override
    public MythsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_myths,parent,false);

        return new MythsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MythsAdapter.ViewHolder holder, int position) {



      holder.mythContainer.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));


       Picasso.get().load(mythsItems.get(position).getUrl())
               .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return mythsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        RelativeLayout mythContainer;
        ImageView imageView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mythContainer = itemView.findViewById(R.id.mythcontainer);
            imageView = itemView.findViewById(R.id.myth_img);
        }

    }
}
