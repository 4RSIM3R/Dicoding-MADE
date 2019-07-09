package com.studio.suku.ketiga;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener{
    //Seperti Biasa inialisasi Untuk data kiriman
    public static String EXTRA_JUDUL = "extra_judul";
    public static String EXTRA_DESC = "extra_desc";
    private String description;

    public String getDescription(){
        return description;
    }

    public void setDescription(String str){
        this.description = str;
    }

    TextView judul, deskripsi, kiriman;
    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Tangkap Element nya
        judul = view.findViewById(R.id.judul);
        deskripsi = view.findViewById(R.id.deskripsi);
        kiriman = view.findViewById(R.id.kiriman);
        Button profile = view.findViewById(R.id.profile);
        Button dialog = view.findViewById(R.id.dialog);
        dialog.setOnClickListener(this);
        profile.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String kiriman = getArguments().getString(EXTRA_JUDUL);
        String jelas = getArguments().getString(EXTRA_DESC);
        judul.setText(kiriman);
        deskripsi.setText(jelas);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog : {
                OptionFragment moptionFragment = new OptionFragment();
                FragmentManager mfragmentManager = getFragmentManager();
                moptionFragment.show(mfragmentManager, OptionFragment.class.getSimpleName());
            }
        }
    }

    OptionFragment.OnOptionDialogListener optionDialogListener = new OptionFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            //Toast Nya disini
            Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
        }
    };
}
