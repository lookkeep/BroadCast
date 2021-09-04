package com.example.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.broadcast.service.MyBackService;

public class MyBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, MyBackService.class);
        context.startService(i);

    }
}