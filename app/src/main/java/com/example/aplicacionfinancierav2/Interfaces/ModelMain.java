package com.example.aplicacionfinancierav2.Interfaces;

public interface ModelMain {


    interface OnDataLoadedCallback {
        void onSuccess(String data);
        void onFailure(String error);
    }
    String getStrings();
    void getData(OnDataLoadedCallback callback);


}
