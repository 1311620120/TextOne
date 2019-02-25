package com.example.textone.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.textone.R;
import com.example.textone.view.fragment.CarFragment;
import com.example.textone.view.fragment.DetailsFragment;
import com.example.textone.view.fragment.FindFragment;
import com.example.textone.view.fragment.HomeFragment;
import com.example.textone.view.fragment.MyFragment;
import com.hjm.bottomtabbar.BottomTabBar;


public class ShowActivity extends AppCompatActivity  {

    private BottomTabBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        initView();
        initData();
    }
    private void initView() {
        bar = findViewById(R.id.bar);
    }

    private void initData() {
        bar.init(getSupportFragmentManager())
                .setTabPadding(80,10,2)
                .setFontSize(0)
                .setImgSize(50,50)
                .addTabItem("首页",R.drawable.tab_home_bottom_shouyes,R.drawable.tab_home_bottom_shouye,HomeFragment.class)
                .addTabItem("发现",R.drawable.tab_home_bottom_quanzis,R.drawable.tab_home_bottom_quanzi,FindFragment.class)
                .setImgSize(130,130)
                .setTabPadding(10,10,3)
                .addTabItem("购物车",R.drawable.tab_home_bottom_gouwuche,R.drawable.tab_home_bottom_gouwuche,CarFragment.class)
                .setTabPadding(80,10,2)
                .setImgSize(50,50)
                .addTabItem("详情",R.drawable.tab_home_bottom_zhangdans,R.drawable.tab_home_bottom_zhangdan,DetailsFragment.class)
                .addTabItem("我的",R.drawable.tab_home_bottom_wodes,R.drawable.tab_home_bottom_wode,MyFragment.class)
                .setTabBarBackgroundResource(R.drawable.bg_homepage_bottom);

    }

}
