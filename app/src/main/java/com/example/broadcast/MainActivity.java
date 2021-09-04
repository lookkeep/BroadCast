package com.example.broadcast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.broadcast.receiver.MyBroadCast;
import com.example.broadcast.service.MyBackService;

public class MainActivity extends AppCompatActivity {

    /*
    *
    *  Broadcast receiver
    *  runtime permission
    *  Service
    *  //Content provider
    *
    * */


    MyBroadCast m = new MyBroadCast();
    MyBackService s = new MyBackService();

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = new Intent(MainActivity.this,MyBackService.class);

        MyBroadCast m = new MyBroadCast();
        IntentFilter i = new IntentFilter();
        i.addAction(Intent.ACTION_BATTERY_LOW);
        i.addAction(Intent.ACTION_BATTERY_OKAY);
        registerReceiver(m,i);

    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(m);
    }


    public void req_permission(View view) {

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            // permission granted
            Toast.makeText(this, "Permission is already granted", Toast.LENGTH_SHORT).show();
        }else {
            String myPer[] = {Manifest.permission.READ_CONTACTS,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION};

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(myPer,5);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 5){
            Toast.makeText(this, "Permission ALllow", Toast.LENGTH_SHORT).show();
        }
    }

    public void startSer(View view) {

        startService(i);
    }
    public void StopSer(View view) {
        stopService(i);
    }
}