package com.example.aplicacionfinancierav2.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;

public class UserDB extends SQLiteOpenHelper implements ModelMain{


    public UserDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase dbUser) {

        String tablaDeUsuarios =
                "CREATE TABLE usuarios (" +
                "correo TEXT PRIMARY KEY," +
                "nombre TEXT," +
                "celular TEXT," +
                "cedula TEXT," +
                "contraseña TEXT," +
                "saldo REAL DEFAULT 3000000.0" +
                ")";
        dbUser.execSQL(tablaDeUsuarios);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public String getStrings() {
        return "";
    }

    @Override
    public void getData(OnDataLoadedCallback callback) {

    }
}
