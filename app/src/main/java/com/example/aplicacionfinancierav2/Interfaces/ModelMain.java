package com.example.aplicacionfinancierav2.Interfaces;

public interface ModelMain {
    void insertUser (String name, String identification, String email, String phone, String password, String confirmPassword);
    void insertVoucher(String nameReceiver, String nameEmiter, String phoneReceiber, String phoneEmiter, String coin, int amount, String description, String date);
    double getMoney(String phone);
    void updateMoney(String phone, double newMoney);
}
