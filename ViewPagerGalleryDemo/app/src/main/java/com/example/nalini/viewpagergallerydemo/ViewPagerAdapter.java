package com.example.nalini.viewpagergallerydemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by nalini on 21/12/16.
 */

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    String[] rank;
    String[] population;
    String[] country;
    int[] flag;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context,String[] rank,String[] country,String[] population,int[] flag)
    {
        this.context=context;
        this.rank=rank;
        this.country=country;
        this.population=population;
        this.flag=flag;


    }

    @Override
    public int getCount() {
        return rank.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return  view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView txtrank;
        TextView txtcountry;
        TextView txtpopulation;
        ImageView imgflag;

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView=layoutInflater.inflate(R.layout.view_pager_item,container,false);

        txtrank=(TextView)itemView.findViewById(R.id.rank);
        txtcountry=(TextView)itemView.findViewById(R.id.country);
        txtpopulation=(TextView)itemView.findViewById(R.id.population);

        txtrank.setText(rank[position]);
        txtcountry.setText(country[position]);
        txtpopulation.setText(population[position]);

        imgflag=(ImageView)itemView.findViewById(R.id.imgflag);

        imgflag.setImageResource(flag[position]);

        ((ViewPager)container).addView(itemView);

        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager)container).removeView((RelativeLayout)object);
    }
}
