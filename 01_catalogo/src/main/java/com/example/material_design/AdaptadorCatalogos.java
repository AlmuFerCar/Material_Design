package com.example.material_design;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorCatalogos extends RecyclerView.Adapter<AdaptadorCatalogos.CatalogosViewHolder> {

    private ArrayList<Catalogo> datos;

    public AdaptadorCatalogos(ArrayList<Catalogo> datos) {
        this.datos = datos;
    }

    public static class CatalogosViewHolder extends RecyclerView.ViewHolder{

        private TextView txtProducto;
        private TextView txtDescripcion;
        public CatalogosViewHolder (View itemView){
            super (itemView);
            this.txtProducto =itemView.findViewById(R.id.producto);
            this.txtDescripcion=itemView.findViewById(R.id.descripcion);
        }

        public void bindCatalogos (Catalogo catalogo)
        {
            txtProducto.setText(catalogo.getProducto());
            txtDescripcion.setText(catalogo.getDescrpcion());
        }
    }

    //Construye la vista
    @Override
    public CatalogosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewTpe)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_component, viewGroup, false);
        CatalogosViewHolder tvh =new CatalogosViewHolder(itemView);
        return tvh;
    }

    //Asigna cada componente
    @Override
    public void onBindViewHolder(@NonNull CatalogosViewHolder holder, int position) {
        Catalogo catalogo = datos.get(position);
        holder.bindCatalogos(catalogo);
    }

    //Devuelve el tamaño del array
    @Override
    public int getItemCount() {
        return datos.size();
    }
}
