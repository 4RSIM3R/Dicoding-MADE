package com.studio.suku.kedua;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button biasa, dgn_data, dgn_obyek, implicit, gondol;
    TextView txt;
    private int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        biasa = findViewById(R.id.biasa);
        dgn_data = findViewById(R.id.dgn_data);
        dgn_obyek = findViewById(R.id.dgn_obyek);
        implicit = findViewById(R.id.implicit);
        gondol = findViewById(R.id.gondol);
        txt = findViewById(R.id.hasil);
        biasa.setOnClickListener(this);
        dgn_data.setOnClickListener(this);
        dgn_obyek.setOnClickListener(this);
        implicit.setOnClickListener(this);
        gondol.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.biasa : {
                //Kita Lakukan Intent Disini
                //Intent(KelasAsal.this, Tujuan.class);
                Intent pindah = new Intent(MainActivity.this, Pertama.class);
                startActivity(pindah);
                break;
            }
            case R.id.dgn_data: {
                Intent pindah = new Intent(MainActivity.this, Kedua.class);
                pindah.putExtra(Kedua.Extra_Nama, "Ilzam");
                pindah.putExtra(Kedua.Extra_Umur, 17);
                startActivity(pindah);
                break;
            }
            case R.id.dgn_obyek : {
                Intent pindah = new Intent(MainActivity.this, Ketiga.class);
                User user = new User();
                user.setNama("Ilzam");
                user.setAlamat("Pakijangan");
                pindah.putExtra(Ketiga.Extra_Object, user);
                startActivity(pindah);
                break;
            }
            case R.id.implicit : {
                String no_hp = "081217141850";
                Intent pindah = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+no_hp));
                startActivity(pindah);
                break;
            }
            case R.id.gondol : {
                Intent pindah = new Intent(MainActivity.this, Keempat.class);
                //AWAS KELIRUUUUU
                startActivityForResult(pindah, 1);
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                    int result = data.getIntExtra("result", 0);
                    txt.setText("" + result);
            }
        }
    }
}

