package com.example.a02_agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorAgendas extends RecyclerView.Adapter<AdaptadorAgendas.AgendasViewHolder> {

    private ArrayList<Agenda> datos;

    public AdaptadorAgendas(ArrayList<Agenda> datos) {
        this.datos = datos;
    }

    public static class AgendasViewHolder extends RecyclerView.ViewHolder{

        private TextView txtNombre;
        private TextView txtTelefono;
        public AgendasViewHolder (View itemView){
            super (itemView);
            this.txtNombre =itemView.findViewById(R.id.nombre);
            this.txtTelefono=itemView.findViewById(R.id.telefono);
        }

        public void bindAgendas(Agenda agenda)
        {
            txtNombre.setText(agenda.getNombre());
            txtTelefono.setText(agenda.getTelefono());
        }
    }

    //Construye la vista
    @Override
    public AgendasViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewTpe)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_component, viewGroup, false);
        AgendasViewHolder tvh =new AgendasViewHolder(itemView);
        return tvh;
    }

    //Asigna cada componente
    @Override
    public void onBindViewHolder(@NonNull AgendasViewHolder holder, int position) {
        Agenda agenda = datos.get(position);
        holder.bindAgendas(agenda);
    }

    //Devuelve el tamaño del array
    @Override
    public int getItemCount() {
        return datos.size();
    }
}
