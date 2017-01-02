package com.example.nalini.introsliderdemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nalini on 20/12/16.
 */

public class PreManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE=0;

    private static final String PREF_NAME="androidhive_wlecome";

    private static final String IS_FIRST_TIME_LAUNCH="IsFirstTimeLaunch";

    public  PreManager(Context context)
    {
        this.context=context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime)
    {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH,isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch()
    {
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH,true);
    }






}
