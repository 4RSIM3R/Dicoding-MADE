package com.studio.suku.viewmodel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {
    //This Is An Adapter For Recycler View

    private ArrayList<WeatherItems> weatherItems = new ArrayList<>();

    public void setData(ArrayList<WeatherItems> items){
        weatherItems.clear();
        weatherItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_items, viewGroup,
        false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //Binding In Below
        myViewHolder.bind(weatherItems.get(i));
    }

    @Override
    public int getItemCount() {
        return weatherItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNamaKota;
        TextView textViewTemperature;
        TextView textViewDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNamaKota = itemView.findViewById(R.id.textKota);
            textViewTemperature = itemView.findViewById(R.id.textTemp);
            textViewDescription = itemView.findViewById(R.id.textDesc);
        }

        //There Is A Function To Bind Data
        public void bind(WeatherItems weatherItems){
            textViewNamaKota.setText(weatherItems.getName());
            textViewTemperature.setText(weatherItems.getTemperature());
            textViewDescription.setText(weatherItems.getDescription());

        }
    }
}
