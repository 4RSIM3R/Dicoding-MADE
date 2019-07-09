package com.studio.suku.kedua;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ketiga extends AppCompatActivity {
    public static final String Extra_Object = "extra_person";
    TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketiga);
        tvObject = findViewById(R.id.tv_object_received);
        User user = getIntent().getParcelableExtra(Extra_Object);

        String text = "Name : " + user.getNama() + " Alamat : " + user.getAlamat();

        tvObject.setText(text);
    }
}
