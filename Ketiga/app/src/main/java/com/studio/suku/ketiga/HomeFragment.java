package com.studio.suku.ketiga;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button tombol = view.findViewById(R.id.tombol);
        tombol.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Sekarang Kita akan Berpindah Ke Fragment yang lain...
        //Lewat Sini
        if (v.getId() == R.id.tombol){
            FragmentManager mfragmentManager = getFragmentManager();
            if (mfragmentManager != null){
                CategoryFragment mcategoryFragment = new CategoryFragment();
                FragmentTransaction mfragmentTransaction = mfragmentManager.beginTransaction();
                //Replace Yang lama dgn yang baru
                mfragmentTransaction.replace(R.id.main, mcategoryFragment, CategoryFragment.class.getSimpleName());
                mfragmentTransaction.addToBackStack(null);
                mfragmentTransaction.commit();
            }
        }
    }
}
