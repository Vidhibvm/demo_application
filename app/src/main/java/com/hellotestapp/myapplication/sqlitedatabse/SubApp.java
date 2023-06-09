package com.hellotestapp.myapplication.sqlitedatabse;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;


public class SubApp extends Application {
    public static String channelId = "";
    public static SubApp instance;
    static SubApp smartApp = null;


    @Override
    public void onCreate() {
        super.onCreate();
        smartApp = this;


        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        instance = this;

    }
    public static SubApp getInstance() {
        return instance;
    }

    public Context getApplicationContext() {
        return super.getApplicationContext();
    }






}
