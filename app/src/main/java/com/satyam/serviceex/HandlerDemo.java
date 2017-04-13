package com.satyam.serviceex;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class HandlerDemo extends Activity
{
    ProgressBar bar;
    int update=0;
    TextView txt_update;
    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            bar.incrementProgressBy(5);
            update=update+5;
            txt_update.setText(String.valueOf(update));
        }
    };
    boolean isRunning = false;

    @Override
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar) findViewById(R.id.progressbar);
        txt_update= (TextView) findViewById(R.id.txt_update);
    }
    public void onStart()
    {
        super.onStart();
        bar.setProgress(0);

        Thread background = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    for (int i = 0; i < 20 && isRunning; i++)
                    {
                        Thread.sleep(1000);
                        handler.sendMessage(handler.obtainMessage());
                    }
                }
                catch (Throwable t)
                {
                    // just end the background thread
                }
            }
        });
        isRunning = true;
        background.start();
    }
    public void onStop()
    {
        super.onStop();
        isRunning = false;
    }
}