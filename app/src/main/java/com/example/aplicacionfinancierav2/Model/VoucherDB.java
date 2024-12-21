package com.example.aplicacionfinancierav2.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VoucherDB extends SQLiteOpenHelper {
    public VoucherDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase dbVoucher) {

        String tablaDeComprobantes = "CREATE TABLE comprobantes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idComprobante INTEGER ," +
                "nombreDestinatario TEXT," +
                "telefonoDestinatario TEXT," +
                "telefonoRemitente TEXT," +
                "moneda TEXT," +
                "nombreRemitente TEXT," +
                "monto REAL," +
                "descripcion TEXT," +
                "fechaHora TEXT" +
                ")";
        dbVoucher.execSQL(tablaDeComprobantes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
