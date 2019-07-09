package com.studio.suku.keempat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PemainAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pemain> pemains;

    public void setPemains(ArrayList<Pemain> pemains){
        this.pemains = pemains;
    }

    public PemainAdapter(Context context){
        this.context = context;
        pemains = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return pemains.size();
    }

    @Override
    public Object getItem(int position) {
        return pemains.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pemain, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Pemain pemain = (Pemain) getItem(position);
        viewHolder.bind(pemain);
        return convertView;
    }

    private class ViewHolder {
        private TextView nama;
        private TextView desc;
        private ImageView gambar;

        ViewHolder(View view){
            nama = view.findViewById(R.id.nama);
            desc = view.findViewById(R.id.desc);
            gambar = view.findViewById(R.id.gambar);
        }

        //Kita Binding Disini
         void bind(Pemain pemain){
            nama.setText(pemain.getNama());
            desc.setText(pemain.getDesc());
            gambar.setImageResource(pemain.getPhoto());
        }
    }
}
