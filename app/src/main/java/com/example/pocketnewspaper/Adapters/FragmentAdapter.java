package com.example.pocketnewspaper.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pocketnewspaper.Fragments.EntertainmentFragment;
import com.example.pocketnewspaper.Fragments.HealthFragment;
import com.example.pocketnewspaper.Fragments.HomeFragments;
import com.example.pocketnewspaper.Fragments.ScienceFragment;
import com.example.pocketnewspaper.Fragments.SportsFragment;
import com.example.pocketnewspaper.Fragments.TechnologyFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);


    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HomeFragments();

            case 1:
                return new SportsFragment();

            case 2:
                return new HealthFragment();

            case 3:
                return new ScienceFragment();

            case 4:
                return new EntertainmentFragment();


            case 5:
                return new TechnologyFragment();


            default:
                return new HomeFragments();



        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
