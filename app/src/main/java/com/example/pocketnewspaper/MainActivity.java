package com.example.pocketnewspaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pocketnewspaper.Adapters.Adapter;
import com.example.pocketnewspaper.Adapters.FragmentAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    TabLayout tabLayout;
    TabItem mhome,msports,mhealth,mtech,mentertainment,mscience;
    FragmentAdapter fragmentAdapter;
    ViewPager viewPager;
    Toolbar toolbar;
    Adapter adapter;
    Spinner spinner;
    String country;




    String api = "cde17dfa551a4fc899260bdf0bcb4ea9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        toolbar=findViewById(R.id.toolbar);
        tabLayout= findViewById(R.id.tablayout);
        mhome=findViewById(R.id.home);
        mentertainment=findViewById(R.id.entertainment);
        mtech=findViewById(R.id.tech);
        msports=findViewById(R.id.sports);
        mscience=findViewById(R.id.science);
        mhealth=findViewById(R.id.health);
        viewPager=findViewById(R.id.fragmentContainer);
        fragmentAdapter= new FragmentAdapter(getSupportFragmentManager());




        spinner = (Spinner) findViewById(R.id.countryselect);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterspinner = ArrayAdapter.createFromResource(this,
                R.array.countrylist, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapterspinner);
        spinner.setOnItemSelectedListener(this);



        viewPager.setAdapter(fragmentAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)

                {
                    fragmentAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        country = adapterView.getSelectedItem().toString();
       utilities.setCountry(country);
       fragmentAdapter.notifyDataSetChanged();
        viewPager.setAdapter(fragmentAdapter);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}