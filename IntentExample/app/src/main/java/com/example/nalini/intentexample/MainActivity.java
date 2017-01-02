package com.example.nalini.intentexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent=new Intent(MainActivity.this,Second.class);
//        intent.setData(Uri.parse("http://www.pngall.com/wp-content/uploads/2016/05/Teddy-Bear-PNG-HD.png"));
//        startActivity(intent);


//        Intent intent=new Intent(Intent.ACTION_SEND);
//
//
//        intent.putExtra(Intent.EXTRA_TEXT,"Hello");
//
//        intent.setType("text/plain");
//
//        intent.setType("image/*");
//
//        intent.setData(Uri.parse("http://www.pngall.com/wp-content/uploads/2016/05/Teddy-Bear-PNG-HD.png"));
//
//        String title=getResources().getString(R.string.chooser_title);
//
//        Intent chosser=Intent.createChooser(intent,title);
//
//        if(intent.resolveActivity(getPackageManager())!=null)
//        {
//            startActivity(chosser);
//        }



//       String imagePath= Environment.getExternalStorageDirectory()+"/home/nalini/Study/Android images/k1.jpg";
//
//       File file=new File(imagePath);
//
//        Uri uri=Uri.fromFile(file);
//
//        Intent intent=new Intent(Intent.ACTION_SEND);
//
//        intent.putExtra(Intent.EXTRA_STREAM,uri);
//
//        intent.setType("image/*");
//
//        startActivity(intent);


        Intent intent=new Intent(Intent.ACTION_SEND);

        Uri imagepath=Uri.parse("http://www.pngall.com/wp-content/uploads/2016/05/Teddy-Bear-PNG-HD.png");

        intent.setType("image/*");

        intent.putExtra(Intent.EXTRA_STREAM,imagepath);

        startActivity(Intent.createChooser(intent, "Share image using"));


    }
}
