package com.satyam.serviceex;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyService extends IntentService {
    public MyService() {
        super("MyService");
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("sldkfs","onHandleIntent");
      //  Toast.makeText(this, "onHandleIntent", Toast.LENGTH_SHORT).show();

/*
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "onHandleIntent", Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("sldkfs","OnCreate");
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("sldkfs","onStartCommand");
         Toast.makeText(getApplicationContext(), "onStartCommand", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("sldkfs","onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("sldkfs","onUnbind");
        Toast.makeText(this, "onUnbind", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);

    }
    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d("sldkfs","onRebind");
        Toast.makeText(this, "onRebind", Toast.LENGTH_SHORT).show();
    }
}
