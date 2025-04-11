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

import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Presenter.VoucherPresenter;
import com.example.aplicacionfinancierav2.R;

public class Voucher extends AppCompatActivity implements ViewMain{

    TextView tvPhoneIssuer, tvPhoneReceiver, tvAmount, tvDescription, tvVoucherId;
    VoucherPresenter presenterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_voucher);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        presenterActivity = new VoucherPresenter(this,this);

        tvAmount = findViewById(R.id.amountValue);
        tvPhoneIssuer = findViewById(R.id.fromAccount);
        tvPhoneReceiver = findViewById(R.id.toAccount);
        tvDescription = findViewById(R.id.conceptValue);
        tvVoucherId = findViewById(R.id.TransaccionNumberData);

        String phoneReceiver = getIntent().getStringExtra("phoneReceiver");
        String phoneIssuer = getIntent().getStringExtra("phoneIssuer");
        String description = getIntent().getStringExtra("description");
        double amount = getIntent().getDoubleExtra("amount", 0);
        presenterActivity.dataFull(phoneReceiver, amount, description, phoneIssuer);



    }

    public void goToHome(View view){
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
        finish();
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
        tvVoucherId.setText(id);
        tvAmount.setText("$ " + amount);
        tvDescription.setText(description);
        tvPhoneIssuer.setText(phoneIssuer);
        tvPhoneReceiver.setText(phone);
    }
}