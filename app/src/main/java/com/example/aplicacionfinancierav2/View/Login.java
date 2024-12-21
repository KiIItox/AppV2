package com.example.aplicacionfinancierav2.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.Presenter.LoginPresenter;
import com.example.aplicacionfinancierav2.R;

public class Login extends AppCompatActivity implements ViewMain {

    LoginPresenter presenter;

    private EditText etUsuario, etPassword;
    private Button btnIniciar, btnRegistro;

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
        presenter = new LoginPresenter(this, new ModelImpl());
        presenter.onLoadData();


        // ID de interacciones

        etUsuario = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);

        btnIniciar = findViewById(R.id.btnLogin);
        btnRegistro = findViewById(R.id.btnRegisterLogin);


    }

    public void registro(View view){
        Intent intent = new Intent(Login.this, Register.class);
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

    }

    @Override
    public void showError(String error) {

    }
}