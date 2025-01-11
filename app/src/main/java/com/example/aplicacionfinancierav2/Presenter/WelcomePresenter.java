package com.example.aplicacionfinancierav2.Presenter;

import android.view.View;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;

public class WelcomePresenter implements PresenterMain {

    private ViewMain view;
    private ModelMain model;

    public WelcomePresenter (ViewMain view, ModelMain model){

        this.view = view;
        this.model = model;
    }
    @Override
    public void saveUser(String name, String identification, String email, String phone, String password,String confirmPassword) {

    }
}