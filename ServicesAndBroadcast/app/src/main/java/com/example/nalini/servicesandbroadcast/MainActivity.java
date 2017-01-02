package com.example.nalini.servicesandbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStartService,btnReciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStartService=(Button)findViewById(R.id.btnstart);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,BackgroundService.class);
                startService(intent);
            }
        });


        btnReciver=(Button)findViewById(R.id.btnsRegisterReciver);

        btnReciver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Receive reciver=new Receive();

                IntentFilter intentFilter=new IntentFilter();

                intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);

                registerReceiver(reciver,intentFilter);

            }
        });



    }
}
