package com.example.a02_agenda;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Agenda> datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        datos= new ArrayList<Agenda>();

        for(int i=0; i<11; i++)
        {
            datos.add(new Agenda("Nombre: "+i, "Telefono: "+i));
        }

        AdaptadorAgendas adaptadorAgendas = new AdaptadorAgendas(datos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adaptadorAgendas);

       adaptadorAgendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Mi App", "Pulsado el elemento"+recyclerView.getChildAdapterPosition(v));
            }
        });

       adaptadorAgendas.setOnLongClickListener(new View.OnLongClickListener(){

           @Override
           public boolean onLongClick(View view) {
               borrarElemento(datos,adaptadorAgendas, view);
               return false;
           }

       });
    }

    public void borrarElemento(ArrayList<Agenda> d, AdaptadorAgendas ad, View view)
    {
        d.remove((int)recyclerView.getChildAdapterPosition(view));
        ad.notifyItemRemoved(recyclerView.getChildAdapterPosition(view));
    }

}