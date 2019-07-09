package com.studio.suku.kesebelas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListPemainAdapter extends RecyclerView.Adapter<ListPemainAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Pemain> pemains;

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Pemain> getListPemain(){
        return pemains;
    }

    public void setListPemain(ArrayList<Pemain> listPemain){
        this.pemains = listPemain;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Kita Inflate Disini
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pemain, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        //Kita Binding Disini Yahhhh
        //GARAPEN VIEWHOLDERE SEK COK!!!
        categoryViewHolder.nama.setText(getListPemain().get(i).getNama());
        categoryViewHolder.asal.setText(getListPemain().get(i).getAsal());

        //Makek Glide Yahhh -> load Image Dari URL

        Picasso.get().load(getListPemain().get(i).getPhoto()).into(categoryViewHolder.gambar);
        
    }

    @Override
    public int getItemCount() {
        return  getListPemain().size();
    }



    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView nama, asal;
        ImageView gambar;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            asal = itemView.findViewById(R.id.asal);
            gambar = itemView.findViewById(R.id.gambar);
        }
    }
}
