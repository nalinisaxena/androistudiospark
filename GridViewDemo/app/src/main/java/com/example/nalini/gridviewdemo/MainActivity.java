package com.example.nalini.gridviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    private ArrayList<Integer> arrayListImg=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListImg.add(R.drawable.b1);
        arrayListImg.add(R.drawable.b2);
        arrayListImg.add(R.drawable.b3);
        arrayListImg.add(R.drawable.b4);
        arrayListImg.add(R.drawable.b1);
        arrayListImg.add(R.drawable.b2);
        arrayListImg.add(R.drawable.b3);
        arrayListImg.add(R.drawable.b4);
        arrayListImg.add(R.drawable.b1);
        arrayListImg.add(R.drawable.b2);
        arrayListImg.add(R.drawable.b3);
        arrayListImg.add(R.drawable.b4);
        arrayListImg.add(R.drawable.b1);
        arrayListImg.add(R.drawable.b2);
        arrayListImg.add(R.drawable.b3);
        arrayListImg.add(R.drawable.b4);
        arrayListImg.add(R.drawable.b1);
        arrayListImg.add(R.drawable.b2);
        arrayListImg.add(R.drawable.b3);
        arrayListImg.add(R.drawable.b4);


        gridView=(GridView)findViewById(R.id.gridview);

      //  final GridViewAdapter gridViewAdapter=new GridViewAdapter();

        gridView.setAdapter(new GridViewAdapter());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int path=(int)parent.getItemAtPosition(position);

                Toast.makeText(MainActivity.this,"path:"+path,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,FullScreenActivity.class);
                intent.putExtra("image_path",path);
                startActivity(intent);
            }
        });
    }

    private class GridViewAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return arrayListImg.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayListImg.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater= getLayoutInflater();

            View rootView= layoutInflater.inflate(R.layout.activity_single_screen,null);

            ImageView imageView=(ImageView)rootView.findViewById(R.id.imgSingle);

            imageView.setImageResource(arrayListImg.get(position));

            return rootView;
        }
    }
}
