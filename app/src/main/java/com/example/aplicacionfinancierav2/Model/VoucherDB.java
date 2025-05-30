package com.example.aplicacionfinancierav2.Model;

import static android.provider.BlockedNumberContract.BlockedNumbers.COLUMN_ID;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;

public class VoucherDB extends SQLiteOpenHelper implements ModelMain {
    private static final String DATABASE_NAME = "voucher.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_VOUCHERS = "vouchers";
    public static final String COLUMN_PHONE_RECEIVER = "phoneReceiver";
    public static final String COLUMN_PHONE_EMITTER = "phoneEmiter";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";

    public VoucherDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public VoucherDB(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbVoucher) {

        String createVoucherTable =
                "CREATE TABLE " + TABLE_VOUCHERS + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_PHONE_RECEIVER + " TEXT, " +
                        COLUMN_PHONE_EMITTER + " TEXT, " +
                        COLUMN_AMOUNT + " INTEGER, " +
                        COLUMN_DESCRIPTION + " TEXT, " +
                        COLUMN_DATE + " TEXT )";
        dbVoucher.execSQL(createVoucherTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getVoucherById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_VOUCHERS + " WHERE " + COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    @Override
    public int insertVoucher(Voucher voucher) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PHONE_RECEIVER, voucher.getPhoneReceiber());
        values.put(COLUMN_PHONE_EMITTER, voucher.getPhoneEmiter());
        values.put(COLUMN_AMOUNT, voucher.getAmount());
        values.put(COLUMN_DESCRIPTION, voucher.getDescription());
        values.put(COLUMN_DATE, voucher.getDate());
        int id = (int) db.insert(TABLE_VOUCHERS, null ,values);
        db.close();
        return id;

    }


    @Override
    public double getMoney(String phone) {
        return 0;
    }

    @Override
    public void updateMoney(String phone, double newMoney) {

    }

    @Override
    public void insertUser(String name, String identification, String email, String phone, String password, String confirmPassword) {

    }


}
