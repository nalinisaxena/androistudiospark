package com.example.nalini.webviewdemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {

    private Switch switchABColor,switchLoadImages,switchJavaScript;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);


        switchABColor=(Switch)findViewById(R.id.SwitchABColor);
        switchLoadImages=(Switch)findViewById(R.id.SwitchLoadimages);
        switchJavaScript=(Switch)findViewById(R.id.SwichJavaScript);



                   boolean colorFlag=sharedPreferences.getBoolean("SWITCH_COLOR",false);

                   if(colorFlag) {
                       switchABColor.setChecked(true);
                   }
                   else {
                       switchABColor.setChecked(false);
                   }


               switchABColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                   sharedPreferences.edit().putBoolean("SWITCH_COLOR",isChecked).apply();

               }
             });


                  boolean loadimage=sharedPreferences.getBoolean("SWITCH_IMAGES",true);

                     if(loadimage) {
                         switchLoadImages.setChecked(true);
                     }
                     else {
                         switchLoadImages.setChecked(false);
                     }

                   switchLoadImages.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                       @Override
                       public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                           sharedPreferences.edit().putBoolean("SWITCH_IMAGES",b).apply();
                       }
                   });




                        boolean switchJava=sharedPreferences.getBoolean("SWITCH_JAVASCRIPT",true);

                        switchJavaScript.setChecked(switchJava);

                        switchJavaScript.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                sharedPreferences.edit().putBoolean("SWITCH_JAVASCRIPT",isChecked).apply();
                            }
                        });

    }
}
