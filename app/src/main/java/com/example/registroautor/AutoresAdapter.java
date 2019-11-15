package com.example.registroautor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AutoresAdapter extends  RecyclerView.Adapter<AutoresAdapter.AutorViewHolder> {


    private Context mCtx;
    private List<Dto_autor> AutoresList;

    public AutoresAdapter(Context mCtx, List<Dto_autor> AutoresList) {
        this.mCtx = mCtx;
        this.AutoresList = AutoresList;
    }

    @Override
    public AutorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
       View view = inflater.inflate(R.layout.list_layout, null);
        return new AutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AutorViewHolder holder, int position) {
        Dto_autor Autor = AutoresList.get(position);

        //loading the image


    }

    @Override
    public int getItemCount() {
        return AutoresList.size();
    }

    public static class AutorViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDUI, textViewNombreAutor, textViewEdad, textViewDescripcion;

        public AutorViewHolder(View itemView) {
            super(itemView);

          //  textViewDUI = itemView.findViewById(R.id.textViewDUI);
           // textViewNombreAutor = itemView.findViewById(R.id.textViewNombreAutor);
           // textViewEdad = itemView.findViewById(R.id.textViewEdad);
            //textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);

        }

    }

}

