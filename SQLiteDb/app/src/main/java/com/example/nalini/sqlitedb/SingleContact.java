package com.example.nalini.sqlitedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SingleContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_contact);


        Intent intent=getIntent();

       String name= intent.getStringExtra("SELECTED_NAME");

        SqliteDatabaseHalper sqliteDatabaseHalper=new SqliteDatabaseHalper(this,null,null,1);

        StringBuilder stringBuilder = sqliteDatabaseHalper.getSingleContact(name);

        Toast.makeText(this, "" + stringBuilder.toString(), Toast.LENGTH_SHORT).show();



    }
}
