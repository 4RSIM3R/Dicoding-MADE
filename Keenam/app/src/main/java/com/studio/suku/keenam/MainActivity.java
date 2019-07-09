package com.studio.suku.keenam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set Action Bar hya
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Google Pixel");
        }
    }
}
