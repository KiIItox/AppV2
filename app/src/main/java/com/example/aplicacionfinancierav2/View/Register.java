package com.example.aplicacionfinancierav2.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.Presenter.RegisterPresenter;
import com.example.aplicacionfinancierav2.R;

public class Register extends AppCompatActivity implements ViewMain {

    PresenterMain presenter;
    private EditText name, id, phone, password, cPassword, email;
    private String inputName, inputPhone, inputPassword, inputConfirmPassword, inputEmail, inputId;
    private Button btnRegistro, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        presenter = new RegisterPresenter(this, this);

        name = findViewById(R.id.etUserName);
        id = findViewById(R.id.etId);
        email = findViewById(R.id.etEmail);
        phone = findViewById(R.id.etPhone);
        password = findViewById(R.id.etPassword);
        cPassword = findViewById(R.id.etConfirmPassword);

    }

    public void RegisterUsers (View view){
        inputName = name.getText().toString();
        inputId = id.getText().toString();
        inputEmail = email.getText().toString();
        inputPhone = phone.getText().toString();
        inputPassword = password.getText().toString();
        inputConfirmPassword = cPassword.getText().toString();
        presenter.saveUser(inputName,inputId,inputEmail,inputPhone,inputPassword);

    }
    public void back(View view){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData(String data) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }
}