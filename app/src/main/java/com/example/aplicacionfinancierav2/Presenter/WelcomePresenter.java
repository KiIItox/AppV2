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
    public void getText() {

    }

    @Override
    public void onLoadData() {
        view.showLoading();
        model.getData(new ModelMain.OnDataLoadedCallback() {

            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFailure(String error) {
                view.hideLoading();
                view.showError("No se pudo rey");
            }
        });

    }

    @Override
    public void onDestroy() {

        view = null;

    }
}