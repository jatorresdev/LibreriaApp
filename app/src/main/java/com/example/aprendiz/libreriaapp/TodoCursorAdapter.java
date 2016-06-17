package com.example.aprendiz.libreriaapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by APRENDIZ on 03/06/2016.
 */
public class TodoCursorAdapter extends CursorAdapter {
    TextView id, nombre, autor, editorial, tipoLiteratura;
    int vid;
    String vnombre, vautor, veditorial, vtipoLiteratura;

    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_listar_libros, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        id = (TextView) view.findViewById(R.id.etId);
        nombre = (TextView) view.findViewById(R.id.etNombre);
        autor = (TextView) view.findViewById(R.id.etAutor);
        editorial = (TextView) view.findViewById(R.id.etEditorial);
        //tipoLiteratura = (TextView)  view.findViewById(R.id.etTipoLiteratura);

        vid = cursor.getInt(cursor.getColumnIndex("_id"));
        vnombre = cursor.getString(cursor.getColumnIndex("nombre"));
        vautor = cursor.getString(cursor.getColumnIndex("autor"));
        veditorial = cursor.getString(cursor.getColumnIndex("editorial"));
        //vtipoLiteratura = cursor.getString(cursor.getColumnIndex("tipo_literatura"));

        id.setText(String.valueOf(vid));
        nombre.setText(vnombre);
        autor.setText(vautor);
        editorial.setText(String.valueOf(vautor));
        //tipoLiteratura.setText(String.valueOf(vtipoLiteratura));
    }
}
