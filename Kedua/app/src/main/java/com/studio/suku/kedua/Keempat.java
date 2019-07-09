package com.studio.suku.kedua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Keempat extends AppCompatActivity implements View.OnClickListener {
    Button kembali;
    RadioGroup pilihan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keempat);
        pilihan = findViewById(R.id.pilihan);
        kembali = findViewById(R.id.kembali);


        kembali.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.kembali) {
            String nama = "";
            int value = 0;
            if (pilihan.getCheckedRadioButtonId() != 0) {

                switch (pilihan.getCheckedRadioButtonId()) {
                    case R.id.a:
                        value = 50;
                        nama = "Ilzam";
                        break;
                    case R.id.b:
                        value = 100;
                        nama = "Ilzam";
                        break;
                    case R.id.c:
                        value = 150;
                        nama = "Ilzam";
                        break;
                }
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", value);
            setResult(RESULT_OK, resultIntent);
            finish();

        }
    }
}

