package com.example.aprendiz.libreriaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MyBDSqlite db;
    EditText id, nombre, autor, editorial, tipoLiteratura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.etId);
        nombre = (EditText) findViewById(R.id.etNombre);
        autor = (EditText) findViewById(R.id.etAutor);
        editorial = (EditText) findViewById(R.id.etEditorial);
        tipoLiteratura = (EditText) findViewById(R.id.etTipoLiteratura);

        db = new MyBDSqlite(this);
    }

    public void onClickAgregar(View myView) {
        Libreria libro = new Libreria(Integer.parseInt(id.getText().toString()),
                nombre.getText().toString(),
                autor.getText().toString(),
                editorial.getText().toString(),
                tipoLiteratura.getText().toString());

        db.agregarLibro(libro);

        limpiarCampos();
    }

    public void onClickMostrarLista(View myView) {
        Intent i = new Intent(this, ListarLibros.class);
        startActivity(i);
    }

    public void onClickModificar(View myView) {
        Intent i = new Intent(this, PreModificar.class);
        startActivity(i);
    }

    private void limpiarCampos() {
        id.setText("");
        nombre.setText("");
        autor.setText("");
        editorial.setText("");
        tipoLiteratura.setText("");
    }
}
