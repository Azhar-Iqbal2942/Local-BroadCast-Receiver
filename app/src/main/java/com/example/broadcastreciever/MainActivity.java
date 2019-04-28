package com.example.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LocalBroadcastManager mLocalManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocalManager = LocalBroadcastManager.getInstance(this);
    }

    public void normalReceiver(View view) {
        Intent intent = new Intent(this, MyReceiver.class);

        intent.putExtra("a", 10);
        intent.putExtra("b", 20);

        sendBroadcast(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter("my.result.intent");
        mLocalManager.registerReceiver(resultReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mLocalManager.unregisterReceiver(resultReceiver);
    }

    // This @resultReceiver act as Local Broadcast Receiver
    private BroadcastReceiver resultReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int sum = intent.getIntExtra("sum", 0);
            Toast.makeText(context, "sum = " + sum, Toast.LENGTH_SHORT).show();

        }
    };


}
