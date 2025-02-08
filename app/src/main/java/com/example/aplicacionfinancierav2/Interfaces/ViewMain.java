package com.example.aplicacionfinancierav2.Interfaces;

public interface ViewMain {

    void showData(String data);
    void showError(String errorMessage);
    void showFieldError(String field, String error);
    void intentTo();
    void showMoney(double money);
}
