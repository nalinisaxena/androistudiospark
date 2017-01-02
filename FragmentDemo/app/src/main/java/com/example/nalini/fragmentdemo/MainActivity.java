package com.example.nalini.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btnNowPlaying,btnUpcoming,btnReleasing;

    private FragmentManager fragmentManager;

    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();

        btnNowPlaying=(Button)findViewById(R.id.btnNowPlaying);
        btnUpcoming=(Button)findViewById(R.id.btnUpcoming);
        btnReleasing=(Button)findViewById(R.id.btnReleasingSoon);


        btnNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentOne fragmentOne=new FragmentOne();

                  fragmentManager.beginTransaction().
                          setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.fade_out).
                          replace(R.id.container,fragmentOne).commit();
            }

        });


        btnUpcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTwo fragmentTwo=new FragmentTwo();

                fragmentManager.beginTransaction().
                        setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.fade_out).
                        replace(R.id.container,fragmentTwo).
                        commit();


            }
        });


        btnReleasing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();

                bundle.putInt("INT_VLAUE_TEST",i++);

                bundle.putInt("IMAGE_PATH",R.drawable.spider);


                FragmentThree fragmentThree=new FragmentThree();

                fragmentThree.setArguments(bundle);

                fragmentManager.beginTransaction().
                        setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.fade_out).
                        replace(R.id.container,fragmentThree).commit();
            }
        });



    }
}
