package com.example.broadcast.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyBackService extends Service {
    public MyBackService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service start", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public boolean stopService(Intent name) {

        Toast.makeText(this, "Service Stop", Toast.LENGTH_SHORT).show();
        return super.stopService(name);
    }
}