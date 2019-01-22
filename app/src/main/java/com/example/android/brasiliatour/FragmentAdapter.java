package com.example.android.brasiliatour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ShoppingFragment();
        } else if (position == 1){
            return new HotelsFragment();
        } else if(position == 2){
            return new RestaurantsFragment();
        }else{
            return new AttractionsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
