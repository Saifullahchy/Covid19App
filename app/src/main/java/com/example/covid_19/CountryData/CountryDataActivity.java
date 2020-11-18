package com.example.covid_19.CountryData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19.R;
import com.example.covid_19.progressBar;
import com.google.protobuf.StringValue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.covid_19.R.menu.menu;

public class CountryDataActivity extends AppCompatActivity {


    RecyclerView dataRecycler;
    LinearLayoutManager linearLayoutManager;
    private ArrayList<CountryDataItems> countryDataItems = new ArrayList<>();
    private CountryDataAdapter countryDataAdapter;

    private final String TAG = CountryDataActivity.class.getSimpleName() ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_data);
        dataRecycler = findViewById(R.id.countryData_recycler);
        EditText searchText = findViewById(R.id.searchText);


        linearLayoutManager = new LinearLayoutManager(this);
        dataRecycler.setHasFixedSize(true);
        dataRecycler.setLayoutManager(linearLayoutManager);
        countryDataAdapter = new CountryDataAdapter(CountryDataActivity.this, countryDataItems);

        getDataFromServer();

        //Search box koi
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void getDataFromServer() {
        final progressBar progressBar = new progressBar(CountryDataActivity.this);
        progressBar.startLoadingDialog();

        String url = "https://corona.lmao.ninja/v2/countries";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {

                    Log.e(TAG, "OnNotnNullResponse:" + response);

                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i <jsonArray.length(); i++) {

                            JSONObject data = jsonArray.getJSONObject(i);
                            countryDataItems.add(new CountryDataItems(
                                    data.getString("country"),
                                    data.getString("cases"),
                                    data.getString("todayCases"),
                                    data.getString("deaths"),
                                    data.getString("todayDeaths"),
                                    data.getString("recovered"),
                                    data.getString("critical")
                            ));
//                            Log.d("DEBUGLOG", String.valueOf(data.get("country")));
                        }
                        dataRecycler.setAdapter(countryDataAdapter);
                        progressBar.dismissDialog();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,"onErrorResponse:"+error);
                progressBar.dismissDialog();
            }
        });
        RequestQueue requestQueue =  Volley.newRequestQueue(CountryDataActivity.this);
        requestQueue.add(stringRequest);
    }

    //search

    private void filter(String keyword){
        ArrayList<CountryDataItems> filteredCountryDataItems = new ArrayList<>();

        for (CountryDataItems item : countryDataItems){
            if(item.getCountryName().toLowerCase().contains(keyword.toLowerCase())){
                filteredCountryDataItems.add(item);
            }
        }
        countryDataAdapter.filter(filteredCountryDataItems);
    }

}
