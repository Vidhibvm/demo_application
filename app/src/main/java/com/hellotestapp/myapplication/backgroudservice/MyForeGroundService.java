package com.hellotestapp.myapplication.backgroudservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import android.widget.Toast;


import com.hellotestapp.myapplication.R;

/**
 * this is an example of a service that prompts itself to a foreground service with a persistent
 * notification.  Which is now required by Oreo otherwise, a background service without an app will be killed.
 */

public class MyForeGroundService extends Service {
    boolean isTorchOn = false;


    private final static String TAG = "MyForegroundService";



    public MyForeGroundService() {
    }


    @Override
    public void onCreate() {

        Notification notification = getNotification("MyService is running");
        startForeground(1, notification);
    }

    @Nullable
    @Override
    public ComponentName startForegroundService(Intent service) {

        return super.startForegroundService(service);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();


      /*  ScreenshotDetector screenshotDetector = new ScreenshotDetector(getApplicationContext());
        screenshotDetector.start();*/
        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }

    // build a persistent notification and return it.
    @SuppressLint("WrongConstant")
    public Notification getNotification(String message) {

        return new NotificationCompat.Builder(getApplicationContext(), ServiceMainActivity.id1)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)  //persistent notification!
                .setChannelId(ServiceMainActivity.id1)
                .setContentTitle("Service")   //Title message top row.
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)//message when looking at the notification, second row
                .build();  //finally build and return a Notification.
    }




}
