package com.example.a02_agenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Agenda> datos;
    public Agenda contacto;
    public static String CONTACTO;
//    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.recycler);
        datos= new ArrayList<Agenda>();

        getSupportActionBar().setDisplayShowTitleEnabled(false);


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
//                Log.i("Mi App", "Pulsado el elemento"+recyclerView.getChildAdapterPosition(v));
//                adaptadorAgendas.getContacto(recyclerView.getChildAdapterPosition(v));
                contacto= adaptadorAgendas.getContacto(recyclerView.getChildAdapterPosition(v));
                paginaSiguiente();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void borrarElemento(ArrayList<Agenda> d, AdaptadorAgendas ad, View view)
    {
        d.remove((int)recyclerView.getChildAdapterPosition(view));
        ad.notifyItemRemoved(recyclerView.getChildAdapterPosition(view));
    }

    public void paginaSiguiente()
    {
        Bundle b=new Bundle();
        b.putSerializable(CONTACTO, contacto);
        Intent intent=new Intent(this, AgendaContactoActivity.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}