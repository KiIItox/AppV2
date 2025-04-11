package com.example.aplicacionfinancierav2.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.R;

public class Welcome extends AppCompatActivity implements ViewMain {



    PresenterMain presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Welcome.this, Login.class);
            startActivity(intent);
            finish();
        }, 1000);

    }



    @Override
    public void showData(String data) {

    }

    @Override
    public void showError(String error) {

    }
    @Override
    public void showFieldError(String field, String error) {

    }
    @Override
    public void intentTo() {

    }
    @Override
    public void showMoney(double money) {

    }

    @Override
    public void voucherData(String id, String phone, String phoneIssuer, String description, double amount) {

    }

}