package com.example.taller1;
import android.content.Intent;
import android.view.View;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        getActionBar();

        String nombre = getIntent().getStringExtra("nombre");
        if(nombre != null){
            setTitle(nombre);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String[] pantallas = new String[3];
        pantallas[0] = "Pantalla 1";
        pantallas[1] = "Pantalla 2";
        pantallas[2] = "Pantalla 3";

        mAdapter = new MyAdapter(pantallas);
        recyclerView.setAdapter(mAdapter);
    }



    public void verMas (View view){
        Intent i = new Intent(this, DetailsActivity.class);
        Object id = view.getId();
        Bundle parametros = new Bundle();
        parametros.putString("id", id.toString());
        i.putExtras(parametros);
        startActivity(i);
    }



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Presione otra vez para salir", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
