package com.example.broadcastreceiverdynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

    public class MainActivity extends AppCompatActivity {


//first step
        //create receiver
        AirplaneModeChangeReceiver airplaneModeChangeReceiver = new AirplaneModeChangeReceiver();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        @Override
        protected void onStart() {
            //Monitor network connections (Wi-Fi, GPRS, UMTS, etc.) Send broadcast intents when network connectivity changes
            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);//jesy koi connectivity action perform ho ga like on off plugin
            //registering receiver
//second step
            //register receiver
            registerReceiver(airplaneModeChangeReceiver,filter);
            super.onStart();
        }

        @Override
        protected void onStop() {
            //we have to unregister receiver once it is not in use or activity is closed
            unregisterReceiver(airplaneModeChangeReceiver);
            super.onStop();
        }
    }


