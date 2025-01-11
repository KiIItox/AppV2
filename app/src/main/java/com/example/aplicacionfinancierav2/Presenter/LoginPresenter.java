package com.example.aplicacionfinancierav2.Presenter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.Model.UserDB;
import com.example.aplicacionfinancierav2.View.Login;

public class LoginPresenter implements PresenterMain {

    private ViewMain view;
    private ModelMain model;
    private UserDB users;
    public LoginPresenter(ViewMain view, ModelMain model) {
        this.view = view;
        this.model = model;
    }
    @Override
    public void saveUser(String name, String identification, String email, String phone, String password,String confirmPassword) {
    }

    public void login(String phone, String password){

    }




}
