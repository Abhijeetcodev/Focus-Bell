package com.Developerabhijeet.FocusBell;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Notificationactionservice extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        context.sendBroadcast(new Intent("Start_something")
                .putExtra("actionname",intent.getAction()));
    }
}
