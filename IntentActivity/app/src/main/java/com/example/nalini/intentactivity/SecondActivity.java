package com.example.nalini.intentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by nalini on 8/12/16.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView txtSec;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtSec=(TextView)findViewById(R.id.txtSec);

        Intent intent=getIntent();
        String data=intent.getStringExtra("Wish");
        txtSec.setText(data);




    }
}
