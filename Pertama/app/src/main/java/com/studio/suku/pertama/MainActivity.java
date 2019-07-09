package com.studio.suku.pertama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//Jadi ini ada implement untuk ngedeteksi Click yang ada di layar
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Bismillah Budal Nang Amerika
    EditText edtPanjang, edtLebar, edtTinggi;
    Button tombol;
    TextView hasil;
    //Saving State Supaya Hasil Hitungannya Gak Hilang
    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, hasil.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edtPanjang = findViewById(R.id.panjang);
        edtLebar = findViewById(R.id.lebar);
        edtTinggi = findViewById(R.id.tinggi);
        tombol = findViewById(R.id.hitung);
        hasil = findViewById(R.id.hasil);

        //Mulai dari sini yahh kita daftarin button kita
        tombol.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            hasil.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.hitung){
            //Jadi klo tombol nya di tekan kita ngerjain sesuatu

            //Tangkap Inputannya
            String iPanjang = edtPanjang.getText().toString().trim();
            String iLebar = edtLebar.getText().toString().trim();
            String iTinggi = edtTinggi.getText().toString().trim();

            boolean isKosong = false;
            boolean isInvalid = false;

            //Check Apakah Inputannya Kosong atau tidak

            if (TextUtils.isEmpty(iPanjang)){
                isKosong = true;
                edtPanjang.setError("Panjang Nya Di Isi Yahh");
            }
            if (TextUtils.isEmpty(iLebar)){
                isKosong = true;
                edtLebar.setError("Panjang Nya Di Isi Yahh");
            }
            if (TextUtils.isEmpty(iTinggi)){
                isKosong = true;
                edtTinggi.setError("Tinggi Nya Di Isi Yahh");
            }
            Double tinggi = toDouble(iTinggi);
            Double lebar = toDouble(iLebar);
            Double panjang = toDouble(iPanjang);
            //Checking Double nggk nya
            if (tinggi == null){
                isInvalid = true;
                edtTinggi.setError("Masukkan Angka yang valid");
            }
            if (lebar == null){
                isInvalid = true;
                edtLebar.setError("Masukkan Angka yang valid");
            }
            if (panjang == null){
                isInvalid = true;
                edtPanjang.setError("Masukkan Angka yang valid");
            }

            if (!isKosong && !isInvalid){
                Double volume = panjang * lebar * tinggi;
                hasil.setText(String.valueOf(volume));

            }
        }
    }

    //Kita Buat Fungsi untuk ngecheck apakah ini type Double atau bukan
    Double toDouble(String str){
        try {
            return Double.valueOf(str);
        }
        catch (NumberFormatException e){
            return null;
        }
    }
}
