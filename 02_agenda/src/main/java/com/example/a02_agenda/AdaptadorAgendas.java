package com.example.a02_agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorAgendas extends RecyclerView.Adapter<AdaptadorAgendas.AgendasViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private final ArrayList<Agenda> datos;
    private View.OnClickListener listener;
    private View.OnLongClickListener listenerlarge;

    public AdaptadorAgendas(ArrayList<Agenda> datos) {
        this.datos = datos;
    }

    @Override
    public boolean onLongClick(View view) {
        if(listenerlarge !=null){
            listenerlarge.onLongClick(view);
            return true;}
        return false;
    }


    public static class AgendasViewHolder extends RecyclerView.ViewHolder{

        private final TextView txtNombre;
        private final TextView txtTelefono;
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
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        AgendasViewHolder tvh =new AgendasViewHolder(itemView);
        return tvh;
    }

    //Asigna cada componente
    @Override
    public void onBindViewHolder(@NonNull AgendasViewHolder holder, int position) {
        Agenda agenda = datos.get(position);
        holder.bindAgendas(agenda);
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

    public void setOnLongClickListener (View.OnLongClickListener listenerlarge)
    {
        this.listenerlarge=listenerlarge;
    }

    @Override
    public void onClick(View view) {
        if(listener !=null){
            listener.onClick(view);}
    }


    //Devuelve el tamaño del array
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public Agenda getContacto(int pos)
    {
        return datos.get(pos);
    }

}
