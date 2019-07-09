package com.studio.suku.ketiga;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionFragment extends DialogFragment implements View.OnClickListener{

    Button tutup, pilih;
    RadioButton ilzam, suku;
    RadioGroup pilihan;
    OnOptionDialogListener optionDialogListener;


    public OptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tutup = view.findViewById(R.id.btn_close);
        pilih = view.findViewById(R.id.btn_choose);
        pilihan = view.findViewById(R.id.pilihan);
        ilzam = view.findViewById(R.id.ilzam);
        suku = view.findViewById(R.id.Suku);

        tutup.setOnClickListener(this);
        pilih.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Fragment fragment = getParentFragment();

        if (fragment instanceof  DetailFragment){
            DetailFragment detailFragment = (DetailFragment) fragment;
            this.optionDialogListener = detailFragment.optionDialogListener;
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close : {
                getDialog().cancel();
                break;
            }
            case R.id.btn_choose : {
                //Ngirim Dia Balik Ke Parent nya
                DetailFragment fragment = (DetailFragment) getActivity().getSupportFragmentManager().findFragmentByTag("DetailFragment");
                fragment.kiriman.setText("Alhamdulillah Bisa");
                getDialog().dismiss();
                }
                break;
            }

        }
    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }
    }

