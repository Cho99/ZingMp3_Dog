package com.example.appmusicv2.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import java.util.ArrayList;

public class ViewPagerPlayListSong extends FragmentPagerAdapter {
    public final ArrayList<Fragment> arrayList =new ArrayList<>();

    public ViewPagerPlayListSong(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public void AddFragment(Fragment fragment) {
        arrayList.add(fragment);
    }
}
