package com.hellotestapp.myapplication.backgroudservice;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

import androidx.annotation.RequiresApi;


import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver
{
    @SuppressLint("NewApi")
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Intent in = new Intent(context, MakeMyToast.class);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            context.startForegroundService(in);
        else
            context.startService(in);*/

        context.startService(in);
        setAlarm(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setAlarm(Context context)
    {

        /*Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.SECOND,1);
*/
        Calendar calendar = Calendar.getInstance();

        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_IMMUTABLE);


       /* PendingIntent pendingIntent = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            pendingIntent = PendingIntent.getActivity
                    (this, 0, notificationIntent, PendingIntent.FLAG_MUTABLE);
        }
        else
        {
            pendingIntent = PendingIntent.getActivity
                    (this, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT);
        }*/

        assert am != null;
       // am.setInexactRepeating(AlarmManager.RTC, Calendar.getInstance().getTimeInMillis() + (2 * 1000),
             //   10000, pi);
        // am.setExactAndAllowWhileIdle(AlarmManager.RTC, (System.currentTimeMillis()/1000L + 15L) *100L, pi);//Next alarm in 15s
      //   am.setInexactRepeating(AlarmManager.RTC_WAKEUP,1000,   5000, pi);//Next alarm in 15s

        am.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() +1000, pi);

     /*   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, 1000, pi);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            am.setExact(AlarmManager.RTC_WAKEUP, 1000, pi);
        } else {
            am.set(AlarmManager.RTC_WAKEUP, 1000, pi);
        }*/

    }
}