package com.example.registroautor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorHimnarios extends  RecyclerView.Adapter<AdaptadorHimnarios.HimnariosViewHolder> {


    private Context mCtx;
    private List<Himnarios> HimnariosList;

    public AdaptadorHimnarios(Context mCtx, List<Himnarios> HimnariosList) {
        this.mCtx = mCtx;
        this.HimnariosList = HimnariosList;
    }

    @Override
    public HimnariosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout2, null);
        return new HimnariosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HimnariosViewHolder holder, int position) {
        Himnarios Himnarios = HimnariosList.get(position);

        //loading the image


    }

    @Override
    public int getItemCount() {
        return HimnariosList.size();
    }

    public static class HimnariosViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDescripcionAut, textViewTituloAla1, textViewFecha1;

        public HimnariosViewHolder(View itemView) {
            super(itemView);

            textViewDescripcionAut = itemView.findViewById(R.id.textViewDescripcionAut);
            textViewTituloAla1 = itemView.findViewById(R.id.textViewTituloAla1);
            textViewFecha1 = itemView.findViewById(R.id.textViewFecha1);


        }

    }

}