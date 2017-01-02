package com.example.nalini.action_view_demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String img="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSgYnz8yULx4l5txiStLsBaNSSuftfHQV3ACvtM22O-Ed3N62cY";

        Intent intent=new Intent(Intent.ACTION_VIEW);

        intent.setDataAndType(Uri.parse(img),"image/jpg");

        startActivity(intent);
    }
}
