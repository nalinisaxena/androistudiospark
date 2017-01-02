package com.example.nalini.picassodemo;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        ImageView imgpic=(ImageView)findViewById(R.id.imgpic);

        Picasso.with(this).load("http://img.freepik.com/free-vector/placeholder-shape-logo-template_1195-17.jpg?size=338&ext=jpg")
                .placeholder(R.drawable.placeholder1)
                .error(R.drawable.error)
                .resize(400,400).into(imgpic);


          // Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
         //  startActivity(intent);






    }
}
