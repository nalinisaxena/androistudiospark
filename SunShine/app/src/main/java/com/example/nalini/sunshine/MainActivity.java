package com.example.nalini.sunshine;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     private ListView listView;

     private ArrayList<String> arrayListDays=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayListDays.add("Today-Sunny-88/63");
        arrayListDays.add("Tomorrow-Foggy-70/46");
        arrayListDays.add("Weds-Clody-72/63");
        arrayListDays.add("Thrus-Rainey-64/51");
        arrayListDays.add("Fri-Foggy-70/46");
        arrayListDays.add("Sat-Sunny-76/68");
        arrayListDays.add("Today-Sunny-88/63");
        arrayListDays.add("Tomorrow-Foggy-70/46");
        arrayListDays.add("Weds-Clody-72/63");
        arrayListDays.add("Thrus-Rainey-64/51");
        arrayListDays.add("Fri-Foggy-70/46");
        arrayListDays.add("Sat-Sunny-76/68");



        ListViewAdapter listViewAdapter=new ListViewAdapter();

        listView=(ListView)findViewById(R.id.list_item);

        listView.setAdapter(listViewAdapter);






    }


    public class ListViewAdapter extends BaseAdapter

    {


        @Override
        public int getCount() {
            return arrayListDays.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayListDays.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater=getLayoutInflater();

              View rootView=layoutInflater.inflate(R.layout.list_view,null);

            TextView textView=(TextView)rootView.findViewById(R.id.txt1);

            textView.setText(arrayListDays.get(position));

            return rootView;
        }
    }

}



