package com.example.nalini.fblistviewdemo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private ArrayList<String> arrayList=new ArrayList<>();

    private ArrayList<Integer> arrayListImg=new ArrayList<>();

    private ArrayList<Integer> arrayListImg1=new ArrayList<>();

    private ArrayList<String> arrayListHrs=new ArrayList<>();

    private ArrayList<String> arrayListLike=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList.add("Sunder Pichai updated him profile picture");
        arrayList.add("Steve Jobs updated him profile picture");
        arrayList.add("Bill Gates updated him profile picture");
        arrayList.add("Mark Zuckerberg him profile picture");

        arrayListImg.add(R.drawable.google);
        arrayListImg.add(R.drawable.apple);
        arrayListImg.add(R.drawable.micro);
        arrayListImg.add(R.drawable.fb);

        arrayListImg1.add(R.drawable.google);
        arrayListImg1.add(R.drawable.apple);
        arrayListImg1.add(R.drawable.micro);
        arrayListImg1.add(R.drawable.fb);

        arrayListHrs.add("5 hrs");
        arrayListHrs.add("1 hrs");
        arrayListHrs.add("10 hrs");
        arrayListHrs.add("20 hrs");

        arrayListLike.add("200");
        arrayListLike.add("100");
        arrayListLike.add("600");
        arrayListLike.add("800");

        ListViewAdapter listViewAdapter=new ListViewAdapter();

        listView=(ListView)findViewById(R.id.list_item);

        listView.setAdapter(listViewAdapter);


    }

    public class ListViewAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater=getLayoutInflater();

            View rootView=layoutInflater.inflate(R.layout.fb_listview,null);

            TextView textView=(TextView)rootView.findViewById(R.id.txt1);

            ImageView imgPic=(ImageView)rootView.findViewById(R.id.imgPic);

            imgPic.setImageResource(arrayListImg.get(position));

            ImageView imgPic1=(ImageView)rootView.findViewById(R.id.imgPic1);

            imgPic1.setImageResource(arrayListImg1.get(position));

            TextView textView1=(TextView)rootView.findViewById(R.id.txthrs);

            textView1.setText(arrayListHrs.get(position));

            TextView textView2=(TextView)rootView.findViewById(R.id.txtLike);

            textView2.setText(arrayListLike.get(position));


            textView.setText(arrayList.get(position));


            return rootView;
        }
    }
}
