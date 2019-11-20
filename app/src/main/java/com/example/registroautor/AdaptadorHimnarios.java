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

public AdaptadorHimnarios(Context mCtx, List<Dto_autor> AutoresList) {
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
        Himnarios Himnario = HimnariosList.get(position);

        //loading the image


        }

@Override
public int getItemCount() {
        return HimnariosList.size();
        }

public static class HimnariosViewHolder extends RecyclerView.ViewHolder {

    TextView textViewDui1, textViewNombre1, textViewEdad1, textViewDescripcion1;

    public HimnariosViewHolder(View itemView) {
        super(itemView);

        //  textViewDUI = itemView.findViewById(R.id.textViewDUI);
        // textViewNombreAutor = itemView.findViewById(R.id.textViewNombreAutor);
        // textViewEdad = itemView.findViewById(R.id.textViewEdad);
        //textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);

        textViewDui1 = itemView.findViewById(R.id.textViewCodigo1);
        textViewNombre1 = itemView.findViewById(R.id.textViewPrecio1);
        textViewEdad1 = itemView.findViewById(R.id.textViewPrecio1);
        textViewDescripcion1 = itemView.findViewById(R.id.textViewDescripcion1);

    }

}


}

