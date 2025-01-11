package com.example.aplicacionfinancierav2.View;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.Presenter.HomePresenter;
import com.example.aplicacionfinancierav2.Presenter.WelcomePresenter;
import com.example.aplicacionfinancierav2.R;

public class Home extends AppCompatActivity implements ViewMain {

    PresenterMain presenter;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //presenter = new HomePresenter(this, new ModelImpl());
        // presenter.onLoadData();

        tv1 = findViewById(R.id.tvSaldo);
    }

    public void traerDelTextoDelModelo(View view){

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData(String data) {
        tv1.setText(data);

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showFieldError(String field, String error) {

    }
}