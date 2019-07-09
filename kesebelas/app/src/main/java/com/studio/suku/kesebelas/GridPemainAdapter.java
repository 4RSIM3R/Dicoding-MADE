package com.studio.suku.kesebelas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridPemainAdapter extends RecyclerView.Adapter<GridPemainAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Pemain> pemains;



    private ArrayList<Pemain> getPemains(){
        return pemains;
    }

    public GridPemainAdapter(Context context){
        this.context = context;
    }

    public void setPemains(ArrayList<Pemain> pemains){
        this.pemains = pemains;
    }
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pemain_grid, viewGroup, false);
        return new GridViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        //Bind Pakek Picasso
        Picasso.get().load(getPemains().get(i).getPhoto()).into(gridViewHolder.gambar);
        gridViewHolder.gambar.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getPemains().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getPemains().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView gambar;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
