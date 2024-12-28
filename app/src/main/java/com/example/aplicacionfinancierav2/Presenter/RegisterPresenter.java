package com.example.aplicacionfinancierav2.Presenter;

import android.content.Context;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.OnUserSavedListener;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;

public class RegisterPresenter implements PresenterMain {

    private ViewMain view;
    private ModelMain model;


    public RegisterPresenter(ViewMain view, Context c) {
        this.view = view;
        this.model = new ModelImpl(c);
    }



    @Override
    public void saveUser(String name, String identification, String email, String phone, String password) {

        if(!validateFields(name,identification,email,phone,password)){

            model.insertUser(name,identification,email,phone,password);

            view.showError("Usuario registrado Exitosamente");
        }
        else {
            view.showData("Usuario registrado existosamente");
        }


    }



    public boolean validateFields(String name, String identification, String email, String phone,
                                  String password){

        if(name.isEmpty() || identification.isEmpty() || email.isEmpty() || phone.isEmpty() ||
                password.isEmpty()){

            view.showData("Debes rellenar todos los campos");
        }
        return false;
    }









    // Condicionales de los campos

    private boolean validateName(String name) {
        String verifyName = "^[a-zA-Z ]+$";
        return name.matches(verifyName) && !name.contains(" ");
    }

    private boolean validateEmail(String email) {
        String verifyEmail = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";
        return email.matches(verifyEmail) && !email.contains(" ");
    }

    private boolean validatePhone(String phone) {
        return phone.length() == 10 && phone.matches("\\d{10}") && !phone.contains(" ");
    }

    private boolean validateId(String id) {
        return id.length() >= 8 && id.length() <= 12 && id.matches("\\d{8,12}") && !id.contains(" ");
    }
}