package com.example.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.editText);
    }

    public void ingresar(View view) {

        if(etNombre.getText().toString() == null || etNombre.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Ingrese un nombre", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(this, ListaActivity.class);
            i.putExtra("nombre", etNombre.getText().toString());
            startActivity(i);
        }
    }
}