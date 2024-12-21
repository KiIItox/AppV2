package com.example.aplicacionfinancierav2.Model;

import android.view.View;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;

public class ModelImpl implements ModelMain {




    @Override
    public String getStrings() {
        String dataString = "Hellow World";
        return dataString;
    }

    @Override
    public void getData(OnDataLoadedCallback callback) {

    }
}
