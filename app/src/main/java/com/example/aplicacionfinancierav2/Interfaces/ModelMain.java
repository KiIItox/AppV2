package com.example.aplicacionfinancierav2.Interfaces;

import com.example.aplicacionfinancierav2.Model.Voucher;

public interface ModelMain {
    void insertUser (String name, String identification, String email, String phone, String password, String confirmPassword);
    int insertVoucher(Voucher voucher);
    double getMoney(String phone);
    void updateMoney(String phone, double newMoney);

    interface transacion{
        void sendAmountDb(String phone, double amount, String description, String phoneUserIssuer);
    }
}
