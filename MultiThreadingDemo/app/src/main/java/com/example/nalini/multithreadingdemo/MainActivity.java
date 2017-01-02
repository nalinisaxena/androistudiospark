package com.example.nalini.multithreadingdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private Button btnStartThread,btnFatchData,btnFatchSyncData;
    private ProgressDialog progressDialog;
    private EditText etxEnterUrl;
    String etxUrl;


    // private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        imageView=(ImageView)findViewById(R.id.imgPicaaso);
//
//        Picasso.with(this).load("http://wallpaper-gallery.net/images/best-hd-wallpapers/best-hd-wallpapers-20.jpg").into(imageView);

        etxEnterUrl=(EditText)findViewById(R.id.etxEnterUrl);

        btnFatchSyncData=(Button)findViewById(R.id.btnFatchSyncdata);

        btnFatchSyncData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etxUrl=etxEnterUrl.getText().toString();

                BackgroundWorkerThread backgroundWorkerThread=new BackgroundWorkerThread();
                backgroundWorkerThread.execute(etxUrl);


            }
        });

        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(MainActivity.this, "Executed after 5 second", Toast.LENGTH_SHORT).show();
            }
        }, 5000);

        btnStartThread=(Button)findViewById(R.id.btnStartThread);

        btnStartThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(MainActivity.this,"Happy Merry Cristums",Toast.LENGTH_SHORT).show();

                            }

                        });
                    }
                });

                thread.start();
            }
        });



        btnFatchData=(Button)findViewById(R.id.btnFetch);

        btnFatchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread threadNetwrk= new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try
                        {
                            Connection connection= Jsoup.connect("http://google.com");

                            final  String title= connection.get().title();

                            Handler handler=new Handler(Looper.getMainLooper());

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    Toast.makeText(MainActivity.this,"Title: "+title,Toast.LENGTH_SHORT).show();

                                }
                            });
                        }

                        catch (IOException e)
                        {

                        }
                    }
                });
                threadNetwrk.start();
            }
        });
    }


    public class BackgroundWorkerThread extends AsyncTask<String,Void,String>

    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog=ProgressDialog.show(MainActivity.this,"Please wait","We are Fatching Your Title",true);

        }

        @Override
        protected String doInBackground(String... params) {

           try
           {
               String url=params[0];

               Connection connection= Jsoup.connect(url);

               String title=connection.get().title();

               return title;
           }
           catch (IOException ioe)
           {

               ioe.printStackTrace();
           }

           catch (IllegalArgumentException iae)
           {
               iae.printStackTrace();
           }

           return null;
        }

        @Override
        protected void onPostExecute(String title) {
            super.onPostExecute(title);
            progressDialog.dismiss();
            
            if(title!=null)
            {
                Toast.makeText(MainActivity.this, "Title is "+title, Toast.LENGTH_SHORT).show();
            }

            else
            {
                Toast.makeText(MainActivity.this, "Exception Occured", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
