package com.example.aplicacionfinancierav2.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;

public class UserDB extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_IDENTIFICATION = "identification";
    private static final String COLUMN_PASSWORD = "password";


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
                        COLUMN_PASSWORD + " TEXT )";
                        ;
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

    public long insertUser (String name, String email, String identification, String phone, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_IDENTIFICATION, identification);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_PASSWORD, password);
        return db.insert(TABLE_NAME, null ,values);
    }

    //READ (All Users)//

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

    //READ (by ID) //

    public Cursor getUserById(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(
                TABLE_NAME,
                null,
                COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );
    }

    // UPDATE //

    public int upDateUser (long id, String name, String email, String identification, String phone, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_IDENTIFICATION, identification);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_PASSWORD, password);
        return db.update(TABLE_NAME,values,COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
    }

    // DELETE //



    public int deleteUser (long id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}

        );
    }
}
