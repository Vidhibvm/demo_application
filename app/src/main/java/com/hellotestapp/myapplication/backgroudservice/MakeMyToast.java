package com.hellotestapp.myapplication.backgroudservice;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.os.Process;
import android.widget.Toast;



import java.util.Calendar;


public class MakeMyToast extends Service {

    // This method run only one time. At the first time of service created and running
    @Override
    public void onCreate() {
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        Log.e("onCreate()", "After service created");
       // screenshotDetector = new ScreenshotDetector(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Toast.makeText(this, "Screenshot service start", Toast.LENGTH_SHORT).show();
    //    screenshotDetector.start();
        //Here is the source of the TOASTS :D
        //Log.e("TAG", "onStartCommand: " + System.currentTimeMillis()/1000L + 15L *1000L);
        Log.e("onCreate()", "Freshly Made toast");
         Toast.makeText(this, "Freshly Made toast!", Toast.LENGTH_SHORT).show();
        // screenshotDetector.start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding
        return null;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Intent restartService = new Intent(getApplicationContext(),
                this.getClass());
        restartService.setPackage(getPackageName());
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent restartServicePI = PendingIntent.getService(
                getApplicationContext(), 1, restartService,
                PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmService = (AlarmManager)getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        alarmService.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() +1000, restartServicePI);
    }


}