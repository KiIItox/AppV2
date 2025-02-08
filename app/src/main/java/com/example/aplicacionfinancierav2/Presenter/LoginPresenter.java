package com.example.aplicacionfinancierav2.Presenter;

import static android.widget.Toast.*;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.Model.UserDB;
import com.example.aplicacionfinancierav2.View.Login;

public class LoginPresenter implements PresenterMain {

    private ViewMain view;
    private ModelMain model;

    private ModelImpl bdModel;
    public LoginPresenter(ViewMain view, Context c) {
        this.view = view;
        this.model = new ModelImpl(c);
        this.bdModel = new ModelImpl(c);
    }

    @Override
    public void saveUser(String name, String identification, String email, String phone, String password,String confirmPassword) {
    }

    public void validateLogin(String phone, String password) {
        if (!validatePhoneField(phone) || !validatePasswordField(password)) {
            return;
        }
        if (bdModel.getDatabaseHelper().userExistByPhone(phone)) {

            if (bdModel.getDatabaseHelper().isPasswordValid(password)) {

                this.view.intentTo();

            } else {
                view.showFieldError("password", "Contraseña incorrecta.");
            }

        } else {
            view.showFieldError("phone", "Usuario no encontrado.");
        }
    }

    public boolean validatePhoneField(String phone) {
        if (phone.isEmpty()) {
            view.showFieldError("phone", "Escribe un numero de telefono");
            return false;

        }
     return true;
    }
    public boolean validatePasswordField(String password) {
        if (password.isEmpty()) {
            view.showFieldError("password", "Escribe tu contraseña.");
            return false;

        }
        return true;
    }




}
