package com.studio.suku.broadcastreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

public class DownloadService extends IntentService {

    public static String TAG = DownloadService.class.getSimpleName();
    public DownloadService() {
        super("DownloadService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //Kita Kasih Notify Klo udh selese Donwload nya
            Intent notifyFinishIntent = new Intent(MainActivity.ACTION_DOWNLOAD_STATUS);
            sendBroadcast(notifyFinishIntent);
        }
    }


}
