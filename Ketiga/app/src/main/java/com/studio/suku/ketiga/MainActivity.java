package com.studio.suku.ketiga;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Kita Main Fragment Sekarang

        //Nanemim Fragment Cara nya gini
        //Panggilin Alatnya
        FragmentManager mfragmentManager = getSupportFragmentManager();
        FragmentTransaction mfragmentTransaction = mfragmentManager.beginTransaction();
        HomeFragment mhomeFragment = new HomeFragment();

        //Mulai Tanamaken
        //Manggil Fragment
        Fragment fragment = mfragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        //Jika Ada Fragement Yang Dimaksud
        if (!(fragment instanceof  HomeFragment)){
            mfragmentTransaction.add(R.id.main, mhomeFragment, HomeFragment.class.getSimpleName());
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment.class.getSimpleName());
            mfragmentTransaction.commit();
        }

    }
}
