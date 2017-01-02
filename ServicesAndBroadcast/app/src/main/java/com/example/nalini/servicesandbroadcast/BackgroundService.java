package com.example.nalini.servicesandbroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by nalini on 23/12/16.
 */

public class BackgroundService extends Service {

    @Override
    public void onCreate() {

        Toast.makeText(this,"Count down started,Run.",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {

        CountDownTimer countDownTimer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                Log.d("TAG","Tick Tok, Bomb Deployed.");

            }

            @Override
            public void onFinish() {

                Log.d("TAG","Boom..!!");

            }
        };

       countDownTimer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
