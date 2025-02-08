package com.example.aplicacionfinancierav2.View;

import android.content.Intent;
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
import com.example.aplicacionfinancierav2.Model.SharedPrefHelper;
import com.example.aplicacionfinancierav2.Presenter.HomePresenter;
import com.example.aplicacionfinancierav2.Presenter.LoginPresenter;
import com.example.aplicacionfinancierav2.Presenter.WelcomePresenter;
import com.example.aplicacionfinancierav2.R;

public class Home extends AppCompatActivity implements ViewMain {

    HomePresenter presenter;
    private TextView tv1;
    String phone, userPhone;

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

        tv1 = findViewById(R.id.tvSaldo);
        presenter = new HomePresenter(this, this);
        userPhone = getIntent().getStringExtra("phone");
        if(userPhone!=null){
            presenter.saveUserPhone(userPhone);
        }
        phone = SharedPrefHelper.getPhone(this);
        presenter.loadMoney(phone);
    }

    public void sendMoneyView(View view){
        Intent intent = new Intent(this,Transaccion.class);
        startActivity(intent);
        finish();
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

    @Override
    public void intentTo() {

    }

    @Override
    public void showMoney(double money) {
        tv1.setText("Saldo disponible: $" + money);
    }
}