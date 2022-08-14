package com.example.pocketnewspaper.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.pocketnewspaper.Adapters.Adapter;
import com.example.pocketnewspaper.ApiUtilities;
import com.example.pocketnewspaper.Mainnews;
import com.example.pocketnewspaper.Model.ModelClass;
import com.example.pocketnewspaper.R;
import com.example.pocketnewspaper.utilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {



    String api = "cde17dfa551a4fc899260bdf0bcb4ea9";
    ArrayList<ModelClass> list ;
    Adapter adapter;
    String country;
    String category="health";
    private RecyclerView recyclerViewhealth;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v= inflater.inflate(R.layout.fragment_health, container, false);

        recyclerViewhealth=v.findViewById(R.id.healthRecyclerView);
        list= new ArrayList<>();
        recyclerViewhealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),list);
        recyclerViewhealth.setAdapter(adapter);
        country= utilities.getCountry();

        findNews();



        return v;

    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<Mainnews>() {
            @Override
            public void onResponse(Call<Mainnews> call, Response<Mainnews> response) {
                if(response.isSuccessful())
                {
                    list.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Mainnews> call, Throwable t) {

            }
        });
    }
}