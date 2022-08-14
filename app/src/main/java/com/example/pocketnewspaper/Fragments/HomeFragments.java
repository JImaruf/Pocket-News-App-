package com.example.pocketnewspaper.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pocketnewspaper.Adapters.Adapter;
import com.example.pocketnewspaper.Adapters.FragmentAdapter;
import com.example.pocketnewspaper.ApiUtilities;
import com.example.pocketnewspaper.MainActivity;
import com.example.pocketnewspaper.Mainnews;
import com.example.pocketnewspaper.Model.ModelClass;
import com.example.pocketnewspaper.R;
import com.example.pocketnewspaper.utilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragments extends Fragment {
    String api = "cde17dfa551a4fc899260bdf0bcb4ea9";
    ArrayList<ModelClass> list ;
    Adapter adapter;
    String country ;

    private RecyclerView homeRecylerView;








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v= inflater.inflate(R.layout.fragment_home_fragments, container, false);

        homeRecylerView=v.findViewById(R.id.homeRecyclerView);
        list= new ArrayList<>();
        homeRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),list);
        homeRecylerView.setAdapter(adapter);

        country = utilities.getCountry();
        findNews();


        return v;

    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<Mainnews>() {
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
                Toast.makeText(getContext(), "failed response"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}