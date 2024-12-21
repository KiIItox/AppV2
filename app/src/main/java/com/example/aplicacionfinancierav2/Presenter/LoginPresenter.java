package com.example.aplicacionfinancierav2.Presenter;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.View.Login;

public class LoginPresenter implements PresenterMain {

    private ViewMain view;
    private ModelMain model;

    public LoginPresenter(ViewMain view, ModelMain model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getText() {

    }

    @Override
    public void onLoadData() {

    }

    @Override
    public void onDestroy() {

    }
}
