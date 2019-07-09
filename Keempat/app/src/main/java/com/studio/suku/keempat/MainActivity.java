package com.studio.suku.keempat;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Buat Dulu Dummy Data nya
    String[] dummy = {"Suku", "Ilzam", "Arasimer", "zamel"};
    //Sekarang Gak Pakek Dummy Lagi Tapi kita ambil dari strings.xml
    private String[] dataNama;
    private String[] dataDesc;
    private TypedArray dataPhoto;
    private PemainAdapter adapter;
    private ArrayList<Pemain> pemains;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Buat Adapter nya
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.activity_list_item, android.R.id.text1, dummy);
        adapter = new PemainAdapter(this);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);

        persiapan();
        addItem();


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, pemains.get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItem(){
        pemains = new ArrayList<>();

        //Looping Dan Masukkan
        for (int i = 0; i < dataNama.length; i++){
            Pemain pemain = new Pemain();
            pemain.setNama(dataNama[i]);
            pemain.setDesc(dataDesc[i]);
            pemain.setPhoto(dataPhoto.getResourceId(i, -1));
            pemains.add(pemain);
        }
        adapter.setPemains(pemains);
    }

    private void persiapan(){
        dataNama = getResources().getStringArray(R.array.list_nama);
        dataDesc = getResources().getStringArray(R.array.list_desc);
        dataPhoto = getResources().obtainTypedArray(R.array.list_gambar);
    }
}
