package com.studio.suku.kelima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView{
    EditText panjang, tinggi, lebar;
    Button hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panjang = findViewById(R.id.panjang);
        tinggi = findViewById(R.id.tinggi);
        lebar = findViewById(R.id.lebar);
        hitung = findViewById(R.id.hitung);
        hasil = findViewById(R.id.hasil);

        final MainPresenter mainPresenter = new MainPresenter(this);

        hitung.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String ipanjang = panjang.getText().toString().trim();
                String itinggi = tinggi.getText().toString().trim();
                String ilebar = lebar.getText().toString().trim();

                boolean kosongkah = false;

                if (TextUtils.isEmpty(ipanjang)){
                    kosongkah = true;
                    panjang.setError("Isi Panjang nya");
                }

                if (TextUtils.isEmpty(itinggi)){
                    kosongkah = true;
                    tinggi.setError("Isi Tinggi nya");
                }

                if (TextUtils.isEmpty(ilebar)){
                    kosongkah = true;
                    lebar.setError("Isi Lebar nya");
                }

                if (!kosongkah){
                    double p = Double.parseDouble(ipanjang);
                    double l = Double.parseDouble(ilebar);
                    double t = Double.parseDouble(itinggi);

                    mainPresenter.calculateVolume(p, t, l);
                }

            }
        });

    }

    @Override
    public void showVolume(MainModel mainModel) {
        hasil.setText(String.valueOf(mainModel.getVolume()));
    }
}
