package com.studio.suku.broadcastreceiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmsReceiverActivity extends AppCompatActivity implements View.OnClickListener{
    TextView dari, isi;
    Button tutup;

    public static final String EXTRA_SMS_NO = "extra_sms_no";
    public static final String EXTRA_SMS_MESSAGE = "extra_sms_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);

        dari = findViewById(R.id.tv_no);
        isi = findViewById(R.id.tv_message);
        tutup = findViewById(R.id.btn_close);

        tutup.setOnClickListener(this);

        String pengirim = getIntent().getStringExtra(EXTRA_SMS_NO);
        String pesan = getIntent().getStringExtra(EXTRA_SMS_MESSAGE);

        dari.setText(pengirim);
        isi.setText(pesan);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_close) {
            finish();
        }
    }
}
