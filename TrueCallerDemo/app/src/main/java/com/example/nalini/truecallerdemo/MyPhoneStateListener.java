package com.example.nalini.truecallerdemo;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by nalini on 23/12/16.
 */

public class MyPhoneStateListener extends PhoneStateListener {

    Context context;


    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        Log.d("My Phone Listener",state+"Incoming no:"+incomingNumber);

        if(state==1)
        {

            Toast.makeText(context,"new phone call event.Incoming number:"+incomingNumber,Toast.LENGTH_LONG).show();
        }

        super.onCallStateChanged(state, incomingNumber);


    }
}
