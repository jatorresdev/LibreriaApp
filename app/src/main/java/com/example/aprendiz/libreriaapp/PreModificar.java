package com.example.aprendiz.libreriaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by APRENDIZ on 10/06/2016.
 */
public class PreModificar extends AppCompatActivity {

    EditText txtIdLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_modificar);
        txtIdLibro = (EditText) findViewById(R.id.txtIdLibro);
    }

    // Metodo para el boton premodificar
    public void modificarOnClick(View mv) {
        Intent i = new Intent(this, Modificar.class);
        txtIdLibro = (EditText) findViewById(R.id.txtIdLibro);
        i.putExtra("id", txtIdLibro.getText().toString());
        startActivity(i);
    }
}
