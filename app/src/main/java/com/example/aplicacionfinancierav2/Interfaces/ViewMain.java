package com.example.aplicacionfinancierav2.Interfaces;

public interface ViewMain {

    void showLoading();
    void hideLoading();
    void showData(String data);
    void showError(String errorMessage);
    void showFieldError(String field, String error);
}
