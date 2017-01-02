package com.example.nalini.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private ArrayList<String> arrayList=new ArrayList<>();

    private ArrayList<Integer> arrayListImg=new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayList.add("Mercury");
        arrayList.add("Venus");
        arrayList.add("Earth");
        arrayList.add("Mars");
        arrayList.add("Jupiter");
        arrayList.add("Saturn");
        arrayList.add("Neptune");
        arrayList.add("Uranus");
        arrayList.add("Pluto");

        arrayListImg.add(R.drawable.ic_android_black_24dp);
        arrayListImg.add(R.drawable.ic_directions_bike_black_24dp);
        arrayListImg.add(R.drawable.ic_face_black_24dp);
        arrayListImg.add(R.drawable.ic_android_black_24dp);
        arrayListImg.add(R.drawable.ic_directions_bike_black_24dp);
        arrayListImg.add(R.drawable.ic_face_black_24dp);
        arrayListImg.add(R.drawable.ic_android_black_24dp);
        arrayListImg.add(R.drawable.ic_directions_bike_black_24dp);
        arrayListImg.add(R.drawable.ic_face_black_24dp);


        ListViewAdapter listViewAdapter=new ListViewAdapter();


        listView=(ListView)findViewById(R.id.list_item);

        listView.setAdapter(listViewAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              String selectedItem=  listView.getItemAtPosition(position).toString();

                Toast.makeText(MainActivity.this,selectedItem,Toast.LENGTH_SHORT).show();
            }
        });

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

            View rootView=layoutInflater.inflate(R.layout.list_view,null);

            TextView txtView=(TextView)rootView.findViewById(R.id.txt1);

            ImageView imageView=(ImageView)rootView.findViewById(R.id.image);

            imageView.setImageResource(arrayListImg.get(position));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this,"Image Clicked"+v.getId(),Toast.LENGTH_SHORT).show();
                }
            });

            txtView.setText(arrayList.get(position));

            return rootView;


        }
    }
}
