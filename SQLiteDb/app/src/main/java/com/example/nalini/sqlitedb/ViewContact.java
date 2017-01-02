package com.example.nalini.sqlitedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewContact extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        SqliteDatabaseHalper sqliteDatabaseHalper=new SqliteDatabaseHalper(this,null,null,1);

        ArrayList<String> arrayList=sqliteDatabaseHalper.getFirstName();

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(ViewContact.this,android.R.layout.simple_list_item_1,
                android.R.id.text1,arrayList);


        listView=(ListView)findViewById(R.id.list_item);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedName=parent.getItemAtPosition(position).toString();

                Intent singleContactintent=new Intent(ViewContact.this,SingleContact.class);

                singleContactintent.putExtra("SELECTED_NAME",selectedName);

                startActivity(singleContactintent);


            }
        });
    }


}
