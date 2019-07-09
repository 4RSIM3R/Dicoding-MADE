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
public class CategoryFragment extends Fragment implements View.OnClickListener {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button lagi = view.findViewById(R.id.lagi);
        lagi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.lagi){
            //Kita Lakuin Intent Dgn ngirim data tapi dalam Fragment
            DetailFragment mdetailFragment = new DetailFragment();
            //Kita Bungkus pakek Bundle yahhh
            Bundle mbundle = new Bundle();
            mbundle.putString(DetailFragment.EXTRA_JUDUL, "Abah Suku Ganteng");
            mbundle.putString(DetailFragment.EXTRA_DESC, "Ini Penjelasannya");
            //Nah Deskripsi nya gak dari bundle..
            //Tapi dari Setter Getter Mereka Sendiri
            mdetailFragment.setArguments(mbundle);
            mdetailFragment.setDescription("Bismillah Budal Amerika");

            FragmentManager mfragmentManager = getFragmentManager();
            if (mfragmentManager != null){
                FragmentTransaction mfragmentTransaction = mfragmentManager.beginTransaction();
                mfragmentTransaction.replace(R.id.main, mdetailFragment, DetailFragment.class.getSimpleName());
                mfragmentTransaction.addToBackStack(null);
                mfragmentTransaction.commit();
            }
        }
    }
}
