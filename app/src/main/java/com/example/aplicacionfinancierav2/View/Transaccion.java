package com.example.aplicacionfinancierav2.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Presenter.TransaccionPresenter;
import com.example.aplicacionfinancierav2.R;

public class Transaccion extends AppCompatActivity implements ViewMain {

    private EditText etPhoneReceiver, etAmount, etDescription;
    private TransaccionPresenter presenterActivity;
    private String phoneReceiver, amount, description;
    private double amountDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_transaccion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        presenterActivity = new TransaccionPresenter(this,this);

        etPhoneReceiver = findViewById(R.id.etPhoneReceiver);
        etAmount = findViewById(R.id.etAmount);
        etDescription = findViewById(R.id.etDescription);

    }

    public void sendAmount(View view){
        phoneReceiver = etPhoneReceiver.getText().toString();
        amount = etAmount.getText().toString();
        amountDouble = Double.parseDouble(amount);
        description = etDescription.getText().toString();
        presenterActivity.sendAmount(phoneReceiver,amountDouble,description);

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
                etPhoneReceiver.setError(error);
                break;
            case "amount":
                etAmount.setError(error);
                break;
        }

    }
    @Override
    public void intentTo() {
        Intent intent = new Intent(this, Voucher.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void showMoney(double money) {

    }

    @Override
    public void voucherData(String id, String phone, String phoneIssuer, String description, double amount) {

    }


}