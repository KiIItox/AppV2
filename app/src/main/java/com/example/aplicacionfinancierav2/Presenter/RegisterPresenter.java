package com.example.aplicacionfinancierav2.Presenter;




import android.content.Context;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.Model.UserDB;
import com.example.aplicacionfinancierav2.View.Register;

import java.sql.SQLOutput;

public class RegisterPresenter implements PresenterMain {

    private ViewMain view;
    private ModelMain model;
    private ModelImpl bdModel;


    public RegisterPresenter(ViewMain view, Context c) {
        this.view = view;
        this.model = new ModelImpl(c);
        this.bdModel = new ModelImpl(c);

    }
    @Override
    public void saveUser(String name, String identification, String email, String phone,
                         String password, String confirmPassword) {

        if (validateFields(name, identification, email, phone, password, confirmPassword)) {

                bdModel.insertUser(name, identification, email, phone, password,confirmPassword);

                view.showData("Usuario registrado Exitosamente");

        } else {

            view.showError("Error al registrar usuario");

        }
    }
    public boolean validateFields(String name, String identification, String email, String phone,
                                  String password, String confirmPassword) {

        boolean isNameValid = validateNameField(name);
        boolean isIdentificationValid = validateIdentificationField(identification);
        boolean isEmailValid = validateEmailField(email);
        boolean isPhoneValid = validatePhoneField(phone);
        boolean isPasswordValid = validatePasswordField(password, confirmPassword);
        return isNameValid && isIdentificationValid && isEmailValid && isPhoneValid && isPasswordValid;

    }

    public boolean validateNameField(String name) {
        if (name.isEmpty()) {
            view.showFieldError("name", "El campo no puede estar vacio.");
            return false;

        }
        if (!validateName(name)) {
            view.showFieldError("name", "El nombre no puede contener espacios.");
            return false;
        } else {
            view.showFieldError("name", null);
            return true;
        }
    }

    public boolean validateIdentificationField(String identification) {
        if (identification.isEmpty()) {
            view.showFieldError("identification", "El campo no puede estar vacio.");
            return false;
        }
        if (!validateId(identification)) {
            view.showFieldError("identification", "Ingresa una identificacion valida.");
            return false;
        }
        if (bdModel.getDatabaseHelper().doesUserExistIdentification(identification)) {
            view.showFieldError("identification", "Ya existe un usuario registrado con este numero de cedula.");
            return false;
        }
        else {
            view.showFieldError("identification", null);
            return true;
        }
    }

    public boolean validateEmailField(String email) {
        if (email.isEmpty()) {
            view.showFieldError("email", "El campo no puede estar vacio.");
            return false;
        }
        if (!validateEmail(email)) {
            view.showFieldError("email", "Ingresa una dirección de correo electronica valida.");
            return false;
        }
        if (bdModel.getDatabaseHelper().doesUserExistByEmail(email)) {
            view.showFieldError("email", "Ya existe un usuario registrado con este correo.");
            return false;
        } else {
            view.showFieldError("email", null);
            return true;
        }

    }

    public boolean validatePhoneField(String phone) {
        if (phone.isEmpty()) {
            view.showFieldError("phone", "El campo no puede estar vacio.");
            return false;
        }
        if (!validatePhone(phone)) {
            view.showFieldError("phone", "Digita un numero telefonico valido.");
            return false;
        }
        if (bdModel.getDatabaseHelper().doesUserExistByPhone(phone)) {
            view.showFieldError("phone", "Ya existe un usuario registrado con este numero de telefono.");
            return false;
        }

        else {
            view.showFieldError("phone", null);
            return true;
        }
    }

    public boolean validatePasswordField(String password, String confirmPassword) {
        if (password.isEmpty() && confirmPassword.isEmpty()) {
            view.showFieldError("password", "El campo no puede estar vacio.");
            view.showFieldError("confirmpassword", "El campo no puede estar vacio.");
            return false;

        }

        if (password.length() < 8) {
            view.showFieldError("password", "La contraseña debe contener minimo 8 " +
                    "caracteres.");
            return false;
        }

        if (!confirmPassword.equals(password)) {
            view.showFieldError("password", "Las contraseñas no coinciden.");
            view.showFieldError("confirmpassword", "Las contraseñas no coinciden.");
            return false;
        } else {
            view.showFieldError("password", null);
            return true;
        }
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
        return id.length() == 10 && id.matches("\\d{10}") && !id.contains(" ");
    }
}