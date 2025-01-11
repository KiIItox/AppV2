package com.example.aplicacionfinancierav2.Model;

import android.content.Context;
import android.view.View;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.OnUserSavedListener;

public class ModelImpl implements ModelMain {

    private UserDB databaseHelper;

    public ModelImpl(Context c){

        this.databaseHelper = new UserDB(c);
    }

    public UserDB getDatabaseHelper() {
        return databaseHelper;
    }

    @Override
    public void insertUser(String name, String identification, String email, String phone,
                           String password, String confirmPassword) {

    }
}
