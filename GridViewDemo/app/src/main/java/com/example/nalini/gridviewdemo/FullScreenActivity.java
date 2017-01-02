package com.example.nalini.gridviewdemo;

import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class FullScreenActivity extends AppCompatActivity {


    private ImageView imageViewfull;
    private Button btnsetWallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        Intent intent= getIntent();
        final int path=  intent.getIntExtra("image_path",R.mipmap.ic_launcher);

        btnsetWallpaper=(Button)findViewById(R.id.btnset);

        imageViewfull=(ImageView)findViewById(R.id.imgfull);

        imageViewfull.setImageResource(path);

        btnsetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try
            {
             WallpaperManager wallpaperManager=   WallpaperManager.getInstance(FullScreenActivity.this);

                    wallpaperManager.setResource(path);

                    Toast.makeText(FullScreenActivity.this,"Wallpaper set",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
