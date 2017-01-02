package com.example.nalini.viewpagergallerydemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

public class MainActivity extends AppCompatActivity {

    Context context;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    String[] rank;
    String[] population;
    String[] country;
    int[] flag;

    LayoutInflater layoutInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rank=new String[]{"1","2","3","4","5"};

        country=new String[]{"India","US","Russia","Japan","Brazil"};

        population=new String[]{"1000","2000","3000","4000","5000"};

        flag=new int[]{R.drawable.india,R.drawable.us,R.drawable.russia,R.drawable.japan,R.drawable.brazil};

        viewPager=(ViewPager)findViewById(R.id.pager);

        pagerAdapter=new ViewPagerAdapter(MainActivity.this,rank,country,population,flag);

        viewPager.setAdapter(pagerAdapter);


    }
}
