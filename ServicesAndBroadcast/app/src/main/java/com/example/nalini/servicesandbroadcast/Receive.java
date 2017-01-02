package com.example.nalini.servicesandbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by nalini on 23/12/16.
 */

public class Receive extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Headphone connected and disconnected",Toast.LENGTH_SHORT).show();

    }
}
