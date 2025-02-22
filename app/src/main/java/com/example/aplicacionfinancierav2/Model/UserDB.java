package com.example.aplicacionfinancierav2.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;

import java.sql.SQLOutput;

public class UserDB extends SQLiteOpenHelper implements ModelMain,ModelMain.transacion {

    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_IDENTIFICATION = "identification";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_SALDO = "saldo";


    public UserDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase dbUser) {

        String createTable =
                "CREATE TABLE " + TABLE_NAME + " ("+
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_IDENTIFICATION + " TEXT, " +
                        COLUMN_EMAIL + " TEXT, " +
                        COLUMN_PHONE + " TEXT, " +
                        COLUMN_PASSWORD + " TEXT, " +
                        COLUMN_SALDO + " REAL DEFAULT 3000000"
                        +" )";
        dbUser.execSQL(createTable);

    }
    public UserDB(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    //                                  CRUD                           //

    //   CREATE   //

    @Override
    public void insertUser(String name, String identification, String email, String phone,
                           String password, String confirmPassword) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_IDENTIFICATION, identification);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_PASSWORD, password);
        db.insert(TABLE_NAME, null ,values);
    }

    @Override
    public void insertVoucher(String nameReceiver, String nameEmiter, String phoneReceiber,
                              String phoneEmiter, String coin, int amount, String description, String date) {

    }
    @Override
    public void sendAmountDb(String phone, double amount, String description, String phoneUserIssuer) {
        this.transaction(phone,amount,phoneUserIssuer);
    }


    public boolean transaction(String phone, double amount, String phoneIssuer){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        double originAmount = getAmountByPhoneUser(phoneIssuer);
        System.out.println(originAmount);
        if (originAmount < amount) {
            System.out.println("El monto a enviar no puede superar tu saldo");
            db.endTransaction();
            return false;
        } else {
            try {
                String querySubstrac = "UPDATE " + TABLE_NAME +
                        " SET " + COLUMN_SALDO + " = " + COLUMN_SALDO + " - ? " +
                        " WHERE " + COLUMN_PHONE + " = ?";
                db.execSQL(querySubstrac, new Object[]{amount, phoneIssuer});

                String queryAdd = "UPDATE " + TABLE_NAME +
                        " SET " + COLUMN_SALDO + " = " + COLUMN_SALDO + " + ? " +
                        " WHERE " + COLUMN_PHONE + " = ?";
                db.execSQL(queryAdd, new Object[]{amount, phone});

                db.setTransactionSuccessful();
            } catch (Exception e) {
                System.out.println("Error en la transacción: " + e.getMessage());
                return false;
            } finally {
                db.endTransaction();
                db.close();
            }
        }
        return true;
    }

    @Override
    public double getMoney(String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        double amount = 0.0;
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_SALDO + " FROM " + TABLE_NAME + " WHERE "
                + COLUMN_PHONE + " = ?", new String[]{phone});

        if (cursor != null && cursor.moveToFirst()) {
            amount = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_SALDO));
            cursor.close();
        }
        return amount;
    }

    @Override
    public void updateMoney(String phone, double newMoney) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SALDO, newMoney);
        db.update(TABLE_NAME, values, COLUMN_PHONE + " = ?", new String[]{phone});
    }



    public Cursor getAllUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                COLUMN_ID + " ASC"
        );
    }
    //Obtener Monto por numero de telefono

    public double getAmountByPhoneUser(String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = buildValueQuery(COLUMN_SALDO);
        Cursor cursor = db.rawQuery(query, new String[]{phone});
        double amount = 0.0;

        if (cursor.moveToFirst()) {
            amount = cursor.getDouble(0);
            System.out.println(amount);
        }
        cursor.close();
        return amount;
    }



    //Verificar que el usuario ya existe.

    public boolean doesUserExistByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = buildExistenceQuery(COLUMN_EMAIL);
        Cursor cursor = db.rawQuery(query, new String[]{email});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }
    public boolean doesUserExistIdentification(String identification) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = buildExistenceQuery(COLUMN_IDENTIFICATION);
        Cursor cursor = db.rawQuery(query, new String[]{identification});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }
    public boolean doesUserExistByPhone(String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = buildExistenceQuery(COLUMN_PHONE);
        Cursor cursor = db.rawQuery(query, new String[]{phone});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }

    // verificar si existe el usuario

    public boolean userExistByPhone (String phone){
        String query = buildExistenceQuery(COLUMN_PHONE);
        return  checkRecordExists(query,new String[]{phone});
    }

    public boolean isPasswordValid (String password){
        String query = buildExistenceQuery(COLUMN_PASSWORD);
        return  checkRecordExists(query,new String[]{password});
    }


    //Realizar consultas SQL
    private String buildExistenceQuery(String columnName) {
        return "SELECT 1 FROM " + TABLE_NAME + " WHERE " + columnName + " = ?";
    }

    //Consulta por telefono
    private String buildValueQuery(String columnName) {
        return "SELECT " + columnName + " FROM " + TABLE_NAME + " WHERE " + COLUMN_PHONE + " = ?";
    }

    //Ejecutar consulta para verificar si hay resultados en las cosultas

    private boolean checkRecordExists(String query, String[] selectionArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        Boolean exists = false;
        try {
            cursor = db.rawQuery(query, selectionArgs);
            exists = cursor.moveToFirst();
        } finally {
            if (cursor != null) {
                cursor.close(); // Libera recursos
            }
        }
        return exists;
    }



}
