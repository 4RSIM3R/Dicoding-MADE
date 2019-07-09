package com.studio.suku.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button service, intent_service, start_bound_service, stop_bound_service;
    boolean mServiceBound = false;
    BoundService mBoundService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = findViewById(R.id.start_service);
        service.setOnClickListener(this);

        intent_service = findViewById(R.id.start_intent_service);
        intent_service.setOnClickListener(this);

        start_bound_service = findViewById(R.id.btn_start_bound_service);
        start_bound_service.setOnClickListener(this);

        stop_bound_service = findViewById(R.id.btn_stop_bound_service);
        stop_bound_service.setOnClickListener(this);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mServiceBound) {
            unbindService(serviceConnection);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service : {
                //Panggil Service Disini
                Intent mulai = new Intent(MainActivity.this, OriginService.class);
                startService(mulai);
                break;
            }
            case R.id.start_intent_service : {
                Intent mulai = new Intent(MainActivity.this, MyIntentService.class);
                mulai.putExtra(MyIntentService.EXTRA_DURATION, 5000);
                startService(mulai);
                break;
            }
            case R.id.btn_start_bound_service : {
                Intent mulai = new Intent(MainActivity.this, BoundService.class);
                bindService(mulai, serviceConnection, BIND_AUTO_CREATE);
                break;
            }
            case R.id.btn_stop_bound_service : {
                unbindService(serviceConnection);
                break;
            }
        }
    }
}
