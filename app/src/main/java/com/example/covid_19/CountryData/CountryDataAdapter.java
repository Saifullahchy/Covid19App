package com.example.covid_19.CountryData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;

import java.util.ArrayList;
import java.util.List;

public class CountryDataAdapter  extends RecyclerView.Adapter<CountryDataAdapter.ViewHolder> {

    private List<CountryDataItems> countyData;
    private Context mContext;

    public CountryDataAdapter(Context mContext, List<CountryDataItems> countyData) {

        this.mContext = mContext;
        this.countyData = countyData;
    }

    @NonNull
    @Override
    public CountryDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_country_data,parent,false);

        return new CountryDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryDataAdapter.ViewHolder holder, int position) {

       final CountryDataItems countryDataItems = countyData.get(position);


        holder.tvCountryName.setText(countryDataItems.getCountryName());
        holder.tvTotalCases.setText(countryDataItems.getTotalCases());
        holder.tvTodayCases.setText(countryDataItems.getTodayCase());
        holder.tvTotalDeaths.setText(countryDataItems.getTotalDeaths());
        holder.tvTodayDeaths.setText(countryDataItems.getTodayDeaths());
        holder.tvTotalRecovered.setText(countryDataItems.getTotalRecovered());
        holder.tvCritical.setText(countryDataItems.getCritical());
    }

    @Override
    public int getItemCount() {
        return countyData.size();
    }

    public void filter(ArrayList<CountryDataItems> filteredCountryDataItems) {
        countyData = filteredCountryDataItems;
        notifyDataSetChanged();
    }

//    @Override
//    public Filter getFilter() {
//
//        Filter filter = new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                FilterResults filterResults = new FilterResults();
//
//               if(constraint == null || constraint.length()== 0){
//                   filterResults.count = countryDataItemsFilter.size();
//                   filterResults.values = countryDataItemsFilter;
//               }else {
//
//                   String searchChr = constraint.toString().toLowerCase();
//
//                   ArrayList<CountryDataItems> resultData  = new ArrayList<>();
//
//                   for(CountryDataItems countryDataItems: countryDataItemsFilter){
//                       if(countryDataItems.getCountryName().toLowerCase().contains(searchChr)){
//                           resultData.add(countryDataItems);
//                       }
//
//                   }
//                   filterResults.count = resultData.size();
//                   filterResults.values = resultData;
//               }
//               return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//
//                countyData = (List<CountryDataItems>) results.values;
//            }
//        };
//        return filter;
//    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountryName,tvTotalCases,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvTotalRecovered,tvCritical;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.country_Name);
            tvTotalCases = itemView.findViewById(R.id.coutnry_case);
            tvTodayCases = itemView.findViewById(R.id.coutnryToday_case);
            tvTotalDeaths = itemView.findViewById(R.id.coutnryTotal_deaths);
            tvTodayDeaths = itemView.findViewById(R.id.coutnryToday_deaths);
            tvTotalRecovered = itemView.findViewById(R.id.coutnryTotal_Recovered);
            tvCritical = itemView.findViewById(R.id.coutnry_critical);

        }
    }


}
