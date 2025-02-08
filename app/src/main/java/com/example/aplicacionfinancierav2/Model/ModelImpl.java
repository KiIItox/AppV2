package com.example.aplicacionfinancierav2.Model;

import android.content.Context;
import android.view.View;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;


public class ModelImpl implements ModelMain {

    private UserDB databaseHelper;
    private VoucherDB databaseHelperVoucher;

    public ModelImpl(Context c) {
        this.databaseHelper = new UserDB(c);
        this.databaseHelperVoucher = new VoucherDB(c);
    }

    public UserDB getDatabaseHelper() {
        return databaseHelper;
    }

    public VoucherDB getDatabaseHelperVoucher() {
        return databaseHelperVoucher;
    }

    @Override
    public void insertUser(String name, String identification, String email, String phone,
                           String password, String confirmPassword) {
        databaseHelper.insertUser(name, identification, email, phone, password, confirmPassword);
    }

    @Override
    public void insertVoucher(String nameReceiver, String nameEmiter, String phoneReceiber, String phoneEmiter, String coin, int amount, String description, String date) {

    }

    @Override
    public double getMoney(String phone) {
        return databaseHelper.getMoney(phone);
    }

    @Override
    public void updateMoney(String phone, double newMoney) {
        databaseHelper.updateMoney(phone, newMoney);
    }
}
