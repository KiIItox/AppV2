package com.example.aplicacionfinancierav2.Presenter;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;

public class HomePresenter implements PresenterMain {

    private ViewMain view;
    private ModelMain model;

    public HomePresenter (ViewMain view, ModelMain model){

        this.view = view;
        this.model = model;
    }
    @Override
    public void getText() {

        String mensaje = model.getStrings();

        view.showData(mensaje);

    }

    @Override
    public void onLoadData() {

    }

    @Override
    public void onDestroy() {

    }
}
