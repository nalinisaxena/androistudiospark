package com.example.nalini.imageshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {

    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Intent intent=new Intent(Intent.ACTION_SEND);
//
//                intent.setType("image/*");
//
//                intent.setPackage("com.whatsapp");
//
//                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("/home/nalini/Study/Android images/b2.jpg"+intent));
//
//                startActivity(Intent.createChooser(share,"share image using"));

                Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.b2);

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("image/jpeg");

                ByteArrayOutputStream bytes = new ByteArrayOutputStream();

                b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

                String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                        b, "Title", null);

                Uri imageUri=Uri.parse(path);


                intent.putExtra(Intent.EXTRA_STREAM, imageUri);

                startActivity(Intent.createChooser(intent, "Select"));



            }
        });
    }
}
