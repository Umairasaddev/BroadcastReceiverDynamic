package com.example.broadcastreceiverdynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean noConnectivity  =  intent.getBooleanExtra(  //method retreive extra no connectivity with intent.getBooleanExtra(String,boolean value)
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);//extra no connectivity means complete lack of connectivity like blkl connection hatam

            if (noConnectivity)
            {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
