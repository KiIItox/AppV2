package com.example.aplicacionfinancierav2.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Presenter.LoginPresenter;
import com.example.aplicacionfinancierav2.R;

public class Login extends AppCompatActivity implements ViewMain {

    LoginPresenter presenter;

    private EditText etPhone, etPassword;
    private String inputName, inputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        presenter = new LoginPresenter(this, this);
        // ID de interacciones
        etPhone = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
    }


    public void login (View view){
        inputName = etPhone.getText().toString();
        inputPassword = etPassword.getText().toString();
        presenter.validateLogin(inputName,inputPassword);
    }

    public void register(View view){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void intentTo() {
        String phone = etPhone.getText().toString();
        Intent intent = new Intent(this,Home.class);
        intent.putExtra("phone",phone);
        startActivity(intent);
        finish();

    }

    @Override
    public void showMoney(double money) {

    }

    @Override
    public void voucherData(String id, String phone, String phoneIssuer, String description, double amount) {

    }

    @Override
    public void showData(String data) {

    }

    @Override
    public void showError(String error) {

    }
    @Override
    public void showFieldError(String field, String error) {
        switch (field){
            case "phone":
                etPhone.setError(error);
                break;
            case "password":
                etPassword.setError(error);
                break;
        }
    }
}