package com.studio.suku.kesebelas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CardPemainAdapter extends RecyclerView.Adapter<CardPemainAdapter.CardViewHolder>{
    private Context context;
    private ArrayList<Pemain> pemains;

    private ArrayList<Pemain> pemains(){
        return pemains;
    }

    public void setPemains(ArrayList<Pemain> pemains){
        this.pemains = pemains;
    }

    public CardPemainAdapter(Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public CardPemainAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pemain_card, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardPemainAdapter.CardViewHolder cardViewHolder, int i) {
        Pemain pemain = pemains.get(i);

        cardViewHolder.nama.setText(pemain.getNama());
        cardViewHolder.asal.setText(pemain.getAsal());

        Picasso.get().load(pemain.getPhoto()).into(cardViewHolder.gambar);

        //Set Onclick Listener
        cardViewHolder.favorit.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + pemains().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewHolder.share.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + pemains().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return pemains().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView gambar;
        TextView nama, asal;
        Button favorit, share;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.card_item_photo);
            nama = itemView.findViewById(R.id.card_item_name);
            asal = itemView.findViewById(R.id.card_item_from);
            favorit = itemView.findViewById(R.id.btn_set_favorite);
            share = itemView.findViewById(R.id.btn_set_share);
        }
    }
}


