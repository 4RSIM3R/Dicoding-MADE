package com.studio.suku.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService extends IntentService {

    public static String EXTRA_DURATION = "extra_duration";
    public static String TAG = MyIntentService.class.getSimpleName();


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            //Jadi ini Kita ngasih durasi pada lamanya background proses
            int duration = intent.getIntExtra(EXTRA_DURATION, 0);

            try {
                Thread.sleep(duration);
                Log.d(TAG, "onHandleIntent Selesai");
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

}
