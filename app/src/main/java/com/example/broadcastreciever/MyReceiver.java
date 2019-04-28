package com.example.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);

        int sum = a + b;

        // Now send back this result to the MainActivity with
        //LocalBroadcast Manager
        // this Manager only works inside this App ...

        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(context);

        Intent returningIntent = new Intent("my.result.intent");
        returningIntent.putExtra("sum", sum);

        manager.sendBroadcast(returningIntent);


    }
}
