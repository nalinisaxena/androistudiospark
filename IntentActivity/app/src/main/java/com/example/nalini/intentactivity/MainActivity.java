package com.example.nalini.intentactivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private ImageView imgPhotu;

    private EditText etxmsg;
    private Button btnsend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=(Button)findViewById(R.id.okay);
        imgPhotu=(ImageView)findViewById(R.id.img);

        etxmsg=(EditText)findViewById(R.id.etxmsg);
        btnsend=(Button)findViewById(R.id.btnSend);

        //Explicit Intent

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message=etxmsg.getText().toString();

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                intent.setType("text/plain");

             //   intent.setPackage("com.whatsapp");

                startActivity(intent);

            }
        });

        Intent intent=getIntent();
        String otherMessage=intent.getStringExtra(Intent.EXTRA_TEXT);
        etxmsg.setText(otherMessage);

        // Implicit Intent

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityOptionsCompat activityOptionsCompat=ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this,imgPhotu,"Image_anim");

                Intent intent=new Intent(MainActivity.this,SecondActivity.class);


                ActivityCompat.startActivity(MainActivity.this,intent, activityOptionsCompat.toBundle());


                intent.putExtra("Wish","Good Morning");

                startActivity(intent);


            }
        });


    }
}
