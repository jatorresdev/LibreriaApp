package com.example.aprendiz.libreriaapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by APRENDIZ on 10/06/2016.
 */
public class Modificar extends AppCompatActivity {

    MyBDSqlite base;
    EditText id, nombre, autor, editorial, tipoLiteratura;
    int vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        id = (EditText) findViewById(R.id.etId);
        nombre = (EditText) findViewById(R.id.etNombre);
        autor = (EditText) findViewById(R.id.etAutor);
        editorial = (EditText) findViewById(R.id.etEditorial);
        tipoLiteratura = (EditText) findViewById(R.id.etTipoLiteratura);

        base = new MyBDSqlite(this);

        Intent i = getIntent();
        vid = Integer.parseInt(i.getStringExtra("id"));
        Cursor c = base.buscarLibro(vid);

        //Cargamos los datos del cursor a nuestra interface
        id.setText(c.getString(c.getColumnIndexOrThrow("_id")));
        nombre.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
        autor.setText(c.getString(c.getColumnIndexOrThrow("autor")));
        editorial.setText(c.getString(c.getColumnIndexOrThrow("editorial")));
        tipoLiteratura.setText(c.getString(c.getColumnIndexOrThrow("tipo_literatura")));
    }

    public void confirmarModificar(View mv) {
        Libreria libro = new Libreria(Integer.parseInt(id.getText().toString()),
                nombre.getText().toString(),
                autor.getText().toString(),
                editorial.getText().toString(),
                tipoLiteratura.getText().toString());

        base.actualizarLibro(libro);
        goListLibros();

        Toast.makeText(getApplicationContext(), "Libro actualizado " + libro.getNombre(), Toast.LENGTH_SHORT).show();
    }

    public void confirmarEliminar(View mv) {
        Libreria libro = new Libreria(Integer.parseInt(id.getText().toString()),
                nombre.getText().toString(),
                autor.getText().toString(),
                editorial.getText().toString(),
                tipoLiteratura.getText().toString());

        base.eliminarLibro(libro);

        goListLibros();
        Toast.makeText(getApplicationContext(), "Libro eliminado " + libro.getNombre(), Toast.LENGTH_SHORT).show();
    }

    public void goListLibros() {
        Intent i = new Intent(this, ListarLibros.class);
        startActivity(i);
    }
}
