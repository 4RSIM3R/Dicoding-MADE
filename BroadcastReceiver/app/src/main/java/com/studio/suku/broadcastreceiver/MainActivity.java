package com.studio.suku.broadcastreceiver;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button permission, download;
    public static final String ACTION_DOWNLOAD_STATUS = "download_status";
    private BroadcastReceiver downloadReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permission = findViewById(R.id.btn_permission);
        download = findViewById(R.id.btn_download);
        permission.setOnClickListener(this);
        download.setOnClickListener(this);

        //Buat Objek Untuk Di daftarkan
        downloadReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(DownloadService.TAG, "Download Selesai");
                Toast.makeText(context, "Download Selesai", Toast.LENGTH_SHORT).show();
            }
        };

        IntentFilter downloadIntentFilter = new IntentFilter(ACTION_DOWNLOAD_STATUS);

        registerReceiver(downloadReceiver, downloadIntentFilter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_permission){
            // Buat Allow Kita nerima
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.RECEIVE_SMS)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.RECEIVE_SMS)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.RECEIVE_SMS},
                            SMS_REQUEST_CODE);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }

        }
        else if (v.getId() == R.id.btn_download){
            //Jalanin Service Disini
            Intent downloadServiceIntent = new Intent(this, DownloadService.class);
            startService(downloadServiceIntent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Kita Unregister Saat Activity Udh di destroy
        if (downloadReceiver != null){
            unregisterReceiver(downloadReceiver);
        }
    }

    //Kode Verifikasi
    final int SMS_REQUEST_CODE = 101;
    //Klo Request Buat Baca Sms Di Bolehin
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if (requestCode == SMS_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Sms receiver permission diterima", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sms receiver permission ditolak", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

