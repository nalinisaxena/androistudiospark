package com.example.nalini.truecallerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by nalini on 23/12/16.
 */

public class InComingCall extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        try {

            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);

            MyPhoneStateListener myPhoneStateListener = new MyPhoneStateListener();

            telephonyManager.listen(myPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);

        }

        catch (Exception e)
        {
            Log.e("Phone Receive error"," "+e);
        }


    }
}
