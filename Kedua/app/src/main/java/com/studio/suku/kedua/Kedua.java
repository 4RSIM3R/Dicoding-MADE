package com.studio.suku.kedua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Kedua extends AppCompatActivity {
    TextView txt;
    public static final String Extra_Nama = "Ilzam";
    public static final String Extra_Umur = "Umur";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);
        String nama = getIntent().getStringExtra(Extra_Nama);
        int umur = getIntent().getIntExtra(Extra_Umur, 0);
        String masuk = "Nama Saya " + nama + "Umur Saya " + umur;
        txt = findViewById(R.id.txt);
        txt.setText(masuk);
    }
}
