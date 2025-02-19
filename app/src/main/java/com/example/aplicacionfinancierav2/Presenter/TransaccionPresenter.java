package com.example.aplicacionfinancierav2.Presenter;

import android.content.Context;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.Model.SharedPrefHelper;


public class TransaccionPresenter implements PresenterMain, PresenterMain.transaccion {

    private ViewMain view;
    private ModelMain model;
    private ModelImpl bdModel;
    private Context context;
    private String phoneUserIssuer;


    public TransaccionPresenter(ViewMain view, Context c) {
        this.view = view;
        this.model = new ModelImpl(c);
        this.bdModel = new ModelImpl(c);
        this.context = c;

    }

    @Override
    public void sendAmount(String phone, double amount, String description) {
        if (validateFields( phone, amount, description)) {

            phoneUserIssuer = SharedPrefHelper.getPhone(context);

            bdModel.sendAmountDb(phone, amount, description,phoneUserIssuer);

            view.showData("Envio exitoso");

        } else {

            view.showError("Error al registrar usuario");

        }
    }



    public boolean validateFields(String phone, double amount, String description) {

        boolean isPhoneValid = validatePhoneField(phone);
        boolean isAmountValid = validateAmountField(amount);
        return isPhoneValid && isAmountValid;
    }

    private boolean validateAmountField(double amount) {

        if(amount == 0){
            view.showFieldError("amount", "El monto no puede ser cero");
        }
        return true;
    }

    private boolean validatePhoneField(String phone) {
        if (phone.isEmpty()) {
            view.showFieldError("phone", "El campo no puede estar vacio.");
            return false;
        }
        if (!bdModel.getDatabaseHelper().doesUserExistByPhone(phone)) {
            view.showFieldError("phone", "No existe un usuario registrado con este numero de telefono.");
            return false;
        }

        else {
            view.showFieldError("phone", null);
            return true;
        }
    }



    @Override
    public void saveUser(String name, String identification, String email, String phone, String password,String confirmPassword) {

    }


}