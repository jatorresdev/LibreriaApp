package com.example.aprendiz.libreriaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        txtIdLibro = (EditText) findViewById(R.id.txtIdLibro);
        String _id = txtIdLibro.getText().toString().trim();

        if (!_id.equals("")) {
            Intent i = new Intent(this, Modificar.class);
            i.putExtra("id", _id);
            startActivity(i);
        } else {
            txtIdLibro.setText("");
            Toast.makeText(getApplicationContext(), "Valor invalido, verifique", Toast.LENGTH_SHORT).show();
        }

    }
}
