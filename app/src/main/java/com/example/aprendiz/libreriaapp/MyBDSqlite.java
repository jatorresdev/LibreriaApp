package com.example.aprendiz.libreriaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by APRENDIZ on 02/06/2016.
 */
public class MyBDSqlite extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "libreria.db";
    private static final String DATABASE_TABLE = "libreria";
    private static final String COLUMNA_ID = "_id";
    private static final String COLUMNA_NOMBRE = "nombre";
    private static final String COLUMNA_AUTOR = "autor";
    private static final String COLUMNA_EDITORIAL = "editorial";
    private static final String COLUMNA_TIPO_LITERATURA = "tipo_literatura";

    public MyBDSqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DATABASE_TABLE +
                " (" + COLUMNA_ID + " INTEGER PRIMARY KEY, " +
                COLUMNA_NOMBRE + " TEXT, " +
                COLUMNA_AUTOR + " TEXT, " +
                COLUMNA_EDITORIAL + " INTEGER, " +
                COLUMNA_TIPO_LITERATURA + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXIST " + DATABASE_TABLE;
        db.execSQL(query);
        onCreate(db);
    }

    public void agregarLibro(Libreria libreria) {
        ContentValues values = new ContentValues();
        values.put(COLUMNA_ID, libreria.getId());
        values.put(COLUMNA_NOMBRE, libreria.getNombre());
        values.put(COLUMNA_AUTOR, libreria.getAutor());
        values.put(COLUMNA_EDITORIAL, libreria.getEditorial());
        values.put(COLUMNA_TIPO_LITERATURA, libreria.getTipoLiteratura());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(DATABASE_TABLE, null, values);
        db.close();
    }

    public Cursor buscarLibros() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + DATABASE_TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c == null) {
            return null;
        } else {
            return c;
        }
    }

    public Cursor buscarLibro(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + DATABASE_TABLE + " WHERE " + COLUMNA_ID + " = " + id + ";";
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

    public void actualizarLibro(Libreria libreria) {
        ContentValues values = new ContentValues();
        values.put(COLUMNA_ID, libreria.getId());
        values.put(COLUMNA_NOMBRE, libreria.getNombre());
        values.put(COLUMNA_AUTOR, libreria.getAutor());
        values.put(COLUMNA_EDITORIAL, libreria.getEditorial());
        values.put(COLUMNA_TIPO_LITERATURA, libreria.getTipoLiteratura());

        SQLiteDatabase bd = getWritableDatabase();
        bd.update(DATABASE_TABLE, values, COLUMNA_ID + " = ?", new String[]{String.valueOf(libreria.getId())});
        bd.close();
    }

    public void eliminarLibro(Libreria libreria) {
        SQLiteDatabase bd = getWritableDatabase();
        bd.delete(DATABASE_TABLE, COLUMNA_ID + " = ?", new String[]{String.valueOf(libreria.getId())});
        bd.close();
    }
}
