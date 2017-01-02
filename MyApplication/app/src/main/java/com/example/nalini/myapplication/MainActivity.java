package com.example.nalini.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  ImageView imgpic=(ImageView)findViewById(R.id.imgPic);

        Log.d("TAG","Good night");

      //  Context context=this;
        //Context context1=this.getBaseContext();
        // Context context2=this.getApplicationContext();

        Toast.makeText(this,"Hiii",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","i am in on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","i am in on resume");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","i am in on pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","i am in on stop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG","i am in on restart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","i am in on destroy");

    }
}












