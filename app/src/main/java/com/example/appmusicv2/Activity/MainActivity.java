package com.example.appmusicv2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.appmusicv2.Adapter.MainViewPagerAdapter;
import com.example.appmusicv2.Fragment.Fragment_Tim_kiem;
import com.example.appmusicv2.Fragment.Fragment_Trang_Chu;
import com.example.appmusicv2.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Init();
    }

    private void Init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(), "Trang Chủ");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_kiem(), "Tìm Kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }

    private void AnhXa() {
        tabLayout = findViewById(R.id.myTapLayout);
        viewPager = findViewById(R.id.myViewPager);
    }

}
