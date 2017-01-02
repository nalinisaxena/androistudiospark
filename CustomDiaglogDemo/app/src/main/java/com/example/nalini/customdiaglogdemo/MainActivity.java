package com.example.nalini.customdiaglogdemo;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCustom,btnOkay,btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCustom=(Button)findViewById(R.id.btnCustom);

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_ui);
                dialog.setTitle("title is...");
                dialog.setCanceledOnTouchOutside(false);


               btnOkay=(Button)dialog.findViewById(R.id.btnOk);
               btnOkay.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                         finish();
                   }
               });

                btnCancel=(Button)dialog.findViewById(R.id.btnCancel);

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });

                dialog.show();


            }
        });




    }
}
